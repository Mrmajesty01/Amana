package com.majestyinc.amana;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class FragmentHome extends Fragment {
    CardView deposit,withdraw,send,save,invest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        deposit = getActivity().findViewById(R.id.deposit);
        withdraw = getActivity().findViewById(R.id.withdraw);
        send = getActivity().findViewById(R.id.send);
        save = getActivity().findViewById(R.id.save);
        invest = getActivity().findViewById(R.id.invest);

        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),DepositActivity.class);
                startActivity(intent);
            }
        });
    }
}
