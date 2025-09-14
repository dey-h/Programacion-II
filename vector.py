import math

class Vector:
    def __init__(self, *args):
     
        if len(args) == 0:  
            self.x, self.y, self.z = 0, 0, 0
        elif len(args) == 1 and isinstance(args[0], Vector):  
            self.x, self.y, self.z = args[0].x, args[0].y, args[0].z
        elif len(args) == 3:  
            self.x, self.y, self.z = args

    def __add__(self, other):   
        return Vector(self.x + other.x, self.y + other.y, self.z + other.z)

    def __sub__(self, other):   
        return Vector(self.x - other.x, self.y - other.y, self.z - other.z)

    def __mul__(self, other):
        if isinstance(other, (int, float)):  
            return Vector(self.x * other, self.y * other, self.z * other)
        elif isinstance(other, Vector):    
            return self.producto_escalar(other)
        else:
            raise TypeError("no soportado en *")

    def __matmul__(self, other):
        return self.producto_vectorial(other)

    def producto_escalar(self, other):
        return self.x * other.x + self.y * other.y + self.z * other.z

    def producto_vectorial(self, other):
        return Vector(
            self.y * other.z - self.z * other.y,
            self.z * other.x - self.x * other.z,
            self.x * other.y - self.y * other.x
        )

    def longitud(self):
        return math.sqrt(self.x**2 + self.y**2 + self.z**2)

    def normalizar(self):
        l = self.longitud()
        if l == 0:
            return Vector(0, 0, 0)
        return Vector(self.x/l, self.y/l, self.z/l)

    def __eq__(self, other):   
        return self.x == other.x and self.y == other.y and self.z == other.z

    def __str__(self):
        return f"({self.x}, {self.y}, {self.z})"


class AlgebraVectorial:

    @staticmethod
    def es_perpendicular(a: Vector, b: Vector) -> bool:
        return a * b == 0  

    @staticmethod
    def es_paralelo(a: Vector, b: Vector) -> bool:
        return (a @ b) == Vector(0, 0, 0)   

    @staticmethod
    def proyeccion_sobre(a: Vector, b: Vector) -> Vector:
        escalar = (a * b) / (b.longitud()**2)
        return b * escalar

    @staticmethod
    def componente_en(a: Vector, b: Vector) -> float:
        return (a * b) / b.longitud()
    
a = Vector(1, 2, 3)
b = Vector(4, 5, 6)

print("a =", a)
print("b =", b)

print("\nProducto escalar:", a * b)
print("Producto vectorial:", a @ b)
print("Longitud de a:", a.longitud())
print("Vector normalizado de a:", a.normalizar())

print("\n¿Son perpendiculares?", AlgebraVectorial.es_perpendicular(a, b))
print("¿Son paralelos?", AlgebraVectorial.es_paralelo(a, b))
print("Proyección de a sobre b:", AlgebraVectorial.proyeccion_sobre(a, b))
print("Componente de a en b:", AlgebraVectorial.componente_en(a, b))

