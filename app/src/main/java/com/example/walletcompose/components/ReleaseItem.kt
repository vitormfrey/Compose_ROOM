package com.example.walletcompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.walletcompose.model.Release
import com.example.walletcompose.model.enums.ReleaseType
import com.example.walletcompose.ui.theme.WalletComposeTheme
import java.math.BigDecimal

/**
 * @Author:  Vitor Rey
 * @Date: 29,maio,2023
 * @Email: vitorrey.dev@gmail.com
 **/

@Composable
fun ReleaseItem(release: Release) {
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column() {
            Text(text = release.description)
        }
        Column() {
            //Text(text = release.amount.toString())
        }
        Column() {
            Text(text = release.type.toString())
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListPreview() {
    val list: MutableList<Release> = mutableListOf();

//    list.add(Release(1, "Luz", ReleaseType.EXPENSE, BigDecimal(199)));
//    list.add(Release(2, "Luz", ReleaseType.EXPENSE, BigDecimal(199)));
//    list.add(Release(3, "Luz", ReleaseType.EXPENSE, BigDecimal(199)));

    WalletComposeTheme {

    }
}