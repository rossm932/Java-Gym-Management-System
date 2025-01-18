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
import java.util.ArrayList;
import java.util.List;

import com.funfit.dao.DBConnection;
import com.funfit.model.Batch;

@WebServlet("/viewBatches")
public class ViewBatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Batch> batches = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM batches";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            // Populate the batch list
            while (rs.next()) {
                Batch batch = new Batch();
                batch.setId(rs.getInt("id"));
                batch.setBatchName(rs.getString("batch_name"));
                batch.setTimetable(rs.getString("timetable"));
                batches.add(batch);
            }

            // Set the batch list as a request attribute
            request.setAttribute("batches", batches);

            // Forward to the JSP page
            request.getRequestDispatcher("pages/viewBatches.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("dashboard.html?error=Unable to fetch batches");
        }
    }
}
