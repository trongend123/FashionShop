/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseAuthentic;

import Model.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author win
 */
public abstract class BaseAuthentication extends HttpServlet{

       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(isAuthenticated(req)){
            processPost(req, resp);
        }else{
            resp.getWriter().println("access denied");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        if(isAuthenticated(req)){
            
            processGet(req, resp);
        }else{
            resp.getWriter().println("access denied");
        }   
    }
     public abstract void processGet(HttpServletRequest request, HttpServletResponse response);
    public abstract void processPost(HttpServletRequest request, HttpServletResponse response);
    public boolean isAuthenticated(HttpServletRequest req){
        Account a= (Account) req.getSession().getAttribute("account");
        int aid= Integer.parseInt(req.getParameter("aid"));
        int role= a.getRole();
        if(role!=aid+1 && role!=1){
            return false;
        }else if(role==aid+1|| role==1){
            return true;
        }
        
        return false;
    }
    
}
