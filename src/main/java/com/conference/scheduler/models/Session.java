package com.conference.scheduler.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author dhruba
 *This class will represent a single row of sessions table
 */
@Entity(name = "sessions")
public class Session {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long session_id;
	
	private String session_name;
	private String session_description;
	private Integer session_length;
	
	@ManyToMany
	@JoinTable(
			name = "session_speakers",
			joinColumns = @JoinColumn(name="session_id"),
			inverseJoinColumns = @JoinColumn(name="speaker_id"))
	private List<Speaker> speakers;
	
	// This helps in serialization and deserialization
	public Session() {
	}

	public Long getSession_id() {
		return session_id;
	}

	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}

	public String getSession_name() {
		return session_name;
	}

	public void setSession_name(String session_name) {
		this.session_name = session_name;
	}

	public String getSession_description() {
		return session_description;
	}

	public void setSession_description(String session_description) {
		this.session_description = session_description;
	}

	public Integer getSession_length() {
		return session_length;
	}

	public void setSession_length(Integer session_length) {
		this.session_length = session_length;
	}
	
	

}
