
def saludo():
    print("programa para encontrar el area ")

def area_triangulo(base,altura):
    return base * altura / 2
var = input("ingrese la base  ")
var2= input("ingrese la altura ")
resultado = area_triangulo(float(var), float(var2))

saludo()
print("el area del triangulo es: " , resultado)

