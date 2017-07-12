import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class112 {
   @ObfuscatedName("w")
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("i")
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("t")
   XHashTable field1682;
   @ObfuscatedName("a")
   XHashTable field1680;

   public class112(IndexDataBase var1, IndexDataBase var2) {
      this.field1680 = new XHashTable(256);
      this.field1682 = new XHashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass107;",
      garbageValue = "522796808"
   )
   class107 method2086(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class107 var7 = (class107)this.field1682.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class106 var8 = (class106)this.field1680.get(var5);
         if(var8 == null) {
            var8 = class106.method1964(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1680.put(var8, var5);
         }

         var7 = var8.method1965(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1682.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass107;",
      garbageValue = "-437293535"
   )
   class107 method2088(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class107 var7 = (class107)this.field1682.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1942();
            this.field1682.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1630.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass107;",
      garbageValue = "1270483995"
   )
   public class107 method2085(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2086(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2086(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass107;",
      garbageValue = "1916602576"
   )
   public class107 method2087(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2088(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2088(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-35"
   )
   static void method2096() {
      if(class17.field317) {
         class92.field1461 = null;
         class92.field1475 = null;
         class266.field3669 = null;
         class92.field1451 = null;
         class3.field19 = null;
         class83.logoSprite = null;
         WorldMapType2.titlemuteSprite = null;
         class5.field40 = null;
         class224.field2855 = null;
         KitDefinition.field3367 = null;
         class48.field651 = null;
         AbstractByteBuffer.field2422 = null;
         class61.field768 = null;
         class91.field1445 = null;
         class41.field586 = null;
         class244.field3326 = null;
         class83.field1370 = null;
         WorldMapType3.field375 = null;
         GraphicsObject.field1382 = null;
         class14.field293 = null;
         class12.field270 = null;
         Ignore.field864 = null;
         class174.method3343(2);
         class170.sendConInfo(true);
         class17.field317 = false;
      }
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "76048059"
   )
   static final void method2097() {
      Client.secretPacketBuffer1.putOpcode(131);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3533(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3538()) {
         if(var0.owner == 0 || var0.owner == 3) {
            class95.method1780(var0, true);
         }
      }

      if(Client.field1091 != null) {
         class88.method1714(Client.field1091);
         Client.field1091 = null;
      }

   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "196913818"
   )
   static final void method2095(int var0, int var1, boolean var2) {
      if(!var2 || var0 != World.field1321 || FileOnDisk.field1777 != var1) {
         World.field1321 = var0;
         FileOnDisk.field1777 = var1;
         TextureProvider.setGameState(25);
         class2.drawStatusBox("Loading - please wait.", true);
         int var3 = KeyFocusListener.baseX;
         int var4 = class266.baseY;
         KeyFocusListener.baseX = (var0 - 6) * 8;
         class266.baseY = (var1 - 6) * 8;
         int var5 = KeyFocusListener.baseX - var3;
         int var6 = class266.baseY - var4;
         var3 = KeyFocusListener.baseX;
         var4 = class266.baseY;

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

         Client.field1181 = 0;
         Client.field1173 = false;
         Client.field1154 = -1;
         Client.graphicsObjectDeque.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].reset();
         }

      }
   }
}
