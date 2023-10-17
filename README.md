# appium-cucumber-testng-poc 


_**For installation instructions go to documents folder in the project directory**_

_**Download the latest version of following software**_

1.Download Java 1.8 or above for Mac and windows

2.Download Node.js latest version for Mac and windows

3.Download Appium latest version for Mac and windows(make sure it is installed globally)

4.Download intellij latest version for Mac and windows

For Android

   1. Download Android Studio latest version for Mac and windows

For IOS

   1. Download Xcode latest version for Mac
   
For Generating Allure Reporting through terminal/command_prompt

  1. Download Allure reports from scoop for Windows and from brew for Mac Refer this url  https://docs.qameta.io/allure/
  2. Use this command to run see allure report
        
         allure serve target/allure-results 

Allure Report will automatically download and launch reports if you run any of the script file

  1. Use runner.bat(windows) or runner.sh(mac) it will automatically launch the reports in the browser
  
For Parallel Execution

  1. Specify these three (device.names, device.versions, device.ports) properties in common.properties file in order to run tests parallel.
  2. Also, you need to specify the test and thread-count in regressiontest.xml file with respect to devices. If you want to run tests on two different devices than define two tests and two thread-count in xml file.

    <suite name="Regression Runner" parallel="tests" thread-count="1">
    <test preserve-order="true" name="Unique test name">
        <classes>
            <class name="com.trackNinja.runner.TestRunner"/>
        </classes>
    </test>