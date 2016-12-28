package ke.co.darkcode.sensei.lilsizeducation.Welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ke.co.darkcode.sensei.lilsizeducation.R;
import ke.co.darkcode.sensei.lilsizeducation.utils.SettingsUtils;

/**
 * Created by sensei on 06/07/16.
 */
public class IntroductionFragment extends WelcomeActivityFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.welcome_intro_fragment, container, false);

        TextView appname = (TextView) view.findViewById(R.id.wif_appname);
        String appnameformatted = getResources().getString(R.string.app_name_formatted);
        appname.setText(Html.fromHtml(appnameformatted));

        Button next = (Button) view.findViewById(R.id.wif_next);
        Button skip = (Button) view.findViewById(R.id.wif_skip);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((WelcomeActivity) getActivity()).getNextFragment();
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsUtils.markWelcomeSkipped(getActivity().getBaseContext());
                ((WelcomeActivity)getActivity()).getNextFragment();
            }
        });
        return view;

    }
}
