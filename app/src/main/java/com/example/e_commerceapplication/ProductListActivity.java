package com.example.e_commerceapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView productRecyclerView;
    private ProductListAdapter productListAdapter;
    private List<Product> productList;

    protected static ArrayList cart;

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
        productList.add(new Product("Basic White T-Shirt", 15.99, R.drawable.white));
        productList.add(new Product("Slim Fit Denim Jeans", 39.99, R.drawable.jeans));

        // Initialize the adapter and set it to the RecyclerView
        productListAdapter = new ProductListAdapter(productList, this);
        productRecyclerView.setAdapter(productListAdapter);
    }
}
