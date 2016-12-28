package ke.co.darkcode.sensei.lilsizeducation.Welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ke.co.darkcode.sensei.lilsizeducation.R;

/**
 * Created by sensei on 06/07/16.
 */
public class TutorialFragment extends WelcomeActivityFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.welcome_tut_fragment, container, false);
        Button gotit = (Button) view.findViewById(R.id.gotit);
        gotit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((WelcomeActivity)getActivity()).getNextFragment();
            }
        });
        return view;

    }
}


