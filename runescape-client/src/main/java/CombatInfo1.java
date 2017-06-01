import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -914481291
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -184528375
   )
   @Export("health")
   int health;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -62191565
   )
   int field1306;
   @ObfuscatedName("y")
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 920202283
   )
   int field1309;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field1306 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1309 = var4;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIIILRegion;LCollisionData;B)V",
      garbageValue = "75"
   )
   static final void method1535(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Region var7, CollisionData var8) {
      ObjectComposition var9 = class226.getObjectDefinition(var4);
      int var10;
      int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = var9.sizeX;
         var11 = var9.sizeY;
      } else {
         var10 = var9.sizeY;
         var11 = var9.sizeX;
      }

      int var12;
      int var13;
      if(var2 + var10 <= 104) {
         var12 = var2 + (var10 >> 1);
         var13 = var2 + (var10 + 1 >> 1);
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var11 + var3 <= 104) {
         var14 = var3 + (var11 >> 1);
         var15 = (var11 + 1 >> 1) + var3;
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = class61.tileHeights[var1];
      int var17 = var16[var12][var14] + var16[var13][var14] + var16[var12][var15] + var16[var13][var15] >> 2;
      int var18 = (var10 << 6) + (var2 << 7);
      int var19 = (var11 << 6) + (var3 << 7);
      int var20 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
      if(var9.field3451 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if(var9.field3472 == 1) {
         var21 += 256;
      }

      Object var22;
      if(var6 == 22) {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4531(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new class100(var4, 22, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         var7.groundObjectSpawned(var0, var2, var3, var17, (Renderable)var22, var20, var21);
         if(var9.field3471 == 1) {
            var8.method3050(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4531(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new class100(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method2735(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
            if(var9.field3471 != 0) {
               var8.method3024(var2, var3, var10, var11, var9.field3450);
            }

         } else if(var6 == 0) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4531(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new class100(var4, 0, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method2682(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field771[var5], 0, var20, var21);
            if(var9.field3471 != 0) {
               var8.method3021(var2, var3, var6, var5, var9.field3450);
            }

         } else if(var6 == 1) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4531(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new class100(var4, 1, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method2682(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field767[var5], 0, var20, var21);
            if(var9.field3471 != 0) {
               var8.method3021(var2, var3, var6, var5, var9.field3450);
            }

         } else {
            Object var24;
            int var27;
            if(var6 == 2) {
               var27 = var5 + 1 & 3;
               Object var28;
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var28 = var9.method4531(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method4531(2, var27, var16, var18, var17, var19);
               } else {
                  var28 = new class100(var4, 2, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  var24 = new class100(var4, 2, var27, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2682(var0, var2, var3, var17, (Renderable)var28, (Renderable)var24, class61.field771[var5], class61.field771[var27], var20, var21);
               if(var9.field3471 != 0) {
                  var8.method3021(var2, var3, var6, var5, var9.field3450);
               }

            } else if(var6 == 3) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4531(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class100(var4, 3, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2682(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field767[var5], 0, var20, var21);
               if(var9.field3471 != 0) {
                  var8.method3021(var2, var3, var6, var5, var9.field3450);
               }

            } else if(var6 == 9) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4531(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class100(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2735(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
               if(var9.field3471 != 0) {
                  var8.method3024(var2, var3, var10, var11, var9.field3450);
               }

            } else if(var6 == 4) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4531(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class100(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2820(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field771[var5], 0, 0, 0, var20, var21);
            } else {
               int var23;
               if(var6 == 5) {
                  var27 = 16;
                  var23 = var7.method2704(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = class226.getObjectDefinition(var23 >> 14 & 32767).field3435;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4531(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class100(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method2820(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, class61.field771[var5], 0, var27 * class61.field760[var5], var27 * class61.field758[var5], var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var23 = var7.method2704(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = class226.getObjectDefinition(var23 >> 14 & 32767).field3435 / 2;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4531(4, var5 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new class100(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method2820(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, var27 * class61.field770[var5], var27 * class61.field766[var5], var20, var21);
               } else if(var6 == 7) {
                  var23 = var5 + 2 & 3;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var22 = var9.method4531(4, var23 + 4, var16, var18, var17, var19);
                  } else {
                     var22 = new class100(var4, 4, var23 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method2820(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, 256, var23, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var23 = var7.method2704(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = class226.getObjectDefinition(var23 >> 14 & 32767).field3435 / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4531(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method4531(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new class100(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                     var25 = new class100(var4, 4, var26 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method2820(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, var27 * class61.field770[var5], class61.field766[var5] * var27, var20, var21);
               }
            }
         }
      } else {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4531(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new class100(var4, 10, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         if(var22 != null) {
            var7.method2735(var0, var2, var3, var17, var10, var11, (Renderable)var22, var6 == 11?256:0, var20, var21);
         }

         if(var9.field3471 != 0) {
            var8.method3024(var2, var3, var10, var11, var9.field3450);
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-53"
   )
   void method1536(int var1, int var2, int var3, int var4) {
      this.field1306 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field1309 = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1713007504"
   )
   static int method1539(int var0, int var1, int var2) {
      return (class61.tileSettings[var0][var1][var2] & 8) != 0?0:(var0 > 0 && (class61.tileSettings[1][var1][var2] & 2) != 0?var0 - 1:var0);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-795070799"
   )
   static byte[] method1541(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LSpotanim;",
      garbageValue = "-984849494"
   )
   public static Spotanim method1542(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.field3322.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.field3329.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.field3324 = var0;
         if(var2 != null) {
            var1.method4339(new Buffer(var2));
         }

         Spotanim.field3322.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BI)LScript;",
      garbageValue = "-953800893"
   )
   static Script method1543(byte[] var0) {
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
         var1.switches = var1.method1841(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            class186 var9 = new class186(class29.method228(var8));
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.method3476(new class198(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.method3148();
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-673679441"
   )
   static int method1544(int var0, Script var1, boolean var2) {
      Widget var3 = WorldMapType3.method199(class83.intStack[--class83.intStackSize]);
      if(var0 == 2500) {
         class83.intStack[++class83.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class83.intStack[++class83.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class83.intStack[++class83.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class83.intStack[++class83.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class83.intStack[++class83.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class83.intStack[++class83.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
