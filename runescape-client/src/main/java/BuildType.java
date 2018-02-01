import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("RC")
   public static final BuildType RC;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("WIP")
   public static final BuildType WIP;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("LIVE")
   public static final BuildType LIVE;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("BUILD_LIVE")
   public static final BuildType BUILD_LIVE;
   @ObfuscatedName("j")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 649607495
   )
   @Export("ordinal")
   public final int ordinal;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.ordinal = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;I)V",
      garbageValue = "28837339"
   )
   public static void method4353(IndexDataBase var0) {
      class175.varplayer_ref = var0;
      VarPlayerType.field3351 = class175.varplayer_ref.fileCount(16);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Leq;",
      garbageValue = "-67"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-241160630"
   )
   static final void method4352(String var0) {
      class63.method1054(var0 + " is already on your ignore list");
   }
}
