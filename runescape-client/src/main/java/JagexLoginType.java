import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ld")
@Implements("JagexLoginType")
public class JagexLoginType {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   public static final JagexLoginType field3973;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3974;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3975;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3976;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3981;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3978;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3979;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3980;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   public static final JagexLoginType field3977;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1685086039
   )
   public final int field3982;
   @ObfuscatedName("u")
   @Export("identifier")
   final String identifier;

   static {
      field3973 = new JagexLoginType(4, 0, "", "");
      field3974 = new JagexLoginType(0, 1, "", "");
      field3975 = new JagexLoginType(2, 2, "", "");
      field3976 = new JagexLoginType(7, 3, "", "");
      field3981 = new JagexLoginType(8, 4, "", "");
      field3978 = new JagexLoginType(6, 5, "", "");
      field3979 = new JagexLoginType(5, 6, "", "");
      field3980 = new JagexLoginType(3, 7, "", "");
      field3977 = new JagexLoginType(1, -1, "", "", true, new JagexLoginType[]{field3973, field3974, field3975, field3981, field3976});
   }

   JagexLoginType(int var1, int var2, String var3, String var4) {
      this.field3982 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lld;)V"
   )
   JagexLoginType(int var1, int var2, String var3, String var4, boolean var5, JagexLoginType[] var6) {
      this.field3982 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
