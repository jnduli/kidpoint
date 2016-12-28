package ke.co.darkcode.sensei.lilsizeducation.Welcome;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ke.co.darkcode.sensei.lilsizeducation.BlankActivity;
import ke.co.darkcode.sensei.lilsizeducation.R;
import ke.co.darkcode.sensei.lilsizeducation.utils.SettingsUtils;

public class WelcomeActivity extends AppCompatActivity implements WelcomeActivityFragment.WelcomeActivityFragmentContainer{

    int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        changeFragment();
    }

    private void changeFragment(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.animator.enter_anim, R.animator.exit_anim);
        transaction.replace(R.id.question_content, getCurrentFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private WelcomeActivityFragment getCurrentFragment(){
        return getWelcomeFragments().get(count++);
    }
    @Override
    public void getNextFragment() {
        if(count >= getWelcomeFragments().size() || SettingsUtils.isWelcomeSkipped(getBaseContext())){
            SettingsUtils.markWelcomeShown(getBaseContext());
            Intent intent = new Intent(WelcomeActivity.this, BlankActivity.class);
            startActivity(intent);
        }
        else
            changeFragment();
    }

    private static List<WelcomeActivityFragment> getWelcomeFragments(){
        return new ArrayList<WelcomeActivityFragment>(Arrays.asList(
                new IntroductionFragment(),
                new DescriptionFragment(),
                new TutorialFragment(),
                new BadgesFragment()
        ));
    }
}
