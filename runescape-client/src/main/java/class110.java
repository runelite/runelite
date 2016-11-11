import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public abstract class class110 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1441304069
   )
   public int field1932;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1807361779
   )
   public int field1933;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 284829507
   )
   public int field1934;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2055005935
   )
   public int field1935;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-215812910"
   )
   public abstract boolean vmethod2413(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1385670777"
   )
   static void method2416(int var0, String var1, String var2) {
      ChatLineBuffer.addChatMessage(var0, var1, var2, (String)null);
   }
}
