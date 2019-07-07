import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lx")
@Implements("LoginType")
public class LoginType {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   public static final LoginType field479;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   static final LoginType field480;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   static final LoginType field481;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   static final LoginType field482;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   static final LoginType field483;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   static final LoginType field484;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   static final LoginType field485;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   static final LoginType field486;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   public static final LoginType field487;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1916729379
   )
   public final int field488;
   @ObfuscatedName("d")
   final String field489;

   LoginType(int var1, int var2, String var3, String var4) {
      this.field488 = var1;
      this.field489 = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Llx;)V"
   )
   LoginType(int var1, int var2, String var3, String var4, boolean var5, LoginType[] var6) {
      this.field488 = var1;
      this.field489 = var4;
   }

   public String toString() {
      return this.field489;
   }

   static {
      field479 = new LoginType(8, 0, "", "");
      field480 = new LoginType(3, 1, "", "");
      field481 = new LoginType(2, 2, "", "");
      field482 = new LoginType(6, 3, "", "");
      field483 = new LoginType(4, 4, "", "");
      field484 = new LoginType(7, 5, "", "");
      field485 = new LoginType(1, 6, "", "");
      field486 = new LoginType(5, 7, "", "");
      field487 = new LoginType(0, -1, "", "", true, new LoginType[]{field479, field480, field481, field483, field482});
   }
}
