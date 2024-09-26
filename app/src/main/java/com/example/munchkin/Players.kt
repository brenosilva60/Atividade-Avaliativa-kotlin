package com.example.munchkin

data class Players(
    var nome: String,
    var nivel: Int = 0,
    var equipamento: Int = 0,
    var modificadores: Int = 0
) {
}