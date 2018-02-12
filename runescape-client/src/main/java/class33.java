import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class33 {
   @ObfuscatedName("ly")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   @Export("mouseWheel")
   static MouseWheel mouseWheel;
   @ObfuscatedName("oc")
   @ObfuscatedSignature(
      signature = "Lcq;"
   )
   static class101 field450;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 76742857
   )
   static int field445;
   @ObfuscatedName("z")
   public static short[] field449;
   @ObfuscatedName("c")
   public static boolean field446;
   @ObfuscatedName("s")
   String field447;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1732991473
   )
   int field442;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1194404457
   )
   int field443;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   Size field444;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILv;)V"
   )
   class33(String var1, int var2, int var3, Size var4) {
      this.field447 = var1;
      this.field442 = var2;
      this.field443 = var3;
      this.field444 = var4;
   }

   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "(B)Llr;",
      garbageValue = "-26"
   )
   static RenderOverview method340() {
      return class175.renderOverview;
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Lhs;I)V",
      garbageValue = "-2086247440"
   )
   static void method341(Widget var0) {
      if(var0.loopCycle == Client.field1028) {
         Client.field1029[var0.boundsIndex] = true;
      }

   }
}
