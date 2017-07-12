import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
@Implements("GZipDecompressor")
public class GZipDecompressor {
   @ObfuscatedName("i")
   @Export("inflator")
   Inflater inflator;

   public GZipDecompressor() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   GZipDecompressor(int var1, int var2, int var3) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "1867657898"
   )
   @Export("decompress")
   public void decompress(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.inflator == null) {
            this.inflator = new Inflater(true);
         }

         try {
            this.inflator.setInput(var1.payload, var1.offset + 10, var1.payload.length - (var1.offset + 10 + 8));
            this.inflator.inflate(var2);
         } catch (Exception var4) {
            this.inflator.reset();
            throw new RuntimeException("");
         }

         this.inflator.reset();
      } else {
         throw new RuntimeException("");
      }
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
