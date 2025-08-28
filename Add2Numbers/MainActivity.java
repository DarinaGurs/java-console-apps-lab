package com.example.add2numbers;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText etA, etB;
    TextView tvSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etA = findViewById(R.id.numA);
        etB = findViewById(R.id.numB);
        tvSum = findViewById(R.id.sum);

        // Установка типа ввода для полей
        etA.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        etB.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }

    // Метод для проверки типа введенного числа
    private boolean isInteger(double number) {
        return number == Math.floor(number);
    }

    public void onClick(View v) {
        String strA = etA.getText().toString();
        String strB = etB.getText().toString();

        // Проверка на заполненность полей
        if (strA.isEmpty() || strB.isEmpty()) {
            if (strA.isEmpty() && strB.isEmpty()) {
                tvSum.setText("Пожалуйста, введите числа!");
            } else if (strA.isEmpty()) {
                tvSum.setText("Пожалуйста, введите число a!");
            } else {
                tvSum.setText("Пожалуйста, введите число b!");
            }
            return;
        }

            Double a = Double.parseDouble(strA);
            Double b = Double.parseDouble(strB);

            String sum = Double.toString(a + b);


            if (isInteger(a) && isInteger(b)) {
                int intSum = (int) Math.round(a + b);
                tvSum.setText(String.valueOf(intSum));
            }
            else {
                tvSum.setText(sum);
            }

        }
}