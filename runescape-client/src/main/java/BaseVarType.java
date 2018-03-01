import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("BaseVarType")
public enum BaseVarType implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   @Export("INTEGER")
   INTEGER(2, 0, Integer.class, new class2()),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   @Export("LONG")
   LONG(1, 1, Long.class, new class3()),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   @Export("STRING")
   STRING(0, 2, String.class, new class5());

   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = -170704821
   )
   static int field28;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   public static IndexDataBase field30;
   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "[Lly;"
   )
   @Export("mapMarkers")
   static SpritePixels[] mapMarkers;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2120883621
   )
   @Export("id2")
   final int id2;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 157238381
   )
   @Export("id")
   final int id;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Ld;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.id2 = var3;
      this.id = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "846888120"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1051939516"
   )
   static final void method14(boolean var0) {
      if(var0) {
         Client.field1040 = class90.field1363?class158.field2141:class158.field2143;
      } else {
         Client.field1040 = class55.preferences.preferences.containsKey(Integer.valueOf(NameableContainer.method5436(class90.username)))?class158.field2140:class158.field2145;
      }

   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-46"
   )
   static void method12() {
      Client.field899.method2082(class31.method285(ClientPacket.field2427, Client.field899.field1470));
      Client.field927 = 0;
   }
}
