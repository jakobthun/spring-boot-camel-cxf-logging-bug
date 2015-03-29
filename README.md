# Spring boot camel CXF bug(?)

Example of a bug(?) that occurs when running Camel CXF component in spring-boot with logging @ INFO level

## Howto reproduce bad behaviour

1. Clone this repo
2. Verify `src/main/resources/application.properties` has `logging.level. = INFO`
3. run `./gradlew build`
4. run `java -jar build/libs/spring-boot-camel-cxf-logging-bug-0.0.1.jar``

*Note:* Java8 is used in this example

It's possible to __avoid the defect__ by setting the log-level to `WARN` (And redo the steps above)

### This is the code that breaks
```Java
/*
 * From DefaultCamelContext (rows 2445-2455)
 */
if (log.isInfoEnabled()) {
    // count how many routes are actually started
    int started = 0;
    for (Route route : getRoutes()) {
        if (getRouteStatus(route.getId()).isStarted()) {	// <<-- HERE is NullPointer exception 'getRouteStatus' returns null 
            started++;
        }
    }
    log.info("Total " + getRoutes().size() + " routes, of which " + started + " is started.");
    log.info("Apache Camel " + getVersion() + " (CamelContext: " + getName() + ") started in " + TimeUtils.printDuration(stopWatch.taken()));
}
```
