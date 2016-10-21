import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class171 extends class170 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2082177391
   )
   int field2722;
   @ObfuscatedName("s")
   volatile boolean[] field2723;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -2034598919
   )
   int field2724 = -1;
   @ObfuscatedName("p")
   volatile boolean field2725 = false;
   @ObfuscatedName("y")
   boolean field2726 = false;
   @ObfuscatedName("r")
   class137 field2727;
   @ObfuscatedName("g")
   static CRC32 field2728 = new CRC32();
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -462173647
   )
   int field2729;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1547377917
   )
   int field2730;
   @ObfuscatedName("a")
   class137 field2731;

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1829724071"
   )
   public int method3380() {
      if(this.field2725) {
         return 100;
      } else if(null != super.field2713) {
         return 99;
      } else {
         int var1 = class77.method1658(255, this.field2722);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "5"
   )
   void vmethod3382(int var1) {
      if(this.field2727 != null && this.field2723 != null && this.field2723[var1]) {
         class137 var2 = this.field2727;
         byte[] var4 = null;
         Deque var5 = class173.field2744;
         synchronized(class173.field2744) {
            for(class172 var6 = (class172)class173.field2744.method3890(); null != var6; var6 = (class172)class173.field2744.method3892()) {
               if(var6.hash == (long)var1 && var2 == var6.field2736 && var6.field2737 == 0) {
                  var4 = var6.field2735;
                  break;
               }
            }
         }

         if(var4 != null) {
            this.method3415(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.method2887(var1);
            this.method3415(var2, var1, var9, true);
         }
      } else {
         class24.method602(this, this.field2722, var1, super.field2714[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2068716052"
   )
   public void method3383(int var1, int var2) {
      this.field2729 = var1;
      this.field2730 = var2;
      if(this.field2731 != null) {
         int var3 = this.field2722;
         class137 var4 = this.field2731;
         byte[] var6 = null;
         Deque var7 = class173.field2744;
         synchronized(class173.field2744) {
            for(class172 var8 = (class172)class173.field2744.method3890(); null != var8; var8 = (class172)class173.field2744.method3892()) {
               if(var8.hash == (long)var3 && var4 == var8.field2736 && var8.field2737 == 0) {
                  var6 = var8.field2735;
                  break;
               }
            }
         }

         if(null != var6) {
            this.method3415(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method2887(var3);
            this.method3415(var4, var3, var11, true);
         }
      } else {
         class24.method602(this, 255, this.field2722, this.field2729, (byte)0, true);
      }

   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(I[BZZS)V",
      garbageValue = "-4844"
   )
   public void method3384(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2725) {
            throw new RuntimeException();
         }

         if(this.field2731 != null) {
            CollisionData.method2421(this.field2722, var2, this.field2731);
         }

         this.method3284(var2);
         this.method3416();
      } else {
         var2[var2.length - 2] = (byte)(super.field2708[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2708[var1];
         if(this.field2727 != null) {
            CollisionData.method2421(var1, var2, this.field2727);
            this.field2723[var1] = true;
         }

         if(var4) {
            super.field2713[var1] = ItemLayer.method2235(var2, false);
         }
      }

   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-309442454"
   )
   public int method3387() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2713.length; ++var3) {
         if(super.field2712[var3] > 0) {
            var1 += 100;
            var2 += this.method3395(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2105936523"
   )
   void vmethod3391(int var1) {
      class31.method683(this.field2722, var1);
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-57"
   )
   int method3395(int var1) {
      return null != super.field2713[var1]?100:(this.field2723[var1]?100:class77.method1658(this.field2722, var1));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1855834543"
   )
   public static boolean method3404(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2780.method3330(var0)) {
         return false;
      } else {
         int var1 = Widget.field2780.method3321(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(null == Widget.widgets[var0]) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.field2780.method3304(var0, var2);
                  if(null != var3) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3441(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3440(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   public class171(class137 var1, class137 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2727 = var1;
      this.field2731 = var2;
      this.field2722 = var3;
      this.field2726 = var6;
      int var8 = this.field2722;
      if(class166.field2686 != null) {
         class166.field2686.offset = 5 + 8 * var8;
         int var9 = class166.field2686.method2538();
         int var10 = class166.field2686.method2538();
         this.method3383(var9, var10);
      } else {
         class24.method602((class171)null, 255, 255, 0, (byte)0, true);
         class174.field2752[var8] = this;
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(Lclass137;I[BZI)V",
      garbageValue = "-1841139300"
   )
   public void method3415(class137 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2731) {
         if(this.field2725) {
            throw new RuntimeException();
         }

         if(null == var3) {
            class24.method602(this, 255, this.field2722, this.field2729, (byte)0, true);
            return;
         }

         field2728.reset();
         field2728.update(var3, 0, var3.length);
         var5 = (int)field2728.getValue();
         Buffer var6 = new Buffer(class160.method3192(var3));
         int var7 = var6.method2656();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2722 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2538();
         }

         if(var5 != this.field2729 || this.field2730 != var8) {
            class24.method602(this, 255, this.field2722, this.field2729, (byte)0, true);
            return;
         }

         this.method3284(var3);
         this.method3416();
      } else {
         if(!var4 && var2 == this.field2724) {
            this.field2725 = true;
         }

         if(null == var3 || var3.length <= 2) {
            this.field2723[var2] = false;
            if(this.field2726 || var4) {
               class24.method602(this, this.field2722, var2, super.field2714[var2], (byte)2, var4);
            }

            return;
         }

         field2728.reset();
         field2728.update(var3, 0, var3.length - 2);
         var5 = (int)field2728.getValue();
         int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(super.field2714[var2] != var5 || var9 != super.field2708[var2]) {
            this.field2723[var2] = false;
            if(this.field2726 || var4) {
               class24.method602(this, this.field2722, var2, super.field2714[var2], (byte)2, var4);
            }

            return;
         }

         this.field2723[var2] = true;
         if(var4) {
            super.field2713[var2] = ItemLayer.method2235(var3, false);
         }
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-7576"
   )
   void method3416() {
      this.field2723 = new boolean[super.field2713.length];

      int var1;
      for(var1 = 0; var1 < this.field2723.length; ++var1) {
         this.field2723[var1] = false;
      }

      if(this.field2727 == null) {
         this.field2725 = true;
      } else {
         this.field2724 = -1;

         for(var1 = 0; var1 < this.field2723.length; ++var1) {
            if(super.field2712[var1] > 0) {
               class137 var2 = this.field2727;
               class172 var4 = new class172();
               var4.field2737 = 1;
               var4.hash = (long)var1;
               var4.field2736 = var2;
               var4.field2734 = this;
               Deque var5 = class173.field2744;
               synchronized(class173.field2744) {
                  class173.field2744.method3886(var4);
               }

               class92.method2127();
               this.field2724 = var1;
            }
         }

         if(this.field2724 == -1) {
            this.field2725 = true;
         }

      }
   }
}
