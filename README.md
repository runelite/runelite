Here is the updated `README.md` incorporating the **RuneLite XR** context while keeping it concise.

-----

# RuneLite XR [](https://github.com/runelite/runelite/actions?query=workflow%3ACI+branch%3Amaster) [](https://discord.gg/ArdAhnN)

RuneLite is a free, open source OldSchool RuneScape client. **RuneLite XR** extends this foundation to create a hybrid "Tabletop VR" experience, allowing users to play OSRS in a 3D mixed-reality environment.

## RuneLite XR Features

* **Hybrid Interface:** Renders the standard 2D client alongside a "table top" 3D  representation of the game world.
* **Desktop Mirror:** Includes a dedicated debug window to view/record the headset perspective.
* **Powered by:** Java, LWJGL, and OpenXR.

## Project Layout

- [cache](https://www.google.com/search?q=cache/src/main/java/net/runelite/cache) - Libraries for reading/writing cache files.
- [runelite-api](https://www.google.com/search?q=runelite-api/src/main/java/net/runelite/api) - RuneLite API interfaces.
- [runelite-client](https://www.google.com/search?q=runelite-client/src/main/java/net/runelite/client) - Game client, plugins, and **XR rendering logic** (`net.runelite.client.xr`).

## Usage

1.  **Prerequisites:** Ensure **SteamVR** (or a compatible OpenXR runtime) is installed and set as default.
2.  **Build & Run:** Open as a Maven project, build the root module, and run the `RuneLite` class in `runelite-client`.
3.  **Launch VR:** Once the client loads, open the **XR Panel** on the sidebar and click **Initialize VR**.