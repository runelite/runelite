import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
public class class184 extends class182 {
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 2009948335
   )
   static int field2716;
   @ObfuscatedName("u")
   class116 field2717;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1412861771
   )
   int field2718;
   @ObfuscatedName("z")
   class116 field2719;
   @ObfuscatedName("e")
   boolean field2720 = false;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 767997907
   )
   int field2721;
   @ObfuscatedName("x")
   static CRC32 field2722 = new CRC32();
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 282033469
   )
   int field2723;
   @ObfuscatedName("m")
   volatile boolean field2725 = false;
   @ObfuscatedName("l")
   volatile boolean[] field2726;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1113634517
   )
   int field2727 = -1;

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1929474501"
   )
   public int method3364() {
      if(this.field2725) {
         return 100;
      } else if(null != super.field2703) {
         return 99;
      } else {
         int var1 = class104.method1975(255, this.field2718);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1719871487"
   )
   void vmethod3365(int var1) {
      class104.method1991(this.field2718, var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-832673040"
   )
   void vmethod3366(int var1) {
      if(this.field2719 != null && this.field2726 != null && this.field2726[var1]) {
         class15.method194(var1, this.field2719, this);
      } else {
         Ignore.method204(this, this.field2718, var1, super.field2699[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "8"
   )
   void method3367(int var1, int var2) {
      this.field2723 = var1;
      this.field2721 = var2;
      if(this.field2717 != null) {
         class15.method194(this.field2718, this.field2717, this);
      } else {
         Ignore.method204(this, 255, this.field2718, this.field2723, (byte)0, true);
      }

   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "1961734730"
   )
   void method3368(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2725) {
            throw new RuntimeException();
         }

         if(null != this.field2717) {
            class22.method225(this.field2718, var2, this.field2717);
         }

         this.method3271(var2);
         this.method3377();
      } else {
         var2[var2.length - 2] = (byte)(super.field2698[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2698[var1];
         if(null != this.field2719) {
            class22.method225(var1, var2, this.field2719);
            this.field2726[var1] = true;
         }

         if(var4) {
            super.field2703[var1] = class10.method125(var2, false);
         }
      }

   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1636974272"
   )
   int method3369(int var1) {
      return super.field2703[var1] != null?100:(this.field2726[var1]?100:class104.method1975(this.field2718, var1));
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1760756166"
   )
   public int method3372() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2703.length; ++var3) {
         if(super.field2694[var3] > 0) {
            var1 += 100;
            var2 += this.method3369(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   public class184(class116 var1, class116 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2719 = var1;
      this.field2717 = var2;
      this.field2718 = var3;
      this.field2720 = var6;
      int var8 = this.field2718;
      if(null != CombatInfoListHolder.field754) {
         CombatInfoListHolder.field754.offset = 5 + 8 * var8;
         int var9 = CombatInfoListHolder.field754.method3062();
         int var10 = CombatInfoListHolder.field754.method3062();
         this.method3367(var9, var10);
      } else {
         Ignore.method204((class184)null, 255, 255, 0, (byte)0, true);
         class185.field2743[var8] = this;
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1638258595"
   )
   void method3377() {
      this.field2726 = new boolean[super.field2703.length];

      int var1;
      for(var1 = 0; var1 < this.field2726.length; ++var1) {
         this.field2726[var1] = false;
      }

      if(null == this.field2719) {
         this.field2725 = true;
      } else {
         this.field2727 = -1;

         for(var1 = 0; var1 < this.field2726.length; ++var1) {
            if(super.field2694[var1] > 0) {
               class116 var2 = this.field2719;
               class180 var4 = new class180();
               var4.field2685 = 1;
               var4.hash = (long)var1;
               var4.field2683 = var2;
               var4.field2681 = this;
               Deque var5 = class183.field2714;
               synchronized(class183.field2714) {
                  class183.field2714.method2380(var4);
               }

               Object var10 = class183.field2712;
               synchronized(class183.field2712) {
                  if(class183.field2715 == 0) {
                     class63.field1093.method1945(new class183(), 5);
                  }

                  class183.field2715 = 600;
               }

               this.field2727 = var1;
            }
         }

         if(this.field2727 == -1) {
            this.field2725 = true;
         }

      }
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(Lclass116;I[BZB)V",
      garbageValue = "-6"
   )
   void method3387(class116 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field2717 == var1) {
         if(this.field2725) {
            throw new RuntimeException();
         }

         if(null == var3) {
            Ignore.method204(this, 255, this.field2718, this.field2723, (byte)0, true);
            return;
         }

         field2722.reset();
         field2722.update(var3, 0, var3.length);
         var5 = (int)field2722.getValue();
         Buffer var6 = new Buffer(class103.method1967(var3));
         int var7 = var6.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2718 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method3062();
         }

         if(this.field2723 != var5 || var8 != this.field2721) {
            Ignore.method204(this, 255, this.field2718, this.field2723, (byte)0, true);
            return;
         }

         this.method3271(var3);
         this.method3377();
      } else {
         if(!var4 && this.field2727 == var2) {
            this.field2725 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field2726[var2] = false;
            if(this.field2720 || var4) {
               Ignore.method204(this, this.field2718, var2, super.field2699[var2], (byte)2, var4);
            }

            return;
         }

         field2722.reset();
         field2722.update(var3, 0, var3.length - 2);
         var5 = (int)field2722.getValue();
         int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(var5 != super.field2699[var2] || var9 != super.field2698[var2]) {
            this.field2726[var2] = false;
            if(this.field2720 || var4) {
               Ignore.method204(this, this.field2718, var2, super.field2699[var2], (byte)2, var4);
            }

            return;
         }

         this.field2726[var2] = true;
         if(var4) {
            super.field2703[var2] = class10.method125(var3, false);
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass152;I)V",
      garbageValue = "1160362540"
   )
   public static void method3393(class152 var0) {
      class210.field3110 = var0;
   }
}
