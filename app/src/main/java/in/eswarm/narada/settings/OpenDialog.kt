package `in`.eswarm.narada.settings

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

/*
https://stackoverflow.com/a/70588212
 */
@Composable
fun CustomDialog(
    openDialogCustom: MutableState<Boolean>,
    title: String,
    label: String,
    defaultValue: String = "",
    onOkRequest: (value: String) -> Unit
) {
    Dialog(onDismissRequest = { openDialogCustom.value = false }
    ) {
        CustomDialogUI(
            openDialogCustom = openDialogCustom,
            title = title,
            label = label,
            value = defaultValue,
            onOkRequest = onOkRequest
        )
    }
}

//Layout
@Composable
fun CustomDialogUI(
    modifier: Modifier = Modifier,
    title: String,
    label: String,
    value: String,
    openDialogCustom: MutableState<Boolean>,
    onOkRequest: (value: String) -> Unit
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp),
        elevation = 8.dp
    ) {
        Column {

            var textValue by rememberSaveable { mutableStateOf(value) }

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.subtitle1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                OutlinedTextField(
                    label = { Text(label) },
                    value = textValue,
                    onValueChange = { textValue = it },
                    singleLine = true,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                        .fillMaxWidth()
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                TextButton(onClick = {
                    openDialogCustom.value = false
                }) {
                    Text(
                        "Cancel",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                }
                TextButton(onClick = {
                    openDialogCustom.value = false
                    onOkRequest(textValue)
                }) {
                    Text(
                        "OK",
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                }
            }
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Preview(name = "Custom Dialog")
@Composable
fun MyDialogUIPreview() {
    CustomDialogUI(
        openDialogCustom = mutableStateOf(false),
        title = "MQTT Port",
        label = "Port",
        value = "Value",
        onOkRequest = {}
    )
}
