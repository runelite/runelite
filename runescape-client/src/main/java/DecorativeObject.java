import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   static IndexData field2162;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 256448349
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1853368037
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -364698591
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1221186097
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1936129171
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1856849269
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -741340865
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1285683311
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1718902575
   )
   @Export("rotation")
   int rotation;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "-65"
   )
   static String method2923(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class269.field3677[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class269.field3677[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class269.field3677[(var6 & 15) << 2 | var7 >>> 6]).append(class269.field3677[var7 & 63]);
            } else {
               var3.append(class269.field3677[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class269.field3677[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIB)I",
      garbageValue = "-92"
   )
   static final int method2922(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - Graphics3D.COSINE[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
   }
}
