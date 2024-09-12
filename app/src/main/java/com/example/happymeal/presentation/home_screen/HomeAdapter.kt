package com.example.happymeal.presentation.home_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.happymeal.R
import com.example.happymeal.data.local.MealsData

class HomeAdapter (private var categories: List<MealsData>,
                   private val onFavoriteClick: (MealsData) -> Unit)
//    : RecyclerView.Adapter<HomeAdapter.CategoryViewHolder>(){
//
//    // ViewHolder class with View Binding
//    inner class CategoryViewHolder() : RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
//        // Inflate the layout using View Binding
//        val binding = ItemMealCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return CategoryViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
//        val category = categories[position]
//        // Set the category name using View Binding
//        holder.binding.categoryName.text = category.strCategory
//        // Load the category image using Glide and View Binding
//        Glide.with(holder.itemView.context)
//            .load(category.strCategoryThumb)
//            .into(holder.binding.categoryImage)
//    }
//
//    override fun getItemCount(): Int {
//        return categories.size
//    }
    :RecyclerView.Adapter<HomeAdapter.MyMealViewHolder>() {


    fun updateCategories(categoriesList: List<MealsData>) {
        categories = categoriesList
        notifyDataSetChanged() // Notify adapter of data changes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMealViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories, parent, false)
        return MyMealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyMealViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryName.text = category.strCategory
        // Load the product image using Glide or any image loading library
        Glide.with(holder.itemView.context)
            .load(category.strCategoryThumb)
            .into(holder.imgCategoryItem)



//        // Update the heart icon based on the isFavorite status
//        holder.favoriteButton.setImageResource(
//            if (category.isFavorite) R.drawable.ic_heart_filled else R.drawable.ic_heart_outline
//        )
//
//        // Handle favorite button click
//        holder.favoriteButton.setOnClickListener {
//            onFavoriteClick(category)
//            // Update the heart icon immediately after the click
//            notifyItemChanged(position)
//        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

   inner class MyMealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCategoryItem: ImageView = itemView.findViewById(R.id.categoryImage)
        val categoryName: TextView = itemView.findViewById(R.id.categoryName)
   // Initialize other views if needed
    }

//    inner class MyMealViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
//        val  mealImage: ImageView =itemView.findViewById(R.id.categoryImage)
//        val mealIName: TextView =itemView.findViewById(R.id.categoryName)
//        //val mealCategory: TextView=itemView.findViewById(R.id.articleCategory)
//        //val mealDescription:TextView=itemView.findViewById((R.id.articleDescription))
//
//    }
//    fun updateCategories(newCategories: List<MealsData>) {
//        categories = newCategories
//        notifyDataSetChanged()
//    }
//
//
//    private val differCallBack = object : DiffUtil.ItemCallback<Meals>() {
//
//        override fun areItemsTheSame(oldItem: Meals, newItem: Meals): Boolean {
//
//            return oldItem.idMeal == newItem.idMeal
//        }
//
//        override fun areContentsTheSame(oldItem: Meals, newItem: Meals): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    val differ = AsyncListDiffer(this, differCallBack)
//
//    override fun getItemCount(): Int {
//        return differ.currentList.size
//    }
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMealViewHolder {
//
//        return MyMealViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.categories, parent, false)
//
//        )
//    }
//
//
//    private var onItemClickListeer:((Meals)->Unit)?= null
//
//    override fun onBindViewHolder(holder: MyMealViewHolder, position: Int) {
//
//        val  meals=differ.currentList[position]
//
//        holder.itemView.apply {
//            Glide.with(this).load(meals.strMealThumb).into(holder.mealImage)
//
//
//            holder.mealIName.text=meals.strMeal
//         //   holder.mealCategory.text=meals.strInstructions
//
//
//            setOnClickListener {
//                onItemClickListeer?.let {
//                    it(meals)
//                }
//            }
//        }
//    }
//    fun setOnItemClickListener(listener:(Meals)->Unit){
//        onItemClickListeer=listener
//    }

}