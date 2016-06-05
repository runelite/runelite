import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class168 extends class167 {
   @ObfuscatedName("q")
   class134 field2719;
   @ObfuscatedName("m")
   boolean field2720 = false;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 933912367
   )
   int field2721;
   @ObfuscatedName("v")
   volatile boolean field2722 = false;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1696341305
   )
   int field2723;
   @ObfuscatedName("w")
   volatile boolean[] field2724;
   @ObfuscatedName("e")
   static CRC32 field2725 = new CRC32();
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 995333023
   )
   int field2727;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 433674987
   )
   int field2728 = -1;
   @ObfuscatedName("n")
   class134 field2729;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "63"
   )
   void vmethod3306(int var1) {
      int var2 = this.field2721;
      long var3 = (long)(var1 + (var2 << 16));
      class172 var5 = (class172)class171.field2748.method3748(var3);
      if(var5 != null) {
         class171.field2747.method3831(var5);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2127739612"
   )
   void vmethod3307(int var1) {
      if(this.field2729 != null && null != this.field2724 && this.field2724[var1]) {
         class134 var2 = this.field2729;
         byte[] var4 = null;
         class199 var5 = class170.field2738;
         synchronized(class170.field2738) {
            for(class169 var6 = (class169)class170.field2738.method3797(); var6 != null; var6 = (class169)class170.field2738.method3779()) {
               if(var6.field3125 == (long)var1 && var6.field2732 == var2 && var6.field2733 == 0) {
                  var4 = var6.field2731;
                  break;
               }
            }
         }

         if(null != var4) {
            this.method3310(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.method2833(var1);
            this.method3310(var2, var1, var9, true);
         }
      } else {
         class124.method2749(this, this.field2721, var1, super.field2707[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-956529113"
   )
   void method3308(int var1, int var2) {
      this.field2723 = var1;
      this.field2727 = var2;
      if(null != this.field2719) {
         int var3 = this.field2721;
         class134 var4 = this.field2719;
         byte[] var6 = null;
         class199 var7 = class170.field2738;
         synchronized(class170.field2738) {
            for(class169 var8 = (class169)class170.field2738.method3797(); null != var8; var8 = (class169)class170.field2738.method3779()) {
               if(var8.field3125 == (long)var3 && var4 == var8.field2732 && var8.field2733 == 0) {
                  var6 = var8.field2731;
                  break;
               }
            }
         }

         if(null != var6) {
            this.method3310(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method2833(var3);
            this.method3310(var4, var3, var11, true);
         }
      } else {
         class124.method2749(this, 255, this.field2721, this.field2723, (byte)0, true);
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "1"
   )
   void method3309(int var1, byte[] var2, boolean var3, boolean var4) {
      if(this.field2722) {
         throw new RuntimeException();
      } else {
         if(null != this.field2719) {
            class169.method3331(this.field2721, var2, this.field2719);
         }

         this.method3297(var2);
         this.method3311();
      }
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(Lclass134;I[BZB)V",
      garbageValue = "-104"
   )
   void method3310(class134 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field2719 == var1) {
         if(this.field2722) {
            throw new RuntimeException();
         }

         if(null == var3) {
            class124.method2749(this, 255, this.field2721, this.field2723, (byte)0, true);
            return;
         }

         field2725.reset();
         field2725.update(var3, 0, var3.length);
         var5 = (int)field2725.getValue();
         class119 var6 = new class119(class137.method2904(var3));
         int var7 = var6.method2494();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2721 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2505();
         }

         if(this.field2723 != var5 || this.field2727 != var8) {
            class124.method2749(this, 255, this.field2721, this.field2723, (byte)0, true);
            return;
         }

         this.method3297(var3);
         this.method3311();
      } else {
         if(!var4 && this.field2728 == var2) {
            this.field2722 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field2724[var2] = false;
            if(this.field2720 || var4) {
               class124.method2749(this, this.field2721, var2, super.field2707[var2], (byte)2, var4);
            }

            return;
         }

         field2725.reset();
         field2725.update(var3, 0, var3.length - 2);
         var5 = (int)field2725.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(super.field2707[var2] != var5 || var9 != super.field2716[var2]) {
            this.field2724[var2] = false;
            if(this.field2720 || var4) {
               class124.method2749(this, this.field2721, var2, super.field2707[var2], (byte)2, var4);
            }

            return;
         }

         this.field2724[var2] = true;
         if(var4) {
            super.field2704[var2] = class111.method2388(var3, false);
         }
      }

   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "320907376"
   )
   void method3311() {
      this.field2724 = new boolean[super.field2704.length];

      int var1;
      for(var1 = 0; var1 < this.field2724.length; ++var1) {
         this.field2724[var1] = false;
      }

      if(this.field2729 == null) {
         this.field2722 = true;
      } else {
         this.field2728 = -1;

         for(var1 = 0; var1 < this.field2724.length; ++var1) {
            if(super.field2702[var1] > 0) {
               class134 var2 = this.field2729;
               class169 var4 = new class169();
               var4.field2733 = 1;
               var4.field3125 = (long)var1;
               var4.field2732 = var2;
               var4.field2734 = this;
               class199 var5 = class170.field2738;
               synchronized(class170.field2738) {
                  class170.field2738.method3771(var4);
               }

               class87.method2045();
               this.field2728 = var1;
            }
         }

         if(this.field2728 == -1) {
            this.field2722 = true;
         }

      }
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-920266520"
   )
   int method3312(int var1) {
      if(null != super.field2704[var1]) {
         return 100;
      } else if(this.field2724[var1]) {
         return 100;
      } else {
         int var3 = this.field2721;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(class171.field2759 != null && var4 == class171.field2759.field3125) {
            var2 = class141.field2201.field2000 * 99 / (class141.field2201.field2001.length - class171.field2759.field2763) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-538375483"
   )
   public int method3313() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2704.length; ++var3) {
         if(super.field2702[var3] > 0) {
            var1 += 100;
            var2 += this.method3312(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   public class168(class134 var1, class134 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2729 = var1;
      this.field2719 = var2;
      this.field2721 = var3;
      this.field2720 = var6;
      class8.method104(this, this.field2721);
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "308377886"
   )
   public int method3325() {
      if(this.field2722) {
         return 100;
      } else if(super.field2704 != null) {
         return 99;
      } else {
         int var2 = this.field2721;
         long var3 = (long)(16711680 + var2);
         int var1;
         if(null != class171.field2759 && var3 == class171.field2759.field3125) {
            var1 = class141.field2201.field2000 * 99 / (class141.field2201.field2001.length - class171.field2759.field2763) + 1;
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
