package com.example.androidprojectsem6

class TeamItem {

    var team_logos: Int ?= 0
    var team_name: String ?= null

    constructor(team_logos: Int?, team_name: String?) {
        this.team_logos = team_logos
        this.team_name = team_name

    }
}