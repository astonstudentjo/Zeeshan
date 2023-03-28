<?php

namespace App\Http\Controllers;

use App\Models\Products;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Session;
use App\Models\Basket;
use Illuminate\Support\Facades\Log;


class BasketController extends Controller
{

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
        $intialQuantity = $request->input('quantity');

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

            //Limits the quantity of a single product in bakset to 10
            if (($basketQuantities[$productId] + $intialQuantity) <= 10) {

                $basketQuantities[$productId] += $intialQuantity;
            } else {
                $basketQuantities[$productId] = 10;
            }
            Session::put('basketQuantities', $basketQuantities);
        } else {
            // if the product doesn't exist, add it to the basket
            $basket[] = $productId;
            $product = Products::find($productId);
            $basketQuantities = Session::get('basketQuantities', []);
            $basketQuantities[$productId] = $intialQuantity;
            Session::put('basketQuantities', $basketQuantities);
        }

        Session::put('basket', $basket);
        return redirect('basket');
    }


    // clear the basket
    public function clearBasket()
    {
        Session::start();
        Session::forget('basketQuantities');
        Session::forget('basket');
        // log to conesole
        Log::info('Basket cleared');
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




    public function remove(Request $request)
    {

        $productId = $request->input('product_id');

    
        $basket = Session::get('basket');
        $basketQuantities = Session::get('basketQuantities', []);
    
        $existingProductIndex = array_search($productId, $basket);
        if ($existingProductIndex !== false) {
            unset($basket[$existingProductIndex]);
            unset($basketQuantities[$productId]);
        }
    
        Session::put('basket', $basket);
        Session::put('basketQuantities', $basketQuantities);

        // dd("test", $productId);
    
        return redirect('basket');
    }
    
}
