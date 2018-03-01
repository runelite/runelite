import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("ac")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   @Export("indexStore")
   IndexFile indexStore;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   @Export("referenceStore")
   IndexFile referenceStore;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 34781631
   )
   @Export("index")
   int index;
   @ObfuscatedName("a")
   volatile boolean field3398;
   @ObfuscatedName("ak")
   boolean field3396;
   @ObfuscatedName("ap")
   @Export("validArchives")
   volatile boolean[] validArchives;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1278301457
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1946263445
   )
   @Export("indexReferenceVersion")
   int indexReferenceVersion;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 751927069
   )
   int field3399;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfp;Lfp;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3398 = false;
      this.field3396 = false;
      this.field3399 = -1;
      this.indexStore = var1;
      this.referenceStore = var2;
      this.index = var3;
      this.field3396 = var6;
      GameObject.method3166(this, this.index);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-983"
   )
   void vmethod4775(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      FileRequest var5 = (FileRequest)class264.NetCache_pendingWrites.get(var3);
      if(var5 != null) {
         class264.NetCache_pendingWritesQueue.setHead(var5);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-65"
   )
   int archiveLoadPercent(int var1) {
      if(super.archives[var1] != null) {
         return 100;
      } else if(this.validArchives[var1]) {
         return 100;
      } else {
         int var3 = this.index;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(TotalQuantityComparator.currentRequest != null && var4 == TotalQuantityComparator.currentRequest.hash) {
            var2 = class264.NetCache_responseArchiveBuffer.offset * 99 / (class264.NetCache_responseArchiveBuffer.payload.length - TotalQuantityComparator.currentRequest.padding) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-339853985"
   )
   void loadArchive(int var1) {
      if(this.indexStore != null && this.validArchives != null && this.validArchives[var1]) {
         IndexFile var2 = this.indexStore;
         byte[] var4 = null;
         Deque var5 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            for(FileSystem var6 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getFront(); var6 != null; var6 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getNext()) {
               if((long)var1 == var6.hash && var2 == var6.index && var6.type == 0) {
                  var4 = var6.field3359;
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
         class229.requestNetFile(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1754497338"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3398) {
         return 100;
      } else if(super.archives != null) {
         return 99;
      } else {
         int var2 = this.index;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(TotalQuantityComparator.currentRequest != null && TotalQuantityComparator.currentRequest.hash == var3) {
            var1 = class264.NetCache_responseArchiveBuffer.offset * 99 / (class264.NetCache_responseArchiveBuffer.payload.length - TotalQuantityComparator.currentRequest.padding) + 1;
         } else {
            var1 = 0;
         }

         int var5 = var1;
         if(var1 >= 100) {
            var5 = 99;
         }

         return var5;
      }
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-537898472"
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
               if(var8.hash == (long)var3 && var4 == var8.index && var8.type == 0) {
                  var6 = var8.field3359;
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
         class229.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "83"
   )
   @Export("write")
   public void write(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3398) {
            throw new RuntimeException();
         }

         if(this.referenceStore != null) {
            int var5 = this.index;
            IndexFile var6 = this.referenceStore;
            FileSystem var7 = new FileSystem();
            var7.type = 0;
            var7.hash = (long)var5;
            var7.field3359 = var2;
            var7.index = var6;
            Deque var8 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
               IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var7);
            }

            class71.method1136();
         }

         this.setIndexReference(var2);
         this.loadAllLocal();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.indexStore != null) {
            IndexFile var11 = this.indexStore;
            FileSystem var14 = new FileSystem();
            var14.type = 0;
            var14.hash = (long)var1;
            var14.field3359 = var2;
            var14.index = var11;
            Deque var15 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
               IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var14);
            }

            class71.method1136();
            this.validArchives[var1] = true;
         }

         if(var4) {
            super.archives[var1] = ClientPacket.byteArrayToObject(var2, false);
         }
      }

   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(Lfp;I[BZI)V",
      garbageValue = "-665860697"
   )
   @Export("load")
   void load(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.referenceStore) {
         if(this.field3398) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class229.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         if(var5 != this.crcValue) {
            class229.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         Buffer var9 = new Buffer(ScriptEvent.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var8 != this.indexReferenceVersion) {
            class229.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.setIndexReference(var3);
         this.loadAllLocal();
      } else {
         if(!var4 && var2 == this.field3399) {
            this.field3398 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.validArchives[var2] = false;
            if(this.field3396 || var4) {
               class229.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.validArchives[var2] = false;
            if(this.field3396 || var4) {
               class229.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.validArchives[var2] = true;
         if(var4) {
            super.archives[var2] = ClientPacket.byteArrayToObject(var3, false);
         }
      }

   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-34"
   )
   @Export("loadAllLocal")
   void loadAllLocal() {
      this.validArchives = new boolean[super.archives.length];

      int var1;
      for(var1 = 0; var1 < this.validArchives.length; ++var1) {
         this.validArchives[var1] = false;
      }

      if(this.indexStore == null) {
         this.field3398 = true;
      } else {
         this.field3399 = -1;

         for(var1 = 0; var1 < this.validArchives.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               IndexFile var2 = this.indexStore;
               FileSystem var4 = new FileSystem();
               var4.type = 1;
               var4.hash = (long)var1;
               var4.index = var2;
               var4.data = this;
               Deque var5 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
               synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
                  IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var4);
               }

               class71.method1136();
               this.field3399 = var1;
            }
         }

         if(this.field3399 == -1) {
            this.field3398 = true;
         }

      }
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "217151411"
   )
   public boolean method4782(int var1) {
      return this.validArchives[var1];
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2127614422"
   )
   public boolean method4783(int var1) {
      return this.getChilds(var1) != null;
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "984596248"
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
