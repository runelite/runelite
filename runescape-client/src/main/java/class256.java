import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
public class class256 {
   @ObfuscatedName("as")
   static FontMetrics field3432;
   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   static IndexedSprite[] field3431;
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = 1734894779
   )
   @Export("menuWidth")
   static int menuWidth;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2013974165"
   )
   public static void method4598() {
      class289.field3811 = new CombatInfoList();
   }
}
