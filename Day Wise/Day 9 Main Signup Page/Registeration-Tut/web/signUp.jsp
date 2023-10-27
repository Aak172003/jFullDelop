<%-- 
    Document   : signUp
    Created on : 10-Oct-2023, 9:05:00 pm
    Author     : Aakash Prajapati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    </head>
    <body style="background: url(img/desktop.jpg); background-size: cover ; background-attachment: fixed; align-content: center ; margin-top: 15%">

        <div class="container">
            <div class="row">
                <div class="col m6 offset-m3">

                    <div class="card">
                        <div class="card-content">

                            <h3 style="margin-top: 10px" class="center-align">Register Here !! </h3>

                            <h5 id="msg" class="center-align"></h5>

                            <div class="form center-align">
                                <!--register is a Servlet--> 

                                <form action="Register" method="post" id="myform">
                                    <input type="text" name="user_name" placeholder="Enter Your Name " />

                                    <input type="password" name="user_password" placeholder="Enter Your Password " />
                                    <input type="email" name="user_email" placeholder="Enter Your Email " />

                                    <div class="file-field input-field">
                                        <div class="btn">
                                            <span>File</span>
                                            <input name="image" type="file">
                                        </div>
                                        <div class="file-path-wrapper">
                                            <input class="file-path validate" type="text">
                                        </div>
                                    </div>

                                    <button type="submit" class="btn">Submit </button>

                                </form>

                            </div>

                            <div style =" margin-top: 10px ; display: none" class="loader center-align margin">
                                <div class="preloader-wrapper big active">
                                    <div class="spinner-layer spinner-blue-only">
                                        <div class="circle-clipper left">
                                            <div class="circle"></div>
                                        </div><div class="gap-patch">
                                            <div class="circle"></div>
                                        </div><div class="circle-clipper right">
                                            <div class="circle"></div>
                                        </div>
                                    </div>
                                </div>

                                <h4>Please Wait ...</h4>

                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>



        <script 
            src="https://code.jquery.com/jquery-3.7.1.min.js" 
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" 
            crossorigin="anonymous">
        </script>

        <!--// Jquery--> 

        <script>
            $(document).ready(function () {

                console.log("Page is Ready ...")

                $("#myform").on('submit', function (event)
                {
                    event.preventDefault();
                    // this point to current event 

                    // Image serialise use when we have text data 
//                     var f = $(this).serialize();
                    
                    // If we have image 
                    
                    let f = new FormData(this);

                    console.log(f);
                    

                    $(".loader").show();
                    $(".form").hide();
                    //From here Request go 

                    // Send data to backend
                    $.ajax({
                        url: "Register",
                        data: f,
                        type: 'POST',
                        success: function (data, textStatus, jqXHR) {
                            console.log("data is : ", data);
                            console.log(("success ......"));

                            $(".loader").hide();
                            $(".form").show();

                            if (data.trim() === "done") {
                                $('#msg').html("Successfully Registered ");
                                $('#msg').addClass('green-text');
                            } else {
                                $('#msg').html(" Something went Wrong on server ......");
                                $('#msg').addClass('red-text');
                            }

                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            console.log(data);
                            console.log(("error ......"));
                            $(".loader").hide();
                            $(".form").show();
                            $('#msg').html(" Something went Wrong on server ......");
                            $('#msg').addClass('red-text');
                        },
                        
                        processData: false,
                        contentType: false
                    });


                });
            });
        </script>

    </body>
</html>
