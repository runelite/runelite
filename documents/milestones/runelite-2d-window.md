Here is the detailed breakdown for the third milestone: **2D Window Injection**.

This milestone focuses on bridging the gap between the existing Java AWT drawing surface (RuneLite) and your new high-performance OpenGL VR renderer. The goal is to take the 2D image the player normally sees and project it onto a "virtual monitor" floating in the VR world.

### **Phase 1: Accessing the Frame Data**

RuneLite renders its game output to an internal buffer before it hits your computer screen. You need to intercept this data.

1.  **Identify the Source:** Access the `Client` instance within the RuneLite codebase. Look for the `BufferProvider` or the `drawCallbacks`. This interface holds the raw integer array (`int[]`) representing the pixels of the current game frame.
2.  **Synchronization Strategy:** The game updates this pixel array on the "Game Thread" (Client Loop), while your VR renderer runs on the "VR Thread." You must implement a thread-safe way to read this array.
    * *Option A (Snapshot):* Create a copy of the pixel array at the end of every game tick.
    * *Option B (Locking):* Briefly lock the buffer during the VR render pass to copy it.
3.  **Data formatting:** The pixel array is typically formatted as ARGB (Int). OpenGL typically expects RGBA (Byte) or BGRA. You may need a lightweight conversion step or simply tell OpenGL to interpret the incoming data as `GL_BGRA`.

### **Phase 2: The Texture Bridge (CPU to GPU)**

Now that you have the raw pixels, you need to turn them into an OpenGL Texture that your VR engine can use.

1.  **Generate Texture Handle:** On your VR Render Thread, generate a standard OpenGL texture (`glGenTextures`).
2.  **Allocate Storage:** Initialize the texture storage matching the resolution of the RuneLite client (e.g., 800x600 or whatever the user has resized it to).
3.  **The Upload Loop:** Inside your VR render loop (created in the previous milestone), add a "Texture Update" step at the start of every frame:
    * Check if the RuneLite client has produced a new frame.
    * Bind the Texture.
    * Use `glTexSubImage2D` to upload the raw integer array from Phase 1 directly into the texture.
    * *Optimization Note:* Using `glTexSubImage2D` is faster than recreating the texture every frame.

### **Phase 3: The Virtual Screen (Geometry)**

You need a physical object in the 3D world to hold this texture.

1.  **Define a Quad:** Create a simple 3D mesh consisting of 4 vertices (a rectangle).
    * **Vertices:** Define the corners relative to a center point (e.g., -0.5 to +0.5).
    * **UV Coordinates:** Map the texture coordinates so the top-left of the image matches the top-left of the quad (0,0 to 1,1).
2.  **Create Buffers:** Upload this geometry to the GPU using a Vertex Buffer Object (VBO) and Vertex Array Object (VAO). This only needs to happen once during initialization, not every frame.
3.  **Aspect Ratio Management:** To prevent the game looking "squashed," you must scale the Quad's vertices to match the aspect ratio of the RuneLite window. If the window is 800x600 (4:3), your quad should be 4 units wide and 3 units tall (scaled down effectively).

### **Phase 4: World Placement (Matrices)**

You need to define *where* this window floats.

1.  **The Model Matrix:** Create a transformation matrix for the Quad.
    * **Translation:** Move it away from the origin (0,0,0). A good starting point is roughly 1.5 meters forward (Z = -1.5) and slightly up (Y = 1.0) so it sits at eye level.
    * **Rotation:** Ensure it is facing the camera.
    * **Scaling:** Apply a global scale to make it a comfortable size (e.g., the width of a movie theater screen or a desktop monitor).
2.  **Dynamic Updates (Optional):** If you want the window to "follow" the player, you will update this Model Matrix every frame based on the headset's position. For this milestone, a fixed position in space is sufficient.

### **Phase 5: The Render Pass**

Finally, draw the quad into the VR scene.

1.  **Shader Setup:** Write a basic "Unlit Texture" shader.
    * **Vertex Shader:** Multiplies the vertex position by the Model, View, and Projection matrices.
    * **Fragment Shader:** Samples the texture color and outputs it directly.
2.  **The Draw Call:** Inside your main `xrBeginFrame` / `xrEndFrame` loop (after you draw the Skybox):
    * Bind the Shader.
    * Bind the "RuneLite Texture" (from Phase 2).
    * Pass the "Model Matrix" (Phase 4) and the current VR "View/Projection Matrices" to the shader.
    * Draw the Quad VAO.

### **Phase 6: Validation**

1.  **Launch:** Start the client.
2.  **Visual Check:** Put on the headset. You should see the Skybox (from the previous milestone) and now, floating in the void, a giant flat panel displaying the RuneLite login screen or game view.
3.  **Live Test:** Interact with the game on your desktop (click buttons, rotate camera). The floating window in VR should update in real-time, mirroring your actions.