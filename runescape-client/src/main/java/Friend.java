import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("l")
   static int[] field758;
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   static IndexData field759;
   @ObfuscatedName("b")
   @Export("name")
   String name;
   @ObfuscatedName("s")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1240668085
   )
   @Export("world")
   int world;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 545283453
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("x")
   boolean field755;
   @ObfuscatedName("f")
   boolean field757;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-54"
   )
   static synchronized byte[] method1020(int var0) {
      return class181.method3406(var0, false);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1335582404"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class96.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class96.field1425.put(var5, (long)var5.id);
      class96.field1424.method3709(var5);
      Client.chatCycle = Client.cycleCntr;
   }
}
