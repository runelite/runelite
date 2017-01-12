import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class148 {
   @ObfuscatedName("hb")
   @Export("localPlayer")
   static Player localPlayer;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1002206526"
   )
   public static int method2740(String var0) {
      return var0.length() + 1;
   }

   static {
      new HashMap();
   }
}
