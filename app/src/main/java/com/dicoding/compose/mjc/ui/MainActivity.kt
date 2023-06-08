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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.compose.mjc.R
import com.dicoding.compose.mjc.model.BottomBarItem
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
    Scaffold(
        bottomBar = { BottomBar() }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Banner()
            HomeSection(
                title = stringResource(R.string.section_category),
                content = { CategoryRow() }
            )
            HomeSection(
                title = stringResource(id = R.string.section_favorite_menu),
                content = { MenuRow(menus = dummyMenu) }
            )
            HomeSection(
                title = stringResource(id = R.string.section_best_seller_menu),
                content = { MenuRow(menus = dummyBestSellerMenu) }
            )
        }
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

@Composable
fun HomeSection(
    modifier: Modifier = Modifier,
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        SectionText(
            title = title,
            modifier = modifier
        )
        content()
    }
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background
    ) {
        val navigationItems = listOf(
            BottomBarItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home
            ),
            BottomBarItem(
                title = stringResource(R.string.menu_favorite),
                icon = Icons.Default.Favorite
            ),
            BottomBarItem(
                title = stringResource(R.string.menu_profile),
                icon = Icons.Default.AccountCircle
            ),
        )
        navigationItems.map {
            NavigationBarItem(
                selected = it.title == navigationItems[0].title,
                onClick = { },
                label = {
                    Text(it.title)
                },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                }
            )
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
