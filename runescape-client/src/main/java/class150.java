import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class150 {
   @ObfuscatedName("eo")
   static SpritePixels[] field2053;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)LFrames;",
      garbageValue = "53"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3060.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         class182 var3 = Sequence.field3066;
         class182 var4 = Sequence.field3058;
         boolean var5 = true;
         int[] var6 = var3.method3191(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3237(var0, var6[var7]);
            if(null == var8) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3237(var9, 0);
               if(null == var10) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(null != var2) {
            Sequence.field3060.put(var2, (long)var0);
         }

         return var2;
      }
   }
}
