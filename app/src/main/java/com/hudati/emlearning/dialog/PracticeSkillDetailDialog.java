package com.hudati.emlearning.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.hudati.emlearning.R;
import com.hudati.emlearning.activity.PracticeActivity;
import com.hudati.emlearning.model.PracticeSkill;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by huylv on 06-Apr-17.
 */

public class PracticeSkillDetailDialog extends Dialog {
    Context context;
    PracticeSkill practiceSkill;

//    @BindView(R.id.dialog_practice_title)
//    TextView dialog_practice_title;
    @BindView(R.id.dialog_practice_description)
    WebView dialog_practice_description;
    @BindView(R.id.dialog_practice_time)
    TextView dialog_practice_time;
    @BindView(R.id.dialog_practice_numOfQuestion)
    TextView dialog_practice_numOfQuestion;
    @BindView(R.id.dialog_practice_start)
    Button dialog_practice_start;
    private View.OnClickListener onClick;

    public PracticeSkillDetailDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public PracticeSkillDetailDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected PracticeSkillDetailDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public PracticeSkillDetailDialog(Activity activity, PracticeSkill practiceSkill) {
        super(activity);
        this.context = activity;
        this.practiceSkill = practiceSkill;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_practice_skill_detail);
        ButterKnife.bind(this);

        setTitle(practiceSkill.getPracticeTitle());
        dialog_practice_time.setText(String.valueOf(practiceSkill.getPracticeTime()));
        dialog_practice_numOfQuestion.setText(String.valueOf(practiceSkill.getPracticeNumberQuestion()));

        dialog_practice_description.loadDataWithBaseURL(null,practiceSkill.getPracticeDescription(),"text/html","utf-8",null);
        dialog_practice_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,PracticeActivity.class);
                context.startActivity(i);
            }
        });
    }
}