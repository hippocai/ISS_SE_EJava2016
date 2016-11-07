<%-- 
    Document   : Index
    Created on : 2016-11-7, 10:42:46
    Author     : EasonChua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/css/bootstrap.min.css"/>
    </head>
    <body>
        <div id="content">
            <form class="form-horizontal" action="<%=request.getContextPath()%>/api/delivery" method="post" >
                <fieldset>

                    <!-- Form Name -->
                    <legend>Add Delivery</legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="name">Name</label>  
                        <div class="col-md-4">
                            <input id="name" name="name" type="text" placeholder="Firstname Surname" class="form-control input-md" required="">
                            <span class="help-block">eg. Fred Flintstone</span>  
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="address">Address</label>  
                        <div class="col-md-5">
                            <input id="address" name="address" type="text" placeholder="Buildingname, Streetname, Country" class="form-control input-md" required="">
                            <span class="help-block">eg. Institute of Systems Science, 25 Heng Mui Keng Terrace, Singapore</span>  
                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="phone">Phone No</label>  
                        <div class="col-md-5">
                            <input id="phone" name="phone" type="text" placeholder="+Countrycode Phonenumber" class="form-control input-md" required="">
                            <span class="help-block">eg. +65 12345678</span>  
                        </div>
                    </div>

                    
                </fieldset>
                <div style="width: 100px; margin-left: auto;margin-right: auto;"> <input type="submit" value="submit" class="btn btn-primary"/></div>
            </form>

        </div>
    </body>
</html>
