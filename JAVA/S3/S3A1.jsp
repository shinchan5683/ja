<%@ page contentType="text/html" language="java" import="java.sql.*" %>
<html>
<head>
    <title>Patient Details</title>
</head>
<body>
    <h1>Patient Details</h1>
    <table boder="1">
        <thead>
            <tr>
                <th>Patient Number</th>
                <th>Name</th>
                <th>Address</th>
                <th>Age</th>
                <th>Disease</th>
            </tr>
        </thead>
        <tbody>
            <%
                String dbUrl = "jdbc:postgresql://localhost/tyjdbc";
                String dbUsr = "root";
                String dbPwd = "root";
                Connection con = null;
                Statement stmt = null;
                ResultSet rs = null;
                try{
                    Class.forName("org.postgresql.Driver");
                    con = DriverManager.getConnection(dbUrl,dbUsr,dbPwd);
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(select * from Patient);
                    while(rs.next()){
                        String pNo = rs.getString("pno");
                        String pName = rs.getString("pname");
                        String address = rs.getString("address");
                        String age = rs.getString("age");
                        String disease = rs.getString("disease");
            %>

                    <tr>
                        <td><%= pNo %></td>
                        <td><%= pName %></td>
                        <td><%= address %></td>
                        <td><%= age %></td>
                        <td><%= disease %></td>
                    </tr>

                    <%

                            }
                        }catch(ClassNotFoundException cnfe){
                            out.println("Driver Not Found:"+cnfe);

                        }catch(SQLException sqle){
                            out.println("SQL Exception:"+sqle);

                        }catch(Exception e){
                            out.println("Exception:"+e);

                        }finally{
                            try{
                                if(rs != null)
                                    rs.close();
                            }catch(Exception e){}

                            try{
                                if(stmt != null)
                                    stmt.close();
                            }catch(Exception e){}

                            try{
                                if(con != null)
                                    con.close();
                            }catch(Exception e){}
                        }
                    %>
        </tbody>
    </table>
</body>
</html>
