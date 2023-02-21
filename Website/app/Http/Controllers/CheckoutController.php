<?php

namespace App\Http\Controllers;

use App\Models\Products;
use Illuminate\Http\Request;
use App\Models\Basket;
use App\Models\Order;
use App\Models\OrderItem;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Session;

class CheckoutController extends Controller
{


    public function show()
    {
        // Check if the user is logged in
        if (Auth::guest()) {
            // Redirect the user to the login page
            return redirect('login');
        }

        // Check if the user's basket is empty
        if (empty(Session::get('basket'))) {
            // Redirect the user back to the basket page
            return redirect('basket');
        }

        // Retrieve the products in the user's basket
        $basket = Session::get('basket');
        $products = [];
        $totalPrice = 0;
        $basketQuantities = Session::get('basketQuantities', []);
        foreach ($basket as $productId) {
            $product = Products::find($productId);
            if ($product) {
                $product->quantity = $basketQuantities[$productId];
                $products[] = $product;
                $totalPrice += $product->price * $basketQuantities[$productId];
            }
        }

        return view('checkout', [
            'products' => $products,
            'totalPrice' => $totalPrice
        ]);
    }

    public function placeOrder(Request $request)
    {
        // Check if the user is logged in
        if (Auth::guest()) {
            // Redirect the user to the login page
            return redirect('login');
        }

        // Check if the user's basket is empty
        if (empty(Session::get('basket'))) {
            // Redirect the user back to the basket page
            return redirect('basket');
        }

        // Retrieve the user's details
        $user = Auth::user();

        // Create a new order in the database
        $order = new Order;
        $order->user_id = $user->id;
        $order->total_price = $request->input('total_price');
        $order->save();

        // Add the products to the order
        $basket = Session::get('basket');
        $basketQuantities = Session::get('basketQuantities', []);
        foreach ($basket as $productId) {
            $product = Product::find($productId);
            if ($product) {
                $quantity = $basketQuantities[$productId] ?? 0;
                $orderItem = new OrderItem;
                $orderItem->order_id = $order->id;
                $orderItem->product_id = $product->id;
                $orderItem->quantity = $quantity;
                $orderItem->price = $product->price;
                $orderItem->save();
            }
        }

        // Clear the user's basket and quantities
        Session::forget('basket');
        Session::forget('basketQuantities');

        // Redirect the user to the order confirmation page
        return redirect('confirmation');
    }
}
