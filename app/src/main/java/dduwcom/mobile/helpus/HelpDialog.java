package dduwcom.mobile.helpus;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HelpDialog {
    private Context context;

    HelpDataManager helpDataManager = new HelpDataManager();
    ArrayList<HelpData> helpDataList = helpDataManager.getHelpDataList();

    public HelpDialog(Context context){
        this.context = context;
    }

    public void callFunction(int pos){

        final Dialog dialog = new Dialog(context);

        dialog.setContentView(R.layout.add_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView location= dialog.findViewById(R.id.location_Inform);
        TextView msg = dialog.findViewById(R.id.msg_Inform);
        Button helpBtn = dialog.findViewById(R.id.helpBtn);
        Button shareBtn = dialog.findViewById(R.id.shareBtn);
        ImageView imageViewClose = dialog.findViewById(R.id.imageViewClose);

        location.setText(helpDataList.get(pos).getLocation());
        msg.setText(helpDataList.get(pos).getMsg());

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //내가 도와줄게요 버튼
        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //요청 공유하기 버튼
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        dialog.show();
    }
}
