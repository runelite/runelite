import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1225516605
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("bx")
   @Export("sessionToken")
   static String sessionToken;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1716430231"
   )
   public abstract int vmethod3025(int var1, int var2);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-120"
   )
   public abstract void vmethod3029();
}
