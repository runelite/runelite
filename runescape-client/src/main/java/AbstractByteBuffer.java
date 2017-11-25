import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("x")
   static boolean field2515;
   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   static SpritePixels[] field2514;

   static {
      field2515 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-862626238"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "100"
   )
   @Export("put")
   abstract void put(byte[] var1);

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(Lbw;IIBS)V",
      garbageValue = "22789"
   )
   static final void method3542(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.getSize();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.getSize();
            class164 var9 = GraphicsObject.method1725(var1, var2);
            CollisionData var10 = Client.collisionMaps[var0.field853];
            int[] var11 = Client.field1131;
            int[] var12 = Client.field888;

            int var13;
            int var14;
            for(var13 = 0; var13 < 128; ++var13) {
               for(var14 = 0; var14 < 128; ++var14) {
                  class163.field2205[var13][var14] = 0;
                  class163.field2204[var13][var14] = 99999999;
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
               class163.field2205[var17][var18] = 99;
               class163.field2204[var17][var18] = 0;
               var21 = 0;
               var22 = 0;
               class163.field2209[var21] = var4;
               var38 = var21 + 1;
               class163.field2207[var21] = var5;
               var23 = var10.flags;

               while(true) {
                  if(var38 == var22) {
                     class163.field2203 = var15;
                     ChatLineBuffer.field1464 = var16;
                     var34 = false;
                     break;
                  }

                  var15 = class163.field2209[var22];
                  var16 = class163.field2207[var22];
                  var22 = var22 + 1 & 4095;
                  var35 = var15 - var19;
                  var36 = var16 - var20;
                  var24 = var15 - var10.x;
                  var25 = var16 - var10.y;
                  if(var9.vmethod3188(1, var15, var16, var10)) {
                     class163.field2203 = var15;
                     ChatLineBuffer.field1464 = var16;
                     var34 = true;
                     break;
                  }

                  var26 = class163.field2204[var35][var36] + 1;
                  if(var35 > 0 && class163.field2205[var35 - 1][var36] == 0 && (var23[var24 - 1][var25] & 19136776) == 0) {
                     class163.field2209[var38] = var15 - 1;
                     class163.field2207[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35 - 1][var36] = 2;
                     class163.field2204[var35 - 1][var36] = var26;
                  }

                  if(var35 < 127 && class163.field2205[var35 + 1][var36] == 0 && (var23[var24 + 1][var25] & 19136896) == 0) {
                     class163.field2209[var38] = var15 + 1;
                     class163.field2207[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35 + 1][var36] = 8;
                     class163.field2204[var35 + 1][var36] = var26;
                  }

                  if(var36 > 0 && class163.field2205[var35][var36 - 1] == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
                     class163.field2209[var38] = var15;
                     class163.field2207[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35][var36 - 1] = 1;
                     class163.field2204[var35][var36 - 1] = var26;
                  }

                  if(var36 < 127 && class163.field2205[var35][var36 + 1] == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
                     class163.field2209[var38] = var15;
                     class163.field2207[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35][var36 + 1] = 4;
                     class163.field2204[var35][var36 + 1] = var26;
                  }

                  if(var35 > 0 && var36 > 0 && class163.field2205[var35 - 1][var36 - 1] == 0 && (var23[var24 - 1][var25 - 1] & 19136782) == 0 && (var23[var24 - 1][var25] & 19136776) == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
                     class163.field2209[var38] = var15 - 1;
                     class163.field2207[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35 - 1][var36 - 1] = 3;
                     class163.field2204[var35 - 1][var36 - 1] = var26;
                  }

                  if(var35 < 127 && var36 > 0 && class163.field2205[var35 + 1][var36 - 1] == 0 && (var23[var24 + 1][var25 - 1] & 19136899) == 0 && (var23[var24 + 1][var25] & 19136896) == 0 && (var23[var24][var25 - 1] & 19136770) == 0) {
                     class163.field2209[var38] = var15 + 1;
                     class163.field2207[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35 + 1][var36 - 1] = 9;
                     class163.field2204[var35 + 1][var36 - 1] = var26;
                  }

                  if(var35 > 0 && var36 < 127 && class163.field2205[var35 - 1][var36 + 1] == 0 && (var23[var24 - 1][var25 + 1] & 19136824) == 0 && (var23[var24 - 1][var25] & 19136776) == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
                     class163.field2209[var38] = var15 - 1;
                     class163.field2207[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35 - 1][var36 + 1] = 6;
                     class163.field2204[var35 - 1][var36 + 1] = var26;
                  }

                  if(var35 < 127 && var36 < 127 && class163.field2205[var35 + 1][var36 + 1] == 0 && (var23[var24 + 1][var25 + 1] & 19136992) == 0 && (var23[var24 + 1][var25] & 19136896) == 0 && (var23[var24][var25 + 1] & 19136800) == 0) {
                     class163.field2209[var38] = var15 + 1;
                     class163.field2207[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35 + 1][var36 + 1] = 12;
                     class163.field2204[var35 + 1][var36 + 1] = var26;
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
               class163.field2205[var17][var18] = 99;
               class163.field2204[var17][var18] = 0;
               var21 = 0;
               var22 = 0;
               class163.field2209[var21] = var4;
               var38 = var21 + 1;
               class163.field2207[var21] = var5;
               var23 = var10.flags;

               while(true) {
                  if(var38 == var22) {
                     class163.field2203 = var15;
                     ChatLineBuffer.field1464 = var16;
                     var34 = false;
                     break;
                  }

                  var15 = class163.field2209[var22];
                  var16 = class163.field2207[var22];
                  var22 = var22 + 1 & 4095;
                  var35 = var15 - var19;
                  var36 = var16 - var20;
                  var24 = var15 - var10.x;
                  var25 = var16 - var10.y;
                  if(var9.vmethod3188(2, var15, var16, var10)) {
                     class163.field2203 = var15;
                     ChatLineBuffer.field1464 = var16;
                     var34 = true;
                     break;
                  }

                  var26 = class163.field2204[var35][var36] + 1;
                  if(var35 > 0 && class163.field2205[var35 - 1][var36] == 0 && (var23[var24 - 1][var25] & 19136782) == 0 && (var23[var24 - 1][var25 + 1] & 19136824) == 0) {
                     class163.field2209[var38] = var15 - 1;
                     class163.field2207[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35 - 1][var36] = 2;
                     class163.field2204[var35 - 1][var36] = var26;
                  }

                  if(var35 < 126 && class163.field2205[var35 + 1][var36] == 0 && (var23[var24 + 2][var25] & 19136899) == 0 && (var23[var24 + 2][var25 + 1] & 19136992) == 0) {
                     class163.field2209[var38] = var15 + 1;
                     class163.field2207[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35 + 1][var36] = 8;
                     class163.field2204[var35 + 1][var36] = var26;
                  }

                  if(var36 > 0 && class163.field2205[var35][var36 - 1] == 0 && (var23[var24][var25 - 1] & 19136782) == 0 && (var23[var24 + 1][var25 - 1] & 19136899) == 0) {
                     class163.field2209[var38] = var15;
                     class163.field2207[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35][var36 - 1] = 1;
                     class163.field2204[var35][var36 - 1] = var26;
                  }

                  if(var36 < 126 && class163.field2205[var35][var36 + 1] == 0 && (var23[var24][var25 + 2] & 19136824) == 0 && (var23[var24 + 1][var25 + 2] & 19136992) == 0) {
                     class163.field2209[var38] = var15;
                     class163.field2207[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35][var36 + 1] = 4;
                     class163.field2204[var35][var36 + 1] = var26;
                  }

                  if(var35 > 0 && var36 > 0 && class163.field2205[var35 - 1][var36 - 1] == 0 && (var23[var24 - 1][var25] & 19136830) == 0 && (var23[var24 - 1][var25 - 1] & 19136782) == 0 && (var23[var24][var25 - 1] & 19136911) == 0) {
                     class163.field2209[var38] = var15 - 1;
                     class163.field2207[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35 - 1][var36 - 1] = 3;
                     class163.field2204[var35 - 1][var36 - 1] = var26;
                  }

                  if(var35 < 126 && var36 > 0 && class163.field2205[var35 + 1][var36 - 1] == 0 && (var23[var24 + 1][var25 - 1] & 19136911) == 0 && (var23[var24 + 2][var25 - 1] & 19136899) == 0 && (var23[var24 + 2][var25] & 19136995) == 0) {
                     class163.field2209[var38] = var15 + 1;
                     class163.field2207[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35 + 1][var36 - 1] = 9;
                     class163.field2204[var35 + 1][var36 - 1] = var26;
                  }

                  if(var35 > 0 && var36 < 126 && class163.field2205[var35 - 1][var36 + 1] == 0 && (var23[var24 - 1][var25 + 1] & 19136830) == 0 && (var23[var24 - 1][var25 + 2] & 19136824) == 0 && (var23[var24][var25 + 2] & 19137016) == 0) {
                     class163.field2209[var38] = var15 - 1;
                     class163.field2207[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35 - 1][var36 + 1] = 6;
                     class163.field2204[var35 - 1][var36 + 1] = var26;
                  }

                  if(var35 < 126 && var36 < 126 && class163.field2205[var35 + 1][var36 + 1] == 0 && (var23[var24 + 1][var25 + 2] & 19137016) == 0 && (var23[var24 + 2][var25 + 2] & 19136992) == 0 && (var23[var24 + 2][var25 + 1] & 19136995) == 0) {
                     class163.field2209[var38] = var15 + 1;
                     class163.field2207[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35 + 1][var36 + 1] = 12;
                     class163.field2204[var35 + 1][var36 + 1] = var26;
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
               class163.field2205[var17][var18] = 99;
               class163.field2204[var17][var18] = 0;
               var21 = 0;
               var22 = 0;
               class163.field2209[var21] = var4;
               var38 = var21 + 1;
               class163.field2207[var21] = var5;
               var23 = var10.flags;

               label813:
               while(true) {
                  label811:
                  while(true) {
                     do {
                        do {
                           do {
                              label788:
                              do {
                                 if(var22 == var38) {
                                    class163.field2203 = var15;
                                    ChatLineBuffer.field1464 = var16;
                                    var34 = false;
                                    break label813;
                                 }

                                 var15 = class163.field2209[var22];
                                 var16 = class163.field2207[var22];
                                 var22 = var22 + 1 & 4095;
                                 var35 = var15 - var19;
                                 var36 = var16 - var20;
                                 var24 = var15 - var10.x;
                                 var25 = var16 - var10.y;
                                 if(var9.vmethod3188(var8, var15, var16, var10)) {
                                    class163.field2203 = var15;
                                    ChatLineBuffer.field1464 = var16;
                                    var34 = true;
                                    break label813;
                                 }

                                 var26 = class163.field2204[var35][var36] + 1;
                                 if(var35 > 0 && class163.field2205[var35 - 1][var36] == 0 && (var23[var24 - 1][var25] & 19136782) == 0 && (var23[var24 - 1][var25 + var8 - 1] & 19136824) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8 - 1) {
                                          class163.field2209[var38] = var15 - 1;
                                          class163.field2207[var38] = var16;
                                          var38 = var38 + 1 & 4095;
                                          class163.field2205[var35 - 1][var36] = 2;
                                          class163.field2204[var35 - 1][var36] = var26;
                                          break;
                                       }

                                       if((var23[var24 - 1][var27 + var25] & 19136830) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var35 < 128 - var8 && class163.field2205[var35 + 1][var36] == 0 && (var23[var8 + var24][var25] & 19136899) == 0 && (var23[var24 + var8][var8 + var25 - 1] & 19136992) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8 - 1) {
                                          class163.field2209[var38] = var15 + 1;
                                          class163.field2207[var38] = var16;
                                          var38 = var38 + 1 & 4095;
                                          class163.field2205[var35 + 1][var36] = 8;
                                          class163.field2204[var35 + 1][var36] = var26;
                                          break;
                                       }

                                       if((var23[var8 + var24][var25 + var27] & 19136995) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var36 > 0 && class163.field2205[var35][var36 - 1] == 0 && (var23[var24][var25 - 1] & 19136782) == 0 && (var23[var8 + var24 - 1][var25 - 1] & 19136899) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8 - 1) {
                                          class163.field2209[var38] = var15;
                                          class163.field2207[var38] = var16 - 1;
                                          var38 = var38 + 1 & 4095;
                                          class163.field2205[var35][var36 - 1] = 1;
                                          class163.field2204[var35][var36 - 1] = var26;
                                          break;
                                       }

                                       if((var23[var27 + var24][var25 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var36 < 128 - var8 && class163.field2205[var35][var36 + 1] == 0 && (var23[var24][var8 + var25] & 19136824) == 0 && (var23[var8 + var24 - 1][var8 + var25] & 19136992) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8 - 1) {
                                          class163.field2209[var38] = var15;
                                          class163.field2207[var38] = var16 + 1;
                                          var38 = var38 + 1 & 4095;
                                          class163.field2205[var35][var36 + 1] = 4;
                                          class163.field2204[var35][var36 + 1] = var26;
                                          break;
                                       }

                                       if((var23[var24 + var27][var8 + var25] & 19137016) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var35 > 0 && var36 > 0 && class163.field2205[var35 - 1][var36 - 1] == 0 && (var23[var24 - 1][var25 - 1] & 19136782) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8) {
                                          class163.field2209[var38] = var15 - 1;
                                          class163.field2207[var38] = var16 - 1;
                                          var38 = var38 + 1 & 4095;
                                          class163.field2205[var35 - 1][var36 - 1] = 3;
                                          class163.field2204[var35 - 1][var36 - 1] = var26;
                                          break;
                                       }

                                       if((var23[var24 - 1][var27 + (var25 - 1)] & 19136830) != 0 || (var23[var27 + (var24 - 1)][var25 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var35 < 128 - var8 && var36 > 0 && class163.field2205[var35 + 1][var36 - 1] == 0 && (var23[var8 + var24][var25 - 1] & 19136899) == 0) {
                                    var27 = 1;

                                    while(true) {
                                       if(var27 >= var8) {
                                          class163.field2209[var38] = var15 + 1;
                                          class163.field2207[var38] = var16 - 1;
                                          var38 = var38 + 1 & 4095;
                                          class163.field2205[var35 + 1][var36 - 1] = 9;
                                          class163.field2204[var35 + 1][var36 - 1] = var26;
                                          break;
                                       }

                                       if((var23[var24 + var8][var27 + (var25 - 1)] & 19136995) != 0 || (var23[var27 + var24][var25 - 1] & 19136911) != 0) {
                                          break;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var35 > 0 && var36 < 128 - var8 && class163.field2205[var35 - 1][var36 + 1] == 0 && (var23[var24 - 1][var25 + var8] & 19136824) == 0) {
                                    for(var27 = 1; var27 < var8; ++var27) {
                                       if((var23[var24 - 1][var25 + var27] & 19136830) != 0 || (var23[var27 + (var24 - 1)][var25 + var8] & 19137016) != 0) {
                                          continue label788;
                                       }
                                    }

                                    class163.field2209[var38] = var15 - 1;
                                    class163.field2207[var38] = var16 + 1;
                                    var38 = var38 + 1 & 4095;
                                    class163.field2205[var35 - 1][var36 + 1] = 6;
                                    class163.field2204[var35 - 1][var36 + 1] = var26;
                                 }
                              } while(var35 >= 128 - var8);
                           } while(var36 >= 128 - var8);
                        } while(class163.field2205[var35 + 1][var36 + 1] != 0);
                     } while((var23[var24 + var8][var8 + var25] & 19136992) != 0);

                     for(var27 = 1; var27 < var8; ++var27) {
                        if((var23[var24 + var27][var8 + var25] & 19137016) != 0 || (var23[var8 + var24][var25 + var27] & 19136995) != 0) {
                           continue label811;
                        }
                     }

                     class163.field2209[var38] = var15 + 1;
                     class163.field2207[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2205[var35 + 1][var36 + 1] = 12;
                     class163.field2204[var35 + 1][var36 + 1] = var26;
                  }
               }

               var33 = var34;
            }

            int var7;
            label879: {
               var14 = var4 - 64;
               var15 = var5 - 64;
               var16 = class163.field2203;
               var35 = ChatLineBuffer.field1464;
               if(!var33) {
                  var36 = Integer.MAX_VALUE;
                  var19 = Integer.MAX_VALUE;
                  byte var37 = 10;
                  var38 = var9.field2210;
                  var22 = var9.field2211;
                  int var32 = var9.field2212;
                  var24 = var9.field2218;

                  for(var25 = var38 - var37; var25 <= var38 + var37; ++var25) {
                     for(var26 = var22 - var37; var26 <= var22 + var37; ++var26) {
                        var27 = var25 - var14;
                        int var28 = var26 - var15;
                        if(var27 >= 0 && var28 >= 0 && var27 < 128 && var28 < 128 && class163.field2204[var27][var28] < 100) {
                           int var29 = 0;
                           if(var25 < var38) {
                              var29 = var38 - var25;
                           } else if(var25 > var32 + var38 - 1) {
                              var29 = var25 - (var38 + var32 - 1);
                           }

                           int var30 = 0;
                           if(var26 < var22) {
                              var30 = var22 - var26;
                           } else if(var26 > var24 + var22 - 1) {
                              var30 = var26 - (var24 + var22 - 1);
                           }

                           int var31 = var30 * var30 + var29 * var29;
                           if(var31 < var36 || var36 == var31 && class163.field2204[var27][var28] < var19) {
                              var36 = var31;
                              var19 = class163.field2204[var27][var28];
                              var16 = var25;
                              var35 = var26;
                           }
                        }
                     }
                  }

                  if(var36 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label879;
                  }
               }

               if(var16 == var4 && var5 == var35) {
                  var7 = 0;
               } else {
                  var18 = 0;
                  class163.field2209[var18] = var16;
                  var36 = var18 + 1;
                  class163.field2207[var18] = var35;

                  for(var19 = var20 = class163.field2205[var16 - var14][var35 - var15]; var16 != var4 || var5 != var35; var19 = class163.field2205[var16 - var14][var35 - var15]) {
                     if(var19 != var20) {
                        var20 = var19;
                        class163.field2209[var36] = var16;
                        class163.field2207[var36++] = var35;
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
                     var11[var38] = class163.field2209[var36];
                     var12[var38++] = class163.field2207[var36];
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
                  var0.method1157(Client.field1131[var14], Client.field888[var14], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Lhx;IIII)V",
      garbageValue = "564581217"
   )
   static final void method3541(Widget var0, int var1, int var2, int var3) {
      class217 var4 = var0.method4181(false);
      if(var4 != null) {
         if(Client.field1088 < 3) {
            class27.compass.method5272(var1, var2, var4.field2683, var4.field2682, 25, 25, Client.mapAngle, 256, var4.field2684, var4.field2681);
         } else {
            Rasterizer2D.method5159(var1, var2, 0, var4.field2684, var4.field2681);
         }

      }
   }
}
