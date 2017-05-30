import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class14 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -690415571
   )
   public final int field285;
   @ObfuscatedName("u")
   public final XGrandExchangeOffer field286;
   @ObfuscatedName("q")
   String field287;
   @ObfuscatedName("g")
   String field288;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 7550912259397998433L
   )
   public final long field289;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -722281267
   )
   static int field291;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-12304164"
   )
   public static final boolean method69() {
      class50 var0 = class50.keyboard;
      synchronized(class50.keyboard) {
         if(class50.field621 == class50.field635) {
            return false;
         } else {
            class50.field625 = class50.field630[class50.field621];
            class22.field341 = class50.field639[class50.field621];
            class50.field621 = class50.field621 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "14"
   )
   public String method70() {
      return this.field287;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "905825888"
   )
   static int method74(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class261.method4792(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class83.field1311:Buffer.field2384;
      }

      class219.method4130(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class83.intStack[--class83.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = XGrandExchangeOffer.localPlayer.composition.method4032();
            return 1;
         } else {
            return 2;
         }
      } else {
         class83.intStackSize -= 2;
         int var4 = class83.intStack[class83.intStackSize];
         int var5 = class83.intStack[class83.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class51.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2752 = var6.offsetX2d;
         var3.field2692 = var6.offsetY2d;
         var3.field2696 = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2770 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2770 = 1;
         } else {
            var3.field2770 = 2;
         }

         if(var3.field2697 > 0) {
            var3.field2696 = var3.field2696 * 32 / var3.field2697;
         } else if(var3.originalWidth > 0) {
            var3.field2696 = var3.field2696 * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-310684875"
   )
   public static boolean method75(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2682.method4217(var0)) {
         return false;
      } else {
         int var1 = Widget.field2682.method4184(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(class90.widgets[var0] == null) {
               class90.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class90.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.field2682.getConfigData(var0, var2);
                  if(var3 != null) {
                     class90.widgets[var0][var2] = new Widget();
                     class90.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class90.widgets[var0][var2].method4049(new Buffer(var3));
                     } else {
                        class90.widgets[var0][var2].method4048(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   class14(Buffer var1, byte var2, int var3) {
      this.field287 = var1.readString();
      this.field288 = var1.readString();
      this.field285 = var1.readUnsignedShort();
      this.field289 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.field286 = new XGrandExchangeOffer();
      this.field286.method98(2);
      this.field286.method99(var2);
      this.field286.price = var4;
      this.field286.totalQuantity = var5;
      this.field286.quantitySold = 0;
      this.field286.spent = 0;
      this.field286.itemId = var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILclass163;LCollisionData;B)Z",
      garbageValue = "0"
   )
   public static final boolean method78(int var0, int var1, int var2, class163 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class162.field2281[var7][var8] = 99;
      class162.field2282[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class162.field2284[var11] = var0;
      int var20 = var11 + 1;
      class162.field2279[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label343:
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
                     label320:
                     do {
                        if(var20 == var12) {
                           class162.field2280 = var5;
                           class227.field3134 = var6;
                           return false;
                        }

                        var5 = class162.field2284[var12];
                        var6 = class162.field2279[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod3110(var2, var5, var6, var4)) {
                           class162.field2280 = var5;
                           class227.field3134 = var6;
                           return true;
                        }

                        var16 = class162.field2282[var18][var19] + 1;
                        if(var18 > 0 && class162.field2281[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2284[var20] = var5 - 1;
                                 class162.field2279[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2281[var18 - 1][var19] = 2;
                                 class162.field2282[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class162.field2281[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var2 + var14][var2 + var15 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2284[var20] = var5 + 1;
                                 class162.field2279[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2281[var18 + 1][var19] = 8;
                                 class162.field2282[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class162.field2281[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var2 + var14 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2284[var20] = var5;
                                 class162.field2279[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2281[var18][var19 - 1] = 1;
                                 class162.field2282[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class162.field2281[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var2 + var15] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class162.field2284[var20] = var5;
                                 class162.field2279[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2281[var18][var19 + 1] = 4;
                                 class162.field2282[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class162.field2281[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class162.field2284[var20] = var5 - 1;
                                 class162.field2279[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2281[var18 - 1][var19 - 1] = 3;
                                 class162.field2282[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class162.field2281[var18 + 1][var19 - 1] == 0 && (var13[var2 + var14][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class162.field2284[var20] = var5 + 1;
                                 class162.field2279[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class162.field2281[var18 + 1][var19 - 1] = 9;
                                 class162.field2282[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class162.field2281[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var14 - 1 + var17][var15 + var2] & 19137016) != 0) {
                                 continue label320;
                              }
                           }

                           class162.field2284[var20] = var5 - 1;
                           class162.field2279[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class162.field2281[var18 - 1][var19 + 1] = 6;
                           class162.field2282[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class162.field2281[var18 + 1][var19 + 1] != 0);
            } while((var13[var2 + var14][var2 + var15] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var2 + var15] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                  continue label343;
               }
            }

            class162.field2284[var20] = var5 + 1;
            class162.field2279[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class162.field2281[var18 + 1][var19 + 1] = 12;
            class162.field2282[var18 + 1][var19 + 1] = var16;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2143732404"
   )
   public String method80() {
      return this.field288;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(ILclass212;ZI)V",
      garbageValue = "217947212"
   )
   static void method81(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = MessageNode.method1130().method5292(var0);
      int var4 = XGrandExchangeOffer.localPlayer.field874;
      int var5 = class166.baseX + (XGrandExchangeOffer.localPlayer.x >> 7);
      int var6 = (XGrandExchangeOffer.localPlayer.y >> 7) + class146.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      MessageNode.method1130().method5268(var3, var7, var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "53"
   )
   static boolean method82(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }
}
