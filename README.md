usana-hrapp
===========

Welcome to the Usana HR App developed by Rob Johansen. This app was developed for the sole purpose of hitting a home run (or at least a ground rule double) for those at Usana who interviewed me Friday, or who will interview me at lunch on Monday. :)

This app is currently running in all its glory on my server at: http://www.e-strux.com/

If you would like to build and deploy this app, follow these instructions:

1. Create an "employee" table in your database. Here's the SQL I used to create mine (in MySQL) after creating a database named "usana":
```SQL
    CREATE TABLE `usana`.`employee` (
      `id` INT NOT NULL AUTO_INCREMENT,
      `firstName` VARCHAR(100) NOT NULL,
      `lastName` VARCHAR(100) NOT NULL,
      `address1` VARCHAR(100) NOT NULL,
      `address2` VARCHAR(100) NULL,
      `city` VARCHAR(100) NOT NULL,
      `state` VARCHAR(2) NOT NULL,
      `zip` VARCHAR(20) NOT NULL,
      `phone` VARCHAR(20) NOT NULL,
      `startDate` DATE NOT NULL,
      PRIMARY KEY (`id`),
      INDEX `firstNameIndex` (`firstName` ASC),
      INDEX `lastNameIndex` (`lastName` ASC),
      INDEX `startDateIndex` (`startDate` ASC));
```

2. Clone this repository:

    git clone https://github.com/stenrap/usana-hrapp.git

3. Execute this command in the root directory of the project:

    mvn package

4. Locate the "usana.war" file in the "target" directory of the project and copy it to your "$CATALINA_HOME/webapps" directory.

5. Start tomcat so it unpackages the "usana.war" file into a "usana" directory.

6. Set the following properties in the "usana/WEB-INF/classes/hibernate.properties" file:
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
