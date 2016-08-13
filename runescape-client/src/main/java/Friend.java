import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("g")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2121713069
   )
   @Export("world")
   int world;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1053575117
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("h")
   boolean field249;
   @ObfuscatedName("l")
   @Export("name")
   String name;
   @ObfuscatedName("s")
   boolean field252;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "1958455949"
   )
   public static void method207(class170 var0) {
      class56.field1232 = var0;
      class56.field1233 = class56.field1232.method3405(16);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-1538680373"
   )
   static final void method208(Actor var0) {
      int var1 = var0.field891 - Client.gameCycle;
      int var2 = var0.field873 * 128 + var0.field877 * 64;
      int var3 = var0.field877 * 64 + var0.field856 * 128;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field889 = 0;
      var0.field882 = var0.field884;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "109"
   )
   public static void method209() {
      Sequence.field1014.reset();
      Sequence.field1015.reset();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "-1124102472"
   )
   public static void method210(File var0) {
      class138.field2137 = var0;
      if(!class138.field2137.exists()) {
         throw new RuntimeException("");
      } else {
         class138.field2138 = true;
      }
   }
}
