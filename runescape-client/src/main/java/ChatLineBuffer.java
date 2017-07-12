import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1955426599
   )
   static int field1576;
   @ObfuscatedName("w")
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1927124027
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "-10822076"
   )
   MessageNode method1885(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.unlinkDual();
         var5.method1146(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "-90822970"
   )
   MessageNode method1876(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1004961095"
   )
   int method1882() {
      return this.length;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass186;III)I",
      garbageValue = "262581773"
   )
   static int method1884(class186 var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         WidgetConfig var3 = (WidgetConfig)var0.method3478((long)var1);
         return var3 == null?var2:var3.config;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1054425953"
   )
   static int method1877(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILclass163;LCollisionData;Z[I[II)I",
      garbageValue = "-996276063"
   )
   public static int method1883(int var0, int var1, int var2, class163 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class162.field2315[var8][var9] = 0;
            class162.field2316[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var12;
      byte var13;
      int var14;
      int var15;
      byte var16;
      int var17;
      int[][] var18;
      int var19;
      int var20;
      int var21;
      boolean var28;
      boolean var29;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class162.field2315[var12][var13] = 99;
         class162.field2316[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class162.field2318[var16] = var0;
         var33 = var16 + 1;
         class162.field2319[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var17 == var33) {
               class267.field3678 = var10;
               class162.field2313 = var11;
               var29 = false;
               break;
            }

            var10 = class162.field2318[var17];
            var11 = class162.field2319[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod3051(1, var10, var11, var4)) {
               class267.field3678 = var10;
               class162.field2313 = var11;
               var29 = true;
               break;
            }

            var21 = class162.field2316[var30][var31] + 1;
            if(var30 > 0 && class162.field2315[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class162.field2318[var33] = var10 - 1;
               class162.field2319[var33] = var11;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30 - 1][var31] = 2;
               class162.field2316[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class162.field2315[var30 + 1][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class162.field2318[var33] = var10 + 1;
               class162.field2319[var33] = var11;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30 + 1][var31] = 8;
               class162.field2316[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class162.field2315[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class162.field2318[var33] = var10;
               class162.field2319[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30][var31 - 1] = 1;
               class162.field2316[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class162.field2315[var30][var31 + 1] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class162.field2318[var33] = var10;
               class162.field2319[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30][var31 + 1] = 4;
               class162.field2316[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class162.field2315[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class162.field2318[var33] = var10 - 1;
               class162.field2319[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30 - 1][var31 - 1] = 3;
               class162.field2316[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class162.field2315[1 + var30][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class162.field2318[var33] = var10 + 1;
               class162.field2319[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30 + 1][var31 - 1] = 9;
               class162.field2316[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class162.field2315[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class162.field2318[var33] = var10 - 1;
               class162.field2319[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30 - 1][var31 + 1] = 6;
               class162.field2316[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 127 && var31 < 127 && class162.field2315[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 1] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class162.field2318[var33] = var10 + 1;
               class162.field2319[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30 + 1][var31 + 1] = 12;
               class162.field2316[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class162.field2315[var12][var13] = 99;
         class162.field2316[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class162.field2318[var16] = var0;
         var33 = var16 + 1;
         class162.field2319[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var17 == var33) {
               class267.field3678 = var10;
               class162.field2313 = var11;
               var29 = false;
               break;
            }

            var10 = class162.field2318[var17];
            var11 = class162.field2319[var17];
            var17 = var17 + 1 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod3051(2, var10, var11, var4)) {
               class267.field3678 = var10;
               class162.field2313 = var11;
               var29 = true;
               break;
            }

            var21 = class162.field2316[var30][var31] + 1;
            if(var30 > 0 && class162.field2315[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][1 + var20] & 19136824) == 0) {
               class162.field2318[var33] = var10 - 1;
               class162.field2319[var33] = var11;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30 - 1][var31] = 2;
               class162.field2316[var30 - 1][var31] = var21;
            }

            if(var30 < 126 && class162.field2315[var30 + 1][var31] == 0 && (var18[var19 + 2][var20] & 19136899) == 0 && (var18[var19 + 2][var20 + 1] & 19136992) == 0) {
               class162.field2318[var33] = var10 + 1;
               class162.field2319[var33] = var11;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30 + 1][var31] = 8;
               class162.field2316[var30 + 1][var31] = var21;
            }

            if(var31 > 0 && class162.field2315[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0) {
               class162.field2318[var33] = var10;
               class162.field2319[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30][var31 - 1] = 1;
               class162.field2316[var30][var31 - 1] = var21;
            }

            if(var31 < 126 && class162.field2315[var30][var31 + 1] == 0 && (var18[var19][var20 + 2] & 19136824) == 0 && (var18[var19 + 1][var20 + 2] & 19136992) == 0) {
               class162.field2318[var33] = var10;
               class162.field2319[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30][var31 + 1] = 4;
               class162.field2316[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class162.field2315[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
               class162.field2318[var33] = var10 - 1;
               class162.field2319[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30 - 1][var31 - 1] = 3;
               class162.field2316[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 126 && var31 > 0 && class162.field2315[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136911) == 0 && (var18[var19 + 2][var20 - 1] & 19136899) == 0 && (var18[var19 + 2][var20] & 19136995) == 0) {
               class162.field2318[var33] = var10 + 1;
               class162.field2319[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30 + 1][var31 - 1] = 9;
               class162.field2316[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 126 && class162.field2315[var30 - 1][var31 + 1] == 0 && (var18[var19 - 1][var20 + 1] & 19136830) == 0 && (var18[var19 - 1][var20 + 2] & 19136824) == 0 && (var18[var19][var20 + 2] & 19137016) == 0) {
               class162.field2318[var33] = var10 - 1;
               class162.field2319[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30 - 1][var31 + 1] = 6;
               class162.field2316[var30 - 1][var31 + 1] = var21;
            }

            if(var30 < 126 && var31 < 126 && class162.field2315[var30 + 1][var31 + 1] == 0 && (var18[var19 + 1][var20 + 2] & 19137016) == 0 && (var18[var19 + 2][var20 + 2] & 19136992) == 0 && (var18[var19 + 2][var20 + 1] & 19136995) == 0) {
               class162.field2318[var33] = var10 + 1;
               class162.field2319[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class162.field2315[var30 + 1][var31 + 1] = 12;
               class162.field2316[var30 + 1][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else {
         var28 = CombatInfo1.method1559(var0, var1, var2, var3, var4);
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class267.field3678;
      var30 = class162.field2313;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field2325;
         var17 = var3.field2323;
         int var27 = var3.field2324;
         var19 = var3.field2322;

         for(var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
            for(var21 = var17 - var32; var21 <= var32 + var17; ++var21) {
               int var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class162.field2316[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var27 + var33 - 1) {
                     var24 = var20 - (var33 + var27 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var17 + var19 - 1) {
                     var25 = var21 - (var19 + var17 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var31 == var26 && class162.field2316[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class162.field2316[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var30 == var1) {
         return 0;
      } else {
         var13 = 0;
         class162.field2318[var13] = var11;
         var31 = var13 + 1;
         class162.field2319[var13] = var30;

         for(var14 = var15 = class162.field2315[var11 - var9][var30 - var10]; var0 != var11 || var30 != var1; var14 = class162.field2315[var11 - var9][var30 - var10]) {
            if(var15 != var14) {
               var15 = var14;
               class162.field2318[var31] = var11;
               class162.field2319[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class162.field2318[var31];
            var7[var33++] = class162.field2319[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }
}
