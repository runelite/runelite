import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("w")
   @Export("crc32")
   static CRC32 crc32;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   IndexFile field3245;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   IndexFile field3250;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1086409969
   )
   @Export("crcValue")
   int crcValue;
   @ObfuscatedName("h")
   volatile boolean field3247;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1361915827
   )
   @Export("index")
   int index;
   @ObfuscatedName("g")
   volatile boolean[] field3249;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1415879103
   )
   int field3246;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -60819923
   )
   int field3244;
   @ObfuscatedName("f")
   boolean field3252;

   static {
      crc32 = new CRC32();
   }

   @ObfuscatedSignature(
      signature = "(Lfx;Lfx;IZZZ)V"
   )
   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3247 = false;
      this.field3252 = false;
      this.field3244 = -1;
      this.field3250 = var1;
      this.field3245 = var2;
      this.index = var3;
      this.field3252 = var6;
      int var8 = this.index;
      if(CollisionData.field2303 != null) {
         CollisionData.field2303.offset = var8 * 8 + 5;
         int var9 = CollisionData.field2303.readInt();
         int var10 = CollisionData.field2303.readInt();
         this.setInformation(var9, var10);
      } else {
         class89.method1717((IndexData)null, 255, 255, 0, (byte)0, true);
         class239.field3268[var8] = this;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void vmethod4228(int var1) {
      if(this.field3250 != null && this.field3249 != null && this.field3249[var1]) {
         IndexFile var2 = this.field3250;
         byte[] var4 = null;
         Deque var5 = class237.field3243;
         synchronized(class237.field3243) {
            for(FileSystem var6 = (FileSystem)class237.field3243.getFront(); var6 != null; var6 = (FileSystem)class237.field3243.getNext()) {
               if(var6.hash == (long)var1 && var2 == var6.index && var6.field3205 == 0) {
                  var4 = var6.field3206;
                  break;
               }
            }
         }

         if(var4 != null) {
            this.method4235(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.method3083(var1);
            this.method4235(var2, var1, var9, true);
         }
      } else {
         class89.method1717(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "56"
   )
   int vmethod4233(int var1) {
      if(super.field3224[var1] != null) {
         return 100;
      } else if(this.field3249[var1]) {
         return 100;
      } else {
         int var3 = this.index;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(class29.currentRequest != null && class29.currentRequest.hash == var4) {
            var2 = BuildType.field3190.offset * 99 / (BuildType.field3190.payload.length - class29.currentRequest.padding) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-78"
   )
   void method4232() {
      this.field3249 = new boolean[super.field3224.length];

      int var1;
      for(var1 = 0; var1 < this.field3249.length; ++var1) {
         this.field3249[var1] = false;
      }

      if(this.field3250 == null) {
         this.field3247 = true;
      } else {
         this.field3244 = -1;

         for(var1 = 0; var1 < this.field3249.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               IndexFile var2 = this.field3250;
               FileSystem var4 = new FileSystem();
               var4.field3205 = 1;
               var4.hash = (long)var1;
               var4.index = var2;
               var4.data = this;
               Deque var5 = class237.field3243;
               synchronized(class237.field3243) {
                  class237.field3243.addFront(var4);
               }

               IndexFile.method3099();
               this.field3244 = var1;
            }
         }

         if(this.field3244 == -1) {
            this.field3247 = true;
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1165910002"
   )
   void vmethod4238(int var1) {
      class164.method3149(this.index, var1);
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(Lfx;I[BZI)V",
      garbageValue = "-976126455"
   )
   public void method4235(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field3245) {
         if(this.field3247) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class89.method1717(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length);
         var5 = (int)crc32.getValue();
         Buffer var9 = new Buffer(AbstractByteBuffer.decodeContainer(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.readInt();
         }

         if(var5 != this.crcValue || var8 != this.field3246) {
            class89.method1717(this, 255, this.index, this.crcValue, (byte)0, true);
            return;
         }

         this.method4162(var3);
         this.method4232();
      } else {
         if(!var4 && var2 == this.field3244) {
            this.field3247 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field3249[var2] = false;
            if(this.field3252 || var4) {
               class89.method1717(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         crc32.reset();
         crc32.update(var3, 0, var3.length - 2);
         var5 = (int)crc32.getValue();
         int var6 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var6 != super.archiveRevisions[var2]) {
            this.field3249[var2] = false;
            if(this.field3252 || var4) {
               class89.method1717(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.field3249[var2] = true;
         if(var4) {
            super.field3224[var2] = class43.method646(var3, false);
         }
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1570910765"
   )
   @Export("setInformation")
   public void setInformation(int var1, int var2) {
      this.crcValue = var1;
      this.field3246 = var2;
      if(this.field3245 != null) {
         int var3 = this.index;
         IndexFile var4 = this.field3245;
         byte[] var6 = null;
         Deque var7 = class237.field3243;
         synchronized(class237.field3243) {
            for(FileSystem var8 = (FileSystem)class237.field3243.getFront(); var8 != null; var8 = (FileSystem)class237.field3243.getNext()) {
               if((long)var3 == var8.hash && var4 == var8.index && var8.field3205 == 0) {
                  var6 = var8.field3206;
                  break;
               }
            }
         }

         if(var6 != null) {
            this.method4235(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method3083(var3);
            this.method4235(var4, var3, var11, true);
         }
      } else {
         class89.method1717(this, 255, this.index, this.crcValue, (byte)0, true);
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "14"
   )
   @Export("percentage")
   public int percentage() {
      if(this.field3247) {
         return 100;
      } else if(super.field3224 != null) {
         return 99;
      } else {
         int var2 = this.index;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(class29.currentRequest != null && var3 == class29.currentRequest.hash) {
            var1 = BuildType.field3190.offset * 99 / (BuildType.field3190.payload.length - class29.currentRequest.padding) + 1;
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

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1914605035"
   )
   public int method4234() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3224.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4233(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "547335278"
   )
   public void method4230(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3247) {
            throw new RuntimeException();
         }

         if(this.field3245 != null) {
            class13.method85(this.index, var2, this.field3245);
         }

         this.method4162(var2);
         this.method4232();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3250 != null) {
            class13.method85(var1, var2, this.field3250);
            this.field3249[var1] = true;
         }

         if(var4) {
            super.field3224[var1] = class43.method646(var2, false);
         }
      }

   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(IIIILkd;Lhc;I)V",
      garbageValue = "-1610861949"
   )
   @Export("drawDot")
   static final void drawDot(int var0, int var1, int var2, int var3, SpritePixels var4, class211 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = Graphics3D.SINE[var6];
            int var9 = Graphics3D.COSINE[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method5096(var10 + var5.field2600 / 2 - var4.maxWidth / 2, var5.field2599 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2600, var5.field2599, var5.field2602, var5.field2601);
            } else {
               var4.method5019(var0 + var10 + var5.field2600 / 2 - var4.maxWidth / 2, var5.field2599 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }
}
