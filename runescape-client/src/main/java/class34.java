import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class34 extends Node {
   @ObfuscatedName("q")
   public static boolean field742;
   @ObfuscatedName("qt")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;
   @ObfuscatedName("m")
   class193 field744;
   @ObfuscatedName("h")
   class126 field745 = new class126();
   @ObfuscatedName("bd")
   static class184 field746;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "1"
   )
   void method717(int var1, int var2, int var3, int var4) {
      class28 var5 = null;
      int var6 = 0;

      for(class28 var7 = (class28)this.field745.method2428(); var7 != null; var7 = (class28)this.field745.method2420()) {
         ++var6;
         if(var7.field660 == var1) {
            var7.method633(var1, var2, var3, var4);
            return;
         }

         if(var7.field660 <= var1) {
            var5 = var7;
         }
      }

      if(null == var5) {
         if(var6 < 4) {
            this.field745.method2434(new class28(var1, var2, var3, var4));
         }

      } else {
         class126.method2423(new class28(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.field745.method2428().unlink();
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass28;",
      garbageValue = "1959417415"
   )
   class28 method718(int var1) {
      class28 var2 = (class28)this.field745.method2428();
      if(null != var2 && var2.field660 <= var1) {
         for(class28 var3 = (class28)this.field745.method2420(); var3 != null && var3.field660 <= var1; var3 = (class28)this.field745.method2420()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.field744.field2841 + var2.field661 + var2.field660 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "86"
   )
   boolean method719() {
      return this.field745.method2427();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-1972278015"
   )
   public static int method723(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var1 + var6);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var4 + var6] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var4 + var6] = -125;
         } else if(var7 == 8222) {
            var3[var4 + var6] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var4 + var6] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var4 + var6] = -120;
         } else if(var7 == 8240) {
            var3[var4 + var6] = -119;
         } else if(var7 == 352) {
            var3[var4 + var6] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var4 + var6] = -116;
         } else if(var7 == 381) {
            var3[var4 + var6] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var4 + var6] = -110;
         } else if(var7 == 8220) {
            var3[var4 + var6] = -109;
         } else if(var7 == 8221) {
            var3[var4 + var6] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var4 + var6] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var4 + var6] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var4 + var6] = -97;
         } else {
            var3[var4 + var6] = 63;
         }
      }

      return var5;
   }

   class34(class193 var1) {
      this.field744 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1340771540"
   )
   public static void method727() {
      if(class105.keyboard != null) {
         class105 var0 = class105.keyboard;
         synchronized(class105.keyboard) {
            class105.keyboard = null;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LModIcon;B)V",
      garbageValue = "0"
   )
   static final void method728(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class188.field2780.length; ++var2) {
         class188.field2780[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class188.field2780[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               GroundObject.field1290[var5] = (class188.field2780[var5 - 1] + class188.field2780[1 + var5] + class188.field2780[var5 - 128] + class188.field2780[var5 + 128]) / 4;
            }
         }

         int[] var8 = class188.field2780;
         class188.field2780 = GroundObject.field1290;
         GroundObject.field1290 = var8;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = 16 + var4 + var0.offsetX;
                  int var6 = 16 + var3 + var0.offsetY;
                  int var7 = (var6 << 7) + var5;
                  class188.field2780[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "786506709"
   )
   public static void method729() {
      class115 var0 = class115.mouse;
      synchronized(class115.mouse) {
         class115.field1801 = class115.field1798;
         class115.field1811 = class115.field1807;
         class115.field1810 = class115.field1800;
         class115.field1808 = class115.field1804;
         class115.field1809 = class115.field1802;
         class115.field1806 = class115.field1803;
         class115.field1796 = class115.field1797;
         class115.field1804 = 0;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "15"
   )
   static void method730() {
      Client.field330.method3234(135);
      Client.field330.method2975(class105.method2061());
      Client.field330.method2976(class16.field169);
      Client.field330.method2976(class65.field1103);
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1048369562"
   )
   static final boolean method731(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "87"
   )
   static final void method732(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field649 == 0) {
         var0.field634 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = class9.getAnimation(var0.animation);
            if(var0.field654 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field634;
               return;
            }

            if(var0.field654 <= 0 && var1.priority == 0) {
               ++var0.field634;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.field599 * 64 + var0.pathX[var0.field649 - 1] * 128;
         int var4 = 128 * var0.pathY[var0.field649 - 1] + var0.field599 * 64;
         if(var10 < var3) {
            if(var2 < var4) {
               var0.field646 = 1280;
            } else if(var2 > var4) {
               var0.field646 = 1792;
            } else {
               var0.field646 = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.field646 = 768;
            } else if(var2 > var4) {
               var0.field646 = 256;
            } else {
               var0.field646 = 512;
            }
         } else if(var2 < var4) {
            var0.field646 = 1024;
         } else if(var2 > var4) {
            var0.field646 = 0;
         }

         byte var5 = var0.field625[var0.field649 - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field646 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field650;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field603;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field606;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field605;
            }

            if(var7 == -1) {
               var7 = var0.field603;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.angle != var0.field646 && var0.interacting == -1 && var0.field629 != 0) {
                  var8 = 2;
               }

               if(var0.field649 > 2) {
                  var8 = 6;
               }

               if(var0.field649 > 3) {
                  var8 = 8;
               }

               if(var0.field634 > 0 && var0.field649 > 1) {
                  var8 = 8;
                  --var0.field634;
               }
            } else {
               if(var0.field649 > 1) {
                  var8 = 6;
               }

               if(var0.field649 > 2) {
                  var8 = 8;
               }

               if(var0.field634 > 0 && var0.field649 > 1) {
                  var8 = 8;
                  --var0.field634;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field603 && var0.field630 != -1) {
               var0.poseAnimation = var0.field630;
            }

            if(var3 != var10 || var4 != var2) {
               if(var10 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var10 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var3 == var0.x && var0.y == var4) {
               --var0.field649;
               if(var0.field654 > 0) {
                  --var0.field654;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field649;
            if(var0.field654 > 0) {
               --var0.field654;
            }

         }
      }
   }
}
