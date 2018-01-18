import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kh")
@Implements("JagexLoginType")
public class JagexLoginType {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final JagexLoginType field3935;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static final JagexLoginType field3927;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static final JagexLoginType field3926;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static final JagexLoginType field3934;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static final JagexLoginType field3930;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static final JagexLoginType field3931;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static final JagexLoginType field3932;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static final JagexLoginType field3928;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final JagexLoginType field3933;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1038038059
   )
   public final int field3929;
   @ObfuscatedName("z")
   @Export("identifier")
   final String identifier;

   static {
      field3935 = new JagexLoginType(0, 0, "", "");
      field3927 = new JagexLoginType(7, 1, "", "");
      field3926 = new JagexLoginType(5, 2, "", "");
      field3934 = new JagexLoginType(4, 3, "", "");
      field3930 = new JagexLoginType(3, 4, "", "");
      field3931 = new JagexLoginType(8, 5, "", "");
      field3932 = new JagexLoginType(6, 6, "", "");
      field3928 = new JagexLoginType(1, 7, "", "");
      field3933 = new JagexLoginType(2, -1, "", "", true, new JagexLoginType[]{field3935, field3927, field3926, field3930, field3934});
   }

   JagexLoginType(int var1, int var2, String var3, String var4) {
      this.field3929 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lkh;)V"
   )
   JagexLoginType(int var1, int var2, String var3, String var4, boolean var5, JagexLoginType[] var6) {
      this.field3929 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
