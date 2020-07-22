package com.nextgenlabs.pizzapalace.Ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nextgenlabs.pizzapalace.Model.GreetingModel;
import com.nextgenlabs.pizzapalace.R;
import com.nextgenlabs.pizzapalace.Ui.Activity.HomeActivity;
import com.nextgenlabs.pizzapalace.Ui.Fragment.AllFragment;
import com.nextgenlabs.pizzapalace.Ui.Fragment.DrinksFragment;
import com.nextgenlabs.pizzapalace.Ui.Fragment.PastaFragment;
import com.nextgenlabs.pizzapalace.Ui.Fragment.PizzaFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    GreetingModel greetingModel = new GreetingModel();

    public HomeActivityAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 ){
            return 0;
        }
        else return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        View view;
        if(viewType == 0){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_a_home_upper_view, parent, false);
            holder = new UpperViewHolder(view);
        }
        else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_a_home_lower_view, parent, false);
            holder = new LowerViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UpperViewHolder){
            ((UpperViewHolder) holder).menuButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"menu Button Clicked",Toast.LENGTH_SHORT).show();
                }
            });

            ((UpperViewHolder) holder).cartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"cart Button Clicked",Toast.LENGTH_SHORT).show();
                }
            });
            if (greetingModel.getGetGreeting() != null)
            ((UpperViewHolder) holder).greetingTextView.setText(greetingModel.getGetGreeting());

            else {
                ((UpperViewHolder) holder).greetingTextView.setText("Sorry");
            }
            ((UpperViewHolder) holder).userName.setText(greetingModel.getUsername());
            ((UpperViewHolder) holder).searchView.clearFocus();
        }
        if (holder instanceof LowerViewHolder){
            lowerView(holder);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static class UpperViewHolder extends RecyclerView.ViewHolder {
        Button menuButton,cartButton;
        TextView greetingTextView,userName;
        SearchView searchView;
        public UpperViewHolder(@NonNull View itemView){
            super(itemView);
            menuButton = itemView.findViewById(R.id.homeAMenuButton);
            cartButton = itemView.findViewById(R.id.homeACartButton);
            greetingTextView= itemView.findViewById(R.id.homeAGoodMorningTextView);
            userName = itemView.findViewById(R.id.aHome_userName);
            searchView = itemView.findViewById(R.id.homeASearchBar);
        }
    }

    public static class LowerViewHolder extends RecyclerView.ViewHolder {
        BottomNavigationView bottomNavigationView;
        FrameLayout frameLayout;
        public LowerViewHolder(@NonNull View itemView){
            super(itemView);
            bottomNavigationView = itemView.findViewById(R.id.aHome_navigationView);
            frameLayout = itemView.findViewById(R.id.aHomeFragHolder);
        }
    }

    public void lowerView(RecyclerView.ViewHolder holder){
        AllFragment allFragment = new AllFragment();
        ((HomeActivity)context). getSupportFragmentManager().beginTransaction().add(R.id.aHomeFragHolder,allFragment).commit();
        ((LowerViewHolder) holder).bottomNavigationView.setSelectedItemId(R.id.nav_all);
        ((LowerViewHolder) holder).bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = new AllFragment();
                int id;
                switch (item.getItemId()){
                    case R.id.nav_all:
                        selectedFragment = new AllFragment();
                        id = R.id.nav_all;
                        break;
                    case R.id.nav_pizza:
                        selectedFragment = new PizzaFragment();
                        id = R.id.nav_pizza;
                        break;
                    case R.id.nav_pasta:
                        selectedFragment = new PastaFragment();
                        id = R.id.nav_pasta;
                        break;
                    case R.id.nav_drinks:
                        selectedFragment = new DrinksFragment();
                        id = R.id.nav_drinks;
                }
                ((HomeActivity)context).getSupportFragmentManager().beginTransaction().add(R.id.aHomeFragHolder,selectedFragment).commit();
                ((HomeActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.aHomeFragHolder,selectedFragment).commit();
                return true;
            }
        });
    }

}
