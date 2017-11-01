import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
@Implements("GZipDecompressor")
public class GZipDecompressor {
   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -2072355635
   )
   static int field2325;
   @ObfuscatedName("w")
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfz;[BI)V",
      garbageValue = "-762882727"
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

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "([Lhj;Lhj;ZI)V",
      garbageValue = "-2118962620"
   )
   static void method3159(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class43.method614(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class43.method614(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         class261.method4814(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
