/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.Utils.getPuppies
import com.example.androiddevchallenge.model.Puppy

@Composable
fun PuppyHome(showPuppyDetails: (Int) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Puppy adoption app") }
            )
        },
        content = {
            val names: List<Puppy> = getPuppies()
            Column(modifier = Modifier.fillMaxHeight()) {
                BuildPuppiesList(names, showPuppyDetails, Modifier.weight(1f))
            }
        }
    )
}

@Composable
fun BuildPuppiesList(
    puppies: List<Puppy>,
    showPuppyDetails: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        this.itemsIndexed(items = puppies) { index, puppy ->
            Card(
                shape = RoundedCornerShape(10.dp),
                elevation = 3.dp,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable(onClick = { showPuppyDetails(index) })
                ) {
                    Image(
                        painter = painterResource(puppy.photo),
                        contentDescription = null,
                        modifier = Modifier
                            .width(120.dp),
                        contentScale = ContentScale.Inside
                    )
                    Spacer(
                        modifier = Modifier
                            .width(15.dp)
                    )
                    Text(
                        text = puppy.breed,
                        style = TextStyle(
                            fontSize = 30.sp,
                            color = Color.DarkGray,
                            fontFamily = FontFamily.Cursive
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
