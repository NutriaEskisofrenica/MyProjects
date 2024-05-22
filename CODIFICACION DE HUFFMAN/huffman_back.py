import tkinter as tk
from tkinter import ttk
import tkinter.filedialog as filedialog

def ventanaPrincipal():
    global ventana
    ventana = tk.Tk()
    frm = ttk.Frame(ventana, padding=10)
    frm.grid()
    ventana.title("Actividad 07")
    ventana.geometry("600x600")

    boton_examinar = ttk.Button(ventana, text="Examinar", command=examinar)
    boton_examinar.grid(column=1, row=0)
    boton_comprimir = ttk.Button(ventana, text="Comprimir", command=comprimir)
    boton_comprimir.grid(column=1, row=1)
    boton_descomprimir = ttk.Button(ventana, text="Descomprimir", command=descomprimir)
    boton_descomprimir.grid(column=1, row=2)
    
    ventana.mainloop()

archivo = None
archivoComprimido = open("archivoComprimido.bin", mode="wb") 

def examinar():
    global archivo
    archivo_path = filedialog.askopenfilename(filetypes=[("Text files", "*.txt")])
    if archivo_path:
        archivo = open(archivo_path, mode="r", encoding="UTF-8")
        print(f"Archivo seleccionado: {archivo_path}")

def calcularFrecuencia():
    frecuenciaLetras = {}
    if archivo:
        for palabras in archivo:
            for letras in palabras:
                letras = letras.lower()
                if letras in frecuenciaLetras:
                    frecuenciaLetras[letras] += 1
                else:
                    frecuenciaLetras[letras] = 1
    return frecuenciaLetras

class Node:
    def __init__(self, letra=None, freq=0, left=None, right=None):
        self.letra = letra
        self.freq = freq
        self.left = left
        self.right = right

def creacionArbol():
    ListaNodos = []
    valorTotal = 0
    class vertice:
        def __init__(self, letra, frecuencia):
            self.letra = letra
            self.frecuencia = frecuencia
            self.left = None
            self.right = None
    for letra, valor in calcularFrecuencia().items():
        valorTotal += valor
        vertices = vertice(letra, valor)
        ListaNodos.append(vertices)

    while len(ListaNodos) > 1:
        ListaNodos = sorted(ListaNodos, key=lambda x: x.frecuencia)
        nodoUnion = vertice(None, ListaNodos[0].frecuencia + ListaNodos[1].frecuencia)
        nodoUnion.left = ListaNodos[0]
        nodoUnion.right = ListaNodos[1]
        ListaNodos.append(nodoUnion)
        ListaNodos.pop(0)
        ListaNodos.pop(0)
    
    return ListaNodos

tabla = {}

def tablaValores(arbol, codigo, tablaA):
    if arbol.letra is not None:
        tablaA[arbol.letra] = codigo
    if arbol.left is not None:
        tablaValores(arbol.left, codigo + "0", tablaA)
    if arbol.right is not None:
        tablaValores(arbol.right, codigo + "1", tablaA)
        
def comprimir():
    if archivo:
        archivo.seek(0)  # Asegurarse de que el archivo se lea desde el principio
        arbolH = creacionArbol()[0]
        tablaValores(arbolH, "", tabla)
        listValores = []
        for palabras in archivo:
            for letras in palabras:
                letras = letras.lower()
                listValores.append(tabla[letras])
        archivoComprimido.write(bytearray(listValores))
        archivo.close()
        archivoComprimido.close()

def descomprimir():
    archivoComprimido = open("archivoComprimido.bin", mode="rb")
    archivoDescomprimido = open("archivoDescomprimido.txt", mode="w", encoding="UTF-8")
    lista = list(archivoComprimido.read())
    for valor in lista:
        for claves, valores in tabla.items():
            if valor == valores:
                archivoDescomprimido.write(claves)
    archivoComprimido.close()
    archivoDescomprimido.close()

ventanaPrincipal()
