package com.example.appinterface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.appinterface.ui.theme.AppInterfaceTheme
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appinterface.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppInterfaceTheme {
                LoginScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White) // Fundo branco
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        TextInicial()
        Spacer(modifier = Modifier.height(16.dp))
        SimpleEmailOutlinedTextFieldSample()
        Spacer(modifier = Modifier.height(16.dp))
        SimplePasswordOutlinedTextFieldSample()
        Spacer(modifier = Modifier.height(16.dp))
        TextPassword()
        Spacer(modifier = Modifier.height(16.dp))
        CheckboxWithTextSample()
        Spacer(modifier = Modifier.height(16.dp))
        ButtonEntrar()
        Spacer(modifier = Modifier.height(20.dp))
        TextCriarConta()
    }
}

@Composable
fun TextInicial() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Acesse sua Conta:",
            fontSize = 35.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Email") },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SimpleEmailOutlinedTextFieldSample() {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
        horizontalAlignment = Alignment.Start
    ) {
        EmailOutlinedTextField(
            value = email,
            onValueChange = { email = it }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Password") },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        singleLine = true,
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SimplePasswordOutlinedTextFieldSample() {
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
        horizontalAlignment = Alignment.Start
    ) {
        PasswordOutlinedTextField(
            value = password,
            onValueChange = { password = it }
        )
    }
}

@Composable
fun TextPassword() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 2.dp) // Reduzir o espaço superior
            .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Esqueci minha senha",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray,
            ),
        )
    }
}

@Composable
fun CheckboxWithTextSample() {
    val (checkedState, onStateChange) = remember { mutableStateOf(true) }
    Row(
        Modifier
            .fillMaxWidth()
            .width(180.dp)
            .height(25.dp)
            .toggleable(
                value = checkedState,
                onValueChange = { onStateChange(!checkedState) },
                role = Role.Checkbox
            )
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = null, // null recommended for accessibility with screenreaders
            colors = CheckboxDefaults.colors(
                checkmarkColor = Color.White, // Change checkmark color
                checkedColor = tomatoColor, // Set checked color as transparent to keep the checkmark icon
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Mostrar Senha",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun ButtonEntrar() {
    ExtendedFloatingActionButton(
        onClick = { /* do something */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp) // Reduzir o espaço superior
            .height(48.dp) // Altura reduzida
            .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
        containerColor = tomatoColor, // Usando a cor laranja personalizada
        contentColor = Color.Black,
        shape = MaterialTheme.shapes.small.copy(CornerSize(4.dp)) // Bordas menos arredondadas
    ) {
        Text(text = "ENTRAR", color = Color.White)
    }
}


@Composable
fun TextCriarConta() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Ainda não tem uma conta? Crie Agora",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
            textAlign = TextAlign.Start
        )
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

@Preview
@Composable
fun TextInicialPreview() {
    TextInicial()
}

@Preview
@Composable
fun TextFieldEmailPreview() {
    SimpleEmailOutlinedTextFieldSample()
}

@Preview
@Composable
fun TextFieldPasswordPreview() {
    SimplePasswordOutlinedTextFieldSample()
}

@Preview
@Composable
fun TextPasswordPreview() {
    TextPassword()
}

@Preview
@Composable
fun CheckboxPreview() {
    CheckboxWithTextSample()
}

@Preview
@Composable
fun ButtonCadastrarPreview() {
    ButtonEntrar()
}

@Preview
@Composable
fun TextCriarContaPreview() {
    TextCriarConta()
}
