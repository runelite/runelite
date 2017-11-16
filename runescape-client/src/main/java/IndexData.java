import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("w")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   IndexFile field3300;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   IndexFile field3303;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -157034705
   )
   @Export("index")
   int index;
   @ObfuscatedName("z")
   volatile boolean field3297;
   @ObfuscatedName("e")
   boolean field3294;
   @ObfuscatedName("v")
   volatile boolean[] field3295;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1892340741
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 873238095
   )
   int field3302;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -2140233085
   )
   int field3299;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfw;Lfw;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3297 = false;
      this.field3294 = false;
      this.field3299 = -1;
      this.field3300 = var1;
      this.field3303 = var2;
      this.index = var3;
      this.field3294 = var6;
      int var8 = this.index;
      if(class36.field473 != null) {
         class36.field473.offset = var8 * 8 + 5;
         int var9 = class36.field473.readInt();
         int var10 = class36.field473.readInt();
         this.setInformation(var9, var10);
      } else {
         class87.method1678((IndexData)null, 255, 255, 0, (byte)0, true);
         class245.field3321[var8] = this;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1224741281"
   )
   void vmethod4211(int var1) {
      class20.method148(this.index, var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   int vmethod4223(int var1) {
      return super.field3279[var1] != null?100:(this.field3295[var1]?100:MessageNode.method1053(this.index, var1));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "71"
   )
   void vmethod4216(int var1) {
      if(this.field3300 != null && this.field3295 != null && this.field3295[var1]) {
         class37.method483(var1, this.field3300, this);
      } else {
         class87.method1678(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2138172350"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3297) {
         return 100;
      } else if(super.field3279 != null) {
         return 99;
      } else {
         int var1 = MessageNode.method1053(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1265504799"
   )
   @Export("setInformation")
   void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.field3302 = var2;
      if(this.field3303 != null) {
         class37.method483(this.index, this.field3303, this);
      } else {
         class87.method1678(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "-73"
   )
   void method4212(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3297) {
            throw new RuntimeException();
         }

         if(this.field3303 != null) {
            WidgetNode.method1030(this.index, var2, this.field3303);
         }

         this.method4106(var2);
         this.method4214();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3300 != null) {
            WidgetNode.method1030(var1, var2, this.field3300);
            this.field3295[var1] = true;
         }

         if(var4) {
            super.field3279[var1] = class177.method3156(var2, false);
         }
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(Lfw;I[BZI)V",
      garbageValue = "-1708519652"
   )
   public void method4213(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field3303) {
         if(this.field3297) {
            throw new RuntimeException();
         } else if(var3 == null) {
            class87.method1678(this, 255, this.index, this.crcValue, (byte)0, true);
         } else {
            crc32.reset();
            crc32.update(var3, 0, var3.length);
            var5 = (int)crc32.getValue();
            Buffer var9 = new Buffer(CacheFile.decodeContainer(var3));
            int var7 = var9.readUnsignedByte();
            if(var7 != 5 && var7 != 6) {
               throw new RuntimeException(var7 + "," + this.index + "," + var2);
            } else {
               int var8 = 0;
               if(var7 >= 6) {
                  var8 = var9.readInt();
               }

               if(var5 != this.crcValue || var8 != this.field3302) {
                  class87.method1678(this, 255, this.index, this.crcValue, (byte)0, true);
               } else {
                  this.method4106(var3);
                  this.method4214();
               }
            }
         }
      } else {
         if(!var4 && var2 == this.field3299) {
            this.field3297 = true;
         }

         if(var3 != null && var3.length > 2) {
            crc32.reset();
            crc32.update(var3, 0, var3.length - 2);
            var5 = (int)crc32.getValue();
            int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
            if(var5 == super.archiveCrcs[var2] && var6 == super.archiveRevisions[var2]) {
               this.field3295[var2] = true;
               if(var4) {
                  super.field3279[var2] = class177.method3156(var3, false);
               }

            } else {
               this.field3295[var2] = false;
               if(this.field3294 || var4) {
                  class87.method1678(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
               }

            }
         } else {
            this.field3295[var2] = false;
            if(this.field3294 || var4) {
               class87.method1678(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

         }
      }
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1693650538"
   )
   void method4214() {
      this.field3295 = new boolean[super.field3279.length];

      int var1;
      for(var1 = 0; var1 < this.field3295.length; ++var1) {
         this.field3295[var1] = false;
      }

      if(this.field3300 == null) {
         this.field3297 = true;
      } else {
         this.field3299 = -1;

         for(var1 = 0; var1 < this.field3295.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               class34.method469(var1, this.field3300, this);
               this.field3299 = var1;
            }
         }

         if(this.field3299 == -1) {
            this.field3297 = true;
         }

      }
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-534251950"
   )
   public int method4217() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3279.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4223(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1454203423"
   )
   public static void method4233() {
      try {
         class156.field2148.method2355();

         for(int var0 = 0; var0 < class164.field2212; ++var0) {
            class221.field2700[var0].method2355();
         }

         class156.field2153.method2355();
         class156.field2151.method2355();
      } catch (Exception var2) {
         ;
      }

   }
}
