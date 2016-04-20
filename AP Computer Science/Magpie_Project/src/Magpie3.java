/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie3
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
	 *Ideas:
	 *create methods for each response  
	 * 
	 */
	
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.indexOf("no") >= 0
			|| statement.indexOf("sucks") >= 0
			|| statement.indexOf("terrible") >= 0
			|| statement.indexOf("bad") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = get_response_Family(statement);
		}
		else if (statement.indexOf("school") >= 0
				|| statement.indexOf("study") >= 0
				|| statement.indexOf("work") >= 0
				|| statement.indexOf("western") >= 0)
		{
			response = "Tell me more about your school.";
		}
		else if (statement.indexOf("city") >= 0
				|| statement.indexOf("place") >= 0
				|| statement.indexOf("building") >= 0
				|| statement.indexOf("town") >= 0)
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
	
	public String get_response_Family(String statement){
		//find response for answers with family related
		String response = "";
		
		if (statement.indexOf(" mother ") >= 0){
			response = "When is your moms birthday?";
		} else if (statement.indexOf(" mother ") >= 0){
			response = "When is your dads birthday?";
		} else if (statement.indexOf(" brother ") >= 0){
			response = "When is your brothers birthday?";
		} else if (statement.indexOf(" sister ") >= 0){
			response = "When is your sisters birthday?";
		}
		
		return response;
	}
	
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
}