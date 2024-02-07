package com.example.quizsandbox2
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizsandbox2.ui.theme.Quizsandbox2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Quizsandbox2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Dasbor()
                }
            }
        }
    }
}

@Composable
fun Dasbor() {
    val hsisakinah = painterResource(R.drawable.hsisakinah)
    val skrol = rememberScrollState()
    val context = LocalContext.current
    var nip by remember {mutableStateOf("")}
    var password by remember {mutableStateOf("")}
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(state = skrol)
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = hsisakinah,
            contentDescription = null,
            modifier = Modifier
                .width(300.dp)
                .height(50.dp)
        )
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            Text(
                text = stringResource(R.string.nip),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.Start)
            )
            TextField(
                value = nip,
                onValueChange = {nip = it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = stringResource(R.string.isinip),color = colorResource(R.color.abu)) },
                )
            Text(
                text = stringResource(R.string.sandi),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.Start)
            )
            TextField(
                value = password,
                onValueChange = {password = it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = stringResource(R.string.isipas),color = colorResource(R.color.abu)) },
                visualTransformation = PasswordVisualTransformation()
                )
        }
        Column (horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = {
                    when {
                        nip.isBlank() && password.isBlank() -> {
                            Toast.makeText(context, context.getString(R.string.kosong2), Toast.LENGTH_SHORT).show()
                        }
                        nip.isBlank() -> {
                            Toast.makeText(context, context.getString(R.string.nipkosong), Toast.LENGTH_SHORT).show()
                        }
                        password.isBlank() -> {
                            Toast.makeText(context, context.getString(R.string.passkosong), Toast.LENGTH_SHORT).show()
                        }
                        else -> {
                            Toast.makeText(context, context.getString(R.string.isi2), Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.biru)),
                modifier = Modifier
                    .padding(end = 5.dp, top = 5.dp)
                    .width(300.dp)
                    .background(
                        color = colorResource(R.color.biru),
                        shape = RoundedCornerShape(20)
                    )
            ) {
                Text(
                    text = stringResource(R.string.login),
                    color = colorResource(R.color.white),
                    fontSize= 21.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
            }
            Text(
                text = stringResource(R.string.noakses),
                color = colorResource(R.color.black),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                )
            TextButton(
                onClick = {Toast.makeText(context, context.getString(R.string.hubcs1), Toast.LENGTH_SHORT).show()}
            ) {
                Text(
                    text = stringResource(R.string.csikhwan),
                    color = colorResource(R.color.biru),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

            TextButton(onClick = { Toast.makeText(context, context.getString(R.string.hubcs2), Toast.LENGTH_SHORT).show()})
            {
                Text(
                text = stringResource(R.string.csakhwat),
                color = colorResource(R.color.biru),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                )
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 35.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {Toast.makeText(context, context.getString(R.string.gofaq), Toast.LENGTH_SHORT).show()},
                    colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
                    modifier = Modifier
                        .padding(end = 5.dp, top = 5.dp)
                        .width(300.dp)
                        .background(
                            color = colorResource(R.color.white),
                            shape = RoundedCornerShape(20)
                        )
                        .border(
                            width = 1.4.dp,
                            color = colorResource(R.color.biru),
                            shape = RoundedCornerShape(30)
                        )
                ) {
                    Text(
                        text = stringResource(R.string.faq),
                        fontWeight = FontWeight.SemiBold,
                        fontSize= 24.sp,
                        textAlign = TextAlign.Center,
                        color = colorResource(R.color.biru),
                        modifier = Modifier
                            .width(200.dp)
                            .padding(10.dp)
                    )
                    Icon(
                        Icons.Filled.ExitToApp,
                        contentDescription = "ExitToApp",
                        modifier = Modifier.size(24.dp),
                        tint = colorResource(R.color.biru)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Tampilan() {
    Quizsandbox2Theme {
        Dasbor()
        }
    }