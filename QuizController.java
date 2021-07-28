package course.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONArray;
import org.json.JSONObject;

@RestController
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@RequestMapping("/coding/exercise/quiz")
	public String getQuiz()
	{
		return quizService.getQuiz().toString();
	}
	
}
