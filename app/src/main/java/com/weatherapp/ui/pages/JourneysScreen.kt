package com.weatherapp.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JourneysScreen(
    onRestartFlow: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AchievementsCard()
        PersonalizedTrainingCard()
        IntergenerationalModeCard()
        ConquestsCard()
        MotivationCard()
        Button(
            onClick = onRestartFlow,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2ED572))
        ) {
            Icon(Icons.AutoMirrored.Filled.DirectionsRun, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Voltar ao inicio")
        }
    }
}

@Composable
private fun AchievementsCard() {
    GradientContainer(colors = PurpleGradient) {
        Text("Suas conquistas", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Voce esta indo muito bem!", color = Color.White.copy(alpha = 0.8f))
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Ranking semanal", fontWeight = FontWeight.Bold)
                RankingRow(1, "Voce", "2.450 pts")
                RankingRow(2, "Joao", "2.100 pts")
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Medalhas conquistadas", fontWeight = FontWeight.Bold)
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxWidth()) {
                    MedalChip("Primeira semana", Modifier.weight(1f))
                    MedalChip("10 treinos", Modifier.weight(1f))
                    MedalChip("Constancia", Modifier.weight(1f))
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text("Proxima recompensa", color = Color.White)
        Text("Mais 3 treinos para desbloquear", color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun PersonalizedTrainingCard() {
    val sessions = listOf(
        TrainingSession("Caminhada leve", "Perfeito para aquecer o corpo", "10 min"),
        TrainingSession("Alongamento", "Relaxe e fortalece os musculos", "5 min"),
        TrainingSession("Respiracao", "Tecnicas de relaxamento", "3 min")
    )
    GradientContainer(colors = BlueGradient) {
        Text("Treino personalizado", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Exercicios adaptados para voce", color = Color.White.copy(alpha = 0.8f))
        Spacer(modifier = Modifier.height(12.dp))
        sessions.forEach { session ->
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(session.title, fontWeight = FontWeight.Bold)
                        Text(session.description, color = Color.Gray, fontSize = 12.sp)
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text(session.duration, color = Color.Gray, fontWeight = FontWeight.Bold)
                        OutlinedButton(onClick = {}, shape = RoundedCornerShape(50)) {
                            Text("Iniciar")
                        }
                    }
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconWithLabel(Icons.Filled.Mic, "Navegacao por voz")
            IconWithLabel(Icons.Filled.Schedule, "Rotina guiada")
        }
    }
}

@Composable
private fun IconWithLabel(icon: ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = null, tint = Color.White)
        Text(label, color = Color.White, fontSize = 12.sp, textAlign = TextAlign.Center)
    }
}

@Composable
private fun IntergenerationalModeCard() {
    GradientContainer(colors = OrangeGradient) {
        Text("Modo intergeracional", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Conectando geracoes pelo movimento", color = Color.White.copy(alpha = 0.8f))
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Seu mentor virtual", fontWeight = FontWeight.Bold)
                Text("Vamos fazer o desafio de caminhada juntos hoje!", color = Color.Gray)
                OutlinedButton(onClick = {}) { Text("Responder") }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Desafio compartilhado", fontWeight = FontWeight.Bold)
                Text("Caminhada de 30 min", color = Color.Gray)
                SharedProgressBar(userMinutes = 15, mentorMinutes = 20)
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxWidth()) {
            InteractionButton(Icons.Filled.VideoCall, "Videoconferencia", Modifier.weight(1f))
            InteractionButton(Icons.Filled.Groups, "Grupo", Modifier.weight(1f))
        }
    }
}

@Composable
private fun SharedProgressBar(userMinutes: Int, mentorMinutes: Int) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Voce: $userMinutes min", color = Color.Gray)
        ProgressIndicator(userMinutes / 30f, Color(0xFF2ED572))
        Text("Pedro: $mentorMinutes min", color = Color.Gray)
        ProgressIndicator(mentorMinutes / 30f, Color(0xFF4A6CF7))
    }
}

@Composable
private fun ProgressIndicator(value: Float, color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            .clip(RoundedCornerShape(50))
            .background(Color.LightGray.copy(alpha = 0.3f))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(value)
                .fillMaxHeight()
                .clip(RoundedCornerShape(50))
                .background(color)
        )
    }
}

@Composable
private fun InteractionButton(icon: ImageVector, label: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White.copy(alpha = 0.9f))
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(icon, contentDescription = null, tint = Color(0xFF4A6CF7))
        Spacer(modifier = Modifier.height(8.dp))
        Text(label, textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun ConquestsCard() {
    GradientContainer(colors = YellowGradient) {
        Text("Conquistas", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Voce esta voando alto!", color = Color.White.copy(alpha = 0.8f))
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Ranking semanal", fontWeight = FontWeight.Bold)
                RankingRow(1, "Maria (voce)", "2.450 pontos")
                RankingRow(2, "Joao", "2.120 pontos")
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Text("Suas medalhas", fontWeight = FontWeight.Bold)
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxWidth()) {
                    MedalChip("Primeira semana", Modifier.weight(1f))
                    MedalChip("Sequencia de 7 dias", Modifier.weight(1f))
                    MedalChip("Meta mensal", Modifier.weight(1f))
                }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text("Proxima recompensa", color = Color.White)
        Text("Complete mais 3 treinos para desbloquear", color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun MotivationCard() {
    GradientContainer(colors = LavenderGradient) {
        Text("Motivacao diaria", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text("Mensagens para te inspirar", color = Color.White.copy(alpha = 0.8f))
        Spacer(modifier = Modifier.height(12.dp))
        val messages = listOf(
            "Parabens! Voce completou 7 dias seguidos de atividade.",
            "Hora do movimento! Que tal uma caminhada de 15 minutos?",
            "Nova conquista! Voce desbloqueou a medalha Perseveranca.",
            "Seu mentor enviou uma mensagem: vamos treinar hoje?"
        )
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            messages.forEach { text ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White.copy(alpha = 0.9f))
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Filled.EmojiEvents, contentDescription = null, tint = Color(0xFF4A6CF7))
                    Text(text, color = Color(0xFF4A4A4A))
                }
            }
        }
    }
}

@Composable
private fun RankingRow(position: Int, name: String, points: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(position.toString(), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(12.dp))
            Text(name)
        }
        Text(points, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun MedalChip(text: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Icon(Icons.Filled.EmojiEvents, contentDescription = null, tint = Color(0xFFFFB74D))
        Text(text, textAlign = TextAlign.Center, fontSize = 12.sp)
    }
}

private data class TrainingSession(val title: String, val description: String, val duration: String)
