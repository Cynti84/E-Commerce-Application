package com.example.e_commerceapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class FeaturedProductsAdapter extends RecyclerView.Adapter<FeaturedProductsAdapter.ViewHolder> {

    private List<Product> productList;

    // Constructor
    public FeaturedProductsAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each product
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product currentProduct = productList.get(position);
        // Set the product name and price
        holder.productName.setText(currentProduct.getName());
        holder.productPrice.setText("$" + currentProduct.getPrice());

        // Load the product image using Picasso
        //Picasso.get().load(currentProduct.getProductImage()).into(holder.productImage);

        // Load image using drawables
        holder.productImage.setImageResource(currentProduct.getImageResource());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    // ViewHolder class to hold the views for each product
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName;
        TextView productPrice;
        ImageView productImage;

        public ViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productImage = itemView.findViewById(R.id.productImage);
        }
    }
}
