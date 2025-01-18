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
import com.funfit.model.Batch;

@WebServlet("/editBatch")
public class EditBatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the batch ID from the request
        String batchIdParam = request.getParameter("id");

        // Validate batch ID parameter
        if (batchIdParam == null || batchIdParam.isEmpty()) {
            response.sendRedirect("viewBatches.jsp?error=Invalid Batch ID");
            return;
        }

        int batchId;
        try {
            batchId = Integer.parseInt(batchIdParam);
        } catch (NumberFormatException e) {
            response.sendRedirect("viewBatches.jsp?error=Invalid Batch ID Format");
            return;
        }

        // Fetch batch details from the database
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM batches WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, batchId);

            ResultSet rs = ps.executeQuery();

            // If batch exists, forward to the editBatch.jsp
            if (rs.next()) {
                Batch batch = new Batch();
                batch.setId(rs.getInt("id"));
                batch.setBatchName(rs.getString("batch_name"));
                batch.setTimetable(rs.getString("timetable"));

                request.setAttribute("batch", batch);
                request.getRequestDispatcher("pages/editBatches.jsp").forward(request, response);
            } else {
                response.sendRedirect("viewBatches.jsp?error=Batch Not Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("viewBatches.jsp?error=Error fetching batch details");
        }
    }
}
