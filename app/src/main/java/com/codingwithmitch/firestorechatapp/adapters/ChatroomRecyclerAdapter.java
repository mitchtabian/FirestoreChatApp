package com.codingwithmitch.firestorechatapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingwithmitch.firestorechatapp.R;
import com.codingwithmitch.firestorechatapp.models.Chatroom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ChatroomRecyclerAdapter extends RecyclerView.Adapter<ChatroomRecyclerAdapter.ViewHolder>{

    private ArrayList<Chatroom> mChatrooms = new ArrayList<>();
    private ChatroomRecyclerClickListener mChatroomRecyclerClickListener;

    public ChatroomRecyclerAdapter(ArrayList<Chatroom> chatrooms, ChatroomRecyclerClickListener chatroomRecyclerClickListener) {
        this.mChatrooms = chatrooms;
        mChatroomRecyclerClickListener = chatroomRecyclerClickListener;
    }

//    private Set<Chatroom> mChatrooms = new HashSet<>();
//    private ChatroomRecyclerClickListener mChatroomRecyclerClickListener;
//
//    public ChatroomRecyclerAdapter(Set<Chatroom> chatrooms, ChatroomRecyclerClickListener chatroomRecyclerClickListener) {
//        this.mChatrooms = chatrooms;
//        mChatroomRecyclerClickListener = chatroomRecyclerClickListener;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_chatroom_list_item, parent, false);
        final ViewHolder holder = new ViewHolder(view, mChatroomRecyclerClickListener);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        ((ViewHolder)holder).chatroomTitle.setText(((Chatroom)(mChatrooms.toArray()[position])).getTitle());
        ((ViewHolder)holder).chatroomTitle.setText(mChatrooms.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mChatrooms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener
    {
        TextView chatroomTitle;
        ChatroomRecyclerClickListener clickListener;

        public ViewHolder(View itemView, ChatroomRecyclerClickListener clickListener) {
            super(itemView);
            chatroomTitle = itemView.findViewById(R.id.chatroom_title);
            this.clickListener = clickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onChatroomSelected(getAdapterPosition());
        }
    }

    public interface ChatroomRecyclerClickListener {
        public void onChatroomSelected(int position);
    }
}
















