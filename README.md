# paramitaSTestNG
•	Project url:  https://www.aspiringtester.com/contact.php (this is mentioned in properties file)
•	Test data: Test data are maintained in excel file. To read the data from excel Apache POI API is used and then using TestNG DataProvider annotation all data are passed to the script.
•	Global properties: Global variables are created and maintained in properties file named here "global.properties".Using FileInputStream and property object They are passed to the script.
•	Test data in excel file and global properties in properties file are in a separate folder src/main/java/resource (in this project).
•	Reports:ExtentReporting has been used and configured in the utility to generate html report and attach screenshot on failure if any using TestNg Listener.
•	Log: In addition to logging in reports, separate logging mechanism using Log4j2 has been configured using rolling file. In this framework testing results will be logged in " Log/print.log".
•	Utilities: In utilities I have created  "BaseTest.java", "ExcelReading.java","ExtentReporting.java","Listeners.java" . I have designed/coded these classes as reusable. They are used in this project and can be used in other projects too.
•	TestNG framework: Using TastNG framework test scripts are generated.
•	Page Object model has been followed for scripting.
•	Maven build management tool has been used. Using maven , project dependencies are maintained. Test is running on maven as well.(It can be run using TestNG in eclipse too)
•	Jenkin is used to run this automated test cases.


