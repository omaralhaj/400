package hala.myPackage.android.a400;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import static hala.myPackage.android.a400.R.id.scroll1;

public class MainActivity extends AppCompatActivity {


    MediaPlayer m;

    int x = 0;
    int y = 0;
    String ln;
    String lh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageButton pb = (ImageButton) findViewById(R.id.play);
        final ImageButton ppb = (ImageButton) findViewById(R.id.pause);

        m = MediaPlayer.create(MainActivity.this, R.raw.talal);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb.setVisibility(View.VISIBLE);

                ppb.setVisibility(View.VISIBLE);

            }
        };


        Button b = (Button) findViewById(R.id.sot);
        b.setOnClickListener(listener);

        View.OnLongClickListener l = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Button b = (Button) findViewById(R.id.sot);


                b.setVisibility(View.VISIBLE);
                return true;
            }
        };
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.egg);

        linearLayout.setOnLongClickListener(l);


    }


    public void sajil(View view) {

        TextView lhm = (TextView) findViewById(R.id.lhm);
        TextView newlna = new TextView(this);
        TextView lna = (TextView) findViewById(R.id.lna);


        StringBuilder stringBuilder1 = new StringBuilder(lhm.getText().length());

        stringBuilder1.append(lhm.getText());

        x += isParc(stringBuilder1);


        StringBuilder stringBuilder2 = new StringBuilder(lna.getText().length());

        stringBuilder2.append(lna.getText());


        y += isParc(stringBuilder2);


        Toast t = new Toast(this);
        Toast nt = new Toast(this);
        if (x >= 152 && x > y) {

            t.makeText(MainActivity.this, "قامت عليكم", Toast.LENGTH_LONG).show();
            nt.makeText(MainActivity.this, "يا غشيم", Toast.LENGTH_SHORT).show();

        } else if (y >= 152 && y > x) {

            t.makeText(MainActivity.this, "مبروك يالذيب", Toast.LENGTH_LONG).show();
        } else {


        }
        ln = x + "";

        LinearLayout scroll1 = (LinearLayout) findViewById(R.id.scroll1);


        lh = y + "";

        newlna.setText(ln + "                                                                      " + lh);
        newlna.setPadding(20, 20, 20, 20);
        scroll1.addView(newlna, 0);


    }

    public void reset(View view) {
        x = 0;
        y = 0;

        LinearLayout l1 = (LinearLayout) findViewById(scroll1);
        l1.removeAllViews();


    }

    public void play(View view) {

        if (m.isPlaying()) return;

        else m.start();

    }

    public void pause(View view) {

        if (m.isPlaying()) m.pause();


    }


    public int isParc(StringBuilder s) {
        int x;
        try {

            x = Integer.parseInt(s.toString());
        } catch (Exception e) {
            x = 0;
        }
        return x;
    }


}



