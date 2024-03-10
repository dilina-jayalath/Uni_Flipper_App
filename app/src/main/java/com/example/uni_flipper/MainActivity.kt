package com.example.uni_flipper

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.uni_flipper.databinding.FragmentControlerBinding
import com.example.uni_flipper.databinding.UserDashboardBinding
import com.example.uni_flipper.databinding.UserProfileBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: FragmentControlerBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.loading_page)
             naviOnboard01()
            val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
            findViewById<ConstraintLayout>(R.id.onboard_01_1).startAnimation(slideInAnimation)

//        Handler().postDelayed({
//            naviOnboard01()
//            val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
//            findViewById<ConstraintLayout>(R.id.onboard_01_1).startAnimation(slideInAnimation)
//        }, 2000)


        binding = FragmentControlerBinding.inflate(layoutInflater)

        binding.bottomNavigator.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.home -> replaceFragment(Home())
                R.id.setting -> replaceFragment(Setting())
                R.id.message -> replaceFragment(UserProfile())
                R.id.Add -> replaceFragment(Ads())

                R.id.profile -> {
                    replaceFragment(UserDashBoard())
                    val UserDashBoard = UserDashboardBinding.inflate(layoutInflater)

                    val editProBtn: Button = UserDashBoard.editPro

                    editProBtn.setOnClickListener {
                            replaceFragment(UserProfile())
                    }
                }

                else->{

                }
            }
            true

        }
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }






    private fun naviOnboard01(){
        setContentView(R.layout.onboard_01)
        val nextButton: Button = findViewById(R.id.btnNext)

        nextButton.setOnClickListener {
            naviOnboard02()
            val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
            findViewById<ConstraintLayout>(R.id.onboard_02_1).startAnimation(slideInAnimation)
        }

    }

    private fun naviOnboard02(){
        setContentView(R.layout.onboard_02)

        val nextButton: Button = findViewById(R.id.btnNext)
        val backButton: Button = findViewById(R.id.btnBack)

        nextButton.setOnClickListener {
            naviOnboard03()
            val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right)
            findViewById<ConstraintLayout>(R.id.onboard_03_1).startAnimation(slideInAnimation)
        }
        backButton.setOnClickListener {
            naviOnboard01()
            val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
            findViewById<ConstraintLayout>(R.id.onboard_01_1).startAnimation(slideInAnimation)
        }
    }


    private fun naviOnboard03(){
        setContentView(R.layout.onboard_03)
        val nextButton: Button = findViewById(R.id.btnNext)
        val backButton: Button = findViewById(R.id.btnBack)

        nextButton.setOnClickListener {
            getStartPage()

        }
        backButton.setOnClickListener {
            naviOnboard02()
            val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_left)
            findViewById<ConstraintLayout>(R.id.onboard_02_1).startAnimation(slideInAnimation)
        }
    }


    private fun getStartPage(){
        setContentView(R.layout.get_start_page)
        val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_up)
        findViewById<ConstraintLayout>(R.id.getStart).startAnimation(slideInAnimation)
        val getStartBtn: Button = findViewById(R.id.getStartBtn)

        getStartBtn.setOnClickListener{
            logIn()
        }

    }

    private fun logIn(){

        setContentView(R.layout.login_page)
        val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_up)
        findViewById<ConstraintLayout>(R.id.loginInsideCon).startAnimation(slideInAnimation)


        val signinBtn:Button = findViewById(R.id.signin_Btn)
        signinBtn.setOnClickListener {
            setContentView(binding.root)
            replaceFragment(Home())
        }
    }







}