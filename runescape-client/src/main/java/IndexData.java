import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("p")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("indexStore")
   IndexFile indexStore;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("referenceStore")
   IndexFile referenceStore;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -233744701
   )
   @Export("index")
   int index;
   @ObfuscatedName("h")
   volatile boolean field3332;
   @ObfuscatedName("d")
   boolean field3331;
   @ObfuscatedName("v")
   @Export("validArchives")
   volatile boolean[] validArchives;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 707407901
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 809778315
   )
   @Export("indexReferenceVersion")
   int indexReferenceVersion;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -2060623263
   )
   int field3340;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfv;Lfv;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3332 = false;
      this.field3331 = false;
      this.field3340 = -1;
      this.indexStore = var1;
      this.referenceStore = var2;
      this.index = var3;
      this.field3331 = var6;
      NPC.method1634(this, this.index);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1772940672"
   )
   void vmethod4373(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      FileRequest var5 = (FileRequest)class249.NetCache_pendingWrites.get(var3);
      if(var5 != null) {
         class249.NetCache_pendingWritesQueue.setHead(var5);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-325248462"
   )
   int archiveLoadPercent(int var1) {
      return super.archives[var1] != null?100:(this.validArchives[var1]?100:WidgetNode.method1048(this.index, var1));
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1028855805"
   )
   void loadArchive(int var1) {
      if(this.indexStore != null && this.validArchives != null && this.validArchives[var1]) {
         class36.method497(var1, this.indexStore, this);
      } else {
         OwnWorldComparator.requestNetFile(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1500600288"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3332) {
         return 100;
      } else if(super.archives != null) {
         return 99;
      } else {
         int var1 = WidgetNode.method1048(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-225269972"
   )
   @Export("setInformation")
   void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.indexReferenceVersion = var2;
      if(this.referenceStore != null) {
         class36.method497(this.index, this.referenceStore, this);
      } else {
         OwnWorldComparator.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "2044597898"
   )
   @Export("write")
   void write(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3332) {
            throw new RuntimeException();
         }

         if(this.referenceStore != null) {
            int var13 = this.index;
            IndexFile var6 = this.referenceStore;
            FileSystem var7 = new FileSystem();
            var7.type = 0;
            var7.hash = (long)var13;
            var7.field3299 = var2;
            var7.index = var6;
            Deque var8 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
               IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var7);
            }

            Object var21 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
               if(IndexStoreActionHandler.field3328 == 0) {
                  IndexStoreActionHandler.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
                  IndexStoreActionHandler.IndexStoreActionHandler_thread.setDaemon(true);
                  IndexStoreActionHandler.IndexStoreActionHandler_thread.start();
                  IndexStoreActionHandler.IndexStoreActionHandler_thread.setPriority(5);
               }

               IndexStoreActionHandler.field3328 = 600;
            }
         }

         this.setIndexReference(var2);
         this.loadAllLocal();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.indexStore != null) {
            IndexFile var5 = this.indexStore;
            FileSystem var18 = new FileSystem();
            var18.type = 0;
            var18.hash = (long)var1;
            var18.field3299 = var2;
            var18.index = var5;
            Deque var19 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
               IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var18);
            }

            Object var20 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
               if(IndexStoreActionHandler.field3328 == 0) {
                  IndexStoreActionHandler.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
                  IndexStoreActionHandler.IndexStoreActionHandler_thread.setDaemon(true);
                  IndexStoreActionHandler.IndexStoreActionHandler_thread.start();
                  IndexStoreActionHandler.IndexStoreActionHandler_thread.setPriority(5);
               }

               IndexStoreActionHandler.field3328 = 600;
            }

            this.validArchives[var1] = true;
         }

         if(var4) {
            super.archives[var1] = class27.byteArrayToObject(var2, false);
         }
      }

   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(Lfv;I[BZS)V",
      garbageValue = "2111"
   )
   @Export("load")
   public void load(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.referenceStore) {
         if(this.field3332) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            OwnWorldComparator.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         Buffer var9 = new Buffer(class218.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var5 != this.crcValue || var8 != this.indexReferenceVersion) {
            OwnWorldComparator.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.setIndexReference(var3);
         this.loadAllLocal();
      } else {
         if(!var4 && var2 == this.field3340) {
            this.field3332 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.validArchives[var2] = false;
            if(this.field3331 || var4) {
               OwnWorldComparator.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.validArchives[var2] = false;
            if(this.field3331 || var4) {
               OwnWorldComparator.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.validArchives[var2] = true;
         if(var4) {
            super.archives[var2] = class27.byteArrayToObject(var3, false);
         }
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1902010383"
   )
   @Export("loadAllLocal")
   void loadAllLocal() {
      this.validArchives = new boolean[super.archives.length];

      int var1;
      for(var1 = 0; var1 < this.validArchives.length; ++var1) {
         this.validArchives[var1] = false;
      }

      if(this.indexStore == null) {
         this.field3332 = true;
      } else {
         this.field3340 = -1;

         for(var1 = 0; var1 < this.validArchives.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               class185.method3513(var1, this.indexStore, this);
               this.field3340 = var1;
            }
         }

         if(this.field3340 == -1) {
            this.field3332 = true;
         }

      }
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-999342725"
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Lje;",
      garbageValue = "1111184639"
   )
   public static class265 method4378(int var0) {
      class265 var1 = (class265)class265.field3499.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class265.field3497.getConfigData(32, var0);
         var1 = new class265();
         if(var2 != null) {
            var1.method4623(new Buffer(var2));
         }

         class265.field3499.put(var1, (long)var0);
         return var1;
      }
   }
}
