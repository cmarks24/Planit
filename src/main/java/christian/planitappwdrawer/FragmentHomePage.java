package christian.planitappwdrawer;

import android.view.View;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import christian.planitappwdrawer.R;

public class FragmentHomePage extends Fragment {
    private static final String TAG = "HomePage";

    static public boolean boo = false;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        Button btn = (Button) view.findViewById(R.id.event4);

        if (boo == false)
        {
            btn.setVisibility(View.GONE);
        }
        else if (boo == true)
        {
            btn.setVisibility(View.VISIBLE);
        }

        return view;
    }

    public interface OnFragmentInteractionListener {
    }
}