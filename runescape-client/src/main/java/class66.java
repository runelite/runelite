import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class66 {
   @ObfuscatedName("t")
   static final class66 field798;
   @ObfuscatedName("cu")
   static IndexData field799;
   @ObfuscatedName("e")
   static final class66 field800;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -1829203397
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("p")
   static final class66 field802;
   @ObfuscatedName("me")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("m")
   static final class66 field804;

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-481593356"
   )
   static void method1024() {
      Client.secretPacketBuffer1.putOpcode(144);
      Client.secretPacketBuffer1.putByte(class241.method4167());
      Client.secretPacketBuffer1.putShort(class10.canvasWidth);
      Client.secretPacketBuffer1.putShort(class1.canvasHeight);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILclass163;LCollisionData;Z[I[II)I",
      garbageValue = "1595736843"
   )
   public static int method1025(int var0, int var1, int var2, class163 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var8;
      int var9;
      for(var9 = 0; var9 < 128; ++var9) {
         for(var8 = 0; var8 < 128; ++var8) {
            class162.field2314[var9][var8] = 0;
            class162.field2311[var9][var8] = 99999999;
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
      int var21;
      boolean var22;
      boolean var23;
      int var24;
      int var25;
      int var26;
      if(var2 == 1) {
         var9 = var0;
         var10 = var1;
         var11 = 64;
         var12 = 64;
         var13 = var0 - var11;
         var14 = var1 - var12;
         class162.field2314[var11][var12] = 99;
         class162.field2311[var11][var12] = 0;
         var15 = 0;
         var16 = 0;
         class162.field2315[var15] = var0;
         var26 = var15 + 1;
         class162.field2316[var15] = var1;
         var17 = var4.flags;

         label431: {
            while(var16 != var26) {
               var9 = class162.field2315[var16];
               var10 = class162.field2316[var16];
               var16 = var16 + 1 & 4095;
               var24 = var9 - var13;
               var25 = var10 - var14;
               var18 = var9 - var4.x;
               var19 = var10 - var4.y;
               if(var3.vmethod2950(1, var9, var10, var4)) {
                  class164.field2331 = var9;
                  class162.field2310 = var10;
                  var23 = true;
                  break label431;
               }

               var20 = class162.field2311[var24][var25] + 1;
               if(var24 > 0 && class162.field2314[var24 - 1][var25] == 0 && (var17[var18 - 1][var19] & 19136776) == 0) {
                  class162.field2315[var26] = var9 - 1;
                  class162.field2316[var26] = var10;
                  var26 = var26 + 1 & 4095;
                  class162.field2314[var24 - 1][var25] = 2;
                  class162.field2311[var24 - 1][var25] = var20;
               }

               if(var24 < 127 && class162.field2314[var24 + 1][var25] == 0 && (var17[var18 + 1][var19] & 19136896) == 0) {
                  class162.field2315[var26] = var9 + 1;
                  class162.field2316[var26] = var10;
                  var26 = var26 + 1 & 4095;
                  class162.field2314[var24 + 1][var25] = 8;
                  class162.field2311[var24 + 1][var25] = var20;
               }

               if(var25 > 0 && class162.field2314[var24][var25 - 1] == 0 && (var17[var18][var19 - 1] & 19136770) == 0) {
                  class162.field2315[var26] = var9;
                  class162.field2316[var26] = var10 - 1;
                  var26 = var26 + 1 & 4095;
                  class162.field2314[var24][var25 - 1] = 1;
                  class162.field2311[var24][var25 - 1] = var20;
               }

               if(var25 < 127 && class162.field2314[var24][var25 + 1] == 0 && (var17[var18][var19 + 1] & 19136800) == 0) {
                  class162.field2315[var26] = var9;
                  class162.field2316[var26] = var10 + 1;
                  var26 = var26 + 1 & 4095;
                  class162.field2314[var24][var25 + 1] = 4;
                  class162.field2311[var24][var25 + 1] = var20;
               }

               if(var24 > 0 && var25 > 0 && class162.field2314[var24 - 1][var25 - 1] == 0 && (var17[var18 - 1][var19 - 1] & 19136782) == 0 && (var17[var18 - 1][var19] & 19136776) == 0 && (var17[var18][var19 - 1] & 19136770) == 0) {
                  class162.field2315[var26] = var9 - 1;
                  class162.field2316[var26] = var10 - 1;
                  var26 = var26 + 1 & 4095;
                  class162.field2314[var24 - 1][var25 - 1] = 3;
                  class162.field2311[var24 - 1][var25 - 1] = var20;
               }

               if(var24 < 127 && var25 > 0 && class162.field2314[var24 + 1][var25 - 1] == 0 && (var17[var18 + 1][var19 - 1] & 19136899) == 0 && (var17[var18 + 1][var19] & 19136896) == 0 && (var17[var18][var19 - 1] & 19136770) == 0) {
                  class162.field2315[var26] = var9 + 1;
                  class162.field2316[var26] = var10 - 1;
                  var26 = var26 + 1 & 4095;
                  class162.field2314[var24 + 1][var25 - 1] = 9;
                  class162.field2311[var24 + 1][var25 - 1] = var20;
               }

               if(var24 > 0 && var25 < 127 && class162.field2314[var24 - 1][var25 + 1] == 0 && (var17[var18 - 1][var19 + 1] & 19136824) == 0 && (var17[var18 - 1][var19] & 19136776) == 0 && (var17[var18][var19 + 1] & 19136800) == 0) {
                  class162.field2315[var26] = var9 - 1;
                  class162.field2316[var26] = var10 + 1;
                  var26 = var26 + 1 & 4095;
                  class162.field2314[var24 - 1][var25 + 1] = 6;
                  class162.field2311[var24 - 1][var25 + 1] = var20;
               }

               if(var24 < 127 && var25 < 127 && class162.field2314[var24 + 1][var25 + 1] == 0 && (var17[var18 + 1][var19 + 1] & 19136992) == 0 && (var17[var18 + 1][var19] & 19136896) == 0 && (var17[var18][var19 + 1] & 19136800) == 0) {
                  class162.field2315[var26] = var9 + 1;
                  class162.field2316[var26] = var10 + 1;
                  var26 = var26 + 1 & 4095;
                  class162.field2314[var24 + 1][var25 + 1] = 12;
                  class162.field2311[var24 + 1][var25 + 1] = var20;
               }
            }

            class164.field2331 = var9;
            class162.field2310 = var10;
            var23 = false;
         }

         var22 = var23;
      } else if(var2 == 2) {
         var22 = class1.method1(var0, var1, var3, var4);
      } else {
         var9 = var0;
         var10 = var1;
         var11 = 64;
         var12 = 64;
         var13 = var0 - var11;
         var14 = var1 - var12;
         class162.field2314[var11][var12] = 99;
         class162.field2311[var11][var12] = 0;
         var15 = 0;
         var16 = 0;
         class162.field2315[var15] = var0;
         var26 = var15 + 1;
         class162.field2316[var15] = var1;
         var17 = var4.flags;

         label420: {
            label419:
            while(var26 != var16) {
               var9 = class162.field2315[var16];
               var10 = class162.field2316[var16];
               var16 = var16 + 1 & 4095;
               var24 = var9 - var13;
               var25 = var10 - var14;
               var18 = var9 - var4.x;
               var19 = var10 - var4.y;
               if(var3.vmethod2950(var2, var9, var10, var4)) {
                  class164.field2331 = var9;
                  class162.field2310 = var10;
                  var23 = true;
                  break label420;
               }

               var20 = class162.field2311[var24][var25] + 1;
               if(var24 > 0 && class162.field2314[var24 - 1][var25] == 0 && (var17[var18 - 1][var19] & 19136782) == 0 && (var17[var18 - 1][var2 + var19 - 1] & 19136824) == 0) {
                  var21 = 1;

                  while(true) {
                     if(var21 >= var2 - 1) {
                        class162.field2315[var26] = var9 - 1;
                        class162.field2316[var26] = var10;
                        var26 = var26 + 1 & 4095;
                        class162.field2314[var24 - 1][var25] = 2;
                        class162.field2311[var24 - 1][var25] = var20;
                        break;
                     }

                     if((var17[var18 - 1][var19 + var21] & 19136830) != 0) {
                        break;
                     }

                     ++var21;
                  }
               }

               if(var24 < 128 - var2 && class162.field2314[var24 + 1][var25] == 0 && (var17[var18 + var2][var19] & 19136899) == 0 && (var17[var18 + var2][var19 + var2 - 1] & 19136992) == 0) {
                  var21 = 1;

                  while(true) {
                     if(var21 >= var2 - 1) {
                        class162.field2315[var26] = var9 + 1;
                        class162.field2316[var26] = var10;
                        var26 = var26 + 1 & 4095;
                        class162.field2314[var24 + 1][var25] = 8;
                        class162.field2311[var24 + 1][var25] = var20;
                        break;
                     }

                     if((var17[var18 + var2][var19 + var21] & 19136995) != 0) {
                        break;
                     }

                     ++var21;
                  }
               }

               if(var25 > 0 && class162.field2314[var24][var25 - 1] == 0 && (var17[var18][var19 - 1] & 19136782) == 0 && (var17[var18 + var2 - 1][var19 - 1] & 19136899) == 0) {
                  var21 = 1;

                  while(true) {
                     if(var21 >= var2 - 1) {
                        class162.field2315[var26] = var9;
                        class162.field2316[var26] = var10 - 1;
                        var26 = var26 + 1 & 4095;
                        class162.field2314[var24][var25 - 1] = 1;
                        class162.field2311[var24][var25 - 1] = var20;
                        break;
                     }

                     if((var17[var21 + var18][var19 - 1] & 19136911) != 0) {
                        break;
                     }

                     ++var21;
                  }
               }

               if(var25 < 128 - var2 && class162.field2314[var24][var25 + 1] == 0 && (var17[var18][var2 + var19] & 19136824) == 0 && (var17[var2 + var18 - 1][var2 + var19] & 19136992) == 0) {
                  var21 = 1;

                  while(true) {
                     if(var21 >= var2 - 1) {
                        class162.field2315[var26] = var9;
                        class162.field2316[var26] = var10 + 1;
                        var26 = var26 + 1 & 4095;
                        class162.field2314[var24][var25 + 1] = 4;
                        class162.field2311[var24][var25 + 1] = var20;
                        break;
                     }

                     if((var17[var18 + var21][var2 + var19] & 19137016) != 0) {
                        break;
                     }

                     ++var21;
                  }
               }

               if(var24 > 0 && var25 > 0 && class162.field2314[var24 - 1][var25 - 1] == 0 && (var17[var18 - 1][var19 - 1] & 19136782) == 0) {
                  var21 = 1;

                  while(true) {
                     if(var21 >= var2) {
                        class162.field2315[var26] = var9 - 1;
                        class162.field2316[var26] = var10 - 1;
                        var26 = var26 + 1 & 4095;
                        class162.field2314[var24 - 1][var25 - 1] = 3;
                        class162.field2311[var24 - 1][var25 - 1] = var20;
                        break;
                     }

                     if((var17[var18 - 1][var21 + (var19 - 1)] & 19136830) != 0 || (var17[var21 + (var18 - 1)][var19 - 1] & 19136911) != 0) {
                        break;
                     }

                     ++var21;
                  }
               }

               if(var24 < 128 - var2 && var25 > 0 && class162.field2314[var24 + 1][var25 - 1] == 0 && (var17[var18 + var2][var19 - 1] & 19136899) == 0) {
                  var21 = 1;

                  while(true) {
                     if(var21 >= var2) {
                        class162.field2315[var26] = var9 + 1;
                        class162.field2316[var26] = var10 - 1;
                        var26 = var26 + 1 & 4095;
                        class162.field2314[var24 + 1][var25 - 1] = 9;
                        class162.field2311[var24 + 1][var25 - 1] = var20;
                        break;
                     }

                     if((var17[var2 + var18][var21 + (var19 - 1)] & 19136995) != 0 || (var17[var21 + var18][var19 - 1] & 19136911) != 0) {
                        break;
                     }

                     ++var21;
                  }
               }

               if(var24 > 0 && var25 < 128 - var2 && class162.field2314[var24 - 1][var25 + 1] == 0 && (var17[var18 - 1][var19 + var2] & 19136824) == 0) {
                  var21 = 1;

                  while(true) {
                     if(var21 >= var2) {
                        class162.field2315[var26] = var9 - 1;
                        class162.field2316[var26] = var10 + 1;
                        var26 = var26 + 1 & 4095;
                        class162.field2314[var24 - 1][var25 + 1] = 6;
                        class162.field2311[var24 - 1][var25 + 1] = var20;
                        break;
                     }

                     if((var17[var18 - 1][var19 + var21] & 19136830) != 0 || (var17[var18 - 1 + var21][var19 + var2] & 19137016) != 0) {
                        break;
                     }

                     ++var21;
                  }
               }

               if(var24 < 128 - var2 && var25 < 128 - var2 && class162.field2314[var24 + 1][var25 + 1] == 0 && (var17[var18 + var2][var2 + var19] & 19136992) == 0) {
                  for(var21 = 1; var21 < var2; ++var21) {
                     if((var17[var18 + var21][var2 + var19] & 19137016) != 0 || (var17[var2 + var18][var19 + var21] & 19136995) != 0) {
                        continue label419;
                     }
                  }

                  class162.field2315[var26] = var9 + 1;
                  class162.field2316[var26] = var10 + 1;
                  var26 = var26 + 1 & 4095;
                  class162.field2314[var24 + 1][var25 + 1] = 12;
                  class162.field2311[var24 + 1][var25 + 1] = var20;
               }
            }

            class164.field2331 = var9;
            class162.field2310 = var10;
            var23 = false;
         }

         var22 = var23;
      }

      var8 = var0 - 64;
      var9 = var1 - 64;
      var10 = class164.field2331;
      var24 = class162.field2310;
      if(!var22) {
         var25 = Integer.MAX_VALUE;
         var13 = Integer.MAX_VALUE;
         byte var27 = 10;
         var26 = var3.field2320;
         var16 = var3.field2322;
         int var28 = var3.field2321;
         var18 = var3.field2323;

         for(var19 = var26 - var27; var19 <= var26 + var27; ++var19) {
            for(var20 = var16 - var27; var20 <= var27 + var16; ++var20) {
               var21 = var19 - var8;
               int var29 = var20 - var9;
               if(var21 >= 0 && var29 >= 0 && var21 < 128 && var29 < 128 && class162.field2311[var21][var29] < 100) {
                  int var30 = 0;
                  if(var19 < var26) {
                     var30 = var26 - var19;
                  } else if(var19 > var26 + var28 - 1) {
                     var30 = var19 - (var28 + var26 - 1);
                  }

                  int var31 = 0;
                  if(var20 < var16) {
                     var31 = var16 - var20;
                  } else if(var20 > var16 + var18 - 1) {
                     var31 = var20 - (var18 + var16 - 1);
                  }

                  int var32 = var31 * var31 + var30 * var30;
                  if(var32 < var25 || var25 == var32 && class162.field2311[var21][var29] < var13) {
                     var25 = var32;
                     var13 = class162.field2311[var21][var29];
                     var10 = var19;
                     var24 = var20;
                  }
               }
            }
         }

         if(var25 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var10 == var0 && var1 == var24) {
         return 0;
      } else {
         var12 = 0;
         class162.field2315[var12] = var10;
         var25 = var12 + 1;
         class162.field2316[var12] = var24;

         for(var13 = var14 = class162.field2314[var10 - var8][var24 - var9]; var10 != var0 || var1 != var24; var13 = class162.field2314[var10 - var8][var24 - var9]) {
            if(var13 != var14) {
               var14 = var13;
               class162.field2315[var25] = var10;
               class162.field2316[var25++] = var24;
            }

            if((var13 & 2) != 0) {
               ++var10;
            } else if((var13 & 8) != 0) {
               --var10;
            }

            if((var13 & 1) != 0) {
               ++var24;
            } else if((var13 & 4) != 0) {
               --var24;
            }
         }

         var26 = 0;

         while(var25-- > 0) {
            var6[var26] = class162.field2315[var25];
            var7[var26++] = class162.field2316[var25];
            if(var26 >= var6.length) {
               break;
            }
         }

         return var26;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1045441971"
   )
   static void method1026() {
      for(class82 var0 = (class82)class82.field1314.method3487(); var0 != null; var0 = (class82)class82.field1314.method3512()) {
         if(var0.field1313 != null) {
            WorldMapType1.field442.method1780(var0.field1313);
            var0.field1313 = null;
         }

         if(var0.field1318 != null) {
            WorldMapType1.field442.method1780(var0.field1318);
            var0.field1318 = null;
         }
      }

      class82.field1314.method3481();
   }

   static {
      field802 = new class66();
      field804 = new class66();
      field800 = new class66();
      field798 = new class66();
   }
}
