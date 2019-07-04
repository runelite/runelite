import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("IndexCache")
public class IndexCache extends AbstractIndexCache {
   @ObfuscatedName("aj")
   @Export("IndexCache_crc")
   static CRC32 IndexCache_crc;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("indexStore")
   IndexStore indexStore;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("referenceStore")
   IndexStore referenceStore;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1579549759
   )
   @Export("index")
   int index;
   @ObfuscatedName("v")
   volatile boolean field403;
   @ObfuscatedName("ag")
   boolean field404;
   @ObfuscatedName("aq")
   @Export("validArchives")
   volatile boolean[] validArchives;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1472870917
   )
   @Export("indexReferenceCrc")
   int indexReferenceCrc;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -785528219
   )
   @Export("indexReferenceVersion")
   int indexReferenceVersion;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1884661133
   )
   int field405;

   @ObfuscatedSignature(
      signature = "(Lff;Lff;IZZZ)V"
   )
   public IndexCache(IndexStore var1, IndexStore var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field403 = false;
      this.field404 = false;
      this.field405 = -1;
      this.indexStore = var1;
      this.referenceStore = var2;
      this.index = var3;
      this.field404 = var6;
      int var7 = this.index;
      if (Players.NetCache_reference != null) {
         Players.NetCache_reference.index = var7 * 8 + 5;
         int var8 = Players.NetCache_reference.readInt();
         int var9 = Players.NetCache_reference.readInt();
         this.loadIndexReference(var8, var9);
      } else {
         PacketBuffer.requestNetFile((IndexCache)null, 255, 255, 0, (byte)0, true);
         NetCache.NetCache_indexCaches[var7] = this;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2102142648"
   )
   void vmethod129(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      NetFileRequest var5 = (NetFileRequest)NetCache.NetCache_pendingWrites.get(var3);
      if (var5 != null) {
         NetCache.NetCache_pendingWritesQueue.addLast(var5);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1809769865"
   )
   @Export("archiveLoadPercent")
   int archiveLoadPercent(int var1) {
      return super.archives[var1] != null ? 100 : (this.validArchives[var1] ? 100 : class54.method1086(this.index, var1));
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1829145107"
   )
   @Export("loadArchive")
   void loadArchive(int var1) {
      if (this.indexStore != null && this.validArchives != null && this.validArchives[var1]) {
         IndexStore var2 = this.indexStore;
         byte[] var3 = null;
         NodeDeque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            for (IndexStoreAction var6 = (IndexStoreAction)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.last(); var6 != null; var6 = (IndexStoreAction)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.previous()) {
               if (var6.key == (long)var1 && var2 == var6.indexStore && var6.type == 0) {
                  var3 = var6.data;
                  break;
               }
            }
         }

         if (var3 != null) {
            this.load(var2, var1, var3, true);
         } else {
            byte[] var5 = var2.read(var1);
            this.load(var2, var1, var5, true);
         }
      } else {
         PacketBuffer.requestNetFile(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1750279412"
   )
   public boolean method130() {
      return this.field403;
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1671499504"
   )
   public int method131() {
      if (this.field403) {
         return 100;
      } else if (super.archives != null) {
         return 99;
      } else {
         int var1 = class54.method1086(255, this.index);
         if (var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1621053520"
   )
   @Export("loadIndexReference")
   public void loadIndexReference(int var1, int var2) {
      this.indexReferenceCrc = var1;
      this.indexReferenceVersion = var2;
      if (this.referenceStore != null) {
         int var3 = this.index;
         IndexStore var4 = this.referenceStore;
         byte[] var5 = null;
         NodeDeque var6 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            for (IndexStoreAction var8 = (IndexStoreAction)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.last(); var8 != null; var8 = (IndexStoreAction)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.previous()) {
               if (var8.key == (long)var3 && var4 == var8.indexStore && var8.type == 0) {
                  var5 = var8.data;
                  break;
               }
            }
         }

         if (var5 != null) {
            this.load(var4, var3, var5, true);
         } else {
            byte[] var7 = var4.read(var3);
            this.load(var4, var3, var7, true);
         }
      } else {
         PacketBuffer.requestNetFile(this, 255, this.index, this.indexReferenceCrc, (byte)0, true);
      }

   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "24"
   )
   @Export("write")
   public void write(int var1, byte[] var2, boolean var3, boolean var4) {
      if (var3) {
         if (this.field403) {
            throw new RuntimeException();
         }

         if (this.referenceStore != null) {
            Widget.method4499(this.index, var2, this.referenceStore);
         }

         this.setIndexReference(var2);
         this.loadAllLocal();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveVersions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveVersions[var1];
         if (this.indexStore != null) {
            Widget.method4499(var1, var2, this.indexStore);
            this.validArchives[var1] = true;
         }

         if (var4) {
            super.archives[var1] = Projectile.byteArrayToObject(var2, false);
         }
      }

   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(Lff;I[BZI)V",
      garbageValue = "-2045340856"
   )
   @Export("load")
   void load(IndexStore var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if (var1 == this.referenceStore) {
         if (this.field403) {
            throw new RuntimeException();
         } else if (var3 == null) {
            PacketBuffer.requestNetFile(this, 255, this.index, this.indexReferenceCrc, (byte)0, true);
         } else {
            IndexCache_crc.reset();
            IndexCache_crc.update(var3, 0, var3.length);
            var5 = (int)IndexCache_crc.getValue();
            if (var5 != this.indexReferenceCrc) {
               PacketBuffer.requestNetFile(this, 255, this.index, this.indexReferenceCrc, (byte)0, true);
            } else {
               Buffer var9 = new Buffer(Strings.decompressBytes(var3));
               int var7 = var9.readUnsignedByte();
               if (var7 != 5 && var7 != 6) {
                  throw new RuntimeException(var7 + "," + this.index + "," + var2);
               } else {
                  int var8 = 0;
                  if (var7 >= 6) {
                     var8 = var9.readInt();
                  }

                  if (var8 != this.indexReferenceVersion) {
                     PacketBuffer.requestNetFile(this, 255, this.index, this.indexReferenceCrc, (byte)0, true);
                  } else {
                     this.setIndexReference(var3);
                     this.loadAllLocal();
                  }
               }
            }
         }
      } else {
         if (!var4 && var2 == this.field405) {
            this.field403 = true;
         }

         if (var3 != null && var3.length > 2) {
            IndexCache_crc.reset();
            IndexCache_crc.update(var3, 0, var3.length - 2);
            var5 = (int)IndexCache_crc.getValue();
            int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
            if (var5 == super.archiveCrcs[var2] && var6 == super.archiveVersions[var2]) {
               this.validArchives[var2] = true;
               if (var4) {
                  super.archives[var2] = Projectile.byteArrayToObject(var3, false);
               }

            } else {
               this.validArchives[var2] = false;
               if (this.field404 || var4) {
                  PacketBuffer.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
               }

            }
         } else {
            this.validArchives[var2] = false;
            if (this.field404 || var4) {
               PacketBuffer.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

         }
      }
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1357733042"
   )
   @Export("loadAllLocal")
   void loadAllLocal() {
      this.validArchives = new boolean[super.archives.length];

      int var1;
      for (var1 = 0; var1 < this.validArchives.length; ++var1) {
         this.validArchives[var1] = false;
      }

      if (this.indexStore == null) {
         this.field403 = true;
      } else {
         this.field405 = -1;

         for (var1 = 0; var1 < this.validArchives.length; ++var1) {
            if (super.recordCounts[var1] > 0) {
               NPC.method2009(var1, this.indexStore, this);
               this.field405 = var1;
            }
         }

         if (this.field405 == -1) {
            this.field403 = true;
         }
      }

   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public boolean method132(int var1) {
      return this.validArchives[var1];
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1419648188"
   )
   public boolean method133(int var1) {
      return this.method3(var1) != null;
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1809381772"
   )
   @Export("loadPercent")
   public int loadPercent() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for (var3 = 0; var3 < super.archives.length; ++var3) {
         if (super.recordCounts[var3] > 0) {
            var1 += 100;
            var2 += this.archiveLoadPercent(var3);
         }
      }

      if (var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-34"
   )
   static final void method4703(int var0) {
      class12.method159();

      for (ObjectSound var1 = (ObjectSound)ObjectSound.objectSounds.last(); var1 != null; var1 = (ObjectSound)ObjectSound.objectSounds.previous()) {
         if (var1.obj != null) {
            var1.set();
         }
      }

      int var4 = SecureRandomCallable.method1140(var0).type;
      if (var4 != 0) {
         int var2 = Varps.Varps_main[var0];
         if (var4 == 1) {
            if (var2 == 1) {
               Rasterizer3D.Rasterizer3D_setBrightness(0.9D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.9D);
            }

            if (var2 == 2) {
               Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.8D);
            }

            if (var2 == 3) {
               Rasterizer3D.Rasterizer3D_setBrightness(0.7D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.7D);
            }

            if (var2 == 4) {
               Rasterizer3D.Rasterizer3D_setBrightness(0.6D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.6D);
            }

            ObjectDefinition.method5041();
         }

         if (var4 == 3) {
            short var3 = 0;
            if (var2 == 0) {
               var3 = 255;
            }

            if (var2 == 1) {
               var3 = 192;
            }

            if (var2 == 2) {
               var3 = 128;
            }

            if (var2 == 3) {
               var3 = 64;
            }

            if (var2 == 4) {
               var3 = 0;
            }

            if (var3 != Client.field128) {
               if (Client.field128 == 0 && Client.field112 != -1) {
                  Login.method2076(UserComparator3.indexCache6, Client.field112, 0, var3, false);
                  Client.field107 = false;
               } else if (var3 == 0) {
                  class214.midiPcmStream.clear();
                  class214.field1129 = 1;
                  class214.field1130 = null;
                  Client.field107 = false;
               } else {
                  class203.method4008(var3);
               }

               Client.field128 = var3;
            }
         }

         if (var4 == 4) {
            if (var2 == 0) {
               Client.soundEffectVolume = 127;
            }

            if (var2 == 1) {
               Client.soundEffectVolume = 96;
            }

            if (var2 == 2) {
               Client.soundEffectVolume = 64;
            }

            if (var2 == 3) {
               Client.soundEffectVolume = 32;
            }

            if (var2 == 4) {
               Client.soundEffectVolume = 0;
            }
         }

         if (var4 == 5) {
            Client.field215 = var2;
         }

         if (var4 == 6) {
            Client.chatEffects = var2;
         }

         if (var4 == 9) {
            Client.field136 = var2;
         }

         if (var4 == 10) {
            if (var2 == 0) {
               Client.field115 = 127;
            }

            if (var2 == 1) {
               Client.field115 = 96;
            }

            if (var2 == 2) {
               Client.field115 = 64;
            }

            if (var2 == 3) {
               Client.field115 = 32;
            }

            if (var2 == 4) {
               Client.field115 = 0;
            }
         }

         if (var4 == 17) {
            Client.followerIndex = var2 & 65535;
         }

         if (var4 == 18) {
            Client.playerAttackOption = (AttackOption)ScriptFrame.findEnumerated(ClientPacket.method3665(), var2);
            if (Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if (var4 == 19) {
            if (var2 == -1) {
               Client.combatTargetPlayerIndex = -1;
            } else {
               Client.combatTargetPlayerIndex = var2 & 2047;
            }
         }

         if (var4 == 22) {
            Client.npcAttackOption = (AttackOption)ScriptFrame.findEnumerated(ClientPacket.method3665(), var2);
            if (Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }
      }

   }

   static {
      IndexCache_crc = new CRC32();
   }
}
