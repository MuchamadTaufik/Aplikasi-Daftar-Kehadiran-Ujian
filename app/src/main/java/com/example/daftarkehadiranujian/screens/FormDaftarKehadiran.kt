package com.example.daftarkehadiranujian.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import com.example.daftarkehadiranujian.model.DaftarKehadiran
import com.example.daftarkehadiranujian.persistences.DaftarKehadiranDao
import com.example.daftarkehadiranujian.ui.theme.Purple900
import com.example.daftarkehadiranujian.ui.theme.Teal400
import kotlinx.coroutines.launch

@Composable
fun FormDaftarKehadiran(DaftarKehadiranDao: DaftarKehadiranDao ) {
    val id = remember { mutableStateOf(TextFieldValue("")) }
    val npm = remember { mutableStateOf(TextFieldValue("")) }
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val kelas = remember { mutableStateOf(TextFieldValue("")) }
    val kodemk = remember { mutableStateOf(TextFieldValue("")) }

    val scope = rememberCoroutineScope()
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {

        OutlinedTextField(
            label = { Text(text = "Id") },
            value = id.value,
            onValueChange = {
                id.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Tidak Perlu di isi") }
        )

        OutlinedTextField(
            label = { Text(text = "npm") },
            value = npm.value,
            onValueChange = {
                npm.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "NPM") }

        )
        OutlinedTextField(
            label = { Text(text = "Nama") },
            value = nama.value,
            onValueChange = {
                nama.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Nama") }
        )
        OutlinedTextField(
            label = { Text(text = "Kelas") },
            value = kelas.value,
            onValueChange = {
                kelas.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "Kelas") }
        )
        OutlinedTextField(
            label = { Text(text = "Kode Matakuliah") },
            value = kodemk.value,
            onValueChange = {
                kodemk.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "Kode Matakuliah") }
        )
        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple900,
            contentColor = Teal400
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal400,
            contentColor = Purple900
        )
        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()
                val item = DaftarKehadiran(id, npm.value.text,
                    nama.value.text, kelas.value.text, kodemk.value.text)
                scope.launch {
                    DaftarKehadiranDao.insertAll(item)
                }
                npm.value = TextFieldValue("")
                nama.value = TextFieldValue("")
                kelas.value = TextFieldValue("")
                kodemk.value = TextFieldValue("")

            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                npm.value = TextFieldValue("")
                nama.value = TextFieldValue("")
                kelas.value = TextFieldValue("")
                kodemk.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}