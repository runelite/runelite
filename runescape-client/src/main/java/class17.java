import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("Friend")
public class class17 {
   @ObfuscatedName("g")
   @Export("previousName")
   String field246;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2121713069
   )
   @Export("world")
   int field247;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1053575117
   )
   @Export("rank")
   int field248;
   @ObfuscatedName("h")
   boolean field249;
   @ObfuscatedName("l")
   @Export("name")
   String field250;
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
      signature = "(Lclass39;I)V",
      garbageValue = "-1538680373"
   )
   static final void method208(class39 var0) {
      int var1 = var0.field891 - client.field305;
      int var2 = var0.field873 * 128 + var0.field877 * 64;
      int var3 = var0.field877 * 64 + var0.field856 * 128;
      var0.field875 += (var2 - var0.field875) / var1;
      var0.field832 += (var3 - var0.field832) / var1;
      var0.field889 = 0;
      var0.field882 = var0.field884;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "109"
   )
   public static void method209() {
      class44.field1014.method3910();
      class44.field1015.method3910();
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
