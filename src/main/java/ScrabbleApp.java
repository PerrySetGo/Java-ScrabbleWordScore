import java.util.HashMap;
import java.util.Arrays;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class ScrabbleApp {
    public static void main(String[] args) {
        staticFileLocation("/public"); //for future use

        get("/scrabble", (request, response) -> {
            HashMap <String, Integer> model = new HashMap<>();

            return new ModelAndView(model, "templates/scrabbleinput.vtl");
        }, new VelocityTemplateEngine());

        get("/scrabbleoutput", (request, response) -> {
            HashMap model = new HashMap();
            //set up hashmap for scrabble letter values
            String userInput = request.queryParams("userInput");
            model.put("userInput", userInput);

            Integer totalScore = getWordScore(userInput);

            //add output to hashmap
            model.put("totalScore", totalScore);

            //output output to page
            return new ModelAndView(model, "templates/scrabbleoutput.vtl");
        }, new VelocityTemplateEngine());

    }


    public static Integer getWordScore(String userInput) {

        // method
        HashMap <Character, Integer> scores = new HashMap<>();

        scores.put('A', 1);
        scores.put('E', 1);
        scores.put('I', 1);
        scores.put('O', 1);
        scores.put('U', 1);
        scores.put('L', 1);
        scores.put('N', 1);
        scores.put('R', 1);
        scores.put('S', 1);
        scores.put('T', 1);

        scores.put('D', 2);
        scores.put('G', 2);

        scores.put('B', 3);
        scores.put('C', 3);
        scores.put('M', 3);
        scores.put('P', 3);

        scores.put('F', 4);
        scores.put('H', 4);
        scores.put('V', 4);
        scores.put('W', 4);
        scores.put('Y', 4);

        scores.put('K', 5);

        scores.put('J', 8);
        scores.put('X', 5);

        scores.put('Q', 10);
        scores.put('Z', 10);


        //grab our inputs from the form
        HashMap model = new HashMap();

        userInput = userInput.toUpperCase();


        //take the input and chunk it up
        char[] listArray = userInput.toCharArray();
        Integer totalScore = 0;
        Integer score = 0 ;

        //look up things in the char array
        for ( char listItem : listArray){
            //System.out.println(listItem);
            System.out.println(scores.get(listItem));
            score = scores.get(listItem);
            //System.out.println(score);

            totalScore = totalScore + score;
        }
return totalScore;
    }

    }
