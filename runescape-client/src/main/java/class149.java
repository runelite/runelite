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

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class149(int var3, int var4) {
      this.field2220 = var3;
      this.field2216 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1204543302"
   )
   public int rsOrdinal() {
      return this.field2216;
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
            class96.field1529[++class96.field1525 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field914 = var1;
            if(class96.field1520[var1] != null) {
               var6.decodeApperance(class96.field1520[var1]);
            }

            var6.orientation = class96.field1526[var1];
            var6.interacting = class96.field1527[var1];
            var7 = class96.field1522[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field1297[0] = class96.field1519[var1];
            var6.field911 = (byte)var8;
            var6.method1176((var9 << 13) + var3 - KeyFocusListener.baseX, (var10 << 13) + var4 - class266.baseY);
            var6.field913 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class96.field1522[var1];
         class96.field1522[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class96.field1522[var1];
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

            class96.field1522[var1] = (var8 << 14) + (var7 << 28) + var9;
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class96.field1522[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class96.field1522[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }
}
