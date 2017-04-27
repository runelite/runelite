import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class137 {
   class137() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "-457726988"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3088.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         IndexDataBase var3 = Sequence.field3085;
         IndexDataBase var4 = Sequence.field3086;
         boolean var5 = true;
         int[] var6 = var3.method3304(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.method3301(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.method3301(var9, 0);
               if(var10 == null) {
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

         if(var2 != null) {
            Sequence.field3088.put(var2, (long)var0);
         }

         return var2;
      }
   }
}
