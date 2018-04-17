import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lh")
@Implements("JagexLoginType")
public class JagexLoginType {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   public static final JagexLoginType field4069;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static final JagexLoginType field4065;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static final JagexLoginType field4072;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static final JagexLoginType field4067;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static final JagexLoginType field4066;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static final JagexLoginType field4075;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static final JagexLoginType field4064;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static final JagexLoginType field4071;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   public static final JagexLoginType field4070;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1882347477
   )
   public final int field4073;
   @ObfuscatedName("y")
   @Export("identifier")
   final String identifier;

   static {
      field4069 = new JagexLoginType(8, 0, "", "");
      field4065 = new JagexLoginType(1, 1, "", "");
      field4072 = new JagexLoginType(0, 2, "", "");
      field4067 = new JagexLoginType(2, 3, "", "");
      field4066 = new JagexLoginType(3, 4, "", "");
      field4075 = new JagexLoginType(6, 5, "", "");
      field4064 = new JagexLoginType(7, 6, "", "");
      field4071 = new JagexLoginType(5, 7, "", "");
      field4070 = new JagexLoginType(4, -1, "", "", true, new JagexLoginType[]{field4069, field4065, field4072, field4066, field4067});
   }

   JagexLoginType(int var1, int var2, String var3, String var4) {
      this.field4073 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Llh;)V"
   )
   JagexLoginType(int var1, int var2, String var3, String var4, boolean var5, JagexLoginType[] var6) {
      this.field4073 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
