package com.example.seletorcores;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.seletorcores.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements
        SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private ActivityMainBinding binding;
    private TextView show;

    private boolean isNegrito;
    private boolean isItalico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        show = binding.labelShowText;

        binding.buttonEnviar.setOnClickListener(this);
        binding.seekbarFontSize.setOnSeekBarChangeListener(this);
        binding.checkboxNegrito.setOnClickListener(this);
        binding.checkboxItalico.setOnClickListener(this);
        binding.checkboxMaiusculas.setOnClickListener(this);
        binding.radioVermelho.setOnClickListener(this);
        binding.radioVerde.setOnClickListener(this);
        binding.radioAzul.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.checkbox_negrito) {
            isNegrito = binding.checkboxNegrito.isChecked();
        }

        if (v.getId() == R.id.checkbox_italico) {
            isItalico = binding.checkboxItalico.isChecked();
        }

        if (v.getId() == R.id.checkbox_maiusculas) {
            boolean isActive = binding.checkboxMaiusculas.isChecked();
            show.setAllCaps(isActive);
        }

        if (v.getId() == R.id.button_enviar) {
            show.setText(
                    binding.inputText.getText()
            );
        }

        show.setTypeface(isItalico && isNegrito ? Typeface.defaultFromStyle(Typeface.BOLD_ITALIC) :
                isNegrito ? Typeface.defaultFromStyle(Typeface.BOLD) :
                isItalico ? Typeface.defaultFromStyle(Typeface.ITALIC) :
                Typeface.DEFAULT);

        if (v.getId() == R.id.radio_vermelho) {
            show.setTextColor(Color.RED);
        }

        if (v.getId() == R.id.radio_verde) {
            show.setTextColor(Color.GREEN);
        }

        if (v.getId() == R.id.radio_azul) {
            show.setTextColor(Color.BLUE);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        show.setTextSize(progress);
        binding.labelFontSizeIndicator.setText(progress + " sp");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}