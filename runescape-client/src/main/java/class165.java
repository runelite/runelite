import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class165 {
   @ObfuscatedName("ey")
   static class78 field2656;
   @ObfuscatedName("b")
   public static final char[] field2657 = new char[]{'€', '\u0000', '‚', 'ƒ', '„', '…', '†', '‡', 'ˆ', '‰', 'Š', '‹', 'Œ', '\u0000', 'Ž', '\u0000', '\u0000', '‘', '’', '“', '”', '•', '–', '—', '˜', '™', 'š', '›', 'œ', '\u0000', 'ž', 'Ÿ'};

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Lclass173;",
      garbageValue = "955481630"
   )
   public static class173 method3247(int var0, int var1) {
      class173 var2 = class161.method3205(var0);
      return var1 == -1?var2:(var2 != null && var2.field2872 != null && var1 < var2.field2872.length?var2.field2872[var1]:null);
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "-1268505800"
   )
   static final void method3250(class173 var0, int var1, int var2) {
      if(null == client.field460 && !client.field428) {
         if(var0 != null && class29.method661(var0) != null) {
            client.field460 = var0;
            client.field461 = class29.method661(var0);
            client.field560 = var1;
            client.field463 = var2;
            class103.field1755 = 0;
            client.field545 = false;
            if(client.field429 > 0) {
               class110.method2434(client.field429 - 1);
            }

         }
      }
   }
}
