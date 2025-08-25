# Parking Management

Aplicación de ejemplo que utiliza **Spring Framework** configurado mediante
`applicationContext.xml` para manejar los beans del dominio.

## Compilación

```bash
mvn clean package
```

## Ejecución

Para ejecutar la clase de demostración:

```bash
java -cp target/parking_management/WEB-INF/classes:\
"$(find target/parking_management/WEB-INF/lib -name '*.jar' -printf '%p:')" \
com.example.DebugApp
```

El comando anterior construye la ruta de clases necesaria para ejecutar la
aplicación desde la línea de comandos. Alternativamente, el archivo WAR
generado puede desplegarse en cualquier contenedor de servlets compatible con
Jakarta EE.

