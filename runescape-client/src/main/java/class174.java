import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class174 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1562770219
   )
   static int field2402;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1143007977
   )
   static int field2401;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -934958249
   )
   static int field2404;
   @ObfuscatedName("r")
   static byte[][] field2403;
   @ObfuscatedName("v")
   static byte[][] field2400;
   @ObfuscatedName("e")
   static byte[][] field2405;

   static {
      field2402 = 0;
      field2401 = 0;
      field2404 = 0;
      field2403 = new byte[1000][];
      field2400 = new byte[250][];
      field2405 = new byte[50][];
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-10"
   )
   static synchronized byte[] method3348(int var0) {
      byte[] var1;
      if(var0 == 100 && field2402 > 0) {
         var1 = field2403[--field2402];
         field2403[field2402] = null;
         return var1;
      } else if(var0 == 5000 && field2401 > 0) {
         var1 = field2400[--field2401];
         field2400[field2401] = null;
         return var1;
      } else if(var0 == 30000 && field2404 > 0) {
         var1 = field2405[--field2404];
         field2405[field2404] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-926492121"
   )
   public static int method3347(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0:(var2 == 2?7 - var1:var0));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1387090026"
   )
   static int method3352(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class83.intStack[--WorldMapType2.intStackSize];
         var3 = class61.method1038(var4);
      } else {
         var3 = var2?class83.field1336:class1.field9;
      }

      if(var0 == 1100) {
         WorldMapType2.intStackSize -= 2;
         var3.scrollX = class83.intStack[WorldMapType2.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class83.intStack[WorldMapType2.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class48.method749(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class83.intStack[--WorldMapType2.intStackSize];
         class48.method749(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2682 = class83.intStack[--WorldMapType2.intStackSize] == 1;
         class48.method749(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class83.intStack[--WorldMapType2.intStackSize];
         class48.method749(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2643 = class83.intStack[--WorldMapType2.intStackSize];
         class48.method749(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class83.intStack[--WorldMapType2.intStackSize];
         class48.method749(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class83.intStack[--WorldMapType2.intStackSize];
         class48.method749(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2691 = class83.intStack[--WorldMapType2.intStackSize] == 1;
         class48.method749(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class83.intStack[--WorldMapType2.intStackSize];
         class48.method749(var3);
         return 1;
      } else if(var0 == 1109) {
         WorldMapType2.intStackSize -= 6;
         var3.field2702 = class83.intStack[WorldMapType2.intStackSize];
         var3.field2670 = class83.intStack[WorldMapType2.intStackSize + 1];
         var3.rotationX = class83.intStack[WorldMapType2.intStackSize + 2];
         var3.rotationZ = class83.intStack[WorldMapType2.intStackSize + 3];
         var3.rotationY = class83.intStack[WorldMapType2.intStackSize + 4];
         var3.modelZoom = class83.intStack[WorldMapType2.intStackSize + 5];
         class48.method749(var3);
         return 1;
      } else {
         int var10;
         if(var0 == 1110) {
            var10 = class83.intStack[--WorldMapType2.intStackSize];
            if(var10 != var3.field2777) {
               var3.field2777 = var10;
               var3.field2772 = 0;
               var3.field2776 = 0;
               class48.method749(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2687 = class83.intStack[--WorldMapType2.intStackSize] == 1;
            class48.method749(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class83.scriptStringStack[--BaseVarType.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               class48.method749(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class83.intStack[--WorldMapType2.intStackSize];
            class48.method749(var3);
            return 1;
         } else if(var0 == 1114) {
            WorldMapType2.intStackSize -= 3;
            var3.field2716 = class83.intStack[WorldMapType2.intStackSize];
            var3.field2749 = class83.intStack[WorldMapType2.intStackSize + 1];
            var3.field2651 = class83.intStack[WorldMapType2.intStackSize + 2];
            class48.method749(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class83.intStack[--WorldMapType2.intStackSize] == 1;
            class48.method749(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class83.intStack[--WorldMapType2.intStackSize];
            class48.method749(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class83.intStack[--WorldMapType2.intStackSize];
            class48.method749(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class83.intStack[--WorldMapType2.intStackSize] == 1;
            class48.method749(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class83.intStack[--WorldMapType2.intStackSize] == 1;
            class48.method749(var3);
            return 1;
         } else if(var0 == 1120) {
            WorldMapType2.intStackSize -= 2;
            var3.scrollWidth = class83.intStack[WorldMapType2.intStackSize];
            var3.scrollHeight = class83.intStack[WorldMapType2.intStackSize + 1];
            class48.method749(var3);
            if(var4 != -1 && var3.type == 0) {
               class36.method487(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var10 = var3.id;
            int var6 = var3.index;
            Client.secretPacketBuffer1.putOpcode(213);
            Client.secretPacketBuffer1.putLEInt(var10);
            Client.secretPacketBuffer1.putLEShortA(var6);
            Client.field1070 = var3;
            class48.method749(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2689 = class83.intStack[--WorldMapType2.intStackSize];
            class48.method749(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2703 = class83.intStack[--WorldMapType2.intStackSize];
            class48.method749(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2708 = class83.intStack[--WorldMapType2.intStackSize];
            class48.method749(var3);
            return 1;
         } else if(var0 == 1125) {
            var10 = class83.intStack[--WorldMapType2.intStackSize];
            class283[] var9 = new class283[]{class283.field3766, class283.field3769, class283.field3768, class283.field3765, class283.field3767};
            class283 var7 = (class283)PendingSpawn.forOrdinal(var9, var10);
            if(var7 != null) {
               var3.field2683 = var7;
               class48.method749(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class83.intStack[--WorldMapType2.intStackSize] == 1;
            var3.field2721 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }
}
