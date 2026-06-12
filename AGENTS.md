# SteveScape RuneLite Fork Context

Primary fork-specific documentation lives in `STEVESCAPE.md`.

## Always Remember

- This fork is pinned to RuneLite tag `runelite-parent-1.11.11` for OSRS revision 231-era compatibility.
- `STEVESCAPE.md` documents the local config flow, injected-client patch workflow, and local launch assumptions.
- `stevescape-config/` contains local client config files.
- `stevescape-config/jav_config.ws` is the default `runelite.jav_config` value.
- `stevescape-config/worlds.properties` is converted at runtime into an OSRS world-list payload served by the local embedded config server.
- `stevescape-tools/patch-injected-client.ps1` reproducibly patches RuneLite's `injected-client-1.11.11.jar` for the SteveScape RSA modulus and `15000` varp allocation size.
- `stevescape-libs/` stores generated local jars and intentionally ignores `*.jar`; regenerate them with the patch script rather than committing binaries.
- The server-side project lives at sibling directory `..\steversps`; its `modulus` file is the source for the client RSA modulus patch.
- The local development server target is `127.0.0.1:43594`.

## Build Notes

- Generate `stevescape-libs/injected-client-1.11.11-stevescape.jar` before building `runelite-client`.
- The fork disables telemetry and updater behavior by default in `RuneLite.java`.
- Keep remote distribution changes compatible with both local file config and future `http(s)` hosted config.
