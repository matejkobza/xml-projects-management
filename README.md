# XML based project management application

Requirements:
- Java 7
- JSF or Spring MVC
- Tomcat 7 or GlassFish
- datastore in xml file
- Firefox, MSIE or Opera
- 3 layers architecture
- User Friendly design not required
- Security

Results:
- [x] Java 7
- [x] JSF 2.2 - primefaces 4
- [/] Jboss AS 7.1.1.Final (should work also on GlassFish with EJB 3 support)
- [/] projects stored in xml file, no need to store users in xml files as well
- [x] fully compatible with Firefox and Safari
- [x] 3 layers architecture - DAO, EJB, JSF Beans
- [/] partialy designed
- [x] Seam security for login and registration

This application was written in InteliJ Idea v12 running on Mac OS X 10.9.2.

To run this application you need to edit file XmlProjectsParses.java in projects-persistence
module at location sk.mk.persistence.util.XmlProjectParser. Change xml file location of projects.xml
where projects are stored.

