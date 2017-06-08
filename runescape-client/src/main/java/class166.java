import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class166 {
   @ObfuscatedName("n")
   Inflater field2336;
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 1828598015
   )
   static int field2338;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "-1845130072"
   )
   public void method3080(Buffer var1, byte[] var2) {
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

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "502257989"
   )
   static final void method3082(class119 var0) {
      var0.field1726 = false;
      if(var0.field1723 != null) {
         var0.field1723.field1757 = 0;
      }

      for(class119 var1 = var0.vmethod3906(); var1 != null; var1 = var0.vmethod3907()) {
         method3082(var1);
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[Lclass230;",
      garbageValue = "-2137366118"
   )
   public static class230[] method3083() {
      return new class230[]{class230.field3181, class230.field3173, class230.field3171, class230.field3175, class230.field3172, class230.field3180};
   }

   public class166() {
      this(-1, 1000000, 1000000);
   }
}
