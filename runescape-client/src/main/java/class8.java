import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public final class class8 extends class9 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1790159263
   )
   final int field226;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1515806897
   )
   final int field225;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1653551707
   )
   final int field227;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1968136129
   )
   final int field228;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -643490179
   )
   final int field229;

   class8(int var1, int var2, int var3, int var4, int var5) {
      this.field226 = var1;
      this.field225 = var2;
      this.field227 = var3;
      this.field228 = var4;
      this.field229 = var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-191383716"
   )
   final void vmethod55() {
      Rasterizer2D.drawRectangle(this.field226 + Rasterizer2D.draw_region_x, this.field225 + Rasterizer2D.drawingAreaTop, this.field227 - this.field226, this.field228 - this.field225, this.field229);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;Lij;I)V",
      garbageValue = "201422913"
   )
   public static void method45(IndexDataBase var0, IndexDataBase var1) {
      NPCComposition.field3610 = var0;
      NPCComposition.field3601 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-623915476"
   )
   static void method43() {
      class96.chatLineMap.clear();
      class96.field1425.clear();
      class96.field1424.method3713();
      class96.field1422 = 0;
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "242773020"
   )
   static final void method44(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class36.field469 || class31.field411 != var1) {
         class36.field469 = var0;
         class31.field411 = var1;
         class2.setGameState(25);
         IndexFile.drawStatusBox("Loading - please wait.", true);
         int var3 = class13.baseX;
         int var4 = ClanMember.baseY;
         class13.baseX = (var0 - 6) * 8;
         ClanMember.baseY = (var1 - 6) * 8;
         int var5 = class13.baseX - var3;
         int var6 = ClanMember.baseY - var4;
         var3 = class13.baseX;
         var4 = ClanMember.baseY;

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
            for(var14 = var10; var11 != var14; var14 += var12) {
               int var15 = var13 + var5;
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

         Client.field1031 = 0;
         Client.field1094 = false;
         Client.field1081 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-567277075"
   )
   static void method38(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class259.field3447; ++var4) {
         ItemComposition var5 = class139.getItemDefinition(var4);
         if((!var1 || var5.field3589) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class60.field696 = -1;
               ChatLineBuffer.field1454 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      ChatLineBuffer.field1454 = var2;
      WorldMapType1.field407 = 0;
      class60.field696 = var3;
      String[] var8 = new String[class60.field696];

      for(int var9 = 0; var9 < class60.field696; ++var9) {
         var8[var9] = class139.getItemDefinition(var2[var9]).name;
      }

      short[] var10 = ChatLineBuffer.field1454;
      class149.method2915(var8, var10, 0, var8.length - 1);
   }
}
