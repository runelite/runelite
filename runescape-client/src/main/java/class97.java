import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class97 implements class158 {
   @ObfuscatedName("c")
   public static final class97 field1629 = new class97(0, 1);
   @ObfuscatedName("e")
   static int[] field1630;
   @ObfuscatedName("h")
   public static final class97 field1632 = new class97(3, 3);
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -971638869
   )
   public final int field1633;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1789566979
   )
   final int field1634;
   @ObfuscatedName("f")
   public static final class97 field1636 = new class97(1, 2);
   @ObfuscatedName("s")
   public static final class97 field1637 = new class97(2, 0);
   @ObfuscatedName("bm")
   static class184 field1639;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "17064"
   )
   public int vmethod3916() {
      return this.field1634;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-605431509"
   )
   public static void method1866(int var0) {
      if(var0 != -1) {
         if(class157.validInterfaces[var0]) {
            Widget.field2240.method3194(var0);
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

               class157.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class97(int var1, int var2) {
      this.field1633 = var1;
      this.field1634 = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)I",
      garbageValue = "-13017548"
   )
   static int method1869(class182 var0, class182 var1) {
      int var2 = 0;
      if(var0.method3238("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3238("logo", "")) {
         ++var2;
      }

      if(var1.method3238("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3238("titlebox", "")) {
         ++var2;
      }

      if(var1.method3238("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3238("runes", "")) {
         ++var2;
      }

      if(var1.method3238("title_mute", "")) {
         ++var2;
      }

      if(var1.method3248("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3248("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3238("sl_back", "");
      var1.method3238("sl_flags", "");
      var1.method3238("sl_arrows", "");
      var1.method3238("sl_stars", "");
      var1.method3238("sl_button", "");
      return var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Lclass196;",
      garbageValue = "78"
   )
   public static class196 method1871(int var0) {
      class196 var1 = (class196)class196.field2875.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class196.field2880.method3182(32, var0);
         var1 = new class196();
         if(null != var2) {
            var1.method3453(new Buffer(var2));
         }

         class196.field2875.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "-45391022"
   )
   public static int method1872(CharSequence var0, int var1) {
      return ChatMessages.method831(var0, var1, true);
   }
}
