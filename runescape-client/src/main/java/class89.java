import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public enum class89 implements RSEnum {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   field1404(0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   field1401(1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   field1402(2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   field1403(3);

   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 630487617
   )
   final int field1400;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field1406;
   @ObfuscatedName("l")
   @Export("userHome")
   public static String userHome;

   class89(int var3) {
      this.field1400 = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-41"
   )
   public int rsOrdinal() {
      return this.field1400;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1775914437"
   )
   public static void method1784() {
      VarPlayerType.varplayers.reset();
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1953634746"
   )
   static void method1783() {
      if(Client.spellSelected) {
         Widget var0 = class5.method18(class25.field372, Client.field1069);
         if(var0 != null && var0.field2750 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.field846 = var0.field2750;
            CollisionData.method3128(var1);
         }

         Client.spellSelected = false;
         class25.method172(var0);
      }
   }
}
