val version: String by properties

val minecraftVersion: String by properties
val yarnVersion: String by properties
val loaderVersion: String by properties
val javaVersion: String by properties

val arrpVersion: String by properties
val divineInterventionVersion: String by properties
val fabricApiVersion: String by properties
val incubusCoreVersion: String by properties
val owoLibVersion: String by properties
val modmenuVersion: String by properties
val reiVersion: String by properties
val worldEditVersion: String by properties

plugins {
    id("fabric-loom")
    `maven-publish`
}

project.version = version

repositories {
    maven {
        name = "TerraformersMC"
        url = uri("https://maven.terraformersmc.com/releases/")
    }

    maven {
        name = "Ladysnake"
        url = uri("https://ladysnake.jfrog.io/artifactory/mods/")
    }

    maven {
        name = "Shedaniel"
        url = uri("https://maven.shedaniel.me/")
    }

    maven {
        name = "Wispforest"
        url = uri("https://maven.wispforest.io/")
    }

    maven {
        name = "Devan"
        url = uri("https://storage.googleapis.com/devan-maven/")
    }

    maven {
        name = "EngneHub"
        url = uri("https://repo.enginehub.org/artifactory/repo/")
    }

    maven {
        name = "Jitpack"
        url = uri("https://jitpack.io/")
    }
}

dependencies {
    minecraft(
        group = "com.mojang",
        name = "minecraft",
        version = minecraftVersion,
    )

    mappings(
        group = "net.fabricmc",
        name = "yarn",
        version = yarnVersion,
        classifier = "v2",
    )

    modImplementation(
        group = "net.fabricmc",
        name = "fabric-loader",
        version = loaderVersion,
    )

    modImplementation(
        group = "net.devtech",
        name = "arrp",
        version = arrpVersion,
    )

    modImplementation(
        group = "com.github.devs-immortal",
        name = "Divine-Intervention",
        version = divineInterventionVersion,
    ).also(::annotationProcessor)

    modImplementation(
        group = "net.fabricmc.fabric-api",
        name = "fabric-api",
        version = fabricApiVersion,
    )

    modImplementation(
        group = "com.github.devs-immortal",
        name = "Incubus-Core",
        version = incubusCoreVersion,
    )

    modImplementation(
        group = "io.wispforest",
        name = "owo-lib",
        version = owoLibVersion,
    )

    modRuntimeOnly(
        group = "com.terraformersmc",
        name = "modmenu",
        version = modmenuVersion,
    )

    modRuntimeOnly(
        group = "me.shedaniel",
        name = "RoughlyEnoughItems-fabric",
        version = reiVersion,
    )

    modRuntimeOnly(
        group = "com.sk89q.worldedit",
        name = "worldedit-fabric-mc1.19",
        version = worldEditVersion,
    )
}

tasks {
    processResources {
        inputs.property("version", version)

        filesMatching("fabric.mod.json") {
            expand("version" to version)
        }
    }
}

sourceSets {
    main {
        resources {
            srcDir("src/main/generated")
        }
    }
}

java {
    sourceCompatibility = JavaVersion.toVersion(javaVersion)
    withSourcesJar()
}

loom {
    shareRemapCaches.set(true)

    runs {
        create("datagen") {
            server()
            vmArg("-Dfabric-api.datagen")
            vmArg("-Dfabric-api.datagen.output-dir=${file("src/main/generated")}")
            vmArg("-Dfabric-api.datagen.strict-validation")
            vmArg("-Dfabric-api.datagen.modid=${project.name.replace('-', '_')}")
            runDir = "build/datagen"
        }
    }

    splitEnvironmentSourceSets()
    mods {
        create(project.name.replace('-', '_')) {
            sourceSet(sourceSets.main.get())
            sourceSet(sourceSets.getByName("client"))
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}
