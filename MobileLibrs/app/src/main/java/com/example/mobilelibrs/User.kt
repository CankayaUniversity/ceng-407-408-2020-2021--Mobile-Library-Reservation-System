package com.example.mobilelibrs

class User {

    var userId: String? = null
    var userEmail: String? = null
    var userPassword: String? = null
    var userStatus: String? = null
    var userPunishmentScore: String? = null


    constructor(
        userId: String,
        userEmail: String,
        userPassword: String,
        userStatus: String,
        userPunishmentScore: String
    ) {
        this.userId = userId
        this.userEmail = userEmail
        this.userPassword = userPassword
        this.userStatus = userStatus
        this.userPunishmentScore = userPunishmentScore

    }

    constructor(
        userId: String,
        userEmail: String,
        userPassword: String,
    ) {
        this.userId = userId
        this.userEmail = userEmail
        this.userPassword = userPassword
    }

    constructor() {}

}