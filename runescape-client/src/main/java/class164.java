import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class164 {
   @ObfuscatedName("g")
   static final char[] field2686 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("h")
   static final char[] field2687 = new char[]{'[', ']', '#'};

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)V",
      garbageValue = "-2091641206"
   )
   static final void method3188(class122 var0) {
      var0.method2726();
      int var1 = client.field460;
      class2 var2 = class152.field2301 = client.field405[var1] = new class2();
      var2.field58 = var1;
      int var3 = var0.method2713(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.field847[0] = var5 - class89.field1565;
      var2.field809 = (var2.field847[0] << 7) + (var2.method30() << 6);
      var2.field839[0] = var6 - client.field358;
      var2.field804 = (var2.field839[0] << 7) + (var2.method30() << 6);
      class32.field754 = var2.field57 = var4;
      if(class32.field736[var1] != null) {
         var2.method12(class32.field736[var1]);
      }

      class32.field741 = 0;
      class32.field742[++class32.field741 - 1] = var1;
      class32.field738[var1] = 0;
      class32.field743 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2713(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class32.field756[var7] = (var10 << 14) + (var9 << 28) + var11;
            class32.field747[var7] = 0;
            class32.field740[var7] = -1;
            class32.field744[++class32.field743 - 1] = var7;
            class32.field738[var7] = 0;
         }
      }

      var0.method2714();
   }
}
