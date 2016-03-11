import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class41 extends class203 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 357803695
   )
   public int field968;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -215090143
   )
   public int field969;
   @ObfuscatedName("j")
   public static class166 field970;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -918801001
   )
   public int field971;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1198373009
   )
   public int field972;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1141701039
   )
   int field973 = 0;
   @ObfuscatedName("n")
   static byte[][] field977;
   @ObfuscatedName("l")
   static class192 field979 = new class192(64);

   @ObfuscatedName("j")
   public static boolean method839(int var0, int var1) {
      return 0 != (var0 >> var1 + 1 & 1);
   }

   @ObfuscatedName("l")
   void method840() {
      this.method843(this.field973);
   }

   @ObfuscatedName("a")
   void method841(class118 var1) {
      while(true) {
         int var2 = var1.method2453();
         if(0 == var2) {
            return;
         }

         this.method842(var1, var2);
      }
   }

   @ObfuscatedName("i")
   void method842(class118 var1, int var2) {
      if(1 == var2) {
         this.field973 = var1.method2553();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1035193256"
   )
   void method843(int var1) {
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
      double var16 = (var8 + var10) / 2.0D;
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
      this.field968 = (int)(256.0D * var14);
      this.field969 = (int)(256.0D * var16);
      if(this.field968 < 0) {
         this.field968 = 0;
      } else if(this.field968 > 255) {
         this.field968 = 255;
      }

      if(this.field969 < 0) {
         this.field969 = 0;
      } else if(this.field969 > 255) {
         this.field969 = 255;
      }

      if(var16 > 0.5D) {
         this.field972 = (int)((1.0D - var16) * var14 * 512.0D);
      } else {
         this.field972 = (int)(var14 * var16 * 512.0D);
      }

      if(this.field972 < 1) {
         this.field972 = 1;
      }

      this.field971 = (int)((double)this.field972 * var12);
   }

   @ObfuscatedName("j")
   public static int method849(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(1 == var1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "([Lclass172;IS)V",
      garbageValue = "21790"
   )
   static final void method857(class172[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class172 var3 = var0[var2];
         if(null != var3 && var1 == var3.field2778 && (!var3.field2758 || !class18.method195(var3))) {
            if(0 == var3.field2849) {
               if(!var3.field2758 && class18.method195(var3) && class74.field1376 != var3) {
                  continue;
               }

               method857(var0, var3.field2759 * -1);
               if(null != var3.field2881) {
                  method857(var3.field2881, var3.field2759 * -1);
               }

               class3 var4 = (class3)client.field449.method3744((long)(var3.field2759 * -1));
               if(null != var4) {
                  class36.method749(var4.field66);
               }
            }

            if(var3.field2849 == 6) {
               int var5;
               if(-1 != var3.field2836 || -1 != var3.field2805) {
                  boolean var7 = class72.method1568(var3);
                  if(var7) {
                     var5 = var3.field2805;
                  } else {
                     var5 = var3.field2836;
                  }

                  if(-1 != var5) {
                     class42 var6 = class36.method741(var5);

                     for(var3.field2760 += client.field362; var3.field2760 > var6.field988[var3.field2816]; class114.method2400(var3)) {
                        var3.field2760 -= var6.field988[var3.field2816];
                        ++var3.field2816;
                        if(var3.field2816 >= var6.field986.length) {
                           var3.field2816 -= var6.field983 * -1;
                           if(var3.field2816 < 0 || var3.field2816 >= var6.field986.length) {
                              var3.field2816 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2813 != 0 && !var3.field2758) {
                  int var8 = var3.field2813 >> 16;
                  var5 = var3.field2813 << 16 >> 16;
                  var8 *= client.field362;
                  var5 *= client.field362;
                  var3.field2808 = var3.field2808 + var8 & 2047;
                  var3.field2809 = var3.field2809 + var5 & 2047;
                  class114.method2400(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   static void method859(class42 var0, int var1, int var2, int var3) {
      if(client.field530 < 50 && client.field502 != 0) {
         if(var0.field995 != null && var1 < var0.field995.length) {
            int var4 = var0.field995[var1];
            if(0 != var4) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               client.field531[client.field530] = var5;
               client.field532[client.field530] = var6;
               client.field443[client.field530] = 0;
               client.field401[client.field530] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               client.field534[client.field530] = (var9 << 8) + (var8 << 16) + var7;
               ++client.field530;
            }
         }
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-127117358"
   )
   static void method860() {
      client var0 = client.field284;
      synchronized(client.field284) {
         Container var1 = client.field284.method2971();
         if(var1 != null) {
            class34.field775 = Math.max(var1.getSize().width, class86.field1534);
            class102.field1777 = Math.max(var1.getSize().height, class45.field1044);
            Insets var2;
            if(client.field574 == var1) {
               var2 = client.field574.getInsets();
               class34.field775 -= var2.left + var2.right;
               class102.field1777 -= var2.bottom + var2.top;
            }

            if(class34.field775 <= 0) {
               class34.field775 = 1;
            }

            if(class102.field1777 <= 0) {
               class102.field1777 = 1;
            }

            if(class97.method2167() == 1) {
               class142.field2190 = client.field503 * 765;
               class89.field1566 = client.field504 * 503;
            } else {
               class142.field2190 = Math.min(class34.field775, 7680);
               class89.field1566 = Math.min(class102.field1777, 2160);
            }

            class143.field2208 = (class34.field775 - class142.field2190) / 2;
            class143.field2209 = 0;
            class125.field2039.setSize(class142.field2190, class89.field1566);
            class75.field1385 = class88.method2054(class142.field2190, class89.field1566, class125.field2039);
            if(var1 == client.field574) {
               var2 = client.field574.getInsets();
               class125.field2039.setLocation(var2.left + class143.field2208, class143.field2209 + var2.top);
            } else {
               class125.field2039.setLocation(class143.field2208, class143.field2209);
            }

            class37.method759();
            if(-1 != client.field448) {
               class51.method1078(true);
            }

            class208.method3862();
         }
      }
   }
}
