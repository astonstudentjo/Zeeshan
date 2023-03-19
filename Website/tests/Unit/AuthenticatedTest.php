<?php

namespace Tests\Unit;

use App\Models\User;
use Tests\TestCase;

class AuthenticatedTest extends TestCase
{
    /**
     * A basic unit test example.
     *
     * @return void
     */
    public function test_example()
    {
        $this->assertTrue(true);
    }

    //tests that authenticated users are redirected back if they try access the signup page
    public function test_signup_route(){

        $user = User::factory()->create();
        $response = $this->actingAs($user)->get('/signup');
        $response->assertStatus(302);
    }

    //tests that authenticated users are redirected back if they try access the login page
    public function test_login_route(){

        $user = User::factory()->create();
        $response = $this->actingAs($user)->get('/login');
        $response->assertStatus(302);
    }

    //tests that authenticated users are redirected to the login page after signing out
    public function test_signout_route(){
        $user = User::factory()->create();
        $response = $this->actingAs($user)->post('/signout');
        $response->assertStatus(302);
    }

    //tests that authenticated users are able to access the orders page
    public function test_orders_route(){
        $user = User::factory()->create();
        $response = $this->actingAs($user)->get('/orders');
        $response->assertStatus(200);
    }
    
}
