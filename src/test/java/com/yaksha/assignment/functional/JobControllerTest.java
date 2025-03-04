package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.yaksha.assignment.utils.CustomParser;

public class JobControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testClassAnnotationsPresentInAppConfig() throws IOException {
		String filePath = "src/main/java/com/yaksha/assignment/config/AppConfig.java";

		boolean hasConfigurationAnnotation = CustomParser.checkClassAnnotation(filePath, "Configuration");
		boolean hasEnableWebMvcAnnotation = CustomParser.checkClassAnnotation(filePath, "EnableWebMvc");
		boolean hasComponentScanAnnotation = CustomParser.checkClassAnnotation(filePath, "ComponentScan");

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(),
				hasConfigurationAnnotation && hasEnableWebMvcAnnotation && hasComponentScanAnnotation,
				businessTestFile);
	}

	@Test
	public void testClassAnnotationsPresentInJobController() throws IOException {
		String filePath = "src/main/java/com/yaksha/assignment/controller/JobController.java";

		boolean hasRestControllerAnnotation = CustomParser.checkClassAnnotation(filePath, "Controller");

		yakshaAssert(currentTest(), hasRestControllerAnnotation, businessTestFile);
	}

	@Test
	public void testJobControllerGetMappings() throws NoSuchMethodException, IOException {
		String filePath = "src/main/webapp/WEB-INF/views/jobs.jsp"; // Just to align with previous test patterns

		boolean isGetAllJobsValid = CustomParser.checkMethodAnnotation("getAllJobs",
				new Class<?>[] { org.springframework.ui.Model.class }, "/jobs");

		boolean isGetJobByIdValid = CustomParser.checkMethodAnnotation("getJobById",
				new Class<?>[] { int.class, org.springframework.ui.Model.class }, "/jobs/{id}");

		boolean isSearchJobsValid = CustomParser.checkMethodAnnotation("searchJobs",
				new Class<?>[] { String.class, org.springframework.ui.Model.class }, "/jobs/search");

		// Auto-grading assertions
		yakshaAssert(currentTest(), isGetAllJobsValid && isGetJobByIdValid && isSearchJobsValid, businessTestFile);
	}

	@Test
	public void testGetMappingValue() throws IOException {
		String filePath = "src/main/java/com/yaksha/assignment/controller/JobController.java";

		boolean hasGetMapping = CustomParser.checkMethodAnnotationWithValue(filePath, "GetMapping", "/jobs");
		yakshaAssert(currentTest(), hasGetMapping, businessTestFile);
	}

	@Test
	public void testJspTagsAndHtmlTagClosureInJobsJsp() throws IOException {
		String filePath = "src/main/webapp/WEB-INF/views/jobs.jsp";

		// Check for the presence of <c:forEach> (JSP tag check)
		boolean hasForEachTag = CustomParser.checkJspTagPresence(filePath, "<c:forEach");

		// Check for proper closure of HTML tags
		boolean isTableClosed = CustomParser.isTagProperlyClosedInFile(filePath, "table");
		if (!isTableClosed) {
			System.out.println("table tag not present");
		}

		boolean hasH2Tag = CustomParser.isTagProperlyClosedInFile(filePath, "h2");
		if (!hasH2Tag) {
			System.out.println("h2 tag not present");
		}

		boolean hasTrTag = CustomParser.isTagProperlyClosedInFile(filePath, "tr");
		if (!hasTrTag) {
			System.out.println("tr tag not present");
		}

		boolean hasTdTag = CustomParser.isTagProperlyClosedInFile(filePath, "td");
		if (!hasTdTag) {
			System.out.println("td tag not present");
		}

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), isTableClosed && hasH2Tag && hasTrTag && hasForEachTag, businessTestFile);
	}
}
