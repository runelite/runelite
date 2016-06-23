import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
@Implements("PlayerComposition")
public class class179 {
   @ObfuscatedName("f")
   @Export("bodyParts")
   int[] field2913;
   @ObfuscatedName("u")
   @Export("bodyPartColours")
   int[] field2914;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 4617173534606938273L
   )
   long field2915;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -455366875
   )
   public int field2916;
   @ObfuscatedName("x")
   @Export("isFemale")
   public boolean field2917;
   @ObfuscatedName("r")
   static final int[] field2918 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("n")
   public static short[] field2919;
   @ObfuscatedName("s")
   public static short[][] field2920;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 895392655579139253L
   )
   @Export("hash")
   long field2921;
   @ObfuscatedName("k")
   static class193 field2922 = new class193(260);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1300788851"
   )
   void method3507() {
      long var1 = this.field2921;
      int var3 = this.field2913[5];
      int var4 = this.field2913[9];
      this.field2913[5] = var4;
      this.field2913[9] = var3;
      this.field2921 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2921 <<= 4;
         if(this.field2913[var5] >= 256) {
            this.field2921 += (long)(this.field2913[var5] - 256);
         }
      }

      if(this.field2913[0] >= 256) {
         this.field2921 += (long)(this.field2913[0] - 256 >> 4);
      }

      if(this.field2913[1] >= 256) {
         this.field2921 += (long)(this.field2913[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2921 <<= 3;
         this.field2921 += (long)this.field2914[var5];
      }

      this.field2921 <<= 1;
      this.field2921 += (long)(this.field2917?1:0);
      this.field2913[5] = var3;
      this.field2913[9] = var4;
      if(0L != var1 && this.field2921 != var1) {
         field2922.method3789(var1);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "897098112"
   )
   public void method3508(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class217.field3162; ++var6) {
               class44 var7 = class28.method697(var6);
               if(var7 != null && !var7.field1049 && var7.field1042 == var5 + (var3?7:0)) {
                  var1[field2918[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.field2913 = var1;
      this.field2914 = var2;
      this.field2917 = var3;
      this.field2916 = var4;
      this.method3507();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1724238152"
   )
   public void method3510(int var1, boolean var2) {
      int var3 = this.field2914[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class169.field2701[var1].length - 1;
            }
         } while(!class93.method2226(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= class169.field2701[var1].length) {
               var3 = 0;
            }
         } while(!class93.method2226(var1, var3));
      }

      this.field2914[var1] = var3;
      this.method3507();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "3"
   )
   public void method3511(boolean var1) {
      if(var1 != this.field2917) {
         this.method3508((int[])null, this.field2914, var1, -1);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-2024759025"
   )
   public void method3512(class119 var1) {
      var1.method2654(this.field2917?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2913[field2918[var2]];
         if(var3 == 0) {
            var1.method2654(-1);
         } else {
            var1.method2654(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2654(this.field2914[var2]);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass42;ILclass42;II)Lclass105;",
      garbageValue = "-821067021"
   )
   public class105 method3514(class42 var1, int var2, class42 var3, int var4) {
      if(this.field2916 != -1) {
         return class172.method3424(this.field2916).method811(var1, var2, var3, var4);
      } else {
         long var5 = this.field2921;
         int[] var7 = this.field2913;
         if(null != var1 && (var1.field1010 >= 0 || var1.field1006 >= 0)) {
            var7 = new int[12];

            for(int var15 = 0; var15 < 12; ++var15) {
               var7[var15] = this.field2913[var15];
            }

            if(var1.field1010 >= 0) {
               var5 += (long)(var1.field1010 - this.field2913[5] << 40);
               var7[5] = var1.field1010;
            }

            if(var1.field1006 >= 0) {
               var5 += (long)(var1.field1006 - this.field2913[3] << 48);
               var7[3] = var1.field1006;
            }
         }

         class105 var8 = (class105)field2922.method3797(var5);
         if(null == var8) {
            boolean var16 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class28.method697(var11 - 256).method981()) {
                  var16 = true;
               }

               if(var11 >= 512 && !class141.method3001(var11 - 512).method1084(this.field2917)) {
                  var16 = true;
               }
            }

            if(var16) {
               if(this.field2915 != -1L) {
                  var8 = (class105)field2922.method3797(this.field2915);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(null == var8) {
               class100[] var17 = new class100[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  class100 var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class28.method697(var13 - 256).method959();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class141.method3001(var13 - 512).method1115(this.field2917);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               class100 var18 = new class100(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2914[var13] < class169.field2701[var13].length) {
                     var18.method2341(field2919[var13], class169.field2701[var13][this.field2914[var13]]);
                  }

                  if(this.field2914[var13] < field2920[var13].length) {
                     var18.method2341(class95.field1620[var13], field2920[var13][this.field2914[var13]]);
                  }
               }

               var8 = var18.method2290(64, 850, -30, -50, -30);
               field2922.method3788(var8, var5);
               this.field2915 = var5;
            }
         }

         if(var1 == null && null == var3) {
            return var8;
         } else {
            class105 var9;
            if(var1 != null && null != var3) {
               var9 = var1.method905(var8, var2, var3, var4);
            } else if(null != var1) {
               var9 = var1.method928(var8, var2);
            } else {
               var9 = var3.method928(var8, var4);
            }

            return var9;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1657770595"
   )
   public int method3516() {
      return this.field2916 == -1?(this.field2913[8] << 10) + (this.field2913[0] << 15) + (this.field2914[4] << 20) + (this.field2914[0] << 25) + (this.field2913[11] << 5) + this.field2913[1]:305419896 + class172.method3424(this.field2916).field899;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-2014404215"
   )
   public void method3521(int var1, boolean var2) {
      if(var1 != 1 || !this.field2917) {
         int var3 = this.field2913[field2918[var1]];
         if(var3 != 0) {
            var3 -= 256;

            class44 var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class217.field3162 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class217.field3162) {
                     var3 = 0;
                  }
               }

               var4 = class28.method697(var3);
            } while(var4 == null || var4.field1049 || (this.field2917?7:0) + var1 != var4.field1042);

            this.field2913[field2918[var1]] = var3 + 256;
            this.method3507();
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Lclass100;",
      garbageValue = "-78"
   )
   class100 method3538() {
      if(this.field2916 != -1) {
         return class172.method3424(this.field2916).method812();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.field2913[var2];
            if(var3 >= 256 && var3 < 512 && !class28.method697(var3 - 256).method975()) {
               var1 = true;
            }

            if(var3 >= 512 && !class141.method3001(var3 - 512).method1100(this.field2917)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class100[] var7 = new class100[12];
            var3 = 0;

            int var5;
            for(int var8 = 0; var8 < 12; ++var8) {
               var5 = this.field2913[var8];
               class100 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class28.method697(var5 - 256).method961();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class141.method3001(var5 - 512).method1099(this.field2917);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            class100 var4 = new class100(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2914[var5] < class169.field2701[var5].length) {
                  var4.method2341(field2919[var5], class169.field2701[var5][this.field2914[var5]]);
               }

               if(this.field2914[var5] < field2920[var5].length) {
                  var4.method2341(class95.field1620[var5], field2920[var5][this.field2914[var5]]);
               }
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Lclass49;",
      garbageValue = "2109117052"
   )
   public static class49 method3547(int var0) {
      class49 var1 = (class49)class49.field1100.method3797((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class49.field1106.method3286(15, var0);
         var1 = new class49();
         if(null != var2) {
            var1.method1059(new class119(var2));
         }

         class49.field1100.method3788(var1, (long)var0);
         return var1;
      }
   }
}
