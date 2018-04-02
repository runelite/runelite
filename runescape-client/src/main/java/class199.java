import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class199 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljava/lang/String;Ljava/lang/String;B)[Llq;",
      garbageValue = "0"
   )
   @Export("getIndexedSprites")
   public static IndexedSprite[] getIndexedSprites(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite[] var5;
      if(!class288.method5204(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class189.method3485();
      }

      return var5;
   }
}
