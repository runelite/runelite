import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
@Implements("GZipDecompressor")
public class GZipDecompressor {
   @ObfuscatedName("r")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("b")
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lfs;[BI)V",
      garbageValue = "109995211"
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

   @ObfuscatedName("b")
   public static final void method3129(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            class164.method3084(var0 - 1L);
            class164.method3084(1L);
         } else {
            class164.method3084(var0);
         }

      }
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "-78"
   )
   static String method3130(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(SoundTask.sessionToken != null) {
         var3 = "/p=" + SoundTask.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class25.field339 + var3 + "/";
   }
}
