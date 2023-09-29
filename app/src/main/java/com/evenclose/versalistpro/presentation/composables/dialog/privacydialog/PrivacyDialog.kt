package com.evenclose.versalistpro.presentation.composables.dialog.privacydialog

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.evenclose.versalistpro.R
import com.evenclose.versalistpro.presentation.composables.dialog.aboutdialog.AboutDialogHeaderImage
import com.evenclose.versalistpro.presentation.ui.theme.light
import com.evenclose.versalistpro.presentation.ui.theme.secondaryContainer

@Composable
fun PrivacyDialog(
    onDismiss: () -> Unit
) {

    val context = LocalContext.current

    Dialog(
        onDismissRequest = onDismiss
    ){
        Box(
            modifier = Modifier.offset(y = (-40).dp)
        ){
            Column(
                modifier = Modifier
            ){
                Spacer(
                    modifier = Modifier
                        .height(100.dp)
                )
                Box(
                    modifier = Modifier
                        .background(
                            color = secondaryContainer,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = light,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .fillMaxWidth()
                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(horizontal = 32.dp, vertical = 16.dp)
                    ){
                        Spacer(
                            modifier = Modifier.height(18.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.privacy),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.headlineSmall,
                            color = light,
                            fontWeight = FontWeight.Bold,
                        )
/*                        Text(
                            text = "Use the link below to learn about the Privacy Policy for this app",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.bodyLarge,
                            color = light,
                            fontWeight = FontWeight.Bold,
                        )*/
                        Divider(
                            color = light,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth(0.95f)
                                .padding(top = 16.dp)
                        )
                        Text(
                            text = "Privacy Policy",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .fillMaxWidth()
                                .clickable {
                                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://evenclose.wordpress.com/2023/09/29/versalist-pro-privacy-policy/")))
                                },
                            style = MaterialTheme.typography.bodyLarge,
                            color = light,
                            fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.Underline
                        )
                        Divider(
                            color = light,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth(0.95f)
                                .padding(top = 16.dp)
                        )
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            TextButton(
                                onClick = {
                                    onDismiss()
                                }
                            ) {
                                Text(
                                    text = stringResource(id = R.string.dismiss),
                                    fontSize = 16.sp,
                                    color = light,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(top = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
            PrivacyDialogHeaderImage(
                modifier = Modifier
                    .size(170.dp)
                    .align(Alignment.TopCenter)
            )
        }
    }
}