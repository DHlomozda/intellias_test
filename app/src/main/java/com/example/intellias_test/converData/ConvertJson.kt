package com.example.intellias_test.converData

//class ConvertFromJson : ArrayList<ConvertFromJsonItem>()

data class ConvertFromJsonItem(
    val meanings: List<Meaning>,
    val phonetics: List<Phonetic>,
    val word: String
)

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)

data class Phonetic(
    val audio: String,
    val text: String
)

data class Definition(
    val definition: String,
    val example: String,
    val synonyms: List<String>
)