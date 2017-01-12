import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 267060817
   )
   int field182;
   @ObfuscatedName("i")
   boolean field183 = false;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1347774781
   )
   @Export("id")
   int id;
   @ObfuscatedName("m")
   static Widget field187;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-44"
   )
   static final int method184(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var3 * (var0 & 16711935) + var2 * (var1 & 16711935) & -16711936) + (var2 * (var1 & '\uff00') + (var0 & '\uff00') * var3 & 16711680) >> 8;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1751576562"
   )
   public static void method185(boolean var0) {
      if(var0 != Buffer.isMembersWorld) {
         class137.method2460();
         Buffer.isMembersWorld = var0;
      }

   }
}
