package services.servlets;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.ServicesTools;


public class RemoveFriend extends HttpServlet {
	//This is generated by eclipse don't think we need it. But we never know
	private static final long serialVersionUID = 1L;
	public RemoveFriend() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Param

		String key = request.getParameter("key");
		String id_friend = request.getParameter("id_friend");

		//Reponse creation
		PrintWriter out = response.getWriter();

		//Send to service
		JSONObject json = null;
		try {
			json = ServicesTools.removeFriend(key,id_friend);
		} 
		catch (JSONException e) {

			e.printStackTrace();
		}

		//Response
		out.print(json.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//To Complete
	}

}