import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class184 extends class182 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1766173483
   )
   int field2730;
   @ObfuscatedName("y")
   class116 field2731;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -2048994493
   )
   int field2732;
   @ObfuscatedName("t")
   volatile boolean field2733 = false;
   @ObfuscatedName("z")
   boolean field2734 = false;
   @ObfuscatedName("o")
   static CRC32 field2736 = new CRC32();
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -174980345
   )
   int field2737;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1525177837
   )
   int field2738 = -1;
   @ObfuscatedName("d")
   class116 field2739;
   @ObfuscatedName("bq")
   static ModIcon[] field2743;
   @ObfuscatedName("b")
   volatile boolean[] field2744;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "116"
   )
   void vmethod3316(int var1) {
      class107.method2005(this.field2730, var1);
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "909451392"
   )
   public int method3317() {
      if(this.field2733) {
         return 100;
      } else if(super.field2718 != null) {
         return 99;
      } else {
         int var2 = this.field2730;
         long var3 = (long)(16711680 + var2);
         int var1;
         if(null != class161.field2149 && var3 == class161.field2149.hash) {
            var1 = 1 + class185.field2758.offset * 99 / (class185.field2758.payload.length - class161.field2149.field2701);
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

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "2045494514"
   )
   public void method3319(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2733) {
            throw new RuntimeException();
         }

         if(this.field2731 != null) {
            class1.method14(this.field2730, var2, this.field2731);
         }

         this.method3209(var2);
         this.method3323();
      } else {
         var2[var2.length - 2] = (byte)(super.field2716[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2716[var1];
         if(null != this.field2739) {
            class1.method14(var1, var2, this.field2739);
            this.field2744[var1] = true;
         }

         if(var4) {
            super.field2718[var1] = XItemContainer.method162(var2, false);
         }
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1442425560"
   )
   public void method3320(int var1, int var2) {
      this.field2737 = var1;
      this.field2732 = var2;
      if(this.field2731 != null) {
         int var3 = this.field2730;
         class116 var4 = this.field2731;
         byte[] var6 = null;
         Deque var7 = class183.field2726;
         synchronized(class183.field2726) {
            for(class180 var8 = (class180)class183.field2726.method2359(); var8 != null; var8 = (class180)class183.field2726.method2361()) {
               if(var8.hash == (long)var3 && var4 == var8.field2693 && var8.field2692 == 0) {
                  var6 = var8.field2691;
                  break;
               }
            }
         }

         if(null != var6) {
            this.method3322(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method2206(var3);
            this.method3322(var4, var3, var11, true);
         }
      } else {
         class178.method3200(this, 255, this.field2730, this.field2737, (byte)0, true);
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(Lclass116;I[BZI)V",
      garbageValue = "36589849"
   )
   void method3322(class116 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2731) {
         if(this.field2733) {
            throw new RuntimeException();
         } else if(null == var3) {
            class178.method3200(this, 255, this.field2730, this.field2737, (byte)0, true);
         } else {
            field2736.reset();
            field2736.update(var3, 0, var3.length);
            var5 = (int)field2736.getValue();
            Buffer var6 = new Buffer(class116.method2200(var3));
            int var7 = var6.readUnsignedByte();
            if(var7 != 5 && var7 != 6) {
               throw new RuntimeException(var7 + "," + this.field2730 + "," + var2);
            } else {
               int var8 = 0;
               if(var7 >= 6) {
                  var8 = var6.method2844();
               }

               if(var5 != this.field2737 || var8 != this.field2732) {
                  class178.method3200(this, 255, this.field2730, this.field2737, (byte)0, true);
               } else {
                  this.method3209(var3);
                  this.method3323();
               }
            }
         }
      } else {
         if(!var4 && this.field2738 == var2) {
            this.field2733 = true;
         }

         if(null != var3 && var3.length > 2) {
            field2736.reset();
            field2736.update(var3, 0, var3.length - 2);
            var5 = (int)field2736.getValue();
            int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
            if(super.field2710[var2] == var5 && var9 == super.field2716[var2]) {
               this.field2744[var2] = true;
               if(var4) {
                  super.field2718[var2] = XItemContainer.method162(var3, false);
               }

            } else {
               this.field2744[var2] = false;
               if(this.field2734 || var4) {
                  class178.method3200(this, this.field2730, var2, super.field2710[var2], (byte)2, var4);
               }

            }
         } else {
            this.field2744[var2] = false;
            if(this.field2734 || var4) {
               class178.method3200(this, this.field2730, var2, super.field2710[var2], (byte)2, var4);
            }

         }
      }
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1872403375"
   )
   void method3323() {
      this.field2744 = new boolean[super.field2718.length];

      int var1;
      for(var1 = 0; var1 < this.field2744.length; ++var1) {
         this.field2744[var1] = false;
      }

      if(this.field2739 == null) {
         this.field2733 = true;
      } else {
         this.field2738 = -1;

         for(var1 = 0; var1 < this.field2744.length; ++var1) {
            if(super.field2712[var1] > 0) {
               class149.method2735(var1, this.field2739, this);
               this.field2738 = var1;
            }
         }

         if(this.field2738 == -1) {
            this.field2733 = true;
         }

      }
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-990588404"
   )
   public int method3325() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2718.length; ++var3) {
         if(super.field2712[var3] > 0) {
            var1 += 100;
            var2 += this.method3326(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1042242998"
   )
   int method3326(int var1) {
      if(null != super.field2718[var1]) {
         return 100;
      } else if(this.field2744[var1]) {
         return 100;
      } else {
         int var3 = this.field2730;
         long var4 = (long)(var1 + (var3 << 16));
         int var2;
         if(class161.field2149 != null && class161.field2149.hash == var4) {
            var2 = class185.field2758.offset * 99 / (class185.field2758.payload.length - class161.field2149.field2701) + 1;
         } else {
            var2 = 0;
         }

         return var2;
      }
   }

   public class184(class116 var1, class116 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2739 = var1;
      this.field2731 = var2;
      this.field2730 = var3;
      this.field2734 = var6;
      int var8 = this.field2730;
      if(null != class142.field2000) {
         class142.field2000.offset = 5 + 8 * var8;
         int var9 = class142.field2000.method2844();
         int var10 = class142.field2000.method2844();
         this.method3320(var9, var10);
      } else {
         class178.method3200((class184)null, 255, 255, 0, (byte)0, true);
         class185.field2761[var8] = this;
      }

   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "86162603"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-105"
   )
   void vmethod3350(int var1) {
      if(this.field2739 != null && null != this.field2744 && this.field2744[var1]) {
         class116 var2 = this.field2739;
         byte[] var4 = null;
         Deque var5 = class183.field2726;
         synchronized(class183.field2726) {
            for(class180 var6 = (class180)class183.field2726.method2359(); var6 != null; var6 = (class180)class183.field2726.method2361()) {
               if(var6.hash == (long)var1 && var2 == var6.field2693 && var6.field2692 == 0) {
                  var4 = var6.field2691;
                  break;
               }
            }
         }

         if(var4 != null) {
            this.method3322(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.method2206(var1);
            this.method3322(var2, var1, var9, true);
         }
      } else {
         class178.method3200(this, this.field2730, var1, super.field2710[var1], (byte)2, true);
      }

   }
}
