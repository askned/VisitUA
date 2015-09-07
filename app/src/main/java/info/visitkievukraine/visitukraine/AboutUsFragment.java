package info.visitkievukraine.visitukraine;

import android.app.Fragment;

import android.net.Uri;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.LikeView;
import com.facebook.share.widget.ShareButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.sufficientlysecure.htmltextview.HtmlTextView;


@EFragment(R.layout.aboutus)
public class AboutUsFragment extends Fragment {
    @ViewById
    LikeView like_view;

    @ViewById
    TextView textView;

    @ViewById
    HtmlTextView html_text;

    @ViewById
    ShareButton shareButton;

    ShareLinkContent content = new ShareLinkContent.Builder()
            .setContentUrl(Uri.parse("https://www.facebook.com/kievnightlifetravel"))
            .build();

    @AfterViews
    void ready() {
       // FacebookSdk.sdkInitialize(getApplicationContext());

        shareButton.setShareContent(content);

        like_view.setObjectIdAndType(
                "https://www.facebook.com/kievnightlifetravel",
                LikeView.ObjectType.PAGE);



// loads html from string and displays cat_pic.png from the app's drawable folder
        html_text.setHtmlFromString(getString(R.string.textmain), new HtmlTextView.LocalImageGetter());
    }
}