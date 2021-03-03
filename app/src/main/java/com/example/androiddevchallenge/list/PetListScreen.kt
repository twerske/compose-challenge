package com.example.androiddevchallenge.list

import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.Screen
import com.example.androiddevchallenge.ui.theme.outlineColor
import kotlinx.coroutines.CoroutineStart

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PetListScreen(navController: NavController, viewModel: PetListViewModel) {
    val pets = viewModel.petsData.observeAsState(emptyMap())

    Surface(color = MaterialTheme.colors.background) {
        Column {
            Surface(color = MaterialTheme.colors.primaryVariant,
                border = BorderStroke(4.dp, MaterialTheme.colors.primary),
                modifier = Modifier.fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = CornerSize(0.dp),
                            topEnd = CornerSize(0.dp),
                            bottomEnd = CornerSize(16.dp),
                            bottomStart = CornerSize(16.dp)
                        )
                    )
            ) {
                Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                    drawGradientText(
                        text = stringResource(id = R.string.adoption_title),
//                        style = MaterialTheme.typography.h2,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 32.dp
                        )
                    )

                    // TODO: totally non functional button
//                    Icon(
//                        Icons.Filled.MoreVert, "toggle theme",
//                        tint = MaterialTheme.colors.onSurface,
//                        modifier = Modifier
//                            .size(50.dp)
//                            .padding(start = 8.dp, end = 8.dp, top = 0.dp, bottom = 0.dp)
//                    )
                }
            }

            PetGrid(
                modifier = Modifier.padding(
                    start = 8.dp,
                    end = 8.dp
                ),
                pets.value
            ) {
                pet -> navController.navigate(Screen.PetDetailsScreen(pet.id).getCalculatedRoute())
            }
        }
    }
}

@Composable
fun drawGradientText(text: String, modifier: Modifier = Modifier) {

    val paint = Paint().asFrameworkPaint()
//    val font = Typeface(fontFamily = MaterialTheme.typography.h3)

    val gradientShader: Shader = LinearGradientShader(
        from = Offset(0f, 0f),
        to = Offset(0f, 250f),
        listOf(
//            MaterialTheme.colors.primaryVariant,
//            MaterialTheme.colors.primary,
            MaterialTheme.colors.secondary,
            MaterialTheme.colors.onSecondary,
            MaterialTheme.colors.onPrimary
        )
    )

    Canvas(modifier.height(50.dp)) {
        paint.apply {
            isAntiAlias = true
            textSize = 130f
            typeface = android.graphics.Typeface.DEFAULT_BOLD
            style = android.graphics.Paint.Style.FILL
            color = android.graphics.Color.parseColor("#cdcdcd")
            xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)
            maskFilter = BlurMaskFilter(30f, BlurMaskFilter.Blur.NORMAL)
        }
        drawIntoCanvas { canvas ->
            canvas.save()
            canvas.nativeCanvas.translate(2f, 5f)
            canvas.nativeCanvas.drawText(text, 0f, 100f, paint)
            canvas.restore()
            paint.shader = gradientShader
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
            paint.maskFilter = null
            canvas.nativeCanvas.drawText(text, 0f, 100f, paint)
            canvas.nativeCanvas.translate(2f, 5f)
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)
            paint.maskFilter = BlurMaskFilter(30f, BlurMaskFilter.Blur.NORMAL)
            canvas.nativeCanvas.drawText(text, 0f, 100f, paint)
        }
        paint.reset()
    }
}