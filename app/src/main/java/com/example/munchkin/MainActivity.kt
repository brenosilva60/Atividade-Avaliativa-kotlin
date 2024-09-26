package com.example.munchkin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.munchkin.ui.theme.MunchkinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutPlayers()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutPlayers() {

    val jogadores = listOf("JogadorBreno",
        "JogadorPablo",
        "JogadorKaik",
        "JogadorJoao")

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(14.dp)){

        items(jogadores) { nome ->
            Jogador(nome)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Jogador(nome: String)
{

    var nomePlayer by remember {
        mutableStateOf("")
    }

    var nivel by remember {
        mutableStateOf(0)
    }

    var equipamentos by remember {
        mutableStateOf(0)
    }

    var modificador by remember {
        mutableStateOf(0)
    }

    val poder =
            nivel +
            equipamentos +
            modificador

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(value = nomePlayer,
            onValueChange = { nomePlayer = it },
            label = { Text(text = "Nome do Player") })

        Spacer(modifier = Modifier.width(15.dp))
        Spacer(modifier = Modifier.height(10.dp))

        Row(horizontalArrangement =
        Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
                if (nivel > 0)
                    nivel--
            }) {
                Text("-")
            }

            Text(text = "Nível: $nivel")
            Button(onClick = {
                if(nivel < 10)
                    nivel++
            else{

            } }) {
                Text("+")
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
                if (equipamentos > 0)
                    equipamentos--
            }) {
                Text("-")
            }

            Text(text = "Equipamento: $equipamentos")
            Button(onClick = {
                if(equipamentos < 40)
                    equipamentos++
            else{

            }}) {
                Text("+")
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
                if (modificador > -5)
                    modificador--
            }) {
                Text("-")
            }

            Text(text = "Modificador: $modificador")
            Button(onClick = {
                if(modificador < 10)
                    modificador++
            else{

            }}) {
                Text("+")
            }
        }
        Text(text = "Poder Total: $poder")
    }
}

@Preview
@Composable
fun Preview(){
    LayoutPlayers()
}