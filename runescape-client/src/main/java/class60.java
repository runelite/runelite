import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public final class class60 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;B)V",
      garbageValue = "-95"
   )
   static final void method965(PacketBuffer var0) {
      var0.method3291();
      int var1 = Client.localInteractingIndex;
      Player var2 = class20.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field890 = var1;
      int var3 = var0.method3290(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class19.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method1072() << 6);
      var2.pathY[0] = var6 - class21.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method1072() << 6);
      Player.plane = var2.field884 = var4;
      if(class96.field1498[var1] != null) {
         var2.method1091(class96.field1498[var1]);
      }

      class96.field1487 = 0;
      class96.field1491[++class96.field1487 - 1] = var1;
      class96.field1489[var1] = 0;
      class96.field1499 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method3290(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class96.field1490[var7] = var11 + (var10 << 14) + (var9 << 28);
            class96.field1497[var7] = 0;
            class96.field1492[var7] = -1;
            class96.field1495[++class96.field1499 - 1] = var7;
            class96.field1489[var7] = 0;
         }
      }

      var0.method3292();
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(LWidget;B)LWidget;",
      garbageValue = "103"
   )
   static Widget method969(Widget var0) {
      int var1 = class15.method106(class15.method92(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = class223.method3959(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}
