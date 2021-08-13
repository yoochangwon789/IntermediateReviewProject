package com.yoochangwonspro.intermediatereviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.messaging.FirebaseMessaging

class PushAlarmReviewActivity : AppCompatActivity() {

    private val resultTextView: TextView by lazy {
        findViewById(R.id.push_alarm_result_text_view)
    }

    private val tokenTextView: TextView by lazy {
        findViewById(R.id.push_alarm_result_token_text_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_push_alarm_review)

        createFirebaseToken()
    }

    private fun createFirebaseToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if (!it.isSuccessful) {
                return@addOnCompleteListener
            }

            tokenTextView.text = it.result
        }
    }
}