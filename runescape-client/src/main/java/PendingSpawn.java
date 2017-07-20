import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1076252257
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -358799599
   )
   @Export("hitpoints")
   int hitpoints;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1579799179
   )
   @Export("x")
   int x;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1134470939
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 741999111
   )
   @Export("level")
   int level;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1338539109
   )
   int field1196;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1817920711
   )
   int field1190;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1747979989
   )
   @Export("type")
   int type;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -131789879
   )
   int field1189;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 566439035
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 578632261
   )
   int field1188;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1334945929
   )
   @Export("orientation")
   int orientation;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "3"
   )
   static final void method1462(int var0) {
      class134.field1955[++class134.field1954 - 1] = var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILfk;Lfu;I)Z",
      garbageValue = "927151142"
   )
   public static final boolean method1463(int var0, int var1, int var2, class163 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class162.field2262[var7][var8] = 99;
      class162.field2265[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class162.field2268[var11] = var0;
      int var20 = var11 + 1;
      class162.field2269[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label300:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label277:
                     do {
                        if(var12 == var20) {
                           class162.field2266 = var5;
                           class162.field2267 = var6;
                           return false;
                        }

                        var5 = class162.field2268[var12];
                        var6 = class162.field2269[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod2998(var2, var5, var6, var4)) {
                           class162.field2266 = var5;
                           class162.field2267 = var6;
                           return true;
                        }

                        var16 = class162.field2265[var18][var19] + 1;
                        if(var18 > 0 && class162.field2262[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2268[var20] = var5 - 1;
                                 class162.field2269[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2262[var18 - 1][var19] = 2;
                                 class162.field2265[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class162.field2262[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2268[var20] = var5 + 1;
                                 class162.field2269[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2262[var18 + 1][var19] = 8;
                                 class162.field2265[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class162.field2262[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2268[var20] = var5;
                                 class162.field2269[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2262[var18][var19 - 1] = 1;
                                 class162.field2265[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class162.field2262[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2268[var20] = var5;
                                 class162.field2269[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2262[var18][var19 + 1] = 4;
                                 class162.field2265[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class162.field2262[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class162.field2268[var20] = var5 - 1;
                                 class162.field2269[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2262[var18 - 1][var19 - 1] = 3;
                                 class162.field2265[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 - 1 + var17] & 19136830) != 0 || (var13[var14 - 1 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class162.field2262[1 + var18][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class162.field2268[var20] = var5 + 1;
                                 class162.field2269[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2262[var18 + 1][var19 - 1] = 9;
                                 class162.field2265[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 - 1 + var17] & 19136995) != 0 || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class162.field2262[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var14 - 1 + var17][var15 + var2] & 19137016) != 0) {
                                 continue label277;
                              }
                           }

                           class162.field2268[var20] = var5 - 1;
                           class162.field2269[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class162.field2262[var18 - 1][var19 + 1] = 6;
                           class162.field2265[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class162.field2262[var18 + 1][var19 + 1] != 0);
            } while((var13[var2 + var14][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var15 + var2] & 19137016) != 0 || (var13[var2 + var14][var15 + var17] & 19136995) != 0) {
                  continue label300;
               }
            }

            class162.field2268[var20] = var5 + 1;
            class162.field2269[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class162.field2262[var18 + 1][var19 + 1] = 12;
            class162.field2265[var18 + 1][var19 + 1] = var16;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;II)I",
      garbageValue = "-894527327"
   )
   public static int method1461(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      byte var7 = 0;
      byte var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = (char)var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = (char)var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         byte var11;
         if(var9 == 198) {
            var11 = 69;
         } else if(var9 == 230) {
            var11 = 101;
         } else if(var9 == 223) {
            var11 = 115;
         } else if(var9 == 338) {
            var11 = 69;
         } else if(var9 == 339) {
            var11 = 101;
         } else {
            var11 = 0;
         }

         var7 = var11;
         byte var12;
         if(var10 == 198) {
            var12 = 69;
         } else if(var10 == 230) {
            var12 = 101;
         } else if(var10 == 223) {
            var12 = 115;
         } else if(var10 == 338) {
            var12 = 69;
         } else if(var10 == 339) {
            var12 = 101;
         } else {
            var12 = 0;
         }

         var8 = var12;
         var9 = class251.method4331(var9, var2);
         var10 = class251.method4331(var10, var2);
         if(var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var10 != var9) {
               return BaseVarType.method14(var9, var2) - BaseVarType.method14(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      int var17;
      char var20;
      for(var17 = 0; var17 < var16; ++var17) {
         char var18 = var0.charAt(var17);
         var20 = var1.charAt(var17);
         if(var18 != var20 && Character.toUpperCase(var18) != Character.toUpperCase(var20)) {
            var18 = Character.toLowerCase(var18);
            var20 = Character.toLowerCase(var20);
            if(var18 != var20) {
               return BaseVarType.method14(var18, var2) - BaseVarType.method14(var20, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var19 = 0; var19 < var16; ++var19) {
            var20 = var0.charAt(var19);
            char var13 = var1.charAt(var19);
            if(var20 != var13) {
               return BaseVarType.method14(var20, var2) - BaseVarType.method14(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-868208852"
   )
   static void method1464(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = class64.worldList[var6];
         class64.worldList[var6] = class64.worldList[var1];
         class64.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = class64.worldList[var9];
            int var12 = MouseInput.method957(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = MouseInput.method957(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = class64.worldList[var9];
               class64.worldList[var9] = class64.worldList[var7];
               class64.worldList[var7++] = var14;
            }
         }

         class64.worldList[var1] = class64.worldList[var7];
         class64.worldList[var7] = var8;
         method1464(var0, var7 - 1, var2, var3, var4, var5);
         method1464(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
