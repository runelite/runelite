import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lo")
@Implements("JagexLoginType")
public class JagexLoginType {
   @ObfuscatedName("qp")
   @ObfuscatedSignature(
      signature = "Lle;"
   )
   @Export("platformInfo")
   static MachineInfo platformInfo;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   public static final JagexLoginType field4071;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   static final JagexLoginType field4061;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   static final JagexLoginType field4062;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   static final JagexLoginType field4063;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   static final JagexLoginType field4064;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   static final JagexLoginType field4065;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   static final JagexLoginType field4069;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   static final JagexLoginType field4067;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   public static final JagexLoginType field4068;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1284733899
   )
   public final int field4070;
   @ObfuscatedName("d")
   @Export("identifier")
   final String identifier;

   static {
      field4071 = new JagexLoginType(3, 0, "", "");
      field4061 = new JagexLoginType(2, 1, "", "");
      field4062 = new JagexLoginType(5, 2, "", "");
      field4063 = new JagexLoginType(4, 3, "", "");
      field4064 = new JagexLoginType(8, 4, "", "");
      field4065 = new JagexLoginType(7, 5, "", "");
      field4069 = new JagexLoginType(1, 6, "", "");
      field4067 = new JagexLoginType(0, 7, "", "");
      field4068 = new JagexLoginType(6, -1, "", "", true, new JagexLoginType[]{field4071, field4061, field4062, field4064, field4063});
   }

   JagexLoginType(int var1, int var2, String var3, String var4) {
      this.field4070 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Llo;)V"
   )
   JagexLoginType(int var1, int var2, String var3, String var4, boolean var5, JagexLoginType[] var6) {
      this.field4070 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
