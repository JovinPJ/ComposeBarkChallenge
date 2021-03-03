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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.Utils.getPuppy
import com.example.androiddevchallenge.model.Puppy

@Composable
fun PuppyDetails(pos: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Puppy adoption app") }
            )
        },
        content = {
            BuildPuppyDetails(getPuppy(pos))
        }
    )
}

@Composable
fun BuildPuppyDetails(puppy: Puppy) {
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(puppy.photo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillWidth
            )
            Spacer(Modifier.height(20.dp))

            Text(
                puppy.breed,
                style = typography.h4
            )
            Spacer(Modifier.height(5.dp))
            Text(
                puppy.description, textAlign = TextAlign.Left,
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.DarkGray,
                    fontFamily = FontFamily.Default,
                    lineHeight = 30.sp
                ),
            )
        }
    }
}
