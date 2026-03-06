#!/bin/bash
OUTPUT="projeto_completo.txt"
echo "--- BACKUP DO PROJETO DBI ---" > $OUTPUT
echo "Gerado em: $(date)" >> $OUTPUT

# 1. Lista apenas os nomes das imagens PNG
echo -e "\n=== LISTA DE TEXTURAS (PNG) ===" >> $OUTPUT
find src -type f -name "*.png" >> $OUTPUT

# 2. Pega o conteúdo completo de arquivos de texto (Java e JSON)
echo -e "\n=== CONTEÚDO DOS ARQUIVOS (JAVA/JSON) ===" >> $OUTPUT
find src -type f \( -name "*.java" -o -name "*.json" \) -exec echo -e "\n--- ARQUIVO: {} ---\n" \; -exec cat {} \; >> $OUTPUT

echo "Pronto! O arquivo $OUTPUT foi gerado."
