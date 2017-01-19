import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class184 extends class182 {
   @ObfuscatedName("y")
   boolean field2736 = false;
   @ObfuscatedName("d")
   class116 field2737;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 754894331
   )
   int field2738;
   @ObfuscatedName("q")
   volatile boolean field2739 = false;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 662783757
   )
   int field2740 = -1;
   @ObfuscatedName("l")
   volatile boolean[] field2741;
   @ObfuscatedName("e")
   class116 field2742;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 2105916641
   )
   int field2743;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1840857873
   )
   int field2744;
   @ObfuscatedName("v")
   static CRC32 field2745 = new CRC32();
   @ObfuscatedName("kw")
   static class112 field2746;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "96"
   )
   void vmethod3269(int var1) {
      if(this.field2742 != null && null != this.field2741 && this.field2741[var1]) {
         class3.method34(var1, this.field2742, this);
      } else {
         class140.method2547(this, this.field2738, var1, super.field2715[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-27"
   )
   void vmethod3271(int var1) {
      int var2 = this.field2738;
      long var3 = (long)(var1 + (var2 << 16));
      class181 var5 = (class181)class185.field2765.method2274(var3);
      if(var5 != null) {
         class185.field2754.method2227(var5);
      }

   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1230563973"
   )
   int method3272(int var1) {
      return super.field2721[var1] != null?100:(this.field2741[var1]?100:Item.method777(this.field2738, var1));
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1751586712"
   )
   void method3273(int var1, int var2) {
      this.field2743 = var1;
      this.field2744 = var2;
      if(this.field2737 != null) {
         class3.method34(this.field2738, this.field2737, this);
      } else {
         class140.method2547(this, 255, this.field2738, this.field2743, (byte)0, true);
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "126"
   )
   void method3274(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2739) {
            throw new RuntimeException();
         }

         if(null != this.field2737) {
            FaceNormal.method1835(this.field2738, var2, this.field2737);
         }

         this.method3253(var2);
         this.method3285();
      } else {
         var2[var2.length - 2] = (byte)(super.field2716[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2716[var1];
         if(null != this.field2742) {
            FaceNormal.method1835(var1, var2, this.field2742);
            this.field2741[var1] = true;
         }

         if(var4) {
            super.field2721[var1] = class6.method73(var2, false);
         }
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(Lclass116;I[BZS)V",
      garbageValue = "-601"
   )
   void method3275(class116 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2737) {
         if(this.field2739) {
            throw new RuntimeException();
         }

         if(null == var3) {
            class140.method2547(this, 255, this.field2738, this.field2743, (byte)0, true);
            return;
         }

         field2745.reset();
         field2745.update(var3, 0, var3.length);
         var5 = (int)field2745.getValue();
         Buffer var6 = new Buffer(class49.method856(var3));
         int var7 = var6.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2738 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2727();
         }

         if(var5 != this.field2743 || this.field2744 != var8) {
            class140.method2547(this, 255, this.field2738, this.field2743, (byte)0, true);
            return;
         }

         this.method3253(var3);
         this.method3285();
      } else {
         if(!var4 && this.field2740 == var2) {
            this.field2739 = true;
         }

         if(null == var3 || var3.length <= 2) {
            this.field2741[var2] = false;
            if(this.field2736 || var4) {
               class140.method2547(this, this.field2738, var2, super.field2715[var2], (byte)2, var4);
            }

            return;
         }

         field2745.reset();
         field2745.update(var3, 0, var3.length - 2);
         var5 = (int)field2745.getValue();
         int var9 = ((var3[var3.length - 2] & 255) << 8) + (var3[var3.length - 1] & 255);
         if(super.field2715[var2] != var5 || super.field2716[var2] != var9) {
            this.field2741[var2] = false;
            if(this.field2736 || var4) {
               class140.method2547(this, this.field2738, var2, super.field2715[var2], (byte)2, var4);
            }

            return;
         }

         this.field2741[var2] = true;
         if(var4) {
            super.field2721[var2] = class6.method73(var3, false);
         }
      }

   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-96"
   )
   public int method3277() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2721.length; ++var3) {
         if(super.field2712[var3] > 0) {
            var1 += 100;
            var2 += this.method3272(var3);
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
      this.field2742 = var1;
      this.field2737 = var2;
      this.field2738 = var3;
      this.field2736 = var6;
      class207.method3710(this, this.field2738);
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1733646809"
   )
   void method3285() {
      this.field2741 = new boolean[super.field2721.length];

      int var1;
      for(var1 = 0; var1 < this.field2741.length; ++var1) {
         this.field2741[var1] = false;
      }

      if(null == this.field2742) {
         this.field2739 = true;
      } else {
         this.field2740 = -1;

         for(var1 = 0; var1 < this.field2741.length; ++var1) {
            if(super.field2712[var1] > 0) {
               class116 var2 = this.field2742;
               class180 var4 = new class180();
               var4.field2704 = 1;
               var4.hash = (long)var1;
               var4.field2702 = var2;
               var4.field2703 = this;
               Deque var5 = class183.field2733;
               synchronized(class183.field2733) {
                  class183.field2733.method2333(var4);
               }

               class182.method3224();
               this.field2740 = var1;
            }
         }

         if(this.field2740 == -1) {
            this.field2739 = true;
         }

      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1551631660"
   )
   public int method3291() {
      if(this.field2739) {
         return 100;
      } else if(super.field2721 != null) {
         return 99;
      } else {
         int var1 = Item.method777(255, this.field2738);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "478867364"
   )
   static final void method3297(Widget var0, int var1, int var2) {
      if(Client.field464 == null && !Client.isMenuOpen) {
         if(null != var0) {
            Widget var4 = class9.method97(var0);
            if(var4 == null) {
               var4 = var0.parent;
            }

            if(var4 != null) {
               Client.field464 = var0;
               var4 = class9.method97(var0);
               if(var4 == null) {
                  var4 = var0.parent;
               }

               Client.field465 = var4;
               Client.field466 = var1;
               Client.field467 = var2;
               class6.field72 = 0;
               Client.field475 = false;
               if(Client.menuOptionCount > 0) {
                  class47.method841(Client.menuOptionCount - 1);
               }

               return;
            }
         }

      }
   }
}
