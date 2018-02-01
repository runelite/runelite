import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public final class class79 extends Node {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   static Deque field1208;
   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   @Export("scrollbarSprites")
   static IndexedSprite[] scrollbarSprites;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1711112115
   )
   int field1201;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2006788353
   )
   int field1210;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -17571629
   )
   int field1203;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -27425325
   )
   int field1205;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1454340491
   )
   int field1202;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1404027719
   )
   int field1206;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljv;"
   )
   ObjectComposition field1215;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 171239805
   )
   int field1204;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1492261489
   )
   int field1207;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   class114 field1209;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 82210439
   )
   int field1211;
   @ObfuscatedName("q")
   int[] field1212;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -817327517
   )
   int field1213;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   class114 field1214;

   static {
      field1208 = new Deque();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "100"
   )
   void method1741() {
      int var1 = this.field1207;
      ObjectComposition var2 = this.field1215.getImpostor();
      if(var2 != null) {
         this.field1207 = var2.ambientSoundId;
         this.field1204 = var2.int4 * 128;
         this.field1203 = var2.int5;
         this.field1211 = var2.int6;
         this.field1212 = var2.field3543;
      } else {
         this.field1207 = -1;
         this.field1204 = 0;
         this.field1203 = 0;
         this.field1211 = 0;
         this.field1212 = null;
      }

      if(var1 != this.field1207 && this.field1209 != null) {
         CombatInfoListHolder.field1251.method2082(this.field1209);
         this.field1209 = null;
      }

   }
}
