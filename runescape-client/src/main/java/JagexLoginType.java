import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lu")
@Implements("JagexLoginType")
public class JagexLoginType {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   public static final JagexLoginType field4075;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   static final JagexLoginType field4068;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   static final JagexLoginType field4067;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   static final JagexLoginType field4070;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   static final JagexLoginType field4071;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   static final JagexLoginType field4072;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   static final JagexLoginType field4073;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   static final JagexLoginType field4077;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Llu;"
   )
   public static final JagexLoginType field4069;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -311779327
   )
   public final int field4076;
   @ObfuscatedName("n")
   @Export("identifier")
   final String identifier;

   static {
      field4075 = new JagexLoginType(2, 0, "", "");
      field4068 = new JagexLoginType(4, 1, "", "");
      field4067 = new JagexLoginType(0, 2, "", "");
      field4070 = new JagexLoginType(8, 3, "", "");
      field4071 = new JagexLoginType(3, 4, "", "");
      field4072 = new JagexLoginType(5, 5, "", "");
      field4073 = new JagexLoginType(1, 6, "", "");
      field4077 = new JagexLoginType(7, 7, "", "");
      field4069 = new JagexLoginType(6, -1, "", "", true, new JagexLoginType[]{field4075, field4068, field4067, field4071, field4070});
   }

   JagexLoginType(int var1, int var2, String var3, String var4) {
      this.field4076 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Llu;)V"
   )
   JagexLoginType(int var1, int var2, String var3, String var4, boolean var5, JagexLoginType[] var6) {
      this.field4076 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
