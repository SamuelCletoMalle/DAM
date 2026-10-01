# Copia de seguridad comprimida de una carpeta, con fecha en el nombre.
# Mantiene solo las N copias más recientes.
# Uso: .\copia-seguridad.ps1 -Origen C:\Datos -Destino D:\Copias -Conservar 5
param(
    [Parameter(Mandatory = $true)][string]$Origen,
    [Parameter(Mandatory = $true)][string]$Destino,
    [int]$Conservar = 5
)

if (-not (Test-Path $Origen)) {
    Write-Error "La carpeta de origen no existe: $Origen"
    exit 1
}

if (-not (Test-Path $Destino)) {
    New-Item -ItemType Directory -Path $Destino | Out-Null
}

$nombre = (Split-Path $Origen -Leaf) + "_" + (Get-Date -Format "yyyyMMdd_HHmmss") + ".zip"
$ruta = Join-Path $Destino $nombre

Compress-Archive -Path (Join-Path $Origen "*") -DestinationPath $ruta
$tamano = [math]::Round((Get-Item $ruta).Length / 1KB, 1)
Write-Host "Copia creada: $ruta ($tamano KB)"

# Borrar las copias antiguas
$prefijo = (Split-Path $Origen -Leaf) + "_*.zip"
$copias = Get-ChildItem $Destino -Filter $prefijo | Sort-Object LastWriteTime -Descending
if ($copias.Count -gt $Conservar) {
    $copias | Select-Object -Skip $Conservar | ForEach-Object {
        Remove-Item $_.FullName
        Write-Host "Copia antigua eliminada: $($_.Name)"
    }
}
