package ke.co.darkcode.sensei.lilsizeducation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ke.co.darkcode.sensei.lilsizeducation.MainActivity;
import ke.co.darkcode.sensei.lilsizeducation.R;

/**
 * Created by sensei on 28/12/15.
 */
public class IntroductionFragment extends MainActivityFragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_introduction, container, false);

        Button mathButton = (Button) view.findViewById(R.id.mathematics_button);
        mathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).getNextFragment();
            }
        });
        return view;
    }
}
