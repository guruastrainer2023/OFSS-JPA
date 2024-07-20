package com.training.bean.pack1;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="questions10")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_id_seq3")
	@SequenceGenerator(name = "question_id_seq3", sequenceName ="seq9", allocationSize = 1)
	private int id;
	
	@Column
	private String questionText;
	
	@Column
	private int mark;
	
	@ElementCollection(targetClass = String.class)
	@CollectionTable(name ="question_answer_choices10")
	@OrderColumn(name = "idx")
	private String[] answerChoices;
	
	public Question(int id, String questionText, int mark, String[] answerChoices) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.mark = mark;
		this.answerChoices = answerChoices;
	}
	public Question(String questionText, int mark, String[] answerChoices) {
		super();
		this.questionText = questionText;
		this.mark = mark;
		this.answerChoices = answerChoices;
	}
	public Question() {
		super();
	}
	
	
	public Question(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String[] getAnswerChoices() {
		return answerChoices;
	}
	public void setAnswerChoices(String[] answerChoices) {
		this.answerChoices = answerChoices;
	}
	@Override
	public String toString() {
		return "\n Question [id=" + id + ", questionText=" + questionText + ", mark=" + mark + ", answerChoices="
				+ "\n"+Arrays.toString(answerChoices) + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return id == other.id;
	}
	
	

}
