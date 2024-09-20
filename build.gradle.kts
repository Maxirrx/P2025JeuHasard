plugins {
    id("java")
    id ("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "fr.magali.p2025jeuhasard"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.openjfx:javafx:20.0.2")
}

tasks.test {
    useJUnitPlatform()
}