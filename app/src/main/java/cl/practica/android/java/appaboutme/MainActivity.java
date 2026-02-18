package cl.practica.android.java.appaboutme;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private Button btnCompartir;
    private ImageView ivFoto, ivFoto2, ivFoto3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnCompartir = findViewById(R.id.btnCompartir);
        ivFoto = findViewById(R.id.ivPerfil);
        ivFoto2 = findViewById(R.id.ivPerfil2);
        ivFoto3 = findViewById(R.id.ivPerfil3);

        String url = "https://img.freepik.com/fotos-premium/retrato-mujer-cabello-castano-largo-camisa-blanca_204916-780.jpg";

        Glide.with(this).load(url).into(ivFoto);
        Glide.with(this).load(url).into(ivFoto2);
        Glide.with(this).load(url).into(ivFoto3);

        btnCompartir.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ContactoActivity.class);
            startActivity(intent);
        });


    }
}