package dam.animacion;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class Main extends Activity {

    AnimationDrawable animacion;
    ImageView imagen;
    Animation animacionTween;
    int contador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen = (ImageView) findViewById(R.id.ivAnimacion);
        animacion = (AnimationDrawable) getResources().getDrawable(R.drawable.animacion);
        imagen.setBackgroundColor(Color.WHITE);
        imagen.setImageDrawable(animacion);


        animacionTween = AnimationUtils.loadAnimation(this, R.anim.animaciontween);
        animacionTween.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if(contador<3){
                    animacion.start();
                    imagen.setAnimation(animacionTween);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                contador++;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



//        imagen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                {
//        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
