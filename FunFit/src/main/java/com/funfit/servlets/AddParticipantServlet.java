package com.funfit.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.funfit.dao.DBConnection;

@WebServlet("/addParticipant")
public class AddParticipantServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Do get called");
	}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int batchId = Integer.parseInt(request.getParameter("batchId"));

        System.out.println("Name: " + name + ", Email: " + email + ", Phone: " + phone + ", Batch ID: " + batchId);

        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO participants (name, email, phone, batch_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setInt(4, batchId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
            	response.sendRedirect(request.getContextPath() + "/pages/dashboard.html?message=Participant Added Successfully");
            } else {
                response.sendRedirect("pages/addParticipant.jsp?error=Unable to Add Participant");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("pages/addParticipant.jsp?error=Server Error");
        }
    }
}
