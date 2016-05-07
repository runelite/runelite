import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
@Implements("PlayerComposition")
public class class179 {
   @ObfuscatedName("k")
   public static short[] field2933;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1733680033
   )
   public int field2934;
   @ObfuscatedName("t")
   static class193 field2935 = new class193(260);
   @ObfuscatedName("p")
   @Export("isFemale")
   public boolean field2936;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -931325731456578883L
   )
   long field2937;
   @ObfuscatedName("s")
   @Export("bodyParts")
   int[] field2938;
   @ObfuscatedName("j")
   @Export("bodyPartColours")
   int[] field2939;
   @ObfuscatedName("l")
   static final int[] field2940 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 2116916617669720697L
   )
   long field2941;
   @ObfuscatedName("pq")
   static class160 field2942;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "1304249758"
   )
   public void method3457(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class44.field1037; ++var6) {
               class44 var7 = class13.method168(var6);
               if(var7 != null && !var7.field1033 && var7.field1026 == (var3?7:0) + var5) {
                  var1[field2940[var5]] = 256 + var6;
                  break;
               }
            }
         }
      }

      this.field2938 = var1;
      this.field2939 = var2;
      this.field2936 = var3;
      this.field2934 = var4;
      this.method3462();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "1"
   )
   public void method3458(int var1, boolean var2) {
      if(1 != var1 || !this.field2936) {
         int var3 = this.field2938[field2940[var1]];
         if(var3 != 0) {
            var3 -= 256;

            class44 var4;
            do {
               ++var3;
               if(var3 >= class44.field1037) {
                  var3 = 0;
               }

               var4 = class13.method168(var3);
            } while(null == var4 || var4.field1033 || (this.field2936?7:0) + var1 != var4.field1026);

            this.field2938[field2940[var1]] = 256 + var3;
            this.method3462();
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "0"
   )
   public void method3460(boolean var1) {
      if(this.field2936 != var1) {
         this.method3457((int[])null, this.field2939, var1, -1);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-14"
   )
   void method3462() {
      long var1 = this.field2937;
      int var3 = this.field2938[5];
      int var4 = this.field2938[9];
      this.field2938[5] = var4;
      this.field2938[9] = var3;
      this.field2937 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2937 <<= 4;
         if(this.field2938[var5] >= 256) {
            this.field2937 += (long)(this.field2938[var5] - 256);
         }
      }

      if(this.field2938[0] >= 256) {
         this.field2937 += (long)(this.field2938[0] - 256 >> 4);
      }

      if(this.field2938[1] >= 256) {
         this.field2937 += (long)(this.field2938[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2937 <<= 3;
         this.field2937 += (long)this.field2939[var5];
      }

      this.field2937 <<= 1;
      this.field2937 += (long)(this.field2936?1:0);
      this.field2938[5] = var3;
      this.field2938[9] = var4;
      if(var1 != 0L && var1 != this.field2937) {
         field2935.method3742(var1);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass42;ILclass42;II)Lclass105;",
      garbageValue = "-1869931211"
   )
   public class105 method3463(class42 var1, int var2, class42 var3, int var4) {
      if(this.field2934 != -1) {
         return class99.method2179(this.field2934).method742(var1, var2, var3, var4);
      } else {
         long var5 = this.field2937;
         int[] var7 = this.field2938;
         if(var1 != null && (var1.field994 >= 0 || var1.field995 >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.field2938[var8];
            }

            if(var1.field994 >= 0) {
               var5 += (long)(var1.field994 - this.field2938[5] << 40);
               var7[5] = var1.field994;
            }

            if(var1.field995 >= 0) {
               var5 += (long)(var1.field995 - this.field2938[3] << 48);
               var7[3] = var1.field995;
            }
         }

         class105 var15 = (class105)field2935.method3743(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class13.method168(var11 - 256).method921()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class9.method128(var11 - 512).method1002(this.field2936)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2941) {
                  var15 = (class105)field2935.method3743(this.field2941);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(null == var15) {
               class100[] var17 = new class100[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  class100 var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class13.method168(var13 - 256).method899();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class9.method128(var13 - 512).method1003(this.field2936);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               class100 var18 = new class100(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2939[var13] < class166.field2673[var13].length) {
                     var18.method2194(class177.field2925[var13], class166.field2673[var13][this.field2939[var13]]);
                  }

                  if(this.field2939[var13] < class12.field190[var13].length) {
                     var18.method2194(field2933[var13], class12.field190[var13][this.field2939[var13]]);
                  }
               }

               var15 = var18.method2202(64, 850, -30, -50, -30);
               field2935.method3745(var15, var5);
               this.field2941 = var5;
            }
         }

         if(null == var1 && var3 == null) {
            return var15;
         } else {
            class105 var16;
            if(null != var1 && var3 != null) {
               var16 = var1.method844(var15, var2, var3, var4);
            } else if(null != var1) {
               var16 = var1.method841(var15, var2);
            } else {
               var16 = var3.method841(var15, var4);
            }

            return var16;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1"
   )
   public void method3466(int var1, boolean var2) {
      int var3 = this.field2939[var1];

      do {
         ++var3;
         if(var3 >= class166.field2673[var1].length) {
            var3 = 0;
         }
      } while(!class95.method2175(var1, var3));

      this.field2939[var1] = var3;
      this.method3462();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "72"
   )
   public static Class method3473(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-353236412"
   )
   public void method3479(class119 var1) {
      var1.method2477(this.field2936?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2938[field2940[var2]];
         if(var3 == 0) {
            var1.method2477(-1);
         } else {
            var1.method2477(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2477(this.field2939[var2]);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Lclass100;",
      garbageValue = "80"
   )
   class100 method3486() {
      if(this.field2934 != -1) {
         return class99.method2179(this.field2934).method743();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.field2938[var2];
            if(var3 >= 256 && var3 < 512 && !class13.method168(var3 - 256).method900()) {
               var1 = true;
            }

            if(var3 >= 512 && !class9.method128(var3 - 512).method1004(this.field2936)) {
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
               var5 = this.field2938[var4];
               class100 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class13.method168(var5 - 256).method919();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class9.method128(var5 - 512).method1006(this.field2936);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            class100 var8 = new class100(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2939[var5] < class166.field2673[var5].length) {
                  var8.method2194(class177.field2925[var5], class166.field2673[var5][this.field2939[var5]]);
               }

               if(this.field2939[var5] < class12.field190[var5].length) {
                  var8.method2194(field2933[var5], class12.field190[var5][this.field2939[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method3491() {
      return this.field2934 == -1?(this.field2939[4] << 20) + (this.field2939[0] << 25) + (this.field2938[0] << 15) + (this.field2938[8] << 10) + (this.field2938[11] << 5) + this.field2938[1]:305419896 + class99.method2179(this.field2934).field886;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lclass43;",
      garbageValue = "441557509"
   )
   public static class43 method3492(int var0) {
      class43 var1 = (class43)class43.field1019.method3743((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class43.field1002.method3239(13, var0);
         var1 = new class43();
         var1.field1015 = var0;
         if(var2 != null) {
            var1.method894(new class119(var2));
         }

         class43.field1019.method3745(var1, (long)var0);
         return var1;
      }
   }
}
