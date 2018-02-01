import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("ap")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("indexStore")
   IndexFile indexStore;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   @Export("referenceStore")
   IndexFile referenceStore;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1114948877
   )
   @Export("index")
   int index;
   @ObfuscatedName("b")
   volatile boolean field3319;
   @ObfuscatedName("c")
   boolean field3314;
   @ObfuscatedName("aa")
   @Export("validArchives")
   volatile boolean[] validArchives;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -301893827
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1748467243
   )
   @Export("indexReferenceVersion")
   int indexReferenceVersion;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1965301359
   )
   int field3317;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfx;Lfx;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3319 = false;
      this.field3314 = false;
      this.field3317 = -1;
      this.indexStore = var1;
      this.referenceStore = var2;
      this.index = var3;
      this.field3314 = var6;
      int var8 = this.index;
      if(class87.NetCache_reference != null) {
         class87.NetCache_reference.offset = var8 * 8 + 5;
         int var9 = class87.NetCache_reference.readInt();
         int var10 = class87.NetCache_reference.readInt();
         this.setInformation(var9, var10);
      } else {
         FileSystem.requestNetFile((IndexData)null, 255, 255, 0, (byte)0, true);
         class249.NetCache_indexCaches[var8] = this;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-3732"
   )
   void vmethod4475(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      FileRequest var5 = (FileRequest)class249.NetCache_pendingWrites.get(var3);
      if(var5 != null) {
         class249.NetCache_pendingWritesQueue.setHead(var5);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2140420115"
   )
   int archiveLoadPercent(int var1) {
      return super.archives[var1] != null?100:(this.validArchives[var1]?100:class289.method5300(this.index, var1));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "651208868"
   )
   void loadArchive(int var1) {
      if(this.indexStore != null && this.validArchives != null && this.validArchives[var1]) {
         class235.method4334(var1, this.indexStore, this);
      } else {
         FileSystem.requestNetFile(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1938799671"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3319) {
         return 100;
      } else if(super.archives != null) {
         return 99;
      } else {
         int var1 = class289.method5300(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   @Export("setInformation")
   void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.indexReferenceVersion = var2;
      if(this.referenceStore != null) {
         class235.method4334(this.index, this.referenceStore, this);
      } else {
         FileSystem.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "-50"
   )
   @Export("write")
   void write(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3319) {
            throw new RuntimeException();
         }

         if(this.referenceStore != null) {
            int var5 = this.index;
            IndexFile var6 = this.referenceStore;
            FileSystem var7 = new FileSystem();
            var7.type = 0;
            var7.hash = (long)var5;
            var7.field3276 = var2;
            var7.index = var6;
            Deque var8 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
               IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var7);
            }

            InvType.method4536();
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
            var14.field3276 = var2;
            var14.index = var11;
            Deque var15 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
               IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var14);
            }

            InvType.method4536();
            this.validArchives[var1] = true;
         }

         if(var4) {
            super.archives[var1] = class173.byteArrayToObject(var2, false);
         }
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(Lfx;I[BZI)V",
      garbageValue = "44150379"
   )
   @Export("load")
   void load(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.referenceStore) {
         if(this.field3319) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            FileSystem.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         if(var5 != this.crcValue) {
            FileSystem.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         Buffer var9 = new Buffer(class278.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var8 != this.indexReferenceVersion) {
            FileSystem.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.setIndexReference(var3);
         this.loadAllLocal();
      } else {
         if(!var4 && var2 == this.field3317) {
            this.field3319 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.validArchives[var2] = false;
            if(this.field3314 || var4) {
               FileSystem.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.validArchives[var2] = false;
            if(this.field3314 || var4) {
               FileSystem.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.validArchives[var2] = true;
         if(var4) {
            super.archives[var2] = class173.byteArrayToObject(var3, false);
         }
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1038599375"
   )
   @Export("loadAllLocal")
   void loadAllLocal() {
      this.validArchives = new boolean[super.archives.length];

      int var1;
      for(var1 = 0; var1 < this.validArchives.length; ++var1) {
         this.validArchives[var1] = false;
      }

      if(this.indexStore == null) {
         this.field3319 = true;
      } else {
         this.field3317 = -1;

         for(var1 = 0; var1 < this.validArchives.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               class240.method4347(var1, this.indexStore, this);
               this.field3317 = var1;
            }
         }

         if(this.field3317 == -1) {
            this.field3319 = true;
         }

      }
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "32767"
   )
   public boolean method4503(int var1) {
      return this.validArchives[var1];
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1273023658"
   )
   public boolean method4482(int var1) {
      return this.getChilds(var1) != null;
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "197344347"
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([I[IB)V",
      garbageValue = "-33"
   )
   public static void method4513(int[] var0, int[] var1) {
      if(var0 != null && var1 != null) {
         class185.field2496 = var0;
         class185.field2500 = new int[var0.length];
         class219.field2675 = new byte[var0.length][][];

         for(int var2 = 0; var2 < class185.field2496.length; ++var2) {
            class219.field2675[var2] = new byte[var1[var2]][];
         }

      } else {
         class185.field2496 = null;
         class185.field2500 = null;
         class219.field2675 = null;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgj;II)Ljava/lang/String;",
      garbageValue = "575525085"
   )
   public static String method4484(Buffer var0, int var1) {
      try {
         int var2 = var0.getUSmart();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class288.huffman.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class23.getString(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }
}
