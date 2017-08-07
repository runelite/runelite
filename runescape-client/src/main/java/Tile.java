import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -5943583
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Leu;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 278652405
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("l")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("bridge")
   Tile bridge;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -113661839
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 988442747
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("m")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1493053205
   )
   @Export("x")
   int x;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1175457685
   )
   @Export("y")
   int y;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -644895815
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("c")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1650782487
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("a")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1813195317
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -63128261
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1239070173
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
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "1598208191"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-888629666"
   )
   static int method2512() {
      return Client.isResized?2:1;
   }
}
