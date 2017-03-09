import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class140 extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 212089123
   )
   int field1956;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -175374413
   )
   int field1957;
   @ObfuscatedName("c")
   class55 field1958;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 928534915
   )
   int field1959;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 688835471
   )
   int field1960;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -715154565
   )
   int field1961;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1346024469
   )
   int field1962;
   @ObfuscatedName("d")
   class137 field1963;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 940012781
   )
   int field1964;
   @ObfuscatedName("bq")
   static class184 field1965;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 463105433
   )
   int field1966;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1928494267
   )
   int field1967;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -292468535
   )
   int field1968;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2008542333
   )
   int field1969;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -882255289
   )
   int field1970;
   @ObfuscatedName("j")
   class142 field1971;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 24040571
   )
   int field1972;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1565315975
   )
   int field1973;
   @ObfuscatedName("f")
   class66 field1974;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 272747017
   )
   int field1975;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1220410861
   )
   int field1976;
   @ObfuscatedName("nr")
   static class57 field1977;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 11772487
   )
   int field1979;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "32"
   )
   void method2656() {
      this.field1971 = null;
      this.field1958 = null;
      this.field1963 = null;
      this.field1974 = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass145;B)V",
      garbageValue = "-90"
   )
   public static void method2658(class145 var0) {
      class210.field3130 = var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "17"
   )
   public static void method2659(Component var0) {
      var0.removeMouseListener(class115.mouse);
      var0.removeMouseMotionListener(class115.mouse);
      var0.removeFocusListener(class115.mouse);
      class115.field1803 = 0;
   }

   @ObfuscatedName("x")
   public static final void method2660(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            class33.method763(var0 - 1L);
            class33.method763(1L);
         } else {
            class33.method763(var0);
         }

      }
   }
}
