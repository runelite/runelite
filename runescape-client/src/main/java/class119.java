import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public class class119 {
   @ObfuscatedName("l")
   Inflater field2036;
   @ObfuscatedName("db")
   static int[] field2037;
   @ObfuscatedName("bq")
   static class171 field2039;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class119(int var1, int var2, int var3) {
   }

   public class119() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass122;[BI)V",
      garbageValue = "1837323007"
   )
   public void method2570(class122 var1, byte[] var2) {
      if(var1.field2051[var1.field2050] == 31 && var1.field2051[1 + var1.field2050] == -117) {
         if(null == this.field2036) {
            this.field2036 = new Inflater(true);
         }

         try {
            this.field2036.setInput(var1.field2051, 10 + var1.field2050, var1.field2051.length - (10 + var1.field2050 + 8));
            this.field2036.inflate(var2);
         } catch (Exception var4) {
            this.field2036.reset();
            throw new RuntimeException("");
         }

         this.field2036.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass170;IB)Lclass83;",
      garbageValue = "-95"
   )
   public static class83 method2573(class170 var0, int var1) {
      if(!class24.method614(var0, var1)) {
         return null;
      } else {
         class83 var3 = new class83();
         var3.field1496 = class79.field1454;
         var3.field1502 = class79.field1456;
         var3.field1500 = class79.field1457[0];
         var3.field1501 = class180.field2962[0];
         var3.field1498 = class192.field3106[0];
         var3.field1503 = class79.field1458[0];
         var3.field1497 = class79.field1459;
         var3.field1499 = class145.field2236[0];
         class55.method1182();
         return var3;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass156;",
      garbageValue = "99649005"
   )
   public static class156 method2574(int var0) {
      class156[] var1 = new class156[]{class156.field2339, class156.field2334, class156.field2335, class156.field2333};
      class156[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class156 var4 = var2[var3];
         if(var4.field2337 == var0) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-48"
   )
   static boolean method2575(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }
}
