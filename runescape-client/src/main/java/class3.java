import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
final class class3 implements class0 {
   @ObfuscatedName("pe")
   @ObfuscatedGetter(
      intValue = -732256429
   )
   static int field17;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -4726496030610099675L
   )
   @Export("currentTimeMsLast")
   static long currentTimeMsLast;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-79"
   )
   static final void method10(String var0) {
      class243.method4617("Please remove " + var0 + " from your friend list first");
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1953333688"
   )
   static void method9(int var0, int var1, int var2, int var3) {
      Widget var4 = class197.getWidgetChild(var0, var1);
      if(var4 != null && var4.field2916 != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.objs = var4.field2916;
         GameCanvas.method800(var5);
      }

      Client.field1007 = var3;
      Client.spellSelected = true;
      WidgetNode.field785 = var0;
      Client.field1042 = var1;
      class243.field2960 = var2;
      class171.method3363(var4);
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "221233004"
   )
   public static void method8(int var0, int var1, int var2, boolean var3) {
      PacketNode var4 = class31.method285(ClientPacket.field2448, Client.field899.field1470);
      var4.packetBuffer.method3626(var3?Client.field932:0);
      var4.packetBuffer.method3596(var2);
      var4.packetBuffer.putShort(var1);
      var4.packetBuffer.method3746(var0);
      Client.field899.method2082(var4);
   }
}
