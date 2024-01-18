openmrs-module-basicmodule
==========================

A demonstration module for new OpenMRS module developers

Description
-----------
This is a very basic module which can be used as a starting point in creating a new module.

Building from Source
--------------------
You will need to have Java 1.6+ and Maven 2.x+ installed.  Use the command 'mvn package' to 
compile and package the module.  The .omod file will be in the omod/target folder.

Alternatively you can add the snippet provided in the [Creating Modules](https://wiki.openmrs.org/x/cAEr) page to your 
omod/pom.xml and use the mvn command:

    mvn package -P deploy-web -D deploy.path="../../openmrs-1.8.x/webapp/src/main/webapp"

It will allow you to deploy any changes to your web 
resources such as jsp or js files without re-installing the module. The deploy path says 
where OpenMRS is deployed.

Installation
------------
1. Build the module to produce the .omod file.
2. Use the OpenMRS Administration > Manage Modules screen to upload and install the .omod file.

If uploads are not allowed from the web (changable via a runtime property), you can drop the omod
into the ~/.OpenMRS/modules folder.  (Where ~/.OpenMRS is assumed to be the Application 
Data Directory that the running openmrs is currently using.)  After putting the file in there 
simply restart OpenMRS/tomcat and the module will be loaded and started.

SQL Query
------------

`
SELECT
e.identifier, b.given_name,
b.family_name, a.start_date_time, a.end_date_time, c.gender, a.patient_id, address2, birthdate, status, comments
FROM patient_appointment a
LEFT JOIN person_name b on a.patient_id = b.person_id
LEFT JOIN person c on a.patient_id = c.person_id
LEFT JOIN person_address d on a.patient_id = d.person_id
LEFT JOIN patient_identifier e on a.patient_id = e.patient_id  
WHERE b.person_id IS NOT NULL
AND e.identifier_type = 3
limit 3;`
