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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "-90822970"
   )
   MessageNode method1876(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1004961095"
   )
   int method1882() {
      return this.length;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILclass163;LCollisionData;Z[I[II)I",
      garbageValue = "-996276063"
   )
   public static int method1883(int var0, int var1, int var2, class163 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var8;
      int var9;
      for(var9 = 0; var9 < 128; ++var9) {
         for(var8 = 0; var8 < 128; ++var8) {
            class162.field2315[var9][var8] = 0;
            class162.field2316[var9][var8] = 99999999;
         }
      }

      int var10;
      byte var11;
      byte var12;
      int var13;
      int var14;
      byte var15;
      int var16;
      int[][] var17;
      int var18;
      int var19;
      int var20;
      boolean var21;
      boolean var22;
      int var23;
      int var24;
      int var25;
      if(var2 == 1) {
         var9 = var0;
         var10 = var1;
         var11 = 64;
         var12 = 64;
         var13 = var0 - var11;
         var14 = var1 - var12;
         class162.field2315[var11][var12] = 99;
         class162.field2316[var11][var12] = 0;
         var15 = 0;
         var16 = 0;
         class162.field2318[var15] = var0;
         var25 = var15 + 1;
         class162.field2319[var15] = var1;
         var17 = var4.flags;

         label336: {
            while(var16 != var25) {
               var9 = class162.field2318[var16];
               var10 = class162.field2319[var16];
               var16 = var16 + 1 & 4095;
               var23 = var9 - var13;
               var24 = var10 - var14;
               var18 = var9 - var4.x;
               var19 = var10 - var4.y;
               if(var3.vmethod3051(1, var9, var10, var4)) {
                  class267.field3678 = var9;
                  class162.field2313 = var10;
                  var22 = true;
                  break label336;
               }

               var20 = class162.field2316[var23][var24] + 1;
               if(var23 > 0 && class162.field2315[var23 - 1][var24] == 0 && (var17[var18 - 1][var19] & 19136776) == 0) {
                  class162.field2318[var25] = var9 - 1;
                  class162.field2319[var25] = var10;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23 - 1][var24] = 2;
                  class162.field2316[var23 - 1][var24] = var20;
               }

               if(var23 < 127 && class162.field2315[var23 + 1][var24] == 0 && (var17[var18 + 1][var19] & 19136896) == 0) {
                  class162.field2318[var25] = var9 + 1;
                  class162.field2319[var25] = var10;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23 + 1][var24] = 8;
                  class162.field2316[var23 + 1][var24] = var20;
               }

               if(var24 > 0 && class162.field2315[var23][var24 - 1] == 0 && (var17[var18][var19 - 1] & 19136770) == 0) {
                  class162.field2318[var25] = var9;
                  class162.field2319[var25] = var10 - 1;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23][var24 - 1] = 1;
                  class162.field2316[var23][var24 - 1] = var20;
               }

               if(var24 < 127 && class162.field2315[var23][var24 + 1] == 0 && (var17[var18][var19 + 1] & 19136800) == 0) {
                  class162.field2318[var25] = var9;
                  class162.field2319[var25] = var10 + 1;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23][var24 + 1] = 4;
                  class162.field2316[var23][var24 + 1] = var20;
               }

               if(var23 > 0 && var24 > 0 && class162.field2315[var23 - 1][var24 - 1] == 0 && (var17[var18 - 1][var19 - 1] & 19136782) == 0 && (var17[var18 - 1][var19] & 19136776) == 0 && (var17[var18][var19 - 1] & 19136770) == 0) {
                  class162.field2318[var25] = var9 - 1;
                  class162.field2319[var25] = var10 - 1;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23 - 1][var24 - 1] = 3;
                  class162.field2316[var23 - 1][var24 - 1] = var20;
               }

               if(var23 < 127 && var24 > 0 && class162.field2315[var23 + 1][var24 - 1] == 0 && (var17[var18 + 1][var19 - 1] & 19136899) == 0 && (var17[var18 + 1][var19] & 19136896) == 0 && (var17[var18][var19 - 1] & 19136770) == 0) {
                  class162.field2318[var25] = var9 + 1;
                  class162.field2319[var25] = var10 - 1;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23 + 1][var24 - 1] = 9;
                  class162.field2316[var23 + 1][var24 - 1] = var20;
               }

               if(var23 > 0 && var24 < 127 && class162.field2315[var23 - 1][var24 + 1] == 0 && (var17[var18 - 1][var19 + 1] & 19136824) == 0 && (var17[var18 - 1][var19] & 19136776) == 0 && (var17[var18][1 + var19] & 19136800) == 0) {
                  class162.field2318[var25] = var9 - 1;
                  class162.field2319[var25] = var10 + 1;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23 - 1][var24 + 1] = 6;
                  class162.field2316[var23 - 1][var24 + 1] = var20;
               }

               if(var23 < 127 && var24 < 127 && class162.field2315[var23 + 1][var24 + 1] == 0 && (var17[var18 + 1][var19 + 1] & 19136992) == 0 && (var17[var18 + 1][var19] & 19136896) == 0 && (var17[var18][var19 + 1] & 19136800) == 0) {
                  class162.field2318[var25] = var9 + 1;
                  class162.field2319[var25] = var10 + 1;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23 + 1][var24 + 1] = 12;
                  class162.field2316[var23 + 1][var24 + 1] = var20;
               }
            }

            class267.field3678 = var9;
            class162.field2313 = var10;
            var22 = false;
         }

         var21 = var22;
      } else if(var2 == 2) {
         var9 = var0;
         var10 = var1;
         var11 = 64;
         var12 = 64;
         var13 = var0 - var11;
         var14 = var1 - var12;
         class162.field2315[var11][var12] = 99;
         class162.field2316[var11][var12] = 0;
         var15 = 0;
         var16 = 0;
         class162.field2318[var15] = var0;
         var25 = var15 + 1;
         class162.field2319[var15] = var1;
         var17 = var4.flags;

         label325: {
            while(var16 != var25) {
               var9 = class162.field2318[var16];
               var10 = class162.field2319[var16];
               var16 = var16 + 1 & 4095;
               var23 = var9 - var13;
               var24 = var10 - var14;
               var18 = var9 - var4.x;
               var19 = var10 - var4.y;
               if(var3.vmethod3051(2, var9, var10, var4)) {
                  class267.field3678 = var9;
                  class162.field2313 = var10;
                  var22 = true;
                  break label325;
               }

               var20 = class162.field2316[var23][var24] + 1;
               if(var23 > 0 && class162.field2315[var23 - 1][var24] == 0 && (var17[var18 - 1][var19] & 19136782) == 0 && (var17[var18 - 1][var19 + 1] & 19136824) == 0) {
                  class162.field2318[var25] = var9 - 1;
                  class162.field2319[var25] = var10;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23 - 1][var24] = 2;
                  class162.field2316[var23 - 1][var24] = var20;
               }

               if(var23 < 126 && class162.field2315[var23 + 1][var24] == 0 && (var17[var18 + 2][var19] & 19136899) == 0 && (var17[var18 + 2][var19 + 1] & 19136992) == 0) {
                  class162.field2318[var25] = var9 + 1;
                  class162.field2319[var25] = var10;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23 + 1][var24] = 8;
                  class162.field2316[var23 + 1][var24] = var20;
               }

               if(var24 > 0 && class162.field2315[var23][var24 - 1] == 0 && (var17[var18][var19 - 1] & 19136782) == 0 && (var17[var18 + 1][var19 - 1] & 19136899) == 0) {
                  class162.field2318[var25] = var9;
                  class162.field2319[var25] = var10 - 1;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23][var24 - 1] = 1;
                  class162.field2316[var23][var24 - 1] = var20;
               }

               if(var24 < 126 && class162.field2315[var23][var24 + 1] == 0 && (var17[var18][var19 + 2] & 19136824) == 0 && (var17[var18 + 1][var19 + 2] & 19136992) == 0) {
                  class162.field2318[var25] = var9;
                  class162.field2319[var25] = var10 + 1;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23][var24 + 1] = 4;
                  class162.field2316[var23][var24 + 1] = var20;
               }

               if(var23 > 0 && var24 > 0 && class162.field2315[var23 - 1][var24 - 1] == 0 && (var17[var18 - 1][var19] & 19136830) == 0 && (var17[var18 - 1][var19 - 1] & 19136782) == 0 && (var17[var18][var19 - 1] & 19136911) == 0) {
                  class162.field2318[var25] = var9 - 1;
                  class162.field2319[var25] = var10 - 1;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23 - 1][var24 - 1] = 3;
                  class162.field2316[var23 - 1][var24 - 1] = var20;
               }

               if(var23 < 126 && var24 > 0 && class162.field2315[var23 + 1][var24 - 1] == 0 && (var17[var18 + 1][var19 - 1] & 19136911) == 0 && (var17[var18 + 2][var19 - 1] & 19136899) == 0 && (var17[var18 + 2][var19] & 19136995) == 0) {
                  class162.field2318[var25] = var9 + 1;
                  class162.field2319[var25] = var10 - 1;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23 + 1][var24 - 1] = 9;
                  class162.field2316[var23 + 1][var24 - 1] = var20;
               }

               if(var23 > 0 && var24 < 126 && class162.field2315[var23 - 1][1 + var24] == 0 && (var17[var18 - 1][var19 + 1] & 19136830) == 0 && (var17[var18 - 1][var19 + 2] & 19136824) == 0 && (var17[var18][var19 + 2] & 19137016) == 0) {
                  class162.field2318[var25] = var9 - 1;
                  class162.field2319[var25] = var10 + 1;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23 - 1][var24 + 1] = 6;
                  class162.field2316[var23 - 1][var24 + 1] = var20;
               }

               if(var23 < 126 && var24 < 126 && class162.field2315[var23 + 1][var24 + 1] == 0 && (var17[var18 + 1][var19 + 2] & 19137016) == 0 && (var17[var18 + 2][var19 + 2] & 19136992) == 0 && (var17[2 + var18][1 + var19] & 19136995) == 0) {
                  class162.field2318[var25] = var9 + 1;
                  class162.field2319[var25] = var10 + 1;
                  var25 = var25 + 1 & 4095;
                  class162.field2315[var23 + 1][var24 + 1] = 12;
                  class162.field2316[var23 + 1][var24 + 1] = var20;
               }
            }

            class267.field3678 = var9;
            class162.field2313 = var10;
            var22 = false;
         }

         var21 = var22;
      } else {
         var21 = CombatInfo1.method1559(var0, var1, var2, var3, var4);
      }

      var8 = var0 - 64;
      var9 = var1 - 64;
      var10 = class267.field3678;
      var23 = class162.field2313;
      if(!var21) {
         var24 = Integer.MAX_VALUE;
         var13 = Integer.MAX_VALUE;
         byte var26 = 10;
         var25 = var3.field2325;
         var16 = var3.field2323;
         int var27 = var3.field2324;
         var18 = var3.field2322;

         for(var19 = var25 - var26; var19 <= var26 + var25; ++var19) {
            for(var20 = var16 - var26; var20 <= var16 + var26; ++var20) {
               int var28 = var19 - var8;
               int var29 = var20 - var9;
               if(var28 >= 0 && var29 >= 0 && var28 < 128 && var29 < 128 && class162.field2316[var28][var29] < 100) {
                  int var30 = 0;
                  if(var19 < var25) {
                     var30 = var25 - var19;
                  } else if(var19 > var27 + var25 - 1) {
                     var30 = var19 - (var27 + var25 - 1);
                  }

                  int var31 = 0;
                  if(var20 < var16) {
                     var31 = var16 - var20;
                  } else if(var20 > var18 + var16 - 1) {
                     var31 = var20 - (var18 + var16 - 1);
                  }

                  int var32 = var31 * var31 + var30 * var30;
                  if(var32 < var24 || var24 == var32 && class162.field2316[var28][var29] < var13) {
                     var24 = var32;
                     var13 = class162.field2316[var28][var29];
                     var10 = var19;
                     var23 = var20;
                  }
               }
            }
         }

         if(var24 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var10 == var0 && var23 == var1) {
         return 0;
      } else {
         var12 = 0;
         class162.field2318[var12] = var10;
         var24 = var12 + 1;
         class162.field2319[var12] = var23;

         for(var13 = var14 = class162.field2315[var10 - var8][var23 - var9]; var10 != var0 || var23 != var1; var13 = class162.field2315[var10 - var8][var23 - var9]) {
            if(var14 != var13) {
               var14 = var13;
               class162.field2318[var24] = var10;
               class162.field2319[var24++] = var23;
            }

            if((var13 & 2) != 0) {
               ++var10;
            } else if((var13 & 8) != 0) {
               --var10;
            }

            if((var13 & 1) != 0) {
               ++var23;
            } else if((var13 & 4) != 0) {
               --var23;
            }
         }

         var25 = 0;

         while(var24-- > 0) {
            var6[var25] = class162.field2318[var24];
            var7[var25++] = class162.field2319[var24];
            if(var25 >= var6.length) {
               break;
            }
         }

         return var25;
      }
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
}
