plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    maven {
        name = "Fabric"
        url = uri("https://maven.fabricmc.net/")
    }
}

dependencies {
    implementation(
        group = "net.fabricmc",
        name = "fabric-loom",
        version = "0.12-SNAPSHOT",
    )
}
