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

@WebServlet("/addBatch")
public class AddBatchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String batchName = request.getParameter("batchName");
        String timetable = request.getParameter("timetable");

        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO batches (batch_name, timetable) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, batchName);
            ps.setString(2, timetable);

            int rows = ps.executeUpdate();
            if (rows > 0) {
            	response.sendRedirect(request.getContextPath() + "/pages/dashboard.html?message=Batch Added Successfully");
            } else {
                response.sendRedirect("pages/addBatch.jsp?error=Unable to Add Batch");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("pages/addBatch.jsp?error=Server Error");
        }
    }
}
