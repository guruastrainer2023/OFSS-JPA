package com.training.bean.pack2;

import java.util.ArrayList;


import java.util.List;

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
@Table(name="books10")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
	@SequenceGenerator(name = "book_id_seq", sequenceName ="seq10", allocationSize = 1)
	private int id;
	
	@Column
	private String bookName;
	
	@Column
	private String authorName;
	
	@ElementCollection
	@CollectionTable(name ="books_topics_10")
	@OrderColumn(name = "idx")
	private List<String> topics;
	
	public Book(String bookName, String authorName) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.topics=new ArrayList<>();
	}

	public Book() {
		super();
		this.topics=new ArrayList<>();
	}
	
	
	
	public Book(int id) {
		super();
		this.id = id;
	}

	public void addTopic(String topic){
		this.topics.add(topic);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

	@Override
	public String toString() {
		return "\n Book [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", topics=" + topics + "]";
	}
	
	
	
	
}
