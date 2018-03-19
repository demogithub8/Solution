package com.example.harry.solution.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.harry.solution.R;
import com.example.harry.solution.model.Forecast;
import com.example.harry.solution.model.JsonResponse;
import com.example.harry.solution.model.MyApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<JsonResponse>, View.OnClickListener {
    private static final String MAIN_ACTIVITY_DATA_FRAGMENT = "MAIN_ACTIVITY_DATA_FRAGMENT";
    private EditText editText;
    private Button button;
    private Boolean errorDialogDisplaying;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private DataFragment dataFragment;
    private ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerView);

        FragmentManager fragmentManager = getSupportFragmentManager();
        dataFragment = (DataFragment) fragmentManager.findFragmentByTag(MAIN_ACTIVITY_DATA_FRAGMENT);
        if (dataFragment == null) {
            dataFragment = new DataFragment();
            fragmentManager.beginTransaction().add(dataFragment, MAIN_ACTIVITY_DATA_FRAGMENT).commit();

            errorDialogDisplaying = false;
        } else {
            recyclerViewAdapter = dataFragment.recyclerViewAdapter;
            errorDialogDisplaying = dataFragment.errorDialogDisplaying;

            recyclerView.setAdapter(recyclerViewAdapter);
            recyclerViewAdapter.notifyDataSetChanged();

            if (errorDialogDisplaying) {
                displayErrorDialog();
            }
        }

        button.setOnClickListener(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        dataFragment.recyclerViewAdapter = recyclerViewAdapter;
        dataFragment.errorDialogDisplaying = errorDialogDisplaying;
    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            String city = editText.getText().toString().trim();
            if (!city.isEmpty()) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(MyApi.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                MyApi myApi = retrofit.create(MyApi.class);
                Call<JsonResponse> call = myApi.getForecast(MyApi.buildQuery(city));
                call.enqueue(this);

                FragmentManager fragmentManager = getSupportFragmentManager();
                progressDialogFragment.show(fragmentManager, "ProgressDialogFragment");
            } else {
                clearRecyclerView();
            }
        }
    }

    @Override
    public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
        if (response.body() != null && response.body().getQuery() != null && response.body().getQuery().getResults() != null) {
            List<Forecast> forecasts = response.body().getQuery().getResults().getChannel().getItem().getForecast();
            recyclerViewAdapter = new RecyclerViewAdapter(forecasts);
            recyclerView.setAdapter(recyclerViewAdapter);
            recyclerViewAdapter.notifyDataSetChanged();
            progressDialogFragment.dismiss();
        } else {
            clearRecyclerView();
            displayErrorDialog();
        }
    }

    @Override
    public void onFailure(Call<JsonResponse> call, Throwable t) {
        clearRecyclerView();
        displayErrorDialog();
    }

    private void clearRecyclerView() {
        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<>());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();
        progressDialogFragment.dismiss();
    }

    private void displayErrorDialog() {
        errorDialogDisplaying = true;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.error);
        alertDialogBuilder.setPositiveButton(R.string.ok, (dialog, which) -> dialog.dismiss());
        alertDialogBuilder.setOnDismissListener(dialog -> errorDialogDisplaying = false);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public static class DataFragment extends Fragment {
        private RecyclerViewAdapter recyclerViewAdapter;
        private Boolean errorDialogDisplaying;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setRetainInstance(true);
        }
    }
}
