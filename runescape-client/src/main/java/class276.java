import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
public class class276 {
   @ObfuscatedName("n")
   @Export("javaVersion")
   public static String javaVersion;

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(IIIILkn;Lha;I)V",
      garbageValue = "1695076712"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class211 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5110(var10 + var5.field2577 / 2 - var4.maxWidth / 2, var5.field2578 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2577, var5.field2578, var5.field2581, var5.field2579);
            } else {
               var4.method5143(var0 + var10 + var5.field2577 / 2 - var4.maxWidth / 2, var5.field2578 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
