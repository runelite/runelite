import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class19 {
   @ObfuscatedName("g")
   boolean field264 = false;
   @ObfuscatedName("f")
   boolean[] field266;
   @ObfuscatedName("s")
   boolean[] field267;
   @ObfuscatedName("p")
   int[] field268;
   @ObfuscatedName("h")
   String[] field269;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -1382373909991646845L
   )
   long field271;
   @ObfuscatedName("bl")
   static class168 field272;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -323117685
   )
   @Export("cameraX")
   static int field273;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-20786"
   )
   void method194(int var1, int var2) {
      this.field268[var1] = var2;
      if(this.field266[var1]) {
         this.field264 = true;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1468016689"
   )
   void method196() {
      class227 var1 = this.method207(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field268.length; ++var4) {
            if(this.field266[var4] && -1 != this.field268[var4]) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.field269.length; ++var5) {
            if(this.field267[var5] && this.field269[var5] != null) {
               var2 += 2 + class47.method982(this.field269[var5]);
               ++var4;
            }
         }

         class119 var17 = new class119(var2);
         var17.method2565(1);
         var17.method2713(var3);

         int var6;
         for(var6 = 0; var6 < this.field268.length; ++var6) {
            if(this.field266[var6] && this.field268[var6] != -1) {
               var17.method2713(var6);
               var17.method2617(this.field268[var6]);
            }
         }

         var17.method2713(var4);

         for(var6 = 0; var6 < this.field269.length; ++var6) {
            if(this.field267[var6] && null != this.field269[var6]) {
               var17.method2713(var6);
               var17.method2514(this.field269[var6]);
            }
         }

         var1.method4113(var17.field1980, 0, var17.field1976);
      } catch (Exception var15) {
         ;
      } finally {
         try {
            var1.method4114();
         } catch (Exception var14) {
            ;
         }

      }

      this.field264 = false;
      this.field271 = class140.method2967();
   }

   @ObfuscatedName("s")
   String method197(int var1) {
      return this.field269[var1];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-46"
   )
   void method198() {
      int var1;
      for(var1 = 0; var1 < this.field268.length; ++var1) {
         if(!this.field266[var1]) {
            this.field268[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.field269.length; ++var1) {
         if(!this.field267[var1]) {
            this.field269[var1] = null;
         }
      }

   }

   @ObfuscatedName("f")
   void method199(int var1, String var2) {
      this.field269[var1] = var2;
      if(this.field267[var1]) {
         this.field264 = true;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "98920241"
   )
   void method201() {
      class227 var1 = this.method207(false);

      label192: {
         try {
            byte[] var2 = new byte[(int)var1.method4115()];

            int var4;
            for(int var3 = 0; var3 < var2.length; var3 += var4) {
               var4 = var1.method4121(var2, var3, var2.length - var3);
               if(var4 == -1) {
                  throw new EOFException();
               }
            }

            class119 var23 = new class119(var2);
            if(var23.field1980.length - var23.field1976 >= 1) {
               int var5 = var23.method2523();
               if(var5 < 0 || var5 > 1) {
                  return;
               }

               int var6 = var23.method2700();

               int var7;
               int var8;
               int var9;
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var23.method2700();
                  var9 = var23.method2528();
                  if(this.field266[var8]) {
                     this.field268[var8] = var9;
                  }
               }

               var7 = var23.method2700();
               var8 = 0;

               while(true) {
                  if(var8 >= var7) {
                     break label192;
                  }

                  var9 = var23.method2700();
                  String var10 = var23.method2531();
                  if(this.field267[var9]) {
                     this.field269[var9] = var10;
                  }

                  ++var8;
               }
            }
         } catch (Exception var21) {
            break label192;
         } finally {
            try {
               var1.method4114();
            } catch (Exception var20) {
               ;
            }

         }

         return;
      }

      this.field264 = false;
   }

   @ObfuscatedName("w")
   int method202(int var1) {
      return this.field268[var1];
   }

   @ObfuscatedName("k")
   boolean method203() {
      return this.field264;
   }

   @ObfuscatedName("h")
   class227 method207(boolean var1) {
      return class143.method3003("2", class164.field2657.field2278, var1);
   }

   @ObfuscatedName("r")
   void method215() {
      if(this.field264 && this.field271 < class140.method2967() - 60000L) {
         this.method196();
      }

   }

   class19() {
      this.field268 = new int[class104.field1772.method3307(19)];
      this.field269 = new String[class104.field1772.method3307(15)];
      this.field266 = new boolean[this.field268.length];

      int var1;
      for(var1 = 0; var1 < this.field268.length; ++var1) {
         class45 var2 = class99.method2211(var1);
         this.field266[var1] = var2.field1019;
      }

      this.field267 = new boolean[this.field269.length];

      for(var1 = 0; var1 < this.field269.length; ++var1) {
         class49 var3 = (class49)class49.field1070.method3754((long)var1);
         class49 var5;
         if(null != var3) {
            var5 = var3;
         } else {
            byte[] var4 = class218.field3163.method3280(15, var1);
            var3 = new class49();
            if(var4 != null) {
               var3.method996(new class119(var4));
            }

            class49.field1070.method3756(var3, (long)var1);
            var5 = var3;
         }

         this.field267[var1] = var5.field1067;
      }

      for(var1 = 0; var1 < this.field268.length; ++var1) {
         this.field268[var1] = -1;
      }

      this.method201();
   }

   @ObfuscatedName("e")
   static class22 method222(int var0) {
      class22 var1 = (class22)class22.field582.method3754((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class59.field1189.method3280(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class22();
            class119 var3 = new class119(var2);
            var3.field1976 = var3.field1980.length - 12;
            int var4 = var3.method2528();
            var1.field581 = var3.method2700();
            var1.field580 = var3.method2700();
            var1.field583 = var3.method2700();
            var1.field584 = var3.method2700();
            var3.field1976 = 0;
            var3.method2530();
            var1.field578 = new int[var4];
            var1.field579 = new int[var4];
            var1.field585 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field1976 < var3.field1980.length - 12; var1.field578[var5++] = var6) {
               var6 = var3.method2700();
               if(var6 == 3) {
                  var1.field585[var5] = var3.method2531();
               } else if(var6 < 100 && 21 != var6 && var6 != 38 && var6 != 39) {
                  var1.field579[var5] = var3.method2528();
               } else {
                  var1.field579[var5] = var3.method2523();
               }
            }

            class22.field582.method3756(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "-2125627777"
   )
   static final void method223(class37 var0) {
      var0.field838 = var0.field847;
      if(var0.field834 == 0) {
         var0.field832 = 0;
      } else {
         if(var0.field819 != -1 && var0.field822 == 0) {
            class42 var1 = class46.method974(var0.field819);
            if(var0.field811 > 0 && 0 == var1.field977) {
               ++var0.field832;
               return;
            }

            if(var0.field811 <= 0 && var1.field978 == 0) {
               ++var0.field832;
               return;
            }
         }

         int var10 = var0.field804;
         int var2 = var0.field814;
         int var3 = var0.field792 * 64 + var0.field842[var0.field834 - 1] * 128;
         int var4 = var0.field792 * 64 + 128 * var0.field843[var0.field834 - 1];
         if(var10 < var3) {
            if(var2 < var4) {
               var0.field793 = 1280;
            } else if(var2 > var4) {
               var0.field793 = 1792;
            } else {
               var0.field793 = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.field793 = 768;
            } else if(var2 > var4) {
               var0.field793 = 256;
            } else {
               var0.field793 = 512;
            }
         } else if(var2 < var4) {
            var0.field793 = 1024;
         } else if(var2 > var4) {
            var0.field793 = 0;
         }

         byte var5 = var0.field844[var0.field834 - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field793 - var0.field790 & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field829;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field796;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field799;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field798;
            }

            if(var7 == -1) {
               var7 = var0.field796;
            }

            var0.field838 = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof class34) {
               var9 = ((class34)var0).field755.field883;
            }

            if(var9) {
               if(var0.field793 != var0.field790 && var0.field845 == -1 && 0 != var0.field841) {
                  var8 = 2;
               }

               if(var0.field834 > 2) {
                  var8 = 6;
               }

               if(var0.field834 > 3) {
                  var8 = 8;
               }

               if(var0.field832 > 0 && var0.field834 > 1) {
                  var8 = 8;
                  --var0.field832;
               }
            } else {
               if(var0.field834 > 1) {
                  var8 = 6;
               }

               if(var0.field834 > 2) {
                  var8 = 8;
               }

               if(var0.field832 > 0 && var0.field834 > 1) {
                  var8 = 8;
                  --var0.field832;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.field796 == var0.field838 && -1 != var0.field797) {
               var0.field838 = var0.field797;
            }

            if(var3 != var10 || var4 != var2) {
               if(var10 < var3) {
                  var0.field804 += var8;
                  if(var0.field804 > var3) {
                     var0.field804 = var3;
                  }
               } else if(var10 > var3) {
                  var0.field804 -= var8;
                  if(var0.field804 < var3) {
                     var0.field804 = var3;
                  }
               }

               if(var2 < var4) {
                  var0.field814 += var8;
                  if(var0.field814 > var4) {
                     var0.field814 = var4;
                  }
               } else if(var2 > var4) {
                  var0.field814 -= var8;
                  if(var0.field814 < var4) {
                     var0.field814 = var4;
                  }
               }
            }

            if(var3 == var0.field804 && var0.field814 == var4) {
               --var0.field834;
               if(var0.field811 > 0) {
                  --var0.field811;
               }
            }

         } else {
            var0.field804 = var3;
            var0.field814 = var4;
            --var0.field834;
            if(var0.field811 > 0) {
               --var0.field811;
            }

         }
      }
   }
}
