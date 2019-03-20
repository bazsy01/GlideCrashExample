package hu.bazsy.glidecrashexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.postDelayed
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_image.*

class ImageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_image, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // load placeholder with Glide to ensure same transformation (circle crop)
        Glide.with(this)
            .load(R.drawable.ic_launcher_background)
            .circleCrop()
            .into(image_view)

        image_view.postDelayed(500) {
            // load actual content using a placeholder drawable to avoid "flashing" (showing an empty view for a moment)
            image_view?.let {
                Glide.with(this)
                    .load("https://github.com/bumptech/glide/raw/master/static/glide_logo.png")
                    .circleCrop()
                    .placeholder(it.drawable)
                    .into(it)
            }
        }
    }
}