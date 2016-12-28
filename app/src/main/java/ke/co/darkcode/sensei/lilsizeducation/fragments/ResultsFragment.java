package ke.co.darkcode.sensei.lilsizeducation.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ke.co.darkcode.sensei.lilsizeducation.MainActivity;
import ke.co.darkcode.sensei.lilsizeducation.R;

/**
 * Created by sensei on 28/12/15.
 */
public class ResultsFragment extends MainActivityFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =inflater.inflate(R.layout.fragment_results, container, false);
        TextView results = (TextView)view.findViewById(R.id.results_text);

        final MainActivity activity = (MainActivity)getActivity();
        results.setText(activity.finalResult());

        Button startOver = (Button) view.findViewById(R.id.start_over_button);
        startOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getNextFragment();
            }
        });
        return view;
    }
}
