package com.funfit.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.funfit.dao.DBConnection;
import com.funfit.model.Participant;

@WebServlet("/viewParticipants")
public class ViewParticipantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Participant> participants = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM participants";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // Populate the participant list
            while (rs.next()) {
                Participant participant = new Participant();
                participant.setId(rs.getInt("id"));
                participant.setName(rs.getString("name"));
                participant.setEmail(rs.getString("email"));
                participant.setPhone(rs.getString("phone"));
                participant.setBatchId(rs.getInt("batch_id"));
                participants.add(participant);
            }

         // Check if participants list is empty
            if (participants.isEmpty()) {
                System.out.println("No participants found in the database.");
            } else {
                System.out.println("Participants fetched: " + participants.size());
            }

            // Set the participant list as a request attribute
            request.setAttribute("participants", participants);

            // Forward to the JSP page
            request.getRequestDispatcher("pages/viewParticipants.jsp").forward(request, response);
        } catch (Exception e) {
            // Log the exception with the error message
            System.err.println("Error fetching participants: " + e.getMessage());
            e.printStackTrace();

            // Redirect to the dashboard with an error message
            response.sendRedirect("dashboard.html?error=Unable to fetch participants");
        }
    }
}
