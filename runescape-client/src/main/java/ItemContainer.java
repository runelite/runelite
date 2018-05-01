import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("i")
   @Export("floorSaturations")
   static int[] floorSaturations;
   @ObfuscatedName("e")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("b")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([I[II)V",
      garbageValue = "-21165259"
   )
   public static void method1142(int[] var0, int[] var1) {
      if(var0 != null && var1 != null) {
         class195.field2572 = var0;
         class195.field2579 = new int[var0.length];
         MilliTimer.field2156 = new byte[var0.length][][];

         for(int var2 = 0; var2 < class195.field2572.length; ++var2) {
            MilliTimer.field2156[var2] = new byte[var1[var2]][];
         }

      } else {
         class195.field2572 = null;
         class195.field2579 = null;
         MilliTimer.field2156 = null;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;IIB)[Llh;",
      garbageValue = "-66"
   )
   static IndexedSprite[] method1150(IndexDataBase var0, int var1, int var2) {
      return !class326.method5792(var0, var1, var2)?null:ClanMemberManager.method5525();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1612643253"
   )
   public static boolean method1149(int var0) {
      return var0 >= WorldMapDecorationType.field2987.rsOrdinal && var0 <= WorldMapDecorationType.field2976.rsOrdinal || var0 == WorldMapDecorationType.field2980.rsOrdinal;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1076950675"
   )
   static final void method1147(int var0) {
      short var1 = 256;
      class90.field1360 += var0 * 128;
      int var2;
      if(class90.field1360 > class199.field2604.length) {
         class90.field1360 -= class199.field2604.length;
         var2 = (int)(Math.random() * 12.0D);
         CombatInfoListHolder.method1931(class90.runeSprites[var2]);
      }

      var2 = 0;
      int var3 = var0 * 128;
      int var4 = (var1 - var0) * 128;

      int var5;
      int var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = MouseRecorder.field789[var3 + var2] - var0 * class199.field2604[var2 + class90.field1360 & class199.field2604.length - 1] / 6;
         if(var6 < 0) {
            var6 = 0;
         }

         MouseRecorder.field789[var2++] = var6;
      }

      int var7;
      int var8;
      for(var5 = var1 - var0; var5 < var1; ++var5) {
         var6 = var5 * 128;

         for(var7 = 0; var7 < 128; ++var7) {
            var8 = (int)(Math.random() * 100.0D);
            if(var8 < 50 && var7 > 10 && var7 < 118) {
               MouseRecorder.field789[var6 + var7] = 255;
            } else {
               MouseRecorder.field789[var6 + var7] = 0;
            }
         }
      }

      if(class90.field1344 > 0) {
         class90.field1344 -= var0 * 4;
      }

      if(class90.field1371 > 0) {
         class90.field1371 -= var0 * 4;
      }

      if(class90.field1344 == 0 && class90.field1371 == 0) {
         var5 = (int)(Math.random() * (double)(2000 / var0));
         if(var5 == 0) {
            class90.field1344 = 1024;
         }

         if(var5 == 1) {
            class90.field1371 = 1024;
         }
      }

      for(var5 = 0; var5 < var1 - var0; ++var5) {
         class90.field1365[var5] = class90.field1365[var0 + var5];
      }

      for(var5 = var1 - var0; var5 < var1; ++var5) {
         class90.field1365[var5] = (int)(Math.sin((double)class90.field1349 / 14.0D) * 16.0D + Math.sin((double)class90.field1349 / 15.0D) * 14.0D + Math.sin((double)class90.field1349 / 16.0D) * 12.0D);
         ++class90.field1349;
      }

      class90.field1347 += var0;
      var5 = (var0 + (Client.gameCycle & 1)) / 2;
      if(var5 > 0) {
         for(var6 = 0; var6 < class90.field1347 * 100; ++var6) {
            var7 = (int)(Math.random() * 124.0D) + 2;
            var8 = (int)(Math.random() * 128.0D) + 128;
            MouseRecorder.field789[var7 + (var8 << 7)] = 192;
         }

         class90.field1347 = 0;

         int var9;
         for(var6 = 0; var6 < var1; ++var6) {
            var7 = 0;
            var8 = var6 * 128;

            for(var9 = -var5; var9 < 128; ++var9) {
               if(var9 + var5 < 128) {
                  var7 += MouseRecorder.field789[var9 + var8 + var5];
               }

               if(var9 - (var5 + 1) >= 0) {
                  var7 -= MouseRecorder.field789[var8 + var9 - (var5 + 1)];
               }

               if(var9 >= 0) {
                  WorldMapManager.field559[var8 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }

         for(var6 = 0; var6 < 128; ++var6) {
            var7 = 0;

            for(var8 = -var5; var8 < var1; ++var8) {
               var9 = var8 * 128;
               if(var8 + var5 < var1) {
                  var7 += WorldMapManager.field559[var9 + var6 + var5 * 128];
               }

               if(var8 - (var5 + 1) >= 0) {
                  var7 -= WorldMapManager.field559[var6 + var9 - (var5 + 1) * 128];
               }

               if(var8 >= 0) {
                  MouseRecorder.field789[var6 + var9] = var7 / (var5 * 2 + 1);
               }
            }
         }
      }

   }
}
