import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class168 extends class167 {
   @ObfuscatedName("v")
   volatile boolean[] field2682;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1055842723
   )
   int field2683;
   @ObfuscatedName("g")
   class134 field2684;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1089210309
   )
   int field2685;
   @ObfuscatedName("o")
   boolean field2686 = false;
   @ObfuscatedName("w")
   class134 field2687;
   @ObfuscatedName("f")
   static CRC32 field2688 = new CRC32();
   @ObfuscatedName("k")
   volatile boolean field2689 = false;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1084644313
   )
   int field2690;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 243682121
   )
   int field2691 = -1;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      intValue = -976162419
   )
   static int field2692;

   public class168(class134 var1, class134 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2687 = var1;
      this.field2684 = var2;
      this.field2685 = var3;
      this.field2686 = var6;
      client.method263(this, this.field2685);
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "540733345"
   )
   public void method3299(int var1, int var2) {
      this.field2683 = var1;
      this.field2690 = var2;
      if(null != this.field2684) {
         class43.method900(this.field2685, this.field2684, this);
      } else {
         class22.method586(this, 255, this.field2685, this.field2683, (byte)0, true);
      }

   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "1"
   )
   public void method3300(int var1, byte[] var2, boolean var3, boolean var4) {
      if(this.field2689) {
         throw new RuntimeException();
      } else {
         if(null != this.field2684) {
            class85.method1901(this.field2685, var2, this.field2684);
         }

         this.method3256(var2);
         this.method3302();
      }
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(Lclass134;I[BZI)V",
      garbageValue = "-1037403298"
   )
   public void method3301(class134 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2684) {
         if(this.field2689) {
            throw new RuntimeException();
         }

         if(null == var3) {
            class22.method586(this, 255, this.field2685, this.field2683, (byte)0, true);
            return;
         }

         field2688.reset();
         field2688.update(var3, 0, var3.length);
         var5 = (int)field2688.getValue();
         class119 var9 = new class119(class10.method133(var3));
         int var7 = var9.method2500();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2685 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.method2505();
         }

         if(this.field2683 != var5 || var8 != this.field2690) {
            class22.method586(this, 255, this.field2685, this.field2683, (byte)0, true);
            return;
         }

         this.method3256(var3);
         this.method3302();
      } else {
         if(!var4 && this.field2691 == var2) {
            this.field2689 = true;
         }

         if(null == var3 || var3.length <= 2) {
            this.field2682[var2] = false;
            if(this.field2686 || var4) {
               class22.method586(this, this.field2685, var2, super.field2673[var2], (byte)2, var4);
            }

            return;
         }

         field2688.reset();
         field2688.update(var3, 0, var3.length - 2);
         var5 = (int)field2688.getValue();
         int var6 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(var5 != super.field2673[var2] || var6 != super.field2681[var2]) {
            this.field2682[var2] = false;
            if(this.field2686 || var4) {
               class22.method586(this, this.field2685, var2, super.field2673[var2], (byte)2, var4);
            }

            return;
         }

         this.field2682[var2] = true;
         if(var4) {
            super.field2671[var2] = class16.method185(var3, false);
         }
      }

   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1200900682"
   )
   void method3302() {
      this.field2682 = new boolean[super.field2671.length];

      int var1;
      for(var1 = 0; var1 < this.field2682.length; ++var1) {
         this.field2682[var1] = false;
      }

      if(null == this.field2687) {
         this.field2689 = true;
      } else {
         this.field2691 = -1;

         for(var1 = 0; var1 < this.field2682.length; ++var1) {
            if(super.field2667[var1] > 0) {
               class134 var2 = this.field2687;
               class169 var4 = new class169();
               var4.field2694 = 1;
               var4.field3122 = (long)var1;
               var4.field2699 = var2;
               var4.field2696 = this;
               class199 var5 = class170.field2702;
               synchronized(class170.field2702) {
                  class170.field2702.method3779(var4);
               }

               class162.method3163();
               this.field2691 = var1;
            }
         }

         if(this.field2691 == -1) {
            this.field2689 = true;
         }

      }
   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1892242410"
   )
   int method3303(int var1) {
      if(super.field2671[var1] != null) {
         return 100;
      } else if(this.field2682[var1]) {
         return 100;
      } else {
         int var3 = this.field2685;
         long var4 = (long)(var1 + (var3 << 16));
         int var2;
         if(class161.field2639 != null && class161.field2639.field3122 == var4) {
            var2 = 1 + class93.field1574.field1971 * 99 / (class93.field1574.field1973.length - class161.field2639.field2732);
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-275048557"
   )
   public int method3304() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2671.length; ++var3) {
         if(super.field2667[var3] > 0) {
            var1 += 100;
            var2 += this.method3303(var3);
         }
      }

      if(0 == var1) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "670136240"
   )
   public int method3311() {
      if(this.field2689) {
         return 100;
      } else if(null != super.field2671) {
         return 99;
      } else {
         int var2 = this.field2685;
         long var3 = (long)(16711680 + var2);
         int var1;
         if(null != class161.field2639 && var3 == class161.field2639.field3122) {
            var1 = class93.field1574.field1971 * 99 / (class93.field1574.field1973.length - class161.field2639.field2732) + 1;
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "71"
   )
   void vmethod3314(int var1) {
      if(this.field2687 != null && this.field2682 != null && this.field2682[var1]) {
         class43.method900(var1, this.field2687, this);
      } else {
         class22.method586(this, this.field2685, var1, super.field2673[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1479120725"
   )
   void vmethod3315(int var1) {
      class140.method2948(this.field2685, var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)[Lclass152;",
      garbageValue = "798010665"
   )
   public static class152[] method3331() {
      return new class152[]{class152.field2246, class152.field2249, class152.field2254, class152.field2256, class152.field2248};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1350475255"
   )
   public static void method3332() {
      class183.field2958.method3565();
      class183.field2959 = 1;
      class76.field1370 = null;
   }
}
