package com.tuteeapp.student.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.Model.Teacher_Model;
import com.tuteeapp.student.MoreShare;
import com.tuteeapp.student.R;
import com.tuteeapp.student.SelectExercise;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class All_ScreenShareFragment extends Fragment {
    RecyclerView rv_teacher;
    List<Teacher_Model> teacher_models;
    TeacherAdapter teacher_adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_teacher,container,false);

        teacher_models = new ArrayList<>();

        rv_teacher = view.findViewById(R.id.rv_teacher);
        rv_teacher.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rv_teacher.setLayoutManager(linearLayoutManager);
        teacher_models.add(new Teacher_Model("Daniel William","CBSE","Maths","Physics","English","134",
                "1500","102 Videos"));
        teacher_models.add(new Teacher_Model("Daniel William","CBSE","Maths","Physics","English","134",
                "1500","102 Videos"));
        teacher_models.add(new Teacher_Model("Daniel William","CBSE","Maths","Physics","English","134",
                "1500","102 Videos"));
        teacher_adapter = new TeacherAdapter(getActivity(),teacher_models);
        rv_teacher.setAdapter(teacher_adapter);


        return view;
    }
    public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.MyViewHolder> {

        Context context;
        List<Teacher_Model> teacher_models = new ArrayList<>();

        public TeacherAdapter(Context context, List<Teacher_Model> teacher_models) {
            this.context = context;
            this.teacher_models = teacher_models;
        }

        @NonNull
        @Override
        public TeacherAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.single_teacher, parent, false);
            return new TeacherAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TeacherAdapter.MyViewHolder holder, int position) {

            holder.text_name.setText(teacher_models.get(position).getText_name());
            holder.board.setText(teacher_models.get(position).getBoard());
            holder.subj.setText(teacher_models.get(position).getSubj_1()+" | "+teacher_models.get(position).getSubj_2()+" | "+teacher_models.get(position).getSubj_3());
            holder.subscriber.setText(teacher_models.get(position).getSubscriber());
            holder.views.setText(teacher_models.get(position).getViews());
            holder.videos.setText(teacher_models.get(position).getVideos());

            holder.linear_teacher.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                       context.startActivity(new Intent(context, MoreShare.class));
                       getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            });
            holder.textViewOptions.setVisibility(View.GONE);
            holder.textViewOptions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity(), R.style.BottomSheetDialogTransparent);
                    View bottomSheetView = LayoutInflater.from(getActivity()).inflate(R.layout.bottomsheet_infocancel, null);
                    final CardView cardinfo = bottomSheetView.findViewById(R.id.info);
                    final CardView cardsave = bottomSheetView.findViewById(R.id.cardsend);
                    final CardView cardexercise = bottomSheetView.findViewById(R.id.exercise);
                    final CardView cardanalysis = bottomSheetView.findViewById(R.id.analysis);
                    final CardView cardtest = bottomSheetView.findViewById(R.id.test);
                    final CardView cardbtncancel = bottomSheetView.findViewById(R.id.btncancel);

                    bottomSheetDialog.setContentView(bottomSheetView);
                    bottomSheetDialog.show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return teacher_models.size();
        }
        public void setTaskList(List<Teacher_Model> taskList) {
            this.teacher_models = taskList;
            notifyDataSetChanged();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView text_name,board,subj,subscriber,views,videos,textViewOptions;
            LinearLayout linear_teacher;
            //        LinearLayout linear_this;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                text_name = itemView.findViewById(R.id.text_name);
                board = itemView.findViewById(R.id.board);
                subj = itemView.findViewById(R.id.subj);
                subscriber = itemView.findViewById(R.id.subscriber);
                views = itemView.findViewById(R.id.views);
                videos = itemView.findViewById(R.id.videos);
                linear_teacher = itemView.findViewById(R.id.linear);
                textViewOptions = itemView.findViewById(R.id.textViewOptions);

            }
        }
    }


}
