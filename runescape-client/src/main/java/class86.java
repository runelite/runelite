import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class86 {
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("lq")
   @ObfuscatedGetter(
      intValue = -459182297
   )
   static int field1308;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lct;",
      garbageValue = "-1267028974"
   )
   static Script method1892(int var0) {
      Script var1 = (Script)Script.field1439.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class1.indexScripts.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = class61.newScript(var2);
            Script.field1439.put(var1, (long)var0);
            return var1;
         }
      }
   }
}
