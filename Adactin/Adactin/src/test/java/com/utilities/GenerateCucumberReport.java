package com.utilities;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateCucumberReport {
	
	static public String reportOutputDirectory;
    public static void generateCucumberReport() {
    	reportOutputDirectory = "src\\test\\java\\com\\Report\\cucumber-reports.html"; // Output directory for the HTML report
        File jsonFile = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\Report\\cucumber.json"); // Path to your Cucumber JSON file

        List<String> jsonFiles = new ArrayList();
        jsonFiles.add(jsonFile.getAbsolutePath());
        
        Configuration configuration = new Configuration(new File(reportOutputDirectory), "Adactin Project");
        configuration.setBuildNumber("1.0");
        configuration.addClassifications("Platform", "Desktop");
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("OperatingSystem", "Windows");
        
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}

