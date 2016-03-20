import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class41 extends class203 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -140740519
   )
   public int field974;
   @ObfuscatedName("a")
   public static class166 field975;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -93323237
   )
   int field976 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1812350895
   )
   public int field977;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2120047889
   )
   public int field978;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1520916055
   )
   public int field979;
   @ObfuscatedName("r")
   public static class192 field981 = new class192(64);

   @ObfuscatedName("a")
   public void method850() {
      this.method853(this.field976);
   }

   @ObfuscatedName("r")
   public void method851(class118 var1) {
      while(true) {
         int var2 = var1.method2579();
         if(0 == var2) {
            return;
         }

         this.method856(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2014269493"
   )
   void method853(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var10 + var8) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = (var6 - var2) / (var10 - var8) + 2.0D;
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field978 = (int)(var14 * 256.0D);
      this.field979 = (int)(var16 * 256.0D);
      if(this.field978 < 0) {
         this.field978 = 0;
      } else if(this.field978 > 255) {
         this.field978 = 255;
      }

      if(this.field979 < 0) {
         this.field979 = 0;
      } else if(this.field979 > 255) {
         this.field979 = 255;
      }

      if(var16 > 0.5D) {
         this.field977 = (int)(512.0D * var14 * (1.0D - var16));
      } else {
         this.field977 = (int)(var14 * var16 * 512.0D);
      }

      if(this.field977 < 1) {
         this.field977 = 1;
      }

      this.field974 = (int)((double)this.field977 * var12);
   }

   @ObfuscatedName("f")
   void method856(class118 var1, int var2) {
      if(1 == var2) {
         this.field976 = var1.method2516();
      }

   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;I)V",
      garbageValue = "1408216536"
   )
   static void method866(int var0, int var1, int var2, int var3, String var4) {
      class172 var5 = class13.method183(var1, var2);
      if(var5 != null) {
         if(var5.field2841 != null) {
            class0 var6 = new class0();
            var6.field6 = var5;
            var6.field5 = var0;
            var6.field0 = var4;
            var6.field8 = var5.field2841;
            class150.method3148(var6);
         }

         boolean var10 = true;
         if(var5.field2747 > 0) {
            var10 = class18.method212(var5);
         }

         if(var10) {
            int var8 = class101.method2294(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> var9 + 1 & 1) != 0;
            if(var7) {
               if(var0 == 1) {
                  client.field301.method2753(238);
                  client.field301.method2663(var1);
                  client.field301.method2498(var2);
                  client.field301.method2498(var3);
               }

               if(var0 == 2) {
                  client.field301.method2753(112);
                  client.field301.method2663(var1);
                  client.field301.method2498(var2);
                  client.field301.method2498(var3);
               }

               if(3 == var0) {
                  client.field301.method2753(74);
                  client.field301.method2663(var1);
                  client.field301.method2498(var2);
                  client.field301.method2498(var3);
               }

               if(var0 == 4) {
                  client.field301.method2753(106);
                  client.field301.method2663(var1);
                  client.field301.method2498(var2);
                  client.field301.method2498(var3);
               }

               if(var0 == 5) {
                  client.field301.method2753(182);
                  client.field301.method2663(var1);
                  client.field301.method2498(var2);
                  client.field301.method2498(var3);
               }

               if(6 == var0) {
                  client.field301.method2753(215);
                  client.field301.method2663(var1);
                  client.field301.method2498(var2);
                  client.field301.method2498(var3);
               }

               if(7 == var0) {
                  client.field301.method2753(220);
                  client.field301.method2663(var1);
                  client.field301.method2498(var2);
                  client.field301.method2498(var3);
               }

               if(var0 == 8) {
                  client.field301.method2753(174);
                  client.field301.method2663(var1);
                  client.field301.method2498(var2);
                  client.field301.method2498(var3);
               }

               if(var0 == 9) {
                  client.field301.method2753(148);
                  client.field301.method2663(var1);
                  client.field301.method2498(var2);
                  client.field301.method2498(var3);
               }

               if(var0 == 10) {
                  client.field301.method2753(66);
                  client.field301.method2663(var1);
                  client.field301.method2498(var2);
                  client.field301.method2498(var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("ds")
   static final void method867(String var0) {
      if(null != class42.field1003) {
         client.field301.method2753(129);
         client.field301.method2497(class22.method578(var0));
         client.field301.method2503(var0);
      }
   }

   @ObfuscatedName("r")
   public static void method868(Component var0) {
      var0.removeKeyListener(class136.field2108);
      var0.removeFocusListener(class136.field2108);
      class136.field2109 = -1;
   }
}
