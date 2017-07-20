import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Let;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1711454415
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lez;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1515767947
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("v")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("bridge")
   Tile bridge;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 794925593
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1218040179
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("e")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 459590027
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 541937511
   )
   @Export("y")
   int y;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1243868789
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("a")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 534741531
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("y")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1234135791
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 825476067
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1587388025
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
