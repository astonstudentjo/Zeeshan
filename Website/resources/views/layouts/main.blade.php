<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="{{ asset('css/styles.css') }}">
    <!-- boxicons icons link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/boxicons/2.0.7/css/boxicons.min.css">



</head>

<body>


    <div class="header-container">
        <div class="left-header">
            <h2>EventTick</h2>
            <a href="/">Home</a>
            <a href="/products">Products</a>
            <a href="/aboutus">About Us</a>
            <a href="/contactus">Contact Us</a>
        </div>


        @guest

        <div class="right-header">
            <a href="/basket"> <i class='bx bxs-cart'></i>
                @if (Session::has('basketQuantities'))
                Items: {{ array_sum(Session::get('basketQuantities')) }}
                @else
                (EMPTY)
                @endif
            </a>
            <a href="/signup">Sign Up</a>
            <a href="/login">Login</a>
        </div>

        @endguest

        @auth



        <div class="right-header">
            <a>{{auth()->user()->name}}</a>
            <a href="/basket"> <i class='bx bxs-cart'></i>

                @if (Session::has('basketQuantities'))
                Items: {{ array_sum(Session::get('basketQuantities')) }}
                @else
                (EMPTY)
                @endif
            </a>
            <a href="/orders">Orders</a>
            <a href="/signout">Signout</a>

        </div>

        @endauth


    </div>
    <div class="body">

        @yield('body')
    </div>

    <footer>
        <div class="footer-box">
            <div class="footer-area">
                <div class="footer-component 1">
                    <h3>Quick Links</h3>
                    <a href="/">Home</a>
                    <a href="/products">Products</a>
                    <a href="/aboutus">About Us</a>
                    <a href="/contactus">Contact Us</a>
                    <a href="/basket">Basket</a>
                </div>

                <div class="footer-component 2">
                    <h3>Contact Info</h3>
                    <a href = "tel:+0121 204 3000">+0121 204 3000</a>
                    <a href="mailto:EventTick@aston.ac.uk">EventTick@aston.ac.uk</a>
                    <a href = "https://goo.gl/maps/7FpErGeDp9EyaoHp6">Birmingham, United Kingdom</a>
                </div>

                <div class="footer-component-newsletter">
                    <h3>Subscribe to our newsletter</h3>
                    <form class="newsletter-form">
                        <input type="email" id="footer-newsletter-email" placeholder="Enter email address" required>
                        <input type="submit" id="footer-newsletter-btn">
                    </form>
                </div>
            </div>

        </div>
    </footer>
</body>







</html>