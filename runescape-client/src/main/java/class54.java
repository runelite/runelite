import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class54 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("underlay_ref")
   public static IndexDataBase underlay_ref;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public static IndexDataBase field638;
   @ObfuscatedName("p")
   public static short[] field635;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field636;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "154378202"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class81.addChatMessage(var0, var1, var2, (String)null);
   }
}
