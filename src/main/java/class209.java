import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public final class class209 {
   @ObfuscatedName("q")
   static int[][] field3126;

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;I)V",
      garbageValue = "16711935"
   )
   static final void method4007(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field379 + client.field443 & 2047;
         int var8 = class91.field1593[var7];
         int var9 = class91.field1594[var7];
         var8 = 256 * var8 / (256 + client.field368);
         var9 = var9 * 256 / (client.field368 + 256);
         int var10 = var9 * var2 + var8 * var3 >> 16;
         int var11 = var9 * var3 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class17.field268.method1810(var14 + var0 + 94 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class95.method2255(var0, var1, var2, var3, var4, var5);
      }

   }
}
