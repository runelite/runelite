import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
@Implements("PlayerComposition")
public class class179 {
   @ObfuscatedName("w")
   @Export("bodyPartColours")
   int[] field2917;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -6722378192716411211L
   )
   long field2918;
   @ObfuscatedName("m")
   static final int[] field2919 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("f")
   @Export("isFemale")
   public boolean field2921;
   @ObfuscatedName("g")
   public static short[] field2922;
   @ObfuscatedName("a")
   public static short[][] field2923;
   @ObfuscatedName("e")
   @Export("bodyParts")
   int[] field2924;
   @ObfuscatedName("n")
   public static class193 field2925 = new class193(260);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 3212731627187997521L
   )
   long field2927;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2026250789
   )
   public int field2928;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IZS)V",
      garbageValue = "-8527"
   )
   public void method3465(int var1, boolean var2) {
      int var3 = this.field2917[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = field2923[var1].length - 1;
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
            if(var3 >= field2923[var1].length) {
               var3 = 0;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      }

      this.field2917[var1] = var3;
      this.method3468();
   }

   @ObfuscatedName("a")
   class100 method3466() {
      if(-1 != this.field2928) {
         return class172.method3370(this.field2928).method764();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.field2924[var2];
            if(var3 >= 256 && var3 < 512 && !class3.method42(var3 - 256).method924()) {
               var1 = true;
            }

            if(var3 >= 512 && !class33.method711(var3 - 512).method1023(this.field2921)) {
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
               var5 = this.field2924[var4];
               class100 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class3.method42(var5 - 256).method925();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class33.method711(var5 - 512).method1026(this.field2921);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            class100 var8 = new class100(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2917[var5] < field2923[var5].length) {
                  var8.method2234(field2922[var5], field2923[var5][this.field2917[var5]]);
               }

               if(this.field2917[var5] < class84.field1433[var5].length) {
                  var8.method2234(class174.field2894[var5], class84.field1433[var5][this.field2917[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("h")
   void method3468() {
      long var1 = this.field2918;
      int var3 = this.field2924[5];
      int var4 = this.field2924[9];
      this.field2924[5] = var4;
      this.field2924[9] = var3;
      this.field2918 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2918 <<= 4;
         if(this.field2924[var5] >= 256) {
            this.field2918 += (long)(this.field2924[var5] - 256);
         }
      }

      if(this.field2924[0] >= 256) {
         this.field2918 += (long)(this.field2924[0] - 256 >> 4);
      }

      if(this.field2924[1] >= 256) {
         this.field2918 += (long)(this.field2924[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2918 <<= 3;
         this.field2918 += (long)this.field2917[var5];
      }

      this.field2918 <<= 1;
      this.field2918 += (long)(this.field2921?1:0);
      this.field2924[5] = var3;
      this.field2924[9] = var4;
      if(0L != var1 && this.field2918 != var1) {
         field2925.method3755(var1);
      }

   }

   @ObfuscatedName("g")
   public class105 method3469(class42 var1, int var2, class42 var3, int var4) {
      if(this.field2928 != -1) {
         return class172.method3370(this.field2928).method760(var1, var2, var3, var4);
      } else {
         long var5 = this.field2918;
         int[] var7 = this.field2924;
         if(var1 != null && (var1.field974 >= 0 || var1.field966 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.field2924[var8];
            }

            if(var1.field974 >= 0) {
               var5 += (long)(var1.field974 - this.field2924[5] << 40);
               var7[5] = var1.field974;
            }

            if(var1.field966 >= 0) {
               var5 += (long)(var1.field966 - this.field2924[3] << 48);
               var7[3] = var1.field966;
            }
         }

         class105 var15 = (class105)field2925.method3754(var5);
         if(null == var15) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class3.method42(var11 - 256).method936()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class33.method711(var11 - 512).method1046(this.field2921)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2927 != -1L) {
                  var15 = (class105)field2925.method3754(this.field2927);
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
                     var14 = class3.method42(var13 - 256).method923();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class33.method711(var13 - 512).method1024(this.field2921);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               class100 var18 = new class100(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2917[var13] < field2923[var13].length) {
                     var18.method2234(field2922[var13], field2923[var13][this.field2917[var13]]);
                  }

                  if(this.field2917[var13] < class84.field1433[var13].length) {
                     var18.method2234(class174.field2894[var13], class84.field1433[var13][this.field2917[var13]]);
                  }
               }

               var15 = var18.method2236(64, 850, -30, -50, -30);
               field2925.method3756(var15, var5);
               this.field2927 = var5;
            }
         }

         if(null == var1 && var3 == null) {
            return var15;
         } else {
            class105 var16;
            if(var1 != null && var3 != null) {
               var16 = var1.method868(var15, var2, var3, var4);
            } else if(null != var1) {
               var16 = var1.method897(var15, var2);
            } else {
               var16 = var3.method897(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("r")
   public int method3471() {
      return -1 == this.field2928?(this.field2924[0] << 15) + (this.field2917[4] << 20) + (this.field2917[0] << 25) + (this.field2924[8] << 10) + (this.field2924[11] << 5) + this.field2924[1]:305419896 + class172.method3370(this.field2928).field882;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-1171371472"
   )
   public void method3472(int var1, boolean var2) {
      if(var1 != 1 || !this.field2921) {
         int var3 = this.field2924[field2919[var1]];
         if(var3 != 0) {
            var3 -= 256;

            class44 var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class44.field1002 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class44.field1002) {
                     var3 = 0;
                  }
               }

               var4 = class3.method42(var3);
            } while(null == var4 || var4.field1006 || var4.field1004 != (this.field2921?7:0) + var1);

            this.field2924[field2919[var1]] = var3 + 256;
            this.method3468();
         }
      }
   }

   @ObfuscatedName("s")
   public void method3488(boolean var1) {
      if(var1 != this.field2921) {
         this.method3493((int[])null, this.field2917, var1, -1);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([I[IZIB)V",
      garbageValue = "-104"
   )
   public void method3493(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class44.field1002; ++var6) {
               class44 var7 = class3.method42(var6);
               if(null != var7 && !var7.field1006 && var7.field1004 == (var3?7:0) + var5) {
                  var1[field2919[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.field2924 = var1;
      this.field2917 = var2;
      this.field2921 = var3;
      this.field2928 = var4;
      this.method3468();
   }

   @ObfuscatedName("p")
   public void method3496(class119 var1) {
      var1.method2565(this.field2921?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2924[field2919[var2]];
         if(var3 == 0) {
            var1.method2565(-1);
         } else {
            var1.method2565(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2565(this.field2917[var2]);
      }

   }
}
