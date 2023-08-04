package com.badlog1n.huntit.domain.models

data class MatchesResponse(
    val data: List<Match>,
)

data class Match(
    val id: Int,
    val teams: Teams,
    val time: Time,
    val scores: Scores,
)

data class Teams(
    val home: TeamDetails,
    val away: TeamDetails,
)

data class TeamDetails(
    val name: String,
    val short_code: String,
    val img: String,
    val form: String,
)

data class Time(
    val datetime: String,
    val date: String,
    val time: String,
    val minute: Int,
)

data class Scores(
    val home_score: String,
    val away_score: String,
)
