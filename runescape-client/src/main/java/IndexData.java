import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("ad")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("indexStore")
   IndexFile indexStore;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("referenceStore")
   IndexFile referenceStore;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -373496579
   )
   @Export("index")
   int index;
   @ObfuscatedName("o")
   volatile boolean field3201;
   @ObfuscatedName("ai")
   boolean field3200;
   @ObfuscatedName("at")
   @Export("validArchives")
   volatile boolean[] validArchives;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 2062650897
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1819171657
   )
   @Export("indexReferenceVersion")
   int indexReferenceVersion;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -293628809
   )
   int field3207;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lff;Lff;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3201 = false;
      this.field3200 = false;
      this.field3207 = -1;
      this.indexStore = var1;
      this.referenceStore = var2;
      this.index = var3;
      this.field3200 = var6;
      Signlink.method3242(this, this.index);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   void vmethod4741(int var1) {
      class33.method608(this.index, var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-45"
   )
   int archiveLoadPercent(int var1) {
      return super.archives[var1] != null?100:(this.validArchives[var1]?100:class8.method91(this.index, var1));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1716933918"
   )
   void loadArchive(int var1) {
      if(this.indexStore != null && this.validArchives != null && this.validArchives[var1]) {
         IndexFile var2 = this.indexStore;
         byte[] var4 = null;
         Deque var5 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            for(FileSystem var6 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getFront(); var6 != null; var6 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getNext()) {
               if((long)var1 == var6.hash && var2 == var6.index && var6.type == 0) {
                  var4 = var6.field3165;
                  break;
               }
            }
         }

         if(var4 != null) {
            this.load(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.read(var1);
            this.load(var2, var1, var9, true);
         }
      } else {
         class37.requestNetFile(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-13"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3201) {
         return 100;
      } else if(super.archives != null) {
         return 99;
      } else {
         int var1 = class8.method91(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-452481515"
   )
   @Export("setInformation")
   void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.indexReferenceVersion = var2;
      if(this.referenceStore != null) {
         int var3 = this.index;
         IndexFile var4 = this.referenceStore;
         byte[] var6 = null;
         Deque var7 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            for(FileSystem var8 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getFront(); var8 != null; var8 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getNext()) {
               if(var8.hash == (long)var3 && var4 == var8.index && var8.type == 0) {
                  var6 = var8.field3165;
                  break;
               }
            }
         }

         if(var6 != null) {
            this.load(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.read(var3);
            this.load(var4, var3, var11, true);
         }
      } else {
         class37.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "1656818327"
   )
   @Export("write")
   void write(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3201) {
            throw new RuntimeException();
         }

         if(this.referenceStore != null) {
            Item.method1906(this.index, var2, this.referenceStore);
         }

         this.setIndexReference(var2);
         this.loadAllLocal();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.indexStore != null) {
            Item.method1906(var1, var2, this.indexStore);
            this.validArchives[var1] = true;
         }

         if(var4) {
            super.archives[var1] = SceneTilePaint.byteArrayToObject(var2, false);
         }
      }

   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(Lff;I[BZB)V",
      garbageValue = "24"
   )
   @Export("load")
   public void load(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.referenceStore) {
         if(this.field3201) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class37.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         if(var5 != this.crcValue) {
            class37.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         Buffer var9 = new Buffer(GZipDecompressor.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var8 != this.indexReferenceVersion) {
            class37.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.setIndexReference(var3);
         this.loadAllLocal();
      } else {
         if(!var4 && var2 == this.field3207) {
            this.field3201 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.validArchives[var2] = false;
            if(this.field3200 || var4) {
               class37.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.validArchives[var2] = false;
            if(this.field3200 || var4) {
               class37.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.validArchives[var2] = true;
         if(var4) {
            super.archives[var2] = SceneTilePaint.byteArrayToObject(var3, false);
         }
      }

   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1849563714"
   )
   @Export("loadAllLocal")
   void loadAllLocal() {
      this.validArchives = new boolean[super.archives.length];

      int var1;
      for(var1 = 0; var1 < this.validArchives.length; ++var1) {
         this.validArchives[var1] = false;
      }

      if(this.indexStore == null) {
         this.field3201 = true;
      } else {
         this.field3207 = -1;

         for(var1 = 0; var1 < this.validArchives.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               FaceNormal.method3082(var1, this.indexStore, this);
               this.field3207 = var1;
            }
         }

         if(this.field3207 == -1) {
            this.field3201 = true;
         }

      }
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public boolean method4744(int var1) {
      return this.validArchives[var1];
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1101254991"
   )
   public boolean method4745(int var1) {
      return this.getChilds(var1) != null;
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "2"
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
