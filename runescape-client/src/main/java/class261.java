import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
public class class261 {
   @ObfuscatedName("c")
   public static final class261 field3617;
   @ObfuscatedName("y")
   public static final class261 field3618;
   @ObfuscatedName("e")
   public static final class261 field3619;
   @ObfuscatedName("v")
   public static final class261 field3620;
   @ObfuscatedName("b")
   public static final class261 field3621;
   @ObfuscatedName("h")
   final String field3622;
   @ObfuscatedName("i")
   public static final class261 field3623;
   @ObfuscatedName("x")
   String field3624;
   @ObfuscatedName("ct")
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = 1111520681
   )
   static int field3626;

   static {
      field3623 = new class261("PLAIN11", "p11_full");
      field3617 = new class261("PLAIN12", "p12_full");
      field3619 = new class261("BOLD12", "b12_full");
      field3620 = new class261("VERDANA11", "verdana_11pt_regular");
      field3621 = new class261("VERDANA13", "verdana_13pt_regular");
      field3618 = new class261("VERDANA15", "verdana_15pt_regular");
   }

   class261(String var1, String var2) {
      this.field3622 = var1;
      this.field3624 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[Lclass261;",
      garbageValue = "772726848"
   )
   public static class261[] method4711() {
      return new class261[]{field3618, field3621, field3620, field3623, field3617, field3619};
   }
}
