param(
    [string] $OriginalJarUrl = "https://repo.runelite.net/net/runelite/injected-client/1.11.11/injected-client-1.11.11.jar",
    [string] $OriginalJarPath = "$PSScriptRoot\..\stevescape-libs\injected-client-1.11.11-original.jar",
    [string] $OutputJarPath = "$PSScriptRoot\..\stevescape-libs\injected-client-1.11.11-stevescape.jar",
    [string] $Modulus = ""
)

$ErrorActionPreference = "Stop"

$oldModulus = "ae61e0df7f65fd97a15baecac264daec7a47f83b616b4e579aae49391d857ccb73cbc45e5b8fd2b02f9134af7098eabbf3096999d0c2facbad8f5b087bbad6820bf6b54e6a8d070de5ccf10a1548afe95d995258045c1b1fb400f9cc36ed62e0ab01175270885ef38081f33d9a6ce565cce9641100b02b0d8548955eeac2ef29"

if ([string]::IsNullOrWhiteSpace($Modulus)) {
    $modulusFile = Join-Path $PSScriptRoot "..\..\steversps\modulus"
    $modulusText = [System.IO.File]::ReadAllText($modulusFile)
    $match = [regex]::Match($modulusText, "modulus:\s*([0-9a-fA-F]+)")
    if (-not $match.Success) {
        throw "Unable to read modulus from $modulusFile"
    }
    $Modulus = $match.Groups[1].Value.ToLowerInvariant()
}

if ($Modulus.Length -ne $oldModulus.Length) {
    throw "Replacement modulus length $($Modulus.Length) does not match original length $($oldModulus.Length)"
}

$originalJar = [System.IO.Path]::GetFullPath($OriginalJarPath)
$outputJar = [System.IO.Path]::GetFullPath($OutputJarPath)
$outputDir = [System.IO.Path]::GetDirectoryName($outputJar)
[System.IO.Directory]::CreateDirectory($outputDir) | Out-Null

if (-not [System.IO.File]::Exists($originalJar)) {
    Invoke-WebRequest -Uri $OriginalJarUrl -OutFile $originalJar -UseBasicParsing
}

if ([System.IO.File]::Exists($outputJar)) {
    [System.IO.File]::Delete($outputJar)
}

Add-Type -AssemblyName System.IO.Compression
Add-Type -AssemblyName System.IO.Compression.FileSystem

$encoding = [System.Text.Encoding]::GetEncoding("iso-8859-1")
$rsaPatchCount = 0
$varpPatchCount = 0

function Replace-Ascii([byte[]] $bytes, [string] $from, [string] $to) {
    $text = $encoding.GetString($bytes)
    $count = ([regex]::Matches($text, [regex]::Escape($from))).Count
    if ($count -ne 1) {
        throw "Expected one RSA modulus occurrence in bp.class, found $count"
    }
    return $encoding.GetBytes($text.Replace($from, $to))
}

function Patch-VarpArrays([byte[]] $bytes) {
    $patched = 0
    for ($i = 0; $i -lt $bytes.Length - 4; $i++) {
        if ($bytes[$i] -eq 0x11 -and $bytes[$i + 1] -eq 0x13 -and $bytes[$i + 2] -eq 0x88 -and $bytes[$i + 3] -eq 0xBC -and $bytes[$i + 4] -eq 0x0A) {
            # sipush 5000; newarray int -> sipush 15000; newarray int
            $bytes[$i + 1] = 0x3A
            $bytes[$i + 2] = 0x98
            $patched++
        }
    }
    return $patched
}

$source = [System.IO.Compression.ZipFile]::OpenRead($originalJar)
$target = [System.IO.Compression.ZipFile]::Open($outputJar, [System.IO.Compression.ZipArchiveMode]::Create)
try {
    foreach ($entry in $source.Entries) {
        $input = $entry.Open()
        $memory = New-Object System.IO.MemoryStream
        try {
            $input.CopyTo($memory)
        } finally {
            $input.Dispose()
        }

        [byte[]] $bytes = $memory.ToArray()

        if ($entry.FullName -eq "bp.class") {
            $bytes = Replace-Ascii $bytes $oldModulus $Modulus
            $rsaPatchCount++
        }

        if ($entry.FullName -eq "nd.class" -or $entry.FullName -eq "tj.class") {
            $varpPatchCount += Patch-VarpArrays $bytes
        }

        $newEntry = $target.CreateEntry($entry.FullName, [System.IO.Compression.CompressionLevel]::Optimal)
        $output = $newEntry.Open()
        try {
            $output.Write($bytes, 0, $bytes.Length)
        } finally {
            $output.Dispose()
        }
    }
} finally {
    $target.Dispose()
    $source.Dispose()
}

if ($rsaPatchCount -ne 1) {
    throw "Expected to patch RSA in one class, patched $rsaPatchCount"
}

if ($varpPatchCount -ne 3) {
    throw "Expected to patch 3 varp array allocations, patched $varpPatchCount"
}

"Patched injected client: $outputJar"
