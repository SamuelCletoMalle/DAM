# Flujo de trabajo con Git

Resumen de cómo trabajo con Git en las prácticas del ciclo.

## Configuración inicial (una vez)
```bash
git config --global user.name "Tu Nombre"
git config --global user.email "tu@correo.com"
```

## Ciclo diario
```bash
git status                 # qué ha cambiado
git add .                  # preparar los cambios
git commit -m "Mensaje claro en presente"
git push origin main       # subir al repositorio remoto
git pull                   # traer los cambios de otros
```

## Trabajar con ramas
```bash
git checkout -b funcionalidad-login   # crear y entrar en la rama
# ...trabajar y hacer commits...
git checkout main
git merge funcionalidad-login         # integrar la rama
git branch -d funcionalidad-login     # borrarla
```

## Resolver un conflicto
1. `git merge rama` avisa de que hay conflicto en un fichero.
2. Se abre el fichero y se buscan las marcas `<<<<<<<`, `=======` y `>>>>>>>`.
3. Se deja el código final correcto y se borran las marcas.
4. `git add fichero` y `git commit` para cerrar la fusión.

## Buenos mensajes de commit
| Mal | Bien |
|---|---|
| `cambios` | `Añadir validación del DNI en el formulario` |
| `arreglo` | `Corregir división entre cero en Calculadora` |

## Qué no subir
Se añade al `.gitignore`: carpetas `.idea/`, `out/`, ficheros `*.class` y `*.iml`.
