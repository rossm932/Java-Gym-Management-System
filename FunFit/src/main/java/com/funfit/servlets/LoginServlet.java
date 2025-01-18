package com.funfit.servlets;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.funfit.dao.DBConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Replace these with your actual MySQL root credentials
        String rootUsername = "root";
        String rootPassword = "root1234!"; // Replace with your MySQL root password

        if (username.equals(rootUsername) && password.equals(rootPassword)) {
            try (Connection con = DBConnection.getConnection()) {
                // Test connection to validate credentials
                if (con != null) {
                    response.sendRedirect("pages/dashboard.html");
                } else {
                    response.sendRedirect("index.html?error=Database Connection Failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("index.html?error=Server Error");
            }
        } else {
            // Invalid credentials
            response.sendRedirect("index.html?error=Invalid Username or Password");
        }
    }
}
