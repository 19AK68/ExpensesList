package com.ak.user.expenseslist.FragmentContent;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ak.user.expenseslist.R;

/**
 * Create AK 24/10/18
 */
public class FragmentContent extends Fragment {

    private  static final String KEY_TITLE="Content";



    public FragmentContent() {
        // Required empty public constructor
    }


    public static FragmentContent newInstance(String param1) {
        FragmentContent fragment = new FragmentContent();
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_fragment_content, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        String title =getArguments().getString(KEY_TITLE);
        ((TextView)view.findViewById(R.id.title)).setText(title);

    }
}
