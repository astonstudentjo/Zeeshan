<?php

namespace Tests\Unit;



use Tests\TestCase;

class AllUserTest extends TestCase
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

    //Tests that all users can access the products page
    public function test_products_route(){
        $response = $this->get('/products');

        $response->assertStatus(200);
    }

    //Tests that all users can access the first product
    public function test_firstproduct_route(){
        $response = $this->get('/products/1');

        $response->assertStatus(200);
    }

    //Tests that all users can access the last product
    public function test_lastproduct_route(){
        $response = $this->get('/products/25');

        $response->assertStatus(200);
    }

    //Tests that all users can access the aboutus page
    public function test_aboutus_route(){
        $response = $this->get('/aboutus');

        $response->assertStatus(200);
    }

    //Tests that all users can access the contactus page
    public function test_contactus_route(){
        $response = $this->get('/contactus');

        $response->assertStatus(200);
    }
    
    //Tests that all users can access the basket page
    public function test_basket_route(){
        $response = $this->get('/basket');

        $response->assertStatus(200);
    }
}
