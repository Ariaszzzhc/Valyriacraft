rootProject.name = "Valyriacraft"

pluginManagement {
    repositories {
        mavenCentral()
        maven("https://maven.fabricmc.net/")
        gradlePluginPortal()
    }

    val loomVersion: String by settings
    val kotlinVersion: String by settings
    val ktlintVersion: String by settings

    plugins {
        id("fabric-loom").version(loomVersion)
        kotlin("jvm").version(kotlinVersion)
        id("org.jlleitschuh.gradle.ktlint").version(ktlintVersion)
    }
}
