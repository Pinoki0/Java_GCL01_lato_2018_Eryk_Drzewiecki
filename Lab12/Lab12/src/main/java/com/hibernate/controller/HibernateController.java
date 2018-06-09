package com.hibernate.controller;
import com.hibernate.dao.*;
import com.hibernate.entity.Club;
import com.hibernate.entity.Country;
import com.hibernate.entity.League;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.Optional;

@Controller
public class HibernateController {

	 @Autowired
	    private ClubDao clubDao;

	    @Autowired
	    private LeagueDao leagueDao;

	    @Autowired
	    private CountryDao countryDao;
	    
	@GetMapping("/panel")
	public String getPanel(Model model) {
	  return "panel";
	}
	@PostMapping("/panel")
	public String backPanel(Model model) {
		return "redirect:/panel";
	}
	@PostMapping("/allClubs")
	public String allClubs(Model model)
	{
		model.addAttribute("clubs", clubDao.findAll());
		return "allClubs";
	}
	@PostMapping("/allLeagues")
	public String allLeagues(Model model)
	{
		model.addAttribute("leagues", leagueDao.findAll());
		return "allLeagues";
	}
	@PostMapping("/allCountries")
	public String allCountries(Model model)
	{
		model.addAttribute("countries", countryDao.findAll());
		return "allCountries";
	}
	@PostMapping("/addClub")
	public String addClub(Model model)
	{
		model.addAttribute("clubs", clubDao.findAll());
		return "addClub";
	}
	@PostMapping("/addClub2")
	public String addClub2(String name, String manager)
	{
		Club club = new Club(name,manager);
        clubDao.save(club);
        return "redirect:/panel";
	}
	@PostMapping("/addLeague")
	public String addLeague(Model model)
	{
		model.addAttribute("leagues", leagueDao.findAll());
		return "addLeague";
	}
	@PostMapping("/addLeague2")
	public String addLeague2(String name, String description, Long countryId)
	{
		System.out.println(countryId);
		League league = new League(name, description, countryId);
		leagueDao.save(league);
		return "redirect:/panel";
	}
	@PostMapping("/addCountry")
	public String addCountries(Model model)
	{
		model.addAttribute("countries", countryDao.findAll());
		return "addCountry";
	}
	@PostMapping("/addCountry2")
	public String addCountry2(String name, String description)
	{
		Country country = new Country(name, description);
		countryDao.save(country);
		return "redirect:/panel";
	}
	@PostMapping("/removeClub")
	public String removeClub(Long index)
	{
		if(clubDao.existsById(index) != false){
			Optional<Club> ca = clubDao.findById(index);
			Club clubRemove = ca.get();
				clubDao.delete(clubRemove);
			}
		return "redirect:/panel";
	}
	@PostMapping("/removeLeague")
	public String removeLeague(Long index)
	{
		if(leagueDao.existsById(index) != false){
			Optional<League> ca = leagueDao.findById(index);
			League leagueRemove = ca.get();
				leagueDao.delete(leagueRemove);
			}
		return "redirect:/panel";
	}
	@PostMapping("/removeCountry")
	public String removeCountry(Long index)
	{
		if(countryDao.existsById(index) != false){
		Optional<Country> ca = countryDao.findById(index);
		Country countryRemove = ca.get();
			countryDao.delete(countryRemove);
		}
		return "redirect:/panel";
	}
	@PostMapping("/updateClub")
	public String updateClub(Long index,Model model)
	{
		if(clubDao.existsById(index) != false)
		{
			model.addAttribute("index", index);
			return "updateClub";
		}
		return "redirect:/panel";
	}
	@PostMapping("/updateClub2")
	public String updateClub2(String name, String manager, Long index)
	{
		Club club = clubDao.findById(index).get();
		club.setName(name);
		club.setManager(manager);
		clubDao.save(club);
		return "redirect:/panel";
	}
	@PostMapping("/updateLeague")
	public String updateLeague(Long index,Model model)
	{
		if(leagueDao.existsById(index) != false)
		{
			model.addAttribute("index", index);
			return "updateLeague";
		}
		return "redirect:/panel";
	}
	@PostMapping("/updateLeague2")
	public String updateLeague2(String name, String description, Long countryId, Long index)
	{
		League league= leagueDao.findById(index).get();
		league.setName(name);
		league.setDescription(description);
		league.setCountryId(countryId);
		leagueDao.save(league);
		return "redirect:/panel";
	}
	@PostMapping("/updateCountry")
	public String updateCountry(Long index,Model model)
	{
		if(countryDao.existsById(index) != false)
		{
			model.addAttribute("index", index);
			return "updateCountry";
		}
		return "redirect:/panel";
	}
	@PostMapping("/updateCountry2")
	public String updateCountry2(String name, String description, Long index)
	{
		Country country = countryDao.findById(index).get();
		country.setName(name);
		country.setDescription(description);
		countryDao.save(country);
		return "redirect:/panel";
	}
}
