import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public class class119 {
   @ObfuscatedName("k")
   Inflater field2040;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 2137123747
   )
   static int field2041;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1469198197"
   )
   public static void method2516() {
      class45.field1029.reset();
      class45.field1032.reset();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BB)V",
      garbageValue = "-68"
   )
   public void method2518(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[1 + var1.offset] == -117) {
         if(null == this.field2040) {
            this.field2040 = new Inflater(true);
         }

         try {
            this.field2040.setInput(var1.payload, var1.offset + 10, var1.payload.length - (10 + var1.offset + 8));
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

   public class119() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class119(int var1, int var2, int var3) {
   }
}
