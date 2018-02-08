import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("al")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   @Export("indexStore")
   IndexFile indexStore;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfu;"
   )
   @Export("referenceStore")
   IndexFile referenceStore;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1883412161
   )
   @Export("index")
   int index;
   @ObfuscatedName("v")
   volatile boolean field3329;
   @ObfuscatedName("a")
   boolean field3332;
   @ObfuscatedName("ad")
   @Export("validArchives")
   volatile boolean[] validArchives;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 454768055
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -332809763
   )
   @Export("indexReferenceVersion")
   int indexReferenceVersion;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -564349501
   )
   int field3331;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfu;Lfu;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3329 = false;
      this.field3332 = false;
      this.field3331 = -1;
      this.indexStore = var1;
      this.referenceStore = var2;
      this.index = var3;
      this.field3332 = var6;
      class213.method4109(this, this.index);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1798413221"
   )
   void vmethod4600(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      FileRequest var5 = (FileRequest)class249.NetCache_pendingWrites.get(var3);
      if(var5 != null) {
         class249.NetCache_pendingWritesQueue.setHead(var5);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1725016829"
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
         if(VertexNormal.currentRequest != null && VertexNormal.currentRequest.hash == var4) {
            var2 = class249.NetCache_responseArchiveBuffer.offset * 99 / (class249.NetCache_responseArchiveBuffer.payload.length - VertexNormal.currentRequest.padding) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-739658899"
   )
   void loadArchive(int var1) {
      if(this.indexStore != null && this.validArchives != null && this.validArchives[var1]) {
         IndexFile var2 = this.indexStore;
         byte[] var4 = null;
         Deque var5 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
         synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            for(FileSystem var6 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getFront(); var6 != null; var6 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getNext()) {
               if(var6.hash == (long)var1 && var2 == var6.index && var6.type == 0) {
                  var4 = var6.field3291;
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
         Varbit.requestNetFile(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1438292508"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3329) {
         return 100;
      } else if(super.archives != null) {
         return 99;
      } else {
         int var2 = this.index;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(VertexNormal.currentRequest != null && VertexNormal.currentRequest.hash == var3) {
            var1 = class249.NetCache_responseArchiveBuffer.offset * 99 / (class249.NetCache_responseArchiveBuffer.payload.length - VertexNormal.currentRequest.padding) + 1;
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

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1076270143"
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
                  var6 = var8.field3291;
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
         Varbit.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "83"
   )
   @Export("write")
   void write(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3329) {
            throw new RuntimeException();
         }

         if(this.referenceStore != null) {
            int var5 = this.index;
            IndexFile var6 = this.referenceStore;
            FileSystem var7 = new FileSystem();
            var7.type = 0;
            var7.hash = (long)var5;
            var7.field3291 = var2;
            var7.index = var6;
            Deque var8 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
               IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var7);
            }

            class214.method4129();
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
            var14.field3291 = var2;
            var14.index = var11;
            Deque var15 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
               IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var14);
            }

            class214.method4129();
            this.validArchives[var1] = true;
         }

         if(var4) {
            super.archives[var1] = KitDefinition.byteArrayToObject(var2, false);
         }
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(Lfu;I[BZI)V",
      garbageValue = "-630882273"
   )
   @Export("load")
   void load(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.referenceStore) {
         if(this.field3329) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            Varbit.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         if(var5 != this.crcValue) {
            Varbit.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         Buffer var9 = new Buffer(Renderable.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var8 != this.indexReferenceVersion) {
            Varbit.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.setIndexReference(var3);
         this.loadAllLocal();
      } else {
         if(!var4 && var2 == this.field3331) {
            this.field3329 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.validArchives[var2] = false;
            if(this.field3332 || var4) {
               Varbit.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.validArchives[var2] = false;
            if(this.field3332 || var4) {
               Varbit.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.validArchives[var2] = true;
         if(var4) {
            super.archives[var2] = KitDefinition.byteArrayToObject(var3, false);
         }
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "102873518"
   )
   @Export("loadAllLocal")
   void loadAllLocal() {
      this.validArchives = new boolean[super.archives.length];

      int var1;
      for(var1 = 0; var1 < this.validArchives.length; ++var1) {
         this.validArchives[var1] = false;
      }

      if(this.indexStore == null) {
         this.field3329 = true;
      } else {
         this.field3331 = -1;

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

               class214.method4129();
               this.field3331 = var1;
            }
         }

         if(this.field3331 == -1) {
            this.field3329 = true;
         }

      }
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1049427500"
   )
   public boolean method4607(int var1) {
      return this.validArchives[var1];
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1531927107"
   )
   public boolean method4608(int var1) {
      return this.getChilds(var1) != null;
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Liq;",
      garbageValue = "-4"
   )
   public static class255 method4624(int var0) {
      class255 var1 = (class255)class255.field3401.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class255.field3402.getConfigData(15, var0);
         var1 = new class255();
         if(var2 != null) {
            var1.method4727(new Buffer(var2));
         }

         class255.field3401.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgz;ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-44"
   )
   static String method4604(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }
}
