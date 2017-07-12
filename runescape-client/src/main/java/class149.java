import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public enum class149 implements RSEnum {
   @ObfuscatedName("i")
   field2215(2, 0),
   @ObfuscatedName("w")
   field2214(0, 1),
   @ObfuscatedName("a")
   field2213(3, 2),
   @ObfuscatedName("t")
   field2219(1, 3);

   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1993583939
   )
   final int field2216;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1233895591
   )
   public final int field2220;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1204543302"
   )
   public int rsOrdinal() {
      return this.field2216;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   private class149(int var3, int var4) {
      this.field2220 = var3;
      this.field2216 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;II)Z",
      garbageValue = "1560290044"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var11 = var0.getBits(1) == 1;
         if(var11) {
            class96.field1529[++class96.field1525 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var12 = Client.cachedPlayers[var1] = new Player();
            var12.field914 = var1;
            if(class96.field1520[var1] != null) {
               var12.decodeApperance(class96.field1520[var1]);
            }

            var12.orientation = class96.field1526[var1];
            var12.interacting = class96.field1527[var1];
            var5 = class96.field1522[var1];
            var6 = var5 >> 28;
            var7 = var5 >> 14 & 255;
            var8 = var5 & 255;
            var12.field1297[0] = class96.field1519[var1];
            var12.field911 = (byte)var6;
            var12.method1176(var3 + (var7 << 13) - KeyFocusListener.baseX, (var8 << 13) + var4 - class266.baseY);
            var12.field913 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class96.field1522[var1];
         class96.field1522[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var9;
         int var10;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var9 = var3 & 7;
            var10 = class96.field1522[var1];
            var5 = (var10 >> 28) + var4 & 3;
            var6 = var10 >> 14 & 255;
            var7 = var10 & 255;
            if(var9 == 0) {
               --var6;
               --var7;
            }

            if(var9 == 1) {
               --var7;
            }

            if(var9 == 2) {
               ++var6;
               --var7;
            }

            if(var9 == 3) {
               --var6;
            }

            if(var9 == 4) {
               ++var6;
            }

            if(var9 == 5) {
               --var6;
               ++var7;
            }

            if(var9 == 6) {
               ++var7;
            }

            if(var9 == 7) {
               ++var6;
               ++var7;
            }

            class96.field1522[var1] = (var5 << 28) + (var6 << 14) + var7;
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var9 = var3 >> 8 & 255;
            var10 = var3 & 255;
            var5 = class96.field1522[var1];
            var6 = var4 + (var5 >> 28) & 3;
            var7 = var9 + (var5 >> 14) & 255;
            var8 = var5 + var10 & 255;
            class96.field1522[var1] = var8 + (var7 << 14) + (var6 << 28);
            return false;
         }
      }
   }
}
