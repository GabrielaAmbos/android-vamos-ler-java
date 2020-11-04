package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import pojos.Crianca;

/**
 * Created by Gabri on 28/10/2017.
 */

public class CriancaDao {
        private SQLiteDatabase db;
        private static final String NOME_TABELA = "Crianca";
        private static final String COLUNA_ID_CRIANCA = "idCrianca";
        private static final String COLUNA_NOME_CRIANCA = "nomeCrianca";
        public static final String CREATE_TABLE = ("CREATE TABLE " + NOME_TABELA + " ( " + COLUNA_ID_CRIANCA + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE ," +  COLUNA_NOME_CRIANCA + " TEXT NOT NULL UNIQUE, )");

        public CriancaDao(Context ctx){
            db = SQLite.getInstance(ctx).getWritableDatabase();

        }

        public boolean Cadastrar(Crianca crianca){
            long id = this.db.insert(NOME_TABELA,null,criancaToContentValues(crianca));
            if(id==-1){
                return false;
            }
            return true;
        }

        public boolean Editar(Crianca crianca){
            String where = "WHERE " + COLUNA_ID_CRIANCA + "= ?";
            String [] whereargs = {String.valueOf(crianca.getIdCrianca())};
            int registroAfetados = this.db.update(NOME_TABELA,this.criancaToContentValues(crianca), where, whereargs);
            if(registroAfetados > 0){
                return true;
            }
            return false;
        }
    public boolean excluir(int id){

        String where = "WHERE " + COLUNA_ID_CRIANCA + "= ?";
        String [] whereargs = {String.valueOf(id)};
        int registrosAfetados = this.db.delete(NOME_TABELA, where, whereargs);

        if(registrosAfetados>0){
            return true;
        }

        return false;
    }
    public ArrayList<Crianca> listar(){

        ArrayList<Crianca> listaCrianca = new ArrayList<Crianca>();
        String sqlListar = "SELECT * FROM " + NOME_TABELA;
        Cursor cursor = this.db.rawQuery(sqlListar, null);
        Crianca crianca;

        int indiceId = cursor.getColumnIndex(COLUNA_ID_CRIANCA);
        int indiceNome = cursor.getColumnIndex(COLUNA_NOME_CRIANCA);

        while(cursor.moveToNext()){

            crianca = new Crianca();

            crianca.setIdCrianca(cursor.getInt(indiceId));
            crianca.setNomeCrianca(cursor.getString(indiceNome));
            listaCrianca.add(crianca);
        }

        return listaCrianca;
    }


    private ContentValues criancaToContentValues(Crianca crianca){
            ContentValues vv = new ContentValues();
            vv.put(COLUNA_NOME_CRIANCA, crianca.getNomeCrianca());
            return vv;
        }

    }


