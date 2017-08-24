import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class139 {
   @ObfuscatedName("z")
   @Export("cacheLocations")
   public static String[] cacheLocations;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lii;Ljava/lang/String;Ljava/lang/String;I)[Ljx;",
      garbageValue = "-1089231950"
   )
   public static IndexedSprite[] method2909(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return Signlink.method3029(var0, var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-1262311789"
   )
   public static final boolean method2908(String var0, String var1, String var2, String var3) {
      return var0 != null && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }
}
