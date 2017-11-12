import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

@WebServlet(urlPatterns = {"/getParam"})
public class getParam extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
          
            RConnection connection = null;
 
         try {
             connection = new RConnection();

             Float[] X = new Float[7], Y= new Float[7];
             for(int i=1;i<=7;i++)
             {
                 X[i-1]=Float.parseFloat(request.getParameter("x"+i));
                 Y[i-1]=Float.parseFloat(request.getParameter("y"+i));
             }
             
            String vectorX = "c("+request.getParameter("x1")+", "+request.getParameter("x2")+", "
+request.getParameter("x3")+", "+request.getParameter("x4")+", "+request.getParameter("x5")+", "+
request.getParameter("x6")+", "+request.getParameter("x7")+")";
            String vectorY = "c("+request.getParameter("y1")+", "+request.getParameter("y2")+", "
+request.getParameter("y3")+", "+request.getParameter("y4")+", "+request.getParameter("y5")+", "+
request.getParameter("y6")+", "+request.getParameter("y7")+")";
             
             connection.eval("lnX=" + vectorX);
             connection.eval("lnY=" + vectorY);
             connection.eval("dataA=data.frame(lnX,lnY)");
             connection.eval("result = lm(lnX ~ lnY, dataA)");

             double[] coefficients= connection.eval("result$coefficients").asDoubles();            
             String formula = String.format("y(x) = %.3f +(%.3f*x);",coefficients[0],coefficients[1]); 
             
             connection.eval("result = lm(lnX ~ lnY, dataA)");
             connection.eval("predictions <- predict(result,dataA)");
             double[] predictions= connection.eval("predictions").asDoubles();
             StringBuffer table = new StringBuffer();
             table.append("<table> <caption>Результаты</caption> <tr>");
             for(float i:Y) table.append("<td>"+i+"</td>");
             table.append("</tr><tr>");
             for(double i:predictions) table.append(String.format("<td>%.3f</td>",i));
             table.append("</tr>");
             table.append("</table>");
             
             connection.eval("png(file = \"C:/Users/Shark/Documents/NetBeansProjects/Regression/web/resourses/linearregression.png\")");
             connection.eval("plot(lnY,lnX,col = \"blue\",abline(result),cex = 1.3,pch = 16)");
             connection.eval("dev.off()");
             
             request.setAttribute("formula", formula);
             request.setAttribute("table", table);
             request.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(request, response);
             
         } catch (RserveException e) {
             e.getMessage();
             out.println("error of data");
         } catch (REXPMismatchException e) {e.getMessage(); out.println("error of compute");}
         finally{
             connection.close();
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
