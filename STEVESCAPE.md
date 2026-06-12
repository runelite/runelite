# SteveScape RuneLite Fork

This fork is pinned to `runelite-parent-1.11.11`, which matches the OSRS revision 231 date window.

## Local Config

- `stevescape-config/jav_config.ws` is the default client config.
- `stevescape-config/worlds.properties` is converted at runtime into an OSRS world list served on a localhost-only ephemeral port.
- `param=17=stevescape:world_list` is replaced during startup with the local generated world-list URL.
- Client runtime state is isolated under `%USERPROFILE%\.stevescape` instead of `%USERPROFILE%\.runelite`.
- Each client run writes a separate timestamped log file under `%USERPROFILE%\.stevescape\logs`.

## Injected Client Patch

Generate the local patched injected client after cloning:

```powershell
powershell -ExecutionPolicy Bypass -File .\stevescape-tools\patch-injected-client.ps1
```

The script downloads RuneLite's `injected-client-1.11.11.jar`, patches the RSA modulus from `..\steversps\modulus`, patches the observed varp array allocations from `5000` to `15000`, and writes:

```text
stevescape-libs/injected-client-1.11.11-stevescape.jar
```

## Local Launch

Run the SteveScape server on `127.0.0.1:43594`, then launch the RuneLite client module using the default `runelite.jav_config` value. The fork disables telemetry and updater behavior by default.

After building `runelite-client`, run the shaded jar directly:

```powershell
java -jar .\runelite-client\target\client-1.11.11-shaded.jar --noupdate
```

For troubleshooting startup, use safe mode. Safe mode disables external plugins and the GPU plugin:

```powershell
java -jar .\runelite-client\target\client-1.11.11-shaded.jar --safe-mode --noupdate
```

The shaded jar includes the patched injected client and its `org.json` runtime dependency, so no extra classpath entries are required.

## Cache Reset

The client keeps its Jagex cache under `%USERPROFILE%\.stevescape\jagexcache`. If the server cache changes, or if the client was previously seeded from the wrong cache, stop the client and move that directory aside before relaunching.

The SteveScape server must serve the same cache used by RuneLite's cache overlay checks. In the server repo, `game-server/src/main/kotlin/org/alter/game/Launcher.kt` should point the filestore at `../data/cache`.

For remote distribution later, replace `runelite.jav_config` with an HTTPS URL and replace `param=17` in that hosted config with a hosted world-list URL.
