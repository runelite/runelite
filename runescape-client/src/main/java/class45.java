import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class45 extends class28 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 831553341
   )
   int field583;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -369602315
   )
   int field585;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2047021049
   )
   int field582;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 308421573
   )
   int field584;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "14"
   )
   int method644() {
      return this.field584;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1466370814"
   )
   boolean method626(int var1, int var2) {
      return var1 < this.field584 * 8?false:(var2 < this.field582 * 8?false:(var1 >= this.field584 * 8 + 8?false:var2 < this.field582 * 8 + 8));
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "86012507"
   )
   int method630() {
      return this.field582;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfh;Lfh;B)V",
      garbageValue = "-29"
   )
   void method625(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field506.field507) {
         throw new IllegalStateException("");
      } else {
         super.field402 = var2.readUnsignedByte();
         super.field407 = var2.readUnsignedByte();
         super.field411 = var2.readUnsignedShort();
         super.field409 = var2.readUnsignedShort();
         this.field585 = var2.readUnsignedByte();
         this.field583 = var2.readUnsignedByte();
         super.field404 = var2.readUnsignedShort();
         super.field405 = var2.readUnsignedShort();
         this.field584 = var2.readUnsignedByte();
         this.field582 = var2.readUnsignedByte();
         super.field407 = Math.min(super.field407, 4);
         super.field408 = new short[1][64][64];
         super.field403 = new short[super.field407][64][64];
         super.field410 = new byte[super.field407][64][64];
         super.field413 = new byte[super.field407][64][64];
         super.field412 = new class31[super.field407][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field497.field499) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field404 && var5 == super.field405 && var6 == this.field584 && var7 == this.field582) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method225(this.field584 * 8 + var8, var9 + this.field582 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1908736392"
   )
   int method653() {
      return this.field585;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   int method628() {
      return this.field583;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return super.field404 == var2.field404 && var2.field405 == super.field405?var2.field584 == this.field584 && this.field582 == var2.field582:false;
      }
   }

   public int hashCode() {
      return super.field404 | super.field405 << 8 | this.field584 << 16 | this.field582 << 24;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-2004696123"
   )
   @Export("getLength")
   public static int getLength(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1537195105"
   )
   public static void method654() {
      FloorUnderlayDefinition.underlays.reset();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfu;B)V",
      garbageValue = "85"
   )
   public static void method655(Huffman var0) {
      class12.field274 = var0;
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1199091719"
   )
   static final void method651() {
      for(int var0 = 0; var0 < Client.field1144; ++var0) {
         --Client.field1147[var0];
         if(Client.field1147[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(CombatInfo1.field1272, Client.field1175[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.field1147[var0] += var9.calculateDelay();
               Client.audioEffects[var0] = var9;
            }

            if(Client.field1147[var0] < 0) {
               int var2;
               if(Client.field1148[var0] != 0) {
                  int var3 = (Client.field1148[var0] & 255) * 128;
                  int var4 = Client.field1148[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - class54.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field1148[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - class54.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.field1147[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field1143 / var3;
               } else {
                  var2 = Client.field1109;
               }

               if(var2 > 0) {
                  class108 var10 = var9.method1964().method2011(class228.field3114);
                  class118 var11 = class118.method2147(var10, 100, var2);
                  var11.method2286(Client.field1146[var0] - 1);
                  class36.field513.method1911(var11);
               }

               Client.field1147[var0] = -100;
            }
         } else {
            --Client.field1144;

            for(int var1 = var0; var1 < Client.field1144; ++var1) {
               Client.field1175[var1] = Client.field1175[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.field1146[var1] = Client.field1146[var1 + 1];
               Client.field1147[var1] = Client.field1147[var1 + 1];
               Client.field1148[var1] = Client.field1148[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field1141) {
         boolean var12;
         if(class204.field2487 != 0) {
            var12 = true;
         } else {
            var12 = class204.field2486.method3708();
         }

         if(!var12) {
            if(Client.field1060 != 0 && Client.field1140 != -1) {
               WorldMapType1.method276(class244.indexTrack1, Client.field1140, 0, Client.field1060, false);
            }

            Client.field1141 = false;
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIIILej;Lfo;I)V",
      garbageValue = "1298974323"
   )
   static final void method649(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Region var7, CollisionData var8) {
      ObjectComposition var9 = WorldMapType1.getObjectDefinition(var4);
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
      if(var10 + var2 <= 104) {
         var12 = (var10 >> 1) + var2;
         var13 = (var10 + 1 >> 1) + var2;
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var3 + var11 <= 104) {
         var14 = var3 + (var11 >> 1);
         var15 = var3 + (var11 + 1 >> 1);
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = class61.tileHeights[var1];
      int var17 = var16[var12][var15] + var16[var13][var14] + var16[var12][var14] + var16[var13][var15] >> 2;
      int var18 = (var2 << 7) + (var10 << 6);
      int var19 = (var3 << 7) + (var11 << 6);
      int var20 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
      if(var9.field3435 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if(var9.field3451 == 1) {
         var21 += 256;
      }

      Object var22;
      if(var6 == 22) {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4539(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new DynamicObject(var4, 22, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         var7.groundObjectSpawned(var0, var2, var3, var17, (Renderable)var22, var20, var21);
         if(var9.interactType == 1) {
            var8.block(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4539(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method2883(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
            if(var9.interactType != 0) {
               var8.addObject(var2, var3, var10, var11, var9.field3433);
            }

         } else if(var6 == 0) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4539(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, 0, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field749[var5], 0, var20, var21);
            if(var9.interactType != 0) {
               var8.addWall(var2, var3, var6, var5, var9.field3433);
            }

         } else if(var6 == 1) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4539(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, 1, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field750[var5], 0, var20, var21);
            if(var9.interactType != 0) {
               var8.addWall(var2, var3, var6, var5, var9.field3433);
            }

         } else {
            Object var24;
            int var27;
            if(var6 == 2) {
               var27 = var5 + 1 & 3;
               Object var23;
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var23 = var9.method4539(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method4539(2, var27, var16, var18, var17, var19);
               } else {
                  var23 = new DynamicObject(var4, 2, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  var24 = new DynamicObject(var4, 2, var27, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundary(var0, var2, var3, var17, (Renderable)var23, (Renderable)var24, class61.field749[var5], class61.field749[var27], var20, var21);
               if(var9.interactType != 0) {
                  var8.addWall(var2, var3, var6, var5, var9.field3433);
               }

            } else if(var6 == 3) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4539(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, 3, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field750[var5], 0, var20, var21);
               if(var9.interactType != 0) {
                  var8.addWall(var2, var3, var6, var5, var9.field3433);
               }

            } else if(var6 == 9) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4539(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2883(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
               if(var9.interactType != 0) {
                  var8.addObject(var2, var3, var10, var11, var9.field3433);
               }

            } else if(var6 == 4) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4539(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field749[var5], 0, 0, 0, var20, var21);
            } else {
               int var28;
               if(var6 == 5) {
                  var27 = 16;
                  var28 = var7.method2736(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = WorldMapType1.getObjectDefinition(var28 >> 14 & 32767).field3429;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4539(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, class61.field749[var5], 0, var27 * class61.field751[var5], var27 * class61.field752[var5], var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var28 = var7.method2736(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = WorldMapType1.getObjectDefinition(var28 >> 14 & 32767).field3429 / 2;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4539(4, var5 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, var27 * class61.field755[var5], var27 * class61.field747[var5], var20, var21);
               } else if(var6 == 7) {
                  var28 = var5 + 2 & 3;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var22 = var9.method4539(4, var28 + 4, var16, var18, var17, var19);
                  } else {
                     var22 = new DynamicObject(var4, 4, var28 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, 256, var28, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var28 = var7.method2736(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = WorldMapType1.getObjectDefinition(var28 >> 14 & 32767).field3429 / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4539(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method4539(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                     var25 = new DynamicObject(var4, 4, var26 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, var27 * class61.field755[var5], var27 * class61.field747[var5], var20, var21);
               }
            }
         }
      } else {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4539(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new DynamicObject(var4, 10, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         if(var22 != null) {
            var7.method2883(var0, var2, var3, var17, var10, var11, (Renderable)var22, var6 == 11?256:0, var20, var21);
         }

         if(var9.interactType != 0) {
            var8.addObject(var2, var3, var10, var11, var9.field3433);
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILcc;ZI)I",
      garbageValue = "1074252033"
   )
   static int method652(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 == 2700) {
         var3 = class266.method4862(class84.intStack[--class84.intStackSize]);
         class84.intStack[++class84.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 2701) {
         var3 = class266.method4862(class84.intStack[--class84.intStackSize]);
         if(var3.itemId != -1) {
            class84.intStack[++class84.intStackSize - 1] = var3.itemQuantity;
         } else {
            class84.intStack[++class84.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2702) {
         int var5 = class84.intStack[--class84.intStackSize];
         WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var5);
         if(var4 != null) {
            class84.intStack[++class84.intStackSize - 1] = 1;
         } else {
            class84.intStack[++class84.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2706) {
         class84.intStack[++class84.intStackSize - 1] = Client.widgetRoot;
         return 1;
      } else {
         return 2;
      }
   }
}
