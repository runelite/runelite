import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class116 {
   @ObfuscatedName("w")
   Inflater field1993;

   class116(int var1, int var2, int var3) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass119;[BI)V",
      garbageValue = "-1669146748"
   )
   public void method2454(class119 var1, byte[] var2) {
      if(31 == var1.field2012[var1.field2011] && var1.field2012[1 + var1.field2011] == -117) {
         if(null == this.field1993) {
            this.field1993 = new Inflater(true);
         }

         try {
            this.field1993.setInput(var1.field2012, 10 + var1.field2011, var1.field2012.length - (10 + var1.field2011 + 8));
            this.field1993.inflate(var2);
         } catch (Exception var4) {
            this.field1993.reset();
            throw new RuntimeException("");
         }

         this.field1993.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("w")
   public static void method2455(class167 var0, class167 var1, class167 var2, class167 var3) {
      class138.field2153 = var0;
      class49.field1105 = var1;
      class173.field2760 = var2;
      class106.field1885 = var3;
      class173.field2830 = new class173[class138.field2153.method3299()][];
      class173.field2759 = new boolean[class138.field2153.method3299()];
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "29"
   )
   static final void method2456(int var0, int var1) {
      int var2 = class89.field1561.method4032("Choose Option");

      int var3;
      int var4;
      for(var3 = 0; var3 < client.field435; ++var3) {
         var4 = class89.field1561.method4032(class82.method1885(var3));
         if(var4 > var2) {
            var2 = var4;
         }
      }

      var2 += 8;
      var3 = 22 + client.field435 * 15;
      var4 = var0 - var2 / 2;
      if(var4 + var2 > class15.field235) {
         var4 = class15.field235 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var5 = var1;
      if(var1 + var3 > class15.field233) {
         var5 = class15.field233 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      client.field433 = true;
      client.field404 = var4;
      class18.field278 = var5;
      class14.field219 = var2;
      class0.field14 = 22 + client.field435 * 15;
   }

   public class116() {
      this(-1, 1000000, 1000000);
   }
}
