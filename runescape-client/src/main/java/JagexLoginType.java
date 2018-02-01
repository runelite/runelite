import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ld")
@Implements("JagexLoginType")
public class JagexLoginType {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   public static final JagexLoginType field3962;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3963;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3956;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3958;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3959;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3960;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3961;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3957;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   public static final JagexLoginType field3955;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1452351683
   )
   public final int field3964;
   @ObfuscatedName("o")
   @Export("identifier")
   final String identifier;

   static {
      field3962 = new JagexLoginType(7, 0, "", "");
      field3963 = new JagexLoginType(1, 1, "", "");
      field3956 = new JagexLoginType(5, 2, "", "");
      field3958 = new JagexLoginType(4, 3, "", "");
      field3959 = new JagexLoginType(8, 4, "", "");
      field3960 = new JagexLoginType(3, 5, "", "");
      field3961 = new JagexLoginType(0, 6, "", "");
      field3957 = new JagexLoginType(2, 7, "", "");
      field3955 = new JagexLoginType(6, -1, "", "", true, new JagexLoginType[]{field3962, field3963, field3956, field3959, field3958});
   }

   JagexLoginType(int var1, int var2, String var3, String var4) {
      this.field3964 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lld;)V"
   )
   JagexLoginType(int var1, int var2, String var3, String var4, boolean var5, JagexLoginType[] var6) {
      this.field3964 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
