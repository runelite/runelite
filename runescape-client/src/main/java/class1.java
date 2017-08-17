import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class1 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1668171507
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   static final class1 field4;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   static final class1 field1;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   static final class1 field2;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   static final class1 field3;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   static final class1 field9;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   static final class1 field5;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   static final class1 field6;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1512978505
   )
   final int field7;

   static {
      field4 = new class1(1);
      field1 = new class1(2);
      field2 = new class1(0);
      field3 = new class1(5);
      field9 = new class1(3);
      field5 = new class1(6);
      field6 = new class1(4);
   }

   class1(int var1) {
      this.field7 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "1"
   )
   public static final void method0(int var0, int var1, int var2, int var3, int var4) {
      class7.field231.method3568(new class8(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "1614184759"
   )
   static int method1(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class84.intStack[--class84.intStackSize];
         var3 = class84.method1670(var4);
      } else {
         var3 = var2?class43.field582:class208.field2580;
      }

      if(var0 == 1100) {
         class84.intStackSize -= 2;
         var3.scrollX = class84.intStack[class84.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class84.intStack[class84.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class90.method1723(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class84.intStack[--class84.intStackSize];
         class90.method1723(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2678 = class84.intStack[--class84.intStackSize] == 1;
         class90.method1723(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class84.intStack[--class84.intStackSize];
         class90.method1723(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2684 = class84.intStack[--class84.intStackSize];
         class90.method1723(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class84.intStack[--class84.intStackSize];
         class90.method1723(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class84.intStack[--class84.intStackSize];
         class90.method1723(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2687 = class84.intStack[--class84.intStackSize] == 1;
         class90.method1723(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class84.intStack[--class84.intStackSize];
         class90.method1723(var3);
         return 1;
      } else if(var0 == 1109) {
         class84.intStackSize -= 6;
         var3.field2698 = class84.intStack[class84.intStackSize];
         var3.field2699 = class84.intStack[class84.intStackSize + 1];
         var3.rotationX = class84.intStack[class84.intStackSize + 2];
         var3.rotationZ = class84.intStack[class84.intStackSize + 3];
         var3.rotationY = class84.intStack[class84.intStackSize + 4];
         var3.modelZoom = class84.intStack[class84.intStackSize + 5];
         class90.method1723(var3);
         return 1;
      } else {
         int var9;
         if(var0 == 1110) {
            var9 = class84.intStack[--class84.intStackSize];
            if(var9 != var3.field2775) {
               var3.field2775 = var9;
               var3.field2771 = 0;
               var3.field2747 = 0;
               class90.method1723(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2706 = class84.intStack[--class84.intStackSize] == 1;
            class90.method1723(var3);
            return 1;
         } else if(var0 == 1112) {
            String var7 = class84.scriptStringStack[--class91.scriptStringStackSize];
            if(!var7.equals(var3.text)) {
               var3.text = var7;
               class90.method1723(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class84.intStack[--class84.intStackSize];
            class90.method1723(var3);
            return 1;
         } else if(var0 == 1114) {
            class84.intStackSize -= 3;
            var3.field2772 = class84.intStack[class84.intStackSize];
            var3.field2682 = class84.intStack[class84.intStackSize + 1];
            var3.field2711 = class84.intStack[class84.intStackSize + 2];
            class90.method1723(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class84.intStack[--class84.intStackSize] == 1;
            class90.method1723(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class84.intStack[--class84.intStackSize];
            class90.method1723(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class84.intStack[--class84.intStackSize];
            class90.method1723(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class84.intStack[--class84.intStackSize] == 1;
            class90.method1723(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class84.intStack[--class84.intStackSize] == 1;
            class90.method1723(var3);
            return 1;
         } else if(var0 == 1120) {
            class84.intStackSize -= 2;
            var3.scrollWidth = class84.intStack[class84.intStackSize];
            var3.scrollHeight = class84.intStack[class84.intStackSize + 1];
            class90.method1723(var3);
            if(var4 != -1 && var3.type == 0) {
               class51.method812(class176.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var9 = var3.id;
            int var6 = var3.index;
            Client.secretPacketBuffer1.putOpcode(72);
            Client.secretPacketBuffer1.putShort(var6);
            Client.secretPacketBuffer1.putLEShortA(var9);
            Client.field1090 = var3;
            class90.method1723(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2685 = class84.intStack[--class84.intStackSize];
            class90.method1723(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2675 = class84.intStack[--class84.intStackSize];
            class90.method1723(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2681 = class84.intStack[--class84.intStackSize];
            class90.method1723(var3);
            return 1;
         } else if(var0 == 1125) {
            var9 = class84.intStack[--class84.intStackSize];
            class284 var8 = (class284)PlayerComposition.forOrdinal(PendingSpawn.method1524(), var9);
            if(var8 != null) {
               var3.field2679 = var8;
               class90.method1723(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class84.intStack[--class84.intStackSize] == 1;
            var3.field2683 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Lii;",
      garbageValue = "107"
   )
   public static InvType method2(int var0) {
      InvType var1 = (InvType)InvType.inventoryCache.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = InvType.field3268.getConfigData(5, var0);
         var1 = new InvType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         InvType.inventoryCache.put(var1, (long)var0);
         return var1;
      }
   }
}
