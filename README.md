# POO - Atividades

## Exercício 05

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
