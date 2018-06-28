import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("pk")
   @ObfuscatedGetter(
      intValue = -83791479
   )
   static int field1589;
   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   static Task field1584;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1561524015
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1674601455
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -798044221
   )
   @Export("y")
   int y;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1001695283
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldi;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ldj;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1950200141
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Leg;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("s")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -148362437
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1028803959
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("y")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("c")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("e")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 351668389
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -900292881
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -568181011
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 360429277
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ldh;"
   )
   @Export("bridge")
   Tile bridge;

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.entityFlags = new int[5];
      this.flags = 0;
      this.renderLevel = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-6"
   )
   public static int method2717(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }
}
