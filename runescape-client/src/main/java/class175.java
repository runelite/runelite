import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class175 {
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-102993708"
   )
   static final void method3181(int var0, int var1, int var2, int var3, int var4) {
      class211.field3121[0].method3995(var0, var1);
      class211.field3121[1].method3995(var0, var1 + var3 - 16);
      class219.method3899(var0, 16 + var1, 16, var3 - 32, Client.field359);
      int var5 = (var3 - 32) * var3 / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = var2 * (var3 - 32 - var5) / (var4 - var3);
      class219.method3899(var0, 16 + var1 + var6, 16, var5, Client.field568);
      class219.method3909(var0, 16 + var1 + var6, var5, Client.field353);
      class219.method3909(var0 + 1, 16 + var1 + var6, var5, Client.field353);
      class219.method3907(var0, var6 + var1 + 16, 16, Client.field353);
      class219.method3907(var0, var6 + 17 + var1, 16, Client.field353);
      class219.method3909(15 + var0, var6 + var1 + 16, var5, Client.field411);
      class219.method3909(14 + var0, var6 + var1 + 17, var5 - 1, Client.field411);
      class219.method3907(var0, var6 + var1 + 15 + var5, 16, Client.field411);
      class219.method3907(1 + var0, 14 + var1 + var6 + var5, 15, Client.field411);
   }
}
