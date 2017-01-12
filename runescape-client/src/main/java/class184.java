import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public class class184 extends class182 {
   @ObfuscatedName("y")
   class116 field2709;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -155381539
   )
   int field2710 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 209035521
   )
   int field2711;
   @ObfuscatedName("w")
   volatile boolean field2712 = false;
   @ObfuscatedName("h")
   class116 field2713;
   @ObfuscatedName("n")
   boolean field2714 = false;
   @ObfuscatedName("b")
   static CRC32 field2715 = new CRC32();
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 605920401
   )
   int field2716;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1812026051
   )
   int field2717;
   @ObfuscatedName("o")
   volatile boolean[] field2718;

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1659166968"
   )
   public int method3355() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2699.length; ++var3) {
         if(super.field2688[var3] > 0) {
            var1 += 100;
            var2 += this.method3363(var3);
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
      signature = "(B)I",
      garbageValue = "-55"
   )
   public int method3356() {
      if(this.field2712) {
         return 100;
      } else if(super.field2699 != null) {
         return 99;
      } else {
         int var2 = this.field2711;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(class185.field2723 != null && class185.field2723.hash == var3) {
            var1 = class22.field238.offset * 99 / (class22.field238.payload.length - class185.field2723.field2677) + 1;
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1441724796"
   )
   void vmethod3358(int var1) {
      if(null != this.field2709 && this.field2718 != null && this.field2718[var1]) {
         class1.method11(var1, this.field2709, this);
      } else {
         class2.method25(this, this.field2711, var1, super.field2686[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "6"
   )
   void method3359(int var1, int var2) {
      this.field2716 = var1;
      this.field2717 = var2;
      if(null != this.field2713) {
         class1.method11(this.field2711, this.field2713, this);
      } else {
         class2.method25(this, 255, this.field2711, this.field2716, (byte)0, true);
      }

   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "1733660244"
   )
   void method3360(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2712) {
            throw new RuntimeException();
         }

         if(null != this.field2713) {
            int var5 = this.field2711;
            class116 var6 = this.field2713;
            class180 var7 = new class180();
            var7.field2673 = 0;
            var7.hash = (long)var5;
            var7.field2675 = var2;
            var7.field2670 = var6;
            Deque var8 = class183.field2705;
            synchronized(class183.field2705) {
               class183.field2705.method2394(var7);
            }

            class171.method3232();
         }

         this.method3260(var2);
         this.method3362();
      } else {
         var2[var2.length - 2] = (byte)(super.field2687[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2687[var1];
         if(null != this.field2709) {
            class116 var11 = this.field2709;
            class180 var14 = new class180();
            var14.field2673 = 0;
            var14.hash = (long)var1;
            var14.field2675 = var2;
            var14.field2670 = var11;
            Deque var15 = class183.field2705;
            synchronized(class183.field2705) {
               class183.field2705.method2394(var14);
            }

            class171.method3232();
            this.field2718[var1] = true;
         }

         if(var4) {
            super.field2699[var1] = class116.method2221(var2, false);
         }
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(Lclass116;I[BZB)V",
      garbageValue = "-53"
   )
   void method3361(class116 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field2713 == var1) {
         if(this.field2712) {
            throw new RuntimeException();
         }

         if(null == var3) {
            class2.method25(this, 255, this.field2711, this.field2716, (byte)0, true);
            return;
         }

         field2715.reset();
         field2715.update(var3, 0, var3.length);
         var5 = (int)field2715.getValue();
         Buffer var6 = new Buffer(class8.method113(var3));
         int var7 = var6.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2711 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2780();
         }

         if(var5 != this.field2716 || this.field2717 != var8) {
            class2.method25(this, 255, this.field2711, this.field2716, (byte)0, true);
            return;
         }

         this.method3260(var3);
         this.method3362();
      } else {
         if(!var4 && this.field2710 == var2) {
            this.field2712 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field2718[var2] = false;
            if(this.field2714 || var4) {
               class2.method25(this, this.field2711, var2, super.field2686[var2], (byte)2, var4);
            }

            return;
         }

         field2715.reset();
         field2715.update(var3, 0, var3.length - 2);
         var5 = (int)field2715.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(super.field2686[var2] != var5 || super.field2687[var2] != var9) {
            this.field2718[var2] = false;
            if(this.field2714 || var4) {
               class2.method25(this, this.field2711, var2, super.field2686[var2], (byte)2, var4);
            }

            return;
         }

         this.field2718[var2] = true;
         if(var4) {
            super.field2699[var2] = class116.method2221(var3, false);
         }
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1477038356"
   )
   void method3362() {
      this.field2718 = new boolean[super.field2699.length];

      int var1;
      for(var1 = 0; var1 < this.field2718.length; ++var1) {
         this.field2718[var1] = false;
      }

      if(this.field2709 == null) {
         this.field2712 = true;
      } else {
         this.field2710 = -1;

         for(var1 = 0; var1 < this.field2718.length; ++var1) {
            if(super.field2688[var1] > 0) {
               class16.method182(var1, this.field2709, this);
               this.field2710 = var1;
            }
         }

         if(this.field2710 == -1) {
            this.field2712 = true;
         }

      }
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2102609460"
   )
   int method3363(int var1) {
      if(super.field2699[var1] != null) {
         return 100;
      } else if(this.field2718[var1]) {
         return 100;
      } else {
         int var3 = this.field2711;
         long var4 = (long)(var1 + (var3 << 16));
         int var2;
         if(null != class185.field2723 && class185.field2723.hash == var4) {
            var2 = class22.field238.offset * 99 / (class22.field238.payload.length - class185.field2723.field2677) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "50383799"
   )
   void vmethod3370(int var1) {
      class143.method2679(this.field2711, var1);
   }

   public class184(class116 var1, class116 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2709 = var1;
      this.field2713 = var2;
      this.field2711 = var3;
      this.field2714 = var6;
      int var8 = this.field2711;
      if(ChatMessages.field905 != null) {
         ChatMessages.field905.offset = 5 + var8 * 8;
         int var9 = ChatMessages.field905.method2780();
         int var10 = ChatMessages.field905.method2780();
         this.method3359(var9, var10);
      } else {
         class2.method25((class184)null, 255, 255, 0, (byte)0, true);
         class185.field2738[var8] = this;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-123"
   )
   static final int method3384(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
