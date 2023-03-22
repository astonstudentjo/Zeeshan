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
<div>
    <form class = "login-form" action="/login" method="post">


        <div>
            @csrf

            @if(session('status'))

            {{session('status')}}
            <br><br>

            @endif


        </div>



        <label for="email"> Email: </label>
        <input type="text" placeholder="Email" name="email">
        <br><br>

        @error('email')
        {{$message}}
        <br>
        @enderror


        <label for="password"> Password: </label>
        <input type="password" placeholder="Password" name="password">
        <br><br>

        @error('password')
        {{$message}}
        <br>
        @enderror

        <button type="submit">Login to view your account</button>
        <br>

        <!-- <div class="description">
            <p>By continuing past this page, you agree to the <u>Terms of Use</u> Purchase Policy and understand that
                information will be used as described in our <u>Privacy Policy.</u></p>
        </div>

        <br>
        <div class="description2">
            <p> Need helping logging in, contact us: <br>
                <br>
                <u> +44 7508156819</u> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; <u>200060828@aston.ac.uk </u>
            </p>
        </div> -->
    </form>


</div>

</html>
@endsection