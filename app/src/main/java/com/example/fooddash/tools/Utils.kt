package com.example.fooddash.tools

import com.example.fooddash.db.entity.Product
import com.google.firebase.database.DatabaseReference
import kotlin.random.Random

object Utils {

    const val CATEGORY_DRINKS: Int = 2
    const val CATEGORY_MAIN_DISHES: Int = 1
    const val CATEGORY_SALADS: Int = 3

    const val CATEGORY_TITLE_DRINKS: String = "drinks"
    const val CATEGORY_TITLE_MAIN_DISHES: String = "main_dishes"
    const val CATEGORY_TITLE_SALADS: String = "salads"

    fun setAllProducts(references: DatabaseReference) {
        try {
            val listDrinks = listOf(
                Product(
                    fullName = "Agua de pepino",
                    description = "Es tan refrescante, con 0 calorías y sin azúcar.",
                    price = 30.0,
                    category = CATEGORY_DRINKS,
                    pictureUrl = "picture_cucumber_water.jpg",
                    ranking = Random.nextDouble(30.0, 100.0)
                ),
                Product(
                    fullName = "Té helado",
                    description = "¡El té helado sin endulzar es una deliciosa alternativa saludable a los refrescos!",
                    price = 20.0,
                    category = CATEGORY_DRINKS,
                    pictureUrl = "picture_iced_tea.jpg",
                    ranking = Random.nextDouble(30.0, 100.0)
                ),
                Product(
                    fullName = "Agua de fresa",
                    description = "¡Esta deliciosa agua saborizada tiene el esencia de esa baya roja y es muy refrescante!",
                    price = 25.0,
                    category = CATEGORY_DRINKS,
                    pictureUrl = "picture_strawberry_water.jpg",
                    ranking = Random.nextDouble(30.0, 100.0)
                ),
                Product(
                    fullName = "Té de menta",
                    description = "Este té de menta es restaurador, delicioso y solo tarda 5 minutos en infusionarse en un té herbal con sabor.",
                    price = 30.0,
                    category = CATEGORY_DRINKS,
                    pictureUrl = "picture_mint_tea.jpg",
                    ranking = Random.nextDouble(30.0, 100.0)
                ),
                Product(
                    fullName = "Té de jengibre",
                    description = "Tiene posibles beneficios para la salud, como ayudar en la digestión y reducir la inflamación (consulta la receta para obtener más información).",
                    price = 25.0,
                    category = CATEGORY_DRINKS,
                    pictureUrl = "picture_ginger_tea.jpg",
                    ranking = Random.nextDouble(30.0, 100.0)
                )
            )
            val listMainDishes = listOf(
                Product(
                    fullName = "Jambalaya",
                    description = "Especial para las fiestas",
                    price = 130.0,
                    category = CATEGORY_MAIN_DISHES,
                    pictureUrl = "picture_slow_cooker_jambalaya.png",
                    ranking = Random.nextDouble(40.0, 100.0)
                ),
                Product(
                    fullName = "Gumbo de pollo con salchicha andouille",
                    description = "La salchicha andouille agrega un toque extra de especias a este clásico sureño lleno de muslos de pollo, okra, tocino y una mezcla de especias casera.",
                    price = 120.0,
                    category = CATEGORY_MAIN_DISHES,
                    pictureUrl = "picture_chicken_gumbo_with_andouille_sausage.png",
                    ranking = Random.nextDouble(40.0, 100.0)
                ),
                Product(
                    fullName = "Gumbo de camarones con salchicha andouille",
                    description = "Domina el roux y haz una olla de gumbo inolvidable en estas fiestas.",
                    price = 140.0,
                    category = CATEGORY_MAIN_DISHES,
                    pictureUrl = "picture_shrimp_gumbo_with_andouille_sausage.png",
                    ranking = Random.nextDouble(40.0, 100.0)
                ),
                Product(
                    fullName = "Pollo asado con zanahorias",
                    description = "Un pollo asado simple es perfecto para una reunión más pequeña.",
                    price = 180.0,
                    category = CATEGORY_MAIN_DISHES,
                    pictureUrl = "picture_roast_chicken_carrots_sally.jpg",
                    ranking = Random.nextDouble(40.0, 100.0)
                )
            )
            val listSalads = listOf(
                Product(
                    fullName = "Ensalada verde simple",
                    description = "Las almendras tostadas crujientes y el aguacate cremoso agregan un contraste de textura increíble a esta ensalada simple.",
                    price = 20.0,
                    category = CATEGORY_SALADS,
                    pictureUrl = "picture_green_salad.jpg",
                    ranking = Random.nextDouble(60.0, 100.0)
                ),
                Product(
                    fullName = "Ensalada italiana picada",
                    description = "¡Esta ensalada picada tiene tanto sabor que incluso los escépticos de las ensaladas se servirán segundos! ¿Los ingredientes clave? Un aderezo contundente, pepperoncini y DOS tipos de queso.",
                    price = 30.0,
                    category = CATEGORY_SALADS,
                    pictureUrl = "picture_chopped_salad.jpg",
                    ranking = Random.nextDouble(60.0, 100.0)
                ),
                Product(
                    fullName = "Ensalada de taco saludable",
                    description = "Completa con tiras crujientes de tortilla, carne de taco a base de plantas sabrosa y un aderezo de cilantro y lima con mucho sabor.",
                    price = 25.0,
                    category = CATEGORY_SALADS,
                    pictureUrl = "picture_taco_salad.jpg",
                    ranking = Random.nextDouble(60.0, 100.0)
                )
            )

            references.child(CATEGORY_TITLE_DRINKS).setValue(listDrinks)

            references.child(CATEGORY_TITLE_MAIN_DISHES).setValue(listMainDishes)

            references.child(CATEGORY_TITLE_SALADS).setValue(listSalads)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}