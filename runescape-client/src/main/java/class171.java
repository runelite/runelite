import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
public class class171 {
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "8"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3201 != 0 && var3 > IndexDataBase.field3201) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 >= 0 && (IndexDataBase.field3201 == 0 || var6 <= IndexDataBase.field3201)) {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class168.method3123(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Ljg;",
      garbageValue = "120174997"
   )
   public static class277 method3153(int var0) {
      class277[] var1 = ObjectComposition.method4549();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class277 var3 = var1[var2];
         if(var0 == var3.field3714) {
            return var3;
         }
      }

      return null;
   }
}
