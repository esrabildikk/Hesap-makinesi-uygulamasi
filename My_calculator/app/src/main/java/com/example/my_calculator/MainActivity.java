package com.example.my_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);

        //EditText tıklayınca klavye gelmesini engelledik.
        editText.setShowSoftInputOnFocus(false);
    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAC:
                editText.setText("0");
                break;
            case R.id.buttonYuzde:
                EkraniGuncelle("%");
                break;
            case R.id.buttonBolme:
                EkraniGuncelle("/");
                break;
            case R.id.buttonCarpma:
                EkraniGuncelle("*");
                break;
            case R.id.buttonCikarma:
                EkraniGuncelle("-");
                break;
            case R.id.buttonEsittir:islemYap();
                break;
            case R.id.buttonToplama:
                EkraniGuncelle("+");
                break;
            case R.id.buttonVirgul:
                EkraniGuncelle(".");
                break;
            case R.id.sil:
                sil();
                break;
            case R.id.button0:
                EkraniGuncelle("0");
                break;
            case R.id.button1:
                EkraniGuncelle("1");
                break;
            case R.id.button2:
                EkraniGuncelle("2");
                break;
            case R.id.button3:
                EkraniGuncelle("3");
                break;
            case R.id.button4:
                EkraniGuncelle("4");
                break;
            case R.id.button5:
                EkraniGuncelle("5");
                break;
            case R.id.button6:
                EkraniGuncelle("6");
                break;
            case R.id.button7:
                EkraniGuncelle("7");
                break;
            case R.id.button8:
                EkraniGuncelle("8");
                break;
            case R.id.button9:
                EkraniGuncelle("9");
                break;
        }
    }

    public void sil() {
            int imlec = editText.getSelectionStart();
            if (imlec > 0) {
                String gelenDeger = editText.getText().toString();
                String sagIslem = gelenDeger.substring(0, imlec - 1);
                String solIslem = gelenDeger.substring(imlec);
                String yeniDeger = sagIslem + solIslem;
                editText.setText(yeniDeger);

                // imleci önceki konumuna geri döndür
                int oncekiImlec = imlec - 1;
                editText.setSelection(oncekiImlec);
            }
    }
    public void EkraniGuncelle (String deger){

        String guncelDeger = editText.getText().toString();

        // Eğer ekranda sadece sıfır varsa, sıfırı sil
        if (guncelDeger.equals("0")) {
            editText.setText("");
        }
        editText.setText(editText.getText() + deger);


        }
            public void islemYap() {
                String deger = editText.getText().toString();

                Expression ifade = new Expression(deger);

                String result = String.valueOf(ifade.calculate()).toString();
                editText.setText(result);
                editText.setSelection(result.length());
            }

        }
