import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class56 {
   @ObfuscatedName("lx")
   @ObfuscatedSignature(
      signature = "Lfq;"
   )
   static class157 field649;
   @ObfuscatedName("m")
   public static Applet field653;
   @ObfuscatedName("p")
   public static String field642;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1424764697
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   static Buffer field640;
   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   static IndexedSprite[] field651;
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("fw")
   @ObfuscatedGetter(
      intValue = 1040314611
   )
   static int field655;

   static {
      field653 = null;
      field642 = null;
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(IIIILkd;Lhm;I)V",
      garbageValue = "2128540063"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class217 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5288(var10 + var5.field2683 / 2 - var4.maxWidth / 2, var5.field2680 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2683, var5.field2680, var5.field2681, var5.field2682);
            } else {
               var4.drawAt(var0 + var10 + var5.field2683 / 2 - var4.maxWidth / 2, var5.field2680 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
