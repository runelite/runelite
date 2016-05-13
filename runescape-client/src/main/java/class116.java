import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class116 {
   @ObfuscatedName("s")
   Inflater field1992;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1"
   )
   class116(int var1, int var2, int var3) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass119;[BI)V",
      garbageValue = "-676745102"
   )
   public void method2445(class119 var1, byte[] var2) {
      if(31 == var1.field2007[var1.field2005] && -117 == var1.field2007[1 + var1.field2005]) {
         if(this.field1992 == null) {
            this.field1992 = new Inflater(true);
         }

         try {
            this.field1992.setInput(var1.field2007, 10 + var1.field2005, var1.field2007.length - (8 + var1.field2005 + 10));
            this.field1992.inflate(var2);
         } catch (Exception var4) {
            this.field1992.reset();
            throw new RuntimeException("");
         }

         this.field1992.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   public class116() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("s")
   public static final void method2448(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            class15.method193(var0 - 1L);
            class15.method193(1L);
         } else {
            class15.method193(var0);
         }
      }

   }
}
