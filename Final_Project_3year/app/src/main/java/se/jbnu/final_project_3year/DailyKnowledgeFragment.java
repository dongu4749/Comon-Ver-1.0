package se.jbnu.final_project_3year;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DailyKnowledgeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DailyKnowledgeFragment extends PreferenceFragmentCompat {

    SharedPreferences prefs;

    public static DailyKnowledgeFragment newInstance() {
        return new DailyKnowledgeFragment();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.dailyknowledge_preference);
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        prefs.registerOnSharedPreferenceChangeListener(prefListener);

        Preference buttonDaily = (Preference) findPreference("DailyKnowledge");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("소프트웨어 공학은 인류의 이익을 위해서 소프트웨어와 관련된 원리, 지식, 도구등을 활용하여 새로운 제품, 도구등을 만드는 것이라고 볼 수 있는데, 더 학문적 개념으로 살펴보자면, 소프트웨어의 개발, 운용, 유지보수등의 생명 주기 전반을 체계적이고 서술적이며 정량적으로 다루는 학문이다.");

        AlertDialog alertDialog = builder.create();

        buttonDaily.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                //open browser or intent here
                alertDialog.show();
                return true;
            }
        });
    }

    SharedPreferences.OnSharedPreferenceChangeListener prefListener =
            new SharedPreferences.OnSharedPreferenceChangeListener() {
                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                    // key값에 해당하는 명령 넣기
                }
            };

    public void onBackPressed() { //뒤로가기 했을 때
        Intent intent = new Intent(getActivity().getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        return ;
    }

}