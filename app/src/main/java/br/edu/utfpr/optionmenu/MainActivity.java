package br.edu.utfpr.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.mainLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_options, menu);
        return true;
    }

    private void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void useData(MenuItem item) {
        item.setChecked(!item.isChecked());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuItemSave:
                showMessage(getString(R.string.save) +
                        " " +
                        getString(R.string.was_clicked));
                return true;

            case R.id.menuItemDelete:
                showMessage(getString(R.string.delete) +
                        " "
                        + getString(R.string.was_clicked));
                return true;

            case R.id.menuItemBlue:
                item.setChecked(true);
                layout.setBackgroundColor(Color.BLUE);
                return true;

            case R.id.menuItemRed:
                item.setChecked(true);
                layout.setBackgroundColor(Color.RED);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}