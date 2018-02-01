import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class228 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lik;Ljava/lang/String;Ljava/lang/String;I)[Lkh;",
      garbageValue = "-1372490908"
   )
   @Export("getIndexedSprites")
   public static IndexedSprite[] getIndexedSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return ScriptEvent.method1075(var0, var3, var4);
   }
}
