import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class37 {
   @ObfuscatedName("v")
   @Export("offsetsY")
   static int[] offsetsY;
   @ObfuscatedName("e")
   static byte[][][] field490;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1095180709
   )
   public static int field485;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1751083468"
   )
   static void method551(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-346256032"
   )
   public static void method552(int var0) {
      class210.field2594 = 1;
      class184.field2516 = null;
      class210.field2598 = -1;
      class210.field2599 = -1;
      field485 = 0;
      class210.field2595 = false;
      class47.field584 = var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1268726361"
   )
   public static void method553() {
      try {
         if(class210.field2594 == 1) {
            int var0 = class210.field2596.method3855();
            if(var0 > 0 && class210.field2596.method3861()) {
               var0 -= class47.field584;
               if(var0 < 0) {
                  var0 = 0;
               }

               class210.field2596.method3854(var0);
               return;
            }

            class210.field2596.method3969();
            class210.field2596.method3858();
            if(class184.field2516 != null) {
               class210.field2594 = 2;
            } else {
               class210.field2594 = 0;
            }

            class210.field2601 = null;
            class43.field539 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class210.field2596.method3969();
         class210.field2594 = 0;
         class210.field2601 = null;
         class43.field539 = null;
         class184.field2516 = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgi;IB)Z",
      garbageValue = "83"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class94.field1415[++class94.field1408 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field853 = var1;
            if(class94.field1404[var1] != null) {
               var6.decodeApperance(class94.field1404[var1]);
            }

            var6.orientation = class94.field1410[var1];
            var6.interacting = class94.field1412[var1];
            var7 = class94.field1409[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field1189[0] = class94.field1411[var1];
            var6.field852 = (byte)var8;
            var6.method1191((var9 << 13) + var3 - ItemLayer.baseX, (var10 << 13) + var4 - ItemLayer.baseY);
            var6.field854 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class94.field1409[var1];
         class94.field1409[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class94.field1409[var1];
            var7 = (var11 >> 28) + var4 & 3;
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

            class94.field1409[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class94.field1409[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class94.field1409[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }
}
