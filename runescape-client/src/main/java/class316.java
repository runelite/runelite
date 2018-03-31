import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lu")
public final class class316 {
   @ObfuscatedName("c")
   public static final char[] field3922;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   static IndexDataBase field3919;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1669544623
   )
   @Export("idxCount")
   public static int idxCount;

   static {
      field3922 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljava/lang/String;Ljava/lang/String;I)[Lla;",
      garbageValue = "-52263419"
   )
   @Export("getSprites")
   public static SpritePixels[] getSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return Parameters.method5208(var0, var3, var4);
   }
}
