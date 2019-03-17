package com.library.model.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * This class is responsible for creating Addresses which are then stored with each Customer.
 * 
 * NOTE: Rearranged the class to fit the conventional order of methods/variables.
 * @author: Veeral Patel
 */
public class Movie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//This is the title of the Movie.
	private String title;
	
	//This is the year the movie was released.
	private int releaseYear;
	
	//This is a boolean to specify if the movie is available or not.
	private boolean availibility;
	
	//This is the catalog Number, this is required to rent the movie.
	private long catalogNumber;
	
	//If rented, this is the date the Movie is due again at the library.
	private Date returnDate;
	
	
	/**
	* This is the constructor. For every Movie object that gets created, this method is called and requires these parameters.
	*/
	public Movie(String title, int releaseYear, long catalogNumber) {
		super();
		this.title = title.toLowerCase();
		this.releaseYear = releaseYear;
		this.availibility = true;
		this.catalogNumber = catalogNumber;
		this.returnDate = null;
	}

	/**ß
	* Validate if the instance variables are valid
	* 
	* @return boolean - true if instance variables are valid, else false
	*/
		public boolean validate () {
			
			if (releaseYear == 0.0) return false;
			if (catalogNumber == 0.0) return false;
			if (title == null) return false;
			if (returnDate != null) return false;
		    if (availibility = false) return false;
			return true;
		}	
	
	/**
	* Until the next comments, all these methods are getters and setters. Which mean that they get and set values for
	* objects that are within the class.
	*/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public boolean isAvailibility() {
		return availibility;
	}
	public void setAvailibility(boolean availibility) {
		this.availibility = availibility;
	}
	public long getCatalogNumber() {
		return catalogNumber;
	}
	public void setCatalogNumber(long catalogNumber) {
		this.catalogNumber = catalogNumber;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	
	/**
	* This is the equals() method. This method will check if two objects within the class are identical to each other.
	* 
	*/	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (availibility != other.availibility)
			return false;
		if (catalogNumber != other.catalogNumber)
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	/**
	* This is the hashCode() method. This is mainly used for hashing collections such as a HashMap, which is not used here.
	* 
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (availibility ? 1231 : 1237);
		result = prime * result + (int) (catalogNumber ^ (catalogNumber >>> 32));
		result = prime * result + releaseYear;
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}	
	
	/**
	* This is the toString() method. This method turns an Movie object into a string that can be read at runtime if invoked.
	* 
	*/
	@Override
	public String toString() {
		return "Movie [title=" + title + ", releaseYear=" + releaseYear + ", availibility=" + availibility
				+ ", catalogNumber=" + catalogNumber + ", returnDate=" + returnDate + "]";
	}
	
	
}
