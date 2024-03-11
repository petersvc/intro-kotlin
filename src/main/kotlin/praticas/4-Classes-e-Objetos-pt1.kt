import java.util.*

// Questão 1
class Produto(var nome: String, var preco: Double) {

    // Implemente os construtores conforme especificado na questão
    constructor() : this("Produto", 0.0){}
    constructor(nome: String) : this(nome, 0.0){}
}

fun questao1() {
    // Crie instâncias das diferentes classes Produto utilizando os seus construtores e imprima os detalhes de cada produto.
    val p1 = Produto("Produto1", 10.0)
    val p2 = Produto()
    val p3 = Produto("Produto3")
    println("${p1.nome} - R$ ${p1.preco}")
    println("${p2.nome} - R$ ${p2.preco}")
    println("${p3.nome} - R$ ${p3.preco}")
}

// Questão 2
class Cliente {
    var nome: String = ""
    private var idade: Int = 0

    // Utilize os modificadores de visibilidade para definir os atributos nome e idade conforme especificado na questão

    // Crie um método público na classe Cliente chamado mostrarIdade() conforme especificado na questão
    fun mostrarIdade() {
        println("Idade: $idade")
    }
}

fun questao2() {
    // Crie uma instância de Cliente e chame o método mostrarIdade() para verificar seu funcionamento.
    val c = Cliente()
    c.mostrarIdade()
}

// Questão 3
abstract class Personagem {
    // Crie um método abstrato atacar() conforme especificado na questão
    open fun atacar() {
        println("Atacando...")
    }
}

class Guerreiro : Personagem() {
    override fun atacar() {
        // Implemente o método atacar() de acordo com as características do Guerreiro
        println("Espadada!")
    }
}

class Mago : Personagem() {
    override fun atacar() {
        // Implemente o método atacar() de acordo com as características do Mago
        println("Feitiço!")
    }
}

fun questao3() {
    // Crie instâncias de Guerreiro e Mago e chame o método atacar() de cada um para verificar se estão realizando os ataques corretamente de acordo com suas respectivas classes.
    val guerreiro = Guerreiro()
    val mago = Mago()
    guerreiro.atacar()
    mago.atacar()
}

// Questão 4
interface FormaGeometrica {
    // Declare um método abstrato calcularArea() conforme especificado na questão
    fun calcularArea(): Double
}

class Retangulo(val altura: Double, val largura: Double) : FormaGeometrica {
    // Implemente o método calcularArea() para o Retangulo conforme especificado na questão
    //}
    override fun calcularArea(): Double {
        return altura * largura
    }
}

class Circulo(val raio: Double) : FormaGeometrica {
    // fun calcularArea(): Double {
    // Implemente o método calcularArea() para o Circulo conforme especificado na questão
    //}
    override fun calcularArea(): Double {
        return Math.PI * raio * raio
    }
}

fun questao4() {
    // Crie instâncias dessas duas classes e chame o método calcularArea() em cada uma delas para verificar o resultado.
    val retangulo = Retangulo(10.0, 5.0)
    val circulo = Circulo(5.0)
    println("Área do retângulo: ${retangulo.calcularArea()}")
    println("Área do círculo: ${circulo.calcularArea()}")
}

// Questão 5
class ContaBancaria {
    var numeroConta: String = ""
    var nomeTitular: String = ""
        get() = field.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    private var saldo: Double = 0.0
        set(value) {
            field = if (value < 0) {
                0.0
            } else {
                value
            }
        }

    // Implemente um getter personalizado para a propriedade nomeTitular conforme especificado na questão
    fun mostrarSaldo() {
        println("Saldo: $saldo")
    }

    // Implemente override do setter para o atributo saldo conforme especificado na questão
    fun diminuirSaldo(quantia: Double) {
        saldo -= quantia
    }
}

fun main() {
    // Crie uma instância de ContaBancaria. Altere o nome do titular para uma string que inicie com letra minúscula e mude o saldo para um valor negativo. Imprima os valores para verificar se as regras dos getters e setters estão sendo aplicadas corretamente.
    val conta = ContaBancaria()

    println("Questão 1")
    questao1()

    println("\nQuestão 2")
    questao2()

    println("\nQuestão 3")
    questao3()

    println("\nQuestão 4")
    questao4()

    println("\nQuestão 5")
    conta.nomeTitular = "joão"
    conta.diminuirSaldo(100.0)
    println("Nome do titular: ${conta.nomeTitular}")
    conta.mostrarSaldo()

}
