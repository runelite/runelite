import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
@Implements("PlayerComposition")
public class class179 {
   @ObfuscatedName("z")
   static final int[] field2925 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("t")
   @Export("isFemale")
   public boolean field2927;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1711296531
   )
   public int field2928;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -2444051769594910649L
   )
   long field2929;
   @ObfuscatedName("w")
   @Export("bodyParts")
   int[] field2930;
   @ObfuscatedName("x")
   @Export("bodyPartColours")
   int[] field2931;
   @ObfuscatedName("v")
   public static short[] field2932;
   @ObfuscatedName("s")
   static class193 field2933 = new class193(260);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -8831607610798601007L
   )
   long field2934;

   @ObfuscatedName("v")
   public int method3490() {
      return this.field2928 == -1?(this.field2930[8] << 10) + (this.field2931[4] << 20) + (this.field2931[0] << 25) + (this.field2930[0] << 15) + (this.field2930[11] << 5) + this.field2930[1]:305419896 + class36.method759(this.field2928).field889;
   }

   @ObfuscatedName("w")
   public void method3491(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class44.field1041; ++var6) {
               class44 var7 = class10.method131(var6);
               if(null != var7 && !var7.field1043 && var7.field1036 == var5 + (var3?7:0)) {
                  var1[field2925[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.field2930 = var1;
      this.field2931 = var2;
      this.field2927 = var3;
      this.field2928 = var4;
      this.method3503();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1608352680"
   )
   public void method3493(int var1, boolean var2) {
      int var3 = this.field2931[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class20.field584[var1].length - 1;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      } else {
         do {
            ++var3;
            if(var3 >= class20.field584[var1].length) {
               var3 = 0;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      }

      this.field2931[var1] = var3;
      this.method3503();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "647429819"
   )
   public void method3494(boolean var1) {
      if(this.field2927 != var1) {
         this.method3491((int[])null, this.field2931, var1, -1);
      }
   }

   @ObfuscatedName("m")
   public class105 method3497(class42 var1, int var2, class42 var3, int var4) {
      if(-1 != this.field2928) {
         return class36.method759(this.field2928).method792(var1, var2, var3, var4);
      } else {
         long var5 = this.field2929;
         int[] var7 = this.field2930;
         if(null != var1 && (var1.field996 >= 0 || var1.field1000 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.field2930[var8];
            }

            if(var1.field996 >= 0) {
               var5 += (long)(var1.field996 - this.field2930[5] << 40);
               var7[5] = var1.field996;
            }

            if(var1.field1000 >= 0) {
               var5 += (long)(var1.field1000 - this.field2930[3] << 48);
               var7[3] = var1.field1000;
            }
         }

         class105 var15 = (class105)field2933.method3771(var5);
         if(null == var15) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class10.method131(var11 - 256).method955()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class50.method1055(var11 - 512).method1085(this.field2927)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2934 != -1L) {
                  var15 = (class105)field2933.method3771(this.field2934);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(var15 == null) {
               class100[] var17 = new class100[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  class100 var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class10.method131(var13 - 256).method963();
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class50.method1055(var13 - 512).method1069(this.field2927);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               class100 var18 = new class100(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2931[var13] < class20.field584[var13].length) {
                     var18.method2238(class34.field787[var13], class20.field584[var13][this.field2931[var13]]);
                  }

                  if(this.field2931[var13] < class109.field1920[var13].length) {
                     var18.method2238(field2932[var13], class109.field1920[var13][this.field2931[var13]]);
                  }
               }

               var15 = var18.method2212(64, 850, -30, -50, -30);
               field2933.method3773(var15, var5);
               this.field2934 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            class105 var16;
            if(null != var1 && var3 != null) {
               var16 = var1.method909(var15, var2, var3, var4);
            } else if(null != var1) {
               var16 = var1.method902(var15, var2);
            } else {
               var16 = var3.method902(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1911355622"
   )
   void method3503() {
      long var1 = this.field2929;
      int var3 = this.field2930[5];
      int var4 = this.field2930[9];
      this.field2930[5] = var4;
      this.field2930[9] = var3;
      this.field2929 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2929 <<= 4;
         if(this.field2930[var5] >= 256) {
            this.field2929 += (long)(this.field2930[var5] - 256);
         }
      }

      if(this.field2930[0] >= 256) {
         this.field2929 += (long)(this.field2930[0] - 256 >> 4);
      }

      if(this.field2930[1] >= 256) {
         this.field2929 += (long)(this.field2930[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2929 <<= 3;
         this.field2929 += (long)this.field2931[var5];
      }

      this.field2929 <<= 1;
      this.field2929 += (long)(this.field2927?1:0);
      this.field2930[5] = var3;
      this.field2930[9] = var4;
      if(0L != var1 && this.field2929 != var1) {
         field2933.method3770(var1);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-905305271"
   )
   public void method3506(class119 var1) {
      var1.method2573(this.field2927?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2930[field2925[var2]];
         if(0 == var3) {
            var1.method2573(-1);
         } else {
            var1.method2573(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2573(this.field2931[var2]);
      }

   }

   @ObfuscatedName("c")
   class100 method3526() {
      if(this.field2928 != -1) {
         return class36.method759(this.field2928).method809();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.field2930[var2];
            if(var3 >= 256 && var3 < 512 && !class10.method131(var3 - 256).method952()) {
               var1 = true;
            }

            if(var3 >= 512 && !class50.method1055(var3 - 512).method1070(this.field2927)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class100[] var7 = new class100[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.field2930[var4];
               class100 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class10.method131(var5 - 256).method958();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class50.method1055(var5 - 512).method1072(this.field2927);
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }
            }

            class100 var8 = new class100(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2931[var5] < class20.field584[var5].length) {
                  var8.method2238(class34.field787[var5], class20.field584[var5][this.field2931[var5]]);
               }

               if(this.field2931[var5] < class109.field1920[var5].length) {
                  var8.method2238(field2932[var5], class109.field1920[var5][this.field2931[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1650573773"
   )
   public void method3528(int var1, boolean var2) {
      if(1 != var1 || !this.field2927) {
         int var3 = this.field2930[field2925[var1]];
         if(var3 != 0) {
            var3 -= 256;

            class44 var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class44.field1041 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class44.field1041) {
                     var3 = 0;
                  }
               }

               var4 = class10.method131(var3);
            } while(null == var4 || var4.field1043 || (this.field2927?7:0) + var1 != var4.field1036);

            this.field2930[field2925[var1]] = var3 + 256;
            this.method3503();
         }
      }
   }
}
