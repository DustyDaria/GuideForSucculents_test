package com.example.guideforsucculents_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class textContentActivity extends AppCompatActivity {

    private TextView text_content;
    private Typeface face1;
    private Toolbar toolbar;
    private ImageView iContent;
    private int category = 0;
    private int position = 0;

    private int [] array_name_cactus = {R.string.cactus_name_1, R.string.cactus_name_2,
            R.string.cactus_name_3, R.string.cactus_name_4, R.string.cactus_name_5,
            R.string.cactus_name_6, R.string.cactus_name_7, R.string.cactus_name_8,
            R.string.cactus_name_9, R.string.cactus_name_10};

    private int [] array_text_cactus = {R.string.cactus_1, R.string.cactus_2, R.string.cactus_3,
            R.string.cactus_4, R.string.cactus_5, R.string.cactus_6, R.string.cactus_7,
            R.string.cactus_8, R.string.cactus_9, R.string.cactus_10};

    private int [] array_image_cactus = {R.drawable.img_cactus_1, R.drawable.img_cactus_2,
            R.drawable.img_cactus_3, R.drawable.img_cactus_4, R.drawable.img_cactus_5,
            R.drawable.img_cactus_6, R.drawable.img_cactus_7, R.drawable.img_cactus_8,
            R.drawable.img_cactus_9, R.drawable.img_cactus_10};

    private int [] array_name_haworthia = {R.string.haworthia_name_1, R.string.haworthia_name_2,
            R.string.haworthia_name_3, R.string.haworthia_name_4, R.string.haworthia_name_5,
            R.string.haworthia_name_6, R.string.haworthia_name_7, R.string.haworthia_name_8,
            R.string.haworthia_name_9, R.string.haworthia_name_10};

    private int [] array_text_haworthia = {R.string.haworthia_1, R.string.haworthia_2,
            R.string.haworthia_3, R.string.haworthia_4, R.string.haworthia_5, R.string.haworthia_6,
            R.string.haworthia_7, R.string.haworthia_8, R.string.haworthia_9,
            R.string.haworthia_10};

    private int [] array_image_haworthia = {R.drawable.img_haworthia_1, R.drawable.img_haworthia_2,
            R.drawable.img_haworthia_3, R.drawable.img_haworthia_4, R.drawable.img_haworthia_5,
            R.drawable.img_haworthia_6, R.drawable.img_haworthia_7, R.drawable.img_haworthia_8,
            R.drawable.img_haworthia_9, R.drawable.img_haworthia_10};

    private int [] array_name_echeveria = {R.string.echeveria_name_1, R.string.echeveria_name_2,
            R.string.echeveria_name_3, R.string.echeveria_name_4, R.string.echeveria_name_5,
            R.string.echeveria_name_6, R.string.echeveria_name_7, R.string.echeveria_name_8,
            R.string.echeveria_name_9, R.string.echeveria_name_10};

    private int [] array_text_echeveria = {R.string.echeveria_1, R.string.echeveria_2,
            R.string.echeveria_3, R.string.echeveria_4, R.string.echeveria_5,
            R.string.echeveria_6, R.string.echeveria_7, R.string.echeveria_8, R.string.echeveria_9,
            R.string.echeveria_10};

    private int [] array_image_echeveria = {R.drawable.img_echeveria_1, R.drawable.img_echeveria_2,
            R.drawable.img_echeveria_3, R.drawable.img_echeveria_4, R.drawable.img_echeveria_5,
            R.drawable.img_echeveria_6, R.drawable.img_echeveria_7, R.drawable.img_echeveria_8,
            R.drawable.img_echeveria_9, R.drawable.img_echeveria_10};

    private int [] array_name_aloe = {R.string.aloe_name_1, R.string.aloe_name_2,
            R.string.aloe_name_3, R.string.aloe_name_4, R.string.aloe_name_5, R.string.aloe_name_6,
            R.string.aloe_name_7, R.string.aloe_name_8, R.string.aloe_name_9, R.string.aloe_name_10};

    private int [] array_text_aloe = {R.string.aloe_1, R.string.aloe_2, R.string.aloe_3,
            R.string.aloe_4, R.string.aloe_5, R.string.aloe_6, R.string.aloe_7, R.string.aloe_8,
            R.string.aloe_9, R.string.aloe_10};

    private int [] array_image_aloe = {R.drawable.img_aloe_1, R.drawable.img_aloe_2,
            R.drawable.img_aloe_3, R.drawable.img_aloe_4, R.drawable.img_aloe_5,
            R.drawable.img_aloe_6, R.drawable.img_aloe_7, R.drawable.img_aloe_8,
            R.drawable.img_aloe_9, R.drawable.img_aloe_10};

    private int [] array_recommendation = {R.string.recommendation_1, R.string.recommendation_2,
            R.string.recommendation_3, R.string.recommendation_4, R.string.recommendation_5,
            R.string.recommendation_6, R.string.recommendation_7, R.string.recommendation_8,
            R.string.recommendation_9, R.string.recommendation_10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);

        text_content = findViewById(R.id.text_main_content);
        iContent = findViewById(R.id.imageContent);
        toolbar = findViewById(R.id.toolbar);
        //face1 = Typeface.createFromAsset(this.getAssets(), "fonts/Lobster-Regular.ttf");
        //text_content.setTypeface(face1);

        receiveIntent();
    }

    private void receiveIntent(){ // Получаем данные, переданные из предыдущей активности
        Intent i = getIntent();
        if (i != null){
            category = i.getIntExtra("category", 0);
            position = i.getIntExtra("position", 0);
        }
        // Набор контента для активности определяется через выбранную категорию в меню
        // + позицией выбранного элемента в данной категории
        switch (category){
            case 0:
                setTitle(R.string.menu_cactus);
                toolbar.setTitle(array_name_cactus[position]);
                iContent.setImageResource(array_image_cactus[position]);
                text_content.setText(array_text_cactus[position]);
                // По категории определяем массив, и с помощью выбранной пользователем позиции,
                // достаем необходимые медиа для шаблона
                break;
            case 1:
                setTitle(R.string.menu_haworthia);
                toolbar.setTitle(array_name_haworthia[position]);
                iContent.setImageResource(array_image_haworthia[position]);
                text_content.setText(array_text_haworthia[position]);
                break;
            case 2:
                setTitle(R.string.menu_echeveria);
                toolbar.setTitle(array_name_echeveria[position]);
                iContent.setImageResource(array_image_echeveria[position]);
                text_content.setText(array_text_echeveria[position]);
                break;
            case 3:
                setTitle(R.string.menu_aloe);
                toolbar.setTitle(array_name_aloe[position]);
                iContent.setImageResource(array_image_aloe[position]);
                text_content.setText(array_text_aloe[position]);
                break;
            case 4:
                setTitle(R.string.menu_recommendation);
                text_content.setText(array_recommendation[position]);
                break;
        }
    }
}