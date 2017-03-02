import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class184 extends class182 {
   @ObfuscatedName("e")
   volatile boolean field2731 = false;
   @ObfuscatedName("c")
   class116 field2732;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1494367087
   )
   int field2733;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 2109109157
   )
   int field2734;
   @ObfuscatedName("j")
   boolean field2735 = false;
   @ObfuscatedName("d")
   volatile boolean[] field2736;
   @ObfuscatedName("g")
   static CRC32 field2737 = new CRC32();
   @ObfuscatedName("q")
   class116 field2738;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 66199511
   )
   int field2739;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -599752599
   )
   int field2740 = -1;

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-619351877"
   )
   public int method3432() {
      if(this.field2731) {
         return 100;
      } else if(super.field2718 != null) {
         return 99;
      } else {
         int var2 = this.field2733;
         long var3 = (long)(var2 + 16711680);
         int var1;
         if(class168.field2181 != null && var3 == class168.field2181.hash) {
            var1 = 1 + class9.field83.offset * 99 / (class9.field83.payload.length - class168.field2181.field2702);
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "441144862"
   )
   void vmethod3433(int var1) {
      class36.method798(this.field2733, var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "184508180"
   )
   void vmethod3434(int var1) {
      if(this.field2738 != null && null != this.field2736 && this.field2736[var1]) {
         class139.method2676(var1, this.field2738, this);
      } else {
         class154.method3077(this, this.field2733, var1, super.field2710[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "-439610837"
   )
   public void method3436(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2731) {
            throw new RuntimeException();
         }

         if(null != this.field2732) {
            int var5 = this.field2733;
            class116 var6 = this.field2732;
            class180 var7 = new class180();
            var7.field2697 = 0;
            var7.hash = (long)var5;
            var7.field2695 = var2;
            var7.field2696 = var6;
            Deque var8 = class183.field2730;
            synchronized(class183.field2730) {
               class183.field2730.method2468(var7);
            }

            Object var21 = class183.field2728;
            synchronized(class183.field2728) {
               if(class183.field2727 == 0) {
                  class25.field579.method2031(new class183(), 5);
               }

               class183.field2727 = 600;
            }
         }

         this.method3348(var2);
         this.method3438();
      } else {
         var2[var2.length - 2] = (byte)(super.field2711[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2711[var1];
         if(this.field2738 != null) {
            class116 var13 = this.field2738;
            class180 var18 = new class180();
            var18.field2697 = 0;
            var18.hash = (long)var1;
            var18.field2695 = var2;
            var18.field2696 = var13;
            Deque var19 = class183.field2730;
            synchronized(class183.field2730) {
               class183.field2730.method2468(var18);
            }

            Object var20 = class183.field2728;
            synchronized(class183.field2728) {
               if(class183.field2727 == 0) {
                  class25.field579.method2031(new class183(), 5);
               }

               class183.field2727 = 600;
            }

            this.field2736[var1] = true;
         }

         if(var4) {
            super.field2718[var1] = class205.method3918(var2, false);
         }
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-1"
   )
   public void method3437(int var1, int var2) {
      this.field2734 = var1;
      this.field2739 = var2;
      if(null != this.field2732) {
         class139.method2676(this.field2733, this.field2732, this);
      } else {
         class154.method3077(this, 255, this.field2733, this.field2734, (byte)0, true);
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "59"
   )
   void method3438() {
      this.field2736 = new boolean[super.field2718.length];

      int var1;
      for(var1 = 0; var1 < this.field2736.length; ++var1) {
         this.field2736[var1] = false;
      }

      if(this.field2738 == null) {
         this.field2731 = true;
      } else {
         this.field2740 = -1;

         for(var1 = 0; var1 < this.field2736.length; ++var1) {
            if(super.field2712[var1] > 0) {
               class116 var2 = this.field2738;
               class180 var4 = new class180();
               var4.field2697 = 1;
               var4.hash = (long)var1;
               var4.field2696 = var2;
               var4.field2694 = this;
               Deque var5 = class183.field2730;
               synchronized(class183.field2730) {
                  class183.field2730.method2468(var4);
               }

               Object var10 = class183.field2728;
               synchronized(class183.field2728) {
                  if(class183.field2727 == 0) {
                     class25.field579.method2031(new class183(), 5);
                  }

                  class183.field2727 = 600;
               }

               this.field2740 = var1;
            }
         }

         if(this.field2740 == -1) {
            this.field2731 = true;
         }

      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "53"
   )
   int method3439(int var1) {
      if(super.field2718[var1] != null) {
         return 100;
      } else if(this.field2736[var1]) {
         return 100;
      } else {
         int var3 = this.field2733;
         long var4 = (long)(var1 + (var3 << 16));
         int var2;
         if(null != class168.field2181 && class168.field2181.hash == var4) {
            var2 = 1 + class9.field83.offset * 99 / (class9.field83.payload.length - class168.field2181.field2702);
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2083247175"
   )
   public int method3451() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2718.length; ++var3) {
         if(super.field2712[var3] > 0) {
            var1 += 100;
            var2 += this.method3439(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   public static void method3455() {
      Sequence.field3075.reset();
      Sequence.field3061.reset();
   }

   public class184(class116 var1, class116 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2738 = var1;
      this.field2732 = var2;
      this.field2733 = var3;
      this.field2735 = var6;
      class107.method2092(this, this.field2733);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1351701060"
   )
   static int method3465(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class32.field719:class185.field2760;
      if(var0 == 1700) {
         class32.field729[++class101.field1648 - 1] = var3.item;
         return 1;
      } else if(var0 == 1701) {
         if(var3.item != -1) {
            class32.field729[++class101.field1648 - 1] = var3.stackSize;
         } else {
            class32.field729[++class101.field1648 - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class32.field729[++class101.field1648 - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(Lclass116;I[BZB)V",
      garbageValue = "-1"
   )
   public void method3466(class116 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2732) {
         if(this.field2731) {
            throw new RuntimeException();
         } else if(null == var3) {
            class154.method3077(this, 255, this.field2733, this.field2734, (byte)0, true);
         } else {
            field2737.reset();
            field2737.update(var3, 0, var3.length);
            var5 = (int)field2737.getValue();
            Buffer var6 = new Buffer(class159.method3143(var3));
            int var7 = var6.readUnsignedByte();
            if(var7 != 5 && var7 != 6) {
               throw new RuntimeException(var7 + "," + this.field2733 + "," + var2);
            } else {
               int var8 = 0;
               if(var7 >= 6) {
                  var8 = var6.readInt();
               }

               if(this.field2734 != var5 || var8 != this.field2739) {
                  class154.method3077(this, 255, this.field2733, this.field2734, (byte)0, true);
               } else {
                  this.method3348(var3);
                  this.method3438();
               }
            }
         }
      } else {
         if(!var4 && var2 == this.field2740) {
            this.field2731 = true;
         }

         if(null != var3 && var3.length > 2) {
            field2737.reset();
            field2737.update(var3, 0, var3.length - 2);
            var5 = (int)field2737.getValue();
            int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
            if(super.field2710[var2] == var5 && super.field2711[var2] == var9) {
               this.field2736[var2] = true;
               if(var4) {
                  super.field2718[var2] = class205.method3918(var3, false);
               }

            } else {
               this.field2736[var2] = false;
               if(this.field2735 || var4) {
                  class154.method3077(this, this.field2733, var2, super.field2710[var2], (byte)2, var4);
               }

            }
         } else {
            this.field2736[var2] = false;
            if(this.field2735 || var4) {
               class154.method3077(this, this.field2733, var2, super.field2710[var2], (byte)2, var4);
            }

         }
      }
   }
}
