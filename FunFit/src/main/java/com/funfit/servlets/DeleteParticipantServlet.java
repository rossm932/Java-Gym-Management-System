package com.funfit.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.funfit.dao.DBConnection;

/**
 * Servlet implementation class DeleteParticipantServlet
 */
@WebServlet("/deleteParticipant")
public class DeleteParticipantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection con = DBConnection.getConnection()) {
            String query = "DELETE FROM participants WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                response.sendRedirect("viewParticipants?message=Participant Deleted Successfully");
            } else {
                response.sendRedirect("viewParticipants?error=Unable to delete participant");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("viewParticipants?error=Server Error");
        }
    }
}
