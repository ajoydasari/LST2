cmd
cd C:\Selenium\IntelliJ_Projects\LST2
xcopy /s C:\Selenium\IntelliJ_Projects\LST2\target C:\Selenium\IntelliJ_Projects\LST2\
mvn clean verify -DsuiteXmlFile=TestSuites\Full_Regression.xml


