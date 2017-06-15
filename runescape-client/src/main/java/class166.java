import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class166 {
   @ObfuscatedName("p")
   Inflater field2342;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "13"
   )
   public static synchronized long method2970() {
      long var0 = System.currentTimeMillis();
      if(var0 < class175.field2426) {
         class175.field2424 += class175.field2426 - var0;
      }

      class175.field2426 = var0;
      return var0 + class175.field2424;
   }

   public class166() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BB)V",
      garbageValue = "-50"
   )
   public void method2971(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field2342 == null) {
            this.field2342 = new Inflater(true);
         }

         try {
            this.field2342.setInput(var1.payload, var1.offset + 10, var1.payload.length - (var1.offset + 10 + 8));
            this.field2342.inflate(var2);
         } catch (Exception var4) {
            this.field2342.reset();
            throw new RuntimeException("");
         }

         this.field2342.reset();
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
}
