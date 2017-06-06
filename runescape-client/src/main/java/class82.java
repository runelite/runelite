import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public final class class82 extends Node {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1663151903
   )
   int field1340;
   @ObfuscatedName("f")
   class117 field1341;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 551925621
   )
   int field1342;
   @ObfuscatedName("o")
   int[] field1343;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 357190219
   )
   int field1344;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1689985153
   )
   int field1345;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1029200173
   )
   int field1346;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1070049931
   )
   int field1347;
   @ObfuscatedName("i")
   static Deque field1348;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 764616761
   )
   int field1349;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -914531703
   )
   int field1350;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 666484841
   )
   int field1351;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1513635475
   )
   int field1352;
   @ObfuscatedName("q")
   class117 field1353;
   @ObfuscatedName("j")
   ObjectComposition field1354;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "553401466"
   )
   void method1597() {
      int var1 = this.field1347;
      ObjectComposition var2 = this.field1354.getImpostor();
      if(var2 != null) {
         this.field1347 = var2.ambientSoundId;
         this.field1346 = var2.field3477 * 128;
         this.field1340 = var2.field3478;
         this.field1350 = var2.field3459;
         this.field1343 = var2.field3480;
      } else {
         this.field1347 = -1;
         this.field1346 = 0;
         this.field1340 = 0;
         this.field1350 = 0;
         this.field1343 = null;
      }

      if(var1 != this.field1347 && this.field1341 != null) {
         class158.field2288.method1871(this.field1341);
         this.field1341 = null;
      }

   }

   static {
      field1348 = new Deque();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "-89"
   )
   public static char method1599(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }
}
