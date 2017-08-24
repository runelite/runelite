import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class36 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   static final class36 field514;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   static final class36 field521;
   @ObfuscatedName("fs")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -258813337
   )
   final int field513;

   static {
      field521 = new class36(0);
      field514 = new class36(1);
   }

   class36(int var1) {
      this.field513 = var1;
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "953021340"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class24.method202(var0, var1, var2, var3, var4, var5, false);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lim;",
      garbageValue = "790678824"
   )
   public static VarPlayerType method520(int var0) {
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
