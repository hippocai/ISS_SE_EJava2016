<%-- 
    Document   : index
    Created on : 2016-11-3, 22:53:24
    Author     : hippo
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
        

 <link href="style/default.css" rel="stylesheet" type="text/css" />
        <script>
            var socket=null;
            $(init);
            
            function init(){
                loadAllNotes();
            }
            
            function loadAllNotes(){
                $.ajax({
                    type:"GET",
                    async:true,
                   // data:param,
                    url:"api/notes",
                    success:function(data){ 		
                          displayAllNotes(data);
                    },
                error:function(data){
                  
                }
            });
            createSocket();
        }
            
            function displayAllNotes(data){
                console.dir(data);
                $("#contents").empty();
                for(var index=data.length-1;index>=0;--index){
                    var note=data[index];
                    prependNote(note);
                }
            }
            
            function prependNote(note){
                 var style="";
                 switch(note.category){
                       // case "Tuition":style="yellownotes";break;
                      //  case  "Social":style="greennotes";break;
                     //   case "Jobs":style="orangenotes";break;
                        default:style="post";
                    }
                $("#contents").prepend("<div id='"+note.id+"' class='"+style+"'></div>");
                $("#"+note.id).append("<div class='title'>"+note.title+"</div>");
                $("#"+note.id).append("<div class='posted'>Posted On "+note.dateTime+" By "+note.user+" </div>");
                $("#"+note.id).append("<div class='story'>"+note.content+"</div>");
                $("#"+note.id).append("<div class='meta'><p>Category:<a href='#' class='category'>"+note.category+"</a></p></div>");
            }
            
            function createSocket(){
                if(socket!=null){
                    socket.close();
                   //return;
                }
                var url = "ws://localhost:8080/CA2/noteSocket";
                socket = new WebSocket(url);
                socket.onopen = function() {
                    
                };
                
                socket.onmessage=function(evt){
                    var note= $.parseJSON(evt.data);
                    prependNote(note);
                }
            }
        </script>
    </head>
    <body>
       <div id="header">
           <h1 style="margin-left:60px"><a href="#">Sticky Notes</a></h1>
            <div id="reload" style="width: 200px;float: right;margin-top: 70px;" ><a href="javascript:loadAllNotes()"><img src="style/reload.png" style="width: 40px;height: 31px;"/>Force Reload</a></div>
            <div id="mgmt" style="width: 110px;float: right;margin-top: 70px;"><a href="faces/Login.xhtml"><img src="style/login.png" style="width: 40px;height: 31px;"/>Login</a></div>
       </div>
        <div id="contents" style="margin-top: 20px">
           
        </div>
    </body>
</html>
