package cl.practica.android.java.appaboutme;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

public class MainActivity extends AppCompatActivity {

    private Button btnCompartir;
    private ImageView ivFoto;
    private LinearLayout llPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnCompartir = findViewById(R.id.btnCompartir);
        ivFoto = findViewById(R.id.ivPerfil);
        llPerfil = findViewById(R.id.llPerfil);

        String url = "https://img.freepik.com/fotos-premium/retrato-mujer-cabello-castano-largo-camisa-blanca_204916-780.jpg";

        Glide.with(this).load(url).into(ivFoto);

        Glide.with(this).
                asBitmap()
                .load(url)
                .override(800,800)
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        //Crear el BitmapDrawable
                        BitmapDrawable drawable = new BitmapDrawable(getResources(), resource);

                        //Configurar la repetición
                        drawable.setTileModeX(Shader.TileMode.REPEAT);

                        //Asignarlo como fondo al layout
                        llPerfil.setBackground(drawable);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });


        btnCompartir.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ContactoActivity.class);
            startActivity(intent);
        });


    }
}