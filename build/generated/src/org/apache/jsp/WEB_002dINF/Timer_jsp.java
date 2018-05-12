package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;;

public final class Timer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form>\n");
      out.write("            <div>\n");
      out.write("                <label>Start Time</label><br>\n");
      out.write("                <input type=\"text\" name=\"startTimeHours\" placeholder=\"Hours\"><br>\n");
      out.write("                <input type=\"text\" name=\"startTimeMinutes\" placeholder=\"Minutes\"><br>\n");
      out.write("                <input type=\"text\" name=\"startTimeSeconds\" placeholder=\"Seconds\"><br>\n");
      out.write("                <input type=\"text\" name=\"startTimeAm_Pm\" placeholder=\"AM/PM\"><br>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <label>End Time</label>\n");
      out.write("                <input type=\"text\" name=\"endTimeHours\" placeholder=\"Hours\"><br>\n");
      out.write("                <input type=\"text\" name=\"endTimeMinutes\" placeholder=\"Minutes\"><br>\n");
      out.write("                <input type=\"text\" name=\"endTimeSeconds\" placeholder=\"Seconds\"><br>\n");
      out.write("                <input type=\"text\" name=\"endTimeAm_Pm\" placeholder=\"AM/PM\"><br>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        ");

            Date date = new Date();
            System.out.print(date);
            response.setIntHeader("Response", 1000);
            Calendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR);
            int minutes = calendar.get(Calendar.MINUTE);
            int startHours = Integer.parseInt(request.getParameter("startTimeHours"));
            int startMinutes = Integer.parseInt(request.getParameter("startTimeMinutes"));
            String start_am_pm = request.getParameter("StartTimrAm_Pm");
            if (start_am_pm.equalsIgnoreCase("pm")) {
                startHours += 12;
            }
            int endHours = Integer.parseInt(request.getParameter("endTimeHours"));
            int endMinutes = Integer.parseInt(request.getParameter("endTimeMinutes"));
            String end_am_pm = request.getParameter("endTimeAm_Pm");
            if (end_am_pm.equalsIgnoreCase("pm")) {
                endHours += 12;
            }
            if (endHours > hour && startHours < hour) {
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function formActionAccept() {\n");
      out.write("        </script>\n");
      out.write("        <form action=\"index.html\">\n");
      out.write("            <input type=\"submit\" value=\"SUBMIT\">\n");
      out.write("        </form>\n");
      out.write("        <script>\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        ");
            } else if (endHours == hour) {
            if (minutes < endMinutes) {
        
      out.write("\n");
      out.write("        <script>  formActionAccept();</script>\n");
      out.write("        ");

        } else {
        
      out.write("\n");
      out.write("        <script>formActionExpired();</script>\n");
      out.write("        ");

            }
        } else if (startHours == hour) {
            if (minutes > startMinutes) {
        
      out.write("\n");
      out.write("        <script>formActionAccept();</script>\n");
      out.write("        ");

        } else {
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function formActionExpired() {\n");
      out.write("        </script>\n");
      out.write("        <form action=\"timeout.html\">\n");
      out.write("            <input type=\"submit\" value=\"SUBMIT\">\n");
      out.write("        </form>\n");
      out.write("        <script>}</script>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    }
    }catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
