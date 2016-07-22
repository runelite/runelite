import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
@Implements("NPC")
public final class class36 extends class39 {
   @ObfuscatedName("na")
   static class59 field799;
   @ObfuscatedName("gq")
   static class176 field801;
   @ObfuscatedName("m")
   @Export("composition")
   class41 field802;
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = 698056015
   )
   static int field803;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "2036053707"
   )
   final void method734(int var1, int var2, boolean var3) {
      if(super.field884 != -1 && class28.method646(super.field884).field1020 == 1) {
         super.field884 = -1;
      }

      if(!var3) {
         int var4 = var1 - super.field885[0];
         int var5 = var2 - super.field886[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field875 < 9) {
               ++super.field875;
            }

            for(int var6 = super.field875; var6 > 0; --var6) {
               super.field885[var6] = super.field885[var6 - 1];
               super.field886[var6] = super.field886[var6 - 1];
               super.field887[var6] = super.field887[var6 - 1];
            }

            super.field885[0] = var1;
            super.field886[0] = var2;
            super.field887[0] = 1;
            return;
         }
      }

      super.field875 = 0;
      super.field851 = 0;
      super.field888 = 0;
      super.field885[0] = var1;
      super.field886[0] = var2;
      super.field864 = super.field858 * 64 + 128 * super.field885[0];
      super.field831 = super.field886[0] * 128 + super.field858 * 64;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "1741985853"
   )
   final void method739(int var1, byte var2) {
      int var3 = super.field885[0];
      int var4 = super.field886[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.field884 != -1 && class28.method646(super.field884).field1020 == 1) {
         super.field884 = -1;
      }

      if(super.field875 < 9) {
         ++super.field875;
      }

      for(int var5 = super.field875; var5 > 0; --var5) {
         super.field885[var5] = super.field885[var5 - 1];
         super.field886[var5] = super.field886[var5 - 1];
         super.field887[var5] = super.field887[var5 - 1];
      }

      super.field885[0] = var3;
      super.field886[0] = var4;
      super.field887[0] = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-58"
   )
   final boolean vmethod786() {
      return null != this.field802;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-990594109"
   )
   protected final class108 vmethod1992() {
      if(this.field802 == null) {
         return null;
      } else {
         class44 var1 = super.field884 != -1 && super.field865 == 0?class28.method646(super.field884):null;
         class44 var2 = super.field859 == -1 || super.field859 == super.field847 && null != var1?null:class28.method646(super.field859);
         class108 var3 = this.field802.method795(var1, super.field863, var2, super.field860);
         if(var3 == null) {
            return null;
         } else {
            var3.method2385();
            super.field880 = var3.field1536;
            if(super.field834 != -1 && super.field868 != -1) {
               class108 var4 = class175.method3442(super.field834).method942(super.field868);
               if(null != var4) {
                  var4.method2372(0, -super.field871, 0);
                  class108[] var5 = new class108[]{var3, var4};
                  var3 = new class108(var5, 2);
               }
            }

            if(this.field802.field906 == 1) {
               var3.field1924 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-8915040"
   )
   public static int method749(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass147;B)V",
      garbageValue = "43"
   )
   static void method751(class147 var0) {
      if(class143.field2224 == 1 || !class17.field235 && class143.field2224 == 4) {
         int var1 = class33.field730 + 280;
         if(class143.field2220 >= var1 && class143.field2220 <= 14 + var1 && class143.field2222 >= 4 && class143.field2222 <= 18) {
            class46.method978(0, 0);
            return;
         }

         if(class143.field2220 >= 15 + var1 && class143.field2220 <= var1 + 80 && class143.field2222 >= 4 && class143.field2222 <= 18) {
            class46.method978(0, 1);
            return;
         }

         int var2 = class33.field730 + 390;
         if(class143.field2220 >= var2 && class143.field2220 <= 14 + var2 && class143.field2222 >= 4 && class143.field2222 <= 18) {
            class46.method978(1, 0);
            return;
         }

         if(class143.field2220 >= var2 + 15 && class143.field2220 <= 80 + var2 && class143.field2222 >= 4 && class143.field2222 <= 18) {
            class46.method978(1, 1);
            return;
         }

         int var3 = class33.field730 + 500;
         if(class143.field2220 >= var3 && class143.field2220 <= 14 + var3 && class143.field2222 >= 4 && class143.field2222 <= 18) {
            class46.method978(2, 0);
            return;
         }

         if(class143.field2220 >= 15 + var3 && class143.field2220 <= var3 + 80 && class143.field2222 >= 4 && class143.field2222 <= 18) {
            class46.method978(2, 1);
            return;
         }

         int var4 = class33.field730 + 610;
         if(class143.field2220 >= var4 && class143.field2220 <= var4 + 14 && class143.field2222 >= 4 && class143.field2222 <= 18) {
            class46.method978(3, 0);
            return;
         }

         if(class143.field2220 >= var4 + 15 && class143.field2220 <= var4 + 80 && class143.field2222 >= 4 && class143.field2222 <= 18) {
            class46.method978(3, 1);
            return;
         }

         if(class143.field2220 >= class33.field730 + 708 && class143.field2222 >= 4 && class143.field2220 <= class33.field730 + 708 + 50 && class143.field2222 <= 20) {
            class33.field728 = false;
            class189.field3054.method1798(class33.field730, 0);
            class141.field2199.method1798(class33.field730 + 382, 0);
            class30.field698.method1946(382 + class33.field730 - class30.field698.field1500 / 2, 18);
            return;
         }

         if(class33.field734 != -1) {
            class27 var5 = class219.field3210[class33.field734];
            class145.method3040(var5);
            class33.field728 = false;
            class189.field3054.method1798(class33.field730, 0);
            class141.field2199.method1798(382 + class33.field730, 0);
            class30.field698.method1946(class33.field730 + 382 - class30.field698.field1500 / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-208465234"
   )
   public static void method753() {
      class46.field1047.method3814();
   }
}
