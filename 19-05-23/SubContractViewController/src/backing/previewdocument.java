package backing;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.io.PrintWriter;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

public class previewdocument extends HttpServlet {
//    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    private  String CONTENT_TYPE = "text/html; charset=UTF-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
                                                           IOException {
        String fileName = (request.getParameter("fname"));
        CONTENT_TYPE=getServletContext().getMimeType(fileName);
        System.err.println("CONTENT_TYPE--->"+CONTENT_TYPE);
        OutputStream os = response.getOutputStream();
        Connection conn = null;
        try {
                    System.out.println("FileName is- " + fileName);
                    //Get database connection object
                    conn = getDBConnection("subcont");
                    //Prepare statement using SQL query to get blob file using file name
                    PreparedStatement statement =
                        conn.prepareStatement("SELECT ATTACHMENT FROM XXSC_ATTACHMENT WHERE ATTACH_ID = ?");
        statement.setString(1, fileName);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
                        Blob blob = rs.getBlob("ATTACHMENT");
                        BufferedInputStream in = new BufferedInputStream(blob.getBinaryStream());
                        int b;
                        byte[] buffer = new byte[10240];
//                        byte[] buffer = new byte[1048576];
                        while ((b = in.read(buffer, 0, 10240)) != -1) {
//                        while ((b = in.read(buffer, 0, 1048576)) != -1) {
                            os.write(buffer, 0, b);
                        }
                        os.close();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Inside Catch ::"+e);
                } finally {
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException e) {
                        }
                    }

                    if (os != null) {
                        os.close();
                    }
                }    
        response.setContentType(CONTENT_TYPE);
        response.setHeader("Content-Disposition", "inline; filename=\"" + fileName);

//        PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<head><title>previewdocument</title></head>");
//        out.println("<body>");
//        out.println("<p>The servlet has received a GET. This is the reply.</p>");
//        out.println("</body></html>");
//        out.close();
    }
    public static Connection getDBConnection(String datasource) throws SQLException,
           NamingException {
                   Connection con = null;
                   DataSource data = null;
                   Context initialContext = new InitialContext();
                   if (initialContext == null) {

                   }
                   data = (DataSource) initialContext.lookup(datasource);
                   if (data != null) {
                       con = data.getConnection();
                   } else {
                       System.out.println("Failed to Find JDBC DataSource.");
                   }
                   return con;
       }    
}
