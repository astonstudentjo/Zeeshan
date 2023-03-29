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
        ],[
            'newsletteremail.unique' => 'This email has already subscribed to the news letter'



        ]);

        Newsletter::create([
            'email' => $request->newsletteremail

        ]);

        
        return redirect()->back()->with('success', 'You have subscribed to the news letter!');

    }
}
