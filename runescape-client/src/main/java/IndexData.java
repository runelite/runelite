import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("u")
   volatile boolean[] field3240;
   @ObfuscatedName("g")
   IndexFile field3241;
   @ObfuscatedName("s")
   IndexFile field3242;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1110210777
   )
   @Export("index")
   int index;
   @ObfuscatedName("l")
   boolean field3244;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -2083606419
   )
   int field3245;
   @ObfuscatedName("p")
   volatile boolean field3246;
   @ObfuscatedName("t")
   static CRC32 field3247;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 918704165
   )
   int field3248;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1835316865
   )
   int field3249;

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-111728704"
   )
   public int method4218() {
      if(this.field3246) {
         return 100;
      } else if(super.field3225 != null) {
         return 99;
      } else {
         int var2 = this.index;
         long var5 = (long)(var2 + 16711680);
         int var1;
         if(class54.field677 != null && var5 == class54.field677.hash) {
            var1 = class224.field2849.offset * 99 / (class224.field2849.payload.length - class54.field677.field3210) + 1;
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1368937922"
   )
   void vmethod4220(int var1) {
      if(this.field3242 != null && this.field3240 != null && this.field3240[var1]) {
         class158.method2973(var1, this.field3242, this);
      } else {
         class224.method4072(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "90"
   )
   void method4221(int var1, int var2) {
      this.field3245 = var1;
      this.field3248 = var2;
      if(this.field3241 != null) {
         class158.method2973(this.index, this.field3241, this);
      } else {
         class224.method4072(this, 255, this.index, this.field3245, (byte)0, true);
      }

   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "7"
   )
   void method4222(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3246) {
            throw new RuntimeException();
         }

         if(this.field3241 != null) {
            int var5 = this.index;
            IndexFile var6 = this.field3241;
            class233 var7 = new class233();
            var7.field3207 = 0;
            var7.hash = (long)var5;
            var7.field3198 = var2;
            var7.field3199 = var6;
            Deque var8 = class236.field3238;
            synchronized(class236.field3238) {
               class236.field3238.method3571(var7);
            }

            Object var21 = class236.field3234;
            synchronized(class236.field3234) {
               if(class236.field3236 == 0) {
                  class111.field1676 = new Thread(new class236());
                  class111.field1676.setDaemon(true);
                  class111.field1676.start();
                  class111.field1676.setPriority(5);
               }

               class236.field3236 = 600;
            }
         }

         this.method4107(var2);
         this.method4239();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3242 != null) {
            IndexFile var13 = this.field3242;
            class233 var18 = new class233();
            var18.field3207 = 0;
            var18.hash = (long)var1;
            var18.field3198 = var2;
            var18.field3199 = var13;
            Deque var19 = class236.field3238;
            synchronized(class236.field3238) {
               class236.field3238.method3571(var18);
            }

            Object var20 = class236.field3234;
            synchronized(class236.field3234) {
               if(class236.field3236 == 0) {
                  class111.field1676 = new Thread(new class236());
                  class111.field1676.setDaemon(true);
                  class111.field1676.start();
                  class111.field1676.setPriority(5);
               }

               class236.field3236 = 600;
            }

            this.field3240[var1] = true;
         }

         if(var4) {
            super.field3225[var1] = WorldMapType2.method490(var2, false);
         }
      }

   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(LIndexFile;I[BZI)V",
      garbageValue = "1510494190"
   )
   void method4223(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field3241 == var1) {
         if(this.field3246) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class224.method4072(this, 255, this.index, this.field3245, (byte)0, true);
            return;
         }

         field3247.reset();
         field3247.update(var3, 0, var3.length);
         var5 = (int)field3247.getValue();
         Buffer var6 = new Buffer(class24.method163(var3));
         int var7 = var6.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.readInt();
         }

         if(var5 != this.field3245 || var8 != this.field3248) {
            class224.method4072(this, 255, this.index, this.field3245, (byte)0, true);
            return;
         }

         this.method4107(var3);
         this.method4239();
      } else {
         if(!var4 && var2 == this.field3249) {
            this.field3246 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field3240[var2] = false;
            if(this.field3244 || var4) {
               class224.method4072(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         field3247.reset();
         field3247.update(var3, 0, var3.length - 2);
         var5 = (int)field3247.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.archiveCrcs[var2] || var9 != super.archiveRevisions[var2]) {
            this.field3240[var2] = false;
            if(this.field3244 || var4) {
               class224.method4072(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }

            return;
         }

         this.field3240[var2] = true;
         if(var4) {
            super.field3225[var2] = WorldMapType2.method490(var3, false);
         }
      }

   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1651665305"
   )
   public int method4226() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3225.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4241(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   static {
      field3247 = new CRC32();
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-616559211"
   )
   void method4239() {
      this.field3240 = new boolean[super.field3225.length];

      int var1;
      for(var1 = 0; var1 < this.field3240.length; ++var1) {
         this.field3240[var1] = false;
      }

      if(this.field3242 == null) {
         this.field3246 = true;
      } else {
         this.field3249 = -1;

         for(var1 = 0; var1 < this.field3240.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               class71.method1098(var1, this.field3242, this);
               this.field3249 = var1;
            }
         }

         if(this.field3249 == -1) {
            this.field3246 = true;
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "447554552"
   )
   void vmethod4240(int var1) {
      class221.method4063(this.index, var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-703132845"
   )
   int vmethod4241(int var1) {
      if(super.field3225[var1] != null) {
         return 100;
      } else if(this.field3240[var1]) {
         return 100;
      } else {
         int var3 = this.index;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(class54.field677 != null && class54.field677.hash == var4) {
            var2 = class224.field2849.offset * 99 / (class224.field2849.payload.length - class54.field677.field3210) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3246 = false;
      this.field3244 = false;
      this.field3249 = -1;
      this.field3242 = var1;
      this.field3241 = var2;
      this.index = var3;
      this.field3244 = var6;
      int var8 = this.index;
      if(class176.field2426 != null) {
         class176.field2426.offset = var8 * 8 + 5;
         int var9 = class176.field2426.readInt();
         int var10 = class176.field2426.readInt();
         this.method4221(var9, var10);
      } else {
         class224.method4072((IndexData)null, 255, 255, 0, (byte)0, true);
         class238.field3265[var8] = this;
      }

   }
}
