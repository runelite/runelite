import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   static IndexedSprite[] field1829;
   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1301732437
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 492287653
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1072790217
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -178216961
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldl;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ldf;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1087750097
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Ler;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("a")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -279791727
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1107176895
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("m")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("h")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("c")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 657432429
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1308193013
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2134635245
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1480653171
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lec;"
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;I)V",
      garbageValue = "-1576614363"
   )
   public static void method2503(IndexDataBase var0) {
      FloorUnderlayDefinition.underlay_ref = var0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "48"
   )
   static final void method2504(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      class13.method79(var7, var9, var8, var10, -49088);
   }
}
