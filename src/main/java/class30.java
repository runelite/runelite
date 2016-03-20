import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ak")
public class class30 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1487696373
   )
   int field703;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 150978511
   )
   int field704;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -626093601
   )
   int field705;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1215832233
   )
   int field706;
   @ObfuscatedName("y")
   String field707;
   @ObfuscatedName("j")
   static byte[][] field708;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -1824498913
   )
   static int field709;
   @ObfuscatedName("fc")
   @ObfuscatedGetter(
      intValue = -125723295
   )
   @Export("cameraZ")
   static int field713;

   @ObfuscatedName("f")
   public static class80[] method664(class166 var0, String var1, String var2) {
      int var3 = var0.method3278(var1);
      int var4 = var0.method3328(var3, var2);
      class80[] var5;
      if(!class12.method176(var0, var3, var4)) {
         var5 = null;
      } else {
         class80[] var7 = new class80[class76.field1385];

         for(int var8 = 0; var8 < class76.field1385; ++var8) {
            class80 var9 = var7[var8] = new class80();
            var9.field1422 = class76.field1379;
            var9.field1416 = class76.field1381;
            var9.field1419 = class76.field1386[var8];
            var9.field1421 = class76.field1382[var8];
            var9.field1418 = class102.field1764[var8];
            var9.field1417 = class76.field1383[var8];
            var9.field1420 = class115.field1968;
            var9.field1423 = field708[var8];
         }

         class1.method7();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("f")
   public static int method665(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 & 858993459) + (var0 >>> 2 & 858993459);
      var0 = (var0 >>> 4) + var0 & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("n")
   public static void method666() {
      class178.field2913.method3800();
   }
}
