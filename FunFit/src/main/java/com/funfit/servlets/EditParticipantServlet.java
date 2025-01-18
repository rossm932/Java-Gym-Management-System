package com.funfit.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.funfit.dao.DBConnection;
import com.funfit.model.Participant;

/**
 * Servlet implementation class EditParticipantServlet
 */
@WebServlet("/editParticipant")
public class EditParticipantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM participants WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Participant participant = new Participant();
                participant.setId(rs.getInt("id"));
                participant.setName(rs.getString("name"));
                participant.setEmail(rs.getString("email"));
                participant.setPhone(rs.getString("phone"));
                participant.setBatchId(rs.getInt("batch_id"));

                request.setAttribute("participant", participant);
                request.getRequestDispatcher("pages/editParticipant.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("dashboard.html?error=Unable to fetch participant details");
        }
    }
}
