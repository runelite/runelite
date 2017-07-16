import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ko")
public class class289 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   public static final class289 field3857;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static final class289 field3849;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static final class289 field3851;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static final class289 field3859;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static final class289 field3853;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static final class289 field3852;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static final class289 field3855;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static final class289 field3856;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   public static final class289 field3860;
   @ObfuscatedName("m")
   @Export("identifier")
   final String identifier;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1994890307
   )
   public final int field3850;

   static {
      field3857 = new class289(1, 0, "", "");
      field3849 = new class289(0, 1, "", "");
      field3851 = new class289(8, 2, "", "");
      field3859 = new class289(2, 3, "", "");
      field3853 = new class289(3, 4, "", "");
      field3852 = new class289(6, 5, "", "");
      field3855 = new class289(7, 6, "", "");
      field3856 = new class289(5, 7, "", "");
      field3860 = new class289(4, -1, "", "", true, new class289[]{field3857, field3849, field3851, field3853, field3859});
   }

   class289(int var1, int var2, String var3, String var4) {
      this.field3850 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lko;)V"
   )
   class289(int var1, int var2, String var3, String var4, boolean var5, class289[] var6) {
      this.field3850 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
