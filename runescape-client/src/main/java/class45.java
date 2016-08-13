import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class45 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1120155595
   )
   int field1033 = 0;
   @ObfuscatedName("l")
   static class170 field1034;
   @ObfuscatedName("r")
   public static NodeCache field1035 = new NodeCache(64);
   @ObfuscatedName("e")
   public static NodeCache field1036 = new NodeCache(30);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -803553263
   )
   int field1037;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1733633239
   )
   int field1038;
   @ObfuscatedName("g")
   static class170 field1039;
   @ObfuscatedName("u")
   short[] field1040;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -91231621
   )
   int field1041 = 128;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -674917835
   )
   public int field1042 = -1;
   @ObfuscatedName("m")
   short[] field1043;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1701214767
   )
   int field1044 = 128;
   @ObfuscatedName("n")
   short[] field1045;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 949013817
   )
   int field1046 = 0;
   @ObfuscatedName("b")
   short[] field1047;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 20963917
   )
   int field1048 = 0;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = -1650637493
   )
   protected static int field1050;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZS)I",
      garbageValue = "-16859"
   )
   static int method949(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method635()?(var1.method635()?0:1):(var1.method635()?-1:0)):(var2 == 5?(var0.method633()?(var1.method633()?0:1):(var1.method633()?-1:0)):(var2 == 6?(var0.method634()?(var1.method634()?0:1):(var1.method634()?-1:0)):(var2 == 7?(var0.method632()?(var1.method632()?0:1):(var1.method632()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "652004690"
   )
   void method951(Buffer var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.method960(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "1306370646"
   )
   public final Model method952(int var1) {
      Model var2 = (Model)field1036.get((long)this.field1037);
      if(var2 == null) {
         ModelData var3 = ModelData.method2369(field1039, this.field1038, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(this.field1040 != null) {
            for(var4 = 0; var4 < this.field1040.length; ++var4) {
               var3.method2305(this.field1040[var4], this.field1045[var4]);
            }
         }

         if(this.field1047 != null) {
            for(var4 = 0; var4 < this.field1047.length; ++var4) {
               var3.method2306(this.field1047[var4], this.field1043[var4]);
            }
         }

         var2 = var3.method2321(this.field1048 + 64, 850 + this.field1033, -30, -50, -30);
         field1036.put(var2, (long)this.field1037);
      }

      Model var5;
      if(this.field1042 != -1 && var1 != -1) {
         var5 = class22.getAnimation(this.field1042).method907(var2, var1);
      } else {
         var5 = var2.method2400(true);
      }

      if(this.field1044 != 128 || this.field1041 != 128) {
         var5.method2404(this.field1044, this.field1041, this.field1044);
      }

      if(this.field1046 != 0) {
         if(this.field1046 == 90) {
            var5.method2455();
         }

         if(this.field1046 == 180) {
            var5.method2455();
            var5.method2455();
         }

         if(this.field1046 == 270) {
            var5.method2455();
            var5.method2455();
            var5.method2455();
         }
      }

      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-46"
   )
   void method960(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1038 = var1.method2635();
      } else if(var2 == 2) {
         this.field1042 = var1.method2635();
      } else if(var2 == 4) {
         this.field1044 = var1.method2635();
      } else if(var2 == 5) {
         this.field1041 = var1.method2635();
      } else if(var2 == 6) {
         this.field1046 = var1.method2635();
      } else if(var2 == 7) {
         this.field1048 = var1.method2633();
      } else if(var2 == 8) {
         this.field1033 = var1.method2633();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2633();
            this.field1040 = new short[var3];
            this.field1045 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1040[var4] = (short)var1.method2635();
               this.field1045[var4] = (short)var1.method2635();
            }
         } else if(var2 == 41) {
            var3 = var1.method2633();
            this.field1047 = new short[var3];
            this.field1043 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1047[var4] = (short)var1.method2635();
               this.field1043[var4] = (short)var1.method2635();
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIILclass110;LCollisionData;Z[I[II)I",
      garbageValue = "-2012157990"
   )
   public static int method967(int var0, int var1, int var2, class110 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var8;
      int var9;
      for(var9 = 0; var9 < 128; ++var9) {
         for(var8 = 0; var8 < 128; ++var8) {
            class109.field1941[var9][var8] = 0;
            class109.field1938[var9][var8] = 99999999;
         }
      }

      int var10;
      byte var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      boolean var18;
      int var19;
      int var20;
      int var21;
      byte var22;
      if(var2 == 1) {
         var9 = var0;
         var10 = var1;
         var22 = 64;
         var11 = 64;
         var12 = var0 - var22;
         var13 = var1 - var11;
         class109.field1941[var22][var11] = 99;
         class109.field1938[var22][var11] = 0;
         byte var23 = 0;
         var14 = 0;
         class109.field1935[var23] = var0;
         var21 = var23 + 1;
         class109.field1942[var23] = var1;
         int[][] var24 = var4.flags;

         boolean var25;
         label226: {
            while(var14 != var21) {
               var9 = class109.field1935[var14];
               var10 = class109.field1942[var14];
               var14 = var14 + 1 & 4095;
               var19 = var9 - var12;
               var20 = var10 - var13;
               var15 = var9 - var4.x;
               var16 = var10 - var4.y;
               if(var3.vmethod2486(1, var9, var10, var4)) {
                  class93.field1634 = var9;
                  class109.field1937 = var10;
                  var25 = true;
                  break label226;
               }

               var17 = class109.field1938[var19][var20] + 1;
               if(var19 > 0 && class109.field1941[var19 - 1][var20] == 0 && (var24[var15 - 1][var16] & 19136776) == 0) {
                  class109.field1935[var21] = var9 - 1;
                  class109.field1942[var21] = var10;
                  var21 = var21 + 1 & 4095;
                  class109.field1941[var19 - 1][var20] = 2;
                  class109.field1938[var19 - 1][var20] = var17;
               }

               if(var19 < 127 && class109.field1941[1 + var19][var20] == 0 && (var24[1 + var15][var16] & 19136896) == 0) {
                  class109.field1935[var21] = var9 + 1;
                  class109.field1942[var21] = var10;
                  var21 = 1 + var21 & 4095;
                  class109.field1941[1 + var19][var20] = 8;
                  class109.field1938[1 + var19][var20] = var17;
               }

               if(var20 > 0 && class109.field1941[var19][var20 - 1] == 0 && (var24[var15][var16 - 1] & 19136770) == 0) {
                  class109.field1935[var21] = var9;
                  class109.field1942[var21] = var10 - 1;
                  var21 = var21 + 1 & 4095;
                  class109.field1941[var19][var20 - 1] = 1;
                  class109.field1938[var19][var20 - 1] = var17;
               }

               if(var20 < 127 && class109.field1941[var19][var20 + 1] == 0 && (var24[var15][var16 + 1] & 19136800) == 0) {
                  class109.field1935[var21] = var9;
                  class109.field1942[var21] = 1 + var10;
                  var21 = var21 + 1 & 4095;
                  class109.field1941[var19][var20 + 1] = 4;
                  class109.field1938[var19][1 + var20] = var17;
               }

               if(var19 > 0 && var20 > 0 && class109.field1941[var19 - 1][var20 - 1] == 0 && (var24[var15 - 1][var16 - 1] & 19136782) == 0 && (var24[var15 - 1][var16] & 19136776) == 0 && (var24[var15][var16 - 1] & 19136770) == 0) {
                  class109.field1935[var21] = var9 - 1;
                  class109.field1942[var21] = var10 - 1;
                  var21 = var21 + 1 & 4095;
                  class109.field1941[var19 - 1][var20 - 1] = 3;
                  class109.field1938[var19 - 1][var20 - 1] = var17;
               }

               if(var19 < 127 && var20 > 0 && class109.field1941[var19 + 1][var20 - 1] == 0 && (var24[var15 + 1][var16 - 1] & 19136899) == 0 && (var24[1 + var15][var16] & 19136896) == 0 && (var24[var15][var16 - 1] & 19136770) == 0) {
                  class109.field1935[var21] = 1 + var9;
                  class109.field1942[var21] = var10 - 1;
                  var21 = 1 + var21 & 4095;
                  class109.field1941[var19 + 1][var20 - 1] = 9;
                  class109.field1938[1 + var19][var20 - 1] = var17;
               }

               if(var19 > 0 && var20 < 127 && class109.field1941[var19 - 1][1 + var20] == 0 && (var24[var15 - 1][1 + var16] & 19136824) == 0 && (var24[var15 - 1][var16] & 19136776) == 0 && (var24[var15][var16 + 1] & 19136800) == 0) {
                  class109.field1935[var21] = var9 - 1;
                  class109.field1942[var21] = 1 + var10;
                  var21 = 1 + var21 & 4095;
                  class109.field1941[var19 - 1][var20 + 1] = 6;
                  class109.field1938[var19 - 1][1 + var20] = var17;
               }

               if(var19 < 127 && var20 < 127 && class109.field1941[var19 + 1][1 + var20] == 0 && (var24[var15 + 1][1 + var16] & 19136992) == 0 && (var24[var15 + 1][var16] & 19136896) == 0 && (var24[var15][var16 + 1] & 19136800) == 0) {
                  class109.field1935[var21] = 1 + var9;
                  class109.field1942[var21] = 1 + var10;
                  var21 = 1 + var21 & 4095;
                  class109.field1941[1 + var19][var20 + 1] = 12;
                  class109.field1938[var19 + 1][var20 + 1] = var17;
               }
            }

            class93.field1634 = var9;
            class109.field1937 = var10;
            var25 = false;
         }

         var18 = var25;
      } else if(var2 == 2) {
         var18 = class137.method3015(var0, var1, var3, var4);
      } else {
         var18 = class146.method3153(var0, var1, var2, var3, var4);
      }

      var8 = var0 - 64;
      var9 = var1 - 64;
      var10 = class93.field1634;
      var19 = class109.field1937;
      if(!var18) {
         var20 = Integer.MAX_VALUE;
         var12 = Integer.MAX_VALUE;
         var22 = 10;
         var21 = var3.field1951;
         var14 = var3.field1948;
         int var29 = var3.field1949;
         var15 = var3.field1950;

         for(var16 = var21 - var22; var16 <= var21 + var22; ++var16) {
            for(var17 = var14 - var22; var17 <= var22 + var14; ++var17) {
               int var30 = var16 - var8;
               int var31 = var17 - var9;
               if(var30 >= 0 && var31 >= 0 && var30 < 128 && var31 < 128 && class109.field1938[var30][var31] < 100) {
                  int var26 = 0;
                  if(var16 < var21) {
                     var26 = var21 - var16;
                  } else if(var16 > var21 + var29 - 1) {
                     var26 = var16 - (var21 + var29 - 1);
                  }

                  int var27 = 0;
                  if(var17 < var14) {
                     var27 = var14 - var17;
                  } else if(var17 > var14 + var15 - 1) {
                     var27 = var17 - (var15 + var14 - 1);
                  }

                  int var28 = var26 * var26 + var27 * var27;
                  if(var28 < var20 || var28 == var20 && class109.field1938[var30][var31] < var12) {
                     var20 = var28;
                     var12 = class109.field1938[var30][var31];
                     var10 = var16;
                     var19 = var17;
                  }
               }
            }
         }

         if(var20 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var10 && var19 == var1) {
         return 0;
      } else {
         var11 = 0;
         class109.field1935[var11] = var10;
         var20 = var11 + 1;
         class109.field1942[var11] = var19;

         for(var12 = var13 = class109.field1941[var10 - var8][var19 - var9]; var0 != var10 || var1 != var19; var12 = class109.field1941[var10 - var8][var19 - var9]) {
            if(var12 != var13) {
               var13 = var12;
               class109.field1935[var20] = var10;
               class109.field1942[var20++] = var19;
            }

            if((var12 & 2) != 0) {
               ++var10;
            } else if((var12 & 8) != 0) {
               --var10;
            }

            if((var12 & 1) != 0) {
               ++var19;
            } else if((var12 & 4) != 0) {
               --var19;
            }
         }

         var21 = 0;

         while(var20-- > 0) {
            var6[var21] = class109.field1935[var20];
            var7[var21++] = class109.field1942[var20];
            if(var21 >= var6.length) {
               break;
            }
         }

         return var21;
      }
   }
}
