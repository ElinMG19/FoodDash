package com.example.fooddash.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddash.R
import com.example.fooddash.db.entity.Product
import com.example.fooddash.tools.Utils.CATEGORY_DRINKS
import com.example.fooddash.tools.Utils.CATEGORY_SALADS
import com.example.fooddash.tools.Utils.CATEGORY_TITLE_DRINKS
import com.example.fooddash.tools.Utils.CATEGORY_TITLE_MAIN_DISHES
import com.example.fooddash.tools.Utils.CATEGORY_TITLE_SALADS
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.willy.ratingbar.ScaleRatingBar

class CustomAdapterProducts(private val context: Context, private val dataSet: List<Product>): RecyclerView.Adapter<CustomAdapterProducts.ViewHolder>() {

    private val storageRef = Firebase.storage.reference

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        val path: String = when (item.category) {
            CATEGORY_DRINKS -> "${CATEGORY_TITLE_DRINKS}/${item.pictureUrl}"
            CATEGORY_SALADS -> "${CATEGORY_TITLE_SALADS}/${item.pictureUrl}"
            else -> "${CATEGORY_TITLE_MAIN_DISHES}/${item.pictureUrl}"
        }
        storageRef.child(path).downloadUrl.addOnSuccessListener {
            Glide.with(context)
                .load(it?.toString())
                .centerCrop()
                .placeholder(R.drawable.ic_bitmap_no_image_available)
                .into(holder.imageViewPicture)
        }
        holder.textViewFullName.text = item.fullName
        holder.textViewDescription.text = item.description
        holder.textViewPrice.text = "C$ " + item.price
        holder.ratingBar.rating = (5 * (item.ranking / 100)).toFloat()
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Ha selecionado " + item.fullName, Toast.LENGTH_LONG).show()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewPicture: ImageView
        val textViewFullName: TextView
        val textViewDescription: TextView
        val textViewPrice: TextView
        val ratingBar: ScaleRatingBar

        init {
            imageViewPicture = view.findViewById(R.id.pictureIcon)
            textViewFullName = view.findViewById(R.id.textViewFullNameItem)
            textViewDescription = view.findViewById(R.id.textViewDescriptionItem)
            textViewPrice = view.findViewById(R.id.textViewPriceItem)
            ratingBar = view.findViewById(R.id.ratingBarItem)
        }
    }

}