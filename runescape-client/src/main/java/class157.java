import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class157 {
   @ObfuscatedName("am")
   static SpritePixels[] field2114;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 673436447
   )
   static int field2116;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LSpotanim;",
      garbageValue = "-1347130718"
   )
   public static Spotanim method3129(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.field2795.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field2798.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.field2810 = var0;
         if(null != var2) {
            var1.method3533(new Buffer(var2));
         }

         Spotanim.field2795.put(var1, (long)var0);
         return var1;
      }
   }

   class157() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IZB)Ljava/lang/String;",
      garbageValue = "50"
   )
   public static String method3138(int var0, boolean var1) {
      return var1 && var0 >= 0?class44.method891(var0, 10, var1):Integer.toString(var0);
   }
}
