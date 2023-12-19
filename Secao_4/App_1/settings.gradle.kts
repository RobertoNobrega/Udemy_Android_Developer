pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
// Abaixo, temos o nome do App ( linha 17 ) e módulo ( "similar" a uma biblioteca. OBS: É possível adicionar
// mais de um módulo aqui ).
rootProject.name = "AppListaCurso"
include(":app")
