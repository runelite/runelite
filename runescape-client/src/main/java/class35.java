import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class35 {
   @ObfuscatedName("i")
   static final class35 field495;
   @ObfuscatedName("c")
   static final class35 field496;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -166600789
   )
   final int field497;

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBI)V",
      garbageValue = "849668809"
   )
   static final void method477(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method1131();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.method1131();
            class163 var9 = class211.method3911(var1, var2);
            CollisionData var10 = Client.collisionMaps[var0.field911];
            int[] var11 = Client.field1208;
            int[] var12 = Client.field1209;

            int var13;
            int var14;
            for(var13 = 0; var13 < 128; ++var13) {
               for(var14 = 0; var14 < 128; ++var14) {
                  class162.field2329[var13][var14] = 0;
                  class162.field2322[var13][var14] = 99999999;
               }
            }

            int var15;
            int var16;
            byte var17;
            byte var18;
            int var19;
            int var20;
            byte var21;
            int var22;
            int[][] var23;
            int var24;
            int var25;
            int var26;
            int var27;
            boolean var33;
            boolean var34;
            int var35;
            int var36;
            int var38;
            if(var8 == 1) {
               var15 = var4;
               var16 = var5;
               var17 = 64;
               var18 = 64;
               var19 = var4 - var17;
               var20 = var5 - var18;
               class162.field2329[var17][var18] = 99;
               class162.field2322[var17][var18] = 0;
               var21 = 0;
               var22 = 0;
               class162.field2325[var21] = var4;
               var38 = var21 + 1;
               class162.field2326[var21] = var5;
               var23 = var10.flags;

               while(true) {
                  if(var22 == var38) {
                     class267.field3667 = var15;
                     class37.field512 = var16;
                     var34 = false;
                     break;
                  }

                  var15 = class162.field2325[var22];
                  var16 = class162.field2326[var22];
                  var22 = var22 + 1 & 4095;
                  var35 = var15 - var19;
                  var36 = var16 - var20;
                  var24 = var15 - var10.x;
                  var25 = var16 - var10.y;
                  if(var9.vmethod3055(1, var15, var16, var10)) {
                     class267.field3667 = var15;
                     class37.field512 = var16;
                     var34 = true;
                     break;
                  }

                  var26 = class162.field2322[var35][var36] + 1;
                  if(var35 > 0 && class162.field2329[var35 - 1][var36] == 0 && (var23[var24 - 1][var25] & 19136776) == 0) {
                     class162.field2325[var38] = var15 - 1;
                     class162.field2326[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35 - 1][var36] = 2;
                     class162.field2322[var35 - 1][var36] = var26;
                  }

                  if(var35 < 127 && class162.field2329[var35 + 1][var36] == 0 && (var23[var24 + 1][var25] & 19136896) == 0) {
                     class162.field2325[var38] = var15 + 1;
                     class162.field2326[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35 + 1][var36] = 8;
                     class162.field2322[var35 + 1][var36] = var26;
                  }

                  if(var36 > 0 && class162.field2329[var35][var36 - 1] == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
                     class162.field2325[var38] = var15;
                     class162.field2326[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35][var36 - 1] = 1;
                     class162.field2322[var35][var36 - 1] = var26;
                  }

                  if(var36 < 127 && class162.field2329[var35][var36 + 1] == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
                     class162.field2325[var38] = var15;
                     class162.field2326[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35][var36 + 1] = 4;
                     class162.field2322[var35][var36 + 1] = var26;
                  }

                  if(var35 > 0 && var36 > 0 && class162.field2329[var35 - 1][var36 - 1] == 0 && (var23[var24 - 1][var25 - 1] & 19136782) == 0 && (var23[var24 - 1][var25] & 19136776) == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
                     class162.field2325[var38] = var15 - 1;
                     class162.field2326[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35 - 1][var36 - 1] = 3;
                     class162.field2322[var35 - 1][var36 - 1] = var26;
                  }

                  if(var35 < 127 && var36 > 0 && class162.field2329[var35 + 1][var36 - 1] == 0 && (var23[var24 + 1][var25 - 1] & 19136899) == 0 && (var23[var24 + 1][var25] & 19136896) == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
                     class162.field2325[var38] = var15 + 1;
                     class162.field2326[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35 + 1][var36 - 1] = 9;
                     class162.field2322[var35 + 1][var36 - 1] = var26;
                  }

                  if(var35 > 0 && var36 < 127 && class162.field2329[var35 - 1][var36 + 1] == 0 && (var23[var24 - 1][var25 + 1] & 19136824) == 0 && (var23[var24 - 1][var25] & 19136776) == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
                     class162.field2325[var38] = var15 - 1;
                     class162.field2326[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35 - 1][var36 + 1] = 6;
                     class162.field2322[var35 - 1][var36 + 1] = var26;
                  }

                  if(var35 < 127 && var36 < 127 && class162.field2329[var35 + 1][var36 + 1] == 0 && (var23[var24 + 1][var25 + 1] & 19136992) == 0 && (var23[var24 + 1][var25] & 19136896) == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
                     class162.field2325[var38] = var15 + 1;
                     class162.field2326[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35 + 1][var36 + 1] = 12;
                     class162.field2322[var35 + 1][var36 + 1] = var26;
                  }
               }

               var33 = var34;
            } else if(var8 == 2) {
               var15 = var4;
               var16 = var5;
               var17 = 64;
               var18 = 64;
               var19 = var4 - var17;
               var20 = var5 - var18;
               class162.field2329[var17][var18] = 99;
               class162.field2322[var17][var18] = 0;
               var21 = 0;
               var22 = 0;
               class162.field2325[var21] = var4;
               var38 = var21 + 1;
               class162.field2326[var21] = var5;
               var23 = var10.flags;

               while(true) {
                  if(var22 == var38) {
                     class267.field3667 = var15;
                     class37.field512 = var16;
                     var34 = false;
                     break;
                  }

                  var15 = class162.field2325[var22];
                  var16 = class162.field2326[var22];
                  var22 = var22 + 1 & 4095;
                  var35 = var15 - var19;
                  var36 = var16 - var20;
                  var24 = var15 - var10.x;
                  var25 = var16 - var10.y;
                  if(var9.vmethod3055(2, var15, var16, var10)) {
                     class267.field3667 = var15;
                     class37.field512 = var16;
                     var34 = true;
                     break;
                  }

                  var26 = class162.field2322[var35][var36] + 1;
                  if(var35 > 0 && class162.field2329[var35 - 1][var36] == 0 && (var23[var24 - 1][var25] & 19136782) == 0 && (var23[var24 - 1][var25 + 1] & 19136824) == 0) {
                     class162.field2325[var38] = var15 - 1;
                     class162.field2326[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35 - 1][var36] = 2;
                     class162.field2322[var35 - 1][var36] = var26;
                  }

                  if(var35 < 126 && class162.field2329[var35 + 1][var36] == 0 && (var23[var24 + 2][var25] & 19136899) == 0 && (var23[var24 + 2][var25 + 1] & 19136992) == 0) {
                     class162.field2325[var38] = var15 + 1;
                     class162.field2326[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35 + 1][var36] = 8;
                     class162.field2322[var35 + 1][var36] = var26;
                  }

                  if(var36 > 0 && class162.field2329[var35][var36 - 1] == 0 && (var23[var24][var25 - 1] & 19136782) == 0 && (var23[var24 + 1][var25 - 1] & 19136899) == 0) {
                     class162.field2325[var38] = var15;
                     class162.field2326[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35][var36 - 1] = 1;
                     class162.field2322[var35][var36 - 1] = var26;
                  }

                  if(var36 < 126 && class162.field2329[var35][var36 + 1] == 0 && (var23[var24][var25 + 2] & 19136824) == 0 && (var23[var24 + 1][var25 + 2] & 19136992) == 0) {
                     class162.field2325[var38] = var15;
                     class162.field2326[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35][var36 + 1] = 4;
                     class162.field2322[var35][var36 + 1] = var26;
                  }

                  if(var35 > 0 && var36 > 0 && class162.field2329[var35 - 1][var36 - 1] == 0 && (var23[var24 - 1][var25] & 19136830) == 0 && (var23[var24 - 1][var25 - 1] & 19136782) == 0 && (var23[var24][var25 - 1] & 19136911) == 0) {
                     class162.field2325[var38] = var15 - 1;
                     class162.field2326[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35 - 1][var36 - 1] = 3;
                     class162.field2322[var35 - 1][var36 - 1] = var26;
                  }

                  if(var35 < 126 && var36 > 0 && class162.field2329[var35 + 1][var36 - 1] == 0 && (var23[var24 + 1][var25 - 1] & 19136911) == 0 && (var23[var24 + 2][var25 - 1] & 19136899) == 0 && (var23[var24 + 2][var25] & 19136995) == 0) {
                     class162.field2325[var38] = var15 + 1;
                     class162.field2326[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35 + 1][var36 - 1] = 9;
                     class162.field2322[var35 + 1][var36 - 1] = var26;
                  }

                  if(var35 > 0 && var36 < 126 && class162.field2329[var35 - 1][var36 + 1] == 0 && (var23[var24 - 1][var25 + 1] & 19136830) == 0 && (var23[var24 - 1][var25 + 2] & 19136824) == 0 && (var23[var24][var25 + 2] & 19137016) == 0) {
                     class162.field2325[var38] = var15 - 1;
                     class162.field2326[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35 - 1][var36 + 1] = 6;
                     class162.field2322[var35 - 1][var36 + 1] = var26;
                  }

                  if(var35 < 126 && var36 < 126 && class162.field2329[var35 + 1][var36 + 1] == 0 && (var23[var24 + 1][var25 + 2] & 19137016) == 0 && (var23[var24 + 2][var25 + 2] & 19136992) == 0 && (var23[var24 + 2][var25 + 1] & 19136995) == 0) {
                     class162.field2325[var38] = var15 + 1;
                     class162.field2326[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35 + 1][var36 + 1] = 12;
                     class162.field2322[var35 + 1][var36 + 1] = var26;
                  }
               }

               var33 = var34;
            } else {
               var15 = var4;
               var16 = var5;
               var17 = 64;
               var18 = 64;
               var19 = var4 - var17;
               var20 = var5 - var18;
               class162.field2329[var17][var18] = 99;
               class162.field2322[var17][var18] = 0;
               var21 = 0;
               var22 = 0;
               class162.field2325[var21] = var4;
               var38 = var21 + 1;
               class162.field2326[var21] = var5;
               var23 = var10.flags;

               label954:
               while(true) {
                  label952:
                  while(true) {
                     do {
                        do {
                           do {
                              label929:
                              do {
                                 if(var38 == var22) {
                                    class267.field3667 = var15;
                                    class37.field512 = var16;
                                    var34 = false;
                                    break label954;
                                 }

                                 var15 = class162.field2325[var22];
                                 var16 = class162.field2326[var22];
                                 var22 = var22 + 1 & 4095;
                                 var35 = var15 - var19;
                                 var36 = var16 - var20;
                                 var24 = var15 - var10.x;
                                 var25 = var16 - var10.y;
                                 if(var9.vmethod3055(var8, var15, var16, var10)) {
                                    class267.field3667 = var15;
                                    class37.field512 = var16;
                                    var34 = true;
                                    break label954;
                                 }

                                 var26 = class162.field2322[var35][var36] + 1;
                                 if(var35 > 0 && class162.field2329[var35 - 1][var36] == 0 && (var23[var24 - 1][var25] & 19136782) == 0 && (var23[var24 - 1][var25 + var8 - 1] & 19136824) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8 - 1) {
                                          class162.field2325[var38] = var15 - 1;
                                          class162.field2326[var38] = var16;
                                          var38 = var38 + 1 & 4095;
                                          class162.field2329[var35 - 1][var36] = 2;
                                          class162.field2322[var35 - 1][var36] = var26;
                                          break;
                                       }

                                       if((var23[var24 - 1][var25 + var27] & 19136830) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var35 < 128 - var8 && class162.field2329[var35 + 1][var36] == 0 && (var23[var8 + var24][var25] & 19136899) == 0 && (var23[var8 + var24][var8 + var25 - 1] & 19136992) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8 - 1) {
                                          class162.field2325[var38] = var15 + 1;
                                          class162.field2326[var38] = var16;
                                          var38 = var38 + 1 & 4095;
                                          class162.field2329[var35 + 1][var36] = 8;
                                          class162.field2322[var35 + 1][var36] = var26;
                                          break;
                                       }

                                       if((var23[var8 + var24][var27 + var25] & 19136995) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var36 > 0 && class162.field2329[var35][var36 - 1] == 0 && (var23[var24][var25 - 1] & 19136782) == 0 && (var23[var24 + var8 - 1][var25 - 1] & 19136899) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8 - 1) {
                                          class162.field2325[var38] = var15;
                                          class162.field2326[var38] = var16 - 1;
                                          var38 = var38 + 1 & 4095;
                                          class162.field2329[var35][var36 - 1] = 1;
                                          class162.field2322[var35][var36 - 1] = var26;
                                          break;
                                       }

                                       if((var23[var24 + var27][var25 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var36 < 128 - var8 && class162.field2329[var35][var36 + 1] == 0 && (var23[var24][var8 + var25] & 19136824) == 0 && (var23[var24 + var8 - 1][var25 + var8] & 19136992) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8 - 1) {
                                          class162.field2325[var38] = var15;
                                          class162.field2326[var38] = var16 + 1;
                                          var38 = var38 + 1 & 4095;
                                          class162.field2329[var35][var36 + 1] = 4;
                                          class162.field2322[var35][var36 + 1] = var26;
                                          break;
                                       }

                                       if((var23[var27 + var24][var25 + var8] & 19137016) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var35 > 0 && var36 > 0 && class162.field2329[var35 - 1][var36 - 1] == 0 && (var23[var24 - 1][var25 - 1] & 19136782) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8) {
                                          class162.field2325[var38] = var15 - 1;
                                          class162.field2326[var38] = var16 - 1;
                                          var38 = var38 + 1 & 4095;
                                          class162.field2329[var35 - 1][var36 - 1] = 3;
                                          class162.field2322[var35 - 1][var36 - 1] = var26;
                                          break;
                                       }

                                       if((var23[var24 - 1][var27 + (var25 - 1)] & 19136830) != 0 || (var23[var27 + (var24 - 1)][var25 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var35 < 128 - var8 && var36 > 0 && class162.field2329[var35 + 1][var36 - 1] == 0 && (var23[var24 + var8][var25 - 1] & 19136899) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8) {
                                          class162.field2325[var38] = var15 + 1;
                                          class162.field2326[var38] = var16 - 1;
                                          var38 = var38 + 1 & 4095;
                                          class162.field2329[var35 + 1][var36 - 1] = 9;
                                          class162.field2322[var35 + 1][var36 - 1] = var26;
                                          break;
                                       }

                                       if((var23[var8 + var24][var25 - 1 + var27] & 19136995) != 0 || (var23[var24 + var27][var25 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var35 > 0 && var36 < 128 - var8 && class162.field2329[var35 - 1][var36 + 1] == 0 && (var23[var24 - 1][var8 + var25] & 19136824) == 0) {
                                    for(var27 = 1; var27 < var8; ++var27) {
                                       if((var23[var24 - 1][var27 + var25] & 19136830) != 0 || (var23[var24 - 1 + var27][var8 + var25] & 19137016) != 0) {
                                          continue label929;
                                       }
                                    }

                                    class162.field2325[var38] = var15 - 1;
                                    class162.field2326[var38] = var16 + 1;
                                    var38 = var38 + 1 & 4095;
                                    class162.field2329[var35 - 1][var36 + 1] = 6;
                                    class162.field2322[var35 - 1][var36 + 1] = var26;
                                 }
                              } while(var35 >= 128 - var8);
                           } while(var36 >= 128 - var8);
                        } while(class162.field2329[var35 + 1][var36 + 1] != 0);
                     } while((var23[var8 + var24][var25 + var8] & 19136992) != 0);

                     for(var27 = 1; var27 < var8; ++var27) {
                        if((var23[var24 + var27][var25 + var8] & 19137016) != 0 || (var23[var24 + var8][var25 + var27] & 19136995) != 0) {
                           continue label952;
                        }
                     }

                     class162.field2325[var38] = var15 + 1;
                     class162.field2326[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class162.field2329[var35 + 1][var36 + 1] = 12;
                     class162.field2322[var35 + 1][var36 + 1] = var26;
                  }
               }

               var33 = var34;
            }

            int var7;
            label1020: {
               var14 = var4 - 64;
               var15 = var5 - 64;
               var16 = class267.field3667;
               var35 = class37.field512;
               if(!var33) {
                  var36 = Integer.MAX_VALUE;
                  var19 = Integer.MAX_VALUE;
                  byte var37 = 10;
                  var38 = var9.field2335;
                  var22 = var9.field2333;
                  int var32 = var9.field2334;
                  var24 = var9.field2332;

                  for(var25 = var38 - var37; var25 <= var38 + var37; ++var25) {
                     for(var26 = var22 - var37; var26 <= var37 + var22; ++var26) {
                        var27 = var25 - var14;
                        int var28 = var26 - var15;
                        if(var27 >= 0 && var28 >= 0 && var27 < 128 && var28 < 128 && class162.field2322[var27][var28] < 100) {
                           int var29 = 0;
                           if(var25 < var38) {
                              var29 = var38 - var25;
                           } else if(var25 > var38 + var32 - 1) {
                              var29 = var25 - (var32 + var38 - 1);
                           }

                           int var30 = 0;
                           if(var26 < var22) {
                              var30 = var22 - var26;
                           } else if(var26 > var24 + var22 - 1) {
                              var30 = var26 - (var24 + var22 - 1);
                           }

                           int var31 = var30 * var30 + var29 * var29;
                           if(var31 < var36 || var36 == var31 && class162.field2322[var27][var28] < var19) {
                              var36 = var31;
                              var19 = class162.field2322[var27][var28];
                              var16 = var25;
                              var35 = var26;
                           }
                        }
                     }
                  }

                  if(var36 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label1020;
                  }
               }

               if(var16 == var4 && var35 == var5) {
                  var7 = 0;
               } else {
                  var18 = 0;
                  class162.field2325[var18] = var16;
                  var36 = var18 + 1;
                  class162.field2326[var18] = var35;

                  for(var19 = var20 = class162.field2329[var16 - var14][var35 - var15]; var4 != var16 || var35 != var5; var19 = class162.field2329[var16 - var14][var35 - var15]) {
                     if(var20 != var19) {
                        var20 = var19;
                        class162.field2325[var36] = var16;
                        class162.field2326[var36++] = var35;
                     }

                     if((var19 & 2) != 0) {
                        ++var16;
                     } else if((var19 & 8) != 0) {
                        --var16;
                     }

                     if((var19 & 1) != 0) {
                        ++var35;
                     } else if((var19 & 4) != 0) {
                        --var35;
                     }
                  }

                  var38 = 0;

                  while(var36-- > 0) {
                     var11[var38] = class162.field2325[var36];
                     var12[var38++] = class162.field2326[var36];
                     if(var38 >= var11.length) {
                        break;
                     }
                  }

                  var7 = var38;
               }
            }

            var13 = var7;
            if(var7 >= 1) {
               for(var14 = 0; var14 < var13 - 1; ++var14) {
                  var0.method1126(Client.field1208[var14], Client.field1209[var14], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)LFont;",
      garbageValue = "-572054119"
   )
   public static Font method478(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.method4125(var2);
      int var5 = var0.method4126(var4, var3);
      Font var6;
      if(!class7.method28(var0, var4, var5)) {
         var6 = null;
      } else {
         var6 = class254.method4524(var1.getConfigData(var4, var5));
      }

      return var6;
   }

   static {
      field495 = new class35(0);
      field496 = new class35(1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "-1001757704"
   )
   static void method479(GameEngine var0) {
      if(class92.worldSelectShown) {
         NPC.method1692(var0);
      } else {
         int var2;
         int var3;
         if((class59.field732 == 1 || !class233.field3202 && class59.field732 == 4) && class59.field745 >= class92.field1459 + 765 - 50 && class59.field750 >= 453) {
            XGrandExchangeOffer.field303.field1332 = !XGrandExchangeOffer.field303.field1332;
            ScriptState.method1052();
            if(!XGrandExchangeOffer.field303.field1332) {
               IndexData var1 = class22.indexTrack1;
               var2 = var1.method4125("scape main");
               var3 = var1.method4126(var2, "");
               class59.method985(var1, var2, var3, 255, false);
            } else {
               class164.method3060();
            }
         }

         if(Client.gameState != 5) {
            ++class92.field1452;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var9;
               if(Client.field1077 == 0) {
                  if(class59.field732 == 1 || !class233.field3202 && class59.field732 == 4) {
                     var9 = class92.field1459 + 5;
                     short var15 = 463;
                     byte var16 = 100;
                     byte var4 = 35;
                     if(class59.field745 >= var9 && class59.field745 <= var16 + var9 && class59.field750 >= var15 && class59.field750 <= var4 + var15) {
                        NPC.method1686();
                        return;
                     }
                  }

                  if(class36.worldServersDownload != null) {
                     NPC.method1686();
                  }
               }

               var9 = class59.field732;
               var2 = class59.field745;
               var3 = class59.field750;
               if(!class233.field3202 && var9 == 4) {
                  var9 = 1;
               }

               int var5;
               short var6;
               if(class92.loginIndex == 0) {
                  boolean var17 = false;

                  while(World.method1546()) {
                     if(class3.field27 == 84) {
                        var17 = true;
                     }
                  }

                  var5 = class92.loginWindowX + 180 - 80;
                  var6 = 291;
                  if(var9 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                     label769: {
                        String var7 = class60.method1007("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                           try {
                              Desktop.getDesktop().browse(new URI(var7));
                              break label769;
                           } catch (Exception var14) {
                              ;
                           }
                        }

                        if(class56.field690.startsWith("win")) {
                           class40.method534(var7, 0, "openjs");
                        } else if(class56.field690.startsWith("mac")) {
                           class40.method534(var7, 1, "openjs");
                        } else {
                           class40.method534(var7, 2, "openjs");
                        }
                     }
                  }

                  var5 = class92.loginWindowX + 180 + 80;
                  if(var9 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20 || var17) {
                     if((Client.flags & 33554432) != 0) {
                        class92.field1460 = "";
                        class92.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class92.loginMessage2 = "Your normal account will not be affected.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class92.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class92.loginMessage2 = "Players can attack each other almost everywhere";
                           class92.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class92.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class92.loginMessage2 = "Players can attack each other";
                           class92.loginMessage3 = "almost everywhere.";
                        }

                        class92.field1460 = "Warning!";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class92.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class92.loginMessage2 = "The Protect Item prayer will";
                        class92.loginMessage3 = "not work on this world.";
                        class92.field1460 = "Warning!";
                        class92.loginIndex = 1;
                        class92.loginIndex2 = 0;
                     } else {
                        class92.loginMessage1 = "";
                        class92.loginMessage2 = "Enter your username/email & password.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 2;
                        class92.loginIndex2 = 0;
                     }
                  }
               } else {
                  int var18;
                  short var20;
                  if(class92.loginIndex != 1) {
                     short var19;
                     if(class92.loginIndex == 2) {
                        var19 = 231;
                        var18 = var19 + 30;
                        if(var9 == 1 && var3 >= var18 - 15 && var3 < var18) {
                           class92.loginIndex2 = 0;
                        }

                        var18 += 15;
                        if(var9 == 1 && var3 >= var18 - 15 && var3 < var18) {
                           class92.loginIndex2 = 1;
                        }

                        var18 += 15;
                        var19 = 361;
                        if(var9 == 1 && var3 >= var19 - 15 && var3 < var19) {
                           WorldMapType2.method496("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }

                        var5 = class92.loginWindowX + 180 - 80;
                        var6 = 321;
                        if(var9 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                           class92.username = class92.username.trim();
                           if(class92.username.length() == 0) {
                              WorldMapType2.method496("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class92.password.length() == 0) {
                              WorldMapType2.method496("", "Please enter your password.", "");
                              return;
                           }

                           WorldMapType2.method496("", "Connecting to server...", "");
                           class92.field1454 = XGrandExchangeOffer.field303.preferences.containsKey(Integer.valueOf(class4.method4(class92.username)))?class149.field2217:class149.field2213;
                           class249.setGameState(20);
                           return;
                        }

                        var5 = class92.loginWindowX + 180 + 80;
                        if(var9 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20) {
                           class92.loginIndex = 0;
                           class92.username = "";
                           class92.password = "";
                           class134.authCodeForLogin = 0;
                           class231.authCode = "";
                           class92.field1464 = true;
                        }

                        while(true) {
                           while(World.method1546()) {
                              boolean var10 = false;

                              for(int var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var11) {
                                 if(class50.field642 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var11)) {
                                    var10 = true;
                                    break;
                                 }
                              }

                              if(class3.field27 == 13) {
                                 class92.loginIndex = 0;
                                 class92.username = "";
                                 class92.password = "";
                                 class134.authCodeForLogin = 0;
                                 class231.authCode = "";
                                 class92.field1464 = true;
                              } else if(class92.loginIndex2 == 0) {
                                 if(class3.field27 == 85 && class92.username.length() > 0) {
                                    class92.username = class92.username.substring(0, class92.username.length() - 1);
                                 }

                                 if(class3.field27 == 84 || class3.field27 == 80) {
                                    class92.loginIndex2 = 1;
                                 }

                                 if(var10 && class92.username.length() < 320) {
                                    class92.username = class92.username + class50.field642;
                                 }
                              } else if(class92.loginIndex2 == 1) {
                                 if(class3.field27 == 85 && class92.password.length() > 0) {
                                    class92.password = class92.password.substring(0, class92.password.length() - 1);
                                 }

                                 if(class3.field27 == 84 || class3.field27 == 80) {
                                    class92.loginIndex2 = 0;
                                 }

                                 if(class3.field27 == 84) {
                                    class92.username = class92.username.trim();
                                    if(class92.username.length() == 0) {
                                       WorldMapType2.method496("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class92.password.length() == 0) {
                                       WorldMapType2.method496("", "Please enter your password.", "");
                                       return;
                                    }

                                    WorldMapType2.method496("", "Connecting to server...", "");
                                    class92.field1454 = XGrandExchangeOffer.field303.preferences.containsKey(Integer.valueOf(class4.method4(class92.username)))?class149.field2217:class149.field2213;
                                    class249.setGameState(20);
                                    return;
                                 }

                                 if(var10 && class92.password.length() < 20) {
                                    class92.password = class92.password + class50.field642;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class92.loginIndex == 3) {
                        var18 = class92.loginWindowX + 180;
                        var20 = 276;
                        if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        }

                        var18 = class92.loginWindowX + 180;
                        var20 = 326;
                        if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                           WorldMapType2.method496("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class92.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var21;
                        int var22;
                        if(class92.loginIndex == 4) {
                           var18 = class92.loginWindowX + 180 - 80;
                           var20 = 321;
                           if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                              class231.authCode.trim();
                              if(class231.authCode.length() != 6) {
                                 WorldMapType2.method496("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              class134.authCodeForLogin = Integer.parseInt(class231.authCode);
                              class231.authCode = "";
                              class92.field1454 = class92.field1464?class149.field2214:class149.field2216;
                              WorldMapType2.method496("", "Connecting to server...", "");
                              class249.setGameState(20);
                              return;
                           }

                           if(var9 == 1 && var2 >= class92.loginWindowX + 180 - 9 && var2 <= class92.loginWindowX + 180 + 130 && var3 >= 263 && var3 <= 296) {
                              class92.field1464 = !class92.field1464;
                           }

                           if(var9 == 1 && var2 >= class92.loginWindowX + 180 - 34 && var2 <= class92.loginWindowX + 180 + 34 && var3 >= 351 && var3 <= 363) {
                              label784: {
                                 String var12 = class60.method1007("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                                 if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                    try {
                                       Desktop.getDesktop().browse(new URI(var12));
                                       break label784;
                                    } catch (Exception var13) {
                                       ;
                                    }
                                 }

                                 if(class56.field690.startsWith("win")) {
                                    class40.method534(var12, 0, "openjs");
                                 } else if(class56.field690.startsWith("mac")) {
                                    class40.method534(var12, 1, "openjs");
                                 } else {
                                    class40.method534(var12, 2, "openjs");
                                 }
                              }
                           }

                           var18 = class92.loginWindowX + 180 + 80;
                           if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                              class92.loginIndex = 0;
                              class92.username = "";
                              class92.password = "";
                              class134.authCodeForLogin = 0;
                              class231.authCode = "";
                           }

                           while(World.method1546()) {
                              var21 = false;

                              for(var22 = 0; var22 < "1234567890".length(); ++var22) {
                                 if(class50.field642 == "1234567890".charAt(var22)) {
                                    var21 = true;
                                    break;
                                 }
                              }

                              if(class3.field27 == 13) {
                                 class92.loginIndex = 0;
                                 class92.username = "";
                                 class92.password = "";
                                 class134.authCodeForLogin = 0;
                                 class231.authCode = "";
                              } else {
                                 if(class3.field27 == 85 && class231.authCode.length() > 0) {
                                    class231.authCode = class231.authCode.substring(0, class231.authCode.length() - 1);
                                 }

                                 if(class3.field27 == 84) {
                                    class231.authCode.trim();
                                    if(class231.authCode.length() != 6) {
                                       WorldMapType2.method496("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    class134.authCodeForLogin = Integer.parseInt(class231.authCode);
                                    class231.authCode = "";
                                    class92.field1454 = class92.field1464?class149.field2214:class149.field2216;
                                    WorldMapType2.method496("", "Connecting to server...", "");
                                    class249.setGameState(20);
                                    return;
                                 }

                                 if(var21 && class231.authCode.length() < 6) {
                                    class231.authCode = class231.authCode + class50.field642;
                                 }
                              }
                           }
                        } else if(class92.loginIndex == 5) {
                           var18 = class92.loginWindowX + 180 - 80;
                           var20 = 321;
                           if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                              class231.method4098();
                              return;
                           }

                           var18 = class92.loginWindowX + 180 + 80;
                           if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                              class92.loginMessage1 = "";
                              class92.loginMessage2 = "Enter your username/email & password.";
                              class92.loginMessage3 = "";
                              class92.loginIndex = 2;
                              class92.loginIndex2 = 0;
                              class92.password = "";
                           }

                           while(World.method1546()) {
                              var21 = false;

                              for(var22 = 0; var22 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var22) {
                                 if(class50.field642 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var22)) {
                                    var21 = true;
                                    break;
                                 }
                              }

                              if(class3.field27 == 13) {
                                 class92.loginMessage1 = "";
                                 class92.loginMessage2 = "Enter your username/email & password.";
                                 class92.loginMessage3 = "";
                                 class92.loginIndex = 2;
                                 class92.loginIndex2 = 0;
                                 class92.password = "";
                              } else {
                                 if(class3.field27 == 85 && class92.username.length() > 0) {
                                    class92.username = class92.username.substring(0, class92.username.length() - 1);
                                 }

                                 if(class3.field27 == 84) {
                                    class231.method4098();
                                    return;
                                 }

                                 if(var21 && class92.username.length() < 320) {
                                    class92.username = class92.username + class50.field642;
                                 }
                              }
                           }
                        } else if(class92.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!World.method1546()) {
                                    var19 = 321;
                                    if(var9 == 1 && var3 >= var19 - 20 && var3 <= var19 + 20) {
                                       class92.loginMessage1 = "";
                                       class92.loginMessage2 = "Enter your username/email & password.";
                                       class92.loginMessage3 = "";
                                       class92.loginIndex = 2;
                                       class92.loginIndex2 = 0;
                                       class92.password = "";
                                    }

                                    return;
                                 }
                              } while(class3.field27 != 84 && class3.field27 != 13);

                              class92.loginMessage1 = "";
                              class92.loginMessage2 = "Enter your username/email & password.";
                              class92.loginMessage3 = "";
                              class92.loginIndex = 2;
                              class92.loginIndex2 = 0;
                              class92.password = "";
                           }
                        }
                     }
                  } else {
                     while(World.method1546()) {
                        if(class3.field27 == 84) {
                           class92.loginMessage1 = "";
                           class92.loginMessage2 = "Enter your username/email & password.";
                           class92.loginMessage3 = "";
                           class92.loginIndex = 2;
                           class92.loginIndex2 = 0;
                        } else if(class3.field27 == 13) {
                           class92.loginIndex = 0;
                        }
                     }

                     var18 = class92.loginWindowX + 180 - 80;
                     var20 = 321;
                     if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                        class92.loginMessage1 = "";
                        class92.loginMessage2 = "Enter your username/email & password.";
                        class92.loginMessage3 = "";
                        class92.loginIndex = 2;
                        class92.loginIndex2 = 0;
                     }

                     var18 = class92.loginWindowX + 180 + 80;
                     if(var9 == 1 && var2 >= var18 - 75 && var2 <= var18 + 75 && var3 >= var20 - 20 && var3 <= var20 + 20) {
                        class92.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass186;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-2007004681"
   )
   static String method480(class186 var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         class185 var3 = (class185)var0.method3475((long)var1);
         return var3 == null?var2:(String)var3.field2457;
      }
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class35(int var1) {
      this.field497 = var1;
   }
}
