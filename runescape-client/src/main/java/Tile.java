import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1976454559
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Lez;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1393231975
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldj;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("o")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Leb;"
   )
   @Export("bridge")
   Tile bridge;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1888297059
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -140769371
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("w")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1910906369
   )
   @Export("x")
   int x;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1263341881
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1447577433
   )
   @Export("y")
   int y;
   @ObfuscatedName("b")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 619212105
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("k")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1573100023
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 370150347
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 59001903
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
