package com.example.walletcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import com.example.walletcompose.components.ReleaseItem
import com.example.walletcompose.model.Release
import com.example.walletcompose.model.enums.ReleaseType
import com.example.walletcompose.ui.theme.WalletComposeTheme
import com.example.walletcompose.viewModel.ReleaseListViewModel
import com.example.walletcompose.viewModel.ReleaseListViewModelFactory
import kotlinx.coroutines.Dispatchers
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    private val releaseViewModel: ReleaseListViewModel by viewModels {
        ReleaseListViewModelFactory((application as WalletApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(releaseViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(viewMode: ReleaseListViewModel) {
    val releaseList: List<Release> by  viewMode.allReleases.observeAsState(initial = listOf())
    LazyColumn(){
        items(releaseList) { r ->
            ReleaseItem(release = r)
        }
    }


//    Column(modifier = Modifier.fillMaxHeight(2f))
//    {
//
//        Row(modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp)) {
//            Text(text = "Balance", fontSize = 24.sp)
//        }
//
//        Row(modifier = Modifier.fillMaxWidth()) {
//            Text(modifier = Modifier.fillMaxWidth(),
//                text = "R$ 0,00",
//                fontSize = 24.sp,
//                textAlign = TextAlign.Center)
//        }
//
//        Row(modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp)) {
//
//            Column(modifier = Modifier
//                .weight(1f)) {
//                Row(modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp, 0.dp),
//                    horizontalArrangement = Arrangement.Center) {
//                    Text(text = "Revenues")
//                }
//                Row(modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp, 0.dp),
//                    horizontalArrangement = Arrangement.Center) {
//                    Text(text = "R$ 0,00")
//                }
//            }
//            Column(modifier = Modifier
//                .weight(1f)) {
//                Row(modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp, 0.dp),
//                    horizontalArrangement = Arrangement.Center) {
//                    Text(text = "Expenses")
//                }
//                Row(modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp, 0.dp),
//                    horizontalArrangement = Arrangement.Center) {
//                    Text(text = "R$ 0,00")
//                }
//            }
//        }
//
//        Row(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
//
//        }
//    }
//    Column(modifier = Modifier.wrapContentSize())
//    {
//        Button(onClick = {
//            list.add(Release(4, "Zub", ReleaseType.EXPENSE, BigDecimal(150), false));
//        }) {
//            Text("Add")
//    } }
}


@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun DefaultPreview() {
    WalletComposeTheme {
        //Greeting()
    }
}