package org.aplas.bissmillah_uas;

import android.database.sqlite.SQLiteDatabase;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class Database {
    public static final String DATABASE_NAME = "enilai";
    public static SQLiteDatabase mDatabase;

    //membuat table siswa
    public static void createSiswaTable(){
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS siswa (\n" +
                        "    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "    nama varchar(100) NOT NULL,\n" +
                        "    nisn varchar(100) NOT NULL,\n" +
                        "    kelas varchar(20) NOT NULL,\n" +
                        "    semester varchar(20) NOT NULL,\n" +
                        "    nt1 INTEGER(3) NOT NULL,\n" +
                        "    nt2 INTEGER(3) NOT NULL,\n" +
                        "    nt3 INTEGER(3) NOT NULL,\n" +
                        "    nt4 INTEGER(3) NOT NULL,\n" +
                        "    nt5 INTEGER(3) NOT NULL,\n" +
                        "    nt6 INTEGER(3) NOT NULL,\n" +
                        "    nt7 INTEGER(3) NOT NULL,\n" +
                        "    nt8 INTEGER(3) NOT NULL,\n" +
                        "    nt9 INTEGER(3) NOT NULL,\n" +
                        "    nt10 INTEGER(3) NOT NULL,\n" +
                        "    nt11 INTEGER(3) NOT NULL,\n" +
                        "    nt12 INTEGER(3) NOT NULL,\n" +
                        "    nt13 INTEGER(3) NOT NULL,\n" +
                        "    nt14 INTEGER(3) NOT NULL,\n" +
                        "    nt15 INTEGER(3) NOT NULL,\n" +
                        "    nt16 INTEGER(3) NOT NULL,\n" +
                        "    nt17 INTEGER(3) NOT NULL,\n" +
                        "    nt18 INTEGER(3) NOT NULL,\n" +
                        "    nt19 INTEGER(3) NOT NULL,\n" +
                        "    nt20 INTEGER(3) NOT NULL,\n" +
                        "    nt21 INTEGER(3) NOT NULL,\n" +
                        "    nt22 INTEGER(3) NOT NULL,\n" +
                        "    nph INTEGER(10) NOT NULL,\n" +
                        "    npts INTEGER(3) NOT NULL,\n" +
                        "    npas INTEGER(3) NOT NULL,\n" +
                        "    nspiritual varchar(100) NOT NULL,\n" +
                        "    nsosial varchar(100) NOT NULL,\n" +
                        "    na INTEGER(10) NOT NULL,\n" +
                        "    nrapot varchar(2) NOT NULL\n" +
                        ");"
        );
    }

    //membuat table kompetensi dasar
    public static void createKdTable(){
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS kd (\n" +
                        "    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "    nokd varchar(5) NOT NULL,\n" +
                        "    namakd varchar(100) NOT NULL,\n" +
                        "    t1 varchar(100) NOT NULL,\n" +
                        "    t2 varchar(100) NOT NULL,\n" +
                        "    t3 varchar(100) NOT NULL,\n" +
                        "    t4 varchar(100) NOT NULL\n" +
                        ");"
        );
    }

    //membuat table user
    public static void createUserTable(){
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS user (\n" +
                        "    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                        "    namalengkap varchar(100) NOT NULL,\n" +
                        "    nip INTEGER(20) NOT NULL,\n" +
                        "    alamat varchar(100) NOT NULL,\n" +
                        "    mapel varchar(30) NOT NULL,\n" +
                        "    username varchar(20) NOT NULL,\n" +
                        "    password varchar(20) NOT NULL,\n" +
                        "    joiningdate datetime NOT NULL\n" +
                        ");"
        );
    }
}
