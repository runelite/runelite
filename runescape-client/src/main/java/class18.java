import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
final class class18 implements Comparator {
   @ObfuscatedName("dy")
   @Export("host")
   static String host;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -586331345
   )
   static int field322;
   @ObfuscatedName("dt")
   @ObfuscatedGetter(
      longValue = -996997973095046729L
   )
   static long field320;
   @ObfuscatedName("y")
   static int[] field323;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;B)I",
      garbageValue = "78"
   )
   int method127(class14 var1, class14 var2) {
      return var1.method79().compareTo(var2.method79());
   }

   public int compare(Object var1, Object var2) {
      return this.method127((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "166859284"
   )
   public static void method138() {
      class286.field3795 = null;
      class31.offsetsY = null;
      class286.field3797 = null;
      class90.field1405 = null;
      class286.field3796 = null;
      class177.spritePixels = null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2105464580"
   )
   public static void method128() {
      VarPlayerType.varplayers.reset();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1956054707"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class98.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method1842(var0, var1, var2, var3);
      class98.field1520.method3501(var5, (long)var5.id);
      class98.field1526.method3674(var5);
      Client.field910 = Client.field1045;
   }
}
