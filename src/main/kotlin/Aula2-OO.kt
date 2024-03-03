package br.ifpb.pdm
//import kotlin.reflect.full.declaredMemberProperties
import java.util.*

fun main() {
    val repositorioAnimal = RepositorioAnimal()

    var opcao = 0
    while (opcao != 8) {
        menu()
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toIntOrNull() ?: 0
        when (opcao) {
            1 -> repositorioAnimal.criarAnimal()
            2 -> {
                print("Digite o nome do animal que deseja remover: ")
                val nomeRemover = readlnOrNull() ?: ""
                repositorioAnimal.remover(nomeRemover)
            }
            3 -> {
                println("Nome - Cor - Idade")
                repositorioAnimal.listar()
            }
            4 -> repositorioAnimal.animais.forEach(Animal::emitirSom)
            5 -> {
                print("Digite a cor dos animais que deseja listar: ")
                val corListar = readlnOrNull()?.uppercase(Locale.getDefault())?.let { Cor.valueOf(it) }
                if (corListar != null) {
                    repositorioAnimal.listarPorCor(corListar)
                } else {
                    println("Cor inválida.")
                }
            }
            6 -> {
                print("Digite a idade dos animais que deseja listar: ")
                val idadeListar = readlnOrNull()?.toIntOrNull() ?: 0
                repositorioAnimal.listarPorIdade(idadeListar)
            }
            999 -> {
                // criar 10 animais de exemplo
                for (i in 1..10) {
                    val nome = "Animal $i"
                    val idade = Random().nextInt(20)
                    val cor = Cor.entries.toTypedArray().random()
                    // criar tipo de animal aleatório, são 4 tipos
                    val tipo = Random().nextInt(4)
                    when (tipo) {
                        0 -> {
                            repositorioAnimal.adicionar(Cachorro(idade, nome, cor))
                        }
                        1 -> {
                            repositorioAnimal.adicionar(Gato(idade, nome, cor))
                        }
                        2 -> {
                            repositorioAnimal.adicionar(Passaro(idade, nome, cor))
                        }
                        3 -> {
                            repositorioAnimal.adicionar(Humano(idade, nome, cor))
                        }
                    }
                }
            }
        }
    }
}

enum class Cor {
    PRETO, MARROM, CINZA, AZUL
}

open class Animal(var idade: Int, var nome: String, var cor: Cor) {
    open fun emitirSom() {
        println("Som de animal")
    }

    open fun idadeEmAnosHumanos(): Int {
        return idade * 7
    }
}

class Humano(idade: Int, nome: String, cor: Cor) : Animal(idade, nome, cor){
    override fun emitirSom() {
        println("Olá mundo!")
    }

    override fun idadeEmAnosHumanos(): Int {
        return idade
    }
}

class Cachorro(idade: Int, nome: String, cor: Cor) : Animal(idade, nome, cor) {
    override fun emitirSom() {
        println("Au au")
    }
}

class Gato(idade: Int, nome: String, cor: Cor) : Animal(idade, nome, cor) {
    override fun emitirSom() {
        println("Miau")
    }
}

class Passaro(idade: Int, nome: String, cor: Cor) : Animal(idade, nome, cor) {
    override fun emitirSom() {
        println("Piu piu")
    }
}

fun menu() {
    println("1 - Criar Animal") // Ao digitar um um submenu aparece para escolher o tipo de animal (gato, cachorro...)
    println("2 - Remover Animal")
    println("3 - Listar Animais")
    println("4 - Emitir som")
    println("5 - Listar Animais por Cor")
    println("6 - Listar Animais por Idade")
}

class RepositorioAnimal {
    val animais: MutableList<Animal> = mutableListOf()

    fun criarAnimal() {
        println("Digite o tipo do animal: ")
        println("1 - Cachorro")
        println("2 - Gato")
        println("3 - Pássaro")
        println("4 - Humano")

        val tipo = readlnOrNull()?.toIntOrNull() ?: 0
        print("Digite o nome do animal: ")
        val nome = readlnOrNull() ?: ""
        print("Digite a idade do animal: ")
        val idade = readlnOrNull()?.toIntOrNull() ?: 0
        print("Digite a cor do animal: ")
        val cor = readlnOrNull()?.uppercase(Locale.getDefault())?.let { Cor.valueOf(it) } ?: Cor.PRETO

        var animal: Animal? = null

        when (tipo) {
            1 -> {
                animal = Cachorro(idade, nome, cor)
            }
            2 -> {
                animal = Gato(idade, nome, cor)
            }
            3 -> {
                animal = Passaro(idade, nome, cor)
            }
            4 -> {
                animal = Humano(idade, nome, cor)
            }
            else -> println("Tipo inválido.")
        }

        if (animal != null) {
            animais.add(animal)
            println("Animal criado com sucesso!")
        }
    }

    fun adicionar(animal: Animal) {
        animais.add(animal)
    }

    fun listar() {
        animais.forEach { println("${it.nome} - ${it.cor} - ${it.idade}") }
    }

    fun remover(nome: String) {
        val animal = animais.find { it.nome == nome }
        if (animal != null) {
            animais.remove(animal)
            println("$nome removido com sucesso!")
        } else {
            println("Animal com nome $nome não encontrado.")
        }
    }

    fun listarPorCor(cor: Cor) {
        val animaisPorCor = animais.filter { it.cor == cor }
        if (animaisPorCor.isNotEmpty()) {
            println("Animais com a cor $cor:")
            animaisPorCor.forEach { println("${it.nome} - ${it.idade} anos") }
        } else {
            println("Não há animais com a cor $cor.")
        }
    }

    fun listarPorIdade(idade: Int) {
        val animaisPorIdade = animais.filter { it.idade == idade }
        if (animaisPorIdade.isNotEmpty()) {
            println("Animais com $idade anos:")
            animaisPorIdade.forEach { println("${it.nome} - ${it.cor}") }
        } else {
            println("Não há animais com $idade anos.")
        }
    }
}


