import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 226227957
   )
   @Export("level")
   int level;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 505925079
   )
   @Export("type")
   int type;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1543670839
   )
   @Export("x")
   int x;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1791100097
   )
   @Export("y")
   int y;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 668811263
   )
   int field870;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 158853083
   )
   int field871;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1182445815
   )
   int field872;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1023279323
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1500162581
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -895946247
   )
   int field875;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1278571041
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1231655143
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "122"
   )
   public static void method1578(int var0) {
      if(class217.field2486 != 0) {
         class21.field185 = var0;
      } else {
         class217.field2485.method4302(var0);
      }

   }
}
