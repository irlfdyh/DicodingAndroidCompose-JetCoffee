package com.dicoding.compose.mjc.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicoding.compose.mjc.R
import com.dicoding.compose.mjc.model.Category
import com.dicoding.compose.mjc.ui.theme.MyJetCoffeeTheme

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    category: Category,
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = category.imageCategory),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = category.textCategory),
            fontSize = 10.sp,
            modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 8.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun CategoryItemPreview() {
    MyJetCoffeeTheme {
        CategoryItem(
            modifier = Modifier,
            category = Category(
                R.drawable.icon_category_cappuccino,
                R.string.category_cappuccino
            )
        )
    }
}