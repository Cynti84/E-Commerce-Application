package com.example.e_commerceapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CartActivity extends AppCompatActivity {
    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize RecyclerView after setContentView
        cartRecyclerView = findViewById(R.id.cartRecyclerView); // Ensure this ID exists in activity_cart.xml
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Ensure the cart is initialized
        if (ProductListActivity.cart == null) {
            ProductListActivity.cart = new java.util.ArrayList<>();
        }

        // Set Adapter
        cartAdapter = new CartAdapter(ProductListActivity.cart);
        cartRecyclerView.setAdapter(cartAdapter);
    }

    private void onRemove(Product product) {
        if (ProductListActivity.cart != null && ProductListActivity.cart.contains(product)) {
            ProductListActivity.cart.remove(product);
            cartAdapter.notifyDataSetChanged();
            Toast.makeText(this, product.getName() + " removed from cart", Toast.LENGTH_SHORT).show();
        }
    }
}
