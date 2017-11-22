package com.example.denis.tecladov3;


import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

/**
 * Created by rafael on 15/11/16.
 */

public class LineAdapter extends RecyclerView.Adapter {

    //private List<UserModel> livros; anterior
    private List<UserModel> livros;
    private Context context;

    public LineAdapter(List<UserModel> livros, Context context) {
        this.livros = livros;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gerencia, parent, false);
        Atualizar holder = new Atualizar(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,final int position) {

        Atualizar holder = (Atualizar) viewHolder;


        UserModel livro  = livros.get(position) ;

        holder.nome.setText(livro.getNomeLivro());
        /*
        holder.deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removerItem(position);
                notifyItemInserted(0);
               // recyclerView.getAdapter().notifyItemInserted(0);
            }
        });
        */
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removerItem(position);
                notifyItemInserted(0);
                // recyclerView.getAdapter().notifyItemInserted(0);
            }
        });




        //demais campos

    }

    @Override
    public int getItemCount() {
        return livros.size();
    }


    //------------------------------------------------------------------


    /**
     * Método publico chamado para atualziar a lista.
     *
     * @param user Novo objeto que será incluido na lista.
     */
    public void updateList(UserModel user) {
        insertItem(user);
    }
    public void removerItem(UserModel user) {
        insertItem(user);
    }

    // Método responsável por inserir um novo usuário na lista e notificar que há novos itens.
    private void insertItem(UserModel user) {
        livros.add(user);
        notifyItemInserted(getItemCount());
    }

    // Método responsável por atualizar um usuário já existente na lista.
    private void updateItem(int position) {
        UserModel userModel = livros.get(position);
       // userModel.incrementAge();
        notifyItemChanged(position);
    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {
        livros.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, livros.size());
    }
    //------------------------------------------------------------------


}


