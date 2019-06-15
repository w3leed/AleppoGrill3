
package  waleeed.my.aleppogrill.Recycle_menuItem;




import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import waleeed.my.aleppogrill.R;

public class MenuAdapter extends  RecyclerView.Adapter<MenuAdapter.viewHolder> {


    ArrayList<Data> data;
    OnItemclick onItemclick;

    public void setOnItemclick(OnItemclick onItemclick) {
        this.onItemclick = onItemclick;
    }


    public MenuAdapter(ArrayList<Data> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        final Data item=data.get(position);
        holder.txt1.setText(item.getTxt1());
        holder.txt2.setText(item.getTxt2());
        holder.txt3.setText(item.getTxt3());
        holder.imag.setImageResource(item.getImag());
        if(holder!=null)
        {
            holder.cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemclick.onitemclick(item,position);
                }
            });

        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class viewHolder extends RecyclerView.ViewHolder
    {
        TextView txt1,txt2, txt3;

        ImageView imag;
        View cardview;
        viewHolder(View view)
        {
            super(view);
            txt1=view.findViewById(R.id.txxview1);
            txt2=view.findViewById(R.id.txtview2);
            txt3=view.findViewById(R.id.txtview3);
            imag=view.findViewById(R.id.imagview);
            cardview=view;

        }

    }

    public interface OnItemclick{

        public void onitemclick(Data data,int position);


    }
}
