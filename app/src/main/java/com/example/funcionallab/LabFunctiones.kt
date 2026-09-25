package com.example.funcionallab
data class Estudiante(val nombre: String, val nota: Double)

// Extension Function 1
fun String.esNombreValido(): Boolean = this.isNotBlank() && this.length > 2

// Extension Function 2
fun Double.esAprobado(): Boolean = this >= 7.0

// Extension Function 3
fun Double.esSobresaliente(): Boolean = this >= 9.0

// Extension Property
val Estudiante.estado: String
    get() = if (nota.esAprobado()) "Aprobado" else "Reprobado"

// Higher-order function 1
fun procesarEstudiantes(estudiantes: List<Estudiante>, operacion: (Estudiante) -> Unit)
{
    for (e in estudiantes) {
        operacion(e)
    }
}

// Higher-order function 2 (inline)
inline fun filtrarEstudiantes(estudiantes: List<Estudiante>, criterio: (Estudiante) ->
Boolean): List<Estudiante> {
    return estudiantes.filter(criterio)
}

// Función principal para pruebas
fun ejecutarLaboratorio() {
    val lista = listOf(
        Estudiante("Ana", 8.5),
        Estudiante("Luis", 6.2),
        Estudiante("María", 9.0),
        Estudiante("Pedro", 5.8)
    )
    println("=== Todos los estudiantes ===")
    procesarEstudiantes(lista) {
        println("${it.nombre} - Nota: ${it.nota} - Estado: ${it.estado}")
    }
    println("\n=== Estudiantes aprobados ===")
    val aprobados = filtrarEstudiantes(lista) { it.nota.esAprobado() }
    aprobados.forEach {
        println("${it.nombre} (${it.nota})")
    }
    println("\n=== Estudiantes sobresalientes ===")
    val sobresalientes = filtrarEstudiantes(lista) { it.nota.esSobresaliente() }
    aprobados.forEach {
        println("${it.nombre} (${it.nota})")
    }
}