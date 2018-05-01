import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
@Implements("JagexLoginType")
public class JagexLoginType {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   public static final JagexLoginType field4069;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   static final JagexLoginType field4067;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   static final JagexLoginType field4077;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   static final JagexLoginType field4074;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   static final JagexLoginType field4070;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   static final JagexLoginType field4071;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   static final JagexLoginType field4066;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   static final JagexLoginType field4073;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   public static final JagexLoginType field4068;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 707083287
   )
   public final int field4075;
   @ObfuscatedName("i")
   @Export("identifier")
   final String identifier;

   static {
      field4069 = new JagexLoginType(0, 0, "", "");
      field4067 = new JagexLoginType(2, 1, "", "");
      field4077 = new JagexLoginType(5, 2, "", "");
      field4074 = new JagexLoginType(6, 3, "", "");
      field4070 = new JagexLoginType(1, 4, "", "");
      field4071 = new JagexLoginType(8, 5, "", "");
      field4066 = new JagexLoginType(3, 6, "", "");
      field4073 = new JagexLoginType(7, 7, "", "");
      field4068 = new JagexLoginType(4, -1, "", "", true, new JagexLoginType[]{field4069, field4067, field4077, field4070, field4074});
   }

   JagexLoginType(int var1, int var2, String var3, String var4) {
      this.field4075 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lly;)V"
   )
   JagexLoginType(int var1, int var2, String var3, String var4, boolean var5, JagexLoginType[] var6) {
      this.field4075 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }

   public String aac() {
      return this.identifier;
   }

   public String aad() {
      return this.identifier;
   }
}
