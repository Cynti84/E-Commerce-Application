package com.example.e_commerceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView totalAmountText;
    private Button proceedToPayBtn;
    private CartAdapter cartAdapter;
    private List<Product> productList; // Use Product as cart item to ensure consistency

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_activity);

        // Initialize views
        recyclerView = findViewById(R.id.cartRecyclerView);
        totalAmountText = findViewById(R.id.totalAmount);
        proceedToPayBtn = findViewById(R.id.btnProceedToPay);

        // Fetch the cart data from ProductListActivity
        if (ProductListActivity.cart != null) {
            productList = ProductListActivity.cart;
        } else {
            productList = new ArrayList<>(); // Ensure no null-pointer exceptions
        }

        // Set up the adapter
        cartAdapter = new CartAdapter(productList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(cartAdapter);

        // Calculate and display the total price
        updateTotalPrice();

        // Set up the button click listener
        proceedToPayBtn.setOnClickListener(v -> {
            Intent intent = new Intent(CheckoutActivity.this, PaymentActivity.class);
            intent.putExtra("totalAmount", calculateTotal()); // Pass the total amount
            intent.putParcelableArrayListExtra("ProductList", new ArrayList<>(productList)); // Pass the cart items if needed
            startActivity(intent);
        });
    }

    private double calculateTotal() {
        double total = 0.0;
        for (Product item : productList) {
            total += item.getPrice();
// Add product price to total
        }
        return Math.round(total * 100.0) / 100.0;
    }

    private void updateTotalPrice() {
        totalAmountText.setText("Total: KES " + calculateTotal());
    }
}
