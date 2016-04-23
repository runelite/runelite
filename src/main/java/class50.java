import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class50 extends class204 {
   @ObfuscatedName("h")
   public static class193 field1077 = new class193(64);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1130299819
   )
   public int field1079 = 0;
   @ObfuscatedName("nn")
   @ObfuscatedGetter(
      intValue = -183365429
   )
   static int field1080;
   @ObfuscatedName("es")
   static class80[] field1081;
   @ObfuscatedName("j")
   public static class167 field1082;
   @ObfuscatedName("da")
   static int[] field1083;

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-992952313"
   )
   static final void method1009(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class148.method3106(var0, var1, class28.field655) - var2;
         var0 -= class122.field1991;
         var3 -= class115.field1952;
         var1 -= class24.field603;
         int var4 = class91.field1571[class154.field2276];
         int var5 = class91.field1572[class154.field2276];
         int var6 = class91.field1571[class17.field243];
         int var7 = class91.field1572[class17.field243];
         int var8 = var6 * var1 + var7 * var0 >> 16;
         var1 = var1 * var7 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var5 * var1 + var4 * var3 >> 16;
         if(var1 >= 50) {
            client.field277 = client.field505 / 2 + var0 * client.field539 / var1;
            client.field382 = client.field538 / 2 + client.field539 * var8 / var1;
         } else {
            client.field277 = -1;
            client.field382 = -1;
         }

      } else {
         client.field277 = -1;
         client.field382 = -1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "311735422"
   )
   void method1011(class119 var1, int var2) {
      if(var2 == 2) {
         this.field1079 = var1.method2502();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "-2047708450"
   )
   public void method1016(class119 var1) {
      while(true) {
         int var2 = var1.method2500();
         if(0 == var2) {
            return;
         }

         this.method1011(var1, var2);
      }
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-1029429534"
   )
   static final String[] method1017(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(null != var0 && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
