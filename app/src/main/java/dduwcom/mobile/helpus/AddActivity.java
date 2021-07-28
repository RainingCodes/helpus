package dduwcom.mobile.helpus;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class AddActivity extends AppCompatActivity {

    EditText inputBuilding;
    EditText inputFloor;
    EditText inputMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        inputBuilding = findViewById(R.id.inputBuilding);
        inputFloor = findViewById(R.id.inputFloor);
        inputMessage = findViewById(R.id.inputMessage);

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onClick(View v){
        switch (v.getId()){
            case R.id.enrollBtn:
                Drawable drawable = this.getResources().getDrawable(R.drawable.white);
                Intent resultIntent = new Intent();
                String location = inputBuilding.getText().toString() + " / " + inputFloor.getText().toString();
                HelpData newData = new HelpData(location, inputMessage.getText().toString());
                resultIntent.putExtra("data", newData);

                setResult(RESULT_OK, resultIntent);
                break;

            case R.id.cancelBtn:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}
