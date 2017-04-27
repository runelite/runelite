import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class170 {
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1881273783"
   )
   static final byte[] method3184(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field2724 != 0 && var3 > IndexDataBase.field2724) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var6 = new byte[var3];
         var1.readBytes(var6, 0, var3);
         return var6;
      } else {
         int var4 = var1.readInt();
         if(var4 >= 0 && (IndexDataBase.field2724 == 0 || var4 <= IndexDataBase.field2724)) {
            byte[] var5 = new byte[var4];
            if(var2 == 1) {
               class123.method2320(var5, var4, var0, var3, 9);
            } else {
               IndexDataBase.field2713.method2313(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }

   class170() throws Throwable {
      throw new Error();
   }
}
