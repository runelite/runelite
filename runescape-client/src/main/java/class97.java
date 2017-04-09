import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class97 implements class158 {
   @ObfuscatedName("h")
   public static final class97 field1649 = new class97(2, 3);
   @ObfuscatedName("i")
   public static final class97 field1650 = new class97(0, 1);
   @ObfuscatedName("u")
   public static final class97 field1651 = new class97(1, 2);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1854596573
   )
   public final int field1653;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 685074635
   )
   final int field1654;
   @ObfuscatedName("f")
   public static final class97 field1655 = new class97(3, 0);
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = 1054569237
   )
   @Export("menuHeight")
   static int menuHeight;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1650657775"
   )
   static int method1961(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class32.field743[--class30.field713];
         var4 = FaceNormal.method1932(var3);
      } else {
         var4 = var2?class154.field2123:class32.field746;
      }

      if(var0 == 1000) {
         class30.field713 -= 4;
         var4.originalX = class32.field743[class30.field713];
         var4.originalY = class32.field743[class30.field713 + 1];
         var4.field2351 = class32.field743[class30.field713 + 2];
         var4.field2217 = class32.field743[class30.field713 + 3];
         class22.method197(var4);
         XGrandExchangeOffer.method54(var4);
         if(var3 != -1 && var4.type == 0) {
            class2.method16(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class30.field713 -= 4;
         var4.originalWidth = class32.field743[class30.field713];
         var4.field2231 = class32.field743[class30.field713 + 1];
         var4.field2226 = class32.field743[class30.field713 + 2];
         var4.field2227 = class32.field743[class30.field713 + 3];
         class22.method197(var4);
         XGrandExchangeOffer.method54(var4);
         if(var3 != -1 && var4.type == 0) {
            class2.method16(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class32.field743[--class30.field713] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class22.method197(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2210 = class32.field743[--class30.field713] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2353 = class32.field743[--class30.field713] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1935391427"
   )
   public int vmethod4085() {
      return this.field1654;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class97(int var1, int var2) {
      this.field1653 = var1;
      this.field1654 = var2;
   }
}
