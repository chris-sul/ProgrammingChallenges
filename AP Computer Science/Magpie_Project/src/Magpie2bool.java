//copy/paste/change code from magpie 2
public class Magpie2bool {
	
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
		boolean negative, family, school, location, tempC, tempH;
		
		public String getResponse(String statement)
		{
			String response = "";
			negative = (statement.indexOf("no") >= 0
					|| statement.indexOf("sucks") >= 0
					|| statement.indexOf("terrible") >= 0
					|| statement.indexOf("bad") >= 0);
			family = (statement.indexOf("mother") >= 0
					|| statement.indexOf("father") >= 0
					|| statement.indexOf("sister") >= 0
					|| statement.indexOf("brother") >= 0);
			school =(statement.indexOf("school") >= 0
					|| statement.indexOf("study") >= 0
					|| statement.indexOf("work") >= 0
					|| statement.indexOf("western") >= 0);
			location =(statement.indexOf("city") >= 0
					|| statement.indexOf("place") >= 0
					|| statement.indexOf("building") >= 0
					|| statement.indexOf("town") >= 0);
			tempC = (statement.indexOf("cold") >= 0
					|| statement.indexOf("snow") >= 0
					|| statement.indexOf("freeze") >= 0
					|| statement.indexOf("freeing") >= 0);
			if (negative)
			{
				response = "Why so negative?";
			}
			else if (family)
			{
				response = get_response_Family(statement);
			}
			else if (school)
			{
				response = "Tell me more about your school.";
			}
			else if (location)
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
}
