import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class171 extends class170 {
   @ObfuscatedName("h")
   volatile boolean field2749 = false;
   @ObfuscatedName("s")
   class137 field2750;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1268599913
   )
   int field2751;
   @ObfuscatedName("l")
   boolean field2753 = false;
   @ObfuscatedName("y")
   class137 field2754;
   @ObfuscatedName("f")
   static CRC32 field2755 = new CRC32();
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 381252953
   )
   int field2756;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1776037301
   )
   int field2757;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -788230413
   )
   int field2758 = -1;
   @ObfuscatedName("c")
   volatile boolean[] field2760;

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(Lclass137;I[BZB)V",
      garbageValue = "-49"
   )
   public void method3382(class137 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2750) {
         if(this.field2749) {
            throw new RuntimeException();
         }

         if(null == var3) {
            class34.method745(this, 255, this.field2751, this.field2756, (byte)0, true);
            return;
         }

         field2755.reset();
         field2755.update(var3, 0, var3.length);
         var5 = (int)field2755.getValue();
         Buffer var6 = new Buffer(Buffer.method2594(var3));
         int var7 = var6.method2528();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2751 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2533();
         }

         if(var5 != this.field2756 || this.field2757 != var8) {
            class34.method745(this, 255, this.field2751, this.field2756, (byte)0, true);
            return;
         }

         this.method3307(var3);
         this.method3401();
      } else {
         if(!var4 && this.field2758 == var2) {
            this.field2749 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field2760[var2] = false;
            if(this.field2753 || var4) {
               class34.method745(this, this.field2751, var2, super.field2735[var2], (byte)2, var4);
            }

            return;
         }

         field2755.reset();
         field2755.update(var3, 0, var3.length - 2);
         var5 = (int)field2755.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(super.field2735[var2] != var5 || super.field2731[var2] != var9) {
            this.field2760[var2] = false;
            if(this.field2753 || var4) {
               class34.method745(this, this.field2751, var2, super.field2735[var2], (byte)2, var4);
            }

            return;
         }

         this.field2760[var2] = true;
         if(var4) {
            super.field2737[var2] = class126.method2807(var3, false);
         }
      }

   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-39212460"
   )
   public int method3383() {
      if(this.field2749) {
         return 100;
      } else if(null != super.field2737) {
         return 99;
      } else {
         int var2 = this.field2751;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(GroundObject.field1677 != null && var3 == GroundObject.field1677.hash) {
            var1 = 1 + class117.field2050.offset * 99 / (class117.field2050.payload.length - GroundObject.field1677.field2802);
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1418501113"
   )
   void vmethod3384(int var1) {
      int var2 = this.field2751;
      long var3 = (long)(var1 + (var2 << 16));
      class175 var5 = (class175)class174.field2787.method3817(var3);
      if(var5 != null) {
         class174.field2780.method3926(var5);
      }

   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "2110382892"
   )
   public void method3387(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2749) {
            throw new RuntimeException();
         }

         if(this.field2750 != null) {
            class156.method3201(this.field2751, var2, this.field2750);
         }

         this.method3307(var2);
         this.method3401();
      } else {
         var2[var2.length - 2] = (byte)(super.field2731[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2731[var1];
         if(this.field2754 != null) {
            class156.method3201(var1, var2, this.field2754);
            this.field2760[var1] = true;
         }

         if(var4) {
            super.field2737[var1] = class126.method2807(var2, false);
         }
      }

   }

   public class171(class137 var1, class137 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2754 = var1;
      this.field2750 = var2;
      this.field2751 = var3;
      this.field2753 = var6;
      class124.method2779(this, this.field2751);
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "902179790"
   )
   int method3389(int var1) {
      if(super.field2737[var1] != null) {
         return 100;
      } else if(this.field2760[var1]) {
         return 100;
      } else {
         int var3 = this.field2751;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(null != GroundObject.field1677 && GroundObject.field1677.hash == var4) {
            var2 = 1 + class117.field2050.offset * 99 / (class117.field2050.payload.length - GroundObject.field1677.field2802);
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1481889899"
   )
   public int method3390() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2737.length; ++var3) {
         if(super.field2741[var3] > 0) {
            var1 += 100;
            var2 += this.method3389(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-74"
   )
   public void method3397(int var1, int var2) {
      this.field2756 = var1;
      this.field2757 = var2;
      if(this.field2750 != null) {
         int var3 = this.field2751;
         class137 var4 = this.field2750;
         byte[] var6 = null;
         Deque var7 = class173.field2774;
         synchronized(class173.field2774) {
            for(class172 var8 = (class172)class173.field2774.method3854(); var8 != null; var8 = (class172)class173.field2774.method3869()) {
               if((long)var3 == var8.hash && var8.field2763 == var4 && var8.field2767 == 0) {
                  var6 = var8.field2762;
                  break;
               }
            }
         }

         if(null != var6) {
            this.method3382(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method2903(var3);
            this.method3382(var4, var3, var11, true);
         }
      } else {
         class34.method745(this, 255, this.field2751, this.field2756, (byte)0, true);
      }

   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1915524212"
   )
   void method3401() {
      this.field2760 = new boolean[super.field2737.length];

      int var1;
      for(var1 = 0; var1 < this.field2760.length; ++var1) {
         this.field2760[var1] = false;
      }

      if(null == this.field2754) {
         this.field2749 = true;
      } else {
         this.field2758 = -1;

         for(var1 = 0; var1 < this.field2760.length; ++var1) {
            if(super.field2741[var1] > 0) {
               class137 var2 = this.field2754;
               class172 var4 = new class172();
               var4.field2767 = 1;
               var4.hash = (long)var1;
               var4.field2763 = var2;
               var4.field2768 = this;
               Deque var5 = class173.field2774;
               synchronized(class173.field2774) {
                  class173.field2774.method3849(var4);
               }

               class165.method3239();
               this.field2758 = var1;
            }
         }

         if(this.field2758 == -1) {
            this.field2749 = true;
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-800410959"
   )
   void vmethod3406(int var1) {
      if(this.field2754 != null && null != this.field2760 && this.field2760[var1]) {
         class137 var2 = this.field2754;
         byte[] var4 = null;
         Deque var5 = class173.field2774;
         synchronized(class173.field2774) {
            for(class172 var6 = (class172)class173.field2774.method3854(); null != var6; var6 = (class172)class173.field2774.method3869()) {
               if(var6.hash == (long)var1 && var2 == var6.field2763 && var6.field2767 == 0) {
                  var4 = var6.field2762;
                  break;
               }
            }
         }

         if(null != var4) {
            this.method3382(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.method2903(var1);
            this.method3382(var2, var1, var9, true);
         }
      } else {
         class34.method745(this, this.field2751, var1, super.field2735[var1], (byte)2, true);
      }

   }
}
