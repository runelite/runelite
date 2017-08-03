import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -751891915
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1585670247
   )
   @Export("y")
   int y;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2120502673
   )
   @Export("z")
   int z;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Len;",
      garbageValue = "420407124"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         IndexDataBase var3 = Sequence.skel_ref;
         IndexDataBase var4 = Sequence.skin_ref;
         boolean var5 = true;
         int[] var6 = var3.getChilds(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.getChild(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.getChild(var9, 0);
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
            Sequence.skeletons.put(var2, (long)var0);
         }

         return var2;
      }
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(Lcj;B)V",
      garbageValue = "-8"
   )
   static final void method2902(Actor var0) {
      int var1 = var0.field1235 - Client.gameCycle;
      int var2 = var0.field1204 * 128 + var0.field1216 * 64;
      int var3 = var0.field1233 * 128 + var0.field1216 * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field1247 = 0;
      var0.orientation = var0.field1208;
   }
}
