import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class13 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-45"
   )
   static String method182(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2045964589"
   )
   static final void method183() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var35;
      if(Client.packetOpcode == 16) {
         var0 = Client.field370.readUnsignedByte();
         var1 = (var0 >> 4 & 7) + class7.field65;
         var2 = (var0 & 7) + class3.field32;
         var3 = Client.field370.readUnsignedShort();
         var4 = Client.field370.readUnsignedShort();
         var35 = Client.field370.readUnsignedShort();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            Deque var36 = Client.groundItemDeque[class166.plane][var1][var2];
            if(var36 != null) {
               for(Item var29 = (Item)var36.method2466(); var29 != null; var29 = (Item)var36.method2461()) {
                  if(var29.id == (var3 & 32767) && var4 == var29.quantity) {
                     var29.quantity = var35;
                     break;
                  }
               }

               ChatLineBuffer.groundItemSpawned(var1, var2);
            }
         }

      } else {
         int var41;
         if(Client.packetOpcode == 169) {
            var0 = Client.field370.method3018();
            var1 = (var0 >> 4 & 7) + class7.field65;
            var2 = class3.field32 + (var0 & 7);
            var3 = Client.field370.method3018();
            var4 = var3 >> 2;
            var35 = var3 & 3;
            var41 = Client.field350[var4];
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               class97.method1953(class166.plane, var1, var2, var41, -1, var4, var35, 0, -1);
            }

         } else {
            Item var33;
            if(Client.packetOpcode == 175) {
               var0 = Client.field370.method3153();
               var1 = Client.field370.readUnsignedByte();
               var2 = class7.field65 + (var1 >> 4 & 7);
               var3 = class3.field32 + (var1 & 7);
               if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                  Deque var32 = Client.groundItemDeque[class166.plane][var2][var3];
                  if(var32 != null) {
                     for(var33 = (Item)var32.method2466(); null != var33; var33 = (Item)var32.method2461()) {
                        if((var0 & 32767) == var33.id) {
                           var33.unlink();
                           break;
                        }
                     }

                     if(var32.method2466() == null) {
                        Client.groundItemDeque[class166.plane][var2][var3] = null;
                     }

                     ChatLineBuffer.groundItemSpawned(var2, var3);
                  }
               }

            } else {
               int var7;
               int var9;
               int var10;
               int var11;
               int var42;
               if(Client.packetOpcode == 209) {
                  var0 = Client.field370.readUnsignedByte();
                  var1 = class7.field65 + (var0 >> 4 & 7);
                  var2 = class3.field32 + (var0 & 7);
                  var3 = var1 + Client.field370.readByte();
                  var4 = var2 + Client.field370.readByte();
                  var35 = Client.field370.method2993();
                  var41 = Client.field370.readUnsignedShort();
                  var7 = Client.field370.readUnsignedByte() * 4;
                  var42 = Client.field370.readUnsignedByte() * 4;
                  var9 = Client.field370.readUnsignedShort();
                  var10 = Client.field370.readUnsignedShort();
                  var11 = Client.field370.readUnsignedByte();
                  int var40 = Client.field370.readUnsignedByte();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var41 != '\uffff') {
                     var1 = 64 + var1 * 128;
                     var2 = 128 * var2 + 64;
                     var3 = 64 + 128 * var3;
                     var4 = 64 + 128 * var4;
                     Projectile var13 = new Projectile(var41, class166.plane, var1, var2, class11.method161(var1, var2, class166.plane) - var7, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var40, var35, var42);
                     var13.method808(var3, var4, class11.method161(var3, var4, class166.plane) - var42, Client.gameCycle + var9);
                     Client.projectiles.method2454(var13);
                  }

               } else {
                  if(Client.packetOpcode == 208) {
                     var0 = Client.field370.method3153();
                     var1 = Client.field370.readUnsignedByte();
                     var2 = var1 >> 2;
                     var3 = var1 & 3;
                     var4 = Client.field350[var2];
                     byte var5 = Client.field370.readByte();
                     byte var30 = Client.field370.method3020();
                     var7 = Client.field370.method3025();
                     byte var31 = Client.field370.method3106();
                     var9 = Client.field370.method3019();
                     var10 = class7.field65 + (var9 >> 4 & 7);
                     var11 = class3.field32 + (var9 & 7);
                     byte var12 = Client.field370.method3106();
                     int var34 = Client.field370.readUnsignedShort();
                     int var14 = Client.field370.method3026();
                     Player var15;
                     if(var0 == Client.localInteractingIndex) {
                        var15 = class40.localPlayer;
                     } else {
                        var15 = Client.cachedPlayers[var0];
                     }

                     if(var15 != null) {
                        ObjectComposition var16 = class15.getObjectDefinition(var14);
                        int var17;
                        int var18;
                        if(var3 != 1 && var3 != 3) {
                           var17 = var16.field2903;
                           var18 = var16.field2907;
                        } else {
                           var17 = var16.field2907;
                           var18 = var16.field2903;
                        }

                        int var19 = (var17 >> 1) + var10;
                        int var20 = (var17 + 1 >> 1) + var10;
                        int var21 = (var18 >> 1) + var11;
                        int var22 = var11 + (1 + var18 >> 1);
                        int[][] var23 = class11.tileHeights[class166.plane];
                        int var24 = var23[var20][var22] + var23[var20][var21] + var23[var19][var21] + var23[var19][var22] >> 2;
                        int var25 = (var10 << 7) + (var17 << 6);
                        int var26 = (var18 << 6) + (var11 << 7);
                        Model var27 = var16.method3652(var2, var3, var23, var25, var24, var26);
                        if(null != var27) {
                           class97.method1953(class166.plane, var10, var11, var4, -1, 0, 0, var34 + 1, var7 + 1);
                           var15.totalLevel = Client.gameCycle + var34;
                           var15.field252 = var7 + Client.gameCycle;
                           var15.model = var27;
                           var15.field253 = var10 * 128 + 64 * var17;
                           var15.field257 = 64 * var18 + 128 * var11;
                           var15.field254 = var24;
                           byte var28;
                           if(var31 > var30) {
                              var28 = var31;
                              var31 = var30;
                              var30 = var28;
                           }

                           if(var12 > var5) {
                              var28 = var12;
                              var12 = var5;
                              var5 = var28;
                           }

                           var15.field245 = var10 + var31;
                           var15.field266 = var10 + var30;
                           var15.field258 = var12 + var11;
                           var15.field260 = var11 + var5;
                        }
                     }
                  }

                  if(Client.packetOpcode == 117) {
                     var0 = Client.field370.readUnsignedByte();
                     var1 = class7.field65 + (var0 >> 4 & 7);
                     var2 = class3.field32 + (var0 & 7);
                     var3 = Client.field370.readUnsignedShort();
                     var4 = Client.field370.readUnsignedByte();
                     var35 = var4 >> 4 & 15;
                     var41 = var4 & 7;
                     var7 = Client.field370.readUnsignedByte();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        var42 = 1 + var35;
                        if(class40.localPlayer.pathX[0] >= var1 - var42 && class40.localPlayer.pathX[0] <= var42 + var1 && class40.localPlayer.pathY[0] >= var2 - var42 && class40.localPlayer.pathY[0] <= var42 + var2 && Client.field526 != 0 && var41 > 0 && Client.field527 < 50) {
                           Client.field528[Client.field527] = var3;
                           Client.field529[Client.field527] = var41;
                           Client.field431[Client.field527] = var7;
                           Client.field532[Client.field527] = null;
                           Client.field299[Client.field527] = (var1 << 16) + (var2 << 8) + var35;
                           ++Client.field527;
                        }
                     }
                  }

                  if(Client.packetOpcode == 165) {
                     var0 = Client.field370.method3153();
                     var1 = Client.field370.method3017();
                     var2 = (var1 >> 4 & 7) + class7.field65;
                     var3 = class3.field32 + (var1 & 7);
                     var4 = Client.field370.method3026();
                     if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                        var33 = new Item();
                        var33.id = var0;
                        var33.quantity = var4;
                        if(null == Client.groundItemDeque[class166.plane][var2][var3]) {
                           Client.groundItemDeque[class166.plane][var2][var3] = new Deque();
                        }

                        Client.groundItemDeque[class166.plane][var2][var3].method2454(var33);
                        ChatLineBuffer.groundItemSpawned(var2, var3);
                     }

                  } else if(Client.packetOpcode != 50) {
                     if(Client.packetOpcode == 107) {
                        var0 = Client.field370.method3019();
                        var1 = (var0 >> 4 & 7) + class7.field65;
                        var2 = (var0 & 7) + class3.field32;
                        var3 = Client.field370.readUnsignedShort();
                        var4 = Client.field370.method3017();
                        var35 = var4 >> 2;
                        var41 = var4 & 3;
                        var7 = Client.field350[var35];
                        if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                           class97.method1953(class166.plane, var1, var2, var7, var3, var35, var41, 0, -1);
                        }

                     } else if(Client.packetOpcode == 243) {
                        var0 = Client.field370.readUnsignedByte();
                        var1 = (var0 >> 4 & 7) + class7.field65;
                        var2 = (var0 & 7) + class3.field32;
                        var3 = Client.field370.readUnsignedShort();
                        var4 = Client.field370.readUnsignedByte();
                        var35 = Client.field370.readUnsignedShort();
                        if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                           var1 = var1 * 128 + 64;
                           var2 = 128 * var2 + 64;
                           class33 var6 = new class33(var3, class166.plane, var1, var2, class11.method161(var1, var2, class166.plane) - var4, var35, Client.gameCycle);
                           Client.field421.method2454(var6);
                        }

                     }
                  } else {
                     var0 = Client.field370.method3019();
                     var1 = (var0 >> 4 & 7) + class7.field65;
                     var2 = class3.field32 + (var0 & 7);
                     var3 = Client.field370.method3025();
                     var4 = Client.field370.method3018();
                     var35 = var4 >> 2;
                     var41 = var4 & 3;
                     var7 = Client.field350[var35];
                     if(var1 >= 0 && var2 >= 0 && var1 < 103 && var2 < 103) {
                        if(var7 == 0) {
                           WallObject var8 = class157.region.method1762(class166.plane, var1, var2);
                           if(null != var8) {
                              var9 = var8.hash >> 14 & 32767;
                              if(var35 == 2) {
                                 var8.renderable1 = new class49(var9, 2, 4 + var41, class166.plane, var1, var2, var3, false, var8.renderable1);
                                 var8.renderable2 = new class49(var9, 2, var41 + 1 & 3, class166.plane, var1, var2, var3, false, var8.renderable2);
                              } else {
                                 var8.renderable1 = new class49(var9, var35, var41, class166.plane, var1, var2, var3, false, var8.renderable1);
                              }
                           }
                        }

                        if(var7 == 1) {
                           DecorativeObject var37 = class157.region.method1861(class166.plane, var1, var2);
                           if(null != var37) {
                              var9 = var37.hash >> 14 & 32767;
                              if(var35 != 4 && var35 != 5) {
                                 if(var35 == 6) {
                                    var37.renderable1 = new class49(var9, 4, var41 + 4, class166.plane, var1, var2, var3, false, var37.renderable1);
                                 } else if(var35 == 7) {
                                    var37.renderable1 = new class49(var9, 4, 4 + (2 + var41 & 3), class166.plane, var1, var2, var3, false, var37.renderable1);
                                 } else if(var35 == 8) {
                                    var37.renderable1 = new class49(var9, 4, 4 + var41, class166.plane, var1, var2, var3, false, var37.renderable1);
                                    var37.renderable2 = new class49(var9, 4, (2 + var41 & 3) + 4, class166.plane, var1, var2, var3, false, var37.renderable2);
                                 }
                              } else {
                                 var37.renderable1 = new class49(var9, 4, var41, class166.plane, var1, var2, var3, false, var37.renderable1);
                              }
                           }
                        }

                        if(var7 == 2) {
                           GameObject var38 = class157.region.method1811(class166.plane, var1, var2);
                           if(var35 == 11) {
                              var35 = 10;
                           }

                           if(var38 != null) {
                              var38.renderable = new class49(var38.hash >> 14 & 32767, var35, var41, class166.plane, var1, var2, var3, false, var38.renderable);
                           }
                        }

                        if(var7 == 3) {
                           GroundObject var39 = class157.region.method1765(class166.plane, var1, var2);
                           if(var39 != null) {
                              var39.renderable = new class49(var39.hash >> 14 & 32767, 22, var41, class166.plane, var1, var2, var3, false, var39.renderable);
                           }
                        }
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-112"
   )
   static final void method184() {
      if(Client.widgetRoot != -1) {
         class107.method2085(Client.widgetRoot);
      }

      int var0;
      for(var0 = 0; var0 < Client.field488; ++var0) {
         if(Client.field490[var0]) {
            Client.field491[var0] = true;
         }

         Client.field492[var0] = Client.field490[var0];
         Client.field490[var0] = false;
      }

      Client.field554 = Client.gameCycle;
      Client.field407 = -1;
      Client.field435 = -1;
      DecorativeObject.field1603 = null;
      if(Client.widgetRoot != -1) {
         Client.field488 = 0;
         class1.method20(Client.widgetRoot, 0, 0, class16.field169, class65.field1103, 0, 0, -1);
      }

      class219.method4040();
      int var1;
      if(!Client.isMenuOpen) {
         if(Client.field407 != -1) {
            var0 = Client.field407;
            var1 = Client.field435;
            if(Client.menuOptionCount >= 2 || Client.field438 != 0 || Client.field440) {
               String var2;
               if(Client.field438 == 1 && Client.menuOptionCount < 2) {
                  var2 = "Use" + " " + Client.field371 + " " + "->";
               } else if(Client.field440 && Client.menuOptionCount < 2) {
                  var2 = Client.field297 + " " + Client.field444 + " " + "->";
               } else {
                  int var11 = Client.menuOptionCount - 1;
                  String var12;
                  if(Client.menuTargets[var11].length() > 0) {
                     var12 = Client.menuOptions[var11] + " " + Client.menuTargets[var11];
                  } else {
                     var12 = Client.menuOptions[var11];
                  }

                  var2 = var12;
               }

               if(Client.menuOptionCount > 2) {
                  var2 = var2 + method182(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
               }

               class156.field2236.method3925(var2, var0 + 4, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
            }
         }
      } else {
         class20.method214();
      }

      if(Client.field497 == 3) {
         for(var0 = 0; var0 < Client.field488; ++var0) {
            if(Client.field492[var0]) {
               class219.method4046(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711935, 128);
            } else if(Client.field491[var0]) {
               class219.method4046(Client.widgetPositionX[var0], Client.widgetPositionY[var0], Client.widgetBoundsWidth[var0], Client.widgetBoundsHeight[var0], 16711680, 128);
            }
         }
      }

      var0 = class166.plane;
      var1 = class40.localPlayer.x;
      int var13 = class40.localPlayer.y;
      int var3 = Client.field517;

      for(class31 var4 = (class31)class31.field697.method2466(); null != var4; var4 = (class31)class31.field697.method2461()) {
         if(var4.field702 != -1 || var4.field706 != null) {
            int var5 = 0;
            if(var1 > var4.field698) {
               var5 += var1 - var4.field698;
            } else if(var1 < var4.field710) {
               var5 += var4.field710 - var1;
            }

            if(var13 > var4.field695) {
               var5 += var13 - var4.field695;
            } else if(var13 < var4.field699) {
               var5 += var4.field699 - var13;
            }

            if(var5 - 64 <= var4.field701 && Client.field526 != 0 && var0 == var4.field705) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = Client.field526 * (var4.field701 - var5) / var4.field701;
               Object var10000;
               if(null == var4.field703) {
                  if(var4.field702 >= 0) {
                     var10000 = null;
                     class53 var7 = class53.method975(PlayerComposition.field2036, var4.field702, 0);
                     if(var7 != null) {
                        class55 var8 = var7.method969().method1019(class3.field35);
                        class66 var9 = class66.method1174(var8, 100, var6);
                        var9.method1192(-1);
                        class143.field2007.method914(var9);
                        var4.field703 = var9;
                     }
                  }
               } else {
                  var4.field703.method1242(var6);
               }

               if(null == var4.field708) {
                  if(var4.field706 != null && (var4.field707 -= var3) <= 0) {
                     int var14 = (int)(Math.random() * (double)var4.field706.length);
                     var10000 = null;
                     class53 var15 = class53.method975(PlayerComposition.field2036, var4.field706[var14], 0);
                     if(var15 != null) {
                        class55 var16 = var15.method969().method1019(class3.field35);
                        class66 var10 = class66.method1174(var16, 100, var6);
                        var10.method1192(0);
                        class143.field2007.method914(var10);
                        var4.field708 = var10;
                        var4.field707 = var4.field704 + (int)(Math.random() * (double)(var4.field713 - var4.field704));
                     }
                  }
               } else {
                  var4.field708.method1242(var6);
                  if(!var4.field708.linked()) {
                     var4.field708 = null;
                  }
               }
            } else {
               if(null != var4.field703) {
                  class143.field2007.method915(var4.field703);
                  var4.field703 = null;
               }

               if(var4.field708 != null) {
                  class143.field2007.method915(var4.field708);
                  var4.field708 = null;
               }
            }
         }
      }

      Client.field517 = 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1730378542"
   )
   static final void method185() {
      if(null != class15.field156) {
         class15.field156.method1045();
      }

      if(null != class11.field114) {
         class11.field114.method1045();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-27"
   )
   public static void method186() {
      class138.field1919.method2556();
      class138.field1917 = 1;
      class1.field12 = null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass228;I)I",
      garbageValue = "-898275828"
   )
   static final int method187(class228 var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3242) {
         case 8:
            return 20;
         default:
            return 12;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "918663602"
   )
   public static void method188(Buffer var0, int var1) {
      ClassInfo var2 = new ClassInfo();
      var2.field3221 = var0.readUnsignedByte();
      var2.field3223 = var0.method2995();
      var2.field3220 = new int[var2.field3221];
      var2.field3224 = new int[var2.field3221];
      var2.fields = new Field[var2.field3221];
      var2.field3225 = new int[var2.field3221];
      var2.methods = new Method[var2.field3221];
      var2.args = new byte[var2.field3221][][];

      for(int var3 = 0; var3 < var2.field3221; ++var3) {
         try {
            int var4 = var0.readUnsignedByte();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.method3057();
                  var6 = var0.method3057();
                  var7 = var0.readUnsignedByte();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method3057();
                  }

                  String var20 = var0.method3057();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method2995();
                        var10[var11] = new byte[var12];
                        var0.method3043(var10[var11], 0, var12);
                     }
                  }

                  var2.field3220[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class193.method3588(var8[var12]);
                  }

                  Class var22 = class193.method3588(var20);
                  if(class193.method3588(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class193.method3588(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(var16.getName().equals(var6)) {
                        Class[] var17 = var16.getParameterTypes();
                        if(var17.length == var21.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var21[var19] != var17[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var22 == var16.getReturnType()) {
                              var2.methods[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.args[var3] = var10;
               }
            } else {
               var5 = var0.method3057();
               var6 = var0.method3057();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.method2995();
               }

               var2.field3220[var3] = var4;
               var2.field3225[var3] = var7;
               if(class193.method3588(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.fields[var3] = class193.method3588(var5).getDeclaredField(var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3224[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3224[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3224[var3] = -3;
         } catch (Exception var27) {
            var2.field3224[var3] = -4;
         } catch (Throwable var28) {
            var2.field3224[var3] = -5;
         }
      }

      class227.field3232.method2421(var2);
   }
}
