# Truncate Log
It's Sample SpringBoot application using Java 8 and SpringMVC for truncating log method testing ... Cheers!


------------------------------
To compile and run the Project
------------------------------

Followings are needed.

-> Java version 8 or greater (http://openjdk.java.net/install/  or http://www.oracle.com/technetwork/java/javase/downloads/index.html)

-> Gradle 3 or greater (https://gradle.org/install/)

-> Internet Connection on the Build Computer as other libraries will be downloaded from Maven repo


---------------------------------------------------
Build commands (expecting gradle is in the path)
---------------------------------------------------
gradle clean build


---------------------------------------------------
Run Application (expecting gradle is in the path)
---------------------------------------------------
gradle run

or

java -jar build/libs/log-truncater-0.1.0.jar


By default the Embedded Tomcat will run on Local Port : 8080
Port and other configurations can be changed in "application.yml"

----------------------------------------------------
After running   
----------------------------------------------------

Please hit following URL using any browser.

http://localhost:8080/   (automatically redirection will occur else please click the link.)

or

http://localhost:8080/subscribe

in the log folder/directory please look for the "application.log" for log truncate testing 

------------------------------------
Testing and Development Environments
------------------------------------

OpenSUSE Leap 42.2  (Linux Kernel 4.4.62-18.6-default)

JRE & JDK = OpenJDK 1.8.0_121 (64 bit Server VM)

Gradle Version = 3.4.1

SptingBoot Version = 1.5.2.RELEASE

SpringFramework Version = v4.3.7.RELEASE

Embedded Tomcat Version = 8.5.11
