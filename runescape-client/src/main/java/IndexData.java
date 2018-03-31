import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("al")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   @Export("indexStore")
   IndexFile indexStore;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   @Export("referenceStore")
   IndexFile referenceStore;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -354438501
   )
   @Export("index")
   int index;
   @ObfuscatedName("s")
   volatile boolean field3396;
   @ObfuscatedName("ac")
   boolean field3397;
   @ObfuscatedName("ap")
   @Export("validArchives")
   volatile boolean[] validArchives;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 541984573
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -2034816883
   )
   @Export("indexReferenceVersion")
   int indexReferenceVersion;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1163552289
   )
   int field3402;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfa;Lfa;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3396 = false;
      this.field3397 = false;
      this.field3402 = -1;
      this.indexStore = var1;
      this.referenceStore = var2;
      this.index = var3;
      this.field3397 = var6;
      AbstractSoundSystem.method2241(this, this.index);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "448107719"
   )
   void vmethod4661(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      FileRequest var5 = (FileRequest)class264.NetCache_pendingWrites.get(var3);
      if(var5 != null) {
         class264.NetCache_pendingWritesQueue.setHead(var5);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-6"
   )
   int archiveLoadPercent(int var1) {
      return super.archives[var1] != null?100:(this.validArchives[var1]?100:ScriptVarType.method29(this.index, var1));
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1509535835"
   )
   void loadArchive(int var1) {
      if(this.indexStore != null && this.validArchives != null && this.validArchives[var1]) {
         PlayerComposition.method4436(var1, this.indexStore, this);
      } else {
         Frames.requestNetFile(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3396) {
         return 100;
      } else if(super.archives != null) {
         return 99;
      } else {
         int var1 = ScriptVarType.method29(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1641020422"
   )
   @Export("setInformation")
   void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.indexReferenceVersion = var2;
      if(this.referenceStore != null) {
         PlayerComposition.method4436(this.index, this.referenceStore, this);
      } else {
         Frames.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "213768222"
   )
   @Export("write")
   void write(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3396) {
            throw new RuntimeException();
         }

         if(this.referenceStore != null) {
            Widget.method4455(this.index, var2, this.referenceStore);
         }

         this.setIndexReference(var2);
         this.loadAllLocal();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.indexStore != null) {
            Widget.method4455(var1, var2, this.indexStore);
            this.validArchives[var1] = true;
         }

         if(var4) {
            super.archives[var1] = class61.byteArrayToObject(var2, false);
         }
      }

   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(Lfa;I[BZI)V",
      garbageValue = "641054848"
   )
   @Export("load")
   public void load(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.referenceStore) {
         if(this.field3396) {
            throw new RuntimeException();
         } else if(var3 == null) {
            Frames.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
         } else {
            crc32.reset();
            crc32.update(var3, 0, var3.length);
            var5 = (int)crc32.getValue();
            if(var5 != this.crcValue) {
               Frames.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            } else {
               Buffer var9 = new Buffer(class5.decodeContainer(var3));
               int var7 = var9.readUnsignedByte();
               if(var7 != 5 && var7 != 6) {
                  throw new RuntimeException(var7 + "," + this.index + "," + var2);
               } else {
                  int var8 = 0;
                  if(var7 >= 6) {
                     var8 = var9.readInt();
                  }

                  if(var8 != this.indexReferenceVersion) {
                     Frames.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
                  } else {
                     this.setIndexReference(var3);
                     this.loadAllLocal();
                  }
               }
            }
         }
      } else {
         if(!var4 && var2 == this.field3402) {
            this.field3396 = true;
         }

         if(var3 != null && var3.length > 2) {
            crc32.reset();
            crc32.update(var3, 0, var3.length - 2);
            var5 = (int)crc32.getValue();
            int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
            if(var5 == super.archiveCrcs[var2] && var6 == super.archiveRevisions[var2]) {
               this.validArchives[var2] = true;
               if(var4) {
                  super.archives[var2] = class61.byteArrayToObject(var3, false);
               }

            } else {
               this.validArchives[var2] = false;
               if(this.field3397 || var4) {
                  Frames.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
               }

            }
         } else {
            this.validArchives[var2] = false;
            if(this.field3397 || var4) {
               Frames.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

         }
      }
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "180"
   )
   @Export("loadAllLocal")
   void loadAllLocal() {
      this.validArchives = new boolean[super.archives.length];

      int var1;
      for(var1 = 0; var1 < this.validArchives.length; ++var1) {
         this.validArchives[var1] = false;
      }

      if(this.indexStore == null) {
         this.field3396 = true;
      } else {
         this.field3402 = -1;

         for(var1 = 0; var1 < this.validArchives.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               class228.method4120(var1, this.indexStore, this);
               this.field3402 = var1;
            }
         }

         if(this.field3402 == -1) {
            this.field3396 = true;
         }

      }
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1121534647"
   )
   public boolean method4675(int var1) {
      return this.validArchives[var1];
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public boolean method4690(int var1) {
      return this.getChilds(var1) != null;
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-5165968"
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

   @ObfuscatedName("c")
   public static double method4664(double var0) {
      return Math.exp(-var0 * var0 / 2.0D) / Math.sqrt(6.283185307179586D);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-877036130"
   )
   static final void method4694() {
      class47.method743("You can\'t add yourself to your own ignore list");
   }
}
