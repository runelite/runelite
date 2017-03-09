import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class146 {
   @ObfuscatedName("ai")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("x")
   Inflater field2021;

   public class146() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "1481917384"
   )
   public void method2767(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(null == this.field2021) {
            this.field2021 = new Inflater(true);
         }

         try {
            this.field2021.setInput(var1.payload, var1.offset + 10, var1.payload.length - (10 + var1.offset + 8));
            this.field2021.inflate(var2);
         } catch (Exception var4) {
            this.field2021.reset();
            throw new RuntimeException("");
         }

         this.field2021.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class146(int var1, int var2, int var3) {
   }
}
