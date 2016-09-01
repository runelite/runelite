import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class171 extends class170 {
   @ObfuscatedName("ih")
   @ObfuscatedGetter(
      intValue = 1283559201
   )
   static int field2749;
   @ObfuscatedName("c")
   class137 field2750;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1610910461
   )
   int field2751;
   @ObfuscatedName("w")
   volatile boolean[] field2752;
   @ObfuscatedName("e")
   class137 field2753;
   @ObfuscatedName("k")
   boolean field2754 = false;
   @ObfuscatedName("o")
   static CRC32 field2755 = new CRC32();
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1325419923
   )
   int field2756;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -942023729
   )
   int field2757;
   @ObfuscatedName("y")
   volatile boolean field2758 = false;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 625018701
   )
   int field2761 = -1;

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2008370911"
   )
   public int method3363() {
      if(this.field2758) {
         return 100;
      } else if(null != super.field2737) {
         return 99;
      } else {
         int var2 = this.field2751;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(class85.field1465 != null && class85.field1465.hash == var3) {
            var1 = 1 + XClanMember.field630.offset * 99 / (XClanMember.field630.payload.length - class85.field1465.field2801);
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-122"
   )
   void vmethod3364(int var1) {
      WallObject.method2121(this.field2751, var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-476485243"
   )
   void vmethod3365(int var1) {
      if(this.field2753 != null && null != this.field2752 && this.field2752[var1]) {
         class164.method3221(var1, this.field2753, this);
      } else {
         DecorativeObject.method2221(this, this.field2751, var1, super.field2733[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1104913993"
   )
   public void method3366(int var1, int var2) {
      this.field2756 = var1;
      this.field2757 = var2;
      if(null != this.field2750) {
         class164.method3221(this.field2751, this.field2750, this);
      } else {
         DecorativeObject.method2221(this, 255, this.field2751, this.field2756, (byte)0, true);
      }

   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "-956505070"
   )
   public void method3367(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2758) {
            throw new RuntimeException();
         }

         if(this.field2750 != null) {
            VertexNormal.method2254(this.field2751, var2, this.field2750);
         }

         this.method3304(var2);
         this.method3372();
      } else {
         var2[var2.length - 2] = (byte)(super.field2740[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2740[var1];
         if(this.field2753 != null) {
            VertexNormal.method2254(var1, var2, this.field2753);
            this.field2752[var1] = true;
         }

         if(var4) {
            super.field2737[var1] = class45.method919(var2, false);
         }
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(Lclass137;I[BZB)V",
      garbageValue = "12"
   )
   void method3368(class137 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field2750 == var1) {
         if(this.field2758) {
            throw new RuntimeException();
         }

         if(null == var3) {
            DecorativeObject.method2221(this, 255, this.field2751, this.field2756, (byte)0, true);
            return;
         }

         field2755.reset();
         field2755.update(var3, 0, var3.length);
         var5 = (int)field2755.getValue();
         Buffer var6 = new Buffer(class54.method1096(var3));
         int var7 = var6.method2556();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2751 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2561();
         }

         if(var5 != this.field2756 || var8 != this.field2757) {
            DecorativeObject.method2221(this, 255, this.field2751, this.field2756, (byte)0, true);
            return;
         }

         this.method3304(var3);
         this.method3372();
      } else {
         if(!var4 && var2 == this.field2761) {
            this.field2758 = true;
         }

         if(null == var3 || var3.length <= 2) {
            this.field2752[var2] = false;
            if(this.field2754 || var4) {
               DecorativeObject.method2221(this, this.field2751, var2, super.field2733[var2], (byte)2, var4);
            }

            return;
         }

         field2755.reset();
         field2755.update(var3, 0, var3.length - 2);
         var5 = (int)field2755.getValue();
         int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(var5 != super.field2733[var2] || var9 != super.field2740[var2]) {
            this.field2752[var2] = false;
            if(this.field2754 || var4) {
               DecorativeObject.method2221(this, this.field2751, var2, super.field2733[var2], (byte)2, var4);
            }

            return;
         }

         this.field2752[var2] = true;
         if(var4) {
            super.field2737[var2] = class45.method919(var3, false);
         }
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "24"
   )
   int method3370(int var1) {
      if(null != super.field2737[var1]) {
         return 100;
      } else if(this.field2752[var1]) {
         return 100;
      } else {
         int var3 = this.field2751;
         long var4 = (long)((var3 << 16) + var1);
         int var2;
         if(class85.field1465 != null && class85.field1465.hash == var4) {
            var2 = 1 + XClanMember.field630.offset * 99 / (XClanMember.field630.payload.length - class85.field1465.field2801);
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-385497399"
   )
   public int method3371() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2737.length; ++var3) {
         if(super.field2735[var3] > 0) {
            var1 += 100;
            var2 += this.method3370(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = 100 * var2 / var1;
         return var3;
      }
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   void method3372() {
      this.field2752 = new boolean[super.field2737.length];

      int var1;
      for(var1 = 0; var1 < this.field2752.length; ++var1) {
         this.field2752[var1] = false;
      }

      if(null == this.field2753) {
         this.field2758 = true;
      } else {
         this.field2761 = -1;

         for(var1 = 0; var1 < this.field2752.length; ++var1) {
            if(super.field2735[var1] > 0) {
               class137 var2 = this.field2753;
               class172 var4 = new class172();
               var4.field2764 = 1;
               var4.hash = (long)var1;
               var4.field2762 = var2;
               var4.field2765 = this;
               Deque var5 = class173.field2769;
               synchronized(class173.field2769) {
                  class173.field2769.method3844(var4);
               }

               class54.method1097();
               this.field2761 = var1;
            }
         }

         if(this.field2761 == -1) {
            this.field2758 = true;
         }

      }
   }

   public class171(class137 var1, class137 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2753 = var1;
      this.field2750 = var2;
      this.field2751 = var3;
      this.field2754 = var6;
      Item.method655(this, this.field2751);
   }
}
