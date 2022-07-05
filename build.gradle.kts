plugins {
	id("azazels-mods.module-conventions")
}

dependencies {
	project(
		path = "azazels-core",
		configuration = "namedElements",
	).also(::runtimeOnly).also(::include)

	project(
		path = "azazels-furniture",
		configuration = "namedElements",
	).also(::runtimeOnly).also(::include)
}
