import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public final class class25 extends Node {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 724365331
   )
   int field572;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -642279425
   )
   int field573;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1366580351
   )
   int field574;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -772918891
   )
   int field575;
   @ObfuscatedName("jd")
   @ObfuscatedGetter(
      intValue = -807957027
   )
   static int field576;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 126014903
   )
   int field577;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1041229065
   )
   int field578;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1043931723
   )
   int field579;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -574214715
   )
   int field580;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 813225051
   )
   int field581 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1906098897
   )
   int field582 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1505487477
   )
   int field583;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -248019319
   )
   int field584;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "23142"
   )
   static int method605(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2405((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1722781758"
   )
   static void method606(int var0, int var1) {
      class38 var2 = class2.field19;
      KitDefinition.menuAction(var2.field798, var2.field791, var2.field792, var2.field793, var2.field790, var2.field790, var0, var1);
      class2.field19 = null;
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "458491402"
   )
   static final void method607(String var0) {
      if(!var0.equals("")) {
         Client.field330.method3234(208);
         Client.field330.method2975(RSCanvas.method2132(var0));
         Client.field330.method2981(var0);
      }
   }
}
