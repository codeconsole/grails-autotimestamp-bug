package com.example

class Sample {

    Date dateCreated
    String name

    static constraints = {
        dateCreated(nullable: true)
    }
}