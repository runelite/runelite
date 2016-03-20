import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("PlayerComposition")
public class class178 {
   @ObfuscatedName("a")
   @Export("bodyParts")
   int[] field2902;
   @ObfuscatedName("r")
   @Export("bodyPartColours")
   int[] field2903;
   @ObfuscatedName("f")
   @Export("isFemale")
   public boolean field2904;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -395747915
   )
   public int field2905;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -5898648102527436647L
   )
   long field2906;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 8019606249543235239L
   )
   long field2907;
   @ObfuscatedName("j")
   public static short[] field2908;
   @ObfuscatedName("l")
   static final int[] field2909 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("cz")
   static class142 field2912;
   @ObfuscatedName("h")
   static class192 field2913 = new class192(260);
   @ObfuscatedName("n")
   public static short[][] field2914;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([I[IZIB)V",
      garbageValue = "-38"
   )
   public void method3496(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class44.field1027; ++var6) {
               class44 var7 = class32.method711(var6);
               if(null != var7 && !var7.field1036 && var7.field1029 == (var3?7:0) + var5) {
                  var1[field2909[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.field2902 = var1;
      this.field2903 = var2;
      this.field2904 = var3;
      this.field2905 = var4;
      this.method3501();
   }

   @ObfuscatedName("s")
   public void method3497(boolean var1) {
      if(var1 != this.field2904) {
         this.method3496((int[])null, this.field2903, var1, -1);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "6"
   )
   public void method3498(int var1, boolean var2) {
      int var3 = this.field2903[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class123.field2027[var1].length - 1;
            }

            if(4 == var1 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      } else {
         do {
            ++var3;
            if(var3 >= class123.field2027[var1].length) {
               var3 = 0;
            }

            if(4 == var1 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      }

      this.field2903[var1] = var3;
      this.method3501();
   }

   @ObfuscatedName("y")
   public void method3500(class118 var1) {
      var1.method2497(this.field2904?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2902[field2909[var2]];
         if(0 == var3) {
            var1.method2497(-1);
         } else {
            var1.method2497(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2497(this.field2903[var2]);
      }

   }

   @ObfuscatedName("e")
   void method3501() {
      long var1 = this.field2906;
      int var3 = this.field2902[5];
      int var4 = this.field2902[9];
      this.field2902[5] = var4;
      this.field2902[9] = var3;
      this.field2906 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2906 <<= 4;
         if(this.field2902[var5] >= 256) {
            this.field2906 += (long)(this.field2902[var5] - 256);
         }
      }

      if(this.field2902[0] >= 256) {
         this.field2906 += (long)(this.field2902[0] - 256 >> 4);
      }

      if(this.field2902[1] >= 256) {
         this.field2906 += (long)(this.field2902[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2906 <<= 3;
         this.field2906 += (long)this.field2903[var5];
      }

      this.field2906 <<= 1;
      this.field2906 += (long)(this.field2904?1:0);
      this.field2902[5] = var3;
      this.field2902[9] = var4;
      if(var1 != 0L && this.field2906 != var1) {
         field2913.method3793(var1);
      }

   }

   @ObfuscatedName("g")
   public class104 method3502(class42 var1, int var2, class42 var3, int var4) {
      if(-1 != this.field2905) {
         return class23.method593(this.field2905).method772(var1, var2, var3, var4);
      } else {
         long var5 = this.field2906;
         int[] var7 = this.field2902;
         if(null != var1 && (var1.field996 >= 0 || var1.field995 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.field2902[var8];
            }

            if(var1.field996 >= 0) {
               var5 += (long)(var1.field996 - this.field2902[5] << 40);
               var7[5] = var1.field996;
            }

            if(var1.field995 >= 0) {
               var5 += (long)(var1.field995 - this.field2902[3] << 48);
               var7[3] = var1.field995;
            }
         }

         class104 var15 = (class104)field2913.method3792(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class32.method711(var11 - 256).method930()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class75.method1648(var11 - 512).method1050(this.field2904)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2907) {
                  var15 = (class104)field2913.method3792(this.field2907);
               }

               if(null == var15) {
                  return null;
               }
            }

            if(null == var15) {
               class99[] var17 = new class99[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  class99 var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class32.method711(var13 - 256).method941();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class75.method1648(var13 - 512).method1051(this.field2904);
                     if(null != var14) {
                        var17[var11++] = var14;
                     }
                  }
               }

               class99 var18 = new class99(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2903[var13] < class123.field2027[var13].length) {
                     var18.method2254(class106.field1865[var13], class123.field2027[var13][this.field2903[var13]]);
                  }

                  if(this.field2903[var13] < field2914[var13].length) {
                     var18.method2254(field2908[var13], field2914[var13][this.field2903[var13]]);
                  }
               }

               var15 = var18.method2239(64, 850, -30, -50, -30);
               field2913.method3794(var15, var5);
               this.field2907 = var5;
            }
         }

         if(null == var1 && null == var3) {
            return var15;
         } else {
            class104 var16;
            if(null != var1 && null != var3) {
               var16 = var1.method903(var15, var2, var3, var4);
            } else if(null != var1) {
               var16 = var1.method873(var15, var2);
            } else {
               var16 = var3.method873(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("m")
   class99 method3503() {
      if(-1 != this.field2905) {
         return class23.method593(this.field2905).method770();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.field2902[var2];
            if(var3 >= 256 && var3 < 512 && !class32.method711(var3 - 256).method932()) {
               var1 = true;
            }

            if(var3 >= 512 && !class75.method1648(var3 - 512).method1052(this.field2904)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class99[] var7 = new class99[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.field2902[var4];
               class99 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class32.method711(var5 - 256).method955();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class75.method1648(var5 - 512).method1053(this.field2904);
                  if(null != var6) {
                     var7[var3++] = var6;
                  }
               }
            }

            class99 var8 = new class99(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2903[var5] < class123.field2027[var5].length) {
                  var8.method2254(class106.field1865[var5], class123.field2027[var5][this.field2903[var5]]);
               }

               if(this.field2903[var5] < field2914[var5].length) {
                  var8.method2254(field2908[var5], field2914[var5][this.field2903[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "-91"
   )
   public void method3504(int var1, boolean var2) {
      if(var1 != 1 || !this.field2904) {
         int var3 = this.field2902[field2909[var1]];
         if(var3 != 0) {
            var3 -= 256;

            class44 var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class44.field1027 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class44.field1027) {
                     var3 = 0;
                  }
               }

               var4 = class32.method711(var3);
            } while(null == var4 || var4.field1036 || (this.field2904?7:0) + var1 != var4.field1029);

            this.field2902[field2909[var1]] = var3 + 256;
            this.method3501();
         }
      }
   }

   @ObfuscatedName("j")
   public int method3521() {
      return -1 == this.field2905?this.field2902[1] + (this.field2902[11] << 5) + (this.field2902[0] << 15) + (this.field2903[4] << 20) + (this.field2903[0] << 25) + (this.field2902[8] << 10):305419896 + class23.method593(this.field2905).field911;
   }
}
