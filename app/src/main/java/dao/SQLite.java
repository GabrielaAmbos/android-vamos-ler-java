package dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "bd_crianca";
    private static final int VERSÃO = 1;

    private static SQLite instance;

    private SQLite(Context context) {
        super(null, NOME_BANCO, null, VERSÃO);
    }

    public static SQLite getInstance(Context context){
        if(instance == null){
            instance = new SQLite(context);
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CriancaDao.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
