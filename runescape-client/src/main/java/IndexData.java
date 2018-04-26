import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexDataBase field3400;
   @ObfuscatedName("aj")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("indexStore")
   IndexFile indexStore;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("referenceStore")
   IndexFile referenceStore;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 587976883
   )
   @Export("index")
   int index;
   @ObfuscatedName("t")
   volatile boolean field3393;
   @ObfuscatedName("ax")
   boolean field3390;
   @ObfuscatedName("ai")
   @Export("validArchives")
   volatile boolean[] validArchives;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -62122527
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1257874323
   )
   @Export("indexReferenceVersion")
   int indexReferenceVersion;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 904765369
   )
   int field3399;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfr;Lfr;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3393 = false;
      this.field3390 = false;
      this.field3399 = -1;
      this.indexStore = var1;
      this.referenceStore = var2;
      this.index = var3;
      this.field3390 = var6;
      Permission.method4628(this, this.index);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-333551024"
   )
   void vmethod4755(int var1) {
      PacketNode.method3514(this.index, var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "374327103"
   )
   int archiveLoadPercent(int var1) {
      return super.archives[var1] != null?100:(this.validArchives[var1]?100:class197.method3822(this.index, var1));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-27"
   )
   void loadArchive(int var1) {
      if(this.indexStore != null && this.validArchives != null && this.validArchives[var1]) {
         class86.method1962(var1, this.indexStore, this);
      } else {
         Script.requestNetFile(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "5"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3393) {
         return 100;
      } else if(super.archives != null) {
         return 99;
      } else {
         int var1 = class197.method3822(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-66"
   )
   @Export("setInformation")
   void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.indexReferenceVersion = var2;
      if(this.referenceStore != null) {
         class86.method1962(this.index, this.referenceStore, this);
      } else {
         Script.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "964514143"
   )
   @Export("write")
   void write(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3393) {
            throw new RuntimeException();
         }

         if(this.referenceStore != null) {
            BoundingBox3D.method52(this.index, var2, this.referenceStore);
         }

         this.setIndexReference(var2);
         this.loadAllLocal();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.indexStore != null) {
            BoundingBox3D.method52(var1, var2, this.indexStore);
            this.validArchives[var1] = true;
         }

         if(var4) {
            super.archives[var1] = GraphicsObject.byteArrayToObject(var2, false);
         }
      }

   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(Lfr;I[BZI)V",
      garbageValue = "1213477398"
   )
   @Export("load")
   void load(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.referenceStore) {
         if(this.field3393) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            Script.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         if(var5 != this.crcValue) {
            Script.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         Buffer var9 = new Buffer(CombatInfoListHolder.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var8 != this.indexReferenceVersion) {
            Script.requestNetFile(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.setIndexReference(var3);
         this.loadAllLocal();
      } else {
         if(!var4 && var2 == this.field3399) {
            this.field3393 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.validArchives[var2] = false;
            if(this.field3390 || var4) {
               Script.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.validArchives[var2] = false;
            if(this.field3390 || var4) {
               Script.requestNetFile(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.validArchives[var2] = true;
         if(var4) {
            super.archives[var2] = GraphicsObject.byteArrayToObject(var3, false);
         }
      }

   }

   @ObfuscatedName("df")
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
         this.field3393 = true;
      } else {
         this.field3399 = -1;

         for(var1 = 0; var1 < this.validArchives.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               MilliTimer.method3280(var1, this.indexStore, this);
               this.field3399 = var1;
            }
         }

         if(this.field3399 == -1) {
            this.field3393 = true;
         }

      }
   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "72"
   )
   public boolean method4772(int var1) {
      return this.validArchives[var1];
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "70"
   )
   public boolean method4783(int var1) {
      return this.getChilds(var1) != null;
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1725357311"
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

   @ObfuscatedName("kl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "2021770657"
   )
   static String method4789(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class23.sessionToken != null) {
         var3 = "/p=" + class23.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class190.field2515 + var3 + "/";
   }
}
