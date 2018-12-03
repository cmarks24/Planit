package christian.planitappwdrawer;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.view.LayoutInflater;

public class GroupPageFunctions extends Fragment {

    final Context context = this.getContext();
    private Button button;
    private EditText result;
    private Button leave;
    private Button del;
    private Button del1;

    //static public boolean boo = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_group_page);

        LayoutInflater li = LayoutInflater.from(context);
        View v = li.inflate(R.layout.fragment_group_page, null);

        final TextView title = v.findViewById(R.id.Title3);
        final Button bt1 = v.findViewById(R.id.VM3);
        final Button bt2 = v.findViewById(R.id.IM3);
        final Button bt3 = v.findViewById(R.id.VGS3);
        final Button bt4 = v.findViewById(R.id.LG3);
        final Button bt5 = v.findViewById(R.id.DG3);

        final TextView group_2_title = v.findViewById(R.id.Title2);
        final Button g2_btn1 = v.findViewById(R.id.VM2);
        final Button g2_btn2 = v.findViewById(R.id.IM2);
        final Button g2_btn3 = v.findViewById(R.id.VGS2);
        final Button g2_btn4 = v.findViewById(R.id.LG2);
        final Button g2_btn5 = v.findViewById(R.id.DG2);

        title.setVisibility(View.INVISIBLE);
        bt1.setVisibility(View.INVISIBLE);
        bt2.setVisibility(View.INVISIBLE);
        bt3.setVisibility(View.INVISIBLE);
        bt4.setVisibility(View.INVISIBLE);
        bt5.setVisibility(View.INVISIBLE);



        // components from activity_groups.xml
        button = (Button) v.findViewById(R.id.AddGroup);
        leave = (Button) v.findViewById(R.id.LG2);
        del = (Button) v.findViewById(R.id.DG3);
        del1 = v.findViewById(R.id.DG1);

        // add button listener
        button.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg0){

                // get add_new_group_prompt.xml view
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.add_new_group_prompt, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // set add_new_group_prompt.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView.findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                title.setVisibility(View.VISIBLE);
                                bt1.setVisibility(View.VISIBLE);
                                bt2.setVisibility(View.VISIBLE);
                                bt3.setVisibility(View.VISIBLE);
                                bt4.setVisibility(View.VISIBLE);
                                bt5.setVisibility(View.VISIBLE);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();



            }
        });
        leave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                group_2_title.setVisibility(View.GONE);
                g2_btn1.setVisibility(View.GONE);
                g2_btn2.setVisibility(View.GONE);
                g2_btn3.setVisibility(View.GONE);
                g2_btn4.setVisibility(View.GONE);
                g2_btn5.setVisibility(View.GONE);
            }
        });

        del.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                title.setVisibility(View.GONE);
                bt1.setVisibility(View.GONE);
                bt2.setVisibility(View.GONE);
                bt3.setVisibility(View.GONE);
                bt4.setVisibility(View.GONE);
                bt5.setVisibility(View.GONE);
            }
        });

        del1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                CharSequence text = "Don't do that.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}