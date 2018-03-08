import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("MapLabel")
public class MapLabel {
   @ObfuscatedName("r")
   static int[] field448;
   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "Lfy;"
   )
   static class169 field445;
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = 804499775
   )
   static int field446;
   @ObfuscatedName("t")
   @Export("text")
   String text;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1279582711
   )
   int field441;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1020440047
   )
   int field442;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   @Export("fontSize")
   Size fontSize;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILh;)V"
   )
   MapLabel(String var1, int var2, int var3, Size var4) {
      this.text = var1;
      this.field441 = var2;
      this.field442 = var3;
      this.fontSize = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljw;",
      garbageValue = "725430008"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.SpotAnimationDefinition_indexCache.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljc;IZB)Let;",
      garbageValue = "39"
   )
   public static Frames method383(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.getChilds(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.getChild(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9;
            if(var3) {
               var9 = var1.getChild(0, var8);
            } else {
               var9 = var1.getChild(var8, 0);
            }

            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1433282140"
   )
   static final void method384() {
      Region.regionLowMemory = false;
      Client.lowMemory = false;
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lju;",
      garbageValue = "-1014929614"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class167.dat2File != null) {
         var4 = new IndexFile(var0, class167.dat2File, WorldMapManager.idxFiles[var0], 1000000);
      }

      return new IndexData(var4, PacketNode.indexStore255, var0, var1, var2, var3);
   }
}
