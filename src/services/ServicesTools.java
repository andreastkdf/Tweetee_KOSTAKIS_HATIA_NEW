package services;


import org.json.JSONException;
import org.json.JSONObject;

import services.traitement.GenerateKey;

public class ServicesTools {
	public static JSONObject createUser(String login, String password,
			String firstname,String lastname) throws JSONException{

		JSONObject json= new JSONObject();
		try
		{
			if(login==null||password==null||firstname==null||lastname==null)
				return(error("Wrong Arguments for createUser",0));
			//boolean login_ok=bd.AuthentificationTools.userExists(login); if true send error 1
			synchronized ("create"){
				//bd.AuthentificationTools.addUser(login,password);
				json.put("User created",login);
			}
		}
		catch (JSONException e)
		{
			return(error("JSON Problem "+e.getMessage(),100));
		}
		return json;
	}

	public static JSONObject logout(String key) throws JSONException{

		JSONObject json= new JSONObject();
		try
		{
			if(key==null)
				return(error("Wrong arguments for logout",0));
			synchronized ("logout"){ //logout traitement 
				json.put("logout ok",key);
			}
		}		
		catch (JSONException e)
		{
			return(error("JSON Problem "+e.getMessage(),100));
		}		
		return json;
	}
	public static JSONObject loginUser(String login, String password) throws JSONException
	{
		JSONObject json = new JSONObject();
		try
		{
			if(login==null||password==null)
				return error("Wrong arguments for login service",0);
			//boolean (!is_user = bd.AuthentificationTools.userExists(login);
			//return error("Uknown user "+login,1);
			synchronized("login")
			{
				String key=GenerateKey.generateSessionKey();
				json.put("logged in", "login:"+login+"session_key:"+key);
			}
		}
		catch(JSONException e)
		{
			return(error("JSON Problem"+e.getMessage(),100));
		}
		return json;
	}
	public static JSONObject addComment(String key, String text) throws JSONException
	{
		JSONObject json = new JSONObject();
		try
		{
			if(text==null||key==null)
				return(error("Wrong arguments for comment service",0));
			synchronized("Comment")
			{
				//I have no idea why there is an init key=1
				//int key=1;
				json.put("comment posted",text);
			}
		}catch (JSONException e){
			return(error("JSON Problem"+e.getMessage(),100));
		}
		return json;
	}

	public static JSONObject removeFriend(String key, String id_friend) throws JSONException
	{
		JSONObject json = new JSONObject();
		try
		{
			if(key==null||id_friend==null)
				return(error("Wrong Arguments for removeFriend "+id_friend,0));

			synchronized("login")
			{
				//I have no idea why there is an init key=1
				//int key=1;
				json.put("friend removed",id_friend);
			}
		}catch (JSONException e){
			return(error("JSON Problem"+e.getMessage(),100));
		}

		return json;
	}

	public static JSONObject addFriend(String key, String id_friend) throws JSONException
	{
		JSONObject json = new JSONObject();
		try
		{
			if(key==null||id_friend==null)
				return(error("Wrong arguments for addFriend "+id_friend,0));

			synchronized("addFriend")
			{
				json.put("Friend added",id_friend);
			}
		}catch (JSONException e){
			return(error("JSON Problem "+e.getMessage(),100));
		}
		return json;
	}

	public static JSONObject error(String error, int error_id ) throws JSONException{
		JSONObject json = new JSONObject();
		try
		{
			json.put(error,error_id);
		}catch (JSONException e){
			e.printStackTrace();
		}	
		return json;
	}
}
