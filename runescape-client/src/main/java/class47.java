import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class47 {
   @ObfuscatedName("e")
   public Coordinates field607;
   @ObfuscatedName("m")
   public Coordinates field608;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = -287556745
   )
   static int field610;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = 1302866047
   )
   static int field611;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1175794721
   )
   public int field612;
   @ObfuscatedName("bg")
   static ModIcon[] field613;
   @ObfuscatedName("dz")
   @ObfuscatedGetter(
      intValue = 2147383689
   )
   static int field614;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "939588052"
   )
   static final void method672(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field1055 || (class61.tileSettings[0][var1][var2] & 2) != 0 || (class61.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class61.field759) {
            class61.field759 = var0;
         }

         ObjectComposition var8 = class29.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.sizeX;
            var10 = var8.sizeY;
         } else {
            var9 = var8.sizeY;
            var10 = var8.sizeX;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = var1 + (var9 + 1 >> 1);
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class61.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = (var3 << 14) + var1 + (var2 << 7) + 1073741824;
         if(var8.field3445 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field3482 == 1) {
            var20 += 256;
         }

         if(var8.method4387()) {
            class91.method1621(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.field1055 || var8.field3445 != 0 || var8.field3476 == 1 || var8.field3480) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.method4393(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.field3476 == 1 && var7 != null) {
                  var7.method2916(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method4393(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2588(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class61.field750[var0][var1][var2] |= 2340;
                  }

                  if(var8.field3476 != 0 && var7 != null) {
                     var7.method2914(var1, var2, var9, var10, var8.field3468);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method4393(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2586(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field748[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field3473) {
                        class267.field3669[var0][var1][var2] = 50;
                        class267.field3669[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.clipped) {
                        class61.field750[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field3473) {
                        class267.field3669[var0][var1][var2 + 1] = 50;
                        class267.field3669[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.clipped) {
                        class61.field750[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field3473) {
                        class267.field3669[var0][var1 + 1][var2] = 50;
                        class267.field3669[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.clipped) {
                        class61.field750[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field3473) {
                        class267.field3669[var0][var1][var2] = 50;
                        class267.field3669[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.clipped) {
                        class61.field750[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field3476 != 0 && var7 != null) {
                     var7.method2922(var1, var2, var5, var4, var8.field3468);
                  }

                  if(var8.field3475 != 16) {
                     var6.method2594(var0, var1, var2, var8.field3475);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method4393(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2586(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field756[var4], 0, var19, var20);
                  if(var8.field3473) {
                     if(var4 == 0) {
                        class267.field3669[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class267.field3669[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class267.field3669[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class267.field3669[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field3476 != 0 && var7 != null) {
                     var7.method2922(var1, var2, var5, var4, var8.field3468);
                  }

               } else {
                  int var26;
                  Object var28;
                  if(var5 == 2) {
                     var26 = var4 + 1 & 3;
                     Object var27;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var27 = var8.method4393(2, var4 + 4, var15, var17, var16, var18);
                        var28 = var8.method4393(2, var26, var15, var17, var16, var18);
                     } else {
                        var27 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var28 = new DynamicObject(var3, 2, var26, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2586(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class61.field748[var4], class61.field748[var26], var19, var20);
                     if(var8.clipped) {
                        if(var4 == 0) {
                           class61.field750[var0][var1][var2] |= 585;
                           class61.field750[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           class61.field750[var0][var1][var2 + 1] |= 1170;
                           class61.field750[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           class61.field750[var0][var1 + 1][var2] |= 585;
                           class61.field750[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class61.field750[var0][var1][var2] |= 1170;
                           class61.field750[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field3476 != 0 && var7 != null) {
                        var7.method2922(var1, var2, var5, var4, var8.field3468);
                     }

                     if(var8.field3475 != 16) {
                        var6.method2594(var0, var1, var2, var8.field3475);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method4393(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2586(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field756[var4], 0, var19, var20);
                     if(var8.field3473) {
                        if(var4 == 0) {
                           class267.field3669[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class267.field3669[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class267.field3669[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class267.field3669[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field3476 != 0 && var7 != null) {
                        var7.method2922(var1, var2, var5, var4, var8.field3468);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method4393(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2588(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.field3476 != 0 && var7 != null) {
                        var7.method2914(var1, var2, var9, var10, var8.field3468);
                     }

                     if(var8.field3475 != 16) {
                        var6.method2594(var0, var1, var2, var8.field3475);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method4393(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2700(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class61.field748[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var26 = 16;
                     var22 = var6.method2584(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class29.getObjectDefinition(var22 >> 14 & 32767).field3475;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.method4393(4, var4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2700(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class61.field748[var4], 0, var26 * class61.field757[var4], class61.field758[var4] * var26, var19, var20);
                  } else if(var5 == 6) {
                     var26 = 8;
                     var22 = var6.method2584(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class29.getObjectDefinition(var22 >> 14 & 32767).field3475 / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.method4393(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2700(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class61.field752[var4], var26 * class61.field760[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method4393(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new DynamicObject(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2700(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var26 = 8;
                     var22 = var6.method2584(var0, var1, var2);
                     if(var22 != 0) {
                        var26 = class29.getObjectDefinition(var22 >> 14 & 32767).field3475 / 2;
                     }

                     int var25 = var4 + 2 & 3;
                     Object var29;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.method4393(4, var4 + 4, var15, var17, var16, var18);
                        var29 = var8.method4393(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var29 = new DynamicObject(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method2700(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class61.field752[var4], class61.field760[var4] * var26, var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.method4393(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var21 != null && var6.method2588(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.field3473) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method2399() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class267.field3669[var0][var23 + var1][var2 + var24]) {
                           class267.field3669[var0][var23 + var1][var2 + var24] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field3476 != 0 && var7 != null) {
                  var7.method2914(var1, var2, var9, var10, var8.field3468);
               }

            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)LScript;",
      garbageValue = "737535581"
   )
   static Script method673(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method1757(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            class186 var9 = new class186(class231.method3979(var8));
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.method3394(new class198(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.method3040();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "825560900"
   )
   static void method674(String var0, String var1, String var2) {
      class92.loginMessage1 = var0;
      class92.loginMessage2 = var1;
      class92.loginMessage3 = var2;
   }

   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field612 = var1;
      this.field608 = var2;
      this.field607 = var3;
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(LWidget;I)LWidget;",
      garbageValue = "787447949"
   )
   static Widget method675(Widget var0) {
      Widget var1 = class60.method969(var0);
      if(var1 == null) {
         var1 = var0.dragParent;
      }

      return var1;
   }

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1040764770"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[Player.plane][var0][var1];
      if(var2 == null) {
         class17.region.method2599(Player.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method3487(); var6 != null; var6 = (Item)var2.method3512()) {
            ItemComposition var7 = class224.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class17.region.method2599(Player.plane, var0, var1);
         } else {
            var2.method3501(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method3487(); var6 != null; var6 = (Item)var2.method3512()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class17.region.method2585(Player.plane, var0, var1, class77.method1438(var0 * 128 + 64, var1 * 128 + 64, Player.plane), var5, var9, var11, var10);
         }
      }
   }
}
