Control + Shift + V

No, no debería generar problemas crear y trabajar en las ramas en el orden que mencionaste. Sin embargo, es importante seguir el flujo de trabajo de **Git Flow** para asegurar una gestión adecuada de las ramas y evitar conflictos innecesarios. Aquí te explico cómo debería ser el proceso:

### ✅ **Flujo típico de Git Flow**  

1. **Inicializar Git Flow** (si no lo has hecho antes):  
   Ejecuta solo una vez en el repositorio. Esto configura el flujo de trabajo básico.
   ```sh
   git flow init
   ```
   Esto creará las ramas `main` y `develop` y configurará el flujo de trabajo.

2. **Crear y trabajar en una rama `feature`** (basada en `develop`):  
   Al iniciar una nueva funcionalidad, lo harás desde `develop`, que es donde se integran las nuevas características.
   ```sh
   git flow feature start basic-entities
   ```

   Esto creará la rama `feature/basic-entities` desde `develop` y te permitirá trabajar en ella.

3. **Finalizar la `feature`** y fusionarla con `develop`:
   Una vez termines de trabajar en la funcionalidad, fusionas la rama de la `feature` de vuelta en `develop`:
   ```sh
   git flow feature finish basic-entities
   ```

4. **Subir cambios a GitHub**:
   Después de finalizar la funcionalidad, debes subir los cambios a GitHub:
   ```sh
   git push origin develop
   ```

5. **Cuando sea el momento de hacer un lanzamiento (release)**:  
   Una vez que el código en `develop` está listo para ser lanzado, puedes crear una rama `release`:
   ```sh
   git flow release start 1.0.0
   ```

6. **Finalizar el release**:
   Cuando el `release` esté listo, lo fusionas tanto en `develop` como en `main`:
   ```sh
   git flow release finish 1.0.0
   ```

---

### 📌 **Resumen de ramas**  
- **`main` (o `master`)**: Esta es la rama de producción. Los lanzamientos finales siempre se realizan desde aquí.  
- **`develop`**: Aquí se integran todas las nuevas funcionalidades antes de ser lanzadas.  
- **`feature/*`**: Cada nueva funcionalidad se desarrolla en una rama `feature` desde `develop`.  
- **`release/*`**: Cuando todo está listo para ser lanzado, se crea una rama `release` desde `develop`.  
- **`hotfix/*`**: Si se necesita corregir algo urgente en producción, se hace desde `main`.

### 🔄 **Secuencia correcta**:
- **`main`** -> **`develop`** -> **`feature`** -> **`release`** -> **`main`**  
- Siempre desde `develop` cuando trabajes en nuevas características.

### 📝 **Conclusión**  
No hay problema si las ramas ya existen, siempre y cuando sigas este flujo. Lo importante es que `feature/*` se derive de `develop`, y `develop` se mantenga sincronizado con `main` para evitar conflictos. 

¡Ahora puedes trabajar con seguridad y organizar tu desarrollo! 🚀