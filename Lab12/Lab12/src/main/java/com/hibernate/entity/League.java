package com.hibernate.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "leagues")
public class League {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "league_id")
    private long leagueId;

	@NotNull
    private String name;
    private String description=null;

    @Column(name = "country_id")
    private Long countryId;
    public League(){ }

    public League(long leagueId)
    {
        this.leagueId = leagueId;
    }

    public League(String name, String description, Long countryId){
        this.name = name;
        this.description = description;
        this.countryId = countryId;
    }
    public long getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(long leagueId) {
		this.leagueId = leagueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
}

