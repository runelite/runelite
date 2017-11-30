import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kz")
@Implements("JagexLoginType")
public class JagexLoginType {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   public static final JagexLoginType field3931;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final JagexLoginType field3937;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final JagexLoginType field3930;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final JagexLoginType field3936;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final JagexLoginType field3932;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final JagexLoginType field3933;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final JagexLoginType field3934;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static final JagexLoginType field3935;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   public static final JagexLoginType field3929;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -484759017
   )
   public final int field3928;
   @ObfuscatedName("x")
   @Export("identifier")
   final String identifier;

   static {
      field3931 = new JagexLoginType(3, 0, "", "");
      field3937 = new JagexLoginType(5, 1, "", "");
      field3930 = new JagexLoginType(4, 2, "", "");
      field3936 = new JagexLoginType(8, 3, "", "");
      field3932 = new JagexLoginType(6, 4, "", "");
      field3933 = new JagexLoginType(2, 5, "", "");
      field3934 = new JagexLoginType(0, 6, "", "");
      field3935 = new JagexLoginType(1, 7, "", "");
      field3929 = new JagexLoginType(7, -1, "", "", true, new JagexLoginType[]{field3931, field3937, field3930, field3932, field3936});
   }

   JagexLoginType(int var1, int var2, String var3, String var4) {
      this.field3928 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lkz;)V"
   )
   JagexLoginType(int var1, int var2, String var3, String var4, boolean var5, JagexLoginType[] var6) {
      this.field3928 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
