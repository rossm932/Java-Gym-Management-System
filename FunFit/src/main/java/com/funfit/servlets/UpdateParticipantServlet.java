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
 * Servlet implementation class UpdateParticipantServlet
 */
@WebServlet("/updateParticipant")
public class UpdateParticipantServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int batchId = Integer.parseInt(request.getParameter("batchId"));

        try (Connection con = DBConnection.getConnection()) {
            String query = "UPDATE participants SET name = ?, email = ?, phone = ?, batch_id = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setInt(4, batchId);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                response.sendRedirect("viewParticipants");
            } else {
                response.sendRedirect("editParticipant.jsp?error=Unable to update participant");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("editParticipant.jsp?error=Server Error");
        }
    }
}
