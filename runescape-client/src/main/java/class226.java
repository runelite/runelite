import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class226 {
   @ObfuscatedName("gs")
   static SpritePixels[] field3144;
   @ObfuscatedName("of")
   @Export("clanChatRank")
   static byte clanChatRank;

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "686687893"
   )
   static final byte[] method3966(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3222 != 0 && var3 > IndexDataBase.field3222) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 >= 0 && (IndexDataBase.field3222 == 0 || var6 <= IndexDataBase.field3222)) {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class167.method2976(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.field3234.method2971(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }
}
