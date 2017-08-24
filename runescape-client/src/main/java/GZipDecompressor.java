import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
@Implements("GZipDecompressor")
public class GZipDecompressor {
   @ObfuscatedName("i")
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;[BB)V",
      garbageValue = "115"
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lhx;",
      garbageValue = "1667299355"
   )
   public static Widget method3177(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class268.widgets[var1] == null || class268.widgets[var1][var2] == null) {
         boolean var3 = class13.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return class268.widgets[var1][var2];
   }
}
