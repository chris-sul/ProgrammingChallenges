import java.util.ArrayList;

/**
 *Christopher Sullivan
 *11/5/14
 * Chatbot program that replies to multiples inputs
 */
public class Magpie4
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	
	/*
	 *methods for each response 
	 */
	
	public String getResponse(String statement)
	{
		//read keywords from each section from a file
		statement = statement.toLowerCase();
		String response = "";
		
		if(findKeyword(statement,"i like",0) != -1 || findKeyword(statement,"i want",0) != -1)
		{
			response = transformILikeToStatement(statement);
		}
		else if (findKeyword(statement,"no",0) != -1
			|| findKeyword(statement,"sucks",0) != -1
			|| findKeyword(statement,"terrible",0) != -1
			|| findKeyword(statement,"bad",0) != -1)
		{
			response = "Why so negative?";
		}
		else if (findKeyword(statement,"mother",0) != -1
				|| findKeyword(statement,"father",0) != -1
				|| findKeyword(statement,"sister",0) != -1
				|| findKeyword(statement,"brother",0) != -1)
		{
			response = get_response_Family(statement);
		}
		else if (findKeyword(statement,"school",0) != -1
				|| findKeyword(statement,"study",0) != -1
				|| findKeyword(statement,"work",0) != -1
				|| findKeyword(statement,"western",0) != -1)
		{
			response = "Tell me more about your school.";
		}
		else if (statement.indexOf("city") >= 0
				|| findKeyword(statement,"place",0) != -1
				|| findKeyword(statement,"building",0) != -1
				|| findKeyword(statement,"town",0) != -1)
		{
			response = "Cool! Where is that?";
		}
		else if (statement.indexOf("cold") >= 0
				|| statement.indexOf("snow") >= 0
				|| statement.indexOf("freeze") >= 0
				|| statement.indexOf("freeing") >= 0)
		{
			response = "Wow thats cold";
		}
		else if (statement.indexOf("hot") >= 0
				|| statement.indexOf("warm") >= 0
				|| statement.indexOf("blazing") >= 0)
		{
			response = "Wow sounds hot";
		}
		else
		{
			response = getRandomResponse();
		}
		
		
		return response;
	}
		

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 10;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "What are you doing?";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "Amazing.";
		}
		else if (whichResponse == 5)
		{
			response = "Thats really cool";
		}
		else if (whichResponse == 6)
		{
			response = "I wish I could do that!";
		}
		else if (whichResponse == 7)
		{
			response = "You are so cool";
		}
		else if (whichResponse == 8)
		{
			response = "What's the weather like?";
		}
		else if (whichResponse == 9)
		{
			response = "Google it!";
		}


		return response;
	}
	
	/*
	 *methods for family response
	 */
	
	public String get_response_Family(String statement){
		//find response for answers with family related
		String response = "";
		
		if (findKeyword(statement,"mother",0) != -1 ){
			response = "When is your moms birthday?";
		} else if (findKeyword(statement,"father",0) != -1){
			response = "When is your dads birthday?";
		} else if (findKeyword(statement,"brother",0) != -1){
			response = "When is your brothers birthday?";
		} else if (findKeyword(statement,"step-brother",0) != -1){
			response = "When is your brothers birthday?";
		} else if (findKeyword(statement,"sister",0) != -1){
			response = "When is your sisters birthday?";
		} else if (findKeyword(statement,"step-sister",0) != -1){
			response = "When is your step-sisters birthday?";
		}
		
		return response;
	}
	
	/*
	 *method to find a keyword in the user input
	 */
	
	public static int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim();
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
		while (psn >= 0)
		{
		String before = " ", after = " ";
		if (psn > 0)
		{
			before = phrase.substring (psn - 1, psn).toLowerCase();
		}
		if (psn + goal.length() < phrase.length())
		{
			after = phrase.substring(psn + goal.length(),
			psn + goal.length() + 1).toLowerCase();
		}
		/* determine the values of psn, before, and after at this point in the method. */
		if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))
				&&
		   ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
		{
			return psn;
		}
		psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
		}
		return -1;
		}
	
	/*
	 *method to transform string into questions
	 */
	
	public String transformILikeToStatement(String statement){
		String finalS ="";
		if (findKeyword(statement,"i like",0) != -1)
			finalS = "What do you like about" + statement.substring(6) + "?";
		else if(findKeyword(statement,"i want",0) != -1)
			finalS = "Would you really be happy if you had" + statement.substring(6) + "?";
		return finalS;
	}
	
	public void addUnknownWord(String a){
		//add these words to the unknown text file
		ArrayList words = new ArrayList();
		//Seperate the words and add to an array list
		String temp = "";
		for(int i=0;i<a.length()-1;i++){
			if(a.substring(i, i+1) == " " && i > 0){
				words.add(temp);
			} else {
				temp += a.substring(i, i+1);
			}
		}
		//add words elements to new lines of unknown
		for(int j=0;j<words.size()-1;j++){
			//scanner = new
		}
		
		
	}
	
}