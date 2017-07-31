package com.kiss.realmretrofitandrxmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.kiss.realmretrofitandrxmvp.R;
import com.kiss.realmretrofitandrxmvp.model.GitHubUser;

import java.util.List;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.GitHubViewHolder> {
    private Context context;
    private List<GitHubUser> gitHubUserList;
    private OnItemClickListener mItemClickListener;

    public MainAdapter(Context context, List<GitHubUser> gitHubUserList, OnItemClickListener mItemClickListener) {
        this.context = context;
        this.gitHubUserList = gitHubUserList;
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if (gitHubUserList.isEmpty()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public GitHubViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView;
        if (viewType == 0) {
            itemView = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.empty_item_layout, viewGroup, false);
        } else {
            itemView = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.item_layout, viewGroup, false);
        }
        return new GitHubViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GitHubViewHolder gitHubViewHolder, int position) {
        if (gitHubUserList.isEmpty()) {
            return;
        }

        gitHubViewHolder.vUserLogin.setText(gitHubUserList.get(position).getLogin());

        Glide.with(context).load(gitHubUserList.get(position).getAvatar_url()).centerCrop().into(gitHubViewHolder.vUserIcon);
        gitHubViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClick(v, gitHubUserList.get(position));
            }
        });
        gitHubViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mItemClickListener.onLongClick(v, gitHubUserList.get(position));
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        if (gitHubUserList.isEmpty()) {
            return 1;
        }
        return gitHubUserList.size();
    }

    public void setDataList(List<GitHubUser> gitHubUserList) {
        this.gitHubUserList.clear();
        this.gitHubUserList.addAll(gitHubUserList);
        notifyDataSetChanged();
    }

    public void reset() {
        this.gitHubUserList.clear();
    }

    /* viewHolder */
    class GitHubViewHolder extends RecyclerView.ViewHolder {
        ImageView vUserIcon;
        TextView vUserLogin;
        TextView vUserId;

        GitHubViewHolder(View v) {
            super(v);
            vUserIcon = (ImageView) v.findViewById(R.id.user_icon);
            vUserLogin = (TextView) v.findViewById(R.id.user_name);
            vUserId = (TextView) v.findViewById(R.id.user_type);

        }
    }

    /* onClick listener */
    public interface OnItemClickListener {
        void onItemClick(View v, GitHubUser gitHubUser);

        void onLongClick(View v, GitHubUser gitHubUser);
    }

}