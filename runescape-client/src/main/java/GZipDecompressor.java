import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("GZipDecompressor")
public class GZipDecompressor {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[[Liz;"
   )
   @Export("widgets")
   public static Widget[][] widgets;
   @ObfuscatedName("o")
   static int[] field2501;
   @ObfuscatedName("g")
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgg;[BB)V",
      garbageValue = "-19"
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "993066626"
   )
   public static boolean method3535(int var0) {
      return (var0 & 1) != 0;
   }
}
