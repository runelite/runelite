Here is the detailed breakdown for the final milestone: **Camera Controls**.

**Crucial Concept:** In VR, you never move the "Camera" (the user's head) via software, as this causes instant motion sickness. Instead, to simulate movement, zooming, or rotation, you move, scale, and rotate the **World** (the Game Board) around the user.

### **Phase 1: The Input System (OpenXR Actions)**

OpenXR handles input differently than standard gamepads. You do not check "Button A," you check "Actions."

1.  **Define Actions:** In your initialization phase, create an **Action Set** containing:
    * **Left Grip:** Type `pose` (tracks the position/rotation of the left hand).
    * **Right Grip:** Type `pose` (tracks the position/rotation of the right hand).
    * **Grip Button:** Type `boolean` (detects if the user is squeezing the controller).
2.  **Interaction Profile:** Bind these actions to specific hardware paths (e.g., `/user/hand/left/input/squeeze/value` on Oculus Touch or Valve Index controllers).
3.  **Attach Action Set:** Associate this action set with your Session so the runtime knows to listen for these specific inputs.

### **Phase 2: The "World Root" Object**

You need a central data structure to represent the transformation of the game board.

1.  **State Variables:** Create a class or struct (e.g., `WorldTransform`) that holds:
    * **Scale:** Float (starts at 1.0).
    * **Rotation:** Float (Angle in degrees around the vertical Y-axis).
    * **Position:** Vector3 (Offset from the room center).
2.  **The Pivot Point:** All scaling and rotation must happen relative to a specific point (usually the center of the user's view or the point between their hands), not the origin (0,0,0).

### **Phase 3: Implementing the Math (The "Demeo" Mechanics)**

This is the logic that runs every frame to calculate the new `WorldTransform` state based on controller input.

#### **A. Zooming (Scaling)**
* **Trigger:** The user holds the Grip button on **both** controllers simultaneously.
* **Logic:**
    1.  Calculate the distance between the Left Hand and Right Hand in the *previous* frame.
    2.  Calculate the distance between them in the *current* frame.
    3.  **Ratio:** `NewDistance / OldDistance`.
    4.  **Apply:** Multiply the current `World Scale` by this ratio.
    5.  *Result:* Pulling hands apart makes the world bigger (zooms in). Pushing hands together makes it smaller (zooms out).

#### **B. Rotation (Vertical Axis)**
* **Trigger:** The user holds the Grip button on **both** controllers (simultaneous with zoom).
* **Logic:**
    1.  Calculate the angle of the line connecting the two hands relative to the horizontal plane (using `atan2`).
    2.  Compare the angle from the *current* frame to the *previous* frame.
    3.  **Delta:** `CurrentAngle - PreviousAngle`.
    4.  **Apply:** Add this delta to the `World Rotation`.
    5.  *Result:* "Steering" your hands like a bus driver rotates the board left or right.

### **Phase 4: Applying the Transform (The Render Loop)**

Now that you have the logic, you must apply it to the graphics.

1.  **Calculate the Model Matrix:**
    * In your render loop, before drawing the Scene Debug Tiles or the 2D Window, construct a **Model Matrix**.
    * **Order of Operations is critical:**
        1.  Translate to Pivot Point.
        2.  Rotate (Y-axis).
        3.  Scale.
        4.  Translate back (Inverse Pivot).
        5.  Translate to `World Position`.
2.  **Update Shaders:**
    * Pass this new Model Matrix to your Debug Tile Shader and your 2D Window Shader.
    * *Note:* Do **not** apply this matrix to the Skybox. The sky should remain static relative to the user's head, or it will feel like the entire universe is spinning.

### **Phase 5: Validation**

1.  **Launch:** Start the client and enter VR.
2.  **Scale Test:** Put your hands out, grab the air (squeeze grips), and pull your hands apart.
    * **Success:** The green debug tiles should expand, making the tiles look massive. The floating RuneLite window should also get larger and move further away (preserving relative scale).
3.  **Rotation Test:** Grab the air with both hands and rotate them like a steering wheel.
    * **Success:** The entire grid of tiles should rotate around the center of your view.
4.  **Stability Test:** Release the grips. The world should stay exactly where you left it. Move your head physically; the world should remain "world-locked" (stationary in space), not stuck to your face.

This concludes the architectural breakdown for your initial milestones. You now have a roadmap from "Empty Project" to "Interactive Tabletop RuneScape Client."