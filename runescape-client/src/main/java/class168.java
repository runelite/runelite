import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class168 extends class167 {
   @ObfuscatedName("f")
   class134 field2682;
   @ObfuscatedName("m")
   volatile boolean field2683 = false;
   @ObfuscatedName("e")
   static CRC32 field2684 = new CRC32();
   @ObfuscatedName("s")
   boolean field2685 = false;
   @ObfuscatedName("a")
   class134 field2686;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -158715729
   )
   int field2687;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -938492281
   )
   int field2688;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 2091091635
   )
   int field2689;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1561407451
   )
   int field2690 = -1;
   @ObfuscatedName("i")
   volatile boolean[] field2691;
   @ObfuscatedName("bp")
   static class168 field2692;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1806686967"
   )
   void vmethod3346(int var1) {
      if(this.field2686 != null && this.field2691 != null && this.field2691[var1]) {
         class134 var2 = this.field2686;
         byte[] var4 = null;
         class199 var5 = class170.field2704;
         synchronized(class170.field2704) {
            for(class169 var6 = (class169)class170.field2704.method3844(); var6 != null; var6 = (class169)class170.field2704.method3834()) {
               if(var6.field3113 == (long)var1 && var2 == var6.field2695 && var6.field2698 == 0) {
                  var4 = var6.field2694;
                  break;
               }
            }
         }

         if(null != var4) {
            this.method3356(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.method2902(var1);
            this.method3356(var2, var1, var9, true);
         }
      } else {
         class121.method2779(this, this.field2687, var1, super.field2667[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "885790446"
   )
   public int method3347() {
      if(this.field2683) {
         return 100;
      } else if(null != super.field2663) {
         return 99;
      } else {
         int var2 = this.field2687;
         long var3 = (long)(16711680 + var2);
         int var1;
         if(null != class137.field2099 && var3 == class137.field2099.field3113) {
            var1 = class75.field1348.field1976 * 99 / (class75.field1348.field1982.length - class137.field2099.field2734) + 1;
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

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-629899309"
   )
   void method3348(int var1, int var2) {
      this.field2688 = var1;
      this.field2689 = var2;
      if(this.field2682 != null) {
         int var3 = this.field2687;
         class134 var4 = this.field2682;
         byte[] var6 = null;
         class199 var7 = class170.field2704;
         synchronized(class170.field2704) {
            for(class169 var8 = (class169)class170.field2704.method3844(); null != var8; var8 = (class169)class170.field2704.method3834()) {
               if(var8.field3113 == (long)var3 && var4 == var8.field2695 && var8.field2698 == 0) {
                  var6 = var8.field2694;
                  break;
               }
            }
         }

         if(var6 != null) {
            this.method3356(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method2902(var3);
            this.method3356(var4, var3, var11, true);
         }
      } else {
         class121.method2779(this, 255, this.field2687, this.field2688, (byte)0, true);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-148634981"
   )
   void vmethod3350(int var1) {
      int var2 = this.field2687;
      long var3 = (long)((var2 << 16) + var1);
      class172 var5 = (class172)class171.field2715.method3807(var3);
      if(var5 != null) {
         class171.field2728.method3880(var5);
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "1"
   )
   void method3351(int var1, byte[] var2, boolean var3, boolean var4) {
      if(this.field2683) {
         throw new RuntimeException();
      } else {
         if(null != this.field2682) {
            int var5 = this.field2687;
            class134 var6 = this.field2682;
            class169 var7 = new class169();
            var7.field2698 = 0;
            var7.field3113 = (long)var5;
            var7.field2694 = var2;
            var7.field2695 = var6;
            class199 var8 = class170.field2704;
            synchronized(class170.field2704) {
               class170.field2704.method3819(var7);
            }

            Object var13 = class170.field2706;
            synchronized(class170.field2706) {
               if(class170.field2701 == 0) {
                  class40.field924.method2917(new class170(), 5);
               }

               class170.field2701 = 600;
            }
         }

         this.method3324(var2);
         this.method3353();
      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1101531172"
   )
   void method3353() {
      this.field2691 = new boolean[super.field2663.length];

      int var1;
      for(var1 = 0; var1 < this.field2691.length; ++var1) {
         this.field2691[var1] = false;
      }

      if(this.field2686 == null) {
         this.field2683 = true;
      } else {
         this.field2690 = -1;

         for(var1 = 0; var1 < this.field2691.length; ++var1) {
            if(super.field2673[var1] > 0) {
               class134 var2 = this.field2686;
               class169 var4 = new class169();
               var4.field2698 = 1;
               var4.field3113 = (long)var1;
               var4.field2695 = var2;
               var4.field2693 = this;
               class199 var5 = class170.field2704;
               synchronized(class170.field2704) {
                  class170.field2704.method3819(var4);
               }

               class158.method3183();
               this.field2690 = var1;
            }
         }

         if(this.field2690 == -1) {
            this.field2683 = true;
         }

      }
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "755"
   )
   int method3354(int var1) {
      if(null != super.field2663[var1]) {
         return 100;
      } else if(this.field2691[var1]) {
         return 100;
      } else {
         int var3 = this.field2687;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(class137.field2099 != null && var4 == class137.field2099.field3113) {
            var2 = 1 + class75.field1348.field1976 * 99 / (class75.field1348.field1982.length - class137.field2099.field2734);
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1145832708"
   )
   public int method3355() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2663.length; ++var3) {
         if(super.field2673[var3] > 0) {
            var1 += 100;
            var2 += this.method3354(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = 100 * var2 / var1;
         return var3;
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(Lclass134;I[BZB)V",
      garbageValue = "0"
   )
   public void method3356(class134 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field2682 == var1) {
         if(this.field2683) {
            throw new RuntimeException();
         }

         if(null == var3) {
            class121.method2779(this, 255, this.field2687, this.field2688, (byte)0, true);
            return;
         }

         field2684.reset();
         field2684.update(var3, 0, var3.length);
         var5 = (int)field2684.getValue();
         class119 var6 = new class119(class116.method2460(var3));
         int var7 = var6.method2514();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2687 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2519();
         }

         if(var5 != this.field2688 || this.field2689 != var8) {
            class121.method2779(this, 255, this.field2687, this.field2688, (byte)0, true);
            return;
         }

         this.method3324(var3);
         this.method3353();
      } else {
         if(!var4 && this.field2690 == var2) {
            this.field2683 = true;
         }

         if(null == var3 || var3.length <= 2) {
            this.field2691[var2] = false;
            if(this.field2685 || var4) {
               class121.method2779(this, this.field2687, var2, super.field2667[var2], (byte)2, var4);
            }

            return;
         }

         field2684.reset();
         field2684.update(var3, 0, var3.length - 2);
         var5 = (int)field2684.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(var5 != super.field2667[var2] || var9 != super.field2668[var2]) {
            this.field2691[var2] = false;
            if(this.field2685 || var4) {
               class121.method2779(this, this.field2687, var2, super.field2667[var2], (byte)2, var4);
            }

            return;
         }

         this.field2691[var2] = true;
         if(var4) {
            super.field2663[var2] = class109.method2426(var3, false);
         }
      }

   }

   public class168(class134 var1, class134 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2686 = var1;
      this.field2682 = var2;
      this.field2687 = var3;
      this.field2685 = var6;
      int var8 = this.field2687;
      if(null != class14.field214) {
         class14.field214.field1976 = 5 + var8 * 8;
         int var9 = class14.field214.method2519();
         int var10 = class14.field214.method2519();
         this.method3348(var9, var10);
      } else {
         class121.method2779((class168)null, 255, 255, 0, (byte)0, true);
         class171.field2723[var8] = this;
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "30"
   )
   static final void method3374(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < client.field490; ++var4) {
         if(client.field495[var4] + client.field497[var4] > var0 && client.field495[var4] < var2 + var0 && client.field496[var4] + client.field498[var4] > var1 && client.field496[var4] < var1 + var3) {
            client.field507[var4] = true;
         }
      }

   }
}
