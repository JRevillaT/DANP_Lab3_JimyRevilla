package com.example.lab3_danp_revilla

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Formulario(
    nombre : String,
    funNombre: (String) -> Unit,
    fecha : String,
    funFecha: (String) -> Unit,
    tipoSangre : String,
    funTipoSangre: (String) -> Unit,
    telef : String,
    funTelef: (String) -> Unit,
    correo : String,
    funCorreo: (String) -> Unit,
    monto : String,
    funMonto: (String) -> Unit,

    estaEditando : Boolean,
    funEstaEditando: () -> Unit,
    txtBtn : String,
    funTxtBtn: (String) -> Unit,
    listaAsistentes : MutableList<Asistente>,
    funLimpiarInputs: () -> Unit
){
    //Nombres
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = nombre,
        onValueChange = {funNombre(it)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        label = {Text(text = "Nombre")},
        enabled = !estaEditando
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    //Fecha
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = fecha,
        onValueChange = {funFecha(it)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        label = {Text(text = "Fecha")},
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    //Tipo de Sangre
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = tipoSangre,
        onValueChange = {funTipoSangre(it)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        label = {Text(text = "Tipo de Sangre")},
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    //Telefono
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = telef,
        onValueChange = {funTelef(it)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        singleLine = true,
        maxLines = 1,
        label = {Text(text = "Numero de Telefono")},
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    //Correo
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = correo,
        onValueChange = {funCorreo(it)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        label = {Text(text = "Correo electronico")},
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))

    //Monto Abonado
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = monto,
        onValueChange = {funMonto(it)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        maxLines = 1,
        label = {Text(text = "Monto Abonado")},
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    
    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
        onClick = {
            if(estaEditando){
                editarAsistente(nombre, fecha, tipoSangre, telef, correo, monto, listaAsistentes)
                funTxtBtn("Agregar Asistente")
                funEstaEditando()

            }else{
                agregarAsistente(nombre, fecha, tipoSangre, telef, correo, monto, listaAsistentes)
            }
            funLimpiarInputs()
        }) {

        Text(
            color = Color.White,
            text = txtBtn
        )
    }
}