package goodman.gm.p_mobile.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import goodman.gm.p_mobile.Controller.Where;
import goodman.gm.p_mobile.R;

public class  OdauFragment extends Fragment {
    RecyclerView recyclerView;
    Where where ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_odau,container,false);
        recyclerView =view.findViewById(R.id.recyclerViewODau);
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        where = new Where(getContext());
        where.getDanhSachQuanAnController(recyclerView);
    }
}
