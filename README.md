# Parking Management

Aplicación de ejemplo que utiliza **Spring Framework**. Puede configurarse
mediante el tradicional archivo `applicationContext.xml`, usando clases
anotadas con `@Configuration` y `@ComponentScan`, o declarando los beans
explícitamente en una clase de configuración.

## Compilación

```bash
mvn clean package
```

## Ejecución

### Versión anotada

`DebugApp` carga el contexto con `AnnotationConfigApplicationContext` y la
clase `AppConfig`, que utiliza `@ComponentScan` para detectar los beans
anotados con estereotipos como `@Service` o `@Repository`.

```bash
java -cp target/parking_management/WEB-INF/classes:\
"$(find target/parking_management/WEB-INF/lib -name '*.jar' -printf '%p:')" \
com.example.DebugApp
```

### Versión Java con `@Bean`

En esta variante, `AppConfig` declara cada bean de forma manual mediante
métodos `@Bean`. Las clases de servicios y repositorios no llevan anotaciones
de estereotipo y las dependencias se registran directamente en la clase de
configuración.

```bash
java -cp target/parking_management/WEB-INF/classes:\
"$(find target/parking_management/WEB-INF/lib -name '*.jar' -printf '%p:')" \
com.example.DebugApp
```

### Versión XML

`DebugAppXml` utiliza el archivo `applicationContext.xml` para definir los
beans manualmente.

```bash
java -cp target/parking_management/WEB-INF/classes:\
"$(find target/parking_management/WEB-INF/lib -name '*.jar' -printf '%p:')" \
com.example.DebugAppXml
```

Los comandos anteriores construyen la ruta de clases necesaria para ejecutar la
aplicación desde la línea de comandos. Alternativamente, el archivo WAR
generado puede desplegarse en cualquier contenedor de servlets compatible con
Jakarta EE.

