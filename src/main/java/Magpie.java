/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie {
    /**
     * Get a default greeting
     *
     * @return a greeting
     */
    public String getGreeting() {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {

        String response = "";
        if (findWord(statement,"I want") >= 0){
            response = transformIWantStatement(statement);
        }
        else if (findWord(statement,"I") >= 0 || findWord(statement,"you") > findWord(statement,"I")){
            response = transformIYouStatement(statement);
        }
        else if (findWord(statement, "I want to") >= 0){
            response = transformIWantToStatement(statement);
        }
        else if (findWord(statement, "you")>= 0 && findWord(statement, "me")> findWord(statement, "you")){
            response = transformYouMeStatement(statement);
        }
        else if (findWord(statement, "I feel") >= 0){
            response = transformIWantToStatement(statement);
        }




        String response = "";
        if (statement.indexOf("no") >= 0) {
            response = "Why so negative?";
        } else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0) {
            response = "Tell me more about your family.";
        } else if (statement.indexOf("My teacher") >= 0
                || statement.indexOf("Mr") >= 0
                || statement.indexOf("Mrs") >= 0) {
            response = "Your teacher seems swanky.";
        } else if (statement.indexOf("cat") >= 0
                || statement.indexOf("dog") >= 0) {
            response = "tell me more about your pets.";
        } else if (statement.trim() == "") {
            response = "Say something dude";
        } else if (statement.indexOf("books") >= 0
                || statement.indexOf("read") >= 0) {
            response = "What have you been reading";
        } else if (statement.indexOf("Harry Potter") >= 0
                || statement.indexOf("quiz") >= 0) {
            response = "Tell me about your house";
        }
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise.
    //Zara
    public int findWord(String str, String word) {
        str = str.toUpperCase();
        word = word.toUpperCase();
        int index = str.indexOf(word);
        if((index)==0 && str.charAt(index + word.length()) == ' ' ) {
         return index; }
        else if(str.charAt(index-1)==' ' && (index+word.length()==str.length())) {
       return index; }
        else if(str.charAt(index-1)==' ' && str.charAt(index + word.length()) == ' ' ) {
            return index; }
        //if(index - 1 == 0 && str.charAt(index + 1) == ' ');


                // str.charAt(str.indexOf(word)-1)==' ';


        return -1;

        }


    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        String want="";
       want=statement.substring(statement.indexOf("I want")+7, statement.length());
        return "Would you really be happy if you had " + want + '?';
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        String iu="";
        iu=statement.substring(statement.indexOf("I")+2,statement.indexOf("you")-1);

        return "Why do you " + iu +" me?";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        String iwantto="";
        iwantto=statement.substring(statement.indexOf("to")+2,statement.length());

        return ("What would it mean to"+iwantto +'?');

    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
    String something="";
    something=statement.substring(statement.indexOf("you")+5,statement.indexOf("me")-1);
        return "What makes you think I " + something+ " you?";
    }
    /**
     * Take a statement with "I feel <something>" and transform it into
     * "Why do you feel <something>?"
     * @return the transformed statement
     */
    public static String transformIFeelStatement(String statement) {
        String ifeel="";
        ifeel=ifeel.statement.substring((statement.indexOf("feel")+7,statement.length());

        return statement;

transformIFeelStatement("I feel good");

    }
}



//statement.indexOf("mother")--> findWord(statement,"Mother")