package edu.ucsb.cs.cs185.bryannaphan.fundguy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Danielle on 3/20/2017.
 */

public class SetBudgetDialog extends DialogFragment {


    /**
     * A simple {@link Fragment} subclass.
     */


    private static final String ARG_LAYOUT_RES_ID = "layoutResId";
    private int layoutResId;

    public static edu.ucsb.cs.cs185.bryannaphan.fundguy.SetBudgetFragment newInstance(int layoutResId) {
        edu.ucsb.cs.cs185.bryannaphan.fundguy.SetBudgetFragment setBudgetFragment = new edu.ucsb.cs.cs185.bryannaphan.fundguy.SetBudgetFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_RES_ID, layoutResId);
        setBudgetFragment.setArguments(args);

        return setBudgetFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID)) {
            layoutResId = getArguments().getInt(ARG_LAYOUT_RES_ID);
        }
    }

   // @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_set_budget, container, false);

        // TODO: Make this actually set the amount!
        final EditText amount = (EditText) view.findViewById(R.id.budgetAmount);
        final Button setBudgetButton = (Button) view.findViewById(R.id.setBudgetButton);


        setBudgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Budget.getInstance().setBudget(Integer.parseInt(amount.getText().toString()));
                BudgetEditListener listener = (BudgetEditListener) getTargetFragment();
                //listener.onEditReturnValue(Budget.getInstance().getBudget());
                getDialog().dismiss();
                //Intent myIntent = new Intent(getActivity(), MainActivity.class);
                //getActivity().startActivity(myIntent);
            }
        });

    /*FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view, "Budget has been successfully set", Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();
        }
    });*/

        return view;
    }


    public interface BudgetEditListener {
        public void onEditReturnValue(float mBudget);
    }

}

