package com.example.etracker.Controller;



import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.etracker.Model.User;
import com.example.etracker.Service.Etracker_Service;
import com.example.etracker.utils.PathRoutes;


@RestController
@RequestMapping(PathRoutes.SearchSQL.SEARCHSQL_ROOT)
public class Etracker_Controller {
	
	@Autowired
	private Etracker_Service exp;
	
	@GetMapping(PathRoutes.SearchSQL.TOTAL_BAR_YEAR)
	public Map<String, java.lang.Object> graph1(@RequestParam int userId ,int year, int month ){
		return exp.graph1(userId,year);
	}
	
	@GetMapping(PathRoutes.SearchSQL.TOTAL_BAR_MONTH)
	public Map<String, java.lang.Object> graph2(@RequestParam int userId, int year, int month ){
		return exp.graph2(userId,year,month);
	}
	@GetMapping(PathRoutes.SearchSQL.TOTAL_LINE_YEAR)
	public Collection<Map<String,java.lang.Object>>  graph3(@RequestParam int userId, int year, int month ){
		return exp.graph3(userId,year);
	}
	@GetMapping(PathRoutes.SearchSQL.TOTAL_LINE_MONTH)
	public Collection<Map<String,java.lang.Object>> graph4(@RequestParam int userId, int year, int month ){
		return exp.graph4(userId,year,month);
	}
	@GetMapping(PathRoutes.SearchSQL.CATEGORY_BAR_MONTH)
	public List<Map<String, Object>> monthlycategorysum(@RequestParam int userId,int month,int year)
	{
		return exp.monthlycategorysum(userId,month,year);
	}
	@GetMapping(PathRoutes.SearchSQL.CATEGORY_BAR_YEAR)
	public List<Map<String, Object>> yearlycategorysum(@RequestParam int userId, int year,int month)
	{
		return exp.yearlycategorysum(userId,year);
	}


	
	@PostMapping(PathRoutes.SearchSQL.ADD_INCOME)
	 public void addincome(@RequestParam int userId,@RequestParam String item,@RequestParam int categoryId,@RequestParam double amount,@RequestParam String transactionDate ) {
	 exp.addincome(userId,item,categoryId,amount,transactionDate);
	 }
	@PostMapping(PathRoutes.SearchSQL.ADD_EXPENSE)
	 public void addexpense(@RequestParam int userId,@RequestParam String item,@RequestParam int categoryId,@RequestParam double amount,@RequestParam String transactionDate ) {
	 exp.addexpense(userId,item,categoryId,amount,transactionDate);
	 }
	
	@PostMapping(PathRoutes.SearchSQL.ADD_INCOME_CATEGORY)
	 public void addincomecategory(@RequestParam String categoryName, @RequestParam int userId ) {
	 exp.addincomecategory(categoryName, userId);
	 }
	@PostMapping(PathRoutes.SearchSQL.ADD_EXPENSE_CATEGORY)
	 public void addexpensecategory(@RequestParam String categoryName, @RequestParam int userId ) {
	 exp.addexpensecategory(categoryName, userId);
	 }
	
	
	
	
	
	
	@GetMapping(PathRoutes.SearchSQL.LIST_CATEGORY_EXPENSE)
	public List<Map<String, Object>> liscategoryexpense(@RequestParam int userId)
	{
		return exp.liscategoryexpense(userId);
	}
	@GetMapping(PathRoutes.SearchSQL.LIST_CATEGORY_INCOME)
	public List<Map<String, Object>> liscategoryincome(@RequestParam int userId)
	{
		return exp.liscategoryincome(userId);
	}
	
	
	@GetMapping(PathRoutes.SearchSQL.GET_INCOME)
	public Collection<Map<String,Object>> getIncome(@RequestParam int userId){
		return exp.getIncome(userId);
	}
	

	@GetMapping(PathRoutes.SearchSQL.GET_EXPENSE)
	public Collection<Map<String,Object>> getExpense(@RequestParam int userId){
		return exp.getExpense(userId);
	}
	
	@GetMapping(PathRoutes.SearchSQL.GET_INCOME_EXPENSE)
	public Collection<Map<String,Object>> getIncomeExpense(@RequestParam int userId){
		return exp.getIncomeExpense(userId);
	}

	@PostMapping
	public int addUser(@RequestBody User user ) {
		 exp.addUser(user.getId(),user.getName(),user.getEmailId(),user.getPassword());
			
return 1;
		
		
	}
	@GetMapping(PathRoutes.SearchSQL.GET_EMAIL_PASSWORD)
	public List<User> getUser(@PathVariable String emailId,@PathVariable String password) {
		return exp.getUser(emailId,password);
	}
	@PutMapping(PathRoutes.SearchSQL.GET_EMAIL_PASSWORD)
	public int resetPassword(@PathVariable String emailId,@PathVariable String password) {
		return exp.resetPassword(emailId,password);
	}
	
	
}