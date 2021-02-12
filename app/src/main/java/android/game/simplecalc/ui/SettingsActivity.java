package android.game.simplecalc.ui;

import android.content.Intent;
import android.game.simplecalc.R;
import android.game.simplecalc.controller.MainActivityController;
import android.game.simplecalc.controller.MainController;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.google.android.material.switchmaterial.SwitchMaterial;


public class SettingsActivity extends BaseActivity {


    private ImageView imageBack;
    private SwitchMaterial switchMaterial;
    private MainController mainController = new MainActivityController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mainController.setTextOnCalcField((String) getIntent().getSerializableExtra(KEY_TextOnCalcField));
        initMaterialSwitch();
        initBackButton();
        switchMaterial.setChecked(getAppThemeForSwitch() != themeSimpleCalc);
    }

    private void initBackButton() {
        imageBack = findViewById(R.id.imageBack);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                if (mainController != null)
                    intent.putExtra(KEY_TextOnCalcField, mainController.getTextOnCalcField());
                startActivity(intent);
            }
        });
    }


    private void initMaterialSwitch() {
        switchMaterial = findViewById(R.id.switchMaterial);

        switchMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchMaterial.isChecked()) {
                    setAppTheme(themeSimpleCalcNight);
                    recreate();
                } else
                    setAppTheme(themeSimpleCalc);
                recreate();
            }
        });
    }

}