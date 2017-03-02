import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class172 {
   @ObfuscatedName("l")
   public static final boolean[] field2347 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("p")
   public static boolean field2349;
   @ObfuscatedName("h")
   static int[] field2351;
   @ObfuscatedName("i")
   public static int[] field2352 = new int[99];

   class172() throws Throwable {
      throw new Error();
   }

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2352[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "1"
   )
   static final void method3325(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class159.method3142(var0)) {
         class94.field1589 = null;
         class85.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(null != class94.field1589) {
            class85.gameDraw(class94.field1589, -1412584499, var1, var2, var3, var4, class160.field2133, class40.field813, var7);
            class94.field1589 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field490[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field490[var8] = true;
            }
         }

      }
   }
}
