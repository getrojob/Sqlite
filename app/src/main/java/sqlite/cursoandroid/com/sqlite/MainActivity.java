package sqlite.cursoandroid.com.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            try{
        SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

        //tabela
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3) ) ");
        //bancoDados.execSQL("DROP TABLE pessoas");

        //bancoDados.execSQL("INSERT INTO pessoas(nome, idade)VALUES('Jessica Silva', 27)");
        //bancoDados.execSQL("INSERT INTO pessoas(nome, idade)VALUES('Getulio Silva', 31)");
          bancoDados.execSQL("INSERT INTO pessoas(nome, idade)VALUES('Gustavo Passos', 4)");
          bancoDados.execSQL("INSERT INTO pessoas(nome, idade)VALUES('Cecilia Passos', 2)");

        //bancoDados.execSQL("UPDATE pessoas SET nome = 'Cecilia Passos' WHERE nome = 'Cecilia'");

        //bancoDados.execSQL("DELETE FROM pessoas WHERE nome = 'Getulio' ");

        Cursor cursor = bancoDados.rawQuery("SELECT * FROM pessoas ", null);

        int indiceColunaNome = cursor.getColumnIndex("nome");
        int indiceColunaIdade = cursor.getColumnIndex("idade");
        int indiceColunaId = cursor.getColumnIndex("id");

        cursor.moveToFirst();

        while (cursor != null){
            Log.i("Resultado - Id: ", cursor.getString(indiceColunaId));
            Log.i("Resultado - nome: ", cursor.getString(indiceColunaNome));
            Log.i("Resultado - idade: ", cursor.getString(indiceColunaIdade));

            cursor.moveToNext();
        }
        }catch (Exception e){
                e.printStackTrace();
            }
    }
}
