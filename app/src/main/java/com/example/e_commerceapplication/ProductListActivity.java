package com.example.e_commerceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView productRecyclerView;
    private ProductListAdapter productListAdapter;
    private List<Product> productList;

    protected static ArrayList<Product> cart;  // Make sure to handle this cart properly

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        // Initialize the RecyclerView
        productRecyclerView = findViewById(R.id.productRecyclerView);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the product list
        productList = new ArrayList<>();

        // Add products to the list
        productList.add(new Product("Basic White T-Shirt", 500.99, R.drawable.white));
        productList.add(new Product("Slim Fit Denim Jeans", 600.99, R.drawable.jeans));
        productList.add(new Product("Big Cute Hoddie ", 1000.99, R.drawable.hoddie));
        productList.add(new Product("Pretty Skirt Outfit", 2500.99, R.drawable.skirt));
        productList.add(new Product("Green Nike Sneakers", 4000.99, R.drawable.sneakers));
        productList.add(new Product("Summer Dress", 1500.99, R.drawable.dress));
        productList.add(new Product("Stunning Brown Jumpsuit", 1200.99, R.drawable.jumpsuit));
        productList.add(new Product("Summer Short Outfit", 1800.99, R.drawable.shorts));

        // Initialize the adapter and set it to the RecyclerView
        productListAdapter = new ProductListAdapter(productList, this);
        productRecyclerView.setAdapter(productListAdapter);

        // Initialize the Proceed to Checkout button
        Button proceedToCheckoutButton = findViewById(R.id.proceedToCheckoutButton);
        proceedToCheckoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the Checkout Activity
                Intent intent = new Intent(ProductListActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });
    }

    // Method to add a product to the cart (call this method when "Add to Cart" is clicked)
    public static void addToCart(Product product) {
        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(product);
    }
}
