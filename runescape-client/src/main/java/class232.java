import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class232 implements class178 {
   @ObfuscatedName("f")
   public static final class232 field3191;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1330403109
   )
   final int field3192;
   @ObfuscatedName("p")
   public static final class232 field3193;
   @ObfuscatedName("n")
   public static final class232 field3194;
   @ObfuscatedName("i")
   public static final class232 field3195;
   @ObfuscatedName("m")
   public static final class232 field3196;
   @ObfuscatedName("c")
   public final String field3197;
   @ObfuscatedName("j")
   public static final class232 field3198;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1469137335"
   )
   public int vmethod5059() {
      return this.field3192;
   }

   static {
      field3194 = new class232("runescape", "RuneScape", 0);
      field3193 = new class232("stellardawn", "Stellar Dawn", 1);
      field3195 = new class232("game3", "Game 3", 2);
      field3198 = new class232("game4", "Game 4", 3);
      field3191 = new class232("game5", "Game 5", 4);
      field3196 = new class232("oldscape", "RuneScape 2007", 5);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class232(String var1, String var2, int var3) {
      this.field3197 = var1;
      this.field3192 = var3;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "1571913639"
   )
   static final WidgetNode method4120(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field816 = var2;
      Client.componentTable.method3546(var3, (long)var0);
      class22.method183(var1);
      Widget var4 = class177.method3390(var0);
      CombatInfo1.method1515(var4);
      if(Client.field1147 != null) {
         CombatInfo1.method1515(Client.field1147);
         Client.field1147 = null;
      }

      Actor.method1512();
      class21.method174(Widget.widgets[var0 >> 16], var4, false);
      class270.method4919(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class73.method1095(var5)) {
            class261.method4764(Widget.widgets[var5], 1);
         }
      }

      return var3;
   }
}
