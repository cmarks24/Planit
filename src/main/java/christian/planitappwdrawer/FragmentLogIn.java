package christian.planitappwdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import christian.planitappwdrawer.MainActivity;



public class FragmentLogIn extends Fragment implements TextWatcher {
    private static final String TAG = "Fragment1";

    private Button btnNavFrag1;
    private Button btnNavFrag2;
    private Button btnNavSecondActivity;
    EditText editTextPassword = null;
    String blah;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_login, container, false);
        btnNavFrag1 = (Button) view.findViewById(R.id.btnNavFrag1);
        btnNavFrag2 = (Button) view.findViewById(R.id.btnNavFrag2);
        btnNavSecondActivity = (Button) view.findViewById(R.id.btnNavSecondActivity);
        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);
        editTextPassword.addTextChangedListener(this);
        Log.d(TAG, "onCreateView: started.");

        btnNavFrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Log In Screen", Toast.LENGTH_SHORT).show();

                ((SecondActivity)getActivity()).setViewPager(0);
            }
        });


        btnNavFrag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to User Registration", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), RegistrationActivity.class);
                startActivity(intent);

            }
        });


        btnNavSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(blah.equals(null)){ blah.equals("Wrong");}
                else if( blah.equals( "Testing" )|| blah.equals( "testing")) {
                    Toast.makeText(getActivity(), "Going to HomePage", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity(),"Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        blah = s.toString();

    }
}