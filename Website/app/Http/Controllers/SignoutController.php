<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class SignoutController extends Controller
{
    public function SignOut(){
        auth()->logout();

        return redirect('login');
    }
}
