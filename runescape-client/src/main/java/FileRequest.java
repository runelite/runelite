import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1545614053
   )
   @Export("idxCount")
   static int idxCount;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("index")
   IndexData index;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 197372007
   )
   @Export("crc")
   int crc;
   @ObfuscatedName("m")
   @Export("padding")
   byte padding;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lje;",
      garbageValue = "322661552"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lbs;",
      garbageValue = "-1976527130"
   )
   static World method4498() {
      return World.field1185 < World.worldCount?class31.worldList[++World.field1185 - 1]:null;
   }
}
