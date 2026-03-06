#!/bin/bash

MOD_ID="dragonblockinfinity"
ASSETS_PATH="/workspaces/DragonBlockInfinity2/src/main/resources/assets/dragonblockinfinity"

# Processam JSONs de blocos
echo "=== Processando JSONs de BLOCOS ==="

# dragon_block1_earth.json
sed -i '1s/^/{\n  "mod_id": "'$MOD_ID'",\n  "texture_path": "textures\/blocks\/block_dragon_block1_earth.png",\n  "texture_name": "block_dragon_block1_earth",\n  "data": /' "$ASSETS_PATH/models/block/dragon_block1_earth.json"
sed -i '$ s/}$/}\n}/' "$ASSETS_PATH/models/block/dragon_block1_earth.json"
echo "✓ dragon_block1_earth.json"

# dirty_stone_cobblestone.json
cat > "$ASSETS_PATH/models/block/dirty_stone_cobblestone.json" << 'EOFJSON'
{
"mod_id": "dragonblockinfinity",
"texture_path": "textures/blocks/block_dirty_stone_cobblestone.png",
"texture_name": "block_dirty_stone_cobblestone",
"format_version": "1.20.1",
"credit": "Made with Blockbench",
"parent": "block/block",
"textures": {
"1": "dragonblockinfinity:block_dirty_stone_cobblestone"
},
"elements": [
{
"from": [0, 0, 0],
"to": [16, 16, 16],
"faces": {
"north": {"uv": [4, 4, 8, 8], "texture": "#1", "cullface": "north", "tintindex": 0},
"east": {"uv": [0, 4, 4, 8], "texture": "#1", "cullface": "east", "tintindex": 0},
"south": {"uv": [12, 4, 16, 8], "texture": "#1", "cullface": "south", "tintindex": 0},
"west": {"uv": [8, 4, 12, 8], "texture": "#1", "cullface": "west", "tintindex": 0},
"up": {"uv": [8, 4, 4, 0], "texture": "#1", "cullface": "up", "tintindex": 0},
"down": {"uv": [12, 0, 8, 4], "texture": "#1", "cullface": "down", "tintindex": 0}
}
}
]
}
EOFJSON
echo "✓ dirty_stone_cobblestone.json"

# namek_dirty.json
python3 << 'EOFPYTHON'
import json
import re

# Lê o arquivo
with open("/workspaces/DragonBlockInfinity2/src/main/resources/assets/dragonblockinfinity/models/block/namek_dirty.json", "r") as f:
    content = f.read()

# Adiciona metadados no início
metadata = {
    "mod_id": "dragonblockinfinity",
    "texture_path": "textures/blocks/block_namek_dirty.png",
    "texture_name": "block_namek_dirty",
}

# Tenta fazer parse
try:
    data = json.loads(content)
    data["mod_id"] = metadata["mod_id"]
    data["texture_path"] = metadata["texture_path"]
    data["texture_name"] = metadata["texture_name"]
    
    with open("/workspaces/DragonBlockInfinity2/src/main/resources/assets/dragonblockinfinity/models/block/namek_dirty.json", "w") as f:
        json.dump(data, f, indent=2)
    print("✓ namek_dirty.json")
except:
    print("✗ Erro em namek_dirty.json")
EOFPYTHON

echo "=== Processando JSONs de ITENS ==="

# dino_meat.json
python3 << 'EOFPYTHON'
import json

with open("/workspaces/DragonBlockInfinity2/src/main/resources/assets/dragonblockinfinity/models/item/dino_meat.json", "r") as f:
    data = json.load(f)

data["mod_id"] = "dragonblockinfinity"
data["texture_path"] = "textures/item/comida/item_dino_meat.png"
data["texture_name"] = "item_dino_meat"

with open("/workspaces/DragonBlockInfinity2/src/main/resources/assets/dragonblockinfinity/models/item/dino_meat.json", "w") as f:
    json.dump(data, f, indent=2)
print("✓ dino_meat.json")
EOFPYTHON

echo ""
echo "✅ Processamento concluído!"
