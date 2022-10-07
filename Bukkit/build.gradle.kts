plugins {
    id("java")
}

group = "es.angelillo15.rlr.bukkit"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    implementation(project(":api"))
    compileOnly("com.github.Angelillo15:ConfigManager:1.2")
    compileOnly("org.yaml:snakeyaml:1.33")
    compileOnly("me.carleslc.Simple-YAML:Simple-Yaml:1.8.1")
    compileOnly("org.spigotmc:spigot-api:1.19.2-R0.1-SNAPSHOT")
}

tasks.processResources {
    filesMatching("spigot.yml") {
        expand("version" to (parent?.version ?: project.version))
    }
}