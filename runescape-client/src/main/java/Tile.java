import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Leu;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("i")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ldj;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lea;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1323551655
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 79339529
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("j")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2134551675
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1773668409
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -160254689
   )
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -800399631
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -620511103
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("bridge")
   Tile bridge;
   @ObfuscatedName("f")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1765055595
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("x")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1692785581
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -832896271
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -371989349
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.entityFlags = new int[5];
      this.flags = 0;
      this.renderLevel = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }
}
