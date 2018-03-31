import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = -2105974075
   )
   static int field3441;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("varplayer_ref")
   public static IndexDataBase varplayer_ref;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 855580013
   )
   public static int field3445;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("varplayers")
   public static NodeCache varplayers;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -308780597
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   public VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-2129205886"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.decode(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "1841418787"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lkv;",
      garbageValue = "-1375974826"
   )
   @Export("getOverlayDefinition")
   public static Overlay getOverlayDefinition(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }
}
