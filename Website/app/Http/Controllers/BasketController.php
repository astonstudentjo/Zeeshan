<?php

namespace App\Http\Controllers;

use App\Models\Products;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Session;
use App\Models\Basket;

class BasketController extends Controller
{
    // public function show()
    // {
    //     Session::start();
    //     $basket = Session::get('basket');
    //     if ($basket == null) {
    //         $basket = [];
    //     }
    //     $product = [];
    //     foreach ($basket as $id) {
    //         $product[] = Products::find($id);
    //     }
    //     return view('basket', ['product' => $product]);
    // }

    public function show()
    {
        Session::start();
        $basket = Session::get('basket');
        if ($basket == null) {
            $basket = [];
        }
        $product = [];
        $totalItems = 0;
        $basketQuantities = Session::get('basketQuantities', []);
        foreach ($basket as $id) {
            $product[] = Products::find($id);
            $totalItems += $basketQuantities[$id] ?? 0;
        }
        return view('basket', [
            'product' => $product,
            'totalItems' => $totalItems
        ]);
    }





    public function addBasket(Request $request)
    {
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
    public function clearBasket()
    {
        Session::start();
        Session::forget('basket');
        return redirect('basket');
    }


    public function update(Request $request)
    {
        $quantities = $request->input('quantity', []);

        $basketQuantities = Session::get('basketQuantities', []);

        foreach ($quantities as $productId => $quantity) {
            $basketQuantities[$productId] = $quantity;
        }

        Session::put('basketQuantities', $basketQuantities);

        return redirect('basket');
    }
}
