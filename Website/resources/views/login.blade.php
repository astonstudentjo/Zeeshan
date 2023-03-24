<!DOCTYPE html>
@extends('layouts.main')
@section('body')


<html>

<head>
    <meta charset="utf-8">
    <title>Login</title>
    <!-- <link rel="stylesheet" href="../css/login.css"> -->
    <link rel="stylesheet" type="text/css" href="{{ asset('css/login.css') }}">

</head>
<!-- placement for the image-->


<br>
<heading class="Title">Welcome back! </heading>
<br>

<div>
    <form class = "login-form" action="/login" method="post">


        <div>
            @csrf

            @if(session('status'))

            {{session('status')}}
            <br><br>

            @endif


        </div>
<h> Log in to your account </h>
<p> New to EventTick? <a href="/signup">Register an account</a></p>
<br>

        <label for="email"> Email: </label>
        <input type="text" placeholder="Email" name="email">
        

        @error('email')
        {{$message}}
        @enderror
        <br>



        <label for="password"> Password: </label>
        <input type="password" placeholder="Password" name="password">


        @error('password')
        {{$message}}
 
        @enderror
        <br>
        <br>
        <button type="submit">Login to view your account</button>
        <br>

       
    </form>
<br>

</div>


</html>
@endsection