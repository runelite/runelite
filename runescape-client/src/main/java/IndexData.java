import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("ao")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("fo")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("indexStore")
   IndexFile indexStore;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("referenceStore")
   IndexFile referenceStore;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1961368667
   )
   @Export("index")
   int index;
   @ObfuscatedName("n")
   volatile boolean field3347;
   @ObfuscatedName("i")
   boolean field3352;
   @ObfuscatedName("av")
   @Export("validArchives")
   volatile boolean[] validArchives;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -594260555
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1891478811
   )
   @Export("indexReferenceVersion")
   int indexReferenceVersion;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1243334895
   )
   int field3354;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfn;Lfn;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3347 = false;
      this.field3352 = false;
      this.field3354 = -1;
      this.indexStore = var1;
      this.referenceStore = var2;
      this.index = var3;
      this.field3352 = var6;
      Signlink.method3246(this, this.index);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-32"
   )
   void vmethod4647(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      FileRequest var5 = (FileRequest)class258.NetCache_pendingWrites.get(var3);
      if(var5 != null) {
         class258.NetCache_pendingWritesQueue.setHead(var5);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "23"
   )
   int archiveLoadPercent(int var1) {
      return super.archives[var1] != null?100:(this.validArchives[var1]?100:class228.method4346(this.index, var1));
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1712167604"
   )
   void loadArchive(int var1) {
      if(this.indexStore != null && this.validArchives != null && this.validArchives[var1]) {
         IndexFile var2 = this.indexStore;
         byte[] var4 = null;
         Deque var5 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            for(FileSystem var6 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getFront(); var6 != null; var6 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getNext()) {
               if((long)var1 == var6.hash && var2 == var6.index && var6.type == 0) {
                  var4 = var6.field3316;
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
         DynamicObject.requestNetFile(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2009892268"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3347) {
         return 100;
      } else if(super.archives != null) {
         return 99;
      } else {
         int var1 = class228.method4346(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "42"
   )
   @Export("setInformation")
   public void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.indexReferenceVersion = var2;
      if(this.referenceStore != null) {
         int var3 = this.index;
         IndexFile var4 = this.referenceStore;
         byte[] var6 = null;
         Deque var7 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            for(FileSystem var8 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getFront(); var8 != null; var8 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getNext()) {
               if((long)var3 == var8.hash && var4 == var8.index && var8.type == 0) {
                  var6 = var8.field3316;
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
         DynamicObject.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "-99425370"
   )
   @Export("write")
   public void write(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3347) {
            throw new RuntimeException();
         }

         if(this.referenceStore != null) {
            Enum.method4913(this.index, var2, this.referenceStore);
         }

         this.setIndexReference(var2);
         this.loadAllLocal();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.indexStore != null) {
            Enum.method4913(var1, var2, this.indexStore);
            this.validArchives[var1] = true;
         }

         if(var4) {
            super.archives[var1] = DState.byteArrayToObject(var2, false);
         }
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(Lfn;I[BZI)V",
      garbageValue = "-1334794179"
   )
   @Export("load")
   void load(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.referenceStore) {
         if(this.field3347) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            DynamicObject.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         if(var5 != this.crcValue) {
            DynamicObject.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         Buffer var9 = new Buffer(CacheFile.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var8 != this.indexReferenceVersion) {
            DynamicObject.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.setIndexReference(var3);
         this.loadAllLocal();
      } else {
         if(!var4 && var2 == this.field3354) {
            this.field3347 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.validArchives[var2] = false;
            if(this.field3352 || var4) {
               DynamicObject.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.validArchives[var2] = false;
            if(this.field3352 || var4) {
               DynamicObject.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.validArchives[var2] = true;
         if(var4) {
            super.archives[var2] = DState.byteArrayToObject(var3, false);
         }
      }

   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-75"
   )
   @Export("loadAllLocal")
   void loadAllLocal() {
      this.validArchives = new boolean[super.archives.length];

      int var1;
      for(var1 = 0; var1 < this.validArchives.length; ++var1) {
         this.validArchives[var1] = false;
      }

      if(this.indexStore == null) {
         this.field3347 = true;
      } else {
         this.field3354 = -1;

         for(var1 = 0; var1 < this.validArchives.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               Widget.method4467(var1, this.indexStore, this);
               this.field3354 = var1;
            }
         }

         if(this.field3354 == -1) {
            this.field3347 = true;
         }

      }
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1982951006"
   )
   public boolean method4687(int var1) {
      return this.validArchives[var1];
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2046095311"
   )
   public boolean method4655(int var1) {
      return this.getChilds(var1) != null;
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "92410646"
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
