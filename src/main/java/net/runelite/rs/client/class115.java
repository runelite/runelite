package net.runelite.rs.client;
import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dp")
public class class115 {
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -1669965781
   )
   static int field1977;
   @ObfuscatedName("aj")
   static class167 field1978;
   @ObfuscatedName("j")
   Inflater field1980;

   @ObfuscatedName("j")
   public void method2401(class118 var1, byte[] var2) {
      if(var1.field1995[var1.field1998] == 31 && var1.field1995[1 + var1.field1998] == -117) {
         if(this.field1980 == null) {
            this.field1980 = new Inflater(true);
         }

         try {
            this.field1980.setInput(var1.field1995, 10 + var1.field1998, var1.field1995.length - (8 + 10 + var1.field1998));
            this.field1980.inflate(var2);
         } catch (Exception var4) {
            this.field1980.reset();
            throw new RuntimeException("");
         }

         this.field1980.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   public class115() {
      this(-1, 1000000, 1000000);
   }

   class115(int var1, int var2, int var3) {
   }
}
