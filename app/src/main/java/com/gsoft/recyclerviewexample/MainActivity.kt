package com.gsoft.recyclerviewexample

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.gsoft.recyclerviewexample.ui.RecyclerViewExampleTheme
import com.gsoft.recyclerviewexample.ui.typography

data class Recipe(
        @DrawableRes val imageResource: Int,
        val title: String,
        val ingredients: List<String>
)

val recipeList = listOf(
                Recipe(R.drawable._07763607_10221777279598067_4853087874651143194_n, "Receta 1", listOf("Leche", "Azucar", "Cafe")),
                Recipe(R.drawable._07763607_10221777279598067_4853087874651143194_n, "Receta 2", listOf("Te", "Limon")),
                Recipe(R.drawable._07763607_10221777279598067_4853087874651143194_n, "Receta 3", listOf("Fetnet", "CocaCola")),
                Recipe(R.drawable._07763607_10221777279598067_4853087874651143194_n, "Receta 4", listOf("Vodka", "Naranja")),
                 Recipe(R.drawable._07763607_10221777279598067_4853087874651143194_n, "Receta 5", listOf("Chocotorta", "Cafe")),
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
               RecipeList(recipeList = recipeList)
        }
    }
}


@Composable
fun RecipeCard(recipe: Recipe){
    val image = imageResource(R.drawable._07763607_10221777279598067_4853087874651143194_n)
    Surface(shape = RoundedCornerShape(8.dp),elevation = 8.dp,modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            val imageModifier = Modifier.preferredHeight(150.dp).fillMaxWidth().clip(shape = RoundedCornerShape(8.dp))
            Image(asset = image,modifier = imageModifier,contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            Text(text = recipe.title,style = typography.h6)
            for(ingredient in recipe.ingredients){
                Text(text = "* $ingredient",style = typography.body2)
            }
        }
    }
}

@Composable
fun RecipeList(recipeList:List<Recipe>){
    LazyColumnFor(items = recipeList) { item ->
        RecipeCard(recipe = item)
    }
}

