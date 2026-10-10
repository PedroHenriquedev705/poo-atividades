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