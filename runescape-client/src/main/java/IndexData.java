import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("IndexData")
public class IndexData extends IndexDataBase {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -869539341
   )
   @Export("index")
   int index;
   @ObfuscatedName("w")
   volatile boolean field3231;
   @ObfuscatedName("f")
   boolean field3232;
   @ObfuscatedName("c")
   volatile boolean[] field3233;
   @ObfuscatedName("z")
   static CRC32 field3234;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 179159679
   )
   int field3235;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1366492005
   )
   int field3236;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -337929601
   )
   int field3237;
   @ObfuscatedName("s")
   IndexFile field3238;
   @ObfuscatedName("n")
   IndexFile field3239;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   void vmethod4288(int var1) {
      class1.method1(this.index, var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1860501882"
   )
   int vmethod4290(int var1) {
      if(super.field3209[var1] != null) {
         return 100;
      } else if(this.field3233[var1]) {
         return 100;
      } else {
         int var3 = this.index;
         long var4 = (long)(var1 + (var3 << 16));
         int var2;
         if(class56.field674 != null && class56.field674.hash == var4) {
            var2 = class24.field362.offset * 99 / (class24.field362.payload.length - class56.field674.field3198) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "559698349"
   )
   void vmethod4291(int var1) {
      if(this.field3238 != null && this.field3233 != null && this.field3233[var1]) {
         class43.method637(var1, this.field3238, this);
      } else {
         Widget.method4047(this, this.index, var1, super.field3207[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "-1692191651"
   )
   void method4293(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field3231) {
            throw new RuntimeException();
         }

         if(this.field3239 != null) {
            int var5 = this.index;
            IndexFile var6 = this.field3239;
            class233 var7 = new class233();
            var7.field3190 = 0;
            var7.hash = (long)var5;
            var7.field3191 = var2;
            var7.field3192 = var6;
            Deque var8 = class236.field3226;
            synchronized(class236.field3226) {
               class236.field3226.method3655(var7);
            }

            class172.method3183();
         }

         this.method4172(var2);
         this.method4295();
      } else {
         var2[var2.length - 2] = (byte)(super.field3208[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field3208[var1];
         if(this.field3238 != null) {
            IndexFile var11 = this.field3238;
            class233 var14 = new class233();
            var14.field3190 = 0;
            var14.hash = (long)var1;
            var14.field3191 = var2;
            var14.field3192 = var11;
            Deque var15 = class236.field3226;
            synchronized(class236.field3226) {
               class236.field3226.method3655(var14);
            }

            class172.method3183();
            this.field3233[var1] = true;
         }

         if(var4) {
            super.field3209[var1] = class38.method538(var2, false);
         }
      }

   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "477309178"
   )
   void method4295() {
      this.field3233 = new boolean[super.field3209.length];

      int var1;
      for(var1 = 0; var1 < this.field3233.length; ++var1) {
         this.field3233[var1] = false;
      }

      if(this.field3238 == null) {
         this.field3231 = true;
      } else {
         this.field3237 = -1;

         for(var1 = 0; var1 < this.field3233.length; ++var1) {
            if(super.field3219[var1] > 0) {
               CollisionData.method3103(var1, this.field3238, this);
               this.field3237 = var1;
            }
         }

         if(this.field3237 == -1) {
            this.field3231 = true;
         }

      }
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1855824534"
   )
   public int method4296() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field3209.length; ++var3) {
         if(super.field3219[var3] > 0) {
            var1 += 100;
            var2 += this.vmethod4290(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(LIndexFile;I[BZI)V",
      garbageValue = "1391869610"
   )
   void method4297(IndexFile var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field3239) {
         if(this.field3231) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            Widget.method4047(this, 255, this.index, this.field3235, (byte)0, true);
            return;
         }

         field3234.reset();
         field3234.update(var3, 0, var3.length);
         var5 = (int)field3234.getValue();
         Buffer var6 = new Buffer(class22.method158(var3));
         int var7 = var6.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.index + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.readInt();
         }

         if(var5 != this.field3235 || this.field3236 != var8) {
            Widget.method4047(this, 255, this.index, this.field3235, (byte)0, true);
            return;
         }

         this.method4172(var3);
         this.method4295();
      } else {
         if(!var4 && var2 == this.field3237) {
            this.field3231 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field3233[var2] = false;
            if(this.field3232 || var4) {
               Widget.method4047(this, this.index, var2, super.field3207[var2], (byte)2, var4);
            }

            return;
         }

         field3234.reset();
         field3234.update(var3, 0, var3.length - 2);
         var5 = (int)field3234.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(super.field3207[var2] != var5 || super.field3208[var2] != var9) {
            this.field3233[var2] = false;
            if(this.field3232 || var4) {
               Widget.method4047(this, this.index, var2, super.field3207[var2], (byte)2, var4);
            }

            return;
         }

         this.field3233[var2] = true;
         if(var4) {
            super.field3209[var2] = class38.method538(var3, false);
         }
      }

   }

   static {
      field3234 = new CRC32();
   }

   public IndexData(IndexFile var1, IndexFile var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field3231 = false;
      this.field3232 = false;
      this.field3237 = -1;
      this.field3238 = var1;
      this.field3239 = var2;
      this.index = var3;
      this.field3232 = var6;
      int var8 = this.index;
      if(class241.field3274 != null) {
         class241.field3274.offset = var8 * 8 + 5;
         int var9 = class241.field3274.readInt();
         int var10 = class241.field3274.readInt();
         this.method4303(var9, var10);
      } else {
         Widget.method4047((IndexData)null, 255, 255, 0, (byte)0, true);
         class238.field3253[var8] = this;
      }

   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-885948104"
   )
   void method4303(int var1, int var2) {
      this.field3235 = var1;
      this.field3236 = var2;
      if(this.field3239 != null) {
         class43.method637(this.index, this.field3239, this);
      } else {
         Widget.method4047(this, 255, this.index, this.field3235, (byte)0, true);
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1038988079"
   )
   public int method4320() {
      if(this.field3231) {
         return 100;
      } else if(super.field3209 != null) {
         return 99;
      } else {
         int var2 = this.index;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(class56.field674 != null && var3 == class56.field674.hash) {
            var1 = class24.field362.offset * 99 / (class24.field362.payload.length - class56.field674.field3198) + 1;
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
}
