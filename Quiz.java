package course.quiz;

public class Quiz {

	private String category;
	private String type;
	private String difficulty;
	private String question;
	private String[] allAnswers;
	private String correctAnswer;
	
	public Quiz(String category, String type, String difficulty, String question, String[] allAnswers,String correctAnswer) 
	{
		this.category = category;
		this.type = type;
		this.difficulty = difficulty;
		this.question = question;
		this.allAnswers = allAnswers;
		this.correctAnswer = correctAnswer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getAllAnswers() {
		return allAnswers;
	}
	public void setAllAnswers(String[] allAnswers) {
		this.allAnswers = allAnswers;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	
	
}
