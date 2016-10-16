import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class32 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1772344329
   )
   int field691;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -865122633
   )
   int field692;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -645994883
   )
   int field693;
   @ObfuscatedName("t")
   String field694;
   @ObfuscatedName("ci")
   static class146 field695;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1894550831
   )
   int field699;

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1300207014"
   )
   static final void method684(int var0, int var1) {
      if(class174.method3393(var0)) {
         class112.method2393(Widget.widgets[var0], var1);
      }
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-435867489"
   )
   static void method685(Widget var0) {
      if(var0.field2930 == Client.field505) {
         Client.field379[var0.boundsIndex] = true;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "-1546477981"
   )
   public static int method686(String var0) {
      return var0.length() + 2;
   }
}
