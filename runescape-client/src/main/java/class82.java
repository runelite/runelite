import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class82 implements class112 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1241877673
   )
   public final int field1398;
   @ObfuscatedName("j")
   static final class82 field1399 = new class82(2, 2);
   @ObfuscatedName("g")
   static final class82 field1400 = new class82(1, 1);
   @ObfuscatedName("x")
   static final class82 field1401 = new class82(4, 4);
   @ObfuscatedName("b")
   public static final class82 field1402 = new class82(0, 0);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -928572917
   )
   final int field1403;
   @ObfuscatedName("d")
   static final class82 field1404 = new class82(3, 3);
   @ObfuscatedName("bj")
   static class80[] field1405;
   @ObfuscatedName("e")
   static int[] field1406;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1527751197"
   )
   static void method1890(int var0) {
      class15 var1 = (class15)class15.field221.method3807((long)var0);
      if(null != var1) {
         for(int var2 = 0; var2 < var1.field216.length; ++var2) {
            var1.field216[var2] = -1;
            var1.field217[var2] = 0;
         }

      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "977914203"
   )
   public int vmethod3185() {
      return this.field1403;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "1033507223"
   )
   public static void method1892(class167 var0) {
      class21.field584 = var0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1799480539"
   )
   public static String method1896(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 402) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class82(int var1, int var2) {
      this.field1398 = var1;
      this.field1403 = var2;
   }
}
