package mymd.dlmu.a2048;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import mymd.dlmu.a2048.view.Game2048Layout;

public class MainActivity extends AppCompatActivity implements Game2048Layout.OnGame2048Listener {

    private TextView tv_score;

    private Game2048Layout game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_score = (TextView) findViewById(R.id.id_score);
        game = (Game2048Layout) findViewById(R.id.id_game2048);
        game.setOnGame2048Listener(this);
    }

    @Override
    public void onScoreChange(int score) {
        tv_score.setText("SCORE: " + score);
    }

    @Override
    public void onGameOver() {
        new AlertDialog.Builder(this).setTitle("GAME OVER")
                .setMessage("YOU HAVE GOT " + tv_score.getText())
                .setPositiveButton("RESTART", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        game.restart();
                    }
                }).setNegativeButton("EXIT", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).show();

    }
}
