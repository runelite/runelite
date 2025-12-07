### **Phase 1: Project Configuration**

Before writing any logic, you must ensure the build environment (Maven) can access the necessary OpenXR libraries.

1.  **Identify the Build File:** Locate the primary `pom.xml` file used for the `runelite-client` module.
2.  **Add OpenXR Dependencies:** You need to modify the dependency section to include the Lightweight Java Game Library (LWJGL) OpenXR modules.
    * **Core Module:** Add the main `lwjgl-openxr` library.
    * **Platform Natives:** Add the `natives-windows` classifier for `lwjgl-openxr`. This ensures the correct `.dll` files are downloaded and available at runtime.
    * **Version Matching:** Ensure the version number for these new dependencies matches the existing LWJGL version already used by RuneLite.

### **Phase 2: The OpenXR Manager Architecture**

You still need the core manager, but it will now be designed to be triggered by a button press rather than just client startup.

1.  **Create a Singleton Class:** Define `OpenXRManager` in `net.runelite.client.xr`.
2.  **Initialization Logic:** Implement the `initialize()` method that loads the OpenXR loader, defines the application info ("RuneLite XR"), and creates the instance.
    * **State Management:** Add a boolean flag (e.g., `isInitialized`) to prevent the user from clicking the "Start" button multiple times.
3.  **Shutdown Logic:** Since this is now a toggleable feature, add a `shutdown()` or `cleanup()` method to properly destroy the OpenXR instance if the user wants to turn VR off without closing RuneLite.

### **Phase 3: The XR Side Panel & Configuration**

This replaces the "Hooking into Startup" phase. You will build a standard RuneLite Plugin UI.

1.  **The Config Interface:** Create a new interface (e.g., `XRConfig`) that extends RuneLite's `Config` class.
    * **Define Setting:** Add a boolean item `startOnLaunch` defaulting to `false`. This allows users to restore the auto-start behavior if they wish.
2.  **The Plugin Class:** Create `XRPlugin` extending `Plugin`.
    * **Annotation:** Add the `@PluginDescriptor` annotation to register it as "RuneLite XR".
    * **Startup Check:** Inside the `startUp()` method, inject your `XRConfig`. Check if `startOnLaunch` is true. If yes, immediately call `openXRManager.initialize()`.
3.  **The UI Panel:** Create a class `XRPanel` extending `PluginPanel`.
    * **Layout:** Use a grid or box layout.
    * **Status Indicator:** Add a generic text label (e.g., "VR Status: Stopped").
    * **The Button:** Add a `JButton` labeled "Initialize VR".
    * **Action Listener:** Bind the button's click event to call `openXRManager.initialize()`. On success, change the button text to "Stop VR" (or disable it) and update the status label.
4.  **Toolbar Integration:** In your `XRPlugin` class, use the `ClientToolbar` to add a new navigation icon (e.g., a headset icon) that opens your `XRPanel` when clicked.

### **Phase 4: Validation Procedure**

1.  **Build & Run:** Compile and launch RuneLite.
2.  **UI Check:** Look at the side toolbar. You should see your new XR icon. Click it to open the panel.
3.  **Manual Start Test:**
    * Ensure SteamVR is closed.
    * Click the **"Initialize VR"** button in your new panel.
    * **Result:** SteamVR should launch, and your panel status text should update to "Running".
4.  **Auto-Start Test:**
    * Go to the Plugin Configuration (via the wrench icon on the plugin list) or your custom panel if you added the checkbox there.
    * Enable **"Start on Launch"**.
    * Restart RuneLite.
    * **Result:** SteamVR should launch automatically without you needing to open the panel.