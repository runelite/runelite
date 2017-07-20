import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
public class class289 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   public static final class289 field3845;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   static final class289 field3841;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   static final class289 field3842;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   static final class289 field3843;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   static final class289 field3848;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   static final class289 field3846;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   static final class289 field3840;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   static final class289 field3847;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   public static final class289 field3844;
   @ObfuscatedName("r")
   @Export("identifier")
   final String identifier;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1043081339
   )
   public final int field3849;

   static {
      field3845 = new class289(4, 0, "", "");
      field3841 = new class289(2, 1, "", "");
      field3842 = new class289(8, 2, "", "");
      field3843 = new class289(3, 3, "", "");
      field3848 = new class289(7, 4, "", "");
      field3846 = new class289(0, 5, "", "");
      field3840 = new class289(5, 6, "", "");
      field3847 = new class289(6, 7, "", "");
      field3844 = new class289(1, -1, "", "", true, new class289[]{field3845, field3841, field3842, field3848, field3843});
   }

   class289(int var1, int var2, String var3, String var4) {
      this.field3849 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lkb;)V"
   )
   class289(int var1, int var2, String var3, String var4, boolean var5, class289[] var6) {
      this.field3849 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
