import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class171 extends class170 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 633463569
   )
   int field2735;
   @ObfuscatedName("t")
   volatile boolean[] field2736;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1206275789
   )
   int field2737;
   @ObfuscatedName("x")
   volatile boolean field2738 = false;
   @ObfuscatedName("n")
   class137 field2739;
   @ObfuscatedName("d")
   boolean field2740 = false;
   @ObfuscatedName("o")
   static CRC32 field2741 = new CRC32();
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 364591213
   )
   int field2742;
   @ObfuscatedName("a")
   class137 field2743;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1910900573
   )
   int field2744 = -1;

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-223289306"
   )
   public int method3365() {
      if(this.field2738) {
         return 100;
      } else if(super.field2726 != null) {
         return 99;
      } else {
         int var2 = this.field2735;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(class221.field3215 != null && var3 == class221.field3215.hash) {
            var1 = 1 + class18.field261.offset * 99 / (class18.field261.payload.length - class221.field3215.field2784);
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "974604139"
   )
   void vmethod3366(int var1) {
      int var2 = this.field2735;
      long var3 = (long)(var1 + (var2 << 16));
      class175 var5 = (class175)class174.field2768.method3828(var3);
      if(null != var5) {
         class174.field2767.method3916(var5);
      }

   }

   public class171(class137 var1, class137 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2743 = var1;
      this.field2739 = var2;
      this.field2735 = var3;
      this.field2740 = var6;
      int var8 = this.field2735;
      if(null != class31.field719) {
         class31.field719.offset = 5 + 8 * var8;
         int var9 = class31.field719.method2576();
         int var10 = class31.field719.method2576();
         this.method3367(var9, var10);
      } else {
         FrameMap.method2355((class171)null, 255, 255, 0, (byte)0, true);
         class174.field2781[var8] = this;
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "380539394"
   )
   void method3367(int var1, int var2) {
      this.field2742 = var1;
      this.field2737 = var2;
      if(null != this.field2739) {
         NPCComposition.method832(this.field2735, this.field2739, this);
      } else {
         FrameMap.method2355(this, 255, this.field2735, this.field2742, (byte)0, true);
      }

   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(Lclass137;I[BZI)V",
      garbageValue = "-241295795"
   )
   public void method3368(class137 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field2739 == var1) {
         if(this.field2738) {
            throw new RuntimeException();
         }

         if(null == var3) {
            FrameMap.method2355(this, 255, this.field2735, this.field2742, (byte)0, true);
            return;
         }

         field2741.reset();
         field2741.update(var3, 0, var3.length);
         var5 = (int)field2741.getValue();
         Buffer var6 = new Buffer(DecorativeObject.method2239(var3));
         int var7 = var6.method2571();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2735 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2576();
         }

         if(this.field2742 != var5 || var8 != this.field2737) {
            FrameMap.method2355(this, 255, this.field2735, this.field2742, (byte)0, true);
            return;
         }

         this.method3278(var3);
         this.method3370();
      } else {
         if(!var4 && var2 == this.field2744) {
            this.field2738 = true;
         }

         if(null == var3 || var3.length <= 2) {
            this.field2736[var2] = false;
            if(this.field2740 || var4) {
               FrameMap.method2355(this, this.field2735, var2, super.field2720[var2], (byte)2, var4);
            }

            return;
         }

         field2741.reset();
         field2741.update(var3, 0, var3.length - 2);
         var5 = (int)field2741.getValue();
         int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(super.field2720[var2] != var5 || var9 != super.field2722[var2]) {
            this.field2736[var2] = false;
            if(this.field2740 || var4) {
               FrameMap.method2355(this, this.field2735, var2, super.field2720[var2], (byte)2, var4);
            }

            return;
         }

         this.field2736[var2] = true;
         if(var4) {
            super.field2726[var2] = class48.method1001(var3, false);
         }
      }

   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1218271341"
   )
   void method3370() {
      this.field2736 = new boolean[super.field2726.length];

      int var1;
      for(var1 = 0; var1 < this.field2736.length; ++var1) {
         this.field2736[var1] = false;
      }

      if(null == this.field2743) {
         this.field2738 = true;
      } else {
         this.field2744 = -1;

         for(var1 = 0; var1 < this.field2736.length; ++var1) {
            if(super.field2716[var1] > 0) {
               class137 var2 = this.field2743;
               class172 var4 = new class172();
               var4.field2749 = 1;
               var4.hash = (long)var1;
               var4.field2748 = var2;
               var4.field2750 = this;
               Deque var5 = class173.field2759;
               synchronized(class173.field2759) {
                  class173.field2759.method3844(var4);
               }

               class193.method3776();
               this.field2744 = var1;
            }
         }

         if(this.field2744 == -1) {
            this.field2738 = true;
         }

      }
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2074210940"
   )
   public int method3376() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2726.length; ++var3) {
         if(super.field2716[var3] > 0) {
            var1 += 100;
            var2 += this.method3377(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-128"
   )
   int method3377(int var1) {
      if(null != super.field2726[var1]) {
         return 100;
      } else if(this.field2736[var1]) {
         return 100;
      } else {
         int var3 = this.field2735;
         long var4 = (long)(var1 + (var3 << 16));
         int var2;
         if(null != class221.field3215 && var4 == class221.field3215.hash) {
            var2 = 1 + class18.field261.offset * 99 / (class18.field261.payload.length - class221.field3215.field2784);
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1885427498"
   )
   void vmethod3383(int var1) {
      if(this.field2743 != null && null != this.field2736 && this.field2736[var1]) {
         NPCComposition.method832(var1, this.field2743, this);
      } else {
         FrameMap.method2355(this, this.field2735, var1, super.field2720[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "2030914166"
   )
   void method3390(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2738) {
            throw new RuntimeException();
         }

         if(null != this.field2739) {
            int var5 = this.field2735;
            class137 var6 = this.field2739;
            class172 var7 = new class172();
            var7.field2749 = 0;
            var7.hash = (long)var5;
            var7.field2747 = var2;
            var7.field2748 = var6;
            Deque var8 = class173.field2759;
            synchronized(class173.field2759) {
               class173.field2759.method3844(var7);
            }

            class193.method3776();
         }

         this.method3278(var2);
         this.method3370();
      } else {
         var2[var2.length - 2] = (byte)(super.field2722[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2722[var1];
         if(this.field2743 != null) {
            class137 var11 = this.field2743;
            class172 var14 = new class172();
            var14.field2749 = 0;
            var14.hash = (long)var1;
            var14.field2747 = var2;
            var14.field2748 = var11;
            Deque var15 = class173.field2759;
            synchronized(class173.field2759) {
               class173.field2759.method3844(var14);
            }

            class193.method3776();
            this.field2736[var1] = true;
         }

         if(var4) {
            super.field2726[var1] = class48.method1001(var2, false);
         }
      }

   }
}
