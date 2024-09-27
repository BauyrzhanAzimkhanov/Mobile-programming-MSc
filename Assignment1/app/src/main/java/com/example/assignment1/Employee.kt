package com.example.assignment1

open class Employee(name: String, age: Int, email: String, val salary: Double) : Person(name, age, email)
{
    constructor(person: Person, salary: Double): this(person.name, person.age, person.email, salary)
    open override fun displayInfo()
    {
        super.displayInfo();
        println("Salary: $salary");
    }
}