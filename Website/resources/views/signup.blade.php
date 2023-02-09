@extends('layouts.header')

@section('body')

<div>
<br>


    <div>
        <form action = "/signup" method = "post">
            @csrf
            @error('name')
            {{$message}}
            <br>
            @enderror

            <label for = "name" > Full Name: </label>
            <input type  = "text" placeholder = "Full name" name = "name">
            <br><br>

            @csrf
            @error('email')
            {{$message}}
            <br>
            @enderror

            <label for = "email"> Email: </label>
            <input type = "text" placeholder = "Email" name = "email">
            <br><br>

            @csrf
            @error('password')
            {{$message}}
            <br>
             @enderror
         
            <label for  = "password"> Password: </label>
            <input type = "password" placeholder =  "Password" name = "password">
            <br><br>

          
            <label for = "password_confirmation"> Password Confirmation: </label>
            <input type = "password" placeholder = "Password Again" name = "password_confirmation">
            <br><br>

            <button type = "submit">Sign Up </button>

        </form>


    </div>


    


</div>
@endsection