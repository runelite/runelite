import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("ep")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class class142 extends Canvas {
   @ObfuscatedName("m")
   Component field2202;

   public final void paint(Graphics var1) {
      this.field2202.paint(var1);
   }

   class142(Component var1) {
      this.field2202 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Lclass106;",
      garbageValue = "1205971140"
   )
   @Export("getFrames")
   static class106 method2997(int var0) {
      class106 var1 = (class106)class44.field1012.method3817((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         class170 var3 = class44.field1023;
         class170 var4 = class44.field1006;
         boolean var5 = true;
         int[] var6 = var3.method3353(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3310(var0, var6[var7]);
            if(null == var8) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3310(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         class106 var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new class106(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "1387548906"
   )
   public static int method2998(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I[BLclass137;B)V",
      garbageValue = "11"
   )
   static void method2999(int var0, byte[] var1, class137 var2) {
      class172 var3 = new class172();
      var3.field2753 = 0;
      var3.field3167 = (long)var0;
      var3.field2755 = var1;
      var3.field2754 = var2;
      class202 var4 = class173.field2759;
      synchronized(class173.field2759) {
         class173.field2759.method3877(var3);
      }

      Object var9 = class173.field2756;
      synchronized(class173.field2756) {
         if(class173.field2758 == 0) {
            class40.field900.method2937(new class173(), 5);
         }

         class173.field2758 = 600;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lclass155;",
      garbageValue = "1032262788"
   )
   public static class155[] method3000() {
      return new class155[]{class155.field2325, class155.field2324, class155.field2322, class155.field2321, class155.field2320};
   }

   public final void update(Graphics var1) {
      this.field2202.update(var1);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-22"
   )
   @Export("groundItemSpawned")
   static final void method3001(int var0, int var1) {
      class202 var2 = client.field403[class51.field1119][var0][var1];
      if(var2 == null) {
         class5.field91.method2020(class51.field1119, var0, var1);
      } else {
         long var3 = -99999999L;
         class30 var5 = null;

         class30 var6;
         for(var6 = (class30)var2.method3882(); var6 != null; var6 = (class30)var2.method3891()) {
            class55 var7 = class4.method42(var6.field699);
            long var8 = (long)var7.field1185;
            if(var7.field1194 == 1) {
               var8 *= (long)(var6.field694 + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class5.field91.method2020(class51.field1119, var0, var1);
         } else {
            var2.method3878(var5);
            class30 var11 = null;
            class30 var10 = null;

            for(var6 = (class30)var2.method3882(); null != var6; var6 = (class30)var2.method3891()) {
               if(var6.field699 != var5.field699) {
                  if(null == var11) {
                     var11 = var6;
                  }

                  if(var11.field699 != var6.field699 && null == var10) {
                     var10 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            class5.field91.method2121(class51.field1119, var0, var1, class15.method163(64 + var0 * 128, 64 + var1 * 128, class51.field1119), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(Lclass3;ZB)V",
      garbageValue = "1"
   )
   static final void method3002(class3 var0, boolean var1) {
      int var2 = var0.field66;
      int var3 = (int)var0.field3167;
      var0.method3990();
      if(var1 && var2 != -1 && class219.field3209[var2]) {
         class176.field2889.method3301(var2);
         if(null != class176.field2814[var2]) {
            boolean var4 = true;

            for(int var5 = 0; var5 < class176.field2814[var2].length; ++var5) {
               if(null != class176.field2814[var2][var5]) {
                  if(class176.field2814[var2][var5].field2929 != 2) {
                     class176.field2814[var2][var5] = null;
                  } else {
                     var4 = false;
                  }
               }
            }

            if(var4) {
               class176.field2814[var2] = null;
            }

            class219.field3209[var2] = false;
         }
      }

      class2.method32(var2);
      class176 var6 = class34.method720(var3);
      if(null != var6) {
         class92.method2164(var6);
      }

      class145.method3039();
      if(client.field430 != -1) {
         class178.method3501(client.field430, 1);
      }

   }
}
