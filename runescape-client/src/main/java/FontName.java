import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   public static final FontName field3753;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   public static final FontName field3757;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   public static final FontName field3755;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("NetCache_reference")
   public static Buffer NetCache_reference;
   @ObfuscatedName("l")
   final String field3756;
   @ObfuscatedName("y")
   String field3759;

   static {
      FontName_plain11 = new FontName("PLAIN11", "p11_full");
      FontName_plain12 = new FontName("PLAIN12", "p12_full");
      FontName_bold12 = new FontName("BOLD12", "b12_full");
      field3753 = new FontName("VERDANA11", "verdana_11pt_regular");
      field3757 = new FontName("VERDANA13", "verdana_13pt_regular");
      field3755 = new FontName("VERDANA15", "verdana_15pt_regular");
   }

   FontName(String var1, String var2) {
      this.field3756 = var1;
      this.field3759 = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[Lki;",
      garbageValue = "-827380966"
   )
   public static FontName[] method5426() {
      return new FontName[]{FontName_bold12, field3753, field3757, field3755, FontName_plain11, FontName_plain12};
   }
}
