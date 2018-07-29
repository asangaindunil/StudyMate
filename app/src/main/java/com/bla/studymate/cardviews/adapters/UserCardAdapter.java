package com.bla.studymate.cardviews.adapters;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bla.studymate.R;
import com.bla.studymate.cardviews.models.User;

import java.util.List;

public class UserCardAdapter extends RecyclerView.Adapter<UserCardAdapter.UserViewHolder> {
    private List<User> usersList;
    Context context;

    //to different color for each card set color
//    Random random = new Random(10);

    public UserCardAdapter(List<User> userItemList, Context context) {
        this.usersList = userItemList;
        this.context = context;
    }


    @Override
    public UserCardAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View userView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_users_card, parent, false);
        UserViewHolder uvh = new UserViewHolder(userView);
        return uvh;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.userProfile.setImageResource(usersList.get(position).getImgId());
        holder.txtUserName.setText(usersList.get(position).getUserName()+"");
        holder.txtScore.setText(usersList.get(position).getScore()+"");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.userProfile.setClipToOutline(true);
        }
//        holder.txtAskToJoin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Request sent", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView userProfile;
        TextView txtUserName;
        TextView txtScore;
//        TextView txtMemberCount;
//        ImageButton txtAskToJoin;

        //to different color for each card set color
//        LinearLayout layout;

        public UserViewHolder(View view) {
            super(view);
            userProfile = view.findViewById(R.id.userProfilePic);
            txtUserName=view.findViewById(R.id.idUserName);
            txtScore = view.findViewById(R.id.idScoreTv);
//            txtMemberCount = view.findViewById(R.id.idMemberCount);
//            txtAskToJoin = view.findViewById(R.id.idAsktoJoin);

            //to different color for each card set color
//            layout = view.findViewById(R.id.idRelativeLayoutProfile);
//            layout.setBackgroundColor(random.nextInt());
        }
    }
}
