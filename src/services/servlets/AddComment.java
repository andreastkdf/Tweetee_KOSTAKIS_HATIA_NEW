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

public class AddComment extends HttpServlet {
	//This is generated by eclipse don't think we need it. But we never know
	private static final long serialVersionUID = 1L;
	public AddComment() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Param

		String key = request.getParameter("key");
		String text = request.getParameter("text");

		//Reponse creation
		PrintWriter out = response.getWriter();

		//Send to service
		JSONObject json = null;
		try {
			json = ServicesTools.addComment(key,text);
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