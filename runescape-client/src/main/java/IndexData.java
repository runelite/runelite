import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("q")
   volatile boolean field3238;
   @ObfuscatedName("w")
   IndexFile field3239;
   @ObfuscatedName("t")
   IndexFile field3240;
   @ObfuscatedName("d")
   volatile boolean[] field3241;
   @ObfuscatedName("k")
   boolean field3242;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1561402547
   )
   @Export("index")
   int index;
   @ObfuscatedName("u")
   static CRC32 field3244;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1827472119
   )
   int field3245;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1040269703
   )
   int field3246;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -181319595
   )
   int field3247;
   @ObfuscatedName("cj")
   @Export("indexTrack2")
   static IndexData indexTrack2;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-288456955"
   )
   void vmethod4234(int var1) {
      class82.method1584(this.index, var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1328137381"
   )
   void vmethod4235(int var1) {
      if(this.field3240 != null && this.field3241 != null && this.field3241[var1]) {
         class226.method4100(var1, this.field3240, this);
      } else {
         class165.method3072(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1863646136"
   )
   public void method4236(int var1, int var2) {
      this.field3245 = var1;
      this.field3246 = var2;
      if(this.field3239 != null) {
         class226.method4100(this.index, this.field3239, this);
      } else {
         class165.method3072(this, 255, this.index, this.field3245, (byte)0, true);
      }

   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "1384315757"
   )
   public void method4237(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3238) {
            throw new RuntimeException();
         }

         if(this.field3239 != null) {
            int var5 = this.index;
            IndexFile var6 = this.field3239;
            class233 var7 = new class233();
            var7.field3204 = 0;
            var7.hash = (long)var5;
            var7.field3200 = var2;
            var7.field3201 = var6;
            Deque var8 = class236.field3233;
            synchronized(class236.field3233) {
               class236.field3233.method3634(var7);
            }

            class21.method169();
         }

         this.method4188(var2);
         this.method4239();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3240 != null) {
            IndexFile var11 = this.field3240;
            class233 var14 = new class233();
            var14.field3204 = 0;
            var14.hash = (long)var1;
            var14.field3200 = var2;
            var14.field3201 = var11;
            Deque var15 = class236.field3233;
            synchronized(class236.field3233) {
               class236.field3233.method3634(var14);
            }

            class21.method169();
            this.field3241[var1] = true;
         }

         if(var4) {
            super.field3225[var1] = RSCanvas.method772(var2, false);
         }
      }

   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(LIndexFile;I[BZI)V",
      garbageValue = "77049923"
   )
   public void method4238(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field3239 == var1) {
         if(this.field3238) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class165.method3072(this, 255, this.index, this.field3245, (byte)0, true);
            return;
         }

         field3244.reset();
         field3244.update(var3, 0, var3.length);
         var5 = (int)field3244.getValue();
         Buffer var6 = new Buffer(Client.method1479(var3));
         int var7 = var6.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.readInt();
         }

         if(this.field3245 != var5 || this.field3246 != var8) {
            class165.method3072(this, 255, this.index, this.field3245, (byte)0, true);
            return;
         }

         this.method4188(var3);
         this.method4239();
      } else {
         if(!var4 && var2 == this.field3247) {
            this.field3238 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field3241[var2] = false;
            if(this.field3242 || var4) {
               class165.method3072(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         field3244.reset();
         field3244.update(var3, 0, var3.length - 2);
         var5 = (int)field3244.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(super.archiveCrcs[var2] != var5 || super.archiveRevisions[var2] != var9) {
            this.field3241[var2] = false;
            if(this.field3242 || var4) {
               class165.method3072(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.field3241[var2] = true;
         if(var4) {
            super.field3225[var2] = RSCanvas.method772(var3, false);
         }
      }

   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2121923225"
   )
   void method4239() {
      this.field3241 = new boolean[super.field3225.length];

      int var1;
      for(var1 = 0; var1 < this.field3241.length; ++var1) {
         this.field3241[var1] = false;
      }

      if(this.field3240 == null) {
         this.field3238 = true;
      } else {
         this.field3247 = -1;

         for(var1 = 0; var1 < this.field3241.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               IndexFile var2 = this.field3240;
               class233 var4 = new class233();
               var4.field3204 = 1;
               var4.hash = (long)var1;
               var4.field3201 = var2;
               var4.field3202 = this;
               Deque var5 = class236.field3233;
               synchronized(class236.field3233) {
                  class236.field3233.method3634(var4);
               }

               class21.method169();
               this.field3247 = var1;
            }
         }

         if(this.field3247 == -1) {
            this.field3238 = true;
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "126"
   )
   int vmethod4242(int var1) {
      if(super.field3225[var1] != null) {
         return 100;
      } else if(this.field3241[var1]) {
         return 100;
      } else {
         int var3 = this.index;
         long var4 = (long)(var1 + (var3 << 16));
         int var2;
         if(class18.field327 != null && var4 == class18.field327.hash) {
            var2 = class223.field2843.offset * 99 / (class223.field2843.payload.length - class18.field327.field3210) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1807755077"
   )
   public int method4252() {
      if(this.field3238) {
         return 100;
      } else if(super.field3225 != null) {
         return 99;
      } else {
         int var2 = this.index;
         long var5 = (long)(var2 + 16711680);
         int var1;
         if(class18.field327 != null && var5 == class18.field327.hash) {
            var1 = class223.field2843.offset * 99 / (class223.field2843.payload.length - class18.field327.field3210) + 1;
         } else {
            var1 = 0;
         }

         int var3 = var1;
         if(var1 >= 100) {
            var3 = 99;
         }

         return var3;
      }
   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1157711185"
   )
   public int method4253() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3225.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4242(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3238 = false;
      this.field3242 = false;
      this.field3247 = -1;
      this.field3240 = var1;
      this.field3239 = var2;
      this.index = var3;
      this.field3242 = var6;
      int var8 = this.index;
      if(class1.field10 != null) {
         class1.field10.offset = var8 * 8 + 5;
         int var9 = class1.field10.readInt();
         int var10 = class1.field10.readInt();
         this.method4236(var9, var10);
      } else {
         class165.method3072((IndexData)null, 255, 255, 0, (byte)0, true);
         class238.field3265[var8] = this;
      }

   }

   static {
      field3244 = new CRC32();
   }
}
