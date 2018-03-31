import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("pm")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -162307101
   )
   @Export("currentPressedKey")
   public static int currentPressedKey;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -301090885
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 697235257
   )
   @Export("x")
   int x;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -195311981
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1240461063
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldf;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 255910971
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Lep;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("e")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 551842339
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1193888249
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("m")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("b")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("h")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2114658351
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1845201121
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 512333307
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -99567843
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Leg;"
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

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "([Lib;IIIZI)V",
      garbageValue = "-1589097289"
   )
   static void method2679(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            Size.method191(var6, var2, var3, var4);
            class292.method5207(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               MapIcon.method578(var0, var6, var4);
            }
         }
      }

   }
}
