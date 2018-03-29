import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("FileRequest")
public class FileRequest extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("index")
   IndexData index;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1970862263
   )
   @Export("crc")
   int crc;
   @ObfuscatedName("o")
   @Export("padding")
   byte padding;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Ljj;",
      garbageValue = "406579834"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class252.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isHollow) {
            var1.clipType = 0;
            var1.blocksProjectile = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljm;B)V",
      garbageValue = "-83"
   )
   public static void method4545(IndexDataBase var0, IndexDataBase var1) {
      class33.field441 = var0;
      class316.field3919 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Ljb;",
      garbageValue = "106"
   )
   public static VarPlayerType method4547(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }
}
