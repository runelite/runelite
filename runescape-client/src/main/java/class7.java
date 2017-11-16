import java.applet.Applet;
import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class7 {
   @ObfuscatedName("qq")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   static IndexFile field223;
   @ObfuscatedName("b")
   public static boolean field219;
   @ObfuscatedName("s")
   public static boolean field217;
   @ObfuscatedName("r")
   public static boolean field224;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   public static class11 field218;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   static CombatInfoList field220;
   @ObfuscatedName("h")
   @Export("cacheLocations")
   static String[] cacheLocations;

   static {
      field219 = false;
      field217 = false;
      field224 = false;
      field218 = class11.field251;
      field220 = new CombatInfoList();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "417530681"
   )
   public static void method37(Applet var0, String var1) {
      class56.field630 = var0;
      class56.field629 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;B)V",
      garbageValue = "87"
   )
   static void method36(File var0) {
      class158.field2156 = var0;
      if(!class158.field2156.exists()) {
         throw new RuntimeException("");
      } else {
         class158.field2162 = true;
      }
   }
}
