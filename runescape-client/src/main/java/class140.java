import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class140 extends Node {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1731404341
   )
   int field1949;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 245482019
   )
   int field1950;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1524326965
   )
   int field1951;
   @ObfuscatedName("t")
   class137 field1952;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1404636757
   )
   int field1953;
   @ObfuscatedName("i")
   class55 field1954;
   @ObfuscatedName("u")
   class66 field1955;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 643052009
   )
   int field1956;
   @ObfuscatedName("l")
   class142 field1957;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 102290211
   )
   int field1958;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1540518515
   )
   int field1959;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1752929665
   )
   int field1960;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -201130711
   )
   int field1961;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 360665761
   )
   int field1962;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 28951511
   )
   int field1963;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1071604793
   )
   int field1964;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1465290801
   )
   int field1965;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2015411693
   )
   int field1966;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1672001817
   )
   int field1967;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -903379159
   )
   int field1968;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 413315649
   )
   int field1969;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "77"
   )
   void method2680() {
      this.field1957 = null;
      this.field1954 = null;
      this.field1952 = null;
      this.field1955 = null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "-457133606"
   )
   public static Widget method2681(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || null == Widget.widgets[var1][var2]) {
         boolean var3 = class159.method3142(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-32"
   )
   static final int method2682(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-2126349762"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class138.addChatMessage(var0, var1, var2, (String)null);
   }
}
