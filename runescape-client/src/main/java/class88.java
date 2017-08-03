import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public class class88 {
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "Lbb;"
   )
   static class71 field1364;
   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "[Ljw;"
   )
   static IndexedSprite[] field1359;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lim;IIB)[Ljw;",
      garbageValue = "-100"
   )
   static IndexedSprite[] method1716(IndexDataBase var0, int var1, int var2) {
      if(!WallObject.method2899(var0, var1, var2)) {
         return null;
      } else {
         IndexedSprite[] var4 = new IndexedSprite[class286.field3781];

         for(int var5 = 0; var5 < class286.field3781; ++var5) {
            IndexedSprite var6 = var4[var5] = new IndexedSprite();
            var6.width = class286.field3779;
            var6.originalHeight = class286.field3780;
            var6.offsetX = class270.field3666[var5];
            var6.offsetY = class286.offsetsY[var5];
            var6.originalWidth = class286.field3778[var5];
            var6.height = class286.field3782[var5];
            var6.palette = class286.field3783;
            var6.pixels = class177.spritePixels[var5];
         }

         class229.method4093();
         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfy;IB)Z",
      garbageValue = "1"
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
            class96.field1478[++class96.field1477 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field865 = var1;
            if(class96.field1469[var1] != null) {
               var6.decodeApperance(class96.field1469[var1]);
            }

            var6.orientation = class96.field1475[var1];
            var6.interacting = class96.field1466[var1];
            var7 = class96.field1476[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field1246[0] = class96.field1467[var1];
            var6.field881 = (byte)var8;
            var6.method1169((var9 << 13) + var3 - class33.baseX, (var10 << 13) + var4 - class17.baseY);
            var6.field879 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class96.field1476[var1];
         class96.field1476[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class96.field1476[var1];
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

            class96.field1476[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class96.field1476[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class96.field1476[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }
}
