package com.example.androidprojectsem6

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class TeamAdapter(var context: Context, var arrayList: ArrayList<TeamItem>) : BaseAdapter() {

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = View.inflate(context, R.layout.grid_item, null)

        var team_logos : ImageView = view.findViewById(R.id.grid_image)
        var team_name : TextView = view.findViewById(R.id.item_name)

        var teamItem : TeamItem = arrayList.get(position)

        team_logos.setImageResource(teamItem.team_logos!!)
        team_name.text = teamItem.team_name

        return view
    }
}