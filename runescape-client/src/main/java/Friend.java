import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = -659250787
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1854251907
   )
   @Export("world")
   int world;
   @ObfuscatedName("v")
   boolean field805;
   @ObfuscatedName("e")
   boolean field801;
   @ObfuscatedName("a")
   @Export("name")
   String name;
   @ObfuscatedName("j")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 206292303
   )
   @Export("rank")
   int rank;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIIZI)V",
      garbageValue = "-1354685471"
   )
   public static void method1083(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class203.field2501 = 1;
      class203.field2502 = var0;
      class203.field2503 = var1;
      MilliTimer.field2204 = var2;
      class203.field2504 = var3;
      class203.field2505 = var4;
      class73.field861 = 10000;
   }
}
