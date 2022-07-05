plugins {
	id("azazels-mods.module-conventions")
}

dependencies {
	project(
		path = "azazels-core",
		configuration = "namedElements",
	).also(::api).also(::include)

	project(
		path = "azazels-furniture",
		configuration = "namedElements",
	).also(::api).also(::include)
}
