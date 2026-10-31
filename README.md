# POO - Atividades

## Lista 01
Exercício 05

### 1. Scanner e System.out.printf

O `Scanner` é usado para ler dados digitados pelo usuário.

Exemplo:

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);

System.out.print("Digite um número: ");
double num = sc.nextDouble();

System.out.printf("Número: %.2f%n", num);

sc.close();
```

O `%.2f` faz o número ser mostrado com **2 casas decimais**.

---

### 2. Correção do código

Os erros encontrados foram:

* `String args` → o correto é `String[] args`;
* faltou `;` no `System.out.println`;
* a quebra de linha dentro da string estava errada;
* o `contador` não era incrementado, causando um loop infinito.

### Código corrigido:

```java
import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int contador = 0;

        while (contador <= 5) {

            System.out.println("Contador: " + contador);

            contador++;
        }

        sc.close();
    }
}
```

### Saída:

```text
Contador: 0
Contador: 1
Contador: 2
Contador: 3
Contador: 4
Contador: 5
```
# Lista 02

## Questão 1: Getters e setters

Usar getters e setters em vez de atributos públicos é boa prática por causa do **encapsulamento**:

- **Controle de acesso:** a classe decide o que pode ser lido e o que pode ser alterado. Um atributo sem setter, por exemplo, é somente leitura.
- **Validação:** o setter pode recusar valores inválidos, mantendo o objeto sempre em um estado consistente. Com atributo público, qualquer código externo atribui o que quiser.
- **Manutenção:** a representação interna pode mudar (tipo, formato, cálculo) sem quebrar quem usa a classe, desde que a interface pública seja mantida.
- **Flexibilidade:** é possível adicionar efeitos colaterais depois (log, notificação, recálculo) sem alterar o código que chama o método.

**Exemplo:** em uma classe `Produto`, o setter do preço impede valores negativos.

```java
public void setPreco(double preco) {
    if (preco < 0) {
        throw new IllegalArgumentException("O preço não pode ser negativo.");
    }
    this.preco = preco;
}
```

Se `preco` fosse público, algo como `produto.preco = -50;` seria aceito e deixaria o objeto com dados inválidos. Com o setter, essa atribuição é barrada e a integridade do objeto é preservada.



## Questão 2: Sistema de controle de biblioteca

### Informações relevantes para representar um livro

- Título
- Autor(es)
- ISBN (identificador único)
- Editora
- Ano de publicação
- Edição
- Categoria ou gênero
- Número de exemplares (total e disponíveis)
- Localização na estante
- Status (disponível, emprestado, reservado)

### Por que `Livro` é uma abstração?

Porque a classe representa apenas as características do livro que são **relevantes para o sistema**, ignorando todo o resto (cor da capa, peso, cheiro, número de páginas amareladas etc.). Ela simplifica um objeto do mundo real, escondendo detalhes irrelevantes e expondo só o que importa para o contexto da biblioteca: identificar, emprestar, devolver e consultar.

### Métodos que fariam sentido

- `emprestar()`: marca um exemplar como emprestado e reduz a quantidade disponível, se houver algum.
- `devolver()`: registra a devolução e aumenta a quantidade disponível.
- `reservar()`: reserva o livro quando não há exemplares disponíveis.
- `estaDisponivel()`: retorna se há ao menos um exemplar para empréstimo.
- `exibirInfo()`: imprime os dados do livro.

# Lista 03

## Questão 4: Array de primitivos vs. array de objetos

Em Java, todo array é um **objeto** e fica no **heap**. A diferença está no que cada posição guarda.

| | `int[]`, `double[]` (primitivos) | `Aluno[]`, `Produto[]` (objetos) |
|---|---|---|
| **O que cada posição guarda** | O próprio valor | Uma **referência** (endereço) para um objeto |
| **Valor inicial** | `0`, `0.0`, `false`... | `null` |
| **Onde ficam os dados** | Contíguos dentro do próprio array | Objetos espalhados no heap; o array guarda só as referências |

### a) Como a memória é alocada em cada caso?

**Array de primitivos:** `new int[5]` aloca um único bloco contíguo no heap com espaço para 5 inteiros, já inicializados com `0`. Os valores ficam dentro do array.

```java
int[] notas = new int[3];
// heap: [0][0][0]
notas[0] = 10;
// heap: [10][0][0]
```

**Array de objetos:** `new Aluno[3]` aloca apenas um bloco com 3 **referências**, todas `null`. Nenhum objeto `Aluno` foi criado ainda. Cada objeto precisa ser criado com `new` e fica em outra região do heap; o array só aponta para ele.

```java
Aluno[] alunos = new Aluno[3];
// heap: [null][null][null]
alunos[0] = new Aluno("Ana", 1);
// heap: [ref -> Aluno(Ana)][null][null]
```

A variável (`notas`, `alunos`) em si é uma referência na pilha (stack) que aponta para o array no heap.

### b) Cuidados ao acessar elementos de um array de objetos

- **`NullPointerException`:** criar o array não cria os objetos. Chamar `alunos[1].getNome()` com posição `null` lança exceção. É preciso instanciar cada posição antes de usar, ou testar `if (alunos[i] != null)`.
- **Percorrer só as posições preenchidas:** se o array não está cheio, usar um contador de elementos em vez de `array.length`, para não bater em `null`.
- **Aliasing (cópia de referência):** `alunos[1] = alunos[0]` faz as duas posições apontarem para o **mesmo** objeto; alterar um altera o outro. Para copiar de verdade, é preciso criar um novo objeto.
- **Cópia do array é rasa:** `clone()` e `Arrays.copyOf()` copiam as referências, não os objetos, então o novo array compartilha os mesmos objetos.
- **Comparação:** `==` compara referências, não conteúdo. Para comparar o conteúdo, usar `equals()` (sobrescrito na classe).
- **Limites do índice:** acessar fora de `0..length-1` lança `ArrayIndexOutOfBoundsException`, igual nos primitivos.

# Lista 04

## Questão 1: Verdadeiro ou falso

**a) Os construtores de superclasse não são herdados por subclasses.**

**Verdadeira.** Construtores não são herdados. Cada classe define os seus. A subclasse apenas **chama** o construtor da superclasse, usando `super(...)`, para inicializar a parte herdada do objeto.

**b) Um relacionamento "tem um" é implementado via herança.**

**Falsa.** Herança implementa o relacionamento **"é um"** (`Cachorro` é um `Animal`). O relacionamento **"tem um"** é implementado por **composição**: uma classe possui, como atributo, um objeto de outra classe (`Carro` tem um `Motor`).

```java
class Carro {
    private Motor motor; // Carro "tem um" Motor
}
```

**c) Quando uma subclasse redefine um método da superclasse com a mesma assinatura, diz-se que ela sobrecarrega esse método.**

**Falsa.** Redefinir um método com a mesma assinatura é **sobrescrita** (*override*). **Sobrecarga** (*overload*) é ter métodos com o **mesmo nome e parâmetros diferentes**, na mesma classe ou na hierarquia.

```java
class Animal {
    void emitirSom() { System.out.println("..."); }
}

