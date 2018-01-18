import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -123400925
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1747017945
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1024113217
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1654186991
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 831855861
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Lee;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("p")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 823196875
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1114807551
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("o")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("a")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("i")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 701297865
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -178883987
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1560273499
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -437205115
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lej;"
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "929636330"
   )
   public static void method2570(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getFile(var1);
      int var6 = var0.getChild(var5, var2);
      World.method1618(var0, var5, var6, var3, var4);
   }
}
