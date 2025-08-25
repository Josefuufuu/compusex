# Parking Management

Aplicación de ejemplo que utiliza **Spring Framework**. Puede configurarse
mediante el tradicional archivo `applicationContext.xml` o usando clases
anotadas con `@Configuration` y `@ComponentScan`.

## Compilación

```bash
mvn clean package
```

## Ejecución

### Versión anotada

`DebugApp` carga el contexto con `AnnotationConfigApplicationContext` y la
clase `AppConfig`.

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

Ambos comandos construyen la ruta de clases necesaria para ejecutar la
aplicación desde la línea de comandos. Alternativamente, el archivo WAR
generado puede desplegarse en cualquier contenedor de servlets compatible con
Jakarta EE.