class Cachorro extends Animal {
    @Override
    void emitirSom() { System.out.println("Au au"); } // sobrescrita

    void emitirSom(int vezes) { /* ... */ }           // sobrecarga
}
```



## Questão 2: `protected` vs. `private` em superclasses

### Argumentos a favor de `protected`

- **Acesso direto das subclasses:** elas usam e alteram o atributo sem precisar de getters e setters, com código mais simples.
- **Desempenho:** evita a chamada de método, embora a diferença seja desprezível na prática.
- **Extensibilidade:** facilita criar subclasses que precisam do estado interno da superclasse.

### Argumentos a favor de `private`

- **Encapsulamento forte:** só a própria classe acessa seus dados, então ela controla totalmente o seu estado.
- **Validação centralizada:** toda alteração passa pelo setter, que garante que o objeto continue consistente. Com `protected`, cada subclasse poderia quebrar essa regra.
- **Manutenção:** a superclasse pode mudar sua representação interna sem quebrar as subclasses. Com `protected`, qualquer mudança no atributo afeta todas elas.
- **Acoplamento menor:** a subclasse depende da interface pública, não de detalhes de implementação.
- **Brecha no pacote:** em Java, `protected` também dá acesso a qualquer classe do **mesmo pacote**, o que expõe ainda mais o atributo.

### Conclusão

Os atributos devem ser `private`, com acesso por getters e setters (`public` ou `protected`). Assim a superclasse mantém o encapsulamento e as subclasses ainda conseguem usar o que precisam. O `protected` fica melhor para **métodos** pensados para as subclasses (pontos de extensão), e não para atributos.

```java
public class Funcionario {
    private double salario; // protegido por encapsulamento

    protected double getSalario() { return salario; }

    protected void setSalario(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("Salário inválido.");
        }
        this.salario = salario;
    }
}
```



## Questão 3: Chamada de construtores em hierarquias de herança

### Como funciona

Ao criar um objeto de uma subclasse, os construtores são executados **da superclasse mais alta até a classe mais baixa**. A primeira instrução de todo construtor é a chamada a outro construtor: `super(...)` (da superclasse) ou `this(...)` (da própria classe).

- Se o programador não escrever nada, o compilador insere automaticamente `super();`, que chama o construtor **sem argumentos** da superclasse.
- Se a superclasse **não tem** construtor sem argumentos, a subclasse é obrigada a chamar `super(...)` explicitamente com os argumentos corretos. Caso contrário, o código **não compila**.
- A chamada a `super(...)` deve ser a **primeira instrução** do construtor.

**Exemplo:**

```java
class Animal {
    Animal(String nome) {
        System.out.println("Animal: " + nome);
    }
}

