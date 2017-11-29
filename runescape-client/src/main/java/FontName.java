import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final FontName field3685;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final FontName field3686;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static final FontName field3684;
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
      FontName_plain11 = new FontName("PLAIN11", "p11_full");
      FontName_plain12 = new FontName("PLAIN12", "p12_full");
      FontName_bold12 = new FontName("BOLD12", "b12_full");
      field3685 = new FontName("VERDANA11", "verdana_11pt_regular");
      field3686 = new FontName("VERDANA13", "verdana_13pt_regular");
      field3684 = new FontName("VERDANA15", "verdana_15pt_regular");
   }

   FontName(String var1, String var2) {
      this.field3688 = var1;
      this.field3689 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)[Ljk;",
      garbageValue = "122"
   )
   public static FontName[] method4912() {
      return new FontName[]{field3684, FontName_bold12, field3686, field3685, FontName_plain11, FontName_plain12};
   }
}
