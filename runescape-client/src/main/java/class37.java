import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class37 {
   @ObfuscatedName("s")
   static byte[][][] field487;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("listFetcher")
   static UrlRequest listFetcher;
   @ObfuscatedName("cu")
   public static char field491;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkm;I)V",
      garbageValue = "967539692"
   )
   static final void method495(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < FrameMap.field1958.length; ++var2) {
         FrameMap.field1958[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         FrameMap.field1958[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class72.field833[var5] = (FrameMap.field1958[var5 + 128] + FrameMap.field1958[var5 - 128] + FrameMap.field1958[var5 + 1] + FrameMap.field1958[var5 - 1]) / 4;
            }
         }

         int[] var8 = FrameMap.field1958;
         FrameMap.field1958 = class72.field833;
         class72.field833 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  FrameMap.field1958[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-227789490"
   )
   static final void method497(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class60.field724 || GrandExchangeEvents.field263 != var1) {
         class60.field724 = var0;
         GrandExchangeEvents.field263 = var1;
         ClanMember.setGameState(25);
         GrandExchangeEvents.drawStatusBox("Loading - please wait.", true);
         int var3 = class175.baseX;
         int var4 = GraphicsObject.baseY;
         class175.baseX = (var0 - 6) * 8;
         GraphicsObject.baseY = (var1 - 6) * 8;
         int var5 = class175.baseX - var3;
         int var6 = GraphicsObject.baseY - var4;
         var3 = class175.baseX;
         var4 = GraphicsObject.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < 32768; ++var7) {
            NPC var8 = Client.cachedNPCs[var7];
            if(var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.cachedPlayers[var7];
            if(var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if(var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if(var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var13 = var20; var18 != var13; var13 += var22) {
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var5 + var13;
               int var16 = var6 + var14;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if(var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItemDeque[var17][var13][var14] = Client.groundItemDeque[var17][var15][var16];
                  } else {
                     Client.groundItemDeque[var17][var13][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.getFront(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.getNext()) {
            var19.x -= var5;
            var19.y -= var6;
            if(var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.unlink();
            }
         }

         if(Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.field1025 = 0;
         Client.field1101 = false;
         Client.field1082 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-1643523835"
   )
   @Export("prependIndices")
   static final String[] prependIndices(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
