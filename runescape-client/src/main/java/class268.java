import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
public class class268 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final class268 field3687;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final class268 field3690;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final class268 field3683;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final class268 field3685;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final class268 field3686;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final class268 field3684;
   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "Lcm;"
   )
   @Export("topContextMenuRow")
   static ContextMenuRow topContextMenuRow;
   @ObfuscatedName("b")
   final String field3688;
   @ObfuscatedName("t")
   String field3689;

   static {
      field3687 = new class268("PLAIN11", "p11_full");
      field3690 = new class268("PLAIN12", "p12_full");
      field3683 = new class268("BOLD12", "b12_full");
      field3685 = new class268("VERDANA11", "verdana_11pt_regular");
      field3686 = new class268("VERDANA13", "verdana_13pt_regular");
      field3684 = new class268("VERDANA15", "verdana_15pt_regular");
   }

   class268(String var1, String var2) {
      this.field3688 = var1;
      this.field3689 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)[Ljk;",
      garbageValue = "122"
   )
   public static class268[] method4912() {
      return new class268[]{field3684, field3683, field3686, field3685, field3687, field3690};
   }
}
