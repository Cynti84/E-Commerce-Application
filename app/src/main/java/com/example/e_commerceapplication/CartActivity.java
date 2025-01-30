package com.example.e_commerceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;
    private TextView totalAmountTextView;
    private Button proceedToCheckoutButton;
    private double totalAmount = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize RecyclerView
        cartRecyclerView = findViewById(R.id.cartRecyclerView);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize Total Amount TextView
        totalAmountTextView = findViewById(R.id.totalAmountTextView);

        // Initialize Proceed to Checkout Button
        proceedToCheckoutButton = findViewById(R.id.proceedToCheckoutButton);

        // Ensure the cart is initialized
        if (ProductListActivity.cart == null) {
            ProductListActivity.cart = new ArrayList<>();
        }

        // Set up the adapter
        cartAdapter = new CartAdapter(ProductListActivity.cart);
        cartRecyclerView.setAdapter(cartAdapter);

        // Calculate and display the total amount
        calculateTotalAmount();

        // Set Proceed to Checkout Button action
        proceedToCheckoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
            intent.putExtra("totalAmount", totalAmount); // Pass the total amount to the checkout activity
            startActivity(intent);
        });
    }

    private void calculateTotalAmount() {
        totalAmount = 0.0;
        for (Object item : ProductListActivity.cart) {
            if (item instanceof Product) {
                Product product = (Product) item;
                totalAmount += product.getPrice();
            }
        }
        totalAmountTextView.setText("Total: KES " + totalAmount);
    }
}
