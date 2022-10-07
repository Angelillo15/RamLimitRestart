plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "4.0.4"
}

group = "es.angelillo15"
version = "1.0"

tasks.shadowJar {
    archiveFileName.set("MABungee.jar")
    relocate("org.simpleyaml", "es.angelillo15.minearte.libs.simpleyaml")
    relocate("org.yaml", "es.angelillo15.minearte.libs.yaml")
    relocate("es.angelillo15.configmanager", "es.angelillo15.minearte.libs.config.manager")
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation(project(":api"))
    implementation(project(":Bukkit"))
    implementation("com.github.Angelillo15:ConfigManager:1.2")
    implementation("org.yaml:snakeyaml:1.33")
    implementation("me.carleslc.Simple-YAML:Simple-Yaml:1.8.1")
}

