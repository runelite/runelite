import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("PlayerComposition")
public class class182 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 3967383615916924711L
   )
   @Export("hash")
   long field2962;
   @ObfuscatedName("w")
   @Export("bodyPartColours")
   int[] field2963;
   @ObfuscatedName("y")
   static int[] field2964;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -5239073219834575449L
   )
   long field2965;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1913378089
   )
   public int field2966;
   @ObfuscatedName("bm")
   static class171 field2967;
   @ObfuscatedName("j")
   public static short[] field2968;
   @ObfuscatedName("r")
   public static short[][] field2969;
   @ObfuscatedName("v")
   static final int[] field2970 = new int[]{8, 11, 4, 6, 9, 7, 10};
   @ObfuscatedName("h")
   public static class196 field2971 = new class196(260);
   @ObfuscatedName("e")
   @Export("isFemale")
   public boolean field2974;
   @ObfuscatedName("m")
   @Export("bodyParts")
   int[] field2975;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1284326377"
   )
   public void method3535(int var1, boolean var2) {
      if(var1 != 1 || !this.field2974) {
         int var3 = this.field2975[field2970[var1]];
         if(var3 != 0) {
            var3 -= 256;

            class46 var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = class46.field1058 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= class46.field1058) {
                     var3 = 0;
                  }
               }

               var4 = class178.method3502(var3);
            } while(null == var4 || var4.field1055 || var1 + (this.field2974?7:0) != var4.field1048);

            this.field2975[field2970[var1]] = 256 + var3;
            this.method3541();
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([I[IZIB)V",
      garbageValue = "-14"
   )
   public void method3536(int[] var1, int[] var2, boolean var3, int var4) {
      if(null == var1) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < class46.field1058; ++var6) {
               class46 var7 = class178.method3502(var6);
               if(null != var7 && !var7.field1055 && var5 + (var3?7:0) == var7.field1048) {
                  var1[field2970[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.field2975 = var1;
      this.field2963 = var2;
      this.field2974 = var3;
      this.field2966 = var4;
      this.method3541();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1700452709"
   )
   public void method3538(boolean var1) {
      if(var1 != this.field2974) {
         this.method3536((int[])null, this.field2963, var1, -1);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "71"
   )
   void method3541() {
      long var1 = this.field2962;
      int var3 = this.field2975[5];
      int var4 = this.field2975[9];
      this.field2975[5] = var4;
      this.field2975[9] = var3;
      this.field2962 = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.field2962 <<= 4;
         if(this.field2975[var5] >= 256) {
            this.field2962 += (long)(this.field2975[var5] - 256);
         }
      }

      if(this.field2975[0] >= 256) {
         this.field2962 += (long)(this.field2975[0] - 256 >> 4);
      }

      if(this.field2975[1] >= 256) {
         this.field2962 += (long)(this.field2975[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.field2962 <<= 3;
         this.field2962 += (long)this.field2963[var5];
      }

      this.field2962 <<= 1;
      this.field2962 += (long)(this.field2974?1:0);
      this.field2975[5] = var3;
      this.field2975[9] = var4;
      if(var1 != 0L && var1 != this.field2962) {
         field2971.method3813(var1);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass44;ILclass44;II)Lclass108;",
      garbageValue = "519581565"
   )
   public class108 method3542(class44 var1, int var2, class44 var3, int var4) {
      if(this.field2966 != -1) {
         return class1.method7(this.field2966).method795(var1, var2, var3, var4);
      } else {
         long var5 = this.field2962;
         int[] var7 = this.field2975;
         if(null != var1 && (var1.field1017 >= 0 || var1.field1018 >= 0)) {
            var7 = new int[12];

            for(int var15 = 0; var15 < 12; ++var15) {
               var7[var15] = this.field2975[var15];
            }

            if(var1.field1017 >= 0) {
               var5 += (long)(var1.field1017 - this.field2975[5] << 40);
               var7[5] = var1.field1017;
            }

            if(var1.field1018 >= 0) {
               var5 += (long)(var1.field1018 - this.field2975[3] << 48);
               var7[3] = var1.field1018;
            }
         }

         class108 var8 = (class108)field2971.method3817(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !class178.method3502(var11 - 256).method959()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class4.method42(var11 - 512).method1160(this.field2974)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2965) {
                  var8 = (class108)field2971.method3817(this.field2965);
               }

               if(null == var8) {
                  return null;
               }
            }

            if(null == var8) {
               class103[] var17 = new class103[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  class103 var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class178.method3502(var13 - 256).method963();
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class4.method42(var13 - 512).method1162(this.field2974);
                     if(var14 != null) {
                        var17[var11++] = var14;
                     }
                  }
               }

               class103 var16 = new class103(var17, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.field2963[var13] < field2969[var13].length) {
                     var16.method2317(field2968[var13], field2969[var13][this.field2963[var13]]);
                  }

                  if(this.field2963[var13] < class17.field225[var13].length) {
                     var16.method2317(class50.field1111[var13], class17.field225[var13][this.field2963[var13]]);
                  }
               }

               var8 = var16.method2305(64, 850, -30, -50, -30);
               field2971.method3823(var8, var5);
               this.field2965 = var5;
            }
         }

         if(null == var1 && null == var3) {
            return var8;
         } else {
            class108 var18;
            if(var1 != null && null != var3) {
               var18 = var1.method906(var8, var2, var3, var4);
            } else if(null != var1) {
               var18 = var1.method910(var8, var2);
            } else {
               var18 = var3.method910(var8, var4);
            }

            return var18;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lclass103;",
      garbageValue = "1354333448"
   )
   class103 method3543() {
      if(this.field2966 != -1) {
         return class1.method7(this.field2966).method814();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.field2975[var2];
            if(var3 >= 256 && var3 < 512 && !class178.method3502(var3 - 256).method965()) {
               var1 = true;
            }

            if(var3 >= 512 && !class4.method42(var3 - 512).method1144(this.field2974)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            class103[] var8 = new class103[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.field2975[var4];
               class103 var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class178.method3502(var5 - 256).method967();
                  if(null != var6) {
                     var8[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class4.method42(var5 - 512).method1145(this.field2974);
                  if(null != var6) {
                     var8[var3++] = var6;
                  }
               }
            }

            class103 var7 = new class103(var8, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.field2963[var5] < field2969[var5].length) {
                  var7.method2317(field2968[var5], field2969[var5][this.field2963[var5]]);
               }

               if(this.field2963[var5] < class17.field225[var5].length) {
                  var7.method2317(class50.field1111[var5], class17.field225[var5][this.field2963[var5]]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "360984248"
   )
   public int method3544() {
      return this.field2966 == -1?(this.field2963[0] << 25) + (this.field2963[4] << 20) + (this.field2975[0] << 15) + (this.field2975[8] << 10) + (this.field2975[11] << 5) + this.field2975[1]:305419896 + class1.method7(this.field2966).field908;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "2078708308"
   )
   public void method3556(int var1, boolean var2) {
      int var3 = this.field2963[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = field2969[var1].length - 1;
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
            if(var3 >= field2969[var1].length) {
               var3 = 0;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      }

      this.field2963[var1] = var3;
      this.method3541();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "-78"
   )
   public void method3564(class122 var1) {
      var1.method2557(this.field2974?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.field2975[field2970[var2]];
         if(var3 == 0) {
            var1.method2557(-1);
         } else {
            var1.method2557(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.method2557(this.field2963[var2]);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "1141078865"
   )
   public static String method3566(int var0, boolean var1) {
      return var1 && var0 >= 0?class190.method3799(var0, 10, var1):Integer.toString(var0);
   }
}
