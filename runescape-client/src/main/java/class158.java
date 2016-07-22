import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class158 {
   @ObfuscatedName("w")
   public static final boolean[] field2349 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
   @ObfuscatedName("e")
   public static int[] field2351 = new int[99];
   @ObfuscatedName("l")
   static byte[][][] field2353;
   @ObfuscatedName("ni")
   static class59 field2354;

   static {
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2351[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)Lclass176;",
      garbageValue = "-32"
   )
   public static class176 method3212(int var0, int var1) {
      class176 var2 = class34.method720(var0);
      return var1 == -1?var2:(null != var2 && var2.field2919 != null && var1 < var2.field2919.length?var2.field2919[var1]:null);
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)Lclass176;",
      garbageValue = "526596730"
   )
   static class176 method3213(class176 var0) {
      int var2 = class12.method151(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(var1 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = class34.method720(var0.field2836);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass171;IIIBZB)V",
      garbageValue = "2"
   )
   static void method3214(class171 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class175 var8 = (class175)class174.field2762.method3856(var6);
      if(var8 == null) {
         var8 = (class175)class174.field2778.method3856(var6);
         if(var8 == null) {
            var8 = (class175)class174.field2773.method3856(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3960();
                  class174.field2762.method3849(var8, var6);
                  --class174.field2768;
                  ++class174.field2763;
               }

            } else {
               if(!var5) {
                  var8 = (class175)class174.field2760.method3856(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class175();
               var8.field2784 = var0;
               var8.field2782 = var3;
               var8.field2781 = var4;
               if(var5) {
                  class174.field2762.method3849(var8, var6);
                  ++class174.field2763;
               } else {
                  class174.field2764.method3946(var8);
                  class174.field2773.method3849(var8, var6);
                  ++class174.field2768;
               }

            }
         }
      }
   }
}
