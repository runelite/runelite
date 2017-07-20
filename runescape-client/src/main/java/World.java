import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("World")
public class World {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1044363357
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2011367347
   )
   static int field1283;
   @ObfuscatedName("x")
   static int[] field1285;
   @ObfuscatedName("p")
   static int[] field1281;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 1051687721
   )
   static int field1293;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1406277343
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2094677819
   )
   @Export("index")
   int index;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -839336279
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 18557115
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @Export("address")
   String address;
   @ObfuscatedName("t")
   @Export("activity")
   String activity;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 135634683
   )
   @Export("location")
   int location;

   static {
      worldCount = 0;
      field1283 = 0;
      field1285 = new int[]{1, 1, 1, 1};
      field1281 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-54664777"
   )
   boolean method1507() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1750682836"
   )
   boolean method1506() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "4431"
   )
   boolean method1511() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "520576485"
   )
   boolean method1512() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1225149159"
   )
   boolean method1510() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "874426345"
   )
   boolean method1508() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(IIIILjj;Lhm;B)V",
      garbageValue = "-13"
   )
   static final void method1536(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class9.mapedge.method4970(var14 + 94 + var0 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class87.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "-1638546512"
   )
   static int method1537(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class83.intStack[--BufferProvider.intStackSize];
         var3 = class239.method4167(var4);
      } else {
         var3 = var2?class48.field614:FaceNormal.field2099;
      }

      if(var0 == 1100) {
         BufferProvider.intStackSize -= 2;
         var3.scrollX = class83.intStack[BufferProvider.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class83.intStack[BufferProvider.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class21.method156(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class83.intStack[--BufferProvider.intStackSize];
         class21.method156(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2646 = class83.intStack[--BufferProvider.intStackSize] == 1;
         class21.method156(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class83.intStack[--BufferProvider.intStackSize];
         class21.method156(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2650 = class83.intStack[--BufferProvider.intStackSize];
         class21.method156(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class83.intStack[--BufferProvider.intStackSize];
         class21.method156(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class83.intStack[--BufferProvider.intStackSize];
         class21.method156(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2655 = class83.intStack[--BufferProvider.intStackSize] == 1;
         class21.method156(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class83.intStack[--BufferProvider.intStackSize];
         class21.method156(var3);
         return 1;
      } else if(var0 == 1109) {
         BufferProvider.intStackSize -= 6;
         var3.field2661 = class83.intStack[BufferProvider.intStackSize];
         var3.field2667 = class83.intStack[BufferProvider.intStackSize + 1];
         var3.rotationX = class83.intStack[BufferProvider.intStackSize + 2];
         var3.rotationZ = class83.intStack[BufferProvider.intStackSize + 3];
         var3.rotationY = class83.intStack[BufferProvider.intStackSize + 4];
         var3.modelZoom = class83.intStack[BufferProvider.intStackSize + 5];
         class21.method156(var3);
         return 1;
      } else {
         int var9;
         if(var0 == 1110) {
            var9 = class83.intStack[--BufferProvider.intStackSize];
            if(var9 != var3.field2664) {
               var3.field2664 = var9;
               var3.field2739 = 0;
               var3.field2676 = 0;
               class21.method156(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2680 = class83.intStack[--BufferProvider.intStackSize] == 1;
            class21.method156(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class83.scriptStringStack[--class83.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               class21.method156(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class83.intStack[--BufferProvider.intStackSize];
            class21.method156(var3);
            return 1;
         } else if(var0 == 1114) {
            BufferProvider.intStackSize -= 3;
            var3.field2718 = class83.intStack[BufferProvider.intStackSize];
            var3.field2681 = class83.intStack[BufferProvider.intStackSize + 1];
            var3.field2644 = class83.intStack[BufferProvider.intStackSize + 2];
            class21.method156(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class83.intStack[--BufferProvider.intStackSize] == 1;
            class21.method156(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class83.intStack[--BufferProvider.intStackSize];
            class21.method156(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class83.intStack[--BufferProvider.intStackSize];
            class21.method156(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class83.intStack[--BufferProvider.intStackSize] == 1;
            class21.method156(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class83.intStack[--BufferProvider.intStackSize] == 1;
            class21.method156(var3);
            return 1;
         } else if(var0 == 1120) {
            BufferProvider.intStackSize -= 2;
            var3.scrollWidth = class83.intStack[BufferProvider.intStackSize];
            var3.scrollHeight = class83.intStack[BufferProvider.intStackSize + 1];
            class21.method156(var3);
            if(var4 != -1 && var3.type == 0) {
               class77.method1465(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class64.method1034(var3.id, var3.index);
            Client.field1068 = var3;
            class21.method156(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2653 = class83.intStack[--BufferProvider.intStackSize];
            class21.method156(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2643 = class83.intStack[--BufferProvider.intStackSize];
            class21.method156(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2649 = class83.intStack[--BufferProvider.intStackSize];
            class21.method156(var3);
            return 1;
         } else if(var0 == 1125) {
            var9 = class83.intStack[--BufferProvider.intStackSize];
            class283[] var6 = new class283[]{class283.field3753, class283.field3756, class283.field3754, class283.field3755, class283.field3752};
            class283 var7 = (class283)class36.forOrdinal(var6, var9);
            if(var7 != null) {
               var3.field2647 = var7;
               class21.method156(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class83.intStack[--BufferProvider.intStackSize] == 1;
            var3.field2663 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }
}
