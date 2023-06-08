package com.dicoding.compose.mjc.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.compose.mjc.R
import com.dicoding.compose.mjc.model.Menu
import com.dicoding.compose.mjc.model.dummyBestSellerMenu
import com.dicoding.compose.mjc.model.dummyCategory
import com.dicoding.compose.mjc.model.dummyMenu
import com.dicoding.compose.mjc.ui.components.CategoryItem
import com.dicoding.compose.mjc.ui.components.MenuItem
import com.dicoding.compose.mjc.ui.components.Search
import com.dicoding.compose.mjc.ui.components.SectionText
import com.dicoding.compose.mjc.ui.theme.MyJetCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetCoffeeTheme {
                JetCoffeeApp()
            }
        }
    }
}

@Composable
fun JetCoffeeApp() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Banner()
        SectionText(title = stringResource(R.string.section_category))
        CategoryRow()
        SectionText(title = stringResource(id = R.string.section_favorite_menu))
        MenuRow(menus = dummyMenu)
        SectionText(title = stringResource(id = R.string.section_best_seller_menu))
        MenuRow(menus = dummyBestSellerMenu)
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        Search()
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(category = category)
        }
    }
}

@Composable
fun MenuRow(
    modifier: Modifier = Modifier,
    menus: List<Menu>
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(menus, key = { it.title }) { menu ->
            MenuItem(menu = menu)
        }
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun JetCoffeeAppPreview() {
    MyJetCoffeeTheme {
        JetCoffeeApp()
    }
}

@Composable
@Preview(showBackground = true)
private fun CategoryRowPreview() {
    MyJetCoffeeTheme {
        CategoryRow()
    }
}
