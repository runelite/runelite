import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class146 {
   @ObfuscatedName("i")
   public static IndexDataBase field2037;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 280560221
   )
   static int field2038;
   @ObfuscatedName("f")
   Inflater field2039;
   @ObfuscatedName("lv")
   static class216 field2041;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class146(int var1, int var2, int var3) {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BB)V",
      garbageValue = "-97"
   )
   public void method2803(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field2039 == null) {
            this.field2039 = new Inflater(true);
         }

         try {
            this.field2039.setInput(var1.payload, var1.offset + 10, var1.payload.length - (var1.offset + 10 + 8));
            this.field2039.inflate(var2);
         } catch (Exception var4) {
            this.field2039.reset();
            throw new RuntimeException("");
         }

         this.field2039.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   public class146() {
      this(-1, 1000000, 1000000);
   }
}
