package br.com.evjdev.minhaagenda.control;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.evjdev.minhaagenda.R;
import br.com.evjdev.minhaagenda.model.Tarefa;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.ViewHolder> {

    private List<Tarefa> listTarefa;
    private Context context;

    public TarefaAdapter(Context context, List<Tarefa> listTarefa) {
        this.listTarefa = listTarefa;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_tarefa, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNome.setText(listTarefa.get(position).getNome());
        holder.tvDesc.setText(listTarefa.get(position).getDesc());
        holder.tvData.setText(listTarefa.get(position).getData());
        holder.tvHora.setText(listTarefa.get(position).getHora());
    }

    @Override
    public int getItemCount() {
        return listTarefa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNome;
        public TextView tvDesc;
        public TextView tvData;
        public TextView tvHora;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNome = itemView.findViewById(R.id.tvNome);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            tvData = itemView.findViewById(R.id.tvData);
            tvHora = itemView.findViewById(R.id.tvHora);
        }
    }
}
