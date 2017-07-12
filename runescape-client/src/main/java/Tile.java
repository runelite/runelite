import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("s")
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("k")
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("y")
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("v")
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 413710941
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("j")
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("o")
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1103038989
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("r")
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("z")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("d")
   @Export("bridge")
   Tile bridge;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1475565547
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 587710695
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("b")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1895705223
   )
   @Export("x")
   int x;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 768199681
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 180766603
   )
   @Export("y")
   int y;
   @ObfuscatedName("m")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1069686959
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("f")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -726971605
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 137325067
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 760069959
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1222404465"
   )
   static int method2485(int var0, int var1, int var2) {
      return (class61.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class61.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }
}
