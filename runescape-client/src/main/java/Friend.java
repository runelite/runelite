import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1036410893
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("p")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1713075
   )
   @Export("world")
   int world;
   @ObfuscatedName("f")
   boolean field793;
   @ObfuscatedName("m")
   boolean field794;
   @ObfuscatedName("n")
   @Export("name")
   String name;

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-79"
   )
   static final void method1060() {
      Client.secretPacketBuffer1.putOpcode(163);
      Client.secretPacketBuffer1.putByte(0);
   }
}
