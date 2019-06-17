import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
public class class236 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lhx;II)Z",
      garbageValue = "278945262"
   )
   @Export("updateExternalPlayer")
   static boolean updateExternalPlayer(PacketBuffer var0, int var1) {
      int var2 = var0.readBits(2);
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(var2 == 0) {
         if(var0.readBits(1) != 0) {
            updateExternalPlayer(var0, var1);
         }

         var3 = var0.readBits(13);
         var4 = var0.readBits(13);
         boolean var11 = var0.readBits(1) == 1;
         if(var11) {
            Players.__cq_i[++Players.__cq_n - 1] = var1;
         }

         if(Client.players[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var12 = Client.players[var1] = new Player();
            var12.index = var1;
            if(Players.__cq_o[var1] != null) {
               var12.read(Players.__cq_o[var1]);
            }

            var12.orientation = Players.Players_orientations[var1];
            var12.targetIndex = Players.Players_targetIndices[var1];
            var5 = Players.Players_regions[var1];
            var6 = var5 >> 28;
            var7 = var5 >> 14 & 255;
            var8 = var5 & 255;
            var12.pathTraversed[0] = Players.__cq_w[var1];
            var12.plane = (byte)var6;
            var12.resetPath((var7 << 13) + var3 - class50.baseX, (var8 << 13) + var4 - GraphicsObject.baseY);
            var12.__ag = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.readBits(2);
         var4 = Players.Players_regions[var1];
         Players.Players_regions[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var9;
         int var10;
         if(var2 == 2) {
            var3 = var0.readBits(5);
            var4 = var3 >> 3;
            var9 = var3 & 7;
            var10 = Players.Players_regions[var1];
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

            Players.Players_regions[var1] = (var6 << 14) + var7 + (var5 << 28);
            return false;
         } else {
            var3 = var0.readBits(18);
            var4 = var3 >> 16;
            var9 = var3 >> 8 & 255;
            var10 = var3 & 255;
            var5 = Players.Players_regions[var1];
            var6 = (var5 >> 28) + var4 & 3;
            var7 = var9 + (var5 >> 14) & 255;
            var8 = var5 + var10 & 255;
            Players.Players_regions[var1] = (var7 << 14) + var8 + (var6 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-616244124"
   )
   static final int method4537(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
