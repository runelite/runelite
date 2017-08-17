import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
public class class74 extends class164 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIILfc;B)Z",
      garbageValue = "-66"
   )
   public boolean vmethod3088(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2318 && var3 == super.field2315;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "2120230786"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class176.field2407) {
         class176.field2404 += class176.field2407 - var0;
      }

      class176.field2407 = var0;
      return class176.field2404 + var0;
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(Lbz;IIBI)V",
      garbageValue = "-653914426"
   )
   static final void method1182(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.getSize();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var8 = var0.getSize();
            class164 var9 = class17.method128(var1, var2);
            CollisionData var10 = Client.collisionMaps[var0.field918];
            int[] var11 = Client.field1149;
            int[] var12 = Client.field1122;

            int var13;
            int var14;
            for(var13 = 0; var13 < 128; ++var13) {
               for(var14 = 0; var14 < 128; ++var14) {
                  class163.field2307[var13][var14] = 0;
                  class163.field2308[var13][var14] = 99999999;
               }
            }

            int var15;
            int var16;
            byte var18;
            int var19;
            int var20;
            int var22;
            int var24;
            int var25;
            int var26;
            boolean var33;
            int var35;
            int var36;
            int var38;
            if(var8 == 1) {
               var33 = class91.method1726(var4, var5, var9, var10);
            } else if(var8 == 2) {
               var15 = var4;
               var16 = var5;
               byte var17 = 64;
               var18 = 64;
               var19 = var4 - var17;
               var20 = var5 - var18;
               class163.field2307[var17][var18] = 99;
               class163.field2308[var17][var18] = 0;
               byte var21 = 0;
               var22 = 0;
               class163.field2310[var21] = var4;
               var38 = var21 + 1;
               class163.field2311[var21] = var5;
               int[][] var32 = var10.flags;

               boolean var34;
               while(true) {
                  if(var22 == var38) {
                     class164.field2316 = var15;
                     class163.field2309 = var16;
                     var34 = false;
                     break;
                  }

                  var15 = class163.field2310[var22];
                  var16 = class163.field2311[var22];
                  var22 = var22 + 1 & 4095;
                  var35 = var15 - var19;
                  var36 = var16 - var20;
                  var24 = var15 - var10.x;
                  var25 = var16 - var10.y;
                  if(var9.vmethod3088(2, var15, var16, var10)) {
                     class164.field2316 = var15;
                     class163.field2309 = var16;
                     var34 = true;
                     break;
                  }

                  var26 = class163.field2308[var35][var36] + 1;
                  if(var35 > 0 && class163.field2307[var35 - 1][var36] == 0 && (var32[var24 - 1][var25] & 19136782) == 0 && 0 == (var32[var24 - 1][var25 + 1] & 19136824)) {
                     class163.field2310[var38] = var15 - 1;
                     class163.field2311[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class163.field2307[var35 - 1][var36] = 2;
                     class163.field2308[var35 - 1][var36] = var26;
                  }

                  if(var35 < 126 && class163.field2307[var35 + 1][var36] == 0 && (var32[var24 + 2][var25] & 19136899) == 0 && 0 == (var32[var24 + 2][var25 + 1] & 19136992)) {
                     class163.field2310[var38] = var15 + 1;
                     class163.field2311[var38] = var16;
                     var38 = var38 + 1 & 4095;
                     class163.field2307[var35 + 1][var36] = 8;
                     class163.field2308[var35 + 1][var36] = var26;
                  }

                  if(var36 > 0 && class163.field2307[var35][var36 - 1] == 0 && (var32[var24][var25 - 1] & 19136782) == 0 && (var32[var24 + 1][var25 - 1] & 19136899) == 0) {
                     class163.field2310[var38] = var15;
                     class163.field2311[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2307[var35][var36 - 1] = 1;
                     class163.field2308[var35][var36 - 1] = var26;
                  }

                  if(var36 < 126 && 0 == class163.field2307[var35][var36 + 1] && (var32[var24][var25 + 2] & 19136824) == 0 && (var32[var24 + 1][var25 + 2] & 19136992) == 0) {
                     class163.field2310[var38] = var15;
                     class163.field2311[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2307[var35][var36 + 1] = 4;
                     class163.field2308[var35][var36 + 1] = var26;
                  }

                  if(var35 > 0 && var36 > 0 && class163.field2307[var35 - 1][var36 - 1] == 0 && (var32[var24 - 1][var25] & 19136830) == 0 && (var32[var24 - 1][var25 - 1] & 19136782) == 0 && (var32[var24][var25 - 1] & 19136911) == 0) {
                     class163.field2310[var38] = var15 - 1;
                     class163.field2311[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2307[var35 - 1][var36 - 1] = 3;
                     class163.field2308[var35 - 1][var36 - 1] = var26;
                  }

                  if(var35 < 126 && var36 > 0 && class163.field2307[var35 + 1][var36 - 1] == 0 && (var32[var24 + 1][var25 - 1] & 19136911) == 0 && (var32[var24 + 2][var25 - 1] & 19136899) == 0 && (var32[var24 + 2][var25] & 19136995) == 0) {
                     class163.field2310[var38] = var15 + 1;
                     class163.field2311[var38] = var16 - 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2307[var35 + 1][var36 - 1] = 9;
                     class163.field2308[var35 + 1][var36 - 1] = var26;
                  }

                  if(var35 > 0 && var36 < 126 && class163.field2307[var35 - 1][var36 + 1] == 0 && (var32[var24 - 1][var25 + 1] & 19136830) == 0 && (var32[var24 - 1][var25 + 2] & 19136824) == 0 && 0 == (var32[var24][var25 + 2] & 19137016)) {
                     class163.field2310[var38] = var15 - 1;
                     class163.field2311[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2307[var35 - 1][var36 + 1] = 6;
                     class163.field2308[var35 - 1][var36 + 1] = var26;
                  }

                  if(var35 < 126 && var36 < 126 && class163.field2307[var35 + 1][var36 + 1] == 0 && 0 == (var32[var24 + 1][var25 + 2] & 19137016) && (var32[var24 + 2][var25 + 2] & 19136992) == 0 && (var32[var24 + 2][var25 + 1] & 19136995) == 0) {
                     class163.field2310[var38] = var15 + 1;
                     class163.field2311[var38] = var16 + 1;
                     var38 = var38 + 1 & 4095;
                     class163.field2307[var35 + 1][var36 + 1] = 12;
                     class163.field2308[var35 + 1][var36 + 1] = var26;
                  }
               }

               var33 = var34;
            } else {
               var33 = IndexFile.method3041(var4, var5, var8, var9, var10);
            }

            int var7;
            label379: {
               var14 = var4 - 64;
               var15 = var5 - 64;
               var16 = class164.field2316;
               var35 = class163.field2309;
               if(!var33) {
                  var36 = Integer.MAX_VALUE;
                  var19 = Integer.MAX_VALUE;
                  byte var37 = 10;
                  var38 = var9.field2318;
                  var22 = var9.field2315;
                  int var23 = var9.field2314;
                  var24 = var9.field2317;

                  for(var25 = var38 - var37; var25 <= var38 + var37; ++var25) {
                     for(var26 = var22 - var37; var26 <= var37 + var22; ++var26) {
                        int var27 = var25 - var14;
                        int var28 = var26 - var15;
                        if(var27 >= 0 && var28 >= 0 && var27 < 128 && var28 < 128 && class163.field2308[var27][var28] < 100) {
                           int var29 = 0;
                           if(var25 < var38) {
                              var29 = var38 - var25;
                           } else if(var25 > var23 + var38 - 1) {
                              var29 = var25 - (var38 + var23 - 1);
                           }

                           int var30 = 0;
                           if(var26 < var22) {
                              var30 = var22 - var26;
                           } else if(var26 > var24 + var22 - 1) {
                              var30 = var26 - (var22 + var24 - 1);
                           }

                           int var31 = var30 * var30 + var29 * var29;
                           if(var31 < var36 || var36 == var31 && class163.field2308[var27][var28] < var19) {
                              var36 = var31;
                              var19 = class163.field2308[var27][var28];
                              var16 = var25;
                              var35 = var26;
                           }
                        }
                     }
                  }

                  if(var36 == Integer.MAX_VALUE) {
                     var7 = -1;
                     break label379;
                  }
               }

               if(var4 == var16 && var5 == var35) {
                  var7 = 0;
               } else {
                  var18 = 0;
                  class163.field2310[var18] = var16;
                  var36 = var18 + 1;
                  class163.field2311[var18] = var35;

                  for(var19 = var20 = class163.field2307[var16 - var14][var35 - var15]; var4 != var16 || var35 != var5; var19 = class163.field2307[var16 - var14][var35 - var15]) {
                     if(var19 != var20) {
                        var20 = var19;
                        class163.field2310[var36] = var16;
                        class163.field2311[var36++] = var35;
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
                     var11[var38] = class163.field2310[var36];
                     var12[var38++] = class163.field2311[var36];
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
                  var0.method1191(Client.field1149[var14], Client.field1122[var14], var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-21"
   )
   static void method1183() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                  Client.field1131[var3] = Client.field1131[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(Lhi;III)V",
      garbageValue = "52797281"
   )
   static final void method1184(Widget var0, int var1, int var2) {
      if(Client.field1160 == 0 || Client.field1160 == 3) {
         if(MouseInput.field740 == 1 || !XGrandExchangeOffer.field302 && MouseInput.field740 == 4) {
            class211 var3 = var0.method4043(true);
            if(var3 == null) {
               return;
            }

            int var4 = MouseInput.field741 - var1;
            int var5 = MouseInput.field742 - var2;
            if(var3.method3927(var4, var5)) {
               var4 -= var3.field2599 / 2;
               var5 -= var3.field2597 / 2;
               int var6 = Client.mapAngle & 2047;
               int var7 = Graphics3D.SINE[var6];
               int var8 = Graphics3D.COSINE[var6];
               int var9 = var4 * var8 + var7 * var5 >> 11;
               int var10 = var5 * var8 - var7 * var4 >> 11;
               int var11 = var9 + XGrandExchangeOffer.localPlayer.x >> 7;
               int var12 = XGrandExchangeOffer.localPlayer.y - var10 >> 7;
               Client.secretPacketBuffer1.putOpcode(110);
               Client.secretPacketBuffer1.putByte(18);
               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field642[82]?(KeyFocusListener.field642[81]?2:1):0);
               Client.secretPacketBuffer1.method3208(var11 + class47.baseX);
               Client.secretPacketBuffer1.putShort(var12 + class44.baseY);
               Client.secretPacketBuffer1.putByte(var4);
               Client.secretPacketBuffer1.putByte(var5);
               Client.secretPacketBuffer1.putShort(Client.mapAngle);
               Client.secretPacketBuffer1.putByte(57);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putByte(0);
               Client.secretPacketBuffer1.putByte(89);
               Client.secretPacketBuffer1.putShort(XGrandExchangeOffer.localPlayer.x);
               Client.secretPacketBuffer1.putShort(XGrandExchangeOffer.localPlayer.y);
               Client.secretPacketBuffer1.putByte(63);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }
}
