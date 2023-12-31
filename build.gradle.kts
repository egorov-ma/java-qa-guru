plugins {
    id("java")
}

group = "guru.qa"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
    compileTestJava {
        options.encoding = "UTF-8"
    }
}

dependencies {
    testImplementation("com.codeborne:selenide:6.19.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.slf4j:slf4j-simple:2.0.9")
}

tasks.test {
    useJUnitPlatform()
}