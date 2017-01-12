import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class39 {
   @ObfuscatedName("x")
   static final BigInteger field793 = new BigInteger("b4942fc64bfd8db2870cc8f544fd34adead420faa3cac1cef2474d30064445d483ef0aa7173a86eaa4c1f7a43555801a0bf273cdcd5078b7bef29aa1d662c6dad5f2da491db1c68310acfa763d97a18e874a6e0419b395e5cf20cdfd27d64b473a1edd2fa6104bddd3fe97aa3b524c6781704a76801719d38df22d9fe175d4a7", 16);
   @ObfuscatedName("q")
   static int[] field796;
   @ObfuscatedName("u")
   static final BigInteger field797 = new BigInteger("10001", 16);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass159;IB)V",
      garbageValue = "97"
   )
   static final void method735(class159 var0, int var1) {
      int var2 = var0.offset;
      class45.field895 = 0;
      class6.method96(var0);

      for(int var3 = 0; var3 < class45.field895; ++var3) {
         int var4 = class45.field904[var3];
         Player var5 = Client.cachedPlayers[var4];
         int var6 = var0.readUnsignedByte();
         if((var6 & 32) != 0) {
            var6 += var0.readUnsignedByte() << 8;
         }

         class10.method148(var0, var4, var5, var6);
      }

      if(var1 != var0.offset - var2) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1749664736"
   )
   public static int method736(int var0) {
      return var0 >> 17 & 7;
   }
}
