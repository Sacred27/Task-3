<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Регерссия</title>
        <style type="text/css">
    <%@include file="/resourses/style.css" %>
    </style>
    </head>

    <body>
        <form action = "getParam" method = "GET">
           <table>
               <caption>Регрессор</caption>
               <tr><td><input type = "number" name = "x1"
            value = "1" min="0" max="100" step="0.1"/></td>
               <td><input type = "number" name = "x2"
            value = "3" min="0" max="100" step="0.1"/></td>
               <td><input type = "number" name = "x3"
            value = "4" min="0" max="100" step="0.1"/></td>
               <td><input type = "number" name = "x4"
            value = "4" min="0" max="100" step="0.1"/></td>
               <td><input type = "number" name = "x5"
            value = "6" min="0" max="100" step="0.1"/></td>
               <td><input type = "number" name = "x6"
            value = "5" min="0" max="100" step="0.1"/></td>
               <td><input type = "number" name = "x7"
            value = "8" min="0" max="100" step="0.1"/></td>
               </tr>           
           </table>  
           <table>
               <caption>Регрессант</caption>
               <tr><td><input type = "number" name = "y1"
            value = "2" min="0" max="100" step="0.1"/></td>
               <td><input type = "number" name = "y2"
            value = "3" min="0" max="100" step="0.1"/></td>
               <td><input type = "number" name = "y3"
            value = "3" min="0" max="100" step="0.1"/></td>
               <td><input type = "number" name = "y4"
            value = "2" min="0" max="100" step="0.1"/></td>
               <td><input type = "number" name = "y5"
            value = "4" min="0" max="100" step="0.1"/></td>
               <td><input type = "number" name = "y6"
            value = "5" min="0" max="100" step="0.1"/></td>
               <td><input type = "number" name = "y7"
            value = "6" min="0" max="100" step="0.1"/></td>
               </tr>
              
           </table> 
        
           <table>
               <caption>Сценарий</caption>
               <tr><td><input type = "number" name = "prognoz"
            value = "2" min="0" max="100" step="0.1"/></td>
               <td><input type = "number" name = "statistic"
            value = "3" min="0" max="100" step="0.1"/></td>
               </tr>
           </table>  
            <button>Compute</button>
            </form>
    </body>
</html>
