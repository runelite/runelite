import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class67 extends class197 {
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 429230285
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      longValue = -3762431455276198581L
   )
   static long field835;
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -406372501
   )
   static int field845;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -337406573
   )
   int field843;
   @ObfuscatedName("j")
   String field842;
   @ObfuscatedName("a")
   short field838;

   class67(String var1, int var2) {
      this.field843 = (int)(class45.currentTimeMs() / 1000L);
      this.field842 = var1;
      this.field838 = (short)var2;
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(IIZB)V",
      garbageValue = "8"
   )
   static final void method1119(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class27.field407 || class15.field303 != var1) {
         class27.field407 = var0;
         class15.field303 = var1;
         WorldMapType2.setGameState(25);
         ScriptState.drawStatusBox("Loading - please wait.", true);
         int var3 = class149.baseX;
         int var4 = baseY;
         class149.baseX = (var0 - 6) * 8;
         baseY = (var1 - 6) * 8;
         int var5 = class149.baseX - var3;
         int var6 = baseY - var4;
         var3 = class149.baseX;
         var4 = baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < '耀'; ++var7) {
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
         for(int var13 = var20; var13 != var18; var13 += var22) {
            for(var14 = var10; var11 != var14; var14 += var12) {
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

         Client.field1172 = 0;
         Client.field1178 = false;
         Client.field1159 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }
}
