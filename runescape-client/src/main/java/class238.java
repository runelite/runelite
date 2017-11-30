import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class238 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("ItemDefinition_modelIndexCache")
   public static IndexDataBase ItemDefinition_modelIndexCache;
   @ObfuscatedName("ae")
   protected static boolean field3251;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgh;IB)Ljava/lang/String;",
      garbageValue = "41"
   )
   static String method4217(Buffer var0, int var1) {
      try {
         int var2 = var0.getUSmart();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class276.huffman.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = ScriptVarType.getString(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }
}
