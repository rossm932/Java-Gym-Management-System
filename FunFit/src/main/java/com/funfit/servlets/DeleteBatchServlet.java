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

@WebServlet("/deleteBatch")
public class DeleteBatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the batch ID from the request
        String batchIdParam = request.getParameter("id");

        // Validate the batch ID parameter
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

        // Delete the batch from the database
        try (Connection con = DBConnection.getConnection()) {
            String query = "DELETE FROM batches WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, batchId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                response.sendRedirect("pages/viewBatches.jsp?message=Batch Deleted Successfully");
            } else {
                response.sendRedirect("pages/viewBatches.jsp?error=Batch Not Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("pages/viewBatches.jsp?error=Error Deleting Batch");
        }
    }
}
