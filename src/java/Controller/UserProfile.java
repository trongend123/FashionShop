/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.AccountDao;
import Model.Account;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class UserProfile extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserProfile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserProfile at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Account account = new Account();
        AccountDao accountDao = new AccountDao();

        String userId = request.getParameter("userId");
        String option = request.getParameter("optiton");

        // get user'info by userId 
        account = accountDao.getUserInforBuUserId(userId);
        if (option.equalsIgnoreCase("Profile")) {
            try ( PrintWriter out = response.getWriter()) {
                out.println("<form action=\"editUserProfile\" method=\"POST\" id=\"formEditProfile\">\n"
                        + "\n"
                        + "                    <table class=\"edit-table-profile\">\n"
                        + "\n"
                        + "                        <tr>\n"
                        + "                            <td> <label for=\"editNameId\">Your Name</label>\n"
                        + "                            </td>\n"
                        + "                            <td> <label for=\"editUserNameId\">User Name</label>\n"
                        + "                            </td>\n"
                        + "                        </tr>\n"
                        + "\n"
                        + "                        <tr>\n"
                        + "                            <td> <span id=\"textDanger-Name\" class=\"textdanger-edit\"></span>\n"
                        + "                            </td>\n"
                        + "                            <td>\n"
                        + "                                <span id=\"textDanger-userName\" class=\"textdanger-edit\"></span>\n"
                        + "                            </td>\n"
                        + "                        </tr>\n"
                        + "\n"
                        + "\n"
                        + "                        <tr>\n"
                        + "                            <td><input type=\"text\" name=\"editNameName\" id=\"editNameId\" value=\"" + account.getName() + "\">\n"
                        + "                            </td>\n"
                        + "                            <td>\n"
                        + "                                <input type=\"text\" name=\"editUserNameName\" id=\"editUserNameId\"  value=\"" + account.getUserName() + "\">\n"
                        + "                            </td>\n"
                        + "                        </tr>\n"
                        + "\n"
                        + "\n"
                        + "                        <tr>\n"
                        + "                            <td> <label for=\"editPhoneNumberId\">Phone Number</label>\n"
                        + "\n"
                        + "                            </td>\n"
                        + "                            <td> <label for=\"editEmailId\">Email</label>\n"
                        + "\n"
                        + "                            </td>\n"
                        + "                        </tr>\n"
                        + "                        <tr>\n"
                        + "                            <td> <span id=\"textDanger-phone\" class=\"textdanger-edit\"></span>\n"
                        + "\n"
                        + "                            </td>\n"
                        + "                            <td> <span id=\"textDanger-email\" class=\"textdanger-edit\"></span>\n"
                        + "\n"
                        + "                            </td>\n"
                        + "                        </tr>\n"
                        + "                        <tr>\n"
                        + "                            <td>\n"
                        + "                                <input type=\"text\" name=\"editPhoneNumberName\" id=\"editPhoneNumberId\" value=\"" + account.getPhoneNumber() + "\">\n"
                        + "                            </td>\n"
                        + "                            <td>\n"
                        + "                                <input type=\"text\" name=\"editEmailName\" id=\"editEmailId\" value=\"" + account.getEmail() + "\" >\n"
                        + "                            </td>\n"
                        + "                        </tr>\n"
                        + "\n"
                        + "                        <tr>\n"
                        + "                            <td><label for=\"editCityId\">City</label></td>\n"
                        + "                            <td><label for=\"editDistrictId\">District</label></td>\n"
                        + "                        </tr>\n"
                        + "                        <tr>\n"
                        + "                            <td><select name=\"editCityName\" id=\"editCityId\">\n"
                        + "                                    <option value=\"\">ha noi</option>\n"
                        + "                                </select></td>\n"
                        + "                            <td><select name=\"editDistrictname\" id=\"editDistrictId\">\n"
                        + "                                    <option value=\"\">ha noi</option>\n"
                        + "                                </select></td>\n"
                        + "                            </td>\n"
                        + "                        </tr>\n"
                        + "\n"
                        + "                        <tr>\n"
                        + "                            <td></td>\n"
                        + "                            <td> <span id=\"textDanger-addressDetails\" class=\"textdanger-edit\"></span></td>\n"
                        + "                        </tr>\n"
                        + "                        <tr>\n"
                        + "                            <td> <label for=\"editAddressId\">Address Details</label></td>\n"
                        + "                            <td><input type=\"text\" name=\"editAddressName\" id=\"editAddressId\" value=\"" + account.getAddress() + "\" ></td>\n"
                        + "                        </tr>\n"
                        + "                        <input type=\"hidden\" name=\"userId\" value=\"" + account.getUserId() + "\">\n"
                        + "\n"
                        + "\n"
                        + "                    </table>\n"
                        + "                </form>\n"
                        + "                <tr>\n"
                        + "                    <td><span class=\"editProfile-submit-button\"><button>Edit</button></span></td>\n"
                        + "                </tr>\n"
                        + "                <tr>\n"
                        + "                </tr>\n"
                        + "            </div>");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (option.equalsIgnoreCase("Account")) {
            try ( PrintWriter out = response.getWriter()) {
                out.print(" <form action=\"changePassServlet\" method=\"Post\" id=\"formChangePass\">\n"
                        + "                    \n"
                        + "                    <table class=\"edit-table-profile\">\n"
                        + "                        <tr>\n"
                        + "                            <td> <label for=\"editOldPassWordId\">Old Password</label>\n"
                        + "                            </td>\n"
                        + "\n"
                        + "                            <td> <label for=\"editNewPassWordId\">New Password</label>\n"
                        + "                            </td>\n"
                        + "                        </tr>\n"
                        + "\n"
                        + "                        <tr>\n"
                        + "                            <td> <span id=\"textDanger-oldPass\" class=\"textdanger-edit\"></span>\n"
                        + "                            </td>\n"
                        + "                            <td> <span id=\"textDanger-newPassWord\" class=\"textdanger-edit\"></span>\n"
                        + "\n"
                        + "                            </td>\n"
                        + "                        </tr>\n"
                        + "                        <tr>\n"
                        + "                            <td>\n"
                        + "                                <input type=\"password\" name=\"editOldPassWordName\" id=\"editOldPassWordId\">\n"
                        + "                            </td>\n"
                        + "                            <td>\n"
                        + "                                <input type=\"password\" name=\"editNewPassWordName\" id=\"editNewPassWordId\">\n"
                        + "                            </td>\n"
                        + "                        </tr>\n"
                        + "\n"
                        + "                    </table>\n"
                        + "                    <input type=\"hidden\" name=\"userId\" value=\"${sessionScope.account.getUserId()}\">\n"
                        + "                    \n"
                        + "                </form>\n"
                        + "\n"
                        + "                <tr>\n"
                        + "                    <td><span class=\"editProfile-submit-button\" id=\"changePass-submit-buttonId\"><button>Change</button></span></td>\n"
                        + "                </tr>\n"
                        + "                <tr>\n"
                        + "                </tr>\n"
                        + "            </div>\n"
                        + "");
            } catch (Exception e) {
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
