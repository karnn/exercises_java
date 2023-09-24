package com.arun;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class ServletClass extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equals("/transactions")) {
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().print(ApplicationContext.objectMapper.writeValueAsString(ApplicationContext.transactionService.getTransactions()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equals("/transactions")) {
            double amount = Double.parseDouble(req.getParameter("amount"));
            String date = req.getParameter("date");
            String reference = req.getParameter("reference");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            Transaction transaction = new Transaction(UUID.randomUUID(), amount, reference, LocalDateTime.parse(date, formatter));
            ApplicationContext.transactionService.addTransaction(transaction);
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().print(ApplicationContext.objectMapper.writeValueAsString(transaction));
        }
    }
}
