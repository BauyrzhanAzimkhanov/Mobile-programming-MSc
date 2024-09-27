package com.example.assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment1.ui.theme.Assignment1Theme

class MainActivity : ComponentActivity()
{
    fun printVals (myInt: Int, myDouble: Double, myString: String, myBoolean: Boolean) : Unit
    {
        println("Int: $myInt");
        println("Double: $myDouble");
        println("String: $myString");
        println("Boolean: $myBoolean");
    }

    fun conditionalStatementsFunc(number: Int) : Unit
    {
        if (number > 0)
        {
            println("Number $number is positive.");
        }
        else if (number < 0)
        {
            println("Number $number is negative.");
        }
        else
        {
            println("Number $number is zero.");
        }
    }

    fun loopsFunc() : Unit
    {
        for (i in 1..10)
        {
            println(i);
        }
        var j = 1;
        while (j <= 10)
        {
            println(j);
            j++;
        }
    }

    fun collectionsFunc(numbers : List<Int>) : Unit
    {
        var sum = 0;
        for (number in numbers)
        {
            sum += number;
        }
        println("Sum of all numbers: $sum");
    }

    fun sumFunc(a: Int, b: Int) : Int
    {
        return a + b;
    }

    fun applyOperationFunc(a: Int, b: Int, operation: (Int, Int) -> Int): Int
    {
        return operation(a, b);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myInt: Int = 10;
        val myDouble: Double = 10.5;
        val myString: String = "Hello, Kotlin!";
        val myBoolean: Boolean = true;
        printVals(myInt, myDouble, myString, myBoolean);

        conditionalStatementsFunc(228);
        conditionalStatementsFunc(0);
        conditionalStatementsFunc(-1337);

        loopsFunc();

        val myNumbers = listOf(1, 2, 3, 4, 5);

        collectionsFunc(myNumbers);

        val person = Person("Van Darkholme", 69, "master-van@kink.com");
        person.displayInfo();

        val employee = Employee(person, 300.0);
        employee.displayInfo();

        val bankAccount = BankAccount(14.88);
        println("Bank account is " + bankAccount.getBalance() + ".");
        bankAccount.deposit(13.37);
        println("Bank account is " + bankAccount.getBalance() + ".")
        bankAccount.withdraw(22.8);
        println("Bank account is " + bankAccount.getBalance() + ".")

        val multiply: (Int, Int) -> Int = { a, b -> a * b };

        println("Product of 4 and 6 is: ${multiply(4, 6)}");

        val sumResult = applyOperationFunc(7, 3, { x, y -> x + y });
        val multiplyResult = applyOperationFunc(7, 3, { x, y -> x * y });

        println("Sum of 7 and 3 using applyOperation: $sumResult");
        println("Product of 7 and 3 using applyOperation: $multiplyResult");

        enableEdgeToEdge()
        setContent {
            Assignment1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment1Theme {
        Greeting("Android")
    }
}