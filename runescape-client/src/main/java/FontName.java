import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
@Implements("FontName")
public class FontName {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   @Export("FontName_plain11")
   public static final FontName FontName_plain11;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   @Export("FontName_plain12")
   public static final FontName FontName_plain12;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   @Export("FontName_bold12")
   public static final FontName FontName_bold12;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   public static final FontName field3723;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   public static final FontName field3733;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   public static final FontName field3734;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = 1042752701
   )
   static int field3729;
   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field3732;
   @ObfuscatedName("jo")
   @ObfuscatedGetter(
      intValue = -413449205
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("t")
   final String field3726;
   @ObfuscatedName("r")
   String field3727;

   static {
      FontName_plain11 = new FontName("PLAIN11", "p11_full");
      FontName_plain12 = new FontName("PLAIN12", "p12_full");
      FontName_bold12 = new FontName("BOLD12", "b12_full");
      field3723 = new FontName("VERDANA11", "verdana_11pt_regular");
      field3733 = new FontName("VERDANA13", "verdana_13pt_regular");
      field3734 = new FontName("VERDANA15", "verdana_15pt_regular");
   }

   FontName(String var1, String var2) {
      this.field3726 = var1;
      this.field3727 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)[Ljo;",
      garbageValue = "4344"
   )
   public static FontName[] method5195() {
      return new FontName[]{field3733, FontName_plain11, field3723, FontName_bold12, FontName_plain12, field3734};
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[Lcu;",
      garbageValue = "-69301122"
   )
   static AttackOption[] method5194() {
      return new AttackOption[]{AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_leftClickWhereAvailable, AttackOption.AttackOption_hidden, AttackOption.AttackOption_dependsOnCombatLevels};
   }
}
