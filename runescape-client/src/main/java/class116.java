import java.lang.management.GarbageCollectorMXBean;
import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class116 {
   @ObfuscatedName("t")
   Inflater field1987;
   @ObfuscatedName("pg")
   static class8 field1988;
   @ObfuscatedName("pw")
   static GarbageCollectorMXBean field1989;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1"
   )
   class116(int var1, int var2, int var3) {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass119;[BI)V",
      garbageValue = "-554498053"
   )
   public void method2412(class119 var1, byte[] var2) {
      if(var1.field2001[var1.field2000] == 31 && var1.field2001[1 + var1.field2000] == -117) {
         if(null == this.field1987) {
            this.field1987 = new Inflater(true);
         }

         try {
            this.field1987.setInput(var1.field2001, 10 + var1.field2000, var1.field2001.length - (var1.field2000 + 10 + 8));
            this.field1987.inflate(var2);
         } catch (Exception var4) {
            this.field1987.reset();
            throw new RuntimeException("");
         }

         this.field1987.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   public class116() {
      this(-1, 1000000, 1000000);
   }
}
