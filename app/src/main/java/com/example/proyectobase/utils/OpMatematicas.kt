package com.example.proyectobase.utils

object OpMatematicas {
    // En python es def, aqui es fun, y al ingresarle variables n1 y n2 hay que definirles el
    // tipo de dato y el Int que va solo es el tipo de dato del resultado

    fun sumar(n1:Int, n2:Int) : Int{
        return n1 + n2
    }

    fun restar(n1:Int, n2:Int) : Int{
        return n1 - n2
    }

    fun multiplicar(n1:Int, n2:Int) : Int{
        return n1 * n2
    }

    fun dividir(n1:Int, n2:Int) : Int{
        try {
            return n1/n2
        } catch (e: ArithmeticException){
            return 0
        } finally {
            println("Se ha producido un error aritmetico")
        }

    }
}