<!--
  DRAFT wiki page for https://github.com/runelite/wiki
  Suggested page name: Native-Resolution-Overlays.md
  Suggested sidebar links from: Developer Guide, Stretched-Mode, GPU

  Status: draft accompanying the native resolution overlays feature.
  Remove this HTML comment when publishing to the wiki.
-->

# Native Resolution Overlays (draft)

When [Stretched Mode](https://github.com/runelite/runelite/wiki/Stretched-Mode) is enabled, the game UI is drawn at canvas resolution and then upscaled. Historically, RuneLite overlays shared that UI buffer, so world overlays (tile highlights, NPC outlines, etc.) were upscaled too and looked soft.

With stretched mode on, **builtin** RuneLite overlays draw into a display-resolution buffer and composite around the stretched UI, so world overlays stay sharp. Plugin Hub / sideloaded overlays stay on the legacy (soft) path until they opt in.

This page is for **core and Plugin Hub developers**. For player-facing stretched/GPU settings, see [Stretched Mode](https://github.com/runelite/runelite/wiki/Stretched-Mode) and [GPU](https://github.com/runelite/runelite/wiki/GPU).

## Player settings (context)

| Setting | Where | Meaning |
| --- | --- | --- |
| **Fixed overlay size** | Stretched Mode | Off (default): interface overlays grow with stretch. On: keep them smaller than full UI stretch. With aspect off they still match the window’s aspect (`1/s` content scale); with aspect on they stay true canvas 1×1 pixels. |
| **Fixed overlay aspect ratio** | Stretched Mode | Keep interface overlays and world HUD text (FPS/ping, player names, ground item labels) at a uniform scale instead of matching a non-uniform window stretch. Only matters when horizontal and vertical stretch differ (typically **Keep aspect ratio** off). Does **not** affect world geometry (tiles, outlines, orb rings) or inventory/`WidgetItemOverlay` sprites. With fixed size on, forces true canvas 1×1. |
| **Fixed menu size** | Stretched Mode | Keep the deferred right-click menu smaller than full UI stretch. Same size/aspect matrix as overlays. Requires native resolution overlays. Off by default. |
| **Fixed menu aspect ratio** | Stretched Mode | Uniform menu scale on non-uniform stretch. With fixed menu size on, forces true canvas size. Off by default. |

Use existing **Interface font**, **Infobox font**, and **Infobox size** to fine-tune readability. Mouse tooltips, FPS, and world-hopper ping always follow the fixed overlay size/aspect matrix when native overlays are active.

### Panel content scale matrix

After the outer stretch `scale(sx, sy)`, interface overlays get an extra content scale (`s = min(sx, sy)`):

| Fixed size | Fixed aspect | Content `(cx, cy)` | Net visual |
| --- | --- | --- | --- |
| off | off | `(1, 1)` | `(sx, sy)` — full window stretch |
| off | on | `(s/sx, s/sy)` | `(s, s)` — uniform |
| on | off | `(1/s, 1/s)` | `(sx/s, sy/s)` — smaller, window aspect |
| on | on | `(1/sx, 1/sy)` | `(1, 1)` — true canvas pixels |

World/`DYNAMIC` decorations that stay tied to the scene use **fixed-size content scale only** (`1/sx`, `1/sy` when fixed size is on; aspect is ignored) so polygons and object-anchored sprites stay aligned with the stretched scene.

## Rendering model

```
Scene (GPU / software)
    → under-UI native overlays   (ABOVE_SCENE, UNDER_WIDGETS; model outlines)
    → game UI (bank, inventory, …)  [stretched; menu skipped when deferred]
    → above-UI native overlays   (ABOVE_WIDGETS, ALWAYS_ON_TOP, tooltips,
                                  WidgetItemOverlay / drawAfter* hooks)
    → deferred right-click menu  [after ABOVE_UI so translucent menus blend over sharp overlays]
```

Layer ordering matches classic `OverlayLayer` rules: default under-widget overlays stay **under** the bank; `ABOVE_WIDGETS` / inventory item overlays stay **under** the menu; overlays promoted to above-widgets (e.g. after Alt-dragging) still draw on top of the UI.

### Two buffers

Core code uses `NativeOverlayBuffer` with passes `UNDER_UI` and `ABOVE_UI`. GPU composites under before `drawUi`, then above after, then the deferred menu. That preserves bank-over-infobox behaviour and menu-over-rune-pouch behaviour. Active whenever stretched mode actually upscales.

CPU path: under-UI stays on the canvas so the bank covers it; only ABOVE_UI (+ deferred menu) composites after stretch.

### Deferred right-click menu

`NativeOverlayMenu` consumes early `BeforeMenuRender` so the menu never enters the UI texture, captures it via Interface Styles / client paint (black/white alpha recovery), and composites after ABOVE_UI.

- Placement: click-centered on X, top-aligned on Y (client contract); clamp only when the dest would not fit — no edge magnet.
- Submenus: dest is anchored on the **root** menu bounds so expanding the capture union does not re-center the tree.
- Mouse: after stretch→canvas translate, hits are remapped with the same root-anchored content scale.

### What “canvas space” means

Even when drawing into the native buffer, **coordinates stay in canvas space** (same values as `Perspective.getCanvasTextLocation`, `getCanvasTilePoly`, widget bounds, etc.). The renderer applies stretch scale on the `Graphics2D` so those coordinates land on the display-sized buffer.

## Plugin Hub / sideloaded plugins (opt-in)

Hub and sideloaded **world** overlays (tiles, outlines, custom `DYNAMIC` drawing) **default to the legacy canvas path**. They keep correct proportions (but stay soft when stretched) until they opt in. This avoids silently breaking external plugins.

**Infoboxes are already included.** Hub plugins that register `InfoBox`es via `InfoBoxManager` are drawn by the core `InfoBoxOverlay`, which always follows the native path + fixed overlay size/aspect settings. No hub opt-in is required for infoboxes.

Builtin (core) overlays default to the native path.

### Opting in (tiles, outlines, custom overlays)

Pass your `Plugin` into `Overlay`’s constructor (normal Hub practice), then:

```java
setPreferNativeResolution(true);
```

Only do this after you have verified drawing under stretch (see checklist below). Prefer submitting a PR to the hub plugin after testing with the author when possible.

`ModelOutlineRenderer` follows the **calling overlay’s** preference: hub overlays that have not opted in keep soft outlines; after opt-in, outlines rasterize into the native UNDER_UI buffer at display resolution with that overlay.

Detection: overlays whose plugin classloader is not the client classloader get `preferNativeResolution = false` automatically in `Overlay(Plugin)`.

### Optional overlay flags (core)

| Flag | Use when |
| --- | --- |
| `setPreferPanelContentScale(true)` | DYNAMIC HUD that should use the **panel** size/aspect matrix and whole-`Graphics2D` content scale (e.g. FPS / ping). Positions are in content space — use `OverlayUtil.getContentSpaceWidth` for flush-right layout. |
| `setPreferPanelGlyphScale(true)` | World-anchored DYNAMIC text/icons that should follow panel size/aspect **without** moving canvas positions (e.g. player names, ground item labels). Glyphs/images scale locally; polygons stay full stretch. |
| `setPreferUiPixelGrid(true)` | Geometry that must share the GPU **nearest** UI texel grid (orb rings / arcs). Draws on the canvas under nearest UI scaling; leave text/panels on the native path. |

Do not set panel content scale on world overlays that self-position with `getMinimapLocation()` (left-aligned from a dot) the same way as `getCanvasTextLocation()` (centered left edge) — see minimap note below.

## Drawing contracts

### Interface overlays (`TOP_LEFT`, `TOP_RIGHT`, panels, …)

After stretch scale, the renderer applies **panel content scale** from the fixed overlay size/aspect matrix. Prefer `OverlayPanel` / panel components. Hit-testing and Alt drag bounds use visual size automatically for overlays on the native path.

### World / `DYNAMIC` overlays

- Positions: canvas coordinates (unchanged APIs).
- **Text / images (default world path)**: honour **fixed overlay size only** (aspect ignored). Prefer `OverlayUtil` for images.
- **Text / images with `preferPanelGlyphScale`**: honour the full panel size/aspect matrix via local glyph scale (`KEY_NATIVE_LOCAL_TEXT_SCALE`). Shadows/outlines use one device pixel after the combined transform (`screenPixelOffset*`).
- **Polygons / strokes**: use stretch scale (sharp at display resolution). Prefer `OverlayUtil.renderPolygon`. If you set your own `BasicStroke`, remember user-space width is multiplied by stretch.

Use `OverlayUtil`:

| API | When to use |
| --- | --- |
| `renderImageLocation(Graphics2D, Point, BufferedImage)` | Point is top-left of the **full bitmap footprint** (e.g. `Perspective.getCanvasImageLocation` / actor canvas image helpers). Applies size factor and **centers** in that footprint |
| `getImageLayoutSize(Graphics2D, BufferedImage)` | Layout size in canvas space after size factor |
| `renderImageLocationExact(Graphics2D, Point, BufferedImage)` | Point is top-left of the **drawn** (layout-sized) sprite — use when packing icons next to text |
| `adjustLocalTextScaleLocation(Graphics2D, Point, String)` | Only when the point is a **`getCanvasTextLocation`-style** left edge (text was centered using full font width). Shifts so left-aligned draw stays centered under local glyph scale. **Do not** use with `getMinimapLocation()` (left-align from actor dot) |
| `getContentSpaceWidth(Graphics2D, int canvasWidth)` | Right-aligned HUD under panel content scale (`preferPanelContentScale`) |
| `renderTextLocation` / `TextComponent` | Local text scale + 1-screen-pixel shadow when `KEY_NATIVE_LOCAL_TEXT_SCALE` is set |

### Progress pies / timer pies

`ProgressPieComponent` follows the native visual size factors on the current overlay. Arcs are antialiased into the native buffer.

### Icon + text packs

Wrong (reserves full bitmap width while the sprite draws smaller → gap / off-centre group):

```java
int w = icon.getWidth();
Point loc = new Point(textX - w / 2, textY - icon.getHeight() / 2);
graphics.drawImage(icon, loc.getX(), loc.getY(), null);
```

Right:

```java
Dimension size = OverlayUtil.getImageLayoutSize(graphics, icon);
Point loc = new Point(textX - size.width / 2, textY - size.height / 2);
OverlayUtil.renderImageLocationExact(graphics, loc, icon);
// advance text by size.width / 2 (or size.width), not icon.getWidth()
```

Under panel glyph scale with a non-uniform aspect, pack icon + name in **unscaled** space then apply one shared local scale about the name center (see `PlayerIndicatorsOverlay`) so the plate stays locked together.

See core examples: `PlayerIndicatorsOverlay`, `PlayerInfoDropOverlay`, `GroundItemsOverlay`.

### Minimap names

`Actor.getMinimapLocation()` is the actor **dot**. Draw text left-aligned from that point. Do **not** call `adjustLocalTextScaleLocation` (that helper assumes overhead-style centering and will shift names to the right when scaled down).

### Widget overlays / inventory item overlays

Overlays that only reposition client widgets (XP tracker, health bar, etc.) are not sprite-scaled; they follow UI stretch.

`WidgetItemOverlay` (rune pouch, item charges, inventory tags, …) uses `MANUAL` + `drawAfterLayer` / `drawAfterInterface`. Those hooks render as ABOVE_UI under native mode; the deferred menu composites afterward so translucent menus still cover them — same contract as classic “under the right-click menu”.

## Checklist for Hub authors enabling native resolution

1. Enable Stretched Mode (integer scaling helps).
2. Call `setPreferNativeResolution(true)` on each overlay you intend to migrate.
3. Exercise: open bank (under-UI overlays covered), Alt-drag overlays, right-click over inventory overlays (menu above rune pouch / charges), tooltips if any.
4. Replace raw `drawImage` with `OverlayUtil.renderImageLocation*` where appropriate.
5. For any icon beside text, use `getImageLayoutSize` for margins/anchors; under glyph scale, prefer a shared group transform when aspect can be non-uniform.
6. Retest with **Fixed overlay size** and **Fixed overlay aspect ratio** on/off if you draw interface panels or DYNAMIC text/icons.
7. Confirm minimap icons and world icons still sit on their targets; minimap **names** stay left-aligned from the dot.
8. If you draw orb-style geometry under GPU nearest UI scaling and need a matching pixel grid, consider `setPreferUiPixelGrid(true)` (geometry only).

## Related code (core)

- `net.runelite.client.plugins.stretchedmode.StretchedModeConfig` — fixed overlay/menu size and aspect options
- `net.runelite.client.ui.overlay.NativeOverlayBuffer` — buffers / stretch / panel vs fixed-size content scales
- `net.runelite.client.ui.overlay.NativeOverlayMenu` — deferred menu capture, placement, mouse remap
- `net.runelite.client.ui.overlay.OverlayRenderer` — native vs canvas routing, layer passes, panel/glyph scale
- `net.runelite.client.ui.overlay.OverlayUtil` — image/text helpers, local text scale, content-space width
- `net.runelite.client.ui.overlay.Overlay#setPreferNativeResolution`
- `net.runelite.client.ui.overlay.Overlay#setPreferPanelContentScale` / `#setPreferPanelGlyphScale` / `#setPreferUiPixelGrid`
- `net.runelite.client.ui.overlay.outline.ModelOutlineRenderer` — display-resolution outlines on native UNDER_UI

## See also

- [Stretched Mode](https://github.com/runelite/runelite/wiki/Stretched-Mode)
- [GPU](https://github.com/runelite/runelite/wiki/GPU)
- [Creating a Plugin](https://github.com/runelite/runelite/wiki/Creating-Plugins) (Plugin Hub packaging)
