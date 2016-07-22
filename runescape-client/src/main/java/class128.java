import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public abstract class class128 {
   @ObfuscatedName("w")
   static boolean field2088 = false;
   @ObfuscatedName("l")
   public static class170 field2089;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = -674834651
   )
   protected static int field2092;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1384004890"
   )
   abstract byte[] vmethod2842();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1950818508"
   )
   abstract void vmethod2843(byte[] var1);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1094279003"
   )
   static void method2851(int var0) {
      class15 var1 = (class15)class15.field204.method3856((long)var0);
      if(null != var1) {
         var1.method3990();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)[Lclass81;",
      garbageValue = "-59"
   )
   static class81[] method2853() {
      class81[] var0 = new class81[class79.field1456];

      for(int var1 = 0; var1 < class79.field1456; ++var1) {
         class81 var2 = var0[var1] = new class81();
         var2.field1475 = class79.field1457;
         var2.field1481 = class79.field1458;
         var2.field1478 = class79.field1459[var1];
         var2.field1479 = class79.field1460[var1];
         var2.field1476 = class79.field1463[var1];
         var2.field1480 = class117.field2021[var1];
         int var3 = var2.field1476 * var2.field1480;
         byte[] var4 = class10.field151[var1];
         var2.field1486 = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.field1486[var5] = class79.field1462[var4[var5] & 255];
         }
      }

      class18.method191();
      return var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-106"
   )
   public static final boolean method2857(String var0, String var1, String var2, String var3) {
      return null != var0 && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }
}
