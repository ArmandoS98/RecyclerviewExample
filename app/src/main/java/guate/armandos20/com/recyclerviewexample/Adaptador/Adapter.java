package guate.armandos20.com.recyclerviewexample.Adaptador;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import guate.armandos20.com.recyclerviewexample.Entidad.Item;
import guate.armandos20.com.recyclerviewexample.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements View.OnClickListener{
    private static final String TAG = Adapter.class.getSimpleName();
    private static final int ITEM_COUNT = 50;
    private static final int TYPE_INACTIVE = 0;
    private static final int TYPE_ACTIVE = 1;
    private List<Item> items;
    private View.OnClickListener listener;

    public Adapter() {
        super();


        //Create some items
        Random random = new Random();
        items = new ArrayList<>();
        for (int i = 0; i < ITEM_COUNT; ++i){
            items.add(new Item("Item " + i, "This is the number " + i, random.nextBoolean()));
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final int layout = viewType == TYPE_INACTIVE ? R.layout.item_layout : R.layout.item_layout_active;

        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Item item = items.get(position);

        holder.titulo.setText(item.getTitulo());
        holder.subTitulos.setText(item.getDescripcion() + ", with is " +
                (item.isActivo() ? "activo" : "inactivo"));

        //Spam the item is active
        final ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp instanceof StaggeredGridLayoutManager.LayoutParams){
            StaggeredGridLayoutManager.LayoutParams sglp = (StaggeredGridLayoutManager.LayoutParams) lp;
            sglp.setFullSpan(item.isActivo());
            holder.itemView.setLayoutParams(sglp);
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        final Item item = items.get(position);
        return item.isActivo() ? TYPE_ACTIVE : TYPE_INACTIVE;
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onClick(v);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private static final String TAG = "ViewHolder";

        TextView titulo;
        TextView subTitulos;

        public ViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo);
            subTitulos = itemView.findViewById(R.id.sub_titulo);

        }
    }
}
