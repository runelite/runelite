import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
@Implements("GZipDecompressor")
public class GZipDecompressor {
   @ObfuscatedName("d")
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfw;[BI)V",
      garbageValue = "-2134893540"
   )
   @Export("decompress")
   public void decompress(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && -117 == var1.payload[var1.offset + 1]) {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Lhn;",
      garbageValue = "-284293022"
   )
   public static Widget method3133(int var0, int var1) {
      Widget var2 = WallObject.method2901(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1908979599"
   )
   static void method3131() {
      if(Client.spellSelected) {
         Widget var0 = method3133(class224.field2825, Client.field1039);
         if(var0 != null && var0.field2721 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.field818 = var0.field2721;
            Ignore.method1126(var1);
         }

         Client.spellSelected = false;
         class48.method732(var0);
      }
   }
}
