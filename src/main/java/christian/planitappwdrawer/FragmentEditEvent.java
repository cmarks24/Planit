package christian.planitappwdrawer;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import christian.planitappwdrawer.R;

public class FragmentEditEvent extends Fragment {
    private static final String TAG = "EditEvent";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_event_edit, container, false);


           Button btn = (Button) view.findViewById(R.id.buttonSubmit);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    startActivity(i);

                }
            });




        return view;
    }


    public interface OnFragmentInteractionListener {
    }
}