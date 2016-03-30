import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class24 extends class208 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -903241457
   )
   @Export("world")
   int field627;
   @ObfuscatedName("x")
   String field628;
   @ObfuscatedName("p")
   @Export("rank")
   byte field630;
   @ObfuscatedName("w")
   @Export("username")
   String field634;

   @ObfuscatedName("u")
   static final int method607(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var0 / 4 << 10) + (var1 / 32 << 7);
      return var3;
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIZB)V",
      garbageValue = "-92"
   )
   static void method608(class173 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2767;
      int var5 = var0.field2783;
      if(0 == var0.field2774) {
         var0.field2767 = var0.field2778;
      } else if(var0.field2774 == 1) {
         var0.field2767 = var1 - var0.field2778;
      } else if(2 == var0.field2774) {
         var0.field2767 = var0.field2778 * var1 >> 14;
      }

      if(0 == var0.field2772) {
         var0.field2783 = var0.field2779;
      } else if(var0.field2772 == 1) {
         var0.field2783 = var2 - var0.field2779;
      } else if(var0.field2772 == 2) {
         var0.field2783 = var2 * var0.field2779 >> 14;
      }

      if(var0.field2774 == 4) {
         var0.field2767 = var0.field2783 * var0.field2784 / var0.field2785;
      }

      if(var0.field2772 == 4) {
         var0.field2783 = var0.field2785 * var0.field2767 / var0.field2784;
      }

      if(client.field521 && 0 == var0.field2814) {
         if(var0.field2783 < 5 && var0.field2767 < 5) {
            var0.field2783 = 5;
            var0.field2767 = 5;
         } else {
            if(var0.field2783 <= 0) {
               var0.field2783 = 5;
            }

            if(var0.field2767 <= 0) {
               var0.field2767 = 5;
            }
         }
      }

      if(var0.field2890 == 1337) {
         client.field466 = var0;
      }

      if(var3 && null != var0.field2876 && (var0.field2767 != var4 || var0.field2783 != var5)) {
         class0 var6 = new class0();
         var6.field2 = var0;
         var6.field7 = var0.field2876;
         client.field493.method3834(var6);
      }

   }

   @ObfuscatedName("co")
   static final void method609(int var0) {
      if(class39.method817(var0)) {
         class32.method728(class173.field2830[var0], -1);
      }
   }

   @ObfuscatedName("g")
   public static class77 method610(int var0, int var1, Component var2) {
      try {
         class81 var3 = new class81();
         var3.vmethod1869(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         class75 var4 = new class75();
         var4.vmethod1869(var0, var1, var2);
         return var4;
      }
   }
}
