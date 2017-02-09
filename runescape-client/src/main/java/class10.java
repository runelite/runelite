import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class10 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1761113109
   )
   int field86 = -1;
   @ObfuscatedName("o")
   int[] field88;
   @ObfuscatedName("r")
   String[] field89;
   @ObfuscatedName("k")
   class48 field90;
   @ObfuscatedName("bv")
   @Export("host")
   static String host;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "2147367971"
   )
   public static Object method125(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class163.field2284) {
            try {
               class158 var2 = new class158();
               var2.vmethod3148(var0);
               return var2;
            } catch (Throwable var3) {
               class163.field2284 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1151797488"
   )
   static final boolean method126(int var0, int var1) {
      ObjectComposition var2 = class156.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method3617(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2013500937"
   )
   public static int method127(int var0) {
      Varbit var1 = class0.method13(var0);
      int var2 = var1.leastSignificantBit;
      int var3 = var1.configId;
      int var4 = var1.mostSignificantBit;
      int var5 = class146.field2013[var4 - var3];
      return class146.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "-1124687927"
   )
   static final String method128(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class163.method3157(16711680):(var2 < -6?class163.method3157(16723968):(var2 < -3?class163.method3157(16740352):(var2 < 0?class163.method3157(16756736):(var2 > 9?class163.method3157('\uff00'):(var2 > 6?class163.method3157(4259584):(var2 > 3?class163.method3157(8453888):(var2 > 0?class163.method3157(12648192):class163.method3157(16776960))))))));
   }
}
