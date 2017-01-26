import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class184 extends class182 {
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -801205285
   )
   int field2729;
   @ObfuscatedName("v")
   class116 field2730;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -906029447
   )
   int field2731;
   @ObfuscatedName("t")
   boolean field2733 = false;
   @ObfuscatedName("b")
   volatile boolean[] field2734;
   @ObfuscatedName("e")
   static CRC32 field2735 = new CRC32();
   @ObfuscatedName("y")
   class116 field2736;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1950406643
   )
   int field2737;
   @ObfuscatedName("l")
   volatile boolean field2738 = false;
   @ObfuscatedName("bl")
   static class184 field2739;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 317370191
   )
   int field2740 = -1;

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-60"
   )
   public int method3361() {
      if(this.field2738) {
         return 100;
      } else if(super.field2710 != null) {
         return 99;
      } else {
         int var1 = class63.method1129(255, this.field2731);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-920994339"
   )
   void vmethod3362(int var1) {
      class48.method879(this.field2731, var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1697601934"
   )
   void vmethod3363(int var1) {
      if(null != this.field2736 && this.field2734 != null && this.field2734[var1]) {
         ItemLayer.method1456(var1, this.field2736, this);
      } else {
         class176.method3244(this, this.field2731, var1, super.field2704[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "555126279"
   )
   public void method3364(int var1, int var2) {
      this.field2729 = var1;
      this.field2737 = var2;
      if(this.field2730 != null) {
         ItemLayer.method1456(this.field2731, this.field2730, this);
      } else {
         class176.method3244(this, 255, this.field2731, this.field2729, (byte)0, true);
      }

   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-86"
   )
   void method3365() {
      this.field2734 = new boolean[super.field2710.length];

      int var1;
      for(var1 = 0; var1 < this.field2734.length; ++var1) {
         this.field2734[var1] = false;
      }

      if(this.field2736 == null) {
         this.field2738 = true;
      } else {
         this.field2740 = -1;

         for(var1 = 0; var1 < this.field2734.length; ++var1) {
            if(super.field2706[var1] > 0) {
               class116 var2 = this.field2736;
               class180 var4 = new class180();
               var4.field2691 = 1;
               var4.hash = (long)var1;
               var4.field2690 = var2;
               var4.field2689 = this;
               Deque var5 = class183.field2727;
               synchronized(class183.field2727) {
                  class183.field2727.method2407(var4);
               }

               Object var10 = class183.field2728;
               synchronized(class183.field2728) {
                  if(class183.field2725 == 0) {
                     class45.field899.method1968(new class183(), 5);
                  }

                  class183.field2725 = 600;
               }

               this.field2740 = var1;
            }
         }

         if(this.field2740 == -1) {
            this.field2738 = true;
         }

      }
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(Lclass116;I[BZB)V",
      garbageValue = "4"
   )
   void method3366(class116 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2730) {
         if(this.field2738) {
            throw new RuntimeException();
         }

         if(null == var3) {
            class176.method3244(this, 255, this.field2731, this.field2729, (byte)0, true);
            return;
         }

         field2735.reset();
         field2735.update(var3, 0, var3.length);
         var5 = (int)field2735.getValue();
         Buffer var9 = new Buffer(Friend.method181(var3));
         int var7 = var9.readUnsignedByte();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2731 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var9.method2819();
         }

         if(var5 != this.field2729 || this.field2737 != var8) {
            class176.method3244(this, 255, this.field2731, this.field2729, (byte)0, true);
            return;
         }

         this.method3269(var3);
         this.method3365();
      } else {
         if(!var4 && var2 == this.field2740) {
            this.field2738 = true;
         }

         if(var3 == null || var3.length <= 2) {
            this.field2734[var2] = false;
            if(this.field2733 || var4) {
               class176.method3244(this, this.field2731, var2, super.field2704[var2], (byte)2, var4);
            }

            return;
         }

         field2735.reset();
         field2735.update(var3, 0, var3.length - 2);
         var5 = (int)field2735.getValue();
         int var6 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(super.field2704[var2] != var5 || var6 != super.field2705[var2]) {
            this.field2734[var2] = false;
            if(this.field2733 || var4) {
               class176.method3244(this, this.field2731, var2, super.field2704[var2], (byte)2, var4);
            }

            return;
         }

         this.field2734[var2] = true;
         if(var4) {
            super.field2710[var2] = World.method653(var3, false);
         }
      }

   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-35"
   )
   int method3368(int var1) {
      return null != super.field2710[var1]?100:(this.field2734[var1]?100:class63.method1129(this.field2731, var1));
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1089260889"
   )
   public int method3370() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2710.length; ++var3) {
         if(super.field2706[var3] > 0) {
            var1 += 100;
            var2 += this.method3368(var3);
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
      this.field2736 = var1;
      this.field2730 = var2;
      this.field2731 = var3;
      this.field2733 = var6;
      class22.method212(this, this.field2731);
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "-46"
   )
   public void method3393(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2738) {
            throw new RuntimeException();
         }

         if(null != this.field2730) {
            Widget.method3221(this.field2731, var2, this.field2730);
         }

         this.method3269(var2);
         this.method3365();
      } else {
         var2[var2.length - 2] = (byte)(super.field2705[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2705[var1];
         if(null != this.field2736) {
            class116 var5 = this.field2736;
            class180 var6 = new class180();
            var6.field2691 = 0;
            var6.hash = (long)var1;
            var6.field2693 = var2;
            var6.field2690 = var5;
            Deque var7 = class183.field2727;
            synchronized(class183.field2727) {
               class183.field2727.method2407(var6);
            }

            Object var12 = class183.field2728;
            synchronized(class183.field2728) {
               if(class183.field2725 == 0) {
                  class45.field899.method1968(new class183(), 5);
               }

               class183.field2725 = 600;
            }

            this.field2734[var1] = true;
         }

         if(var4) {
            super.field2710[var1] = World.method653(var2, false);
         }
      }

   }
}
