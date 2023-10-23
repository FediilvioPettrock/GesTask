package ao.co.isptec.aplm.taskmanager;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> messagesList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagesList = new ArrayList<>();
        //configurar a ListView
        ListView listView = findViewById(R.id.lista);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, messagesList);
        listView.setAdapter(adapter);

        Button send_btn = (Button) findViewById(R.id.send_btn);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.taskName);
                String message = editText.getText().toString();

                // Adiciona a mensagem à lista
                messagesList.add(0,message);

                // Notifica o adapter sobre a mudança nos dados
                adapter.notifyDataSetChanged();

                // Limpa o EditText
                editText.getText().clear();
            }
        });

    }
}