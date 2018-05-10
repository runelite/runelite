import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
public class class278 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Liv;Ljava/lang/String;Ljava/lang/String;B)[Llh;",
      garbageValue = "14"
   )
   @Export("getIndexedSprites")
   public static IndexedSprite[] getIndexedSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite[] var5;
      if(!class306.method5702(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class142.method3182();
      }

      return var5;
   }
}