class Cachorro extends Animal {
    Cachorro(String nome) {
        super(nome); // obrigatório: Animal não tem construtor vazio
        System.out.println("Cachorro: " + nome);
    }
}

// new Cachorro("Rex");
```

Saída:

```text
Animal: Rex
Cachorro: Rex
```

### Por que a chamada é obrigatória?

Um objeto da subclasse **contém** a parte da superclasse (atributos herdados). Essa parte precisa ser inicializada antes de a subclasse usá-la, e quem sabe inicializá-la é o construtor da superclasse, principalmente quando ela tem atributos `private` que a subclasse não acessa diretamente.

Sem essa chamada, o objeto poderia ficar com a parte herdada em estado inválido ou não inicializado, e as subclasses poderiam usar dados inconsistentes. Por isso o Java garante, de forma implícita ou explícita, que **toda a cadeia de construtores seja executada**, da raiz (`Object`) até a classe instanciada.


# Lista 05

## Questão 1: Métodos com corpo em interfaces

**A partir de qual versão?** Desde o **Java 8**, as interfaces podem ter métodos `default` e `static` com corpo. (No Java 9 também passaram a aceitar métodos `private`, usados para reaproveitar código entre os métodos `default`.)

### Utilidade dos métodos `default`

- **Evolução de interfaces sem quebrar código existente:** antes do Java 8, adicionar um método abstrato a uma interface obrigava todas as classes que a implementavam a serem alteradas. Com `default`, o método novo já vem com uma implementação padrão e as classes antigas continuam compilando. Foi assim que o Java adicionou `forEach` e `stream` à interface `Collection`.
- **Comportamento padrão reaproveitável:** as classes herdam a implementação e só sobrescrevem se precisarem de algo diferente.

### Utilidade dos métodos `static`

- **Métodos utilitários ligados à interface:** ficam na própria interface, em vez de numa classe auxiliar separada (como `Collections` para `Collection`). Exemplo: `Comparator.comparing(...)`.
- Não são herdados pelas classes que implementam a interface; são chamados pelo nome da interface (`Interface.metodo()`).

```java
public interface Imprimivel {
    void imprimir();

    default void imprimirDuasVezes() {   // método default
        imprimir();
        imprimir();
    }

    static Imprimivel vazio() {          // método static
        return () -> { };
    }
}
```



## Questão 2: Interfaces, desacoplamento e manutenção

### Como as interfaces ajudam

- **Dependência do contrato, não da implementação:** o código cliente usa a interface e não sabe qual classe concreta está por trás. Se a implementação mudar, o cliente não precisa mudar.
- **Substituição fácil (polimorfismo):** é possível trocar uma implementação por outra sem alterar quem a usa.
- **Testabilidade:** em testes, a implementação real pode ser trocada por uma falsa (*mock*), sem acessar banco de dados, rede etc.
- **Trabalho em paralelo:** equipes combinam o contrato e desenvolvem cada lado separadamente.
- **Extensibilidade:** novos comportamentos são adicionados criando novas classes, sem modificar o código existente (princípio aberto/fechado).
- **Herança múltipla de tipo:** uma classe pode implementar várias interfaces, o que não é possível com classes.

### Exemplo prático: envio de notificações

Um sistema precisa notificar o cliente. Se o serviço de pedidos usar diretamente a classe `EmailService`, ele fica preso ao e-mail. Se amanhã for preciso enviar SMS ou notificação push, será necessário alterar o serviço de pedidos.

Com uma interface, o serviço depende só do contrato:

```java
public interface Notificador {
    void enviar(String destino, String mensagem);
}

public class NotificadorEmail implements Notificador {
    public void enviar(String destino, String mensagem) { /* envia e-mail */ }
}

public class NotificadorSms implements Notificador {
    public void enviar(String destino, String mensagem) { /* envia SMS */ }
}

public class PedidoService {
    private final Notificador notificador; // depende da interface

    public PedidoService(Notificador notificador) {
        this.notificador = notificador;
    }

    public void finalizarPedido(String cliente) {
        // ... regras do pedido ...
        notificador.enviar(cliente, "Pedido finalizado!");
    }
}
```

Para trocar e-mail por SMS, basta passar outra implementação no construtor; `PedidoService` não muda. Nos testes, usa-se um `Notificador` falso, sem enviar mensagens de verdade.
