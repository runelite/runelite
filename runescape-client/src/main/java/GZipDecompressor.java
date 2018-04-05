import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
@Implements("GZipDecompressor")
public class GZipDecompressor {
   @ObfuscatedName("l")
   static int[][][] field2520;
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   @Export("loginType")
   static JagexLoginType loginType;
   @ObfuscatedName("o")
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgc;[BI)V",
      garbageValue = "929743285"
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

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(Lin;B)Z",
      garbageValue = "70"
   )
   static final boolean method3461(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field915 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1132.method4379(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1132.method4406(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1132.method4386(false);
         }

         if(var1 == 325) {
            Client.field1132.method4386(true);
         }

         if(var1 == 326) {
            PacketNode var4 = WorldMapRectangle.method280(ClientPacket.field2435, Client.field957.field1484);
            Client.field1132.method4398(var4.packetBuffer);
            Client.field957.method2052(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
