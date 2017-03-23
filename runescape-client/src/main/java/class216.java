import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class216 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 53611899
   )
   public final int field3181;
   @ObfuscatedName("i")
   public static final class216 field3182 = new class216(1);
   @ObfuscatedName("u")
   static final class216 field3183 = new class216(2);
   @ObfuscatedName("f")
   static final class216 field3184 = new class216(0);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-89"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class47.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method930(var0, var1, var2, var3);
      class47.field949.method2389(var5, (long)var5.id);
      class47.field952.method2535(var5);
      Client.field495 = Client.field561;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class216(int var1) {
      this.field3181 = var1;
   }
}
