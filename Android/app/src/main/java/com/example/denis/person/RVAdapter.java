package com.example.denis.person;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public  class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

    ArrayList<Person> pp;
    private RVAdapter.OnItemClickListener<Person> onItemClickListener;



    public   class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personId;
        TextView personFname;
        TextView personLname;
        TextView personAge;


        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card);
            personId = (TextView)itemView.findViewById(R.id.personid);
            personFname = (TextView)itemView.findViewById(R.id.personfname);
            personLname = (TextView)itemView.findViewById(R.id.personlname);
            personAge = (TextView)itemView.findViewById(R.id.personage);
        }
    }

    public void updateList(ArrayList<Person> list) {
        this.pp.clear();
        this.pp.addAll(list);
        this.notifyDataSetChanged();
    }

    RVAdapter(){
        this.pp = new ArrayList<Person>();
    }
    @Override
    public int getItemCount() {
        return pp.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
       PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }
    @Override
    public void onBindViewHolder(RVAdapter.PersonViewHolder personViewHolder, final int i) {
        final Person p = pp.get(i);
        personViewHolder.personId.setText(String.valueOf(pp.get(i).Id));
        personViewHolder.personFname.setText(pp.get(i).Fname);
        personViewHolder.personLname.setText(pp.get(i).Lname);
        personViewHolder.personLname.setText(String.valueOf(pp.get(i).Age));
        personViewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (onItemClickListener != null)
                    onItemClickListener.onItemClick(i, p);
            }
        });
    }
    public void setOnItemClickListener(RVAdapter.OnItemClickListener<Person> onItemClickListener)
    {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener<Person>
    {
        void onItemClick(int position, Person item);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}