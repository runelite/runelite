import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class222 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field2815;
   @ObfuscatedName("o")
   public static final boolean[] field2813;
   @ObfuscatedName("i")
   public static int[] field2817;
   @ObfuscatedName("fq")
   @Export("landRegionFielIds")
   static int[] landRegionFielIds;
   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;

   static {
      field2813 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2817 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2817[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "246811441"
   )
   public static void method3977() {
      Spotanim.spotanims.reset();
      Spotanim.field3300.reset();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "2042206922"
   )
   public static void method3978(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class56.field675.startsWith("win") && !var3) {
            class149.method2837(var0, 0, "openjs");
            return;
         }

         if(class56.field675.startsWith("mac")) {
            class149.method2837(var0, 1, var2);
            return;
         }

         class149.method2837(var0, 2, "openjs");
      } else {
         class149.method2837(var0, 3, "openjs");
      }

   }
}
