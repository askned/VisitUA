package info.visitkievukraine.visitukraine;


import android.app.Fragment;
import android.support.v7.widget.CardView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;


@EFragment(R.layout.fragment_befor_visit)
public class BeforVisitFragment extends Fragment {


    public BeforVisitFragment() {
        // Required empty public constructor
    }

    CardView costcalcul;

    @AfterViews
    void ready() {


    }


}
