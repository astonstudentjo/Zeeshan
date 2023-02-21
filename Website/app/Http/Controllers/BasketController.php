<?php

namespace App\Http\Controllers;

use App\Models\Products;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Session;
use App\Models\Basket; 

class BasketController extends Controller
{
    public function show(){
        Session::start();
        $basket = Session::get('basket');
        if($basket == null){
            $basket = [];
        }
        $product = [];
        foreach($basket as $id){
            $product[] = Products::find($id);
        }
        return view('basket', ['product' => $product]);
    }


    // public function addBasket(Request $request){
    //     Session::start();
    //     $basket = Session::get('basket');
    //     $basket[] = $request->input('product_id');
    //     Session::put('basket', $basket);
    //     return redirect('basket');
    // }

    public function addBasket(Request $request){
        Session::start();
        $productId = $request->input('product_id');
        $basket = Session::get('basket');
    
        if ($basket == null) {
            $basket = [];
        }
    
        // check if the product already exists in the basket
        $existingProductIndex = array_search($productId, $basket);
        if ($existingProductIndex !== false) {
            // if the product exists, increase its quantity
            $product = Products::find($productId);
            $basketQuantities = Session::get('basketQuantities', []);
            $basketQuantities[$productId] += 1;
            Session::put('basketQuantities', $basketQuantities);
        } else {
            // if the product doesn't exist, add it to the basket
            $basket[] = $productId;
            $product = Products::find($productId);
            $basketQuantities = Session::get('basketQuantities', []);
            $basketQuantities[$productId] = 1;
            Session::put('basketQuantities', $basketQuantities);
        }
    
        Session::put('basket', $basket);
        return redirect('basket');
    }


    // clear the basket
    public function clearBasket(){
        Session::start();
        Session::forget('basket');
        return redirect('basket');
    }


    public function update(Request $request)
{
    $quantities = $request->input('quantity', []);

    foreach ($quantities as $productId => $quantity) {
        $basket = Basket::where('product_id', $productId)->first();

        if ($basket) {
            $basket->quantity = $quantity;
            $basket->save();
        }
    }

    return redirect('basket');
}

}

