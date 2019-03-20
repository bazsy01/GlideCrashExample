package hu.bazsy.glidecrashexample

import android.os.Bundle
import android.transition.AutoTransition
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.transaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.transaction {
            val fragment = ImageFragment()
            fragment.enterTransition = AutoTransition()
            fragment.exitTransition = AutoTransition()
            addToBackStack(null)
            replace(R.id.main_container, fragment)
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
            return
        }
        super.onBackPressed()
    }
}
