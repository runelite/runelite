import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class57 {
   @ObfuscatedName("pt")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   static Resampler field673;
   @ObfuscatedName("d")
   public static Applet field667;
   @ObfuscatedName("z")
   public static String field668;

   static {
      field667 = null;
      field668 = "";
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)Lly;",
      garbageValue = "-1101903591"
   )
   static SpritePixels method826(int var0, int var1, int var2) {
      class213 var3 = class35.field485;
      long var4 = (long)(var2 << 16 | var0 << 8 | var1);
      return (SpritePixels)var3.method4044(var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-72"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      Varbit var2 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = Varbit.varbit_ref.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.decode(new Buffer(var7));
         }

         Varbit.varbits.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class237.varpsMasks[var5 - var4];
      return class237.widgetSettings[var3] >> var4 & var6;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Lkg;",
      garbageValue = "-267826182"
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2069472990"
   )
   static final boolean method833(int var0, int var1) {
      ObjectComposition var2 = class169.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method5114(var1);
   }
}
