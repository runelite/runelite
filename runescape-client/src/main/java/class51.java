import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class51 implements class103 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1697444433
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("gd")
   static SpritePixels[] field670;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Lclass109;",
      garbageValue = "1993592379"
   )
   public class109 vmethod1916() {
      return new class55();
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   static final boolean method755(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "82"
   )
   static void method756(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method3520((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method3516(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1550525169"
   )
   static void method757() {
      Client.secretPacketBuffer1.putOpcode(225);
      PacketBuffer var0 = Client.secretPacketBuffer1;
      int var1 = Client.isResized?2:1;
      var0.putByte(var1);
      Client.secretPacketBuffer1.putShort(VertexNormal.field2020);
      Client.secretPacketBuffer1.putShort(class18.field311);
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(LWidget;IIII)V",
      garbageValue = "-1538637715"
   )
   static final void method758(Widget var0, int var1, int var2, int var3) {
      class210 var4 = var0.method3987(false);
      if(var4 != null) {
         if(Client.field1170 < 3) {
            class109.field1660.method5057(var1, var2, var4.field2602, var4.field2601, 25, 25, Client.mapAngle, 256, var4.field2603, var4.field2605);
         } else {
            Rasterizer2D.method4938(var1, var2, 0, var4.field2603, var4.field2605);
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;II)Z",
      garbageValue = "-1065010399"
   )
   static boolean method759(PacketBuffer var0, int var1) {
      int var2 = var0.method3397(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method3397(1) != 0) {
            method759(var0, var1);
         }

         var3 = var0.method3397(13);
         var4 = var0.method3397(13);
         boolean var12 = var0.method3397(1) == 1;
         if(var12) {
            class96.field1517[++class96.field1514 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field912 = var1;
            if(class96.field1506[var1] != null) {
               var6.method1116(class96.field1506[var1]);
            }

            var6.field1259 = class96.field1512[var1];
            var6.interacting = class96.field1513[var1];
            var7 = class96.field1511[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field1257[0] = class96.field1503[var1];
            var6.field911 = (byte)var8;
            var6.method1120(var3 + (var9 << 13) - class41.baseX, var4 + (var10 << 13) - WorldMapType3.baseY);
            var6.field890 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3397(2);
         var4 = class96.field1511[var1];
         class96.field1511[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method3397(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class96.field1511[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class96.field1511[var1] = var9 + (var8 << 14) + (var7 << 28);
            return false;
         } else {
            var3 = var0.method3397(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class96.field1511[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var7 + var11 & 255;
            class96.field1511[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2016166626"
   )
   public static int method760(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var2 * var0;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILIndexDataBase;IIIZI)V",
      garbageValue = "1294402700"
   )
   public static void method762(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class203.field2514 = 1;
      class203.field2513 = var1;
      class203.field2515 = var2;
      class157.field2280 = var3;
      class151.field2229 = var4;
      class87.field1404 = var5;
      ChatMessages.field1527 = var0;
   }
}
