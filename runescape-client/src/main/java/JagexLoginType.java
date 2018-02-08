import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ld")
@Implements("JagexLoginType")
public class JagexLoginType {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   public static final JagexLoginType field3966;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3973;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3968;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3967;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3970;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3971;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3969;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   static final JagexLoginType field3975;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   public static final JagexLoginType field3974;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1080136857
   )
   public final int field3972;
   @ObfuscatedName("c")
   @Export("identifier")
   final String identifier;

   static {
      field3966 = new JagexLoginType(0, 0, "", "");
      field3973 = new JagexLoginType(6, 1, "", "");
      field3968 = new JagexLoginType(5, 2, "", "");
      field3967 = new JagexLoginType(8, 3, "", "");
      field3970 = new JagexLoginType(7, 4, "", "");
      field3971 = new JagexLoginType(2, 5, "", "");
      field3969 = new JagexLoginType(1, 6, "", "");
      field3975 = new JagexLoginType(4, 7, "", "");
      field3974 = new JagexLoginType(3, -1, "", "", true, new JagexLoginType[]{field3966, field3973, field3968, field3970, field3967});
   }

   JagexLoginType(int var1, int var2, String var3, String var4) {
      this.field3972 = var1;
      this.identifier = var4;
   }

   @ObfuscatedSignature(
      signature = "(IILjava/lang/String;Ljava/lang/String;Z[Lld;)V"
   )
   JagexLoginType(int var1, int var2, String var3, String var4, boolean var5, JagexLoginType[] var6) {
      this.field3972 = var1;
      this.identifier = var4;
   }

   public String toString() {
      return this.identifier;
   }
}
