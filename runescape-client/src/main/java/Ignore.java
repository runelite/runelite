import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("dk")
   static byte[][] field126;
   @ObfuscatedName("r")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("x")
   @Export("name")
   String name;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 1250211579
   )
   @Export("cameraX")
   static int cameraX;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "1521729514"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field996.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         var1 = FaceNormal.method1938(Sequence.field1003, Sequence.field1008, var0, false);
         if(null != var1) {
            Sequence.field996.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
