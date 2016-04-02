import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("q")
public class class20 implements class112 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1650626219
   )
   final int field561;
   @ObfuscatedName("w")
   static final class20 field562 = new class20(1);
   @ObfuscatedName("f")
   static final class20 field563 = new class20(2);
   @ObfuscatedName("e")
   static final class20 field564 = new class20(0);
   @ObfuscatedName("s")
   static final class20 field569 = new class20(3);
   @ObfuscatedName("hv")
   @Export("localPlayer")
   static class2 field572;

   class20(int var1) {
      this.field561 = var1;
   }

   @ObfuscatedName("bt")
   static void method564(int var0, int var1, int var2, int var3) {
      class173 var4 = class40.method837(var0, var1);
      if(null != var4 && var4.field2846 != null) {
         class0 var5 = new class0();
         var5.field2 = var4;
         var5.field11 = var4.field2846;
         class93.method2183(var5);
      }

      client.field435 = var3;
      client.field433 = true;
      class39.field859 = var0;
      client.field416 = var1;
      class190.field3048 = var2;
      class9.method133(var4);
   }

   @ObfuscatedName("w")
   public int vmethod3172() {
      return this.field561;
   }

   @ObfuscatedName("w")
   static String method566(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class161.field2643[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class161.field2643[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[2 + var4] & 255;
               var3.append(class161.field2643[(var6 & 15) << 2 | var7 >>> 6]).append(class161.field2643[var7 & 63]);
            } else {
               var3.append(class161.field2643[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class161.field2643[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("h")
   static int method567(class25 var0, class25 var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class122.method2775(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class122.method2775(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
