<?php

namespace Tests\Unit;

use Tests\TestCase;

class GuestTest extends TestCase
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

    public function test_signup_route(){
        $response = $this->get('/signup');

        $response->assertStatus(200);
    }

    public function test_login_route(){
        $response = $this->get('/login');

        $response->assertStatus(200);
    }

    public function test_orders_route(){
        $response = $this->get('/orders');

        $response->assertStatus(302);
    }

    public function test_specificorder_route(){
        $response = $this->get('/confirmation/1');

        $response->assertStatus(302);
    }
}
