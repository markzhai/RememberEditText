package cn.zhaiyifan.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        View submitButton = findViewById(R.id.submit_button);
        final TextView contentTextView = (TextView) findViewById(R.id.content);
        final EditText replyEditText = (EditText) findViewById(R.id.reply);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentTextView.setText(replyEditText.getText());
            }
        });
    }
}
