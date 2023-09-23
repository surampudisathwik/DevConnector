package com.dnb.DevConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.DevConnector.dto.Education;
import com.dnb.DevConnector.dto.Experience;
import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.dto.User;
import com.dnb.DevConnector.exceptions.InvalidEmailException;
import com.dnb.DevConnector.exceptions.InvalidPasswordException;
import com.dnb.DevConnector.services.ProfileService;
import com.dnb.DevConnector.services.UserService;

@SpringBootApplication
public class DevConnectorApplication {
	@Autowired
	private static UserService userService;
	@Autowired
	private static ProfileService profileService;
	static int choice=-1;
	public static void main(String[] args) throws InvalidEmailException, InvalidPasswordException {
		
		ApplicationContext applicationContext =SpringApplication.run(DevConnectorApplication.class, args);
	}
}
//		userService = applicationContext.getBean(UserService.class);
//		profileService = applicationContext.getBean(ProfileService.class);
//		do {
//			System.out.println("Select the required operation among below operations :");
//			System.out.println("1.Create User ");
//			System.out.println("2.Delete User ");
//			System.out.println("3.Get All Users ");
//			System.out.println("4.Get an user ");
//			System.out.println("5.Create Profile ");
//			System.out.println("6.Delete Profile ");
//			System.out.println("7.Get All Profiles ");
//			System.out.println("8.Get an Profile ");
//			System.out.println("9.Exit!");
//			choice=sc.nextInt();
//			switch(choice) {
//			case 1: {
//				User res = new User("surampudi@gmail.com","Uma1@asdfghjkl","Password");
//				createUser(res);
//				break;
//			}
//			case 2:{
//				deleteUser("surampudi1@gmail.com");
//				break;
//			}
//			case 3:{
//				getAll();
//				break;
//			}
//			case 4:{
//				getUser("surampudi1@gmail.com");
//				break;
//			}
//			case 5:{
//				createProfile(new Profile(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next()));
//				break;
//			}
//			case 6:{
//				deleteProfile(sc.next());
//				break;
//			}
//			case 7:{
//				getAllProfile();
//				break;
//			}
//			case 8:{
//				
//				getProfile(sc.next());
//				break;
//			}
//			}
//			
//		}while(choice!=9);
//		
//	}
//	private static void getProfile(String next) {
////		Optional<Profile> result = profileService.getProfileById(next);
////		if (result.isPresent()) {
////    		Profile profile1 = result.get();
////    		System.out.println(profile1.getBio() + " " + profile1.getLocation()+ " " + profile1.getName()+" "+profile1.getOccupation()+" "+profile1.getSkill()+" "+profile1.getEducation()
////    		+" "+profile1.getExperience()+" "+profile1.getGitHub());
////    		}else{
//    		//System.out.println("No user found for this " + next + " name.");
//    		//}
//		
//	}
//	private static void getAllProfile() {
//		// TODO Auto-generated method stub
////		profileService.getAllProfiles().forEach(profile-> { System.out.println
////	    	(profile.getName() + " " + profile.getLocation() + " " + profile.getBio()+" "+ profile.getOccupation()+" "+profile.getSkill()+" "+profile.getEducation()+" "
////	    			+profile.getExperience()+" "+profile.getGitHub());
////	         });
//		
//	}
//	private static void deleteProfile(String next) {
//		// TODO Auto-generated method stub
//		boolean ans= profileService.deleteProfileById(next);
//		System.out.println(ans);
//		
//	}
//	private static void createProfile(Profile profile) {
//		profileService.createProfile(profile);
//		System.out.println("Profile created");
//		
//	}
//	public static void getAll()
//	{
//	userService.getAllUsers().forEach(user-> { System.out.println
//    	(user.getUserMail() + " " + user.getUserName() + " " + user.getPassword());
//         });
//	}
//	public static void createUser(User user)
//	{
//		userService.createUser(user);
//		System.out.println("USer is being created");
//	}
//	public static void deleteUser(String email) throws InvalidEmailException
//	{
//		boolean ans= userService.deleteUserByMail(email);
//		System.out.println("Delete Status :"+ans);
//	}
//	public static void getUser(String mail)
//	{
//		Optional<User> result = userService.getUserBymail(mail);
//		if (result.isPresent()) {
//    		User user1 = result.get();
//    		System.out.println(user1.getUserName() + " " + user1.getUserMail() + " " + user1.getPassword());
//    		}else{
//    		System.out.println("No user found for this " + mail + " mail id.");
//    		}
//		}
