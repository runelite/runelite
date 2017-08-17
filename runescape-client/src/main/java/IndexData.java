import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("d")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   IndexFile field3226;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   IndexFile field3231;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -380105873
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("k")
   volatile boolean field3228;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -701278915
   )
   @Export("index")
   int index;
   @ObfuscatedName("n")
   volatile boolean[] field3235;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -177522927
   )
   int field3233;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -236732629
   )
   int field3234;
   @ObfuscatedName("q")
   boolean field3225;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfx;Lfx;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3228 = false;
      this.field3225 = false;
      this.field3234 = -1;
      this.field3231 = var1;
      this.field3226 = var2;
      this.index = var3;
      this.field3225 = var6;
      int var8 = this.index;
      if(class113.field1679 != null) {
         class113.field1679.offset = var8 * 8 + 5;
         int var9 = class113.field1679.readInt();
         int var10 = class113.field1679.readInt();
         this.setInformation(var9, var10);
      } else {
         class175.method3389((IndexData)null, 255, 255, 0, (byte)0, true);
         class239.field3236[var8] = this;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1542431978"
   )
   void vmethod4223(int var1) {
      if(this.field3231 != null && this.field3235 != null && this.field3235[var1]) {
         KeyFocusListener.method807(var1, this.field3231, this);
      } else {
         class175.method3389(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "4005"
   )
   int vmethod4229(int var1) {
      if(super.field3211[var1] != null) {
         return 100;
      } else if(this.field3235[var1]) {
         return 100;
      } else {
         int var3 = this.index;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(class239.currentRequest != null && var4 == class239.currentRequest.hash) {
            var2 = 1 + class40.field555.offset * 99 / (class40.field555.payload.length - class239.currentRequest.padding);
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "253420213"
   )
   void method4242() {
      this.field3235 = new boolean[super.field3211.length];

      int var1;
      for(var1 = 0; var1 < this.field3235.length; ++var1) {
         this.field3235[var1] = false;
      }

      if(this.field3231 == null) {
         this.field3228 = true;
      } else {
         this.field3234 = -1;

         for(var1 = 0; var1 < this.field3235.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               DecorativeObject.method2921(var1, this.field3231, this);
               this.field3234 = var1;
            }
         }

         if(this.field3234 == -1) {
            this.field3228 = true;
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2112050568"
   )
   void vmethod4225(int var1) {
      int var2 = this.index;
      long var3 = (long)((var2 << 16) + var1);
      FileRequest var5 = (FileRequest)class239.field3239.get(var3);
      if(var5 != null) {
         class239.field3243.setHead(var5);
      }

   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(Lfx;I[BZI)V",
      garbageValue = "-1514233074"
   )
   void method4228(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field3226) {
         if(this.field3228) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class175.method3389(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         Buffer var9 = new Buffer(GZipDecompressor.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var5 != this.crcValue || var8 != this.field3233) {
            class175.method3389(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.method4169(var3);
         this.method4242();
      } else {
         if(!var4 && var2 == this.field3234) {
            this.field3228 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field3235[var2] = false;
            if(this.field3225 || var4) {
               class175.method3389(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.field3235[var2] = false;
            if(this.field3225 || var4) {
               class175.method3389(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.field3235[var2] = true;
         if(var4) {
            super.field3211[var2] = class83.method1621(var3, false);
         }
      }

   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1345655371"
   )
   @Export("setInformation")
   public void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.field3233 = var2;
      if(this.field3226 != null) {
         KeyFocusListener.method807(this.index, this.field3226, this);
      } else {
         class175.method3389(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "42"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3228) {
         return 100;
      } else if(super.field3211 != null) {
         return 99;
      } else {
         int var2 = this.index;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(class239.currentRequest != null && var3 == class239.currentRequest.hash) {
            var1 = class40.field555.offset * 99 / (class40.field555.payload.length - class239.currentRequest.padding) + 1;
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

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1550887519"
   )
   public int method4226() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3211.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4229(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "0"
   )
   public void method4230(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3228) {
            throw new RuntimeException();
         }

         if(this.field3226 != null) {
            int var11 = this.index;
            IndexFile var6 = this.field3226;
            FileSystem var7 = new FileSystem();
            var7.field3196 = 0;
            var7.hash = (long)var11;
            var7.field3194 = var2;
            var7.index = var6;
            Deque var8 = class237.field3224;
            synchronized(class237.field3224) {
               class237.field3224.addFront(var7);
            }

            class229.method4092();
         }

         this.method4169(var2);
         this.method4242();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3231 != null) {
            IndexFile var5 = this.field3231;
            FileSystem var14 = new FileSystem();
            var14.field3196 = 0;
            var14.hash = (long)var1;
            var14.field3194 = var2;
            var14.index = var5;
            Deque var15 = class237.field3224;
            synchronized(class237.field3224) {
               class237.field3224.addFront(var14);
            }

            class229.method4092();
            this.field3235[var1] = true;
         }

         if(var4) {
            super.field3211[var1] = class83.method1621(var2, false);
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lia;Ljava/lang/String;Ljava/lang/String;I)Lkp;",
      garbageValue = "1473083008"
   )
   public static SpritePixels method4233(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class252.method4470(var0, var3, var4);
   }
}
