import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("la")
@Implements("JagexLoginType")
public class JagexLoginType {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   public static final JagexLoginType field3878;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   static final JagexLoginType field3875;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   static final JagexLoginType field3877;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   static final JagexLoginType field3884;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   static final JagexLoginType field3879;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   static final JagexLoginType field3880;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   static final JagexLoginType field3881;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   static final JagexLoginType field3882;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   public static final JagexLoginType field3883;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1130586863
   )
   public final int field3876;
   @ObfuscatedName("l")
   @Export("identifier")
   final String identifier;

   static {
      field3878 = new JagexLoginType(0, 0, "", "");
      field3875 = new JagexLoginType(5, 1, "", "");
      field3877 = new JagexLoginType(3, 2, "", "");
      field3884 = new JagexLoginType(4, 3, "", "");
      field3879 = new JagexLoginType(8, 4, "", "");
      field3880 = new JagexLoginType(1, 5, "", "");
      field3881 = new JagexLoginType(7, 6, "", "");
      field3882 = new JagexLoginType(6, 7, "", "");
      field3883 = new JagexLoginType(2, -1, "", "", true, new JagexLoginType[]{field3878, field3875, field3877, field3879, field3884});
   }

   JagexLoginType(int var1, int var2, String var3, String var4) {
      this.field3876 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lla;)V"
   )
   JagexLoginType(int var1, int var2, String var3, String var4, boolean var5, JagexLoginType[] var6) {
      this.field3876 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
