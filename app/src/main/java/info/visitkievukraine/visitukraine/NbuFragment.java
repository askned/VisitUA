package info.visitkievukraine.visitukraine;

import android.app.Fragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.rey.material.widget.FloatingActionButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;


@EFragment(R.layout.converter_fragment)
public class NbuFragment extends Fragment {

    @ViewById
    android.support.design.widget.FloatingActionButton fab;

    @ViewById
    Spinner spinnerval;

    @ViewById
    TextView cost_label, description_label, description_label2;

    @ViewById
    EditText name_label;

    @ViewById
    FloatingActionButton parsbutt;

    ArrayList<String> mCats = new ArrayList<String>();
    private String currceXml;
    private String sizeXml;

    @AfterViews
    void ready() {


        parsbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Snackbar.make(getView(), R.string.diferencurs, Snackbar.LENGTH_LONG)
                //          .setAction("Action", null).show();
                try {
                    getCurrensyRate();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }

            }
        });
        try {

            parseCurencySpiner();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // адаптер с данными, полученными через XPath для вывода в ListView
        Collections.sort(mCats); //сортируем
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, mCats);
        spinnerval.setAdapter(adapter);
    }

    private void parseCurencySpiner() throws Exception {

        // создаем объект InputSource из файла /res/raw/sample.xml
        InputSource inputSrc = new InputSource(getResources().openRawResource(
                R.raw.currrate));
        // Создаем экземпляр XPath
        XPath xpath = XPathFactory.newInstance().newXPath();
        // задаем выражение для разбора
        String expression = "//char3";
        // String expression = String.valueOf(name_label.getText());
        // список полученных узлов
        NodeList nodes = (NodeList) xpath.evaluate(expression, inputSrc,
                XPathConstants.NODESET);


        // если узел найден
        if (nodes != null && nodes.getLength() > 0) {
            mCats.clear();
            int len = nodes.getLength();
            for (int i = 0; i < len; ++i) {
                // query value
                Node node = nodes.item(i);
                // формируем списочный массив
                mCats.add(node.getTextContent());
            }
        }
    }

    public void getCurrensyRate() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);


        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();


        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(getResources().openRawResource(
                R.raw.currrate));

        String valutaname_label = spinnerval.getSelectedItem().toString();

        XPathExpression expr = null;
        XPathExpression expr2 = null;
        try {
            expr = xpath.compile("/chapter/item[char3='" + valutaname_label + "']/rate/text()");
            expr2 = xpath.compile("/chapter/item[char3='" + valutaname_label + "']/size/text()");
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        //evaluate expression result on XML document


        assert expr != null;
        try {
            currceXml = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        try {
            assert expr2 != null;
            sizeXml = (String) expr2.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }


        Float currceComplite;
        currceComplite = Float.valueOf(currceXml) / Float.valueOf(sizeXml);

        cost_label.setText(getString(R.string.cursLabel) + String.valueOf(currceComplite));
        Float resultComplite = Float.valueOf(name_label.getText().toString()) / currceComplite;
        Float resultComplite2 = Float.valueOf(name_label.getText().toString()) * currceComplite;

        String formattedString = String.format("%.02f", resultComplite);
        String formattedString2 = String.format("%.02f", resultComplite2);
        description_label.setText(new StringBuilder().append(name_label.getText()).append(" UAH = ").append(formattedString).append(" ").append(valutaname_label).toString());
        description_label2.setText(new StringBuilder().append(name_label.getText()).append(" ").append(valutaname_label).append(" = ").append(formattedString2).append(" UAH").toString());
        //    description_label.setText(getString(R.string.summaLabel) + formattedString + valutaname_label);

    }
}
