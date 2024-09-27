package com.example.assignment1

open class Person(var name: String, val age: Int, val email: String)
{
    open fun displayInfo(): Unit
    {
        println("Name: $name");
        println("Age: $age");
        println("Email: $email");
    }
}