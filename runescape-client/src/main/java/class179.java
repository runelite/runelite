import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class179 implements class158 {
   @ObfuscatedName("p")
   static final class179 field2685 = new class179("game4", "Game 4", 3);
   @ObfuscatedName("d")
   static final class179 field2686 = new class179("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("h")
   static final class179 field2687 = new class179("game3", "Game 3", 2);
   @ObfuscatedName("r")
   public final String field2689;
   @ObfuscatedName("q")
   static final class179 field2690 = new class179("runescape", "RuneScape", 0);
   @ObfuscatedName("j")
   static final class179 field2691 = new class179("game5", "Game 5", 4);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -128468795
   )
   final int field2692;
   @ObfuscatedName("n")
   public static final class179 field2693 = new class179("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1991625382"
   )
   static void method3290() {
      class47.chatLineMap.clear();
      class47.field951.method2366();
      class47.field948.method2525();
      class47.field949 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "555633042"
   )
   public int vmethod4101() {
      return this.field2692;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class179(String var1, String var2, int var3) {
      this.field2689 = var1;
      this.field2692 = var3;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "-441265871"
   )
   public static Widget method3296(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(null == Widget.widgets[var1] || Widget.widgets[var1][var2] == null) {
         boolean var3 = class30.method696(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }
}
