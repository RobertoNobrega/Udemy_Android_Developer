// Top-level build file where you can add configuration options common to all sub-projects/modules.
// Aula 21, Seção 4: Abaixo, informa a versão do gradle, que irá compilar o projeto (ou seja, este App).
// O gradle é um resolvedor de dependências ( ex: se for necessário que o App precise de bibliotecas,
// aqui (gradle) resolve isso, buscando na Internet ).

//    OBS: Quando o programador altera o(s) arquivo(s) do Gradle Scripts, é necessário fazer ( após
//    isso ) o Sync ( clique na opção Sync Now ).

// No arquivo proguard-rules.pro , podemos colocar parâmetros, para impedir a Engenharia Reversa ( por
// exemplo, dado o APK gerado, não será possível gerar a Engenharia Reversa, depois de colocar esses
// parâmetros ).

// Em gradle.properties , possui instruções, para uso de recurso do computador ( pelo que compreendi ).

plugins {
    id("com.android.application") version "8.2.0" apply false
}