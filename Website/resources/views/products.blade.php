<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ticket Selling Website</title>



    <!-- font awesome cdn link  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <!-- custom css file link  -->
    <link rel="stylesheet" href="../css/products.css">

    
<style>
        
    </style>
</head>
<body>

<!-- header section starts  -->

<header>
</header>

<!-- header section ends -->

<!-- home section starts  -->

<section class="home" id="home">

    <div class="content">
        <h3>Tickets Available!</h3>
        <span> Concerts & music events </span>
        <p>Attention all music lovers! Get ready to experience the thrill of live music!</p>
        <p>We are excited to announce that tickets to the event are now on sale! Don't miss the chance to see your favorite artists perform live on stage, jamming out to the tunes that have become the soundtrack of our lives.
        With a lineup of world-class musicians, this event is sure to be a night to remember. Whether you're a fan of rock, pop, hip-hop,</p>
        <a href="#products" class="btn">buy now</a>
    </div>
    
</section>

<!-- home section ends -->

<section class="filters">
<div class="bar">
          
    <p> Search Event </p>
    <p> place </p>
    <p> Time</p>

</div>
</section>

<!-- icons section starts  -->

<section class="icons-container">


    <div class="icons">
        <img src="../images/icon-2.png" alt="">
        <div class="info">
            <h3>10 days returns</h3>
            <span>moneyback guarantee</span>
        </div>
    </div>

    <div class="icons">
        <img src="../images/icon-3.png" alt="">
        <div class="info">
            <h3>offer & gifts</h3>
            <span>on all orders</span>
        </div>
    </div>

    <div class="icons">
        <img src="../images/icon-4.png" alt="">
        <div class="info">
            <h3>secure paymens</h3>
            <span>protected by paypal</span>
        </div>
    </div>
   
</section>

<!-- icons section ends -->

<!-- prodcuts section starts  -->

<section class="products" id="products">

    <h1 class="heading"> TICKETS AVAILABLE </h1>

 <div class="box-container">


    @foreach($products as $product)
        <div class="box">
            <span class="discount">-10%</span>
            <div class="image">
                <img src="../images/tickets.jpg" alt="">
                <div class="icons">
                    <a href="#" class="fas fa-heart"></a>
                    <a href="#" class="cart-btn">add to cart</a>
                    <a href="#" class="fas fa-share"></a>
                </div>
            </div>
            <div class="content">
                <h3>Product 1</h3>
                <h2> {{$product->artist}}</h2>
                <h2>{{$product->category}}</h2>
                <p> {{$product->description}}</p>
                <div class="price"> $12.99 <span>$15.99</span> </div>
            </div>
        </div>
    @endforeach

        </div>
</section>

<!-- prodcuts section ends -->

</body>
</html>