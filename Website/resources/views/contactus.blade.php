<!DOCTYPE html>
@extends('layouts.main')
@section('body')


<html>
    <head>
        <meta charset="utf-8">
        <title>Contact Us</title>
        <script src="https://kit.fontawesome.com/b356ad9dc8.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" type="text/css" href="{{ asset('css/contactus.css') }}">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    </head>

    <div class = "contactus-container">
        <div class = "contactus-area">
        <div class = "contactus-left">
            <div class = "contactus-details address">

                <div class = "image-icon">
                <img src="{{ asset('images/phone-icon.png') }}" width="30" height="30">
                </div>

                <div class = "icon-text">
                <h4>Address</h4>
                <p>Aston St, Birmingham B4 7ET</p>
                </div>



            </div>
            <div class = "contactus-details phone">

                <div class = "image-icon">
                <img src="{{ asset('images/phone-icon.png') }}" width="30" height="30">
                </div>

                <div class = "icon-text">
                <h4>Phone</h4>
                <p>0121 204 3000</p>
                </div>



            </div>
            <div class = "contactus-details email">

                <div class = "image-icon">
                <img src="{{ asset('images/email-icon.png') }}" width="30" height="30">
                </div>

                <div class = "icon-text">
                <h4>Email</h4>
                <p>EventTick@Aston.ac.uk</p>
                </div>


            </div>

        </div>

        <div class = "contactus-right">
            <h3 id = "form-header">Contact US</h3>
            <p id = "form-text">Have an enquiry that needs to be answered? Please contact us by filling out the form below!</p>
            <form class="contactus-form">

                    <input type="text" id="contactus-name" placeholder="Name" required>
                    <input type="email" id="contactus-email" placeholder="Email" required>
                    <input type="subject" id="contactus-subject" placeholder="EventTick Enquiry" required>
                    <input type="message" id="contactus-message" placeholder="Message" required>
                    <input type="submit" id="contactus-btn">


            </form>

        </div>
    </div>
    </div>




</html>

@endsection
