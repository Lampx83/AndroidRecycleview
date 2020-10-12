package com.mycompany.recylerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LinkedList<Email> mWordList;
    private LayoutInflater mInflater;
    private Context context;

    public WordListAdapter(Context context, LinkedList<Email> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
        this.context = context;
    }


    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        Email email = mWordList.get(position);
        holder.wordItemView.setText(email.title);
        holder.descriptionItemView.setText(email.description);
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        public final TextView descriptionItemView;
        final WordListAdapter mAdapter;


        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            descriptionItemView = itemView.findViewById(R.id.description);

            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailActivity.class);
            int position = getAdapterPosition();
            Email email = mWordList.get(position);

            intent.putExtra("email", email);

            context.startActivity(intent);

        }
    }
}
