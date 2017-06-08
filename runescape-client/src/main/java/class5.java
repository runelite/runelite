import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
final class class5 implements class0 {
   @ObfuscatedName("p")
   public static IndexDataBase field40;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIIII[LCollisionData;B)V",
      garbageValue = "1"
   )
   static final void method14(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var1 + var7 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var2 + var8 < 103) {
                  var5[var6].flags[var7 + var1][var2 + var8] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               World.method1563(var10, var7, var1 + var8, var9 + var2, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-25"
   )
   public static void method15() {
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "674172993"
   )
   static void method16(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1077 < 50 && Client.field1005 != 0) {
         if(var0.field3615 != null && var1 < var0.field3615.length) {
            int var4 = var0.field3615[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1158[Client.field1077] = var5;
               Client.field1159[Client.field1077] = var6;
               Client.field1049[Client.field1077] = 0;
               Client.field1162[Client.field1077] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1101[Client.field1077] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field1077;
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)LOverlay;",
      garbageValue = "14"
   )
   public static Overlay method17(int var0) {
      Overlay var1 = (Overlay)Overlay.field3596.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.field3598.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.method4697(new Buffer(var2), var0);
         }

         var1.method4696();
         Overlay.field3596.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(ILCoordinates;ZI)V",
      garbageValue = "-1864797929"
   )
   static void method18(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = WorldMapType1.method259().method5272(var0);
      int var4 = class168.localPlayer.field891;
      int var5 = class61.baseX + (class168.localPlayer.x >> 7);
      int var6 = class23.baseY + (class168.localPlayer.y >> 7);
      Coordinates var7 = new Coordinates(var4, var5, var6);
      WorldMapType1.method259().method5232(var3, var7, var1, var2);
   }
}
