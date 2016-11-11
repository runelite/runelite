import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class138 {
   @ObfuscatedName("e")
   static Hashtable field2132 = new Hashtable(16);
   @ObfuscatedName("i")
   public static boolean field2133 = false;
   @ObfuscatedName("hx")
   @Export("localPlayer")
   static Player localPlayer;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "83"
   )
   static void method2915() {
      if(FrameMap.loadWorlds()) {
         class33.worldSelectShown = true;
      }

   }
}
