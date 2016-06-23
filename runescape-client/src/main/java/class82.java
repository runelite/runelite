import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public class class82 implements class112 {
   @ObfuscatedName("l")
   static final class82 field1435 = new class82(4, 4);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -893929535
   )
   final int field1437;
   @ObfuscatedName("f")
   public static final class82 field1438 = new class82(0, 0);
   @ObfuscatedName("u")
   static final class82 field1439 = new class82(1, 1);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1573270551
   )
   public final int field1440;
   @ObfuscatedName("b")
   static final class82 field1441 = new class82(3, 3);
   @ObfuscatedName("x")
   static final class82 field1443 = new class82(2, 2);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "69"
   )
   public int vmethod3194() {
      return this.field1437;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class82(int var1, int var2) {
      this.field1440 = var1;
      this.field1437 = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "758595501"
   )
   public static String method1948(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < 0 + var2; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class161.field2639[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class161.field2639[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class161.field2639[(var6 & 15) << 2 | var7 >>> 6]).append(class161.field2639[var7 & 63]);
            } else {
               var3.append(class161.field2639[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class161.field2639[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }
}
