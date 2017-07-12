import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public enum class91 implements RSEnum {
   @ObfuscatedName("i")
   field1442(0),
   @ObfuscatedName("w")
   field1440(1),
   @ObfuscatedName("a")
   field1439(2),
   @ObfuscatedName("t")
   field1441(3);

   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1279618521
   )
   final int field1443;
   @ObfuscatedName("be")
   static ModIcon field1445;
   @ObfuscatedName("cz")
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("ao")
   static Image field1448;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1204543302"
   )
   public int rsOrdinal() {
      return this.field1443;
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-71664062"
   )
   static void method1729(int var0, int var1, int var2, int var3) {
      Widget var4 = class202.method3650(var0, var1);
      if(var4 != null && var4.field2745 != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.field857 = var4.field2745;
         class14.method76(var5);
      }

      Client.field1084 = var3;
      Client.spellSelected = true;
      class208.field2598 = var0;
      Client.field1158 = var1;
      WorldMapType3.spellTargetFlags = var2;
      class88.method1714(var4);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   private class91(int var3) {
      this.field1443 = var3;
   }
}
