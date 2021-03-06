package gr.aueb.softeng.project1805.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import gr.aueb.softeng.project1805.R;

public class HomePageSMS extends android.support.v4.app.Fragment {

    private View view;
    private TextView smsFromPackages, smsFromFriends;
    ArrayList<View> active_packages=new ArrayList<>();
    LayoutInflater inflater;
    LinearLayout list;

    public HomePageSMS() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.home_page_sms, container, false);
        this.inflater=inflater;

        smsFromPackages= view.findViewById(R.id.sms_from_packages);
        smsFromFriends=view.findViewById(R.id.sms_from_friends);
        return view;
    }

    public void setSMSFromPackages (String sms) {
        smsFromPackages.setText(sms);
    }

    public void setSMSFromFriends (String sms) {
        smsFromFriends.setText(sms);
    }

    public void addActivePackage(String name, String expiration, String remaining) {
        list=view.findViewById(R.id.scroll_active_packages).findViewById(R.id.packages_view);

        final View active_package=inflater.inflate(R.layout.active_package_view, null);
        list.addView(active_package, list.getChildCount()-1 );
        active_packages.add(active_package);

        final TextView txtName=active_package.findViewById(R.id.package_name);
        txtName.setText(name);

        final TextView txtExpiration=active_package.findViewById(R.id.expiration);
        txtExpiration.setText(expiration);

        final TextView txtRemaining=active_package.findViewById(R.id.remaining);
        txtRemaining.setText(remaining);
    }


    public View getAddView() {

        return view.findViewById(R.id.add);
    }

    public void clearView() {
        if (active_packages.size()!=0) {
            for (View v : active_packages) {
                list.removeView(v);
            }
            active_packages.clear();
        }
    }
}
