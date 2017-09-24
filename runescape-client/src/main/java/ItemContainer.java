import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1780243173
   )
   static int field787;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 650740399
   )
   static int field793;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -149462991
   )
   static int field792;
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 403773231
   )
   static int field790;
   @ObfuscatedName("j")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("a")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfn;II)Z",
      garbageValue = "-1899239185"
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
            class95.field1510[++class95.field1514 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field923 = var1;
            if(class95.field1506[var1] != null) {
               var6.decodeApperance(class95.field1506[var1]);
            }

            var6.orientation = class95.field1512[var1];
            var6.interacting = class95.field1508[var1];
            var7 = class95.field1502[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field1286[0] = class95.field1513[var1];
            var6.field910 = (byte)var8;
            var6.method1153((var9 << 13) + var3 - class149.baseX, (var10 << 13) + var4 - class67.baseY);
            var6.field909 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class95.field1502[var1];
         class95.field1502[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class95.field1502[var1];
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

            class95.field1502[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class95.field1502[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class95.field1502[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }
}
