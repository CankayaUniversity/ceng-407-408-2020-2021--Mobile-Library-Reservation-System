package com.example.mobilelibrs

class Tables {

    var Table_1:String? = null
    var Table_2:String? = null
    var Table_3:String? = null

    constructor() {
        this.Table_1= "T1"
        this.Table_2 = "T2"
        this.Table_3 = "T3"
    }

    constructor( table1:String , table2:String, table3:String )
    {
        this.Table_1 = table1
        this.Table_2 = table2
        this.Table_3 = table3
    }
}