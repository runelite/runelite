import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("c")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 802336667
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 842013557
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1933807101
   )
   int field2133;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -421571797
   )
   int field2134;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1846020607
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("pw")
   @ObfuscatedGetter(
      intValue = -1714343833
   )
   static int field2136;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1753389133
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1792322677
   )
   int field2138;
   @ObfuscatedName("dx")
   @Export("host")
   static String host;
   @ObfuscatedName("m")
   @Export("renderable1")
   public Renderable renderable1;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;III)LSpritePixels;",
      garbageValue = "-2050237947"
   )
   public static SpritePixels method2876(IndexDataBase var0, int var1, int var2) {
      if(!class112.method2092(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = NPC.field1377;
         var4.maxHeight = class286.field3791;
         var4.offsetX = class95.field1493[0];
         var4.offsetY = class286.field3790[0];
         var4.width = class286.field3793[0];
         var4.height = class241.field3293[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = class31.field449[0];
         var4.image = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.image[var7] = class174.field2410[var6[var7] & 255];
         }

         VertexNormal.method2592();
         return var4;
      }
   }

   WallObject() {
      this.hash = 0;
      this.field2138 = 0;
   }
}
