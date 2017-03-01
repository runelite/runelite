import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class184 extends class182 {
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1041509215
   )
   int field2732;
   @ObfuscatedName("u")
   class116 field2733;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -830639379
   )
   int field2734;
   @ObfuscatedName("r")
   class116 field2735;
   @ObfuscatedName("d")
   boolean field2736 = false;
   @ObfuscatedName("z")
   volatile boolean[] field2737;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1707546395
   )
   int field2738;
   @ObfuscatedName("h")
   volatile boolean field2739 = false;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -2061683423
   )
   int field2741 = -1;
   @ObfuscatedName("bm")
   static class184 field2743;
   @ObfuscatedName("t")
   static CRC32 field2745 = new CRC32();

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "3"
   )
   void vmethod3443(int var1) {
      if(null != this.field2735 && this.field2737 != null && this.field2737[var1]) {
         class8.method103(var1, this.field2735, this);
      } else {
         class44.method884(this, this.field2734, var1, super.field2712[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void vmethod3445(int var1) {
      class115.method2330(this.field2734, var1);
   }

   public class184(class116 var1, class116 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2735 = var1;
      this.field2733 = var2;
      this.field2734 = var3;
      this.field2736 = var6;
      class9.method110(this, this.field2734);
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-4"
   )
   void method3446(int var1, int var2) {
      this.field2732 = var1;
      this.field2738 = var2;
      if(this.field2733 != null) {
         class8.method103(this.field2734, this.field2733, this);
      } else {
         class44.method884(this, 255, this.field2734, this.field2732, (byte)0, true);
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "64"
   )
   void method3447(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2739) {
            throw new RuntimeException();
         }

         if(this.field2733 != null) {
            class22.method225(this.field2734, var2, this.field2733);
         }

         this.method3383(var2);
         this.method3472();
      } else {
         var2[var2.length - 2] = (byte)(super.field2711[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2711[var1];
         if(null != this.field2735) {
            class22.method225(var1, var2, this.field2735);
            this.field2737[var1] = true;
         }

         if(var4) {
            super.field2726[var1] = class112.method2183(var2, false);
         }
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(Lclass116;I[BZI)V",
      garbageValue = "768222406"
   )
   public void method3448(class116 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field2733 == var1) {
         if(this.field2739) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            class44.method884(this, 255, this.field2734, this.field2732, (byte)0, true);
            return;
         }

         field2745.reset();
         field2745.update(var3, 0, var3.length);
         var5 = (int)field2745.getValue();
         Buffer var6 = new Buffer(ScriptState.method165(var3));
         int var7 = var6.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2734 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.readInt();
         }

         if(var5 != this.field2732 || this.field2738 != var8) {
            class44.method884(this, 255, this.field2734, this.field2732, (byte)0, true);
            return;
         }

         this.method3383(var3);
         this.method3472();
      } else {
         if(!var4 && this.field2741 == var2) {
            this.field2739 = true;
         }

         if(null == var3 || var3.length <= 2) {
            this.field2737[var2] = false;
            if(this.field2736 || var4) {
               class44.method884(this, this.field2734, var2, super.field2712[var2], (byte)2, var4);
            }

            return;
         }

         field2745.reset();
         field2745.update(var3, 0, var3.length - 2);
         var5 = (int)field2745.getValue();
         int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(var5 != super.field2712[var2] || super.field2711[var2] != var9) {
            this.field2737[var2] = false;
            if(this.field2736 || var4) {
               class44.method884(this, this.field2734, var2, super.field2712[var2], (byte)2, var4);
            }

            return;
         }

         this.field2737[var2] = true;
         if(var4) {
            super.field2726[var2] = class112.method2183(var3, false);
         }
      }

   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1141451614"
   )
   int method3450(int var1) {
      return super.field2726[var1] != null?100:(this.field2737[var1]?100:class118.method2383(this.field2734, var1));
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1428464173"
   )
   public int method3451() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2726.length; ++var3) {
         if(super.field2714[var3] > 0) {
            var1 += 100;
            var2 += this.method3450(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = 100 * var2 / var1;
         return var3;
      }
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1328132739"
   )
   public int method3461() {
      if(this.field2739) {
         return 100;
      } else if(null != super.field2726) {
         return 99;
      } else {
         int var1 = class118.method2383(255, this.field2734);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-381727"
   )
   void method3472() {
      this.field2737 = new boolean[super.field2726.length];

      int var1;
      for(var1 = 0; var1 < this.field2737.length; ++var1) {
         this.field2737[var1] = false;
      }

      if(null == this.field2735) {
         this.field2739 = true;
      } else {
         this.field2741 = -1;

         for(var1 = 0; var1 < this.field2737.length; ++var1) {
            if(super.field2714[var1] > 0) {
               class116 var2 = this.field2735;
               class180 var4 = new class180();
               var4.field2695 = 1;
               var4.hash = (long)var1;
               var4.field2691 = var2;
               var4.field2692 = this;
               Deque var5 = class183.field2731;
               synchronized(class183.field2731) {
                  class183.field2731.method2511(var4);
               }

               Object var10 = class183.field2727;
               synchronized(class183.field2727) {
                  if(class183.field2729 == 0) {
                     class114.field1793.method2067(new class183(), 5);
                  }

                  class183.field2729 = 600;
               }

               this.field2741 = var1;
            }
         }

         if(this.field2741 == -1) {
            this.field2739 = true;
         }

      }
   }
}
