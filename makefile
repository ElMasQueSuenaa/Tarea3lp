# Directorios de fuente y binario
SRC_DIR := .
BIN_DIR := bin

# Comandos de compilación y ejecución
JAVAC := javac
JAVA := java

# Clase principal
MAIN_CLASS := NoJavaSky

# Encontrar todos los archivos .java en los paquetes correspondientes
PLANETAS_CLASSES := $(wildcard $(SRC_DIR)/Planetas/*.java)
INTERACTUABLE_CLASSES := $(wildcard $(SRC_DIR)/Interactuable/*.java)
INTERFAZ_CLASSES := $(wildcard $(SRC_DIR)/Interfaz/*.java)

# Directorios de salida para los archivos compilados
PLANETAS_BIN := $(BIN_DIR)/Planetas
INTERACTUABLE_BIN := $(BIN_DIR)/Interactuable
INTERFAZ_BIN := $(BIN_DIR)/Interfaz

# Objetivo por defecto: compilar y ejecutar el proyecto
all: $(MAIN_CLASS)

# Compilar la clase principal
$(MAIN_CLASS): $(MAIN_CLASS).class
$(MAIN_CLASS).class: $(SRC_DIR)/$(MAIN_CLASS).java $(PLANETAS_CLASSES) $(INTERACTUABLE_CLASSES) $(INTERFAZ_CLASSES)
	@mkdir -p $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) $^

# Compilar las clases en Planetas
$(PLANETAS_BIN)/%.class: $(SRC_DIR)/Planetas/%.java
	@mkdir -p $(PLANETAS_BIN)
	$(JAVAC) -d $(PLANETAS_BIN) $<

# Compilar las clases en Interactuable
$(INTERACTUABLE_BIN)/%.class: $(SRC_DIR)/Interactuable/%.java
	@mkdir -p $(INTERACTUABLE_BIN)
	$(JAVAC) -d $(INTERACTUABLE_BIN) $<

# Compilar las clases en Interfaz
$(INTERFAZ_BIN)/%.class: $(SRC_DIR)/Interfaz/%.java
	@mkdir -p $(INTERFAZ_BIN)
	$(JAVAC) -d $(INTERFAZ_BIN) $<

# Ejecutar el programa
run: all
	$(JAVA) -cp $(BIN_DIR) $(MAIN_CLASS)

# Limpiar los archivos compilados
clean:
	rm -rf $(BIN_DIR)/*
