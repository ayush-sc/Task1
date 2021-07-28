package course.quiz;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
	
	private Quiz quiz;

	public String getCategory1()
	{
		HttpClient client=HttpClient.newHttpClient();
		HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://opentdb.com/api.php?amount=5&category=11")).build();
		return client.sendAsync(request,HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body).join();
//			.thenAccept(System.out::println)
//			.join();
		
//		return "";
	}
	
	public String getCategory2()
	{
		HttpClient client=HttpClient.newHttpClient();
		HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://opentdb.com/api.php?amount=5&category=12")).build();
		return client.sendAsync(request,HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body).join();
//				.thenAccept(System.out::println)
//				.join();
			
//			return "";
	}
	
	public JSONObject getQuiz()
	{
		System.out.println("\n\n\n");
		String res1=getCategory1();
		String res2=getCategory2();
		
		JSONObject result=new JSONObject();
		
		JSONArray film=new JSONArray(new JSONObject(res1).getJSONArray("results"));
		System.out.println("Film Array--->"+film.toString()+"    size--->"+film.length());
		
		JSONArray music=new JSONArray(new JSONObject(res2).getJSONArray("results"));
		System.out.println("Music Array--->"+music.toString()+"    size--->"+music.length());
		
//		JSONArray s=(JSONArray)film.getJSONObject(0).get("incorrect_answers");
//		System.out.println(s.toString());
		
//		for(int i=0;i<film.length();i++)
//		{
//			JSONObject x=film.getJSONObject(i);
//			quiz.setCategory(x.getString("category"));
//			quiz.setType(x.getString("type"));
//			quiz.setDifficulty(x.getString("difficulty"));
//			quiz.setQuestion(x.getString("question"));
//			quiz.setCorrectAnswer(x.getString("correct_answer"));
//			JSONArray s=(JSONArray)x.get("incorrect_answers");
//			String[] str=new String[s.length()];
//			for(int j=0;j<s.length();j++)
//			{
//				str[j]=s.getString(i);
//			}
//			str[str.length-1]=x.getString("correct_answer");
//			
////			System.out.println(x.getString("category")+" "+x.getString("question"));
//		}
		
		JSONArray filmArray=new JSONArray();
		for(int i=0;i<film.length();i++)
		{
			JSONObject x=film.getJSONObject(i);
			System.out.println("Individual object--->"+i+" "+x.toString());
			JSONObject y=new JSONObject();
			y.put("type", (String)x.getString("type"));
			y.put("difficulty", (String)x.getString("difficulty"));
			y.put("question", (String)x.getString("question"));
			JSONArray s=(JSONArray)x.get("incorrect_answers");
			String[] str=new String[s.length()+1];
			System.out.println("JSONArray size--->"+s.length()+"    array--->"+s.toString());
			for(int j=0;j<s.length();j++)
			{
				System.out.println("j-->"+j);
				str[j]=(String)s.getString(j);
			}
			str[str.length-1]=x.getString("correct_answer");
			y.put("all_answer", str);
			y.put("correct_answer", (String)x.getString("correct_answer"));
			
			filmArray.put(y);
		}
		
		JSONArray lastArray=new JSONArray();
		JSONObject category=new JSONObject();
		category.put("category", "Entertainment: Film");
		category.put("results", filmArray);
		
		lastArray.put(category);
		
		JSONArray musicArray=new JSONArray();
		for(int i=0;i<music.length();i++)
		{
			JSONObject x=music.getJSONObject(i);
			JSONObject y=new JSONObject();
			y.put("type", (String)x.getString("type"));
			y.put("difficulty", (String)x.getString("difficulty"));
			y.put("question", (String)x.getString("question"));
			JSONArray s=(JSONArray)x.get("incorrect_answers");
			String[] str=new String[s.length()+1];
			for(int j=0;j<s.length();j++)
			{
				str[j]=(String)s.getString(j);
			}
			str[str.length-1]=x.getString("correct_answer");
			y.put("all_answer", str);
			y.put("correct_answer", (String)x.getString("correct_answer"));
			
			musicArray.put(y);
		}
		
		JSONObject category2=new JSONObject();
		category2.put("category", "Entertainment: Music");
		category2.put("results", musicArray);
		
		lastArray.put(category2);
		
		result.put("quiz", lastArray);
		System.out.println("\n\n\nFinal Result--->"+result);
		
		return result;
	}
	
}
