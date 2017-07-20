import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("d")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   IndexFile field3219;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 178641617
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   IndexFile field3213;
   @ObfuscatedName("n")
   volatile boolean field3211;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 674233083
   )
   @Export("index")
   int index;
   @ObfuscatedName("b")
   volatile boolean[] field3215;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1780189913
   )
   int field3218;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1411486053
   )
   int field3220;
   @ObfuscatedName("z")
   boolean field3214;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfz;Lfz;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3211 = false;
      this.field3214 = false;
      this.field3220 = -1;
      this.field3213 = var1;
      this.field3219 = var2;
      this.index = var3;
      this.field3214 = var6;
      int var8 = this.index;
      if(class48.field620 != null) {
         class48.field620.offset = var8 * 8 + 5;
         int var9 = class48.field620.readInt();
         int var10 = class48.field620.readInt();
         this.setInformation(var9, var10);
      } else {
         class228.method3983((IndexData)null, 255, 255, 0, (byte)0, true);
         class238.field3242[var8] = this;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "83"
   )
   void vmethod4129(int var1) {
      if(this.field3213 != null && this.field3215 != null && this.field3215[var1]) {
         class48.method699(var1, this.field3213, this);
      } else {
         class228.method3983(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-6"
   )
   int vmethod4125(int var1) {
      return super.field3192[var1] != null?100:(this.field3215[var1]?100:XItemContainer.method1032(this.index, var1));
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2078513442"
   )
   void method4119() {
      this.field3215 = new boolean[super.field3192.length];

      int var1;
      for(var1 = 0; var1 < this.field3215.length; ++var1) {
         this.field3215[var1] = false;
      }

      if(this.field3213 == null) {
         this.field3211 = true;
      } else {
         this.field3220 = -1;

         for(var1 = 0; var1 < this.field3215.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               class67.method1043(var1, this.field3213, this);
               this.field3220 = var1;
            }
         }

         if(this.field3220 == -1) {
            this.field3211 = true;
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-92"
   )
   void vmethod4120(int var1) {
      class46.method668(this.index, var1);
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(Lfz;I[BZI)V",
      garbageValue = "-816837499"
   )
   void method4124(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field3219) {
         if(this.field3211) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class228.method3983(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         Buffer var9 = new Buffer(FileOnDisk.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var5 != this.crcValue || var8 != this.field3218) {
            class228.method3983(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.method4104(var3);
         this.method4119();
      } else {
         if(!var4 && var2 == this.field3220) {
            this.field3211 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field3215[var2] = false;
            if(this.field3214 || var4) {
               class228.method3983(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.field3215[var2] = false;
            if(this.field3214 || var4) {
               class228.method3983(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.field3215[var2] = true;
         if(var4) {
            super.field3192[var2] = WallObject.method2806(var3, false);
         }
      }

   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-646419045"
   )
   @Export("setInformation")
   public void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.field3218 = var2;
      if(this.field3219 != null) {
         class48.method699(this.index, this.field3219, this);
      } else {
         class228.method3983(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1015844900"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3211) {
         return 100;
      } else if(super.field3192 != null) {
         return 99;
      } else {
         int var1 = XItemContainer.method1032(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "49"
   )
   public int method4126() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3192.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4125(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "1851415681"
   )
   public void method4123(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3211) {
            throw new RuntimeException();
         }

         if(this.field3219 != null) {
            class43.method594(this.index, var2, this.field3219);
         }

         this.method4104(var2);
         this.method4119();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3213 != null) {
            class43.method594(var1, var2, this.field3213);
            this.field3215[var1] = true;
         }

         if(var4) {
            super.field3192[var1] = WallObject.method2806(var2, false);
         }
      }

   }
}
