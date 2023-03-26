<?php

namespace App\Http\Controllers;

use App\Models\Newsletter;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Redirect;

class NewsletterController extends Controller
{
    public function create(Request $request){
        $this->validate($request,[
            'newsletteremail' => ['required' , 'max:150', 'unique:newsletter,email,exists,0']          
        ]);

        Newsletter::create([
            'email' => $request->newsletteremail

        ]);

        
        return Redirect::back();
    }
}
