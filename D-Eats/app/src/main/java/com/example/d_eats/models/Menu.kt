package com.example.d_eats.models

class Menu {

    var name:String = ""
    var description:String = ""
    var quantity:String = ""
    var price:String = ""
    var id:String = ""
    var userId:String = ""

    constructor(name: String, description: String, quantity: String, price: String, id: String, userId: String) {
        this.name = name
        this.description = description
        this.quantity = quantity
        this.price = price
        this.id = id
        this.userId = userId
    }

    constructor()
}