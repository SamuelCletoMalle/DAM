#!/bin/bash
# Alta masiva de usuarios a partir de un fichero CSV (usuario;nombre;grupo).
# Con --simular solo muestra lo que haría, sin tocar el sistema.
# Uso: sudo ./alta-usuarios.sh usuarios.csv [--simular]

FICHERO=$1
SIMULAR=0
[ "$2" = "--simular" ] && SIMULAR=1

if [ -z "$FICHERO" ] || [ ! -f "$FICHERO" ]; then
    echo "Uso: $0 fichero.csv [--simular]"
    exit 1
fi

ejecutar() {
    if [ "$SIMULAR" -eq 1 ]; then
        echo "[simulación] $*"
    else
        "$@"
    fi
}

creados=0
omitidos=0
while IFS=';' read -r usuario nombre grupo; do
    [ -z "$usuario" ] && continue

    if id "$usuario" &>/dev/null; then
        echo "Ya existe el usuario $usuario, se omite"
        omitidos=$((omitidos + 1))
        continue
    fi

    if ! getent group "$grupo" &>/dev/null; then
        ejecutar groupadd "$grupo"
    fi

    ejecutar useradd -m -c "$nombre" -g "$grupo" "$usuario"
    echo "Usuario creado: $usuario ($nombre) en el grupo $grupo"
    creados=$((creados + 1))
done < "$FICHERO"

echo "Resumen: $creados creados, $omitidos omitidos"
