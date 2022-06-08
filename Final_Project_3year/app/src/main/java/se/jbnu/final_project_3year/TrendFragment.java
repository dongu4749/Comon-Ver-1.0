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
 * Use the {@link TrendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrendFragment extends PreferenceFragmentCompat {


    SharedPreferences prefs;

    public static TrendFragment newInstance() {
        return new TrendFragment();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.trend_preference);
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        prefs.registerOnSharedPreferenceChangeListener(prefListener);

        Preference buttonTrend = (Preference) findPreference("Trend");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("메타버스(metaverse) 또는 확장 가상 세계는 가상, 초월을 의미하는 '메타'(meta)와 세계, 우주를 의미하는 '유니버스'(universe)를 합성한 신조어다.[1] '가상 우주'라고 번역하기도 했다. 1992년 출간한 닐 스티븐슨의 소설 '스노 크래시'에서 가장 먼저 사용했다.[2] 이는 3차원에서 실제 생활과 법적으로 인정한 활동인 직업, 금융, 학습 등이 연결된 가상 세계를 뜻한다. 가상현실, 증강현실의 상위 개념으로서 현실을 디지털 기반의 가상 세계로 확장해 가상 공간에서 모든 활동을 할 수 있게 만드는 시스템이다. 구체적으로 정치와 경제, 사회, 문화 전반적 측면에서 현실과 비현실이 공존하는 생활형, 게임형 가상 세계라는 의미로 폭넓게 사용한다");

        AlertDialog alertDialog = builder.create();

        buttonTrend.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
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