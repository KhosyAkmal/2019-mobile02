package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private int number;
	private EditText numberInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		numberInput = findViewById(R.id.number_input);
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random random = new Random();//membuat objek random
		int r = random.nextInt(50); //membuat variabel random (r) dengan memberi batasan nilai int sampa 50 saja
		number = r; //mengisi variabel number dnegan r yang telah dilakukan pada baris sebelumnya
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		String angka = numberInput.getText().toString();// membuat variabel angka bertipe String dengan isi numberinput yang di ambil dari objek dan dibuat menjadi string
		int input = Integer.parseInt(angka); //membuat variabel input dengan isi valiabel angka, namun integernya di parse dulu dari String ke int

		if(input == number){ //kondisi dimana input yang di masukan sama dengan nomor yang random
			Toast.makeText(this, "Tebakan anda benar!!",Toast.LENGTH_SHORT).show();
		}else if (input < number){//kondisi dimana input yang di masukan lebih kecil dari nomor yang random
			Toast.makeText(this, "Tebakan anda terlalu kecil!!",Toast.LENGTH_SHORT).show();
		}else{ // //kondisi dimana input yang di masukan lebih besar nomor yang random
			Toast.makeText(this, "Tebakan anda terlalu besar!!",Toast.LENGTH_SHORT).show();
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		numberInput.setText("");//untuk mereset tampilan menjadi "" (kosong)
		initRandomNumber(); //setelah di reset maka angka diacak lagi
	}
}
