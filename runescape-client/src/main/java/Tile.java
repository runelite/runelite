import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("qf")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   @Export("indexStore255")
   static IndexFile indexStore255;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2105934049
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1329435683
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -309325813
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 877475327
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lem;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -345764159
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lef;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("l")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 844857511
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1951036295
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("r")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("x")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("u")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1767770041
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1908885699
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1057753803
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1962025195
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lde;"
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

   @ObfuscatedName("s")
   public static final void method2712(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            ContextMenuRow.method1876(var0 - 1L);
            ContextMenuRow.method1876(1L);
         } else {
            ContextMenuRow.method1876(var0);
         }

      }
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "-1120847280"
   )
   static final String method2711(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class70.getColTags(16711680):(var2 < -6?class70.getColTags(16723968):(var2 < -3?class70.getColTags(16740352):(var2 < 0?class70.getColTags(16756736):(var2 > 9?class70.getColTags(65280):(var2 > 6?class70.getColTags(4259584):(var2 > 3?class70.getColTags(8453888):(var2 > 0?class70.getColTags(12648192):class70.getColTags(16776960))))))));
   }
}
