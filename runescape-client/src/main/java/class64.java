import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public class class64 {
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1463079491
   )
   static int field739;
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   @Export("indexCache15")
   static IndexData indexCache15;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 417188171
   )
   static int field742;
   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   final IndexData field732;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1322851079
   )
   final int field741;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -959065029
   )
   int field734;

   @ObfuscatedSignature(
      signature = "(Lju;Ljava/lang/String;)V"
   )
   class64(IndexData var1, String var2) {
      this.field734 = 0;
      this.field732 = var1;
      this.field741 = var1.size();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2104682684"
   )
   boolean method1129() {
      this.field734 = 0;

      for(int var1 = 0; var1 < this.field741; ++var1) {
         if(!this.field732.method4714(var1) || this.field732.method4685(var1)) {
            ++this.field734;
         }
      }

      return this.field734 >= this.field741;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-518691397"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class95.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class95.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class95.messages.put(var5, (long)var5.id);
      class95.field1421.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjc;Ljava/lang/String;Ljava/lang/String;IZB)V",
      garbageValue = "-98"
   )
   public static void method1133(int var0, IndexDataBase var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.getFile(var2);
      int var7 = var1.getChild(var6, var3);
      NPC.method1903(var0, var1, var6, var7, var4, var5);
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "711063577"
   )
   static final void method1131(int var0, int var1, boolean var2) {
      if(!var2 || var0 != class49.field581 || PacketNode.field2476 != var1) {
         class49.field581 = var0;
         PacketNode.field2476 = var1;
         class20.setGameState(25);
         class21.method166("Loading - please wait.", true);
         int var3 = class38.baseX;
         int var4 = PlayerComposition.baseY;
         class38.baseX = (var0 - 6) * 8;
         PlayerComposition.baseY = (var1 - 6) * 8;
         int var5 = class38.baseX - var3;
         int var6 = PlayerComposition.baseY - var4;
         var3 = class38.baseX;
         var4 = PlayerComposition.baseY;

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
               int var15 = var13 + var5;
               int var16 = var14 + var6;

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

         Client.queuedSoundEffectCount = 0;
         Client.field851 = false;
         Varcs.cameraX -= var5 << 7;
         BoundingBox3D.cameraY -= var6 << 7;
         WorldMapDecoration.field415 -= var5 << 7;
         class196.field2569 -= var6 << 7;
         Client.field1071 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }
}
