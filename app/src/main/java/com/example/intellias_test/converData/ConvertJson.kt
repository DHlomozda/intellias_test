package com.example.intellias_test.converData

//data class where hold data from Json object
data class ConvertFromJsonItem(
    val meanings: List<Meaning>,
    val origin: String,
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
    val antonyms: List<String>,
    val definition: String,
    val example: String,
    val synonyms: List<String>
)