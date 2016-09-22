import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class162 implements class115 {
   @ObfuscatedName("v")
   public static final class162 field2665 = new class162(1, 2);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2055737835
   )
   public final int field2667;
   @ObfuscatedName("r")
   public static final class162 field2668 = new class162(3, 3);
   @ObfuscatedName("d")
   public static final class162 field2669 = new class162(0, 1);
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1643308745
   )
   final int field2670;
   @ObfuscatedName("a")
   public static final class162 field2671 = new class162(2, 0);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "255"
   )
   public static void method3212(int var0) {
      if(var0 != -1) {
         if(Widget.validInterfaces[var0]) {
            class153.field2311.method3321(var0);
            if(null != Widget.widgets[var0]) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(null != Widget.widgets[var0][var2]) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class162(int var1, int var2) {
      this.field2667 = var1;
      this.field2670 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1565114944"
   )
   public int vmethod3214() {
      return this.field2670;
   }
}
