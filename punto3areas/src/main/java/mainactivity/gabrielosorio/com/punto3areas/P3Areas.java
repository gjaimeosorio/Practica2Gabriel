package mainactivity.gabrielosorio.com.punto3areas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;

public class P3Areas extends AppCompatActivity {

    EditText v_base, v_altura, v_radio, v_lado;
    TextView Area;
    RadioButton Cuadro, Trian, Rect, Circ;
    Button Boton;
    int opcion;
    double area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3_areas);

        v_lado = (EditText)findViewById(R.id.eLado);
        v_lado.setVisibility(View.GONE);
        v_base = (EditText)findViewById(R.id.eBase);
        v_base.setVisibility(View.GONE);
        v_altura = (EditText)findViewById(R.id.eAltura);
        v_altura.setVisibility(View.GONE);
        v_radio = (EditText)findViewById(R.id.eRadio);
        v_radio.setVisibility(View.GONE);
        Cuadro = (RadioButton)findViewById(R.id.eRadio_cuadro);
        Trian = (RadioButton)findViewById(R.id.eRadio_trian);
        Rect = (RadioButton)findViewById(R.id.eRadio_rect);
        Circ = (RadioButton)findViewById(R.id.eRadio_circ);
        Area = (TextView)findViewById(R.id.eVer_area);
        Boton = (Button) findViewById(R.id.button);

        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double la, ba, alt, rad, PI = 3.1415926535;
                    switch (opcion) {
                        case 1:
                            if (TextUtils.isEmpty(v_lado.getText().toString())){
                                v_lado.setError("Ingrese lado del cuadrado");
                            area = 0;
                            }else {
                                la = Double.parseDouble(v_lado.getText().toString());//Debe estar si hay numero
                                area = Math.pow(la, 2);
                            }break;
                        case 2:
                            if (TextUtils.isEmpty(v_base.getText().toString())){
                                v_base.setError("Ingrese base del triángulo");
                                area = 0;
                            }else if(TextUtils.isEmpty(v_altura.getText().toString())){
                                v_altura.setError("Ingrese altura del triángulo");
                                area = 0;
                            }else {
                                ba = Double.parseDouble(v_base.getText().toString());//Debe estar si hay numero
                                alt = Double.parseDouble(v_altura.getText().toString());
                                area = ba * alt / 2;
                            }break;
                        case 3:
                            if (TextUtils.isEmpty(v_base.getText().toString())){
                                v_base.setError("Ingrese base del rectángulo");
                                area = 0;
                            }else if(TextUtils.isEmpty(v_altura.getText().toString())){
                                v_altura.setError("Ingrese altura del rectángulo");
                                area = 0;
                            }else {
                                ba = Double.parseDouble(v_base.getText().toString());//Debe estar si hay numero
                                alt = Double.parseDouble(v_altura.getText().toString());
                                area = ba * alt;
                            }break;
                        case 4:
                            if (TextUtils.isEmpty(v_radio.getText().toString())){
                                v_radio.setError("Ingrese radio del circulo");
                                area = 0;
                            }else {
                                rad = Double.parseDouble(v_radio.getText().toString());//Debe estar si hay numero
                                area = PI * Math.pow(rad,2);
                            }break;
                        default:
                    }
                Area.setText(String.valueOf(area));
            }
        });
    }

    public void onRadioButtonClicked(View view){
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.eRadio_cuadro:
                if (checked) {
                    v_lado.setVisibility(View.VISIBLE);
                    v_base.setVisibility(View.GONE);
                    v_altura.setVisibility(View.GONE);
                    v_radio.setVisibility(View.GONE);
                    opcion = 1;
                }break;
            case R.id.eRadio_trian:
                if (checked) {
                    v_lado.setVisibility(View.GONE);
                    v_base.setVisibility(View.VISIBLE);
                    v_altura.setVisibility(View.VISIBLE);
                    v_radio.setVisibility(View.GONE);
                    opcion = 2;
                }break;
            case R.id.eRadio_rect:
                if (checked) {
                    v_lado.setVisibility(View.GONE);
                    v_base.setVisibility(View.VISIBLE);
                    v_altura.setVisibility(View.VISIBLE);
                    v_radio.setVisibility(View.GONE);
                    opcion = 3;
                }break;
            case R.id.eRadio_circ:
                if (checked) {
                    v_lado.setVisibility(View.GONE);
                    v_base.setVisibility(View.GONE);
                    v_altura.setVisibility(View.GONE);
                    v_radio.setVisibility(View.VISIBLE);
                    opcion = 4;
                }break;
            default:
        }
    }
}
