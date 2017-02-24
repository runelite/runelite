import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class47 {
   @ObfuscatedName("h")
   static final class136 field948 = new class136();
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 870521533
   )
   static int field949 = 0;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -429631243
   )
   protected static int field950;
   @ObfuscatedName("d")
   static final class121 field951 = new class121(1024);
   @ObfuscatedName("o")
   public static short[][] field952;
   @ObfuscatedName("q")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();

   class47() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "1048729356"
   )
   static void method965(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class195.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field642 = 0;
            var0.actionAnimationDisable = var2;
            var0.field677 = 0;
         }

         if(var3 == 2) {
            var0.field677 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class195.getAnimation(var1).forcedPriority >= class195.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field642 = 0;
         var0.actionAnimationDisable = var2;
         var0.field677 = 0;
         var0.field682 = var0.field673;
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-56505470"
   )
   static void method966(int var0) {
      Client.field566 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      WidgetNode.method193();
      if(Client.gameState >= 25) {
         class8.method96();
      }

      GameEngine.field1783 = true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "2001810939"
   )
   public static int method967(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "2136816329"
   )
   public static int method968(CharSequence var0, int var1) {
      return class13.method169(var0, var1, true);
   }
}
