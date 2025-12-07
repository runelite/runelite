# RuneLite XR

## Project Purpose

To create an immersive Extended Reality (XR) interface for Old School RuneScape by extending the open-source **RuneLite** client.

The goal is to evolve the standard desktop experience into a hybrid "Tabletop VR" environment. Users will retain full access to the traditional 2D RuneLite interface while simultaneously viewing the game world rendered as a 3D board in virtual reality. Users will interact with this project just as they usually do with a keyboard and mouse. It is critical to maintain standard input methods to avoid false flagging from RuneScape anti cheat measures. 

## Tech Stack & Architecture

### Languages & Frameworks

* **Java:** Core application logic (extending existing RuneLite codebase).
* **LWJGL (Lightweight Java Game Library):** Provides the bindings for low-level access to OpenXR and OpenGL.
* **OpenXR:** The industry-standard standard used to interface with VR hardware (Headsets/Controllers).
* **OpenGL** For rendering the 3D scene and skybox directly to the HMD.

### Architecture Overview

1.  **The Client:** The application hooks into the existing RuneLite client to extract scene data (Tile IDs, Object IDs, Player Coordinates).
2.  **The XR Loop:** A dedicated rendering loop (likely decoupled from the AWT/Swing UI thread) manages the connection to the OpenXR runtime to ensure high frame rates.
3.  **The Bridge:**
    * **2D Pass:** The standard RuneLite UI is rendered to a Texture and applied to a floating Quad in VR space.
    * **3D Pass:** Scene data is intercepted and interpreted to render 3D meshes (tiles/objects) in the VR space relative to the user's headset.

## Development Milestones

### Phase 1: Foundation

* [ ] [**Initialize OpenXR Runtime:**](milestones/init-openxr-runtime.md) Successfully launch the VR runtime directly from the RuneLite client startup process using LWJGL.
* [ ] [**Basic Environment:**](milestones/basic-environment.md) Render a skybox texture to the XR HMD to verify the rendering pipeline.

### Phase 2: The Hybrid View

* [ ] [**2D Window Injection:**](milestones/runelite-2d-window.md) Render the live RuneLite game window to a floating 3D plane (Quad) within the XR space.
* [ ] [**Scene Debugging:**](milestones/scene-layout.md) Iterate through RuneLite's `Scene` data and render debug geometry (Debug wireframe quads with text IDs) at valid `TileID` coordinates in the 3D world.

### Phase 3: Interaction

* [ ] [**Camera Controls:**](milestones/camera-controls.md) Implement navigation to allow rotation around the vertical axis and zooming (scaling) of the game board. This will use the inputs from the 2D game window and translate them to 3D space. 