import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("av")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("indexStore")
   IndexFile indexStore;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfn;"
   )
   @Export("referenceStore")
   IndexFile referenceStore;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -368366989
   )
   @Export("index")
   int index;
   @ObfuscatedName("m")
   volatile boolean field3405;
   @ObfuscatedName("ay")
   boolean field3403;
   @ObfuscatedName("ao")
   @Export("validArchives")
   volatile boolean[] validArchives;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1380421487
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1962923667
   )
   @Export("indexReferenceVersion")
   int indexReferenceVersion;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1188699635
   )
   int field3411;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfn;Lfn;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3405 = false;
      this.field3403 = false;
      this.field3411 = -1;
      this.indexStore = var1;
      this.referenceStore = var2;
      this.index = var3;
      this.field3403 = var6;
      int var8 = this.index;
      if(class152.NetCache_reference != null) {
         class152.NetCache_reference.offset = var8 * 8 + 5;
         int var9 = class152.NetCache_reference.readInt();
         int var10 = class152.NetCache_reference.readInt();
         this.setInformation(var9, var10);
      } else {
         Signlink.requestNetFile((IndexData)null, 255, 255, 0, (byte)0, true);
         class264.NetCache_indexCaches[var8] = this;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "593099649"
   )
   void vmethod4681(int var1) {
      Frames.method3056(this.index, var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "80"
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
         if(Signlink.currentRequest != null && Signlink.currentRequest.hash == var4) {
            var2 = CacheFile.NetCache_responseArchiveBuffer.offset * 99 / (CacheFile.NetCache_responseArchiveBuffer.payload.length - Signlink.currentRequest.padding) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1021545065"
   )
   void loadArchive(int var1) {
      if(this.indexStore != null && this.validArchives != null && this.validArchives[var1]) {
         SceneTilePaint.method2863(var1, this.indexStore, this);
      } else {
         Signlink.requestNetFile(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "153885459"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3405) {
         return 100;
      } else if(super.archives != null) {
         return 99;
      } else {
         int var2 = this.index;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(Signlink.currentRequest != null && var3 == Signlink.currentRequest.hash) {
            var1 = CacheFile.NetCache_responseArchiveBuffer.offset * 99 / (CacheFile.NetCache_responseArchiveBuffer.payload.length - Signlink.currentRequest.padding) + 1;
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

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1544568446"
   )
   @Export("setInformation")
   public void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.indexReferenceVersion = var2;
      if(this.referenceStore != null) {
         SceneTilePaint.method2863(this.index, this.referenceStore, this);
      } else {
         Signlink.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "583672441"
   )
   @Export("write")
   public void write(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3405) {
            throw new RuntimeException();
         }

         if(this.referenceStore != null) {
            int var5 = this.index;
            IndexFile var6 = this.referenceStore;
            FileSystem var7 = new FileSystem();
            var7.type = 0;
            var7.hash = (long)var5;
            var7.field3367 = var2;
            var7.index = var6;
            Deque var8 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
               IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var7);
            }

            Object var21 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
               if(IndexStoreActionHandler.field3398 == 0) {
                  IndexStoreActionHandler.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
                  IndexStoreActionHandler.IndexStoreActionHandler_thread.setDaemon(true);
                  IndexStoreActionHandler.IndexStoreActionHandler_thread.start();
                  IndexStoreActionHandler.IndexStoreActionHandler_thread.setPriority(5);
               }

               IndexStoreActionHandler.field3398 = 600;
            }
         }

         this.setIndexReference(var2);
         this.loadAllLocal();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.indexStore != null) {
            IndexFile var13 = this.indexStore;
            FileSystem var18 = new FileSystem();
            var18.type = 0;
            var18.hash = (long)var1;
            var18.field3367 = var2;
            var18.index = var13;
            Deque var19 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
               IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.addFront(var18);
            }

            Object var20 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
            synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
               if(IndexStoreActionHandler.field3398 == 0) {
                  IndexStoreActionHandler.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
                  IndexStoreActionHandler.IndexStoreActionHandler_thread.setDaemon(true);
                  IndexStoreActionHandler.IndexStoreActionHandler_thread.start();
                  IndexStoreActionHandler.IndexStoreActionHandler_thread.setPriority(5);
               }

               IndexStoreActionHandler.field3398 = 600;
            }

            this.validArchives[var1] = true;
         }

         if(var4) {
            super.archives[var1] = class229.byteArrayToObject(var2, false);
         }
      }

   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(Lfn;I[BZI)V",
      garbageValue = "-1654925751"
   )
   @Export("load")
   public void load(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.referenceStore) {
         if(this.field3405) {
            throw new RuntimeException();
         } else if(var3 == null) {
            Signlink.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
         } else {
            crc32.reset();
            crc32.update(var3, 0, var3.length);
            var5 = (int)crc32.getValue();
            if(var5 != this.crcValue) {
               Signlink.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            } else {
               Buffer var9 = new Buffer(DState.decodeContainer(var3));
               int var7 = var9.readUnsignedByte();
               if(var7 != 5 && var7 != 6) {
                  throw new RuntimeException(var7 + "," + this.index + "," + var2);
               } else {
                  int var8 = 0;
                  if(var7 >= 6) {
                     var8 = var9.readInt();
                  }

                  if(var8 != this.indexReferenceVersion) {
                     Signlink.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
                  } else {
                     this.setIndexReference(var3);
                     this.loadAllLocal();
                  }
               }
            }
         }
      } else {
         if(!var4 && var2 == this.field3411) {
            this.field3405 = true;
         }

         if(var3 != null && var3.length > 2) {
            crc32.reset();
            crc32.update(var3, 0, var3.length - 2);
            var5 = (int)crc32.getValue();
            int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
            if(var5 == super.archiveCrcs[var2] && var6 == super.archiveRevisions[var2]) {
               this.validArchives[var2] = true;
               if(var4) {
                  super.archives[var2] = class229.byteArrayToObject(var3, false);
               }

            } else {
               this.validArchives[var2] = false;
               if(this.field3403 || var4) {
                  Signlink.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
               }

            }
         } else {
            this.validArchives[var2] = false;
            if(this.field3403 || var4) {
               Signlink.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

         }
      }
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-38909249"
   )
   @Export("loadAllLocal")
   void loadAllLocal() {
      this.validArchives = new boolean[super.archives.length];

      int var1;
      for(var1 = 0; var1 < this.validArchives.length; ++var1) {
         this.validArchives[var1] = false;
      }

      if(this.indexStore == null) {
         this.field3405 = true;
      } else {
         this.field3411 = -1;

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

               Object var10 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
               synchronized(IndexStoreActionHandler.IndexStoreActionHandler_lock) {
                  if(IndexStoreActionHandler.field3398 == 0) {
                     IndexStoreActionHandler.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
                     IndexStoreActionHandler.IndexStoreActionHandler_thread.setDaemon(true);
                     IndexStoreActionHandler.IndexStoreActionHandler_thread.start();
                     IndexStoreActionHandler.IndexStoreActionHandler_thread.setPriority(5);
                  }

                  IndexStoreActionHandler.field3398 = 600;
               }

               this.field3411 = var1;
            }
         }

         if(this.field3411 == -1) {
            this.field3405 = true;
         }

      }
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1140402065"
   )
   public boolean method4685(int var1) {
      return this.validArchives[var1];
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1967472642"
   )
   public boolean method4714(int var1) {
      return this.getChilds(var1) != null;
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-577915171"
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "-1740095163"
   )
   @Export("parseInt")
   static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
