package com.pms.app.filters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.pms.app.models.Customer;
import com.pms.app.services.CustomerService;
import com.pms.app.utils.CryptoUtil;
import com.pms.app.utils.JsonParser;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;


public class AuthFilter implements Filter {



    private  final JsonParser<Map<String,Object>> jsonParser = new JsonParser<Map<String,Object>>();

    public void doFilter(ServletRequest servletRequest , ServletResponse servletResponse , FilterChain filterChain) throws ServletException , IOException{
        HttpServletRequest request = (HttpServletRequest)  servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String authHeader = request.getHeader("Authorization");

        if(authHeader==null){
                jsonParser.getErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "must login to application before any usage");
                return;
        }


        String jsonStringFromHeader = authHeader.split("##")[1];
        System.out.println(jsonStringFromHeader);
        System.out.println(authHeader);


        Map<String,Object> customerMap;
        String token = jsonStringFromHeader;

        String customerMappedString = CryptoUtil.decrypt(token);

        try {

             customerMap = jsonParser.StringToJsonByTypeRef(customerMappedString, new TypeReference<Map<String,Object>>() {
             });
            System.out.println(customerMap);
//            Object userIdObj = customerMap.get("user_id");
//            Integer userId;
//
//            if (userIdObj instanceof Integer) {
//                userId = (Integer) userIdObj;
//            } else if (userIdObj instanceof String) {
//                userId = Integer.parseInt((String) userIdObj);
//            } else {
//                jsonParser.getErrorResponse(response, 400, "Invalid user_id in token");
//                return;
//            }

//            Optional<Customer> customer =  customerService.getCustomerById( userId );
//            if(customer.isEmpty()){
//                  jsonParser.getErrorResponse(response , 404 , "User not found from auth Filter");
//            }
            request.setAttribute("loggedInUser" , customerMap);
            filterChain.doFilter(request,response);

        }catch (JsonProcessingException exp){
            System.out.println("exception while parsing the json at AuthFilter");
            jsonParser.getErrorResponse(response,HttpServletResponse.SC_BAD_REQUEST,"Invalid Customer" );
        }

    }
}
