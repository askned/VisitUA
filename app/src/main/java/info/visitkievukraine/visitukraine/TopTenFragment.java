package info.visitkievukraine.visitukraine;

import android.app.Fragment;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.single_item_scrool)
public class TopTenFragment extends Fragment {
    @ViewById
    TextView textItem;

    @AfterViews
    void ready() {
        textItem.setText(R.string.top10see);


    }
}
