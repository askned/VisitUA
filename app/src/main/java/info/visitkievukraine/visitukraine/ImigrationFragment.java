package info.visitkievukraine.visitukraine;


import android.app.Fragment;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.single_item)
public class ImigrationFragment extends Fragment {


    public ImigrationFragment() {
        // Required empty public constructor
    }

    @ViewById
    TextView textItem;

    @AfterViews
    void ready() {
        textItem.setText("ImigrationFragment ImigrationFragment ImigrationFragment");


    }


}
