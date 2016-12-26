package com.example.djakaumbarawurung.persipantestcept;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.djakaumbarawurung.persipantestcept.Model_Set_get.UserLog;

import java.util.ArrayList;

public class ActivityCekJawabanListening extends AppCompatActivity {
    int indexAktivitasUser = 0;
    ArrayList<UserLog> userLogArrayList = new ArrayList<>();
    TextView tvSoalCekListening, tvJawabanUserCekListening, tvKunciCekListening;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_jawaban_listening);

        tvJawabanUserCekListening = (TextView) findViewById(R.id.tvJawabanUserCekListening);
        tvSoalCekListening = (TextView) findViewById(R.id.tvSoalCekListening);
        tvKunciCekListening = (TextView) findViewById(R.id.tvKunciCekListening);
        userLogArrayList = getIntent().getParcelableArrayListExtra("aktivitasUser");

        showQuestion(0);
    }

    private void showQuestion(int index){
        UserLog userLog = userLogArrayList.get(index);
        tvSoalCekListening.setText("Question "+(index + 1));
        tvJawabanUserCekListening.setText(userLog.getJawabanUser());
        tvKunciCekListening.setText(userLog.getKunci());
    }

    public void nextCekListening(View view){
        if (indexAktivitasUser < userLogArrayList.size() - 1){
            indexAktivitasUser++;
            showQuestion(indexAktivitasUser);
        }
    }

    public void backCekListening(View view){
        if (indexAktivitasUser > 0){
            indexAktivitasUser--;
            showQuestion(indexAktivitasUser);
        }
    }
}
