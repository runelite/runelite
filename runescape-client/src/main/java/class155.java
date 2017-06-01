import java.io.File;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public class class155 {
   @ObfuscatedName("b")
   public static File field2264;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 573797271
   )
   public static int field2265;
   @ObfuscatedName("o")
   public static class123 field2268;
   @ObfuscatedName("z")
   public static class123 field2269;
   @ObfuscatedName("q")
   public static class123 field2270;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1197186517
   )
   public static int field2271;
   @ObfuscatedName("g")
   public static String field2273;
   @ObfuscatedName("rn")
   static class291 field2275;

   static {
      field2268 = null;
      field2269 = null;
      field2270 = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "2066485001"
   )
   public static final boolean method2957(String var0, String var1, String var2, String var3) {
      return var0 != null && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }
}
