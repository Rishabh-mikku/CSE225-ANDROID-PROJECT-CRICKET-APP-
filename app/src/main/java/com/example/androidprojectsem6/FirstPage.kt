package com.example.androidprojectsem6

import android.annotation.SuppressLint
import android.content.Intent
import android.media.RouteListingPreference
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class FirstPage : AppCompatActivity(), AdapterView.OnItemClickListener {

    lateinit var toggle : ActionBarDrawerToggle

    private var gridView: GridView?= null
    private var arrayList: ArrayList<TeamItem> ?= null
    private var teamAdapter : TeamAdapter ?= null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)

        val navView : NavigationView = findViewById(R.id.nav_view)



        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId) {

                R.id.nav_venues -> stadiums()
                R.id.nav_captains -> captains()
                R.id.nav_owners -> owners()
                R.id.settings -> Toast.makeText(applicationContext, "Clicked Settings", Toast.LENGTH_SHORT).show()
                R.id.nav_login -> startActivity(Intent(this, LoginForm::class.java))
                R.id.nav_signout -> startActivity(Intent(this, RegisterForm::class.java))
            }
            true
        }

        gridView =  findViewById(R.id.gridView)
        arrayList = ArrayList()
        arrayList = setDataList()
        teamAdapter = TeamAdapter(applicationContext, arrayList!!)
        gridView?.adapter = teamAdapter
        gridView?.onItemClickListener = this
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
       return super.onOptionsItemSelected(item)
    }

    private fun setDataList() : ArrayList<TeamItem> {
        var arrayList: ArrayList<TeamItem> = ArrayList()

        arrayList.add(TeamItem(R.drawable.csk, "CSK"))
        arrayList.add(TeamItem(R.drawable.mi, "MI"))
        arrayList.add(TeamItem(R.drawable.rcb, "RCB"))
        arrayList.add(TeamItem(R.drawable.srh, "SRH"))
        arrayList.add(TeamItem(R.drawable.kkr, "KKR"))
        arrayList.add(TeamItem(R.drawable.rr, "RR"))
        arrayList.add(TeamItem(R.drawable.lsg, "LSG"))
        arrayList.add(TeamItem(R.drawable.gt, "GT"))
        arrayList.add(TeamItem(R.drawable.pk, "PK"))
        arrayList.add(TeamItem(R.drawable.dc, "DC"))

        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        var teamItem : TeamItem = arrayList!!.get(position)
        Toast.makeText(applicationContext, teamItem.team_name, Toast.LENGTH_LONG).show()
    }

    fun stadiums() {
        gotoUrl("https://www.gmrit.org/ipl-schedule/#Venues_for_the_IPL_2024_Matches")
    }

    fun captains() {
        gotoUrl("https://c.ndtvimg.com/2024-03/j0rg071_ipl-2024-x_625x300_21_March_24.jpg?output-quality=80&downsize=639:*")
    }

    fun owners() {
        gotoUrl("https://www.howzat.com/blog/cricket/indian-t20-league-team-owners")
    }

    private fun gotoUrl(s: String) {

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(s))
        startActivity(intent)
    }
}