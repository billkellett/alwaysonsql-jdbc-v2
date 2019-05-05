# alwaysonsql-jdbc-v2
Java resource for DataStax AlwaysOnSQL Workshop

This is a Maven-based Java project built with IntelliJ.  Note that .gitignore ignores the entire .idea folder. 

Before starting the project, **you must install the AlwaysOnSQL JDBC Driver in your local Maven repository**. The driver can be downloaded from the DataStax documentation site. Go to https://docs.datastax.com/en/landing_page/doc/landing_page/current.html and scroll down to "JDBC/ODBC Drivers."

To find local repo location: 

```
mvn help:evaluate -Dexpression=settings.localRepository 
```

Here is an example installation command:

```
mvn install:install-file -Dfile=C:\Users\Bill\Squirrel\jdbc-drivers\SparkJDBC41.jar -DgroupId=com.kellett.code -DartifactId=spark-jdbc -Dversion=4.1 -Dpackaging=jar -DgeneratePom=true
```
		
Then you can reference it in your .pom thusly:

```
<dependency>
	<groupId>com.kellett.code</groupId>
	<artifactId>spark-jdbc</artifactId>
	<version>4.1</version>
</dependency>
```
