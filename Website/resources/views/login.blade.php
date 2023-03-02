<!DOCTYPE html>
@extends('layouts.header')
@section('body')


<html>
    <head>
        <meta charset="utf-8">
        <title>Login</title>
        <link rel="stylesheet" href="../css/login.css">
    </head>
    <!-- placement for the image-->

    <div class="image-container">
  <img src="../css/Registration/welcomeback.jpg" alt="image" width="300" height="204">
</div>
<br>
    <link rel="stylesheet" href="../css/login.css">
    <div>
        <form action = "/login" method = "post">

            
        <div>
            @csrf

            @if(session('status'))

            {{session('status')}}
            <br><br>

            @endif

            
        </div>
            

            @error('email')
            {{$message}}
            <br>
            @enderror 

            <label for = "email"> Email: </label>
            <input type = "text" placeholder = "Email" name = "email">
            <br><br>

            
            @error('password')
            {{$message}}
            <br>
             @enderror 
         
            <label for  = "password"> Password: </label>
            <input type = "password" placeholder =  "Password" name = "password">
            <br><br>

            
            <button type = "submit">Login to view your account</button>
            <br>

            <div class="description">
            <p>By continuing past this page, you agree to the <u>Terms of Use</u> Purchase Policy and understand that 
                information will be used as described in our <u>Privacy Policy.</u></p>
            </div>
            
            <br>
            <div class="description2">
               <p> Need helping logging in, contact us: <br> 
                <br>
               <u> +44 7508156819</u> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; <u>200060828@aston.ac.uk </u>
                </p>
            </div>
        </form>


    </div>

    
</html>
@endsection