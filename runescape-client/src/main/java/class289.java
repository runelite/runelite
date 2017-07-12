import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("kq")
public class class289 {
   @ObfuscatedName("i")
   public static final class289 field3862;
   @ObfuscatedName("w")
   static final class289 field3863;
   @ObfuscatedName("a")
   static final class289 field3855;
   @ObfuscatedName("t")
   static final class289 field3854;
   @ObfuscatedName("s")
   static final class289 field3857;
   @ObfuscatedName("r")
   static final class289 field3858;
   @ObfuscatedName("v")
   static final class289 field3856;
   @ObfuscatedName("y")
   static final class289 field3860;
   @ObfuscatedName("j")
   public static final class289 field3861;
   @ObfuscatedName("e")
   @Export("identifier")
   final String identifier;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1236187165
   )
   public final int field3859;

   static {
      field3862 = new class289(0, 0, "", "");
      field3863 = new class289(2, 1, "", "");
      field3855 = new class289(1, 2, "", "");
      field3854 = new class289(8, 3, "", "");
      field3857 = new class289(5, 4, "", "");
      field3858 = new class289(4, 5, "", "");
      field3856 = new class289(6, 6, "", "");
      field3860 = new class289(7, 7, "", "");
      field3861 = new class289(3, -1, "", "", true, new class289[]{field3862, field3863, field3855, field3857, field3854});
   }

   class289(int var1, int var2, String var3, String var4) {
      this.field3859 = var1;
      this.identifier = var4;
   }

   class289(int var1, int var2, String var3, String var4, boolean var5, class289[] var6) {
      this.field3859 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
