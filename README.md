# EmployeeSkillsApplication

SpringBoot integration point between the database and university systems.

 Currently initialized:
    RestController
    JPARepository connecting to the database
    
Future initializations:
    JPARepositories to connect further entities to the database.
    
Initialized using intellij's spring boot initializer.

For further reference, please consider the following sections:
* https://www.javadevjournal.com/spring-boot/spring-boot-application-intellij/
* https://start.spring.io/
* RestController information is abundant throughout the web. 
There are many annotations as well as well written documentation if you are
curious about more functionality.
 * [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/) -
 this can be used as a good reference to understanding how things work.
 It is best to clone this repository if interested in creating a similar application.
 
 Other Notes
 * The application.properties file is powerful,
 spring uses it to specify anything from the application
 name to the password used to enter a database.
 Values that should be in this file include
   * spring.application.name=name
     * name of the application
   * spring.datasource.platform=platform (ex mysql)
     * database spring will attempt to connect to
   * spring.datasource.username=username
     * credentials used for database access
   * spring.datasource.password=password
     * credentials used for database access
   * spring.datasource.driver-class-name=driver (ex com.mysql.cj.jdbc.Driver)
   *  optional parameters used for debugging
      * logging.level.org.hibernate.SQL=debug
      * spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
 * The application-local.properties, application-prod.properties, application-test.properties files are also powerful,
 spring uses this for spring port configuration and database connections.
   * server.port=port
     * port to deploy the application to
   * spring.datasource.url=datasourceUrl
     * database to connect to
       * this can also have different configurations
         * ?characterEncoding=latin1&useConfigs=maxPerformance&verifyServerCertificate=false&useSSL=false&requireSSL=false
 * Basic configurations need to be setup for the application to look at the application-local.properties file
   * SPRING_PROFILES_ACTIVE needs to be placed as an environment property and specifies which properties file to view.
   Edit Configurations -> Expand Environment in the Configuration tab -> 
   click the folder icon next to Environment Variables.
   put local as the value. 
 
