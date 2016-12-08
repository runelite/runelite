import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class104 {
   @ObfuscatedName("h")
   static File field1685;
   @ObfuscatedName("z")
   public static class72 field1687 = null;
   @ObfuscatedName("y")
   public static class72 field1688 = null;
   @ObfuscatedName("j")
   public static class72 field1689 = null;
   @ObfuscatedName("f")
   public static class72[] field1690;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LWorld;B)V",
      garbageValue = "66"
   )
   @Export("selectWorld")
   static void selectWorld(World var0) {
      if(var0.method596() != Client.isMembers) {
         Client.isMembers = var0.method596();
         class11.method149(var0.method596());
      }

      class139.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      MessageNode.field237 = Client.field428 == 0?'ꩊ':var0.id + '鱀';
      class38.field812 = Client.field428 == 0?443:var0.id + '썐';
      class206.field3087 = MessageNode.field237;
   }
}
