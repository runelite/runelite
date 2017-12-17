import java.util.zip.Inflater;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
@Implements("GZipDecompressor")
public class GZipDecompressor {
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -219460773
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("a")
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgh;[BB)V",
      garbageValue = "4"
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lir;",
      garbageValue = "-1948930203"
   )
   public static CombatInfo2 method3201(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field3443.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field3452.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.read(new Buffer(var2));
         }

         CombatInfo2.field3443.put(var1, (long)var0);
         return var1;
      }
   }
}
