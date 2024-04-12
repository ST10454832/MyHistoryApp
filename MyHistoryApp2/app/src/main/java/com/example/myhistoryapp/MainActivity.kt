package com.example.myhistoryapp

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Background

        val videoView = findViewById<VideoView>(R.id.videoView)

        val videoPath = "android.resource://" + packageName + "/" + R.raw.gif_history

        videoView.setVideoURI(Uri.parse(videoPath))



// This ensures that the VideoView Runs Continuously

        videoView.setOnPreparedListener { mediaPlayer ->

            true.also { mediaPlayer.isLooping = it }

        }



// Video Time frame.

        videoView.start()



//The world history app begins. (Start)



//declarations

        val deleteButton  = findViewById<ImageButton>(R.id.clearButton)

        val searchButton = findViewById<ImageButton>(R.id.findButton)

        val ageText = findViewById<EditText>(R.id.ageText)

        val matchedTextView = findViewById<TextView>(R.id.imageSearched)

        val resultImageView = findViewById<ImageView>(R.id.resultSearched)

        data class Item(val imageResId: Int, val text: String)



//Array this is where i group both the image as well as the information of the figures.

        val ageItemMap = mapOf(

            25 to Item(

                R.drawable.phillip_hughes,

                "The cricket world received a terrible jolt when Phillip Hughes died at the age of 25 after being struck by a bouncer on the side of his head, below the helmet. Playing a Shield game in Sydney, Hughes was hit when he missed an attempted hook, causing a cerebral haemorrhage. He underwent surgery after being rushed to hospital from the SCG but did not regain consciousness. His funeral was held in his hometown, Macksville, on December 3, and attended by cricketers of every stripe, and dignitaries including the Australian prime minister Tony Abbott."
            ),

            27 to Item(

                R.drawable.amy_winehouse,

                "Who was Amy Winehouse? Amy Winehouse was a British singer-songwriter who skyrocketed to fame as a result of the critically acclaimed multiple Grammy Award-winning album Back to Black, released in 2006. Her tempestuous love life and substance abuse problems stalled her recording career and drew media attention"
            ),

            34 to Item(

                R.drawable.shushant_sing_rajput,

                "For his performance in the latter, he received his first nomination for the Filmfare Award for Best Actor. Rajput died by suicide at his home in Bandra, Mumbai, in June 2020, aged 34"
            ),

            43 to Item(

                R.drawable.chadwick_boseman,

                "He made film history portraying many of America's history makers—from major league baseball great Jackie Robinson to soul singer James Brown. But he found stardom with his role as T'Challa in Marvel's 'Black Panther,' adding important representation to the Marvel Universe and the superhero film genre"
            ),

            50 to Item(

                R.drawable.michael_jackson,

                "Michael Joseph Jackson was an American singer, songwriter, dancer, and one of the most influential and iconic pop music entertainers of all time. He was nicknamed the “King of Pop” by his close and long-time friend Elizabeth Taylor, a title that stuck after striking a chord with fans"
            ),

            53 to Item(

                R.drawable.irrfan_khan,

                "One of the most versatile actors in Indian cinema as well as Hollywood, Irrfan Khan, passed away on April 29, 2020. The actor had been battling cancer for a few years and died due to complications arising from the illness"
            ),

            65 to Item(

                R.drawable.bob_saget,

                "Bob Saget was an American actor, stand-up comedian, and television host from Philadelphia. His best known role was playing pater familias Danny Tanner on the hit sitcom Full House (1987-1995). He played the character again in the sequel series Fuller House(2016-2020)"
            ),

            70 to Item(

                R.drawable.rishi_kapoor,

                "Rishi Raj Kapoor (4 September 1952 – 30 April 2020) was an Indian actor, film director, and producer who worked in Hindi films. He was the recipient of several accolades, including a National Film Award and four Filmfare Awards, in a career that spanned 50 years"
            ),

            95 to Item(

                R.drawable.nelson_mandela,

                "As President of South Africa, Nelson Mandela improved the living standards and facilities of South Africa's black population, who had suffered for decades under apartheid. He also worked hard to make South Africa a country of equality, where people of all race and colour could live together in peace"
            ),

            96 to Item(

                R.drawable.queen_elizabeth,

                "Elizabeth II (born April 21, 1926, London, England—died September 8, 2022, Balmoral Castle, Aberdeenshire, Scotland) was the queen of the United Kingdom of Great Britain and Northern Ireland from February 6, 1952, to September 8, 2022"
            )

        )

//While Loop Begins


        searchButton.setOnClickListener {



            //While statement, while the app is running

            val age = ageText.text.toString().toIntOrNull()

            //if the age of the number is 0

            if (age == null) {

                matchedTextView.text = "Please enter a Valid age "

            } else {

                //if the age is in between

                if (age < 20 || age > 100) {

                    matchedTextView.text = "Enter a age between 20 and 100"

                    ageText.text.clear()

                } else {

                    // Check if the entered age is correct

                    val correctItem = ageItemMap[age]

                    if (correctItem != null) {

                        // Display Text and Image when match has been met

                        resultImageView.setImageResource(correctItem.imageResId)

                        matchedTextView.text = correctItem.text

                    } else {

                        // When a user inputs an age that doesn't match

                        matchedTextView.text = "Seems Like your age is not special,try again next year"



                    }

                    //Reset once the user clicks this button

                    deleteButton.setOnClickListener {

                        // Clear the text of EditText

                        ageText.text.clear()



                        // Clear the text of TextView

                        matchedTextView.text = ""



                        // Reset the image of ImageView

                        resultImageView.setImageResource(android.R.color.transparent)

                    }











                }

            }

        }

    }

}
