package com.bla.studymate.cardviews.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bla.studymate.R;
import com.bla.studymate.cardviews.models.Group;

import java.util.List;
import java.util.Random;

public class GroupCardAdapter extends RecyclerView.Adapter<GroupCardAdapter.GroupViewHolder>{
    private List<Group> groupItemList;
    Context context;

    //to different color for each card set color
    Random random = new Random(20);

    public GroupCardAdapter(List<Group> groupItemList, Context context) {
        this.groupItemList = groupItemList;
        this.context = context;
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groupView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_group_card, parent, false);
        GroupViewHolder gvh = new GroupViewHolder(groupView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, final int position) {

        holder.txtquizCount.setText(groupItemList.get(position).getNoOfQuizes()+"");
        holder.txtGroupName.setText(groupItemList.get(position).getGroupName()+"");
        holder.txtMemberCount.setText(groupItemList.get(position).getNoOfMembers()+"");

        holder.txtAskToJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Request sent", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return groupItemList.size();
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder {
        TextView txtGroupName;
        TextView txtquizCount;
        TextView txtMemberCount;
        ImageButton txtAskToJoin;

        //to different color for each card set color
        LinearLayout layout;

        public GroupViewHolder(View view) {
            super(view);
            txtGroupName=view.findViewById(R.id.idGroupName);
            txtquizCount = view.findViewById(R.id.idQuizesCount);
            txtMemberCount = view.findViewById(R.id.idMemberCount);
            txtAskToJoin = view.findViewById(R.id.idAsktoJoin);

            //to different color for each card set color
            layout = view.findViewById(R.id.idRelativeLayoutQuizeCount);
            layout.setBackgroundColor(random.nextInt());
        }
    }
}