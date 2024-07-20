package com.training.bean.pack2;



public class Subject {
	
	
	int subjectId;
	String subjectName;
	int durationInHours;
	
	
	
	public Subject() {
		super();
	}



	public Subject(int subjectId) {
		super();
		this.subjectId = subjectId;
	}



	public Subject(String subjectName, int durationInHours) {
		super();
		this.subjectName = subjectName;
		this.durationInHours = durationInHours;
	}



	public Subject(int subjectId, String subjectName, int durationInHours) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.durationInHours = durationInHours;
	}



	public int getSubjectId() {
		return subjectId;
	}



	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}



	public String getSubjectName() {
		return subjectName;
	}



	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}



	public int getDurationInHours() {
		return durationInHours;
	}



	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}



	@Override
	public String toString() {
		return "\nSubject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", durationInHours="
				+ durationInHours + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subjectName == null) ? 0 : subjectName.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		return true;
	}



	
	
	
}
