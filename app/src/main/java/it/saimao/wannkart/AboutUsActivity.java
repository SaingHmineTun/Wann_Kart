package it.saimao.wannkart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        // 1. Handle Back Button
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        // 2. Setup Contact Cards
        setupCards();
    }

    private void setupCards() {
        // Email Card
        setupContactCard(
                findViewById(R.id.cardEmail),
                R.drawable.ic_email,
                "Email",
                "tmk.muse@gmail.com",
                v -> sendEmail()
        );

        // Facebook Card
        setupContactCard(
                findViewById(R.id.cardFacebook),
                R.drawable.ic_facebook,
                "Facebook",
                "ထုင်ႉမၢဝ်းၶမ်း",
                v -> openUrl("https://www.facebook.com/100377671433172")
        );

        // GitHub Card
        setupContactCard(
                findViewById(R.id.cardGithub),
                R.drawable.ic_github,
                "GitHub",
                "Get Source Code",
                v -> openUrl("https://github.com/SaingHmineTun/learn_shan")
        );

        // Website Card
        setupContactCard(
                findViewById(R.id.cardWebsite),
                R.drawable.ic_earth,
                "Website",
                "Visit developer website",
                v -> openUrl("https://www.saimao.top")
        );
    }

    private void setupContactCard(View card, int iconRes, String label, String value, View.OnClickListener listener) {
        ImageView ivIcon = card.findViewById(R.id.itemIcon);
        TextView tvLabel = card.findViewById(R.id.itemLabel);
        TextView tvValue = card.findViewById(R.id.itemValue);

        ivIcon.setImageResource(iconRes);
        tvLabel.setText(label);
        tvValue.setText(value);

        card.setOnClickListener(listener);
    }

    private void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:tmk.muse@gmail.com"));
        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show();
        }
    }

    private void openUrl(String urlString) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Could not open link", Toast.LENGTH_SHORT).show();
        }
    }
}