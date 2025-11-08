# 💱 Conversor de Monedas en Tiempo Real

Este es un programa en **Java** que permite convertir cualquier tipo de moneda
en tiempo real utilizando la API de ExchangeRate. El conversor obtiene
las tasas de cambio actualizadas desde internet y mantiene un historial
completo de conversiones realizadas por el usuario.

------------------------------------------------------------------------

## 🚀 Características Principales

-   Conversión **en tiempo real** entre cualquier par de monedas (ej.
    USD → PEN, EUR → JPY, etc.).
-   **Conexión a API** (ExchangeRate API) para obtener tasas
    actualizadas.
-   **Historial completo** de todas las conversiones realizadas durante
    la sesión y despupes de la sesión.
-   Validación de entradas del usuario (monto, códigos de
    moneda, opciones del menú).
-   Interfaz en consola clara e interactiva.

------------------------------------------------------------------------

## 🧩 Estructura del Proyecto

    📦 ConversorMonedas
     ┣ 📂 excepciones
     ┃ ┗ 📜 ConversionExcepcion.java
     ┣ 📜 Conversor.java
     ┣ 📜 ConversorAPI.java
     ┣ 📜 Historial.java
     ┣ 📜 Moneda.java
     ┣ 📜 ValidarDatos.java
     ┗ 📜 Main.java

------------------------------------------------------------------------

## ⚙️ Funcionamiento del Programa

1.  Al iniciar el programa, el usuario elige entre:
    -   **Realizar una nueva conversión**
    -   **Ver historial actual**
    -   **Ver historial de todas las conversiones**
    -   **Salir del programa**
2.  Si elige convertir:
    -   Ingresa el **código de la moneda base** (por ejemplo, `PEN` o
        `USD`).
    -   Ingresa el **monto a convertir**.
    -   Ingresa el **código de la moneda destino** (por ejemplo, `EUR`,
        `JPY`, etc.).
    -   El programa consulta la **API de ExchangeRate** para obtener la
        tasa de cambio.
    -   Muestra el resultado con el monto convertido y la tasa aplicada.
3.  Cada conversión se **guarda automáticamente en el historial**, que
    puede verse en pantalla al finalizar o reiniciar el programa.

------------------------------------------------------------------------

## 📜 Ejemplo de Ejecución

    =========================================
       CONVERSOR DE MONEDAS - EN TIEMPO REAL
    =========================================

    Seleccione una opción:
    1. Realizar nueva conversión
    2. Ver historial actual
    3. Ver historial de todas las conversiones
    4. Salir

    Ingrese su opción: 1
    Ingrese el código de la moneda base (ej. USD, PEN, EUR): PEN
    Ingrese el monto a convertir: 100
    Ingrese el código de la moneda destino (ej. JPY, GBP, CLP): EUR

    🔄 Obteniendo tasas desde la API...

    💱 Resultado:
    100.00 PEN = 24.20 EUR
    (Tasa de cambio: 0.2420)

------------------------------------------------------------------------

## 🛠️ Requisitos del Sistema

-   **Java 17** o superior
-   Conexión a internet (para consultar la API)
-   Dependencias nativas de Java (sin librerías externas)

------------------------------------------------------------------------

## 🌐 API Utilizada

Este proyecto usa la API pública de [ExchangeRate
API](https://www.exchangerate-api.com/).\
Ejemplo de endpoint utilizado:

    https://v6.exchangerate-api.com/v6/74f877e5da1ce7ff6d3f4bd0/latest/USD

------------------------------------------------------------------------

## 📈 Historial de Conversiones

Cada vez que se realiza una conversión, se almacena en un registro
temporal de la sesión:

    [PEN → USD] 100.0 PEN = 26.42 USD (Tasa: 0.2642)
    [USD → EUR] 50.0 USD = 46.78 EUR (Tasa: 0.9356)
    ...

El historial se puede consultar antes de salir del programa.

------------------------------------------------------------------------

## 💡 Recomendaciones

-   Verifica que los códigos de moneda sean válidos según el estándar
    **ISO 4217**.\
-   Mantén conexión estable a internet para obtener las tasas más
    recientes.\

------------------------------------------------------------------------

## 👨‍💻 Autor

Desarrollado por **Pay Puma**\
Proyecto educativo para aplicar lo aprendido de **Java** en el curso de Backens en Alura Latam, **API REST**, y **manejo de
excepciones**.

------------------------------------------------------------------------
