package com.example.studyanalayzer.homefragment.mcqtest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studyanalayzer.R;

import java.util.ArrayList;
import java.util.List;

public class mcqTest extends AppCompatActivity {

    Toolbar toolbar;
    Button previous, next;
    TextView questionTextView;
    RadioGroup optionsGroup;

    private List<String> questions;
    private List<String[]> options;
    private List<String> correctAnswers;
    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mcq_test);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.toolbar2);
        previous = findViewById(R.id.mcqPrevious);
        next = findViewById(R.id.mcqNext);
        questionTextView = findViewById(R.id.textView6);
        optionsGroup = findViewById(R.id.optionsGroup); // Assuming you have a RadioGroup for options

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize questions and options
        initializeQuestions();

        // Display the first question
        updateQuestion();

        // Previous button click listener
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--;
                    updateQuestion();
                } else {
                    Toast.makeText(mcqTest.this, "This is the first question!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Next button click listener
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex < questions.size() - 1) {
                    currentQuestionIndex++;
                    updateQuestion();
                } else {
                    Toast.makeText(mcqTest.this, "No more questions!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to initialize the questions, options, and correct answers
    private void initializeQuestions() {
        questions = new ArrayList<>();
        options = new ArrayList<>();
        correctAnswers = new ArrayList<>();

        // Add 20 questions, options, and correct answers
        questions.add("What is the concept of encapsulation in OOP?");
        options.add(new String[]{"Hiding the internal state and requiring all interaction through methods",
                "Inheriting properties from another class",
                "Designing a class with multiple constructors",
                "Defining multiple methods with the same name"});
        correctAnswers.add("Hiding the internal state and requiring all interaction through methods");

        questions.add("Which of the following is NOT a feature of OOP?");
        options.add(new String[]{"Encapsulation", "Inheritance", "Polymorphism", "Procedural programming"});
        correctAnswers.add("Procedural programming");

        questions.add("Which keyword is used to inherit a class in Java?");
        options.add(new String[]{"super", "this", "extends", "implements"});
        correctAnswers.add("extends");

        questions.add("What is polymorphism in OOP?");
        options.add(new String[]{"Ability of a function to take different forms",
                "The ability to hide data",
                "The process of creating multiple instances of a class",
                "Ability to create a new class from an existing class"});
        correctAnswers.add("Ability of a function to take different forms");

        questions.add("What does the 'this' keyword refer to?");
        options.add(new String[]{"The current instance of the class",
                "The parent class",
                "A superclass",
                "A method"});
        correctAnswers.add("The current instance of the class");

        questions.add("Which of the following is an example of inheritance?");
        options.add(new String[]{"A child class inheriting from a parent class",
                "A class containing private variables",
                "A method that returns an object",
                "A class with static methods"});
        correctAnswers.add("A child class inheriting from a parent class");

        questions.add("Which keyword is used to prevent a class from being subclassed?");
        options.add(new String[]{"private", "static", "final", "abstract"});
        correctAnswers.add("final");

        questions.add("Which of the following is a characteristic of abstraction?");
        options.add(new String[]{"Hiding implementation details",
                "Enabling data hiding",
                "Enabling multiple inheritance",
                "Creating private methods"});
        correctAnswers.add("Hiding implementation details");

        questions.add("What is the default access modifier for a class in Java?");
        options.add(new String[]{"public", "private", "protected", "package-private"});
        correctAnswers.add("package-private");

        questions.add("Which OOP principle allows different classes to be treated as instances of the same class through inheritance?");
        options.add(new String[]{"Polymorphism", "Abstraction", "Encapsulation", "Inheritance"});
        correctAnswers.add("Inheritance");

        questions.add("Which of the following is a benefit of using encapsulation?");
        options.add(new String[]{"Increased accessibility to class variables",
                "Increased security by protecting data from outside manipulation",
                "Increased code duplication",
                "Improved readability"});
        correctAnswers.add("Increased security by protecting data from outside manipulation");

        questions.add("What is the main purpose of the constructor in a class?");
        options.add(new String[]{"To initialize objects of the class",
                "To define the methods of the class",
                "To handle exceptions",
                "To declare variables"});
        correctAnswers.add("To initialize objects of the class");

        questions.add("Which method is used to start a thread in Java?");
        options.add(new String[]{"start()", "run()", "init()", "execute()"});
        correctAnswers.add("start()");

        questions.add("Which is the correct way to define a method in Java?");
        options.add(new String[]{"public void method() {}",
                "public method() {}",
                "void public method() {}",
                "method() public {}"});
        correctAnswers.add("public void method() {}");

        questions.add("Which of the following allows methods to have the same name but different parameters?");
        options.add(new String[]{"Overloading", "Overriding", "Encapsulation", "Polymorphism"});
        correctAnswers.add("Overloading");

        questions.add("What does the 'final' keyword do to a method in Java?");
        options.add(new String[]{"Prevents method overriding",
                "Prevents method overloading",
                "Prevents method invocation",
                "Prevents method definition"});
        correctAnswers.add("Prevents method overriding");

        questions.add("Which of the following represents a class method?");
        options.add(new String[]{"A method that is declared static",
                "A method that is declared private",
                "A method that is declared final",
                "A method that is declared abstract"});
        correctAnswers.add("A method that is declared static");

        questions.add("What is the main feature of an abstract class?");
        options.add(new String[]{"It can have abstract methods",
                "It can be instantiated",
                "It cannot inherit from another class",
                "It must implement all interfaces"});
        correctAnswers.add("It can have abstract methods");

        // 16th question
        questions.add("Which method is used to add an element to the end of a list in Java?");
        options.add(new String[]{"add()", "append()", "insert()", "push()"});
        correctAnswers.add("add()");

        // 17th question
        questions.add("What is the default size of an array in Java?");
        options.add(new String[]{"0", "1", "10", "None (it can be any size)"});
        correctAnswers.add("None (it can be any size)");

        // 18th question
        questions.add("What is the purpose of the 'break' statement?");
        options.add(new String[]{"Exit the loop or switch statement", "Continue to the next iteration", "Pause execution", "Terminate the program"});
        correctAnswers.add("Exit the loop or switch statement");

        // 19th question
        questions.add("Which method is used to find the length of a string in Java?");
        options.add(new String[]{"length()", "getLength()", "size()", "len()"});
        correctAnswers.add("length()");

        // 20th question
        questions.add("Which keyword is used to declare a constant in Java?");
        options.add(new String[]{"const", "constant", "final", "static"});
        correctAnswers.add("final");
    }

    // Method to update the question and options text
    private void updateQuestion() {
        questionTextView.setText(questions.get(currentQuestionIndex));

        // Clear previous selections
        optionsGroup.removeAllViews();

        String[] currentOptions = options.get(currentQuestionIndex);
        // Set radio buttons for options
        for (int i = 0; i < currentOptions.length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(currentOptions[i]);
            radioButton.setId(i); // Set unique IDs for each option
            optionsGroup.addView(radioButton);
        }
    }
}
