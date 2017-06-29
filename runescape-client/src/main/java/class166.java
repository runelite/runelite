import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class166 {
   @ObfuscatedName("i")
   Inflater field2336;

   public class166() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "1867657898"
   )
   public void method3072(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field2336 == null) {
            this.field2336 = new Inflater(true);
         }

         try {
            this.field2336.setInput(var1.payload, var1.offset + 10, var1.payload.length - (var1.offset + 10 + 8));
            this.field2336.inflate(var2);
         } catch (Exception var4) {
            this.field2336.reset();
            throw new RuntimeException("");
         }

         this.field2336.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class166(int var1, int var2, int var3) {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "14"
   )
   static int method3076(int var0) {
      MessageNode var1 = (MessageNode)class98.field1546.method3478((long)var0);
      return var1 == null?-1:(var1.previous == class98.field1548.field2492?-1:((MessageNode)var1.previous).id);
   }
}
