import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class229 {
   @ObfuscatedName("p")
   public static final boolean[] field2908;
   @ObfuscatedName("i")
   public static int[] field2909;
   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   @Export("headIconsHint")
   static SpritePixels[] headIconsHint;

   static {
      field2908 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2909 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2909[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgi;I)V",
      garbageValue = "721014972"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = class48.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field853 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - ItemLayer.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - ItemLayer.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      Ignore.plane = var2.field852 = var4;
      if(class94.field1404[var1] != null) {
         var2.decodeApperance(class94.field1404[var1]);
      }

      class94.playerIndexesCount = 0;
      class94.playerIndices[++class94.playerIndexesCount - 1] = var1;
      class94.field1407[var1] = 0;
      class94.field1403 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class94.field1409[var7] = (var10 << 14) + var11 + (var9 << 28);
            class94.field1410[var7] = 0;
            class94.field1412[var7] = -1;
            class94.field1402[++class94.field1403 - 1] = var7;
            class94.field1407[var7] = 0;
         }
      }

      var0.byteAccess();
   }
}
