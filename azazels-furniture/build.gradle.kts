plugins {
    id("azazels-mods.module-conventions")
}

dependencies {
    project(
        path = ":azazels-core",
        configuration = "namedElements",
    ).also(::implementation)
}

