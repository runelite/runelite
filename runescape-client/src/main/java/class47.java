import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class47 {
   @ObfuscatedName("a")
   static int[] field555;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = 1304566643
   )
   static int field562;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1091963031
   )
   public int field559;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   public Coordinates field560;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   public Coordinates field556;

   @ObfuscatedSignature(
      signature = "(ILhk;Lhk;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field559 = var1;
      this.field560 = var2;
      this.field556 = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-300330105"
   )
   static int method663(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-526703513"
   )
   static void method660(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(KeyFocusListener.keyboard);
      var0.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfs;IIIIIIB)V",
      garbageValue = "0"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -class51.method722(932731 + var2 + var4, var5 + 556238 + var3) * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class37.field474[var1][var2][var3] = var0.readByte();
               class61.field702[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class19.field296[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class233.field3204[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIILjt;II)V",
      garbageValue = "-61503583"
   )
   static void method664(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class81 var5 = new class81();
      var5.field1239 = var0;
      var5.field1248 = var1 * 128;
      var5.field1252 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field1242 = (var6 + var1) * 128;
      var5.field1241 = (var7 + var2) * 128;
      var5.field1243 = var3.ambientSoundId;
      var5.field1238 = var3.field3531 * 128;
      var5.field1245 = var3.field3503;
      var5.field1246 = var3.field3533;
      var5.field1247 = var3.field3532;
      if(var3.impostorIds != null) {
         var5.field1250 = var3;
         var5.method1576();
      }

      class81.field1240.addFront(var5);
      if(var5.field1247 != null) {
         var5.field1237 = var5.field1245 + (int)(Math.random() * (double)(var5.field1246 - var5.field1245));
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "-1026520444"
   )
   static int method662(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class64.method1017(class82.intStack[--class82.intStackSize]);
      } else {
         var3 = var2?class234.field3210:class82.field1253;
      }

      ScriptEvent.method1038(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class82.intStack[--class82.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class275.localPlayer.composition.method3990();
            return 1;
         } else {
            return 2;
         }
      } else {
         class82.intStackSize -= 2;
         int var4 = class82.intStack[class82.intStackSize];
         int var5 = class82.intStack[class82.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class139.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2762 = var6.offsetX2d;
         var3.field2763 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2787 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2787 = 1;
         } else {
            var3.field2787 = 2;
         }

         if(var3.field2768 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2768;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }
}
