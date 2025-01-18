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
 * Servlet implementation class UpdateBatchServlet
 */
@WebServlet("/updateBatch")
public class UpdateBatchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String batchName = request.getParameter("batchName");
        String timetable = request.getParameter("timetable");

        try (Connection con = DBConnection.getConnection()) {
            String query = "UPDATE batches SET batch_name = ?, timetable = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, batchName);
            ps.setString(2, timetable);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                response.sendRedirect("viewBatches?message=Batch Updated Successfully");
            } else {
                response.sendRedirect("editBatch.jsp?error=Unable to update batch");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("editBatch.jsp?error=Server Error");
        }
    }
}
