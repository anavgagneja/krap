package models

import kotlinx.serialization.Serializable

@Serializable
data class Rhyme(val word: String, val score: Int, val numSyllables: Int)

@Serializable
data class RhymeResponse(val word: String, val rhymes: List<Rhyme>)