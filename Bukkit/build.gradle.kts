plugins {
    id("java")
}

group = "es.angelillo15.rlr.bukkit"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    implementation(project(":api"))
    compileOnly("com.github.Angelillo15:ConfigManager:1.2")
    compileOnly("org.yaml:snakeyaml:1.33")
    compileOnly("me.carleslc.Simple-YAML:Simple-Yaml:1.8.1")
    compileOnly("org.spigotmc:spigot-api:1.13-R0.1-SNAPSHOT")
    compileOnly("com.mashape.unirest:unirest-java:1.4.9")
    compileOnly("com.google.code.gson:gson:2.9.0")
}

tasks.processResources {
    filesMatching("plugin.yml") {
        expand("version" to (parent?.version ?: project.version))
    }
}

java {
    withJavadocJar()
}