from PIL import Image

def detect_final(image_path):
    img = Image.open(image_path).convert("RGBA")
    width, height = img.size
    
    # Nomes dos botões na ordem
    names = [
        "Seta Grande Esquerda", "Seta Grande Direita",
        "Seta Pequena Esquerda", "Seta Pequena Direita",
        "Seta Pequena Cima", "Seta Pequena Baixo",
        "Seta Dupla Esquerda", "Seta Dupla Direita",
        "Seta Barra Esquerda", "Seta Barra Direita",
        "X Grande", "Losango Grande",
        "X Pequeno", "Círculo Pequeno",
        "Pause Pequeno 1", "Pause Pequeno 2",
        "Pause Grande 1", "Pause Grande 2"
    ]
    
    results = []
    
    # Linha Normal (Amarela) - Y=54 aprox
    # Linha Pressionada (Azul) - Y=88 aprox
    y_lines = [54, 88]
    
    for row_idx, y_base in enumerate(y_lines):
        for i, name in enumerate(names):
            x_base = i * 20
            
            # Encontrar o conteúdo real dentro deste bloco 20x20
            min_x, max_x = x_base + 20, x_base
            min_y, max_y = y_base + 20, y_base - 20
            has_content = False
            
            # Procurar em uma área maior para garantir que pegamos o ícone todo
            for tx in range(x_base, x_base + 20):
                for ty in range(y_base - 15, y_base + 15):
                    if tx >= width or ty >= height: continue
                    r, g, b, a = img.getpixel((tx, ty))
                    # Considerar qualquer pixel com cor ou opacidade como parte do botão
                    if (r > 10 or g > 10 or b > 10) and a > 0:
                        min_x = min(min_x, tx)
                        max_x = max(max_x, tx)
                        min_y = min(min_y, ty)
                        max_y = max(max_y, ty)
                        has_content = True
            
            if has_content:
                # Ajustar para incluir bordas pretas (1px)
                results.append({
                    "nome": name,
                    "tipo": "Normal" if row_idx == 0 else "Pressionado",
                    "x": max(0, min_x - 1),
                    "y": max(0, min_y - 1),
                    "w": (max_x - min_x + 1) + 2,
                    "h": (max_y - min_y + 1) + 2
                })
            
    return results

if __name__ == "__main__":
    btns = detect_final("/home/ubuntu/upload/icons_btn.png")
    print("| Nome | Tipo | X | Y | Largura | Altura |")
    print("| :--- | :--- | :- | :- | :--- | :--- |")
    for b in btns:
        print(f"| {b['nome']} | {b['tipo']} | {b['x']} | {b['y']} | {b['w']} | {b['h']} |")
