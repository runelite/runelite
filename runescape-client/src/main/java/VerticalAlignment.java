import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ja")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   field3438(1, 0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   field3436(2, 1),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   field3437(0, 2);

   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1643823619
   )
   @Export("value")
   public final int value;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -571010739
   )
   final int field3439;

   VerticalAlignment(int var3, int var4) {
      this.value = var3;
      this.field3439 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "19795"
   )
   public int rsOrdinal() {
      return this.field3439;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "104"
   )
   static void method4829(String var0, String var1, String var2) {
      class90.loginMessage1 = var0;
      class90.loginMessage2 = var1;
      class90.loginMessage3 = var2;
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "613899797"
   )
   static void method4830(int var0, int var1, int var2, int var3) {
      Widget var4 = class44.getWidgetChild(var0, var1);
      if(var4 != null && var4.onTargetEnterListener != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.source = var4;
         var5.params = var4.onTargetEnterListener;
         class71.method1203(var5);
      }

      Client.field1009 = var3;
      Client.spellSelected = true;
      BoundingBox3D.field261 = var0;
      Client.field1008 = var1;
      class49.field605 = var2;
      TotalQuantityComparator.method100(var4);
   }
}
