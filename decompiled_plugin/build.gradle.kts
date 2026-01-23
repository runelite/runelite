plugins {
    java
}

group = "com.fakedrop"
version = "1.0.0"

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.runelite.net")
    }
    mavenCentral()
}

dependencies {
    compileOnly(group = "net.runelite", name = "client", version = "latest.release")

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    compileOnly("com.google.guava:guava:23.2-jre")
    compileOnly("com.google.inject:guice:4.1.0:no_aop")
    compileOnly("com.google.code.gson:gson:2.8.5")
    compileOnly("net.sf.jopt-simple:jopt-simple:5.0.4")
    compileOnly("org.slf4j:slf4j-api:1.7.25")

    // Test dependencies
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:4.11.0")
    testImplementation("org.mockito:mockito-inline:4.11.0")
    testImplementation(group = "net.runelite", name = "client", version = "latest.release")
    testImplementation("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
    testImplementation("com.google.inject:guice:4.1.0:no_aop")
    testImplementation("org.slf4j:slf4j-api:1.7.25")
    testImplementation("org.slf4j:slf4j-simple:1.7.25")
}

tasks.test {
    useJUnit()
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
