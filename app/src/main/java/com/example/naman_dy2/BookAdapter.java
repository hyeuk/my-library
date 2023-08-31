package com.example.naman_dy2;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    ArrayList<BookVO> array;
    Context context;


    public BookAdapter(ArrayList<BookVO> array, Context context) {
        this.array = array;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String title=array.get(position).getTitle();
        String image=array.get(position).getImage();
        int price=array.get(position).getPrice();
        String author=array.get(position).getAuthor();

        holder.txtprice.setText(array.get(position).getPrice() + "원");
        holder.txttitle.setText(Html.fromHtml(array.get(position).getTitle()));

        Picasso.get().load(image).into(holder.image);

        holder.txttitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, BookDetailActivity.class);
                //제목을 가져감
                intent.putExtra("title",title);
                intent.putExtra("image",image);
                intent.putExtra("author",author);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txttitle, txtprice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttitle=itemView.findViewById(R.id.txttitle);
            txtprice=itemView.findViewById(R.id.txtprice);
            image=itemView.findViewById(R.id.image);
        }
    }
}