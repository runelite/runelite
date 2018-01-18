import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("q")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("gx")
   @ObfuscatedGetter(
      intValue = 791486435
   )
   static int field3340;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("indexStore")
   IndexFile indexStore;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("referenceStore")
   IndexFile referenceStore;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1609893325
   )
   @Export("index")
   int index;
   @ObfuscatedName("g")
   volatile boolean field3336;
   @ObfuscatedName("c")
   boolean field3334;
   @ObfuscatedName("k")
   @Export("validArchives")
   volatile boolean[] validArchives;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -212414243
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 113742419
   )
   @Export("indexReferenceVersion")
   int indexReferenceVersion;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1812688073
   )
   int field3342;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfv;Lfv;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3336 = false;
      this.field3334 = false;
      this.field3342 = -1;
      this.indexStore = var1;
      this.referenceStore = var2;
      this.index = var3;
      this.field3334 = var6;
      FrameMap.method2743(this, this.index);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "34"
   )
   void vmethod4415(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      FileRequest var5 = (FileRequest)class249.NetCache_pendingWrites.get(var3);
      if(var5 != null) {
         class249.NetCache_pendingWritesQueue.setHead(var5);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "643031408"
   )
   int archiveLoadPercent(int var1) {
      return super.archives[var1] != null?100:(this.validArchives[var1]?100:class22.method163(this.index, var1));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "43"
   )
   void loadArchive(int var1) {
      if(this.indexStore != null && this.validArchives != null && this.validArchives[var1]) {
         GameSocket.method3180(var1, this.indexStore, this);
      } else {
         class56.requestNetFile(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "40"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3336) {
         return 100;
      } else if(super.archives != null) {
         return 99;
      } else {
         int var1 = class22.method163(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1895764078"
   )
   @Export("setInformation")
   public void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.indexReferenceVersion = var2;
      if(this.referenceStore != null) {
         GameSocket.method3180(this.index, this.referenceStore, this);
      } else {
         class56.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "22"
   )
   @Export("write")
   public void write(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3336) {
            throw new RuntimeException();
         }

         if(this.referenceStore != null) {
            ClientPacket.method3245(this.index, var2, this.referenceStore);
         }

         this.setIndexReference(var2);
         this.loadAllLocal();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.indexStore != null) {
            ClientPacket.method3245(var1, var2, this.indexStore);
            this.validArchives[var1] = true;
         }

         if(var4) {
            super.archives[var1] = ClanMember.byteArrayToObject(var2, false);
         }
      }

   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(Lfv;I[BZI)V",
      garbageValue = "-1932977974"
   )
   @Export("load")
   void load(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.referenceStore) {
         if(this.field3336) {
            throw new RuntimeException();
         } else if(var3 == null) {
            class56.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
         } else {
            crc32.reset();
            crc32.update(var3, 0, var3.length);
            var5 = (int)crc32.getValue();
            if(var5 != this.crcValue) {
               class56.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            } else {
               Buffer var9 = new Buffer(CacheFile.decodeContainer(var3));
               int var7 = var9.readUnsignedByte();
               if(var7 != 5 && var7 != 6) {
                  throw new RuntimeException(var7 + "," + this.index + "," + var2);
               } else {
                  int var8 = 0;
                  if(var7 >= 6) {
                     var8 = var9.readInt();
                  }

                  if(var8 != this.indexReferenceVersion) {
                     class56.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
                  } else {
                     this.setIndexReference(var3);
                     this.loadAllLocal();
                  }
               }
            }
         }
      } else {
         if(!var4 && var2 == this.field3342) {
            this.field3336 = true;
         }

         if(var3 != null && var3.length > 2) {
            crc32.reset();
            crc32.update(var3, 0, var3.length - 2);
            var5 = (int)crc32.getValue();
            int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
            if(var5 == super.archiveCrcs[var2] && var6 == super.archiveRevisions[var2]) {
               this.validArchives[var2] = true;
               if(var4) {
                  super.archives[var2] = ClanMember.byteArrayToObject(var3, false);
               }

            } else {
               this.validArchives[var2] = false;
               if(this.field3334 || var4) {
                  class56.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
               }

            }
         } else {
            this.validArchives[var2] = false;
            if(this.field3334 || var4) {
               class56.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

         }
      }
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   @Export("loadAllLocal")
   void loadAllLocal() {
      this.validArchives = new boolean[super.archives.length];

      int var1;
      for(var1 = 0; var1 < this.validArchives.length; ++var1) {
         this.validArchives[var1] = false;
      }

      if(this.indexStore == null) {
         this.field3336 = true;
      } else {
         this.field3342 = -1;

         for(var1 = 0; var1 < this.validArchives.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               class163.method3168(var1, this.indexStore, this);
               this.field3342 = var1;
            }
         }

         if(this.field3342 == -1) {
            this.field3336 = true;
         }

      }
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-159741000"
   )
   @Export("loadPercent")
   public int loadPercent() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.archives.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.archiveLoadPercent(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }
}
