import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class119 {
   @ObfuscatedName("e")
   Inflater field2040;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1217182913
   )
   public static int field2041;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;[BI)V",
      garbageValue = "1551959874"
   )
   public void method2545(class122 var1, byte[] var2) {
      if(var1.field2054[var1.field2061] == 31 && var1.field2054[1 + var1.field2061] == -117) {
         if(this.field2040 == null) {
            this.field2040 = new Inflater(true);
         }

         try {
            this.field2040.setInput(var1.field2054, 10 + var1.field2061, var1.field2054.length - (8 + var1.field2061 + 10));
            this.field2040.inflate(var2);
         } catch (Exception var4) {
            this.field2040.reset();
            throw new RuntimeException("");
         }

         this.field2040.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class119(int var1, int var2, int var3) {
   }

   public class119() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)[Lclass83;",
      garbageValue = "1938140758"
   )
   static class83[] method2549() {
      class83[] var0 = new class83[class79.field1450];

      for(int var1 = 0; var1 < class79.field1450; ++var1) {
         class83 var2 = var0[var1] = new class83();
         var2.field1485 = class79.field1458;
         var2.field1484 = class79.field1452;
         var2.field1488 = class79.field1449[var1];
         var2.field1491 = class11.field192[var1];
         var2.field1486 = class138.field2134[var1];
         var2.field1489 = class169.field2703[var1];
         var2.field1487 = class178.field2941;
         var2.field1490 = class93.field1626[var1];
      }

      class52.method1134();
      return var0;
   }
}
