package com.tanmay.Servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tanmay.Person;
import com.tanmay.Persons;

/**
 * Servlet implementation class RestClientServlet
 */
@WebServlet("/RestClientServlet")
public class RestClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RestClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String target = "http://localhost:8080/demorest/webresources/persons/person/"
					+ request.getParameter("name");
			URL url = new URL(target);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output = "", temp;
			System.out.println("Output from Server .... \n");

			while ((temp = br.readLine()) != null) {
				output += temp;
			}
//			output = output.substring(1, output.length() - 1);
			System.out.println("================ "+output);
				Gson gson = new Gson();
				try {
					Persons persons = gson.fromJson(output, Persons.class);
					List<Person> personlist = new ArrayList<Person>();
					if (persons != null)
						personlist = persons.getPerson();
					request.setAttribute("persons", personlist);
					RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
					rd.forward(request, response);
				} catch(Exception e) {
					output = output.substring(output.indexOf(':')+1, output.length()-1);
					System.out.println(output);
					Person person = gson.fromJson(output, Person.class);
					System.out.println(person);
					List<Person> personlist =  new ArrayList<Person>();
					personlist.add(person);
					request.setAttribute("persons", personlist);
					RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
					rd.forward(request, response);
				}
//		    for(Person p:personlist) {
//				System.out.println("id:"+p.getId());
//				System.out.println("name:"+p.getName());
//				System.out.println("mob_num:"+p.getMob_num());
//			}
//			ObjectMapper mapper = new ObjectMapper();
//			List<Person> persons = mapper.readValue(output, new TypeReference<List<Person>>(){});
//			for(Person p:persons) {
//				System.out.println("id:"+p.getId());
//				System.out.println("name:"+p.getName());
//				System.out.println("mob_num:"+p.getMob_num());
//			}
//				System.out.println("Inside Second");
//				Gson gson = new Gson();
//				Person person = gson.fromJson(output, Person.class);
//				List<Person> personlist = new ArrayList<Person>();
//				personlist.add(person);
////				SinglePerson singlePerson = new SinglePerson();
////				singlePerson = persons.getPersonSingle();
//				request.setAttribute("persons", personlist);
//				RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
//				rd.forward(request, response);
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		try {

			URL url = new URL("http://localhost:8080/demorest/webresources/persons/person");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{\"name\":\"" + request.getParameter("name") + "\",\"mob_num\":"
					+ request.getParameter("mob_num") + "}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

}
