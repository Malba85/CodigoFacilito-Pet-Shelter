**Ctrl + Shift + V**
**para visualizar el MarkDowm**

Git Flow es una estrategia de gestión de ramas en Git que organiza el desarrollo de software en un flujo estructurado. Se basa en varias ramas principales y de soporte para manejar el desarrollo, las características, los lanzamientos y los arreglos de errores.  

### **Ramas principales en Git Flow**  
1. **`main` (o `master`)**:  
   - Contiene el código en producción.  
   - Solo recibe cambios mediante merges desde `release` o `hotfix`.  

2. **`develop`**:  
   - Contiene el código en desarrollo.  
   - Se usa para integrar cambios antes de un lanzamiento.  

### **Ramas de soporte en Git Flow**  
1. **`feature`** (funcionalidades nuevas)  
   - Se crean a partir de `develop`.  
   - Se usan para desarrollar nuevas características.  
   - Al finalizar, se fusionan de vuelta en `develop`.  
   - Ejemplo: `feature/nueva-funcionalidad`.  

2. **`release`** (preparación para un lanzamiento)  
   - Se crean a partir de `develop` cuando se va a lanzar una versión.  
   - Se usa para pruebas y ajustes menores.  
   - Al finalizar, se fusiona en `main` y en `develop`.  
   - Ejemplo: `release/v1.0.0`.  

3. **`hotfix`** (correcciones urgentes en producción)  
   - Se crean a partir de `main` para corregir errores críticos en producción.  
   - Se fusionan en `main` y `develop` (o `release` si está activa).  
   - Ejemplo: `hotfix/fix-bug-crítico`.  

### **Comandos básicos con Git Flow**  
1. **Inicializar Git Flow en un repositorio:**  
   ```sh
   git flow init
   ```
   (Configura las ramas y convenciones de nombres)  

2. **Crear una nueva feature:**  
   ```sh
   git flow feature start nombre-feature
   ```
   (Crea una rama `feature/nombre-feature` desde `develop`)  

3. **Finalizar una feature:**  
   ```sh
   git flow feature finish nombre-feature
   ```
   (Fusiona la feature en `develop` y elimina la rama)  

4. **Crear una release:**  
   ```sh
   git flow release start v1.0.0
   ```
   (Crea una rama `release/v1.0.0` desde `develop`)  

5. **Finalizar una release:**  
   ```sh
   git flow release finish v1.0.0
   ```
   (Fusiona en `main` y `develop`, etiqueta la versión y elimina la rama)  

6. **Crear un hotfix:**  
   ```sh
   git flow hotfix start fix-critico
   ```
   (Crea una rama `hotfix/fix-critico` desde `main`)  

7. **Finalizar un hotfix:**  
   ```sh
   git flow hotfix finish fix-critico
   ```
   (Fusiona en `main` y `develop`, etiqueta la corrección y elimina la rama)  

🔹 **Git Flow es útil para proyectos con versiones bien definidas y múltiples desarrolladores**. Si necesitas un flujo más ligero, puedes usar **GitHub Flow** o **Trunk-Based Development**. 🚀