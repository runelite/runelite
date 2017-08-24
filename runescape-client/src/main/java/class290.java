import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
public class class290 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final class290 field3859;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static final class290 field3853;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static final class290 field3861;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static final class290 field3854;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static final class290 field3856;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static final class290 field3852;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static final class290 field3858;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static final class290 field3857;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   public static final class290 field3860;
   @ObfuscatedName("d")
   @Export("identifier")
   final String identifier;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -625431193
   )
   public final int field3855;

   static {
      field3859 = new class290(5, 0, "", "");
      field3853 = new class290(2, 1, "", "");
      field3861 = new class290(0, 2, "", "");
      field3854 = new class290(4, 3, "", "");
      field3856 = new class290(3, 4, "", "");
      field3852 = new class290(1, 5, "", "");
      field3858 = new class290(7, 6, "", "");
      field3857 = new class290(6, 7, "", "");
      field3860 = new class290(8, -1, "", "", true, new class290[]{field3859, field3853, field3861, field3856, field3854});
   }

   class290(int var1, int var2, String var3, String var4) {
      this.field3855 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lky;)V"
   )
   class290(int var1, int var2, String var3, String var4, boolean var5, class290[] var6) {
      this.field3855 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
