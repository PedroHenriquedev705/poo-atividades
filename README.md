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

