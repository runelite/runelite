import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -370012777
   )
   int field3246;
   @ObfuscatedName("l")
   IndexFile field3247;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1511483991
   )
   @Export("index")
   int index;
   @ObfuscatedName("b")
   boolean field3249;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 135608967
   )
   int field3250;
   @ObfuscatedName("y")
   volatile boolean[] field3251;
   @ObfuscatedName("u")
   static CRC32 field3252;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1608820109
   )
   int field3253;
   @ObfuscatedName("x")
   volatile boolean field3254;
   @ObfuscatedName("h")
   IndexFile field3256;

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "28647"
   )
   public int method4095() {
      if(this.field3254) {
         return 100;
      } else if(super.field3230 != null) {
         return 99;
      } else {
         int var1 = class90.method1617(255, this.index);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-953159438"
   )
   void vmethod4096(int var1) {
      int var2 = this.index;
      long var3 = (long)(var1 + (var2 << 16));
      class234 var5 = (class234)class238.field3265.method3425(var3);
      if(var5 != null) {
         class238.field3259.method3376(var5);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-848431386"
   )
   void vmethod4097(int var1) {
      if(this.field3247 != null && this.field3251 != null && this.field3251[var1]) {
         IndexFile var2 = this.field3247;
         byte[] var3 = null;
         Deque var4 = class236.field3245;
         Deque var5 = class236.field3245;
         Deque var6 = class236.field3245;
         synchronized(class236.field3245) {
            for(FileSystem var7 = (FileSystem)class236.field3245.method3487(); var7 != null; var7 = (FileSystem)class236.field3245.method3512()) {
               if((long)var1 == var7.hash && var2 == var7.index && var7.field3211 == 0) {
                  var3 = var7.field3210;
                  break;
               }
            }
         }

         if(var3 != null) {
            this.method4100(var2, var1, var3, true);
         } else {
            byte[] var10 = var2.method2902(var1);
            this.method4100(var2, var1, var10, true);
         }
      } else {
         class9.method52(this, this.index, var1, super.archiveCrcs[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1305160441"
   )
   int vmethod4098(int var1) {
      return super.field3230[var1] != null?100:(this.field3251[var1]?100:class90.method1617(this.index, var1));
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(LIndexFile;I[BZI)V",
      garbageValue = "251964315"
   )
   public void method4100(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field3256 == var1) {
         if(this.field3254) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class9.method52(this, 255, this.index, this.field3253, (byte)0, true);
         } else {
            field3252.reset();
            field3252.update(var3, 0, var3.length);
            var5 = (int)field3252.getValue();
            Buffer var6 = new Buffer(class226.method3966(var3));
            int var7 = var6.readUnsignedByte();
            if(var7 != 5 && var7 != 6) {
               throw new RuntimeException(var7 + "," + this.index + "," + var2);
            }

            int var8 = 0;
            if(var7 >= 6) {
               var8 = var6.readInt();
            }

            if(var5 == this.field3253 && var8 == this.field3246) {
               this.method3993(var3);
               this.method4101();
            } else {
               class9.method52(this, 255, this.index, this.field3253, (byte)0, true);
            }
         }
      } else {
         if(!var4 && var2 == this.field3250) {
            this.field3254 = true;
         }

         if(var3 != null && var3.length > 2) {
            field3252.reset();
            field3252.update(var3, 0, var3.length - 2);
            var5 = (int)field3252.getValue();
            int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
            if(var5 == super.archiveCrcs[var2] && super.archiveRevisions[var2] == var9) {
               this.field3251[var2] = true;
               if(var4) {
                  super.field3230[var2] = class20.method166(var3, false);
               }
            } else {
               this.field3251[var2] = false;
               if(this.field3249 || var4) {
                  class9.method52(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
               }
            }
         } else {
            this.field3251[var2] = false;
            if(this.field3249 || var4) {
               class9.method52(this, this.index, var2, super.archiveCrcs[var2], (byte)2, var4);
            }
         }
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-19774725"
   )
   void method4101() {
      this.field3251 = new boolean[super.field3230.length];

      int var1;
      for(var1 = 0; var1 < this.field3251.length; ++var1) {
         this.field3251[var1] = false;
      }

      if(this.field3247 == null) {
         this.field3254 = true;
      } else {
         this.field3250 = -1;

         for(var1 = 0; var1 < this.field3251.length; ++var1) {
            if(super.archiveNumberOfFiles[var1] > 0) {
               class11.method61(var1, this.field3247, this);
               this.field3250 = var1;
            }
         }

         if(this.field3250 == -1) {
            this.field3254 = true;
         }
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-122"
   )
   public int method4103() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3230.length; ++var3) {
         if(super.archiveNumberOfFiles[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4098(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "597528711"
   )
   void method4117(int var1, byte[] var2, boolean var3, boolean var4) {
      Deque var5;
      Object var6;
      Deque var10;
      Object var24;
      if(var3) {
         if(this.field3254) {
            throw new RuntimeException();
         }

         if(this.field3256 != null) {
            int var7 = this.index;
            IndexFile var8 = this.field3256;
            FileSystem var9 = new FileSystem();
            var9.field3211 = 0;
            var9.hash = (long)var7;
            var9.field3210 = var2;
            var9.index = var8;
            var5 = class236.field3245;
            var10 = class236.field3245;
            Deque var11 = class236.field3245;
            synchronized(class236.field3245) {
               class236.field3245.method3505(var9);
            }

            var6 = class236.field3239;
            var24 = class236.field3239;
            Object var12 = class236.field3239;
            synchronized(class236.field3239) {
               if(class236.field3241 == 0) {
                  class21.field352 = new Thread(new class236());
                  class21.field352.setDaemon(true);
                  class21.field352.start();
                  class21.field352.setPriority(5);
               }

               class236.field3241 = 600;
            }
         }

         this.method3993(var2);
         this.method4101();
      } else {
         var2[var2.length - 2] = (byte)(super.archiveRevisions[var1] >> 8);
         var2[var2.length - 1] = (byte)super.archiveRevisions[var1];
         if(this.field3247 != null) {
            IndexFile var20 = this.field3247;
            FileSystem var21 = new FileSystem();
            var21.field3211 = 0;
            var21.hash = (long)var1;
            var21.field3210 = var2;
            var21.index = var20;
            Deque var22 = class236.field3245;
            var5 = class236.field3245;
            var10 = class236.field3245;
            synchronized(class236.field3245) {
               class236.field3245.method3505(var21);
            }

            Object var23 = class236.field3239;
            var6 = class236.field3239;
            var24 = class236.field3239;
            synchronized(class236.field3239) {
               if(class236.field3241 == 0) {
                  class21.field352 = new Thread(new class236());
                  class21.field352.setDaemon(true);
                  class21.field352.start();
                  class21.field352.setPriority(5);
               }

               class236.field3241 = 600;
            }

            this.field3251[var1] = true;
         }

         if(var4) {
            super.field3230[var1] = class20.method166(var2, false);
         }
      }

   }

   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3254 = false;
      this.field3249 = false;
      this.field3250 = -1;
      this.field3247 = var1;
      this.field3256 = var2;
      this.index = var3;
      this.field3249 = var6;
      int var7 = this.index;
      if(class238.field3272 != null) {
         class238.field3272.offset = var7 * 8 + 5;
         int var8 = class238.field3272.readInt();
         int var9 = class238.field3272.readInt();
         this.method4126(var8, var9);
      } else {
         class9.method52((IndexData)null, 255, 255, 0, (byte)0, true);
         class238.field3273[var7] = this;
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "801136386"
   )
   void method4126(int var1, int var2) {
      this.field3253 = var1;
      this.field3246 = var2;
      if(this.field3256 != null) {
         int var3 = this.index;
         IndexFile var4 = this.field3256;
         byte[] var5 = null;
         Deque var6 = class236.field3245;
         Deque var7 = class236.field3245;
         Deque var8 = class236.field3245;
         synchronized(class236.field3245) {
            for(FileSystem var9 = (FileSystem)class236.field3245.method3487(); var9 != null; var9 = (FileSystem)class236.field3245.method3512()) {
               if((long)var3 == var9.hash && var9.index == var4 && var9.field3211 == 0) {
                  var5 = var9.field3210;
                  break;
               }
            }
         }

         if(var5 != null) {
            this.method4100(var4, var3, var5, true);
         } else {
            byte[] var12 = var4.method2902(var3);
            this.method4100(var4, var3, var12, true);
         }
      } else {
         class9.method52(this, 255, this.index, this.field3253, (byte)0, true);
      }

   }

   static {
      field3252 = new CRC32();
   }
}
