package com.example.quizgame;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    private static List<QuestionList> javaQuestions(){
        final List<QuestionList> questionslist= new ArrayList<>();
        final QuestionList question1= new QuestionList(" Which of the following is not a Java features?","Dynamic","Architecture Neutral","Use of pointers","Object-oriented","Use of pointers","");
        final QuestionList question2= new QuestionList("  _____ is used to find and fix bugs in the Java programs.","JVM","JRE","JDK","JDP","JDP","");
        final QuestionList question3= new QuestionList(" What is the return type of the hashCode() method in the Object class?","Object","integer","Long","Void","integer","");
        final QuestionList question4= new QuestionList(" What does the expression float a = 35 / 0 return?","0","Not A Number","Infinity","Runtime exception","Infinity","");

        questionslist.add(question1);
        questionslist.add(question2);
        questionslist.add(question3);
        questionslist.add(question4);


        return questionslist;
    }

    private static List<QuestionList> htmlquestions(){
        final List<QuestionList> questionslist= new ArrayList<>();
        final QuestionList question1= new QuestionList(" How many sizes of headers are available in HTML by default?","6","5","1","3","6","");
        final QuestionList question2= new QuestionList(" What is the smallest header in HTML by default  ","h1","h2","h6","h4","h6","");
        final QuestionList question3= new QuestionList(" What are the types of lists available in HTML?","Ordered, Unordered  Lists","Bulleted, Numbered Lists","Named, Unnamed Lists","None of the above","Ordered, Unordered  Lists","");
        final QuestionList question4= new QuestionList(" How to create an ordered list in HTML?","<ul>","<ol>","<href>","<b>","<ol>","");

        questionslist.add(question1);
        questionslist.add(question2);
        questionslist.add(question3);
        questionslist.add(question4);


        return questionslist;
    }
    private static List<QuestionList> cssquestions(){
        final List<QuestionList> questionslist= new ArrayList<>();
        final QuestionList question1= new QuestionList(" The full form of CSS is:","Cascading Style Sheets","Coloured Special Sheets","Color and Style Sheets","None of the above","Cascading Style Sheets","");
        final QuestionList question2= new QuestionList(" In how many ways can CSS be written in?","1","2","3","4","3","");
        final QuestionList question3= new QuestionList(" Can negative values be allowed in padding property?","Yes","No","Depends on property","None of the above","No","");
        final QuestionList question4= new QuestionList(" Which of the following are valid CSS position property values?","static","relative","fixed","All of the above","All of the above","");

        questionslist.add(question1);
        questionslist.add(question2);
        questionslist.add(question3);
        questionslist.add(question4);


        return questionslist;
    }

    private static List<QuestionList> kotlinquestions(){
        final List<QuestionList> questionslist= new ArrayList<>();
        final QuestionList question1= new QuestionList(" Who developed Kotlin?","IBM","GOOGLE","JETBRAINS","MICROSOFT","JETBRAINS","");
        final QuestionList question2= new QuestionList(" Which extension is responsible to save kotlin files",".kt or .kts",".src",".android",".kot",".kt or .kts","");
        final QuestionList question3= new QuestionList(" Kotlin only works for supporting java language?","True","False","I don't know","Maybe","False","");
        final QuestionList question4= new QuestionList(" What handles null exception in Kotlin?","Sealed classes","Lambada function","The Kotlin extension","Elvis operator","Elvis operator","");

        questionslist.add(question1);
        questionslist.add(question2);
        questionslist.add(question3);
        questionslist.add(question4);


        return questionslist;
    }

    public static List<QuestionList> getQuestions(String selectedTpicname){
        switch (selectedTpicname){
            case "java":
                return javaQuestions();
            case "html":
                return htmlquestions();
            case "css":
                return cssquestions();
            default:
                return kotlinquestions();
        }
    }
}
