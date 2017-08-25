# [UDEA-PS] Programa 2 [![Build Status](https://travis-ci.org/yoinergomez/Pruebas_PS1.svg?branch=master)](https://travis-ci.org/yoinergomez/Pruebas_PS1) [![Coverage Status](https://coveralls.io/repos/github/yoinergomez/Pruebas_PS1/badge.svg?branch=master)](https://coveralls.io/github/yoinergomez/Pruebas_PS1?branch=master) [![trello](https://img.shields.io/badge/trello-Pruebas__PS1-blue.svg)](https://trello.com/b/YSHHBdhP/pruebasps1)

Aplicación que cuenta la cantidad de líneas de código teniendo en cuenta un [estándar de conteo. (Ver estándar)](https://github.com/yoinergomez/Pruebas_PS1/blob/master/doc/Est%C3%A1ndar%20de%20conteo%20programa%20java.docx)

## Desarrolladores
Jhonatan Alexánder Orozco Blandón.
Frank Alexis Castrillón Giraldo.
Yoiner Esteban Gómez Ayala.

## Metodología [![trello](https://img.shields.io/badge/trello-Pruebas__PS1-blue.svg)](https://trello.com/b/YSHHBdhP/pruebasps1)
**- Análisis:** Los miembros del equipo comprendieron el documento donde se describía el problema y sus requerimientos, también se definieron las tecnologías, IDE de desarrollo, lenguaje de programación y tareas para realizar por cada integrante.
  

Posteriormente, se establece un estandar de códificación que nos permite abordar de una manera correcta el desarrollo de software y en ese mismo proceso definir el estandar de conteo que debera tener el cuenta el Programa 2 para calcular el total de lineas código.

**- Planeación:** Se asignaron y estimaron las tareas por medio de la técnica de _planning poker_, además para lograr una mayor claridad se describieron las tareas que presentaban ambigüedad o no tenían un alcance bien definido.

**- Implementación:** El equipo implemento la metodología de desarrollo TDD y en base a esto se resolvieron las tareas estipuladas en las etapas anteriores.

**- Verificación:** Se comprobó la ejecución del programa y el nivel de cobertura del código fuera mayor o igual al 90%.

## Tecnologías usadas
- Java v1.8
- NetBeans v8.2
- Maven v3.0.5

## Herramientas utilizadas
- Trello  [![Plus for Trello]()](https://chrome.google.com/webstore/search/Plus%20for%20trello)

Para poder medir el tiempo que se requirio en el desarrollo de una tarea en especifico, se utilizo el plugin del navegador Chrome llamado "Plus for Trello" que permite iniciar un cronometro con el objetivo de saber exactamente cuanto se tardo en completarla y automaticamente asignar ese tiempo en BackLog de Trello.

También contiene una sección de reportes que permite ver el historial completo de las modificaciones realizadas sobre las tareas establecidas.
- WakaTime [![WakaTime]()](https://wakatime.com/login)

Es un plugin que se integra con el proyecto de GitHub y permite establecer metricas tales como el tiempo en que se estuvo desarrollando en el IDE de NetBeans, el porcentaje de lenguajes de programación utiilizados.

- Nota:  Para poder utilizar la herramienta es necesario que se dirija a la pagina de WakaTime, e ingrese con la cuenta de GitHub y em la sección "Supported IDEs" selecciona el IDE de preferencia para nuestro caso sera Netbeans

## Ejecución del proyecto
Una vez clonado el projecto de GitHub se procede a abrirlo con el IDE de NetBeans

- Nota: Debe verificar que NetBeans tenga instalado Maven para poder descargar las dependencias.

Luego se procede a darle click izquierdo sobre el proyecto y escoger la opción Build, con esto se procedera a que Maven descargue las dependencias necesarias para la ejecución del programa.

Una vez terminado el proceso anterior se procede a ejecutar el proyecto ya sea con la tecla f6 o directamente de la herramienta play ubicada en la ventana visual del IDE de NetBeans.
Posteriormente se debera ingresar la ruta absoluta del archivo a leer.

- Nota: Se debe asegurar que la extensión del archivo sea ".txt".

Al finalizar el programa mostrara la ruta donde esta guardado el resultado de la ejecución del programa.
<div align="center">
    <img src="" >
</div>
