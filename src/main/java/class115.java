import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class115 {
   @ObfuscatedName("m")
   static int[] field1968;
   @ObfuscatedName("a")
   Inflater field1969;

   @ObfuscatedName("f")
   static char method2452(char var0) {
      return (char)(var0 == 198?'E':(230 == var0?'e':(223 == var0?'s':(var0 == 338?'E':(339 == var0?'e':'\u0000')))));
   }

   class115(int var1, int var2, int var3) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass118;[BI)V",
      garbageValue = "707866111"
   )
   public void method2453(class118 var1, byte[] var2) {
      if(31 == var1.field1980[var1.field1979] && var1.field1980[var1.field1979 + 1] == -117) {
         if(null == this.field1969) {
            this.field1969 = new Inflater(true);
         }

         try {
            this.field1969.setInput(var1.field1980, var1.field1979 + 10, var1.field1980.length - (8 + var1.field1979 + 10));
            this.field1969.inflate(var2);
         } catch (Exception var4) {
            this.field1969.reset();
            throw new RuntimeException("");
         }

         this.field1969.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   public class115() {
      this(-1, 1000000, 1000000);
   }
}
