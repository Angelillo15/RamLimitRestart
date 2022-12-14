plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "4.0.4"
}

group = "es.angelillo15.rlr.api"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.13-R0.1-SNAPSHOT")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

java {
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "es.angelillo15"
            artifactId = "RamLimitRestart"
            version = parent?.version.toString()

            from(components["java"])
        }
    }
}
