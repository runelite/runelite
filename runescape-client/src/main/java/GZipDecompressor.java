import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
@Implements("GZipDecompressor")
public class GZipDecompressor {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -909875367
   )
   public static int field2420;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = 568418653
   )
   static int field2423;
   @ObfuscatedName("p")
   @Export("inflator")
   Inflater inflator;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   GZipDecompressor(int var1, int var2, int var3) {
   }

   public GZipDecompressor() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgj;[BI)V",
      garbageValue = "-1381429413"
   )
   @Export("decompress")
   public void decompress(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.inflator == null) {
            this.inflator = new Inflater(true);
         }

         try {
            this.inflator.setInput(var1.payload, var1.offset + 10, var1.payload.length - (var1.offset + 8 + 10));
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "97"
   )
   public static boolean method3340(int var0) {
      return var0 >= class232.field2912.field2903 && var0 <= class232.field2913.field2903;
   }
}
