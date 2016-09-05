package mainactivity.gabrielosorio.com.punto2calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;

public class MainActivityP2Calculadora extends AppCompatActivity {

    EditText PN, SN;
    TextView Resultado;
    RadioButton Suma, Resta, Mult, Div;
    Button Boton;
    int opcion;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_p2_calculadora);

        PN = (EditText)findViewById(R.id.ePN);
        SN = (EditText)findViewById(R.id.eSN);
        Suma = (RadioButton)findViewById(R.id.eRadio_suma);
        Resta = (RadioButton)findViewById(R.id.eRadio_resta);
        Mult = (RadioButton)findViewById(R.id.eRadio_mult);
        Div = (RadioButton)findViewById(R.id.eRadio_div);
        Resultado = (TextView)findViewById(R.id.eVer_result);
        Boton = (Button) findViewById(R.id.button);


        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1, num2;
                if((TextUtils.isEmpty(PN.getText().toString()))){
                    total = 0;
                    PN.setError("Ingrese primer número");
                }else if(TextUtils.isEmpty(SN.getText().toString())) {
                    total = 0;
                    SN.setError("Ingrese segundo número");
                }else {
                    num1 = Integer.parseInt(PN.getText().toString());//Debe estar si hay numero
                    num2 = Integer.parseInt(SN.getText().toString());
                    switch (opcion) {
                        case 1:
                            total = num1 + num2;
                            break;
                        case 2:
                            total = num1 - num2;
                            break;
                        case 3:
                            total = num1 * num2;
                            break;
                        case 4:
                            total = num1 / num2;
                            break;
                        default:
                    }
                }
                Resultado.setText(String.valueOf(total));
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.eRadio_suma:
                if (checked)
                    opcion = 1;
                else
                    opcion = 0;
                break;
            case R.id.eRadio_resta:
                if (checked)
                    opcion = 2;
                else
                    opcion = 0;
                break;
            case R.id.eRadio_mult:
                if (checked)
                    opcion = 3;
                else
                    opcion = 0;
                break;
            case R.id.eRadio_div:
                if (checked)
                    opcion = 4;
                else
                    opcion = 0;
                break;
        }
    }




}
