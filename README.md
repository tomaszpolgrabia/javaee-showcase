# Requirements

- Wildfly (tested with 18.0.0 Final)

# Initial setup

- Queue ( java:/jms/queue/MyQueue )
- Connection factory ( java:/ConnectionFactory - tested with in-vm )

# Cargo deployment

Container ids used in the gradle plugin for cargo:

1. Tomcat tomcat9x
2. Jetty jetty9x
3. Wildfly 9.* wildfly9x
4. Wildfly 17.* wildfly17x

# Postgresql wildfly setup

## creating postgresql driver

modules/org/postgresql and put there module.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <module xmlns="urn:jboss:module:1.3" name="org.postgresql">
        <resources>
            <resource-root path="postgresql-42.2.1.jar"/>
            <!-- Make sure this matches the name of the JAR you are installing -->
        </resources>
        <dependencies>
            <module name="javax.api"/>
            <module name="javax.transaction.api"/>
        </dependencies>
    </module>

then in jboss-cli

    ./subsystem=datasources/jdbc-driver=postgresql:add(driver-module-name="org.postgresql")    

it should create the jdbc driver

## creating data source

    ./subsystem=datasources/data-source=MyDataSource:add(driver-name="postgresql", jndi-name="java:/MyDataSource", connection-url="jdbc:postgresql://localhost:5432/simpleservice", user-name="simpleservice", password="simpleservice", min-pool-size=5, max-pool-size=15)


# Useful links
1. https://thoughts-on-java.org/jpa-persistence-xml/
2. https://www.stenusys.com/how_to_setup_postgresql_datasource_with_wildfly/
3. Adding messaging queue / topics - https://docs.jboss.org/author/display/WFLY10/Messaging+configuration
4. One another way 4. One another way https://cleanprogrammer.net/how-to-configure-jms-in-wildfly/
5. Markdown syntax https://daringfireball.net/projects/markdown/syntax
