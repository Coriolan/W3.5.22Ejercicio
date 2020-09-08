package com.example.w3522project.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.w3522project.R;
import com.example.w3522project.pojo.Mascota;

import java.util.ArrayList;
import java.util.Random;

public class MascotasBuilder {

        private static final int RATING = 1;
        private Context context;

        public MascotasBuilder(Context context) {
            this.context = context;
            BaseDatos db = new BaseDatos(this.context);
            if (db.obtenerTodasLasMascotas().isEmpty()) {
                insertarMascotas(db);
            }
        }

        public ArrayList<Mascota> obtenerDatos() {
            BaseDatos db = new BaseDatos(this.context);

            return db.obtenerTodasLasMascotas();
        }

        public ArrayList<Mascota> obtenerDatosFavoritos() {
            BaseDatos db = new BaseDatos(this.context);
            return db.obtenerMascotasFavoritas();
        }

        public void insertarMascotas(BaseDatos db) {
            ContentValues values = new ContentValues();
            ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

            Random rand = new Random();

            mascotas.add(new Mascota("Cathy", rand.nextInt(11), R.drawable.pet1));
            mascotas.add(new Mascota("Ronny", rand.nextInt(11), R.drawable.pet2));
            mascotas.add(new Mascota("Firulais", rand.nextInt(11), R.drawable.pet3));
            mascotas.add(new Mascota("Fido", rand.nextInt(11), R.drawable.pet4));
            mascotas.add(new Mascota("Pluto", rand.nextInt(11), R.drawable.pet5));
            mascotas.add(new Mascota("Ayudante de Santa", rand.nextInt(11), R.drawable.pet6));
            mascotas.add(new Mascota("Snoopy", rand.nextInt(11), R.drawable.pet7));
            mascotas.add(new Mascota("Odie", rand.nextInt(11), R.drawable.pet8));
            mascotas.add(new Mascota("Garfield", rand.nextInt(11), R.drawable.pet9));
            mascotas.add(new Mascota("Simba", rand.nextInt(11), R.drawable.pet10));

            for (Mascota m : mascotas) {
                values.put(ConstantesDB.TABLA_MASCOTA_NOMBRE, m.getNombre());
                values.put(ConstantesDB.TABLA_MASCOTA_FOTO, m.getFoto());

                db.insertarMascota(values);
            }
        }

        public void darRating(Mascota mascota) {
            BaseDatos db = new BaseDatos(context);
            ContentValues values = new ContentValues();

            values.put(ConstantesDB.TABLA_RATING_ID_MASCOTA, mascota.getId());
            values.put(ConstantesDB.TABLA_RATING_NUMERO_RATING, RATING);

            db.insertarRatingMascota(values);
        }

        public int obtenerRating(Mascota mascota) {
            BaseDatos db = new BaseDatos(context);
            return db.obtenerRating(mascota);
        }

        public Mascota obtenerMascotaPorId(int id) {
            BaseDatos db = new BaseDatos(context);
            return db.obtenerMascota(id);
        }
    }

