import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public final class class279 {
   @ObfuscatedName("a")
   public static final char[] field3739;
   @ObfuscatedName("ak")
   static java.awt.Font field3737;

   static {
      field3739 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lib;Ljava/lang/String;Ljava/lang/String;I)Lkg;",
      garbageValue = "2107804032"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!Parameters.spriteDataValid(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = MilliTimer.method2946();
      }

      return var5;
   }
}
