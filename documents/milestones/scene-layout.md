Here is the detailed breakdown for the fourth milestone: **Scene Debugging**.

This milestone represents the first time your application interprets the *logic* of RuneScape and represents it physically in VR, rather than just displaying a 2D image.

### **Phase 1: Accessing Scene Data**

You need to extract the spatial data from the game client. RuneScape divides the world into "Scenes" (chunks of the map loaded into memory).

1.  **Get the Scene Object:** In your RuneLite code (on the client thread), access `client.getScene()`.
2.  **Understanding the Grid:** The scene is typically a 104x104 grid of "Tiles." It has 3 vertical levels (Planes 0, 1, 2).
3.  **Data Extraction Loop:** You need to iterate through this 3D array: `Scene.getTiles()[plane][x][y]`.
4.  **Filter Valid Tiles:** Not every coordinate in the array contains a valid tile (some are null or outside the renderable area). Check if `tile != null`.
    * *Tip:* For this milestone, just target **Plane 0** (the ground floor) to keep things simple.

### **Phase 2: Coordinate Conversion (RS to VR)**

This is the most critical logic step: translating "RuneScape Units" into "Real World Meters."

1.  **Define a Scale:** Decide how big a RuneScape tile is in your VR room.
    * *Suggestion:* 1 Tile = 10cm (0.1 meters). This creates a "tabletop" miniature feel.
2.  **Mapping Axes:**
    * **RuneScape:** X is East/West. Y is North/South. Z (Plane) is Up/Down.
    * **OpenXR/OpenGL:** X is Left/Right. Y is Up/Down. Z is Forward/Back.
3.  **The Transformation Formula:**
    * `VR_X = (RS_X - Camera_Offset_X) * Scale`
    * `VR_Y = (RS_Plane * Height_Per_Plane) * Scale`
    * `VR_Z = (RS_Y - Camera_Offset_Y) * Scale`
    * *Note:* You likely need to negate one axis (often Z) because OpenGL uses a right-handed coordinate system where -Z is "forward."

### **Phase 3: Geometry Batching (Optimization)**

Drawing 10,000 individual cubes (104 * 104 tiles) with 10,000 separate draw calls will lag the VR headset. You must batch them.

1.  **Instance Buffer Strategy:**
    * Create a **single** cube mesh (VAO) roughly the size of 1 tile (0.1m).
    * Create a second buffer (Instance Buffer) that holds just the **Position (vec3)** for every valid tile found in Phase 1.
2.  **Snapshotting:** Since the scene changes as the player moves (loading lines), you cannot iterate the live scene graph during the render loop.
    * **Action:** At the start of the frame (or when the scene changes), copy the valid tile coordinates into a `FloatBuffer` or `List<Vector3f>` specifically for the VR thread to read.

### **Phase 4: The Debug Shader**

You need a shader capable of drawing these instances.

1.  **Vertex Shader:**
    * Input: `aPos` (Cube Vertex), `aInstancePos` (Tile World Position).
    * Logic: `gl_Position = Projection * View * Model * (vec4(aPos + aInstancePos, 1.0));`
    * *Explanation:* We add the instance position to the vertex position effectively "moving" the cube to the right tile location before projecting it.
2.  **Fragment Shader:**
    * Output: A solid color (e.g., Bright Green or Wireframe).
    * *Optional:* Pass the Tile ID as a color to make them look distinct (e.g., `Color = vec3(TileX / 104.0, 0, TileY / 104.0)`).

### **Phase 5: The Render Pass**

Integrate this into your main VR loop.

1.  **Update Buffer:** If the player has moved, update the Instance Buffer (GPU memory) with the new list of valid tile positions.
2.  **Draw Call:**
    * Bind the Cube VAO.
    * Bind the Debug Shader.
    * Call `glDrawArraysInstanced`. This single command draws thousands of cubes instantly.
3.  **Layering:** Ensure this draw call happens *after* the Skybox but *before* or *after* the 2D window depending on whether you want the window to clip through the world or float above it.

### **Phase 6: Validation**

1.  **Launch:** Start the client and log in.
2.  **VR Check:** Look down. You should see a "floor" made of thousands of small green cubes.
3.  **Movement Test:** Walk your character in the RuneLite desktop window.
    * **Success:** As your character moves past the loading line and new chunks load, the field of green cubes in VR should update to match the new terrain.
4.  **Alignment Test:** If you see "holes" in the cube grid, compare them to the game window. Those holes should match obstacles or water in the actual game world.