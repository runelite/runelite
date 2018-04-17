import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
public class class243 {
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = 2085892313
   )
   @Export("port2")
   static int port2;
   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   static TextureProvider field2961;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljf;IB)Lll;",
      garbageValue = "1"
   )
   public static IndexedSprite method4486(IndexDataBase var0, int var1) {
      byte[] var3 = var0.takeRecordFlat(var1);
      boolean var2;
      if(var3 == null) {
         var2 = false;
      } else {
         Area.decodeSprite(var3);
         var2 = true;
      }

      return !var2?null:class155.method3159();
   }
}
