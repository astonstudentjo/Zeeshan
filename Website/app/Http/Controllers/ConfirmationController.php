<?php

namespace App\Http\Controllers;

use App\Models\Order;
use App\Models\Products;


use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Session;
use App\Models\Basket;
// use App\Http\Controllers\Auth;

class ConfirmationController extends Controller
{


    public function show($id)
    {
        // Retrieve the order from the database
        $order = Order::with('user', 'items.products')->find($id);

        // Check if the order exists and the user has permission to view it
        if (!$order || $order->user_id != Auth::user()->id) {
            abort(404);
        }

        // Return the view with the order data
        return view('confirmation')->with('confirmation', $order);
        

    }
}
