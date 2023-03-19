<?php

namespace App\Http\Controllers;

use App\Models\Order;
use App\Models\Products;


use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Session;
use App\Models\Basket;

class OrdersController extends Controller
{


    public function show()
    {
        $orders = Order::where('user_id', Auth::user()->id)->get();
        return view('orders', ['orders' => $orders]);
        

    }
}
