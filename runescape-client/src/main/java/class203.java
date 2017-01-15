import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class203 {
   @ObfuscatedName("u")
   public static final char[] field3061 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;B)V",
      garbageValue = "-95"
   )
   static final void method3801(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle + Client.mapScale & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class84.field1438[var6];
            int var9 = class84.field1428[var6];
            var8 = var8 * 256 / (256 + Client.mapScaleDelta);
            var9 = var9 * 256 / (256 + Client.mapScaleDelta);
            int var10 = var8 * var3 + var9 * var2 >> 16;
            int var11 = var9 * var3 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method4132(var5.field2143 / 2 + var10 - var4.field3205 / 2, var5.field2139 / 2 - var11 - var4.field3207 / 2, var0, var1, var5.field2143, var5.field2139, var5.field2138, var5.field2141);
            } else {
               var4.method4122(var5.field2143 / 2 + var0 + var10 - var4.field3205 / 2, var5.field2139 / 2 + var1 - var11 - var4.field3207 / 2);
            }
         }
      }

   }
}
