package com.example.lab3_danp_revilla

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab3_danp_revilla.ui.theme.Lab3_danp_revillaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab3_danp_revillaTheme {
                // A surface container using the 'background' color from the theme
                val listaAsistentes = remember { mutableStateListOf<Asistente>() }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(modifier = Modifier.fillMaxSize())
                    pantallaUsuario(listaAsistentes);

                }
            }
        }
    }
}

@Composable
fun pantallaUsuario(listaAsistentes: MutableList<Asistente>){
    var nombre by remember {mutableStateOf("")}
    var fecha by remember {mutableStateOf("")}
    var tipoSangre by remember {mutableStateOf("")}
    var telef by remember {mutableStateOf("")}
    var correo by remember {mutableStateOf("")}
    var monto by remember {mutableStateOf("")}

    var estaEditando by remember {mutableStateOf(false)}
    var txtBtn by remember {mutableStateOf("Agregar Asistente")}

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(12.dp)){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()){
            Formulario(
                nombre = nombre,
                funNombre = {nombre = it},
                fecha = fecha,
                funFecha = {fecha = it},
                tipoSangre = tipoSangre,
                funTipoSangre = {tipoSangre= it},
                telef = telef,
                funTelef = {telef = it},
                correo = correo,
                funCorreo = {correo = it},
                monto = monto,
                funMonto = {monto = it},

                estaEditando = estaEditando,
                funEstaEditando = {estaEditando = false},
                txtBtn = txtBtn,
                funTxtBtn = {txtBtn = it},
                listaAsistentes = listaAsistentes,
                funLimpiarInputs = {
                    nombre=""
                    fecha = ""
                    tipoSangre = ""
                    telef = ""
                    correo = ""
                    monto = ""
                }

            )
            Column(modifier = Modifier.fillMaxWidth()) {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ){
                    items(listaAsistentes){asistente ->
                        CardAsistente(
                            funNombre = {nombre = it},
                            funFecha = {nombre = it},
                            funTipoSangre = {nombre = it},
                            funTelef = {nombre = it},
                            funCorreo = {nombre = it},
                            funMonto = {nombre = it},

                            funTxtBtn = {txtBtn = it},
                            funEstaEditando = {estaEditando= it},
                            funLimpiarInputs= {estaEditando= it},

                        )

                    }
                }

            }
        }


    }

}




