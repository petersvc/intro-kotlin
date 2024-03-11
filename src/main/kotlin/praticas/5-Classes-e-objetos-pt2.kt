package br.ifpb.pdm.praticas

/** SISTEMA DE REGISTROS DE FUNCIONÁRIOS
 *
 * Desenvolva um sistema de registro de funcionários para uma empresa.
 * O sistema deverá permitir registrar diferentes tipos de funcionários e apresentar suas informações.
 *
 * Alguns passos abaixo:
 *
 * 1.Crie uma classe base chamada Funcionario com as seguintes propriedades:
 * - Nome (string): o nome do funcionário.
 * - Idade (int): a idade do funcionário.
 *
 * 2.Crie uma classe Gerente que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Setor (string): o setor em que o gerente trabalha.
 *
 * 3.Crie uma classe Desenvolvedor que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Linguagem (string): a linguagem de programação que o desenvolvedor utiliza.
 *
 * 4.Crie uma classe Analista que herda da classe Funcionario e adicione uma propriedade adicional:
 * - Area (string): a área de especialização do analista.
 *
 * 5.Imprima uma mensagem informando que um novo funcionário foi registrado, juntamente com o nome e a idade do
 * funcionário. (Lembre-se do init)
 *
 * 6. Crie um método na classe Funcionario chamado Apresentar que imprima uma mensagem de apresentação do funcionário,
 * incluindo o nome e a idade.
 *
 * 7. Crie uma lista de funcionários e adicione diferentes tipos de funcionários (gerentes, desenvolvedores e analistas)
 * à lista.
 *
 * 8. Utilize o typecast (is e as) para verificar o tipo de cada funcionário na lista e chamar o método Apresentar
 * correspondente.
 */

open class Funcionario(val nome: String, val idade: Int) {
    init {
        println("Novo funcionário registrado: $nome, $idade anos.")
    }
    open fun apresentar(): String {
        return "Olá, meu nome é $nome e tenho $idade anos"
    }
}

class Gerente(nome: String, idade: Int, val setor: String) : Funcionario(nome, idade){
    override fun apresentar(): String {
        return "Olá, meu nome é $nome e tenho $idade anos e trabalho no setor de $setor"
    }
}

class Desenvolvedor(nome: String, idade: Int, val linguagem: String) : Funcionario(nome, idade){
    override fun apresentar(): String {
        return "Olá, meu nome é $nome e tenho $idade anos e trabalho com a linguagem $linguagem"
    }
}

class Analista(nome: String, idade: Int, val area: String) : Funcionario(nome, idade){
    override fun apresentar(): String {
        return "Olá, meu nome é $nome e tenho $idade anos e sou especialista na área de $area"
    }
}

fun main() {
    println("Sistema de registro de funcionários")

    val funcionarios = mutableListOf<Funcionario>(
        Gerente("João", 35, "TI"),
        Desenvolvedor("Maria", 28, "Kotlin"),
        Analista("José", 30, "BI")
    )

    var tipo = ""

    funcionarios.forEach {
        tipo = when (it) {
            is Gerente -> "Gerente"
            is Desenvolvedor -> "Desenvolvedor"
            is Analista -> "Analista"
            else -> "Funcionário"
        }

        println("${it.apresentar()} e trabalho como ${tipo}.")
    }
}