package com.olivierloukombo.android_app_fake_api

import android.annotation.SuppressLint
import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.olivierloukombo.android_app_fake_api.model.Comment
import com.olivierloukombo.android_app_fake_api.ui.theme.AndroidappfakeapiTheme
import com.olivierloukombo.android_app_fake_api.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel  by viewModels<MainViewModel>()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidappfakeapiTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Toolbar()
                    }
                ) {
                    val invokedComments = viewModel.getComments()
                    CommentList(invokedComments)
                }
            }
        }
    }
}

@Composable
fun Toolbar(){
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 0.dp,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                color = Color.White
            )
        }
    )
}

@Composable
fun CommentList(comments: List<Comment>) {
    LazyColumn {
//        itemsIndexed(comments) {  _, item ->
//            CommentItem(commentMe = item)
//        }

        items(
            items = comments,
            key = { comment ->
                comment.id
            }
        ) { comment ->
            val item = comment
            if (item == null) {
                CircularProgressIndicator()
            } else {
                CommentItem(item)
            }

        }

    }
}

@Composable
fun CommentItem(commentMe: Comment) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(0.dp), elevation = 4.dp
    ) {
        Surface() {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()

            ) {
                
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = commentMe.name,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = commentMe.email,
                        style = MaterialTheme.typography.caption,
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .padding(4.dp)

                    )

                    Text(
                        text = commentMe.body,
                        style = MaterialTheme.typography.body1,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
        }
    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Toolbar()
    AndroidappfakeapiTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                Toolbar()
            }
        ) {

            Comment(
                1,
                "id labore ex et quam laborum",
                "example@example.com",
                "laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium"
            ).let {
                CommentItem(it)
            }
        }



    }
}