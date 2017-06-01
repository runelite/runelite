import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class23 {
   @ObfuscatedName("ad")
   static int[] field344;
   @ObfuscatedName("dh")
   @Export("indexScripts")
   static IndexData indexScripts;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;I)V",
      garbageValue = "1494548046"
   )
   static final void method157(PacketBuffer var0) {
      var0.method3389();
      int var1 = Client.localInteractingIndex;
      Player var2 = World.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field912 = var1;
      int var3 = var0.method3397(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class41.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method1131() << 6);
      var2.pathY[0] = var6 - WorldMapType3.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method1131() << 6);
      FaceNormal.plane = var2.field911 = var4;
      if(class96.field1506[var1] != null) {
         var2.method1116(class96.field1506[var1]);
      }

      class96.field1507 = 0;
      class96.field1508[++class96.field1507 - 1] = var1;
      class96.field1504[var1] = 0;
      class96.field1502 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method3397(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class96.field1511[var7] = var11 + (var10 << 14) + (var9 << 28);
            class96.field1512[var7] = 0;
            class96.field1513[var7] = -1;
            class96.field1515[++class96.field1502 - 1] = var7;
            class96.field1504[var7] = 0;
         }
      }

      var0.method3391();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZZB)I",
      garbageValue = "-81"
   )
   public static int method158(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class238.field3255 + class238.field3259;
      return var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Lclass241;",
      garbageValue = "1580265805"
   )
   public static class241 method159(int var0) {
      class241 var1 = (class241)class241.field3284.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class241.field3282.getConfigData(16, var0);
         var1 = new class241();
         if(var2 != null) {
            var1.method4291(new Buffer(var2));
         }

         class241.field3284.put(var1, (long)var0);
         return var1;
      }
   }
}
