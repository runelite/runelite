import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class38 implements class42 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1361445081
   )
   int field510;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -789131831
   )
   int field511;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -324093373
   )
   int field512;
   @ObfuscatedName("cj")
   static IndexData field513;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 144920469
   )
   int field514;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1760361413
   )
   int field515;
   @ObfuscatedName("bp")
   static ModIcon field518;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1095796627
   )
   int field519;

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-983201831"
   )
   static final void method512() {
      for(class76 var0 = (class76)Client.field1021.method3660(); var0 != null; var0 = (class76)Client.field1021.method3661()) {
         if(var0.field1185 == -1) {
            var0.field1184 = 0;
            class69.method1115(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(J)V",
      garbageValue = "1"
   )
   static final void method513(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method514() {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "437687546"
   )
   public boolean vmethod716(int var1, int var2) {
      return var1 >> 6 == this.field514 && var2 >> 6 == this.field515;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "892960012"
   )
   public int[] vmethod717(int var1, int var2, int var3) {
      if(!this.vmethod724(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field514 * 64 - this.field510 * 64 + var2, var3 + (this.field515 * 64 - this.field512 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1671424373"
   )
   public void vmethod719(Buffer var1) {
      this.field519 = var1.readUnsignedByte();
      this.field511 = var1.readUnsignedByte();
      this.field510 = var1.readUnsignedShort();
      this.field512 = var1.readUnsignedShort();
      this.field514 = var1.readUnsignedShort();
      this.field515 = var1.readUnsignedShort();
      this.method514();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lclass212;",
      garbageValue = "-820164631"
   )
   public class212 vmethod718(int var1, int var2) {
      if(!this.vmethod716(var1, var2)) {
         return null;
      } else {
         int var3 = var1 + (this.field510 * 64 - this.field514 * 64);
         int var4 = var2 + (this.field512 * 64 - this.field515 * 64);
         return new class212(this.field519, var3, var4);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-5"
   )
   public boolean vmethod724(int var1, int var2, int var3) {
      return var1 >= this.field519 && var1 < this.field519 + this.field511?var2 >> 6 == this.field510 && this.field512 == var3 >> 6:false;
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIBI)V",
      garbageValue = "-2127342321"
   )
   static final void method537(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.method1143();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.method1143();
            Client.field1168.field2289 = var1;
            Client.field1168.field2287 = var2;
            Client.field1168.field2288 = 1;
            Client.field1168.field2286 = 1;
            class73 var9 = Client.field1168;
            class73 var10 = var9;
            CollisionData var11 = Client.collisionMaps[var0.field874];
            int[] var12 = Client.field1169;
            int[] var13 = Client.field1170;

            int var14;
            int var15;
            for(var14 = 0; var14 < 128; ++var14) {
               for(var15 = 0; var15 < 128; ++var15) {
                  class162.field2281[var14][var15] = 0;
                  class162.field2282[var14][var15] = 99999999;
               }
            }

            int var16;
            int var17;
            byte var18;
            byte var19;
            int var20;
            int var21;
            byte var22;
            int var23;
            int[][] var24;
            int var25;
            int var26;
            int var27;
            boolean var34;
            boolean var35;
            int var36;
            int var37;
            int var39;
            if(var8 == 1) {
               var16 = var4;
               var17 = var5;
               var18 = 64;
               var19 = 64;
               var20 = var4 - var18;
               var21 = var5 - var19;
               class162.field2281[var18][var19] = 99;
               class162.field2282[var18][var19] = 0;
               var22 = 0;
               var23 = 0;
               class162.field2284[var22] = var4;
               var39 = var22 + 1;
               class162.field2279[var22] = var5;
               var24 = var11.flags;

               while(true) {
                  if(var23 == var39) {
                     class162.field2280 = var16;
                     class227.field3134 = var17;
                     var35 = false;
                     break;
                  }

                  var16 = class162.field2284[var23];
                  var17 = class162.field2279[var23];
                  var23 = var23 + 1 & 4095;
                  var36 = var16 - var20;
                  var37 = var17 - var21;
                  var25 = var16 - var11.x;
                  var26 = var17 - var11.y;
                  if(var10.vmethod3110(1, var16, var17, var11)) {
                     class162.field2280 = var16;
                     class227.field3134 = var17;
                     var35 = true;
                     break;
                  }

                  var27 = class162.field2282[var36][var37] + 1;
                  if(var36 > 0 && class162.field2281[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136776) == 0) {
                     class162.field2284[var39] = var16 - 1;
                     class162.field2279[var39] = var17;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36 - 1][var37] = 2;
                     class162.field2282[var36 - 1][var37] = var27;
                  }

                  if(var36 < 127 && class162.field2281[var36 + 1][var37] == 0 && (var24[var25 + 1][var26] & 19136896) == 0) {
                     class162.field2284[var39] = var16 + 1;
                     class162.field2279[var39] = var17;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36 + 1][var37] = 8;
                     class162.field2282[var36 + 1][var37] = var27;
                  }

                  if(var37 > 0 && class162.field2281[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                     class162.field2284[var39] = var16;
                     class162.field2279[var39] = var17 - 1;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36][var37 - 1] = 1;
                     class162.field2282[var36][var37 - 1] = var27;
                  }

                  if(var37 < 127 && class162.field2281[var36][var37 + 1] == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                     class162.field2284[var39] = var16;
                     class162.field2279[var39] = var17 + 1;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36][var37 + 1] = 4;
                     class162.field2282[var36][var37 + 1] = var27;
                  }

                  if(var36 > 0 && var37 > 0 && class162.field2281[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                     class162.field2284[var39] = var16 - 1;
                     class162.field2279[var39] = var17 - 1;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36 - 1][var37 - 1] = 3;
                     class162.field2282[var36 - 1][var37 - 1] = var27;
                  }

                  if(var36 < 127 && var37 > 0 && class162.field2281[var36 + 1][var37 - 1] == 0 && (var24[var25 + 1][var26 - 1] & 19136899) == 0 && (var24[var25 + 1][var26] & 19136896) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                     class162.field2284[var39] = var16 + 1;
                     class162.field2279[var39] = var17 - 1;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36 + 1][var37 - 1] = 9;
                     class162.field2282[var36 + 1][var37 - 1] = var27;
                  }

                  if(var36 > 0 && var37 < 127 && class162.field2281[var36 - 1][var37 + 1] == 0 && (var24[var25 - 1][var26 + 1] & 19136824) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                     class162.field2284[var39] = var16 - 1;
                     class162.field2279[var39] = var17 + 1;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36 - 1][var37 + 1] = 6;
                     class162.field2282[var36 - 1][var37 + 1] = var27;
                  }

                  if(var36 < 127 && var37 < 127 && class162.field2281[var36 + 1][var37 + 1] == 0 && (var24[var25 + 1][var26 + 1] & 19136992) == 0 && (var24[var25 + 1][var26] & 19136896) == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                     class162.field2284[var39] = var16 + 1;
                     class162.field2279[var39] = var17 + 1;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36 + 1][var37 + 1] = 12;
                     class162.field2282[var36 + 1][var37 + 1] = var27;
                  }
               }

               var34 = var35;
            } else if(var8 == 2) {
               var16 = var4;
               var17 = var5;
               var18 = 64;
               var19 = 64;
               var20 = var4 - var18;
               var21 = var5 - var19;
               class162.field2281[var18][var19] = 99;
               class162.field2282[var18][var19] = 0;
               var22 = 0;
               var23 = 0;
               class162.field2284[var22] = var4;
               var39 = var22 + 1;
               class162.field2279[var22] = var5;
               var24 = var11.flags;

               while(true) {
                  if(var39 == var23) {
                     class162.field2280 = var16;
                     class227.field3134 = var17;
                     var35 = false;
                     break;
                  }

                  var16 = class162.field2284[var23];
                  var17 = class162.field2279[var23];
                  var23 = var23 + 1 & 4095;
                  var36 = var16 - var20;
                  var37 = var17 - var21;
                  var25 = var16 - var11.x;
                  var26 = var17 - var11.y;
                  if(var10.vmethod3110(2, var16, var17, var11)) {
                     class162.field2280 = var16;
                     class227.field3134 = var17;
                     var35 = true;
                     break;
                  }

                  var27 = class162.field2282[var36][var37] + 1;
                  if(var36 > 0 && class162.field2281[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136782) == 0 && (var24[var25 - 1][var26 + 1] & 19136824) == 0) {
                     class162.field2284[var39] = var16 - 1;
                     class162.field2279[var39] = var17;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36 - 1][var37] = 2;
                     class162.field2282[var36 - 1][var37] = var27;
                  }

                  if(var36 < 126 && class162.field2281[var36 + 1][var37] == 0 && (var24[var25 + 2][var26] & 19136899) == 0 && (var24[var25 + 2][var26 + 1] & 19136992) == 0) {
                     class162.field2284[var39] = var16 + 1;
                     class162.field2279[var39] = var17;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36 + 1][var37] = 8;
                     class162.field2282[var36 + 1][var37] = var27;
                  }

                  if(var37 > 0 && class162.field2281[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136782) == 0 && (var24[var25 + 1][var26 - 1] & 19136899) == 0) {
                     class162.field2284[var39] = var16;
                     class162.field2279[var39] = var17 - 1;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36][var37 - 1] = 1;
                     class162.field2282[var36][var37 - 1] = var27;
                  }

                  if(var37 < 126 && class162.field2281[var36][var37 + 1] == 0 && (var24[var25][var26 + 2] & 19136824) == 0 && (var24[var25 + 1][var26 + 2] & 19136992) == 0) {
                     class162.field2284[var39] = var16;
                     class162.field2279[var39] = var17 + 1;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36][var37 + 1] = 4;
                     class162.field2282[var36][var37 + 1] = var27;
                  }

                  if(var36 > 0 && var37 > 0 && class162.field2281[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26] & 19136830) == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0 && (var24[var25][var26 - 1] & 19136911) == 0) {
                     class162.field2284[var39] = var16 - 1;
                     class162.field2279[var39] = var17 - 1;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36 - 1][var37 - 1] = 3;
                     class162.field2282[var36 - 1][var37 - 1] = var27;
                  }

                  if(var36 < 126 && var37 > 0 && class162.field2281[var36 + 1][var37 - 1] == 0 && (var24[var25 + 1][var26 - 1] & 19136911) == 0 && (var24[var25 + 2][var26 - 1] & 19136899) == 0 && (var24[var25 + 2][var26] & 19136995) == 0) {
                     class162.field2284[var39] = var16 + 1;
                     class162.field2279[var39] = var17 - 1;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36 + 1][var37 - 1] = 9;
                     class162.field2282[var36 + 1][var37 - 1] = var27;
                  }

                  if(var36 > 0 && var37 < 126 && class162.field2281[var36 - 1][var37 + 1] == 0 && (var24[var25 - 1][var26 + 1] & 19136830) == 0 && (var24[var25 - 1][var26 + 2] & 19136824) == 0 && (var24[var25][var26 + 2] & 19137016) == 0) {
                     class162.field2284[var39] = var16 - 1;
                     class162.field2279[var39] = var17 + 1;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36 - 1][var37 + 1] = 6;
                     class162.field2282[var36 - 1][var37 + 1] = var27;
                  }

                  if(var36 < 126 && var37 < 126 && class162.field2281[var36 + 1][var37 + 1] == 0 && (var24[var25 + 1][var26 + 2] & 19137016) == 0 && (var24[var25 + 2][var26 + 2] & 19136992) == 0 && (var24[var25 + 2][var26 + 1] & 19136995) == 0) {
                     class162.field2284[var39] = var16 + 1;
                     class162.field2279[var39] = var17 + 1;
                     var39 = var39 + 1 & 4095;
                     class162.field2281[var36 + 1][var37 + 1] = 12;
                     class162.field2282[var36 + 1][var37 + 1] = var27;
                  }
               }

               var34 = var35;
            } else {
               var34 = class14.method78(var4, var5, var8, var9, var11);
            }

            int var7;
            label632: {
               var15 = var4 - 64;
               var16 = var5 - 64;
               var17 = class162.field2280;
               var36 = class227.field3134;
               if(!var34) {
                  var37 = Integer.MAX_VALUE;
                  var20 = Integer.MAX_VALUE;
                  byte var38 = 10;
                  var39 = var10.field2289;
                  var23 = var10.field2287;
                  int var33 = var10.field2288;
                  var25 = var10.field2286;

                  for(var26 = var39 - var38; var26 <= var39 + var38; ++var26) {
                     for(var27 = var23 - var38; var27 <= var38 + var23; ++var27) {
                        int var28 = var26 - var15;
                        int var29 = var27 - var16;
                        if(var28 >= 0 && var29 >= 0 && var28 < 128 && var29 < 128 && class162.field2282[var28][var29] < 100) {
                           int var30 = 0;
                           if(var26 < var39) {
                              var30 = var39 - var26;
                           } else if(var26 > var39 + var33 - 1) {
                              var30 = var26 - (var39 + var33 - 1);
                           }

                           int var31 = 0;
                           if(var27 < var23) {
                              var31 = var23 - var27;
                           } else if(var27 > var25 + var23 - 1) {
                              var31 = var27 - (var25 + var23 - 1);
                           }

                           int var32 = var31 * var31 + var30 * var30;
                           if(var32 < var37 || var32 == var37 && class162.field2282[var28][var29] < var20) {
                              var37 = var32;
                              var20 = class162.field2282[var28][var29];
                              var17 = var26;
                              var36 = var27;
                           }
                        }
                     }
                  }

                  if(var37 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label632;
                  }
               }

               if(var4 == var17 && var5 == var36) {
                  var7 = 0;
               } else {
                  var19 = 0;
                  class162.field2284[var19] = var17;
                  var37 = var19 + 1;
                  class162.field2279[var19] = var36;

                  for(var20 = var21 = class162.field2281[var17 - var15][var36 - var16]; var17 != var4 || var5 != var36; var20 = class162.field2281[var17 - var15][var36 - var16]) {
                     if(var21 != var20) {
                        var21 = var20;
                        class162.field2284[var37] = var17;
                        class162.field2279[var37++] = var36;
                     }

                     if((var20 & 2) != 0) {
                        ++var17;
                     } else if((var20 & 8) != 0) {
                        --var17;
                     }

                     if((var20 & 1) != 0) {
                        ++var36;
                     } else if((var20 & 4) != 0) {
                        --var36;
                     }
                  }

                  var39 = 0;

                  while(var37-- > 0) {
                     var12[var39] = class162.field2284[var37];
                     var13[var39++] = class162.field2279[var37];
                     if(var39 >= var12.length) {
                        break;
                     }
                  }

                  var7 = var39;
               }
            }

            var14 = var7;
            if(var7 >= 1) {
               for(var15 = 0; var15 < var14 - 1; ++var15) {
                  var0.method1164(Client.field1169[var15], Client.field1170[var15], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "33"
   )
   public static Object method538(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class176.field2405) {
            try {
               class171 var2 = new class171();
               var2.vmethod3431(var0);
               return var2;
            } catch (Throwable var3) {
               class176.field2405 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass32;I)V",
      garbageValue = "-228062308"
   )
   public void vmethod715(class32 var1) {
      if(var1.field453 > this.field514) {
         var1.field453 = this.field514;
      }

      if(var1.field454 < this.field514) {
         var1.field454 = this.field514;
      }

      if(var1.field463 > this.field515) {
         var1.field463 = this.field515;
      }

      if(var1.field456 < this.field515) {
         var1.field456 = this.field515;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-27"
   )
   static int method540(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(Client.field939 == 0) {
            class83.intStack[++class83.intStackSize - 1] = -2;
         } else if(Client.field939 == 1) {
            class83.intStack[++class83.intStackSize - 1] = -1;
         } else {
            class83.intStack[++class83.intStackSize - 1] = Client.friendCount;
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class83.intStack[--class83.intStackSize];
            if(Client.field939 == 2 && var3 < Client.friendCount) {
               class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = Client.friends[var3].name;
               class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = Client.friends[var3].previousName;
            } else {
               class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
               class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class83.intStack[--class83.intStackSize];
            if(Client.field939 == 2 && var3 < Client.friendCount) {
               class83.intStack[++class83.intStackSize - 1] = Client.friends[var3].world;
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class83.intStack[--class83.intStackSize];
            if(Client.field939 == 2 && var3 < Client.friendCount) {
               class83.intStack[++class83.intStackSize - 1] = Client.friends[var3].rank;
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            return 1;
         } else {
            String var9;
            if(var0 == 3604) {
               var9 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
               int var10 = class83.intStack[--class83.intStackSize];
               Client.secretPacketBuffer1.putOpcode(1);
               Client.secretPacketBuffer1.putByte(class46.method711(var9) + 1);
               Client.secretPacketBuffer1.putByte(var10);
               Client.secretPacketBuffer1.method3191(var9);
               return 1;
            } else if(var0 == 3605) {
               var9 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
               Preferences.method1608(var9);
               return 1;
            } else if(var0 == 3606) {
               var9 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
               CollisionData.method3094(var9);
               return 1;
            } else {
               int var5;
               if(var0 == 3607) {
                  var9 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                  if(var9 != null) {
                     if((Client.ignoreCount < 100 || Client.field1012 == 1) && Client.ignoreCount < 400) {
                        String var12 = class27.method214(var9, class30.field423);
                        if(var12 != null) {
                           var5 = 0;

                           while(true) {
                              String var7;
                              String var8;
                              if(var5 >= Client.ignoreCount) {
                                 for(var5 = 0; var5 < Client.friendCount; ++var5) {
                                    Friend var14 = Client.friends[var5];
                                    var7 = class27.method214(var14.name, class30.field423);
                                    if(var7 != null && var7.equals(var12)) {
                                       GameObject.sendGameMessage(31, "", "Please remove " + var9 + " from your friend list first");
                                       return 1;
                                    }

                                    if(var14.previousName != null) {
                                       var8 = class27.method214(var14.previousName, class30.field423);
                                       if(var8 != null && var8.equals(var12)) {
                                          GameObject.sendGameMessage(31, "", "Please remove " + var9 + " from your friend list first");
                                          return 1;
                                       }
                                    }
                                 }

                                 if(class27.method214(XGrandExchangeOffer.localPlayer.name, class30.field423).equals(var12)) {
                                    GameObject.sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                 } else {
                                    Client.secretPacketBuffer1.putOpcode(44);
                                    Client.secretPacketBuffer1.putByte(class46.method711(var9));
                                    Client.secretPacketBuffer1.method3191(var9);
                                 }
                                 break;
                              }

                              Ignore var13 = Client.ignores[var5];
                              var7 = class27.method214(var13.name, class30.field423);
                              if(var7 != null && var7.equals(var12)) {
                                 GameObject.sendGameMessage(31, "", var9 + " is already on your ignore list");
                                 break;
                              }

                              if(var13.previousName != null) {
                                 var8 = class27.method214(var13.previousName, class30.field423);
                                 if(var8 != null && var8.equals(var12)) {
                                    GameObject.sendGameMessage(31, "", var9 + " is already on your ignore list");
                                    break;
                                 }
                              }

                              ++var5;
                           }
                        }
                     } else {
                        GameObject.sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                     }
                  }

                  return 1;
               } else if(var0 == 3608) {
                  var9 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                  class261.method4791(var9);
                  return 1;
               } else if(var0 == 3609) {
                  var9 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                  class230[] var4 = WidgetNode.method1106();

                  for(var5 = 0; var5 < var4.length; ++var5) {
                     class230 var6 = var4[var5];
                     if(var6.field3166 != -1 && var9.startsWith(WidgetNode.method1104(var6.field3166))) {
                        var9 = var9.substring(Integer.toString(var6.field3166).length() + 6);
                        break;
                     }
                  }

                  class83.intStack[++class83.intStackSize - 1] = class158.method3025(var9, false)?1:0;
                  return 1;
               } else if(var0 == 3611) {
                  if(Client.field1115 != null) {
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = RSSocket.method3056(Client.field1115);
                  } else {
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3612) {
                  if(Client.field1115 != null) {
                     class83.intStack[++class83.intStackSize - 1] = class48.clanChatCount;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3613) {
                  var3 = class83.intStack[--class83.intStackSize];
                  if(Client.field1115 != null && var3 < class48.clanChatCount) {
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = ClassInfo.clanMembers[var3].username;
                  } else {
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3614) {
                  var3 = class83.intStack[--class83.intStackSize];
                  if(Client.field1115 != null && var3 < class48.clanChatCount) {
                     class83.intStack[++class83.intStackSize - 1] = ClassInfo.clanMembers[var3].world;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3615) {
                  var3 = class83.intStack[--class83.intStackSize];
                  if(Client.field1115 != null && var3 < class48.clanChatCount) {
                     class83.intStack[++class83.intStackSize - 1] = ClassInfo.clanMembers[var3].rank;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3616) {
                  class83.intStack[++class83.intStackSize - 1] = class27.field401;
                  return 1;
               } else if(var0 == 3617) {
                  var9 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                  if(ClassInfo.clanMembers != null) {
                     Client.secretPacketBuffer1.putOpcode(135);
                     Client.secretPacketBuffer1.putByte(class46.method711(var9));
                     Client.secretPacketBuffer1.method3191(var9);
                  }

                  return 1;
               } else if(var0 == 3618) {
                  class83.intStack[++class83.intStackSize - 1] = class29.field418;
                  return 1;
               } else if(var0 == 3619) {
                  var9 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                  if(!var9.equals("")) {
                     Client.secretPacketBuffer1.putOpcode(233);
                     Client.secretPacketBuffer1.putByte(class46.method711(var9));
                     Client.secretPacketBuffer1.method3191(var9);
                  }

                  return 1;
               } else if(var0 == 3620) {
                  class181.method3503();
                  return 1;
               } else if(var0 == 3621) {
                  if(Client.field939 == 0) {
                     class83.intStack[++class83.intStackSize - 1] = -1;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = Client.ignoreCount;
                  }

                  return 1;
               } else if(var0 == 3622) {
                  var3 = class83.intStack[--class83.intStackSize];
                  if(Client.field939 != 0 && var3 < Client.ignoreCount) {
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = Client.ignores[var3].name;
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = Client.ignores[var3].previousName;
                  } else {
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                     class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                  }

                  return 1;
               } else if(var0 == 3623) {
                  label384: {
                     var9 = class83.scriptStringStack[--ChatMessages.scriptStringStackSize];
                     if(!var9.startsWith(WidgetNode.method1104(0))) {
                        String var11 = "<img=1>";
                        if(!var9.startsWith(var11)) {
                           break label384;
                        }
                     }

                     var9 = var9.substring(7);
                  }

                  class83.intStack[++class83.intStackSize - 1] = class22.method153(var9)?1:0;
                  return 1;
               } else if(var0 != 3624) {
                  if(var0 == 3625) {
                     if(Client.clanChatOwner != null) {
                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = RSSocket.method3056(Client.clanChatOwner);
                     } else {
                        class83.scriptStringStack[++ChatMessages.scriptStringStackSize - 1] = "";
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  var3 = class83.intStack[--class83.intStackSize];
                  if(ClassInfo.clanMembers != null && var3 < class48.clanChatCount && ClassInfo.clanMembers[var3].username.equalsIgnoreCase(XGrandExchangeOffer.localPlayer.name)) {
                     class83.intStack[++class83.intStackSize - 1] = 1;
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = 0;
                  }

                  return 1;
               }
            }
         }
      }
   }
}
