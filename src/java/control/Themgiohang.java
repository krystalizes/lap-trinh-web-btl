
package control;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Giohang;
import model.Taikhoan;

@WebServlet(name = "Themgiohang", urlPatterns = {"/Themgiohang"})
public class Themgiohang extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao=new DAO();
        HttpSession session=request.getSession();
        Taikhoan a=(Taikhoan) session.getAttribute("taikhoan");
        if (a == null){
            request.getRequestDispatcher("Login").forward(request, response);
        }else{
            int id=a.getId();
            a=dao.getTaikhoanbyID(id);
            request.setAttribute("detail", a);
            Taikhoan b=(Taikhoan) session.getAttribute("taikhoan");
            String name=b.getName();
            String sdt=b.getSdt();
            String dchi=b.getDchi();
            if(name==null||sdt==null||dchi==null){
                request.getRequestDispatcher("LoadeditAcc").forward(request, response);
            }
            String pid=request.getParameter("txt1");
            int id1=Integer.parseInt(pid);
            String soluong=request.getParameter("soluong");
            int soluong1=Integer.parseInt(soluong);
            Giohang c=dao.checkGiohang(id, id1);
            if(c==null){
                dao.themgiohang(id,id1,soluong1);
                request.getRequestDispatcher("Trangchu").forward(request, response);
            }else{
                request.getRequestDispatcher("Cart").forward(request, response);
            }
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
