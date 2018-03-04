import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public enum class27 implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field404(0, (byte)0),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field400(1, (byte)1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field401(3, (byte)2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lap;"
   )
   field399(2, (byte)3);

   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1733657607
   )
   final int field406;
   @ObfuscatedName("y")
   final byte field403;

   class27(int var3, byte var4) {
      this.field406 = var3;
      this.field403 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "846888120"
   )
   public int rsOrdinal() {
      return this.field403;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-938653123"
   )
   public static boolean method221(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1176643479"
   )
   static void method224() {
      ItemContainer.itemContainers = new HashTable(32);
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "938754353"
   )
   static final void method222(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method5232()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1193 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field947[var4][var5] == Client.field1108) {
                     continue;
                  }

                  Client.field947[var4][var5] = Client.field1108;
               }

               if(!var2.composition.field3718) {
                  var3 -= Integer.MIN_VALUE;
               }

               var2.field1143 = Client.gameCycle;
               class86.region.method3026(class36.plane, var2.x, var2.y, class35.getTileHeight(var2.field1193 * 64 - 64 + var2.x, var2.field1193 * 64 - 64 + var2.y, class36.plane), var2.field1193 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1141);
            }
         }
      }

   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method223() {
      if(OwnWorldComparator.field852 != null) {
         Client.field1116 = Client.gameCycle;
         OwnWorldComparator.field852.method4825();

         for(int var0 = 0; var0 < Client.cachedPlayers.length; ++var0) {
            if(Client.cachedPlayers[var0] != null) {
               OwnWorldComparator.field852.method4824((Client.cachedPlayers[var0].x >> 7) + WorldMapType1.baseX, (Client.cachedPlayers[var0].y >> 7) + Enum.baseY);
            }
         }
      }

   }
}
