package com.example.bsef19a532mobilecomputinglearningandteachingapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {
    public static int[] images = {
            R.drawable.tree,
            R.drawable.fire,
            R.drawable.water,
            R.drawable.rock,
    };
    public static String[] contents = {
            "tree",
            "fire",
            "water",
            "stone"
    };
    public static ArrayList<Integer> covered_indexes = new ArrayList<Integer>();

    public static int get_random_int(int max ) {
        Random rand = new Random();
        return rand.nextInt( max + 1 );
    }

    public static int get_random_int(int max, int ignore ) {
        Random rand = new Random();
        int temp = rand.nextInt( max + 1 );
        while ( temp == ignore ) {
            temp = rand.nextInt( max + 1 );
        }
        return temp;
    }

    public static int get_random_int(int max, int ignore, int ignore2 ) {
        Random rand = new Random();
        int temp = rand.nextInt( max + 1 );
        while ( temp == ignore || temp == ignore2 ) {
            temp = rand.nextInt( max + 1 );
        }
        return temp;
    }

    public static Intent exam_intent(Context packageContext, Class cls, int score ) {
        Intent intent = new Intent(packageContext, cls);
        int index = Data.get_random_int( Data.images.length - 1 );
        while ( Data.covered_indexes.contains(index) ) {
            index = Data.get_random_int( Data.images.length - 1 );
        }

        Data.covered_indexes.add( index );

        intent.putExtra("image", Data.images[ index ]);
        intent.putExtra("correct_option", Data.contents[ index ]);

        int wrong_index_1 = Data.get_random_int( Data.images.length - 1, index);
        int wrong_index_2 = Data.get_random_int( Data.images.length - 1, index, wrong_index_1);

        intent.putExtra("wrong_option_1", Data.contents[ wrong_index_1 ]);
        intent.putExtra("wrong_option_2", Data.contents[ wrong_index_2 ]);

        intent.putExtra("score", score);

        return intent;
    }
}
