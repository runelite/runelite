import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public final class class60 {
   @ObfuscatedName("a")
   @Export("userHome")
   static String userHome;
   @ObfuscatedName("n")
   static int[] field719;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lin;",
      garbageValue = "-106468967"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class140.field2086.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "-2071466269"
   )
   public static int method1053(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1163618220"
   )
   public static boolean method1048(int var0) {
      return var0 == class221.field2807.field2813;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2104963610"
   )
   static void method1050() {
      class98.chatLineMap.clear();
      class98.field1494.clear();
      class98.field1495.method3679();
      class98.field1493 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "1624302120"
   )
   static int method1055(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = WallObject.method2901(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class214.field2615:class73.field851;
      }

      class48.method732(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class83.intStack[--class83.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class224.localPlayer.composition.method3968();
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
         ItemComposition var6 = Friend.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2678 = var6.offsetX2d;
         var3.field2693 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2744 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2744 = 1;
         } else {
            var3.field2744 = 2;
         }

         if(var3.field2684 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2684;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILcd;ZI)I",
      garbageValue = "-1727211053"
   )
   static int method1051(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      int var6;
      if(var0 == 3400) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         Enum var5 = Permission.method4099(var3);
         if(var5.valType != 115) {
            ;
         }

         for(var6 = 0; var6 < var5.size; ++var6) {
            if(var4 == var5.keys[var6]) {
               class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var5.stringVals[var6];
               var5 = null;
               break;
            }
         }

         if(var5 != null) {
            class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var5.defaultString;
         }

         return 1;
      } else if(var0 != 3408) {
         return 2;
      } else {
         class83.intStackSize -= 4;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         int var9 = class83.intStack[class83.intStackSize + 2];
         var6 = class83.intStack[class83.intStackSize + 3];
         Enum var7 = Permission.method4099(var9);
         if(var3 == var7.keyType && var4 == var7.valType) {
            for(int var8 = 0; var8 < var7.size; ++var8) {
               if(var6 == var7.keys[var8]) {
                  if(var4 == 115) {
                     class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var7.stringVals[var8];
                  } else {
                     class83.intStack[++class83.intStackSize - 1] = var7.intVals[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if(var7 != null) {
               if(var4 == 115) {
                  class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = var7.defaultString;
               } else {
                  class83.intStack[++class83.intStackSize - 1] = var7.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class83.scriptStringStack[++Timer.scriptStringStackSize - 1] = "null";
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
