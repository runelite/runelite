import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("y")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   IndexFile field3238;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -379650397
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   IndexFile field3245;
   @ObfuscatedName("d")
   volatile boolean field3240;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1959537713
   )
   @Export("index")
   int index;
   @ObfuscatedName("q")
   volatile boolean[] field3242;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1379417843
   )
   int field3241;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 442280343
   )
   int field3243;
   @ObfuscatedName("b")
   boolean field3251;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfz;Lfz;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3240 = false;
      this.field3251 = false;
      this.field3243 = -1;
      this.field3245 = var1;
      this.field3238 = var2;
      this.index = var3;
      this.field3251 = var6;
      class21.method155(this, this.index);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-314848895"
   )
   void vmethod4194(int var1) {
      if(this.field3245 != null && this.field3242 != null && this.field3242[var1]) {
         Occluder.method2888(var1, this.field3245, this);
      } else {
         FileOnDisk.method2368(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2124731025"
   )
   int vmethod4176(int var1) {
      if(super.field3228[var1] != null) {
         return 100;
      } else if(this.field3242[var1]) {
         return 100;
      } else {
         int var3 = this.index;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(class268.currentRequest != null && var4 == class268.currentRequest.hash) {
            var2 = class1.field0.offset * 99 / (class1.field0.payload.length - class268.currentRequest.padding) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-66"
   )
   void method4180() {
      this.field3242 = new boolean[super.field3228.length];

      int var1;
      for(var1 = 0; var1 < this.field3242.length; ++var1) {
         this.field3242[var1] = false;
      }

      if(this.field3245 == null) {
         this.field3240 = true;
      } else {
         this.field3243 = -1;

         for(var1 = 0; var1 < this.field3242.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               IndexFile var2 = this.field3245;
               FileSystem var4 = new FileSystem();
               var4.field3204 = 1;
               var4.hash = (long)var1;
               var4.index = var2;
               var4.data = this;
               Deque var5 = class236.field3235;
               synchronized(class236.field3235) {
                  class236.field3235.addFront(var4);
               }

               World.method1519();
               this.field3243 = var1;
            }
         }

         if(this.field3243 == -1) {
            this.field3240 = true;
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1537468439"
   )
   void vmethod4193(int var1) {
      class27.method215(this.index, var1);
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(Lfz;I[BZB)V",
      garbageValue = "-99"
   )
   void method4179(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field3238) {
         if(this.field3240) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            FileOnDisk.method2368(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         Buffer var9 = new Buffer(class217.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var5 != this.crcValue || var8 != this.field3241) {
            FileOnDisk.method2368(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.method4080(var3);
         this.method4180();
      } else {
         if(!var4 && var2 == this.field3243) {
            this.field3240 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field3242[var2] = false;
            if(this.field3251 || var4) {
               FileOnDisk.method2368(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.field3242[var2] = false;
            if(this.field3251 || var4) {
               FileOnDisk.method2368(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.field3242[var2] = true;
         if(var4) {
            super.field3228[var2] = class83.method1617(var3, false);
         }
      }

   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "883509637"
   )
   @Export("setInformation")
   void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.field3241 = var2;
      if(this.field3238 != null) {
         Occluder.method2888(this.index, this.field3238, this);
      } else {
         FileOnDisk.method2368(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "57"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3240) {
         return 100;
      } else if(super.field3228 != null) {
         return 99;
      } else {
         int var2 = this.index;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(class268.currentRequest != null && var3 == class268.currentRequest.hash) {
            var1 = class1.field0.offset * 99 / (class1.field0.payload.length - class268.currentRequest.padding) + 1;
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

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "281562219"
   )
   public int method4182() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3228.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4176(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "2147111422"
   )
   void method4174(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3240) {
            throw new RuntimeException();
         }

         if(this.field3238 != null) {
            int var11 = this.index;
            IndexFile var6 = this.field3238;
            FileSystem var7 = new FileSystem();
            var7.field3204 = 0;
            var7.hash = (long)var11;
            var7.field3202 = var2;
            var7.index = var6;
            Deque var8 = class236.field3235;
            synchronized(class236.field3235) {
               class236.field3235.addFront(var7);
            }

            World.method1519();
         }

         this.method4080(var2);
         this.method4180();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3245 != null) {
            IndexFile var5 = this.field3245;
            FileSystem var14 = new FileSystem();
            var14.field3204 = 0;
            var14.hash = (long)var1;
            var14.field3202 = var2;
            var14.index = var5;
            Deque var15 = class236.field3235;
            synchronized(class236.field3235) {
               class236.field3235.addFront(var14);
            }

            World.method1519();
            this.field3242[var1] = true;
         }

         if(var4) {
            super.field3228[var1] = class83.method1617(var2, false);
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lif;III)Z",
      garbageValue = "627007602"
   )
   public static boolean method4200(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class36.decodeSprite(var3);
         return true;
      }
   }
}
