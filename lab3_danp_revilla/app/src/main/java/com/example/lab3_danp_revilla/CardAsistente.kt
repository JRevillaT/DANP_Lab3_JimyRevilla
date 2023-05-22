package com.example.lab3_danp_revilla

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardAsistente(
    funNombre : (String) -> Unit,
    funFecha : (String) -> Unit,
    funTipoSangre : (String) -> Unit,
    funTelef : (String) -> Unit,
    funCorreo : (String) -> Unit,
    funMonto : (String) -> Unit,

    funTxtBtn : (String) -> Unit,
    funEstaEditando : (Boolean) -> Unit,
    //funLimpiarInputs= (String) -> Unit,
    funBorrarAsistente : (String) -> Unit,
    asistente: Asistente
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 8.dp
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp), Arrangement.Center) {
            Text(text = asistente.nomCom, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.fecha, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.tipoSangre, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.telef, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.correo, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = asistente.monto, modifier = Modifier.align(Alignment.CenterHorizontally))

            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    onClick = {
                        funNombre(asistente.nomCom)
                        funFecha(asistente.fecha)
                        funTipoSangre(asistente.tipoSangre)
                        funTelef(asistente.telef)
                        funCorreo(asistente.correo)
                        funMonto(asistente.monto)

                        funTxtBtn("Editar Asistente")
                        funEstaEditando(true)
                    }) {
                    Text(text = "Editar", color = Color.White)
                }

                Button(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    onClick = {
                        funBorrarAsistente(asistente.nomCom)
                    }) {
                    Text(text = "Borrar", color = Color.White)
                }

            }
        }
    }
}