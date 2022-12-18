package com.olivierloukombo.android_app_fake_api.views

import android.annotation.SuppressLint
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*

import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.olivierloukombo.android_app_fake_api.R
import com.olivierloukombo.android_app_fake_api.model.Comment
import com.olivierloukombo.android_app_fake_api.ui.theme.AndroidappfakeapiTheme
import com.olivierloukombo.android_app_fake_api.vm.MainViewModel
import javax.inject.Inject

class Home @Inject constructor(var viewModel : MainViewModel?) {

   // @Inject lateinit var viewModel : MainViewModel

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
     fun Main() {

        AndroidappfakeapiTheme {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    Toolbar()
                }
            ) {

                val invokedComments = viewModel!!.getComments()
                CommentList(invokedComments)
            }


        }
    }

    @Composable
    fun Toolbar() {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.primary,
            elevation = 0.dp,
            title = {
                Text(
                    text = stringResource(R.string.app_name),
                    /*.uppercase(Locale.ROOT)*/
                    color = Color.White,
                    style = MaterialTheme.typography.h1,

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
                CommentItem(comment)

            }

        }
    }

    @Composable
    fun CommentItem(commentMe: Comment) {
        Card(
            modifier = Modifier
                .padding(8.dp, 4.dp)
                .fillMaxWidth()
                .height(140.dp), shape = RoundedCornerShape(0.dp), elevation = 4.dp
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
                            style = MaterialTheme.typography.h1,
                            maxLines = 1,
                            overflow = TextOverflow.Clip

                        )
                        Text(
                            text = commentMe.email,
                            style = MaterialTheme.typography.caption,
                            color = MaterialTheme.colors.primaryVariant,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier
                                .padding(4.dp)

                        )

                        Text(
                            text = commentMe.body,
                            style = MaterialTheme.typography.h2,
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )

                    }
                }
            }
        }

    }


}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    AndroidappfakeapiTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                Home(null).Toolbar()
            }
        ) {

            Comment(
                1,
                "id labore ex et quam laborum",
                "example@example.com",
                "laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium"
            ).let {
                Home(null).CommentItem(it)
            }
        }


    }
}