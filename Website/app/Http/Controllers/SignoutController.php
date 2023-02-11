<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class SignoutController extends Controller
{
    public function signout(){
        auth()->logout();

        return redirect('login');
    }
}
