import java.applet.Applet;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class57 {
   @ObfuscatedName("c")
   static Applet field652;
   @ObfuscatedName("i")
   public static String field646;
   @ObfuscatedName("p")
   static ScheduledExecutorService field654;
   @ObfuscatedName("e")
   @Export("floorMultiplier")
   static int[] floorMultiplier;
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("rssocket")
   static class169 rssocket;

   static {
      field652 = null;
      field646 = "";
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "20"
   )
   static int method858(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class95.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.size();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "822151177"
   )
   public static void method859() {
      KitDefinition.identKits.reset();
   }
}
