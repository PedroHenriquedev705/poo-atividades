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