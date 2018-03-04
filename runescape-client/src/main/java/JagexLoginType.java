import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lt")
@Implements("JagexLoginType")
public class JagexLoginType {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   public static final JagexLoginType field4066;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   static final JagexLoginType field4067;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   static final JagexLoginType field4064;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   static final JagexLoginType field4065;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   static final JagexLoginType field4062;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   static final JagexLoginType field4069;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   static final JagexLoginType field4068;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   static final JagexLoginType field4063;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Llt;"
   )
   public static final JagexLoginType field4070;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 957138479
   )
   public final int field4071;
   @ObfuscatedName("m")
   @Export("identifier")
   final String identifier;

   static {
      field4066 = new JagexLoginType(4, 0, "", "");
      field4067 = new JagexLoginType(8, 1, "", "");
      field4064 = new JagexLoginType(1, 2, "", "");
      field4065 = new JagexLoginType(2, 3, "", "");
      field4062 = new JagexLoginType(0, 4, "", "");
      field4069 = new JagexLoginType(3, 5, "", "");
      field4068 = new JagexLoginType(7, 6, "", "");
      field4063 = new JagexLoginType(5, 7, "", "");
      field4070 = new JagexLoginType(6, -1, "", "", true, new JagexLoginType[]{field4066, field4067, field4064, field4062, field4065});
   }

   JagexLoginType(int var1, int var2, String var3, String var4) {
      this.field4071 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Llt;)V"
   )
   JagexLoginType(int var1, int var2, String var3, String var4, boolean var5, JagexLoginType[] var6) {
      this.field4071 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
