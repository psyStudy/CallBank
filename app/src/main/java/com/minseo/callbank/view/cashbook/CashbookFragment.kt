package com.minseo.callbank.view.cashbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Surface
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minseo.callbank.R

class CashbookFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                ViewCreate()
            }
        }
    }

    @Preview
    @Composable
    private fun ViewCreate() {
        val sansFamily = FontFamily(
            Font(R.font.notosanscjkkr_bold, FontWeight.Bold),
            Font(R.font.notosanscjkkr_medium, FontWeight.Medium),
            Font(R.font.notosanscjkkr_regular, FontWeight.Normal)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text="내 가계부",
                fontSize = 28.sp,
                fontFamily = sansFamily, fontWeight = FontWeight.Bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text="달력에서 날짜를 눌러\n통장 내역을 확인하세요",
                fontSize = 20.sp,
                fontFamily = sansFamily, fontWeight = FontWeight.Normal,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}