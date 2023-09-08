package com.evenclose.versalistpro.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Policy
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.evenclose.versalistpro.R
import com.evenclose.versalistpro.presentation.composables.dialog.aboutdialog.AboutDialog
import com.evenclose.versalistpro.presentation.composables.dialog.languagedialog.LanguageDialog
import com.evenclose.versalistpro.presentation.composables.dialog.mainscreenhelpdialog.MainScreenHelpDialog
import com.evenclose.versalistpro.presentation.ui.theme.onDark
import com.evenclose.versalistpro.presentation.ui.theme.secondaryContainer

@Composable
fun MainScreenHeader(
    navController: NavController,
) {
    var expanded by remember { mutableStateOf(false) }

    /** Dialog */
    var openHelpDialog by remember { mutableStateOf(false) }
    var openAboutDialog by remember { mutableStateOf(false) }
    var openLanguageDialog by remember { mutableStateOf(false) }


    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 8.dp
            )
    ) {
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = onDark,
            modifier = Modifier.padding(start = 12.dp)
        )
        Box(
            //modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.TopStart)
        ) {
            IconButton(
                onClick = {
                    expanded = true
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = "Menu Icon",
                    tint = onDark
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .background(secondaryContainer)
                    .border(1.dp, onDark, RoundedCornerShape(4.dp))
            ) {
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Help,
                            contentDescription = "Help Icon",
                            tint = onDark
                        )
                    },
                    text = {
                        Text(
                            text = stringResource(id = R.string.help),
                            fontSize = 16.sp,
                            color = onDark
                        )
                    },
                    onClick = {
                        expanded = false
                        openHelpDialog = true
                    }
                )
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "Info Icon",
                            tint = onDark
                        )
                    },
                    text = {
                        Text(
                            text = stringResource(id = R.string.about),
                            fontSize = 16.sp,
                            color = onDark
                        )
                    },
                    onClick = {
                        expanded = false
                        openAboutDialog = true
                    }
                )
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Policy,
                            contentDescription = "Privacy Icon",
                            tint = onDark
                        )
                    },
                    text = {
                        Text(
                            text = stringResource(id = R.string.privacy),
                            fontSize = 16.sp,
                            color = onDark
                        )
                    },
                    onClick = { /* TODO*/ }
                )
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Language,
                            contentDescription = "Language Icon",
                            tint = onDark
                        )
                    },
                    text = {
                        Text(
                            text = stringResource(id = R.string.language),
                            fontSize = 16.sp,
                            color = onDark
                        )
                    },
                    onClick = {
                        expanded = false
                        openLanguageDialog = true
                    }
                )
            }
        }

        if (openHelpDialog) {
            MainScreenHelpDialog(
                onDismiss = {
                    openHelpDialog = false
                }
            )
        }
        if (openAboutDialog) {
            AboutDialog(
                onDismiss = {
                    openAboutDialog = false
                }
            )
        }
        if (openLanguageDialog) {
            LanguageDialog(
                onDismiss = {
                    openLanguageDialog = false
                }
            )
        }

    }
}