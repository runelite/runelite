import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class181 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;II)Lclass184;",
      garbageValue = "-276240581"
   )
   static class184 method3631(class170 var0, int var1) {
      byte[] var2 = var0.method3402(var1);
      return var2 == null?null:new class184(var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "1637661745"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field1015.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = DecorativeObject.method2255(Sequence.field1012, Sequence.field1019, var0, false);
         if(null != var1) {
            Sequence.field1015.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
