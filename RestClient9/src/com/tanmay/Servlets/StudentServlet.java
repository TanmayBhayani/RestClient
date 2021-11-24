package com.tanmay.Servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tanmay.Student;
import com.tanmay.Students;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String target = "http://localhost:8080/demorest/webresources/students/student/"+ request.getParameter("name");
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
			System.out.println("================ "+output);
			output = output.substring(output.indexOf(':')+1, output.length()-1);
			System.out.println("================ "+output);
				Gson gson = new Gson();
				if(!output.equals("nul")) {
					try {
						Student[] studentarray = gson.fromJson(output, Student[].class);
						ArrayList<Student> studentlist = new ArrayList<Student>();
						for(Student std:studentarray) {
							studentlist.add(std);
						}
						request.setAttribute("students", studentlist);
						RequestDispatcher rd = request.getRequestDispatcher("/SearchResult.jsp");
						rd.forward(request, response);
					} catch(Exception e) {
						Student student = gson.fromJson(output, Student.class);
						System.out.println(student);
						List<Student> studentlist =  new ArrayList<Student>();
						studentlist.add(student);
						request.setAttribute("students", studentlist);
						RequestDispatcher rd = request.getRequestDispatcher("/SearchResult.jsp");
						rd.forward(request, response);
					}
					conn.disconnect();
				}
				else {
					request.setAttribute("students", new ArrayList<Student>());
					RequestDispatcher rd = request.getRequestDispatcher("/SearchResult.jsp");
					rd.forward(request, response);
				}
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			URL url = new URL("http://localhost:8080/demorest/webresources/students/student");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/json"); 
			Student s = new Student(request.getParameter("name"),request.getParameter("city"),request.getParameter("email"),request.getParameter("sex"),Integer.parseInt(request.getParameter("age")),Integer.parseInt(request.getParameter("marks")));
			//String input = "{\"name\":\""+request.getParameter("name")+"\",\"city\":\""+request.getParameter("city")+"\",\"email\":\""+request.getParameter("email")+"\",\"sex\":\""+request.getParameter("sex")+"\",\"age\":"+request.getParameter("age")+",\"marks\":"+request.getParameter("marks")+"}";
			String json = (new Gson().toJson(s));
			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes());
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


