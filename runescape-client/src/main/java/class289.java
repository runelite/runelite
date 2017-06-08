import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ki")
public class class289 {
   @ObfuscatedName("n")
   public static final class289 field3847;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -914017367
   )
   public final int field3848;
   @ObfuscatedName("i")
   static final class289 field3849;
   @ObfuscatedName("j")
   static final class289 field3850;
   @ObfuscatedName("f")
   static final class289 field3851;
   @ObfuscatedName("m")
   static final class289 field3852;
   @ObfuscatedName("p")
   static final class289 field3853;
   @ObfuscatedName("e")
   final String field3854;
   @ObfuscatedName("h")
   public static final class289 field3855;
   @ObfuscatedName("z")
   static final class289 field3856;
   @ObfuscatedName("c")
   static final class289 field3857;

   class289(int var1, int var2, String var3, String var4, boolean var5, class289[] var6) {
      this.field3848 = var1;
      this.field3854 = var4;
   }

   class289(int var1, int var2, String var3, String var4) {
      this.field3848 = var1;
      this.field3854 = var4;
   }

   static {
      field3847 = new class289(1, 0, "", "");
      field3853 = new class289(0, 1, "", "");
      field3849 = new class289(4, 2, "", "");
      field3850 = new class289(3, 3, "", "");
      field3851 = new class289(6, 4, "", "");
      field3852 = new class289(8, 5, "", "");
      field3857 = new class289(2, 6, "", "");
      field3856 = new class289(7, 7, "", "");
      field3855 = new class289(5, -1, "", "", true, new class289[]{field3847, field3853, field3849, field3851, field3850});
   }

   public String toString() {
      return this.field3854;
   }
}
