usana-hrapp
===========

Welcome to the Usana HR App developed by Rob Johansen. This app was developed for the sole purpose of hitting a home run (or at least a ground rule double) for those at Usana who interviewed me Friday, or who will interview me at lunch on Monday. :)

This app is currently running in all its glory on my server at: http://www.e-strux.com/

If you would like to build and deploy this app yourself, follow these instructions:

1. Clone this repository: git clone https://github.com/stenrap/usana-hrapp.git
2. Execute this command in the root directory of the project: mvn package
3. Locate the file named "usana.war" in the "target" directory and copy it to your $CATALINA_HOME/webapps directory.
4. Start tomcat if it's not already running.
5. Tomcat should unpackage the "usana.war" file into a "usana" directory.
6. Set the following properties in the WEB-INF/classes/hibernate.properties:
   - hibernate.connection.driver_class=[your-driver]
   - hibernate.connection.url=[your-url]
   - hibernate.connection.username=[your-username]
   - hibernate.connection.password=[your-password]
   - hibernate.dialect=[your-dialect]
7. Restart tomcat and you can access the app by going to http://your.domain/usana

Development Notes:
- This app was developed using JDK version 1.7.0_67
- Tomcat 7.0.50 was used in development, and is installed at http://www.e-strux.com/
- This app has been tested against the latest versions of the following browsers:
  + Chrome for Mac/Win
  + Chrome for Android on HTC One
  + Firefox for Mac/Win
  + Internet Exploder 11
  + Safari for Mac
  + Safari for iPhone 5s
  + Safari for iPad 2
- There are no unit/integration tests because I'm tired and it's after 3:00 am
- I estimated during my interview that I could develop this app in 0000 0110 hours
- My actual development time was 0000 1100 hours (thank you, Hibernate, for shifting my bits left)
- In case you were wondering, I bought the domain e-strux.com because I have an idea for a mobile app that will provide electronic instructions
