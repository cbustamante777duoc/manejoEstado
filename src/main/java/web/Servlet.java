
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
         //Simulacion de valores correctos
         String usuarioOk = "Cristian";
         String passwordOK = "1234";
         
         //Recibir los paramentros de la web
         String usuario = request.getParameter("usuario");
         String password = request.getParameter("password");
         
         //imprimir en html
         PrintWriter out = response.getWriter();
         
         //validacion
         if (usuarioOk.equals(usuario) && passwordOK.equals(password)) {
            out.print("<h1>");
            out.print("Datos correctos ");
            out.print("<br> Usuario: "+usuario);
            out.print("<br> password: "+password);
            
            out.print("</h1>");
        }
        else{
             response.sendError(response.SC_UNAUTHORIZED,"Las credenciales son incorrectas");
        }
         out.close();
     }
}
