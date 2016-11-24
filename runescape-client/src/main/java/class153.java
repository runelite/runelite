import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
public class class153 {
   @ObfuscatedName("n")
   Inflater field2222;

   public class153() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class153(int var1, int var2, int var3) {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "64660173"
   )
   public void method2925(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[1 + var1.offset] == -117) {
         if(null == this.field2222) {
            this.field2222 = new Inflater(true);
         }

         try {
            this.field2222.setInput(var1.payload, 10 + var1.offset, var1.payload.length - (10 + var1.offset + 8));
            this.field2222.inflate(var2);
         } catch (Exception var4) {
            this.field2222.reset();
            throw new RuntimeException("");
         }

         this.field2222.reset();
      } else {
         throw new RuntimeException("");
      }
   }
}
