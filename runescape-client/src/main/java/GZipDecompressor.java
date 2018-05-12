import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
@Implements("GZipDecompressor")
public class GZipDecompressor {
   @ObfuscatedName("w")
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;[BI)V",
      garbageValue = "1499837314"
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

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "1"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3179 != 0 && var3 > IndexDataBase.field3179) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 >= 0 && (IndexDataBase.field3179 == 0 || var6 <= IndexDataBase.field3179)) {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class176.Bzip2Decompressor_decompress(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }
}
