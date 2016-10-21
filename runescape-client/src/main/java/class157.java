import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class157 implements class115 {
   @ObfuscatedName("n")
   public static final class157 field2326 = new class157("game3", "Game 3", 2);
   @ObfuscatedName("e")
   public static final class157 field2327 = new class157("stellardawn", "Stellar Dawn", 1);
   @ObfuscatedName("v")
   public static final class157 field2328 = new class157("game5", "Game 5", 4);
   @ObfuscatedName("t")
   public static final class157 field2329 = new class157("game4", "Game 4", 3);
   @ObfuscatedName("f")
   public static final class157 field2330 = new class157("runescape", "RuneScape", 0);
   @ObfuscatedName("b")
   public static final class157 field2331 = new class157("oldscape", "RuneScape 2007", 5);
   @ObfuscatedName("m")
   public final String field2332;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -121436163
   )
   final int field2333;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class157(String var1, String var2, int var3) {
      this.field2332 = var1;
      this.field2333 = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;Lclass170;I)V",
      garbageValue = "-1516403759"
   )
   public static void method3185(class170 var0, class170 var1, class170 var2, class170 var3) {
      Widget.field2780 = var0;
      Widget.field2906 = var1;
      class167.field2697 = var2;
      class133.field2115 = var3;
      Widget.widgets = new Widget[Widget.field2780.method3295()][];
      Widget.validInterfaces = new boolean[Widget.field2780.method3295()];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "50702266"
   )
   public int vmethod3196() {
      return this.field2333;
   }
}
