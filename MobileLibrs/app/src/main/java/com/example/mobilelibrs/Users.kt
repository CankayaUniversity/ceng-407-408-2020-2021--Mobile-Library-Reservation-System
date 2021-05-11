package com.example.mobilelibrs

class Users {

    var userId : String? = null
    var userPassword: String? = null
    var userEmail: String? = null

    constructor(userId: String, userPassword: String, userEmail: String) {
        this.userId = userId
        this.userPassword = userPassword
        this.userEmail = userEmail
    }

    constructor() {}

}