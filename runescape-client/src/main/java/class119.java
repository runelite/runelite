import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public class class119 {
   @ObfuscatedName("rq")
   protected static String field2013;
   @ObfuscatedName("s")
   Inflater field2014;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class119(int var1, int var2, int var3) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BB)V",
      garbageValue = "112"
   )
   public void method2424(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field2014 == null) {
            this.field2014 = new Inflater(true);
         }

         try {
            this.field2014.setInput(var1.payload, var1.offset + 10, var1.payload.length - (8 + var1.offset + 10));
            this.field2014.inflate(var2);
         } catch (Exception var4) {
            this.field2014.reset();
            throw new RuntimeException("");
         }

         this.field2014.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   public class119() {
      this(-1, 1000000, 1000000);
   }
}
