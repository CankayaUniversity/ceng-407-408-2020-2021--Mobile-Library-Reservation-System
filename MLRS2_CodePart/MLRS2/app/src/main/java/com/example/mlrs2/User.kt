package com.example.mlrs2

class User {
    var userId: String? = null
    //Library member, Librarian or Admin
    var type: String? = null
    var email: String? = null
    var password: String? = null

    //Constructors
    constructor() {}

    constructor(email: String?, password: String?) {
        this.email = email
        this.password = password
    }

    constructor(email: String?, password: String?, type: String?, userId: String?) {
        this.email = email
        this.password = password
        this.type = type
        this.userId = userId
    }
}