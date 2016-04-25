import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public final class class89 {
   @ObfuscatedName("s")
   public static String field1529;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1796255009
   )
   int field1530;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 827765405
   )
   int field1531;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -180944007
   )
   int field1532;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -226080955
   )
   int field1533;
   @ObfuscatedName("e")
   boolean field1534 = true;
   @ObfuscatedName("c")
   public static short[][] field1535;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1405278975
   )
   int field1536;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1697013465
   )
   int field1538;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass51;",
      garbageValue = "1848640170"
   )
   public static class51 method2081(int var0) {
      class51 var1 = (class51)class51.field1089.method3704((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class51.field1087.method3217(10, var0);
         var1 = new class51();
         var1.field1093 = var0;
         if(null != var2) {
            var1.method1029(new class119(var2));
         }

         var1.method1020();
         if(var1.field1139 != -1) {
            var1.method1023(method2081(var1.field1139), method2081(var1.field1125));
         }

         if(-1 != var1.field1116) {
            var1.method1046(method2081(var1.field1116), method2081(var1.field1134));
         }

         if(var1.field1137 != -1) {
            var1.method1024(method2081(var1.field1137), method2081(var1.field1113));
         }

         if(!class72.field1334 && var1.field1108) {
            var1.field1095 = "Members object";
            var1.field1127 = false;
            var1.field1088 = null;
            var1.field1110 = null;
            var1.field1130 = 0;
         }

         class51.field1089.method3706(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class89(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1536 = var1;
      this.field1530 = var2;
      this.field1531 = var3;
      this.field1532 = var4;
      this.field1533 = var5;
      this.field1538 = var6;
      this.field1534 = var7;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-400138161"
   )
   public static int method2082(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
