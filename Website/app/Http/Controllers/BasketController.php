<?php

namespace App\Http\Controllers;

use App\Models\Products;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Session;

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


    public function addBasket(Request $request){
        Session::start();
        $basket = Session::get('basket');
        $basket[] = $request->input('product_id');
        Session::put('basket', $basket);
        return redirect('basket');
    }


    // clear the basket
    public function clearBasket(){
        Session::start();
        Session::forget('basket');
        return redirect('basket');
    }

}

