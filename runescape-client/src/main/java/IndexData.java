import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1157602403
   )
   int field3248;
   @ObfuscatedName("p")
   IndexFile field3249;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -941487097
   )
   @Export("index")
   int index;
   @ObfuscatedName("d")
   volatile boolean field3251;
   @ObfuscatedName("h")
   boolean field3252;
   @ObfuscatedName("g")
   volatile boolean[] field3253;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1143355003
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1097572185
   )
   int field3256;
   @ObfuscatedName("u")
   IndexFile field3257;
   @ObfuscatedName("gm")
   static SpritePixels[] field3258;
   @ObfuscatedName("x")
   @Export("crc32")
   static CRC32 crc32;

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-916515885"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3251) {
         return 100;
      } else if(super.field3235 != null) {
         return 99;
      } else {
         int var1 = class228.method4084(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3251 = false;
      this.field3252 = false;
      this.field3248 = -1;
      this.field3257 = var1;
      this.field3249 = var2;
      this.index = var3;
      this.field3252 = var6;
      int var7 = this.index;
      if(FaceNormal.field2150 != null) {
         FaceNormal.field2150.offset = var7 * 8 + 5;
         int var8 = FaceNormal.field2150.readInt();
         int var9 = FaceNormal.field2150.readInt();
         this.setInformation(var8, var9);
      } else {
         PacketBuffer.method3413((IndexData)null, 255, 255, 0, (byte)0, true);
         class238.field3262[var7] = this;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "2"
   )
   void vmethod4217(int var1) {
      if(this.field3257 != null && this.field3253 != null && this.field3253[var1]) {
         class5.method19(var1, this.field3257, this);
      } else {
         PacketBuffer.method3413(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "595579571"
   )
   @Export("setInformation")
   void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.field3256 = var2;
      if(this.field3249 != null) {
         class5.method19(this.index, this.field3249, this);
      } else {
         PacketBuffer.method3413(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "23808975"
   )
   void method4219(int var1, byte[] var2, boolean var3, boolean var4) {
      Deque var8;
      if(var3) {
         if(this.field3251) {
            throw new RuntimeException();
         }

         if(this.field3249 != null) {
            int var5 = this.index;
            IndexFile var6 = this.field3249;
            FileSystem var7 = new FileSystem();
            var7.field3213 = 0;
            var7.hash = (long)var5;
            var7.field3215 = var2;
            var7.index = var6;
            var8 = class236.field3247;
            Deque var9 = class236.field3247;
            synchronized(class236.field3247) {
               class236.field3247.addFront(var7);
            }

            class43.method644();
         }

         this.method4112(var2);
         this.method4237();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3257 != null) {
            IndexFile var14 = this.field3257;
            FileSystem var15 = new FileSystem();
            var15.field3213 = 0;
            var15.hash = (long)var1;
            var15.field3215 = var2;
            var15.index = var14;
            Deque var16 = class236.field3247;
            var8 = class236.field3247;
            synchronized(class236.field3247) {
               class236.field3247.addFront(var15);
            }

            class43.method644();
            this.field3253[var1] = true;
         }

         if(var4) {
            super.field3235[var1] = FrameMap.method2665(var2, false);
         }
      }

   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(LIndexFile;I[BZB)V",
      garbageValue = "0"
   )
   public void method4220(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field3249 == var1) {
         if(this.field3251) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            PacketBuffer.method3413(this, 255, this.index, this.crcValue, (byte)0, true);
         } else {
            crc32.reset();
            crc32.update(var3, 0, var3.length);
            var5 = (int)crc32.getValue();
            Buffer var6 = new Buffer(class162.decodeContainer(var3));
            int var7 = var6.readUnsignedByte();
            if(var7 != 5 && var7 != 6) {
               throw new RuntimeException(var7 + "," + this.index + "," + var2);
            }

            int var8 = 0;
            if(var7 >= 6) {
               var8 = var6.readInt();
            }

            if(var5 == this.crcValue && var8 == this.field3256) {
               this.method4112(var3);
               this.method4237();
            } else {
               PacketBuffer.method3413(this, 255, this.index, this.crcValue, (byte)0, true);
            }
         }
      } else {
         if(!var4 && var2 == this.field3248) {
            this.field3251 = true;
         }

         if(var3 != null && var3.length > 2) {
            crc32.reset();
            crc32.update(var3, 0, var3.length - 2);
            var5 = (int)crc32.getValue();
            int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
            if(var5 == super.archiveCrcs[var2] && super.archiveRevisions[var2] == var9) {
               this.field3253[var2] = true;
               if(var4) {
                  super.field3235[var2] = FrameMap.method2665(var3, false);
               }
            } else {
               this.field3253[var2] = false;
               if(this.field3252 || var4) {
                  PacketBuffer.method3413(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
               }
            }
         } else {
            this.field3253[var2] = false;
            if(this.field3252 || var4) {
               PacketBuffer.method3413(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-400480797"
   )
   int vmethod4226(int var1) {
      return super.field3235[var1] != null?100:(this.field3253[var1]?100:class228.method4084(this.index, var1));
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2033467706"
   )
   public int method4234() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3235.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4226(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1750356862"
   )
   void method4237() {
      this.field3253 = new boolean[super.field3235.length];

      int var1;
      for(var1 = 0; var1 < this.field3253.length; ++var1) {
         this.field3253[var1] = false;
      }

      if(this.field3257 == null) {
         this.field3251 = true;
      } else {
         this.field3248 = -1;

         for(var1 = 0; var1 < this.field3253.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               class268.method4858(var1, this.field3257, this);
               this.field3248 = var1;
            }
         }

         if(this.field3248 == -1) {
            this.field3251 = true;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1800419410"
   )
   void vmethod4243(int var1) {
      class31.method265(this.index, var1);
   }

   static {
      crc32 = new CRC32();
   }
}
