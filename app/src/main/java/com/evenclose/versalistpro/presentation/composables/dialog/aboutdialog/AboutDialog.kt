package com.evenclose.versalistpro.presentation.composables.dialog.aboutdialog

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.evenclose.versalistpro.presentation.composables.dialog.HelpDialogHeaderImage
import com.evenclose.versalistpro.presentation.ui.theme.onDark
import com.evenclose.versalistpro.presentation.ui.theme.secondaryContainer

@Composable
fun AboutDialog(
    onDismiss: () -> Unit
) {

    val context = LocalContext.current

    Dialog(
        onDismissRequest = onDismiss
    ) {

        Box(
            modifier = Modifier.offset(y = (-40).dp)
        ) {
            Column(
                modifier = Modifier
            ) {
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
                            color = onDark,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(horizontal = 32.dp, vertical = 16.dp)
                    ) {
                        Spacer(
                            modifier = Modifier.height(18.dp)
                        )
                        Text(
                            text = "About Us",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.headlineSmall,
                            color = onDark,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "Versalist Pro has been developed by Even Close.\n" + "Get in touch using the link below!",
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.bodyLarge,
                            color = onDark,
                            fontWeight = FontWeight.Bold,
                        )
                        Divider(
                            color = onDark,
                            thickness = 1.dp,
                            modifier = Modifier
                                .fillMaxWidth(0.95f)
                                .padding(top = 16.dp)
                        )
                        Text(
                            text = "evenclosedigital@gmail.com",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .fillMaxWidth()
                                .clickable {
                                    val email = "evenclosedigital@gmail.com"
                                    val intent = Intent(Intent.ACTION_SENDTO)
                                    intent.data = Uri.parse("mailto:$email")
                                    context.startActivity(intent)
                                },
                            style = MaterialTheme.typography.bodyLarge,
                            color = onDark,
                            fontWeight = FontWeight.Bold,
                        )
                        Divider(
                            color = onDark,
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
                                    text = "Dismiss",
                                    fontSize = 16.sp,
                                    color = onDark,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(top = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
            AboutDialogHeaderImage(
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.TopCenter)
            )
        }
    }
}

fun Context.sendMail(to: String, subject: String) {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "vnd.android.cursor.item/email" // or "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        // TODO: Handle case where no email app is available
    } catch (t: Throwable) {
        // TODO: Handle potential other type of exceptions
    }
}