#!/bin/bash
# Informe rápido del estado del sistema (Linux / Git Bash).
# Uso: ./informe-sistema.sh [umbral_disco]   (por defecto avisa si un disco supera el 80%)

UMBRAL=${1:-80}

echo "===== INFORME DEL SISTEMA ====="
echo "Fecha:   $(date '+%d/%m/%Y %H:%M:%S')"
echo "Equipo:  $(hostname)"
echo "Usuario: $(whoami)"
echo "Kernel:  $(uname -sr)"
echo

echo "--- Uso de disco ---"
df -h | awk 'NR==1 {print; next} {print}' | head -n 10
echo

echo "--- Alertas de disco (más del ${UMBRAL}%) ---"
alertas=0
while read -r uso punto; do
    numero=${uso%\%}
    if [[ "$numero" =~ ^[0-9]+$ ]] && [ "$numero" -gt "$UMBRAL" ]; then
        echo "ATENCIÓN: $punto está al $uso"
        alertas=$((alertas + 1))
    fi
done < <(df -h --output=pcent,target 2>/dev/null | tail -n +2)
[ "$alertas" -eq 0 ] && echo "Ningún disco supera el umbral"
echo

echo "--- 5 procesos que más memoria usan ---"
ps aux --sort=-%mem 2>/dev/null | head -n 6 || echo "ps no disponible en este entorno"
