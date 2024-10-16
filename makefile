# Variables
SRC_DIR := ./Tarea3lp
BIN_DIR := ./bin
MAIN_CLASS := NoJavaSky
JAVAC := javac
JAVA := java
JFLAGS := -d $(BIN_DIR)

# Encontrar todos los archivos .java
SOURCES := $(shell find $(SRC_DIR) -name "*.java")

# Objetivo por defecto
all: build run

# Compilar el código
build:
	@echo "Compilando el código..."
	$(JAVAC) $(JFLAGS) $(SOURCES)
	@echo "Compilación completa."

# Ejecutar el programa principal
run:
	@echo "Ejecutando el programa..."
	$(JAVA) -cp $(BIN_DIR) $(MAIN_CLASS)

# Limpiar los archivos compilados
clean:
	@echo "Limpiando archivos compilados..."
	rm -rf $(BIN_DIR)/*
	@echo "Limpieza completa."
