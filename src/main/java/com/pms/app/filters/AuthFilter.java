package com.pms.app.filters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pms.app.models.Customer;
import com.pms.app.utils.JsonParser;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class AuthFilter implements Filter {

    @Autowired
    JsonParser<Customer> jsonParser;
    public void doFilter(ServletRequest servletRequest , ServletResponse servletResponse , FilterChain filterChain) throws ServletException , IOException{
        HttpServletRequest request = (HttpServletRequest)  servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String authHeader = request.getHeader("Authorization");

        if(authHeader==null){
                jsonParser.getErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "must login to application before any usage");
                return;
        }


        String jsonStringFromHeader = authHeader.split(" ")[1];
        Customer customer = null;
        try {
             customer = jsonParser.StringToJson(jsonStringFromHeader , Customer.class);
        }catch (JsonProcessingException exp){
            System.out.println("exception while parsing the json at AuthFilter");
            jsonParser.getErrorResponse(response,HttpServletResponse.SC_BAD_REQUEST,"Invalid Customer" );
            return;
        }

        // how to access logged in user in the controller
        request.setAttribute("loggedInUser" , customer);
        filterChain.doFilter(request,response);
        return;
    }
}
