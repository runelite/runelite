import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
public class class54 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Lie;"
   )
   public static Area[] field662;
   @ObfuscatedName("ak")
   static java.awt.Font field657;
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   static IndexData field660;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = -998485645
   )
   static int field659;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "1376114429"
   )
   public static void method800(String var0, Throwable var1) {
      var1.printStackTrace();
   }
}
