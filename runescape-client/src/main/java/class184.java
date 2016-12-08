import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class184 extends class182 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1984001813
   )
   int field2741;
   @ObfuscatedName("n")
   class116 field2742;
   @ObfuscatedName("t")
   volatile boolean field2744 = false;
   @ObfuscatedName("r")
   boolean field2745 = false;
   @ObfuscatedName("a")
   volatile boolean[] field2746;
   @ObfuscatedName("e")
   static CRC32 field2747 = new CRC32();
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1267779359
   )
   int field2748;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 678530383
   )
   int field2749;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 79672359
   )
   int field2750 = -1;
   @ObfuscatedName("w")
   class116 field2754;

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1702282161"
   )
   public int method3294() {
      if(this.field2744) {
         return 100;
      } else if(null != super.field2718) {
         return 99;
      } else {
         int var1 = class65.method1150(255, this.field2741);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2136437876"
   )
   void vmethod3295(int var1) {
      class162.method3012(this.field2741, var1);
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2060776337"
   )
   public void method3297(int var1, int var2) {
      this.field2748 = var1;
      this.field2749 = var2;
      if(this.field2742 != null) {
         class116.method2195(this.field2741, this.field2742, this);
      } else {
         class3.method40(this, 255, this.field2741, this.field2748, (byte)0, true);
      }

   }

   public class184(class116 var1, class116 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2754 = var1;
      this.field2742 = var2;
      this.field2741 = var3;
      this.field2745 = var6;
      int var8 = this.field2741;
      if(class118.field1862 != null) {
         class118.field1862.offset = var8 * 8 + 5;
         int var9 = class118.field1862.method2731();
         int var10 = class118.field1862.method2731();
         this.method3297(var9, var10);
      } else {
         class3.method40((class184)null, 255, 255, 0, (byte)0, true);
         class185.field2770[var8] = this;
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(Lclass116;I[BZB)V",
      garbageValue = "-89"
   )
   public void method3298(class116 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2742) {
         if(this.field2744) {
            throw new RuntimeException();
         } else if(var3 == null) {
            class3.method40(this, 255, this.field2741, this.field2748, (byte)0, true);
         } else {
            field2747.reset();
            field2747.update(var3, 0, var3.length);
            var5 = (int)field2747.getValue();
            Buffer var9 = new Buffer(class7.method88(var3));
            int var7 = var9.readUnsignedByte();
            if(var7 != 5 && var7 != 6) {
               throw new RuntimeException(var7 + "," + this.field2741 + "," + var2);
            } else {
               int var8 = 0;
               if(var7 >= 6) {
                  var8 = var9.method2731();
               }

               if(this.field2748 != var5 || var8 != this.field2749) {
                  class3.method40(this, 255, this.field2741, this.field2748, (byte)0, true);
               } else {
                  this.method3201(var3);
                  this.method3299();
               }
            }
         }
      } else {
         if(!var4 && this.field2750 == var2) {
            this.field2744 = true;
         }

         if(var3 != null && var3.length > 2) {
            field2747.reset();
            field2747.update(var3, 0, var3.length - 2);
            var5 = (int)field2747.getValue();
            int var6 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
            if(super.field2719[var2] == var5 && super.field2715[var2] == var6) {
               this.field2746[var2] = true;
               if(var4) {
                  super.field2718[var2] = class177.method3189(var3, false);
               }

            } else {
               this.field2746[var2] = false;
               if(this.field2745 || var4) {
                  class3.method40(this, this.field2741, var2, super.field2719[var2], (byte)2, var4);
               }

            }
         } else {
            this.field2746[var2] = false;
            if(this.field2745 || var4) {
               class3.method40(this, this.field2741, var2, super.field2719[var2], (byte)2, var4);
            }

         }
      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "732357144"
   )
   void method3299() {
      this.field2746 = new boolean[super.field2718.length];

      int var1;
      for(var1 = 0; var1 < this.field2746.length; ++var1) {
         this.field2746[var1] = false;
      }

      if(this.field2754 == null) {
         this.field2744 = true;
      } else {
         this.field2750 = -1;

         for(var1 = 0; var1 < this.field2746.length; ++var1) {
            if(super.field2721[var1] > 0) {
               class116 var2 = this.field2754;
               class180 var4 = new class180();
               var4.field2702 = 1;
               var4.hash = (long)var1;
               var4.field2704 = var2;
               var4.field2705 = this;
               Deque var5 = class183.field2733;
               synchronized(class183.field2733) {
                  class183.field2733.method2361(var4);
               }

               class18.method187();
               this.field2750 = var1;
            }
         }

         if(this.field2750 == -1) {
            this.field2744 = true;
         }

      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "17937"
   )
   public int method3300() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2718.length; ++var3) {
         if(super.field2721[var3] > 0) {
            var1 += 100;
            var2 += this.method3301(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "489611715"
   )
   int method3301(int var1) {
      return super.field2718[var1] != null?100:(this.field2746[var1]?100:class65.method1150(this.field2741, var1));
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "38"
   )
   public void method3310(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2744) {
            throw new RuntimeException();
         }

         if(null != this.field2742) {
            ChatLineBuffer.method894(this.field2741, var2, this.field2742);
         }

         this.method3201(var2);
         this.method3299();
      } else {
         var2[var2.length - 2] = (byte)(super.field2715[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2715[var1];
         if(this.field2754 != null) {
            ChatLineBuffer.method894(var1, var2, this.field2754);
            this.field2746[var1] = true;
         }

         if(var4) {
            super.field2718[var1] = class177.method3189(var2, false);
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-903346480"
   )
   void vmethod3313(int var1) {
      if(this.field2754 != null && null != this.field2746 && this.field2746[var1]) {
         class116.method2195(var1, this.field2754, this);
      } else {
         class3.method40(this, this.field2741, var1, super.field2719[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "-1729278574"
   )
   public static long method3324(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(1 + var5 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(1 + var5 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }
}
