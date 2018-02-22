import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public final class class79 extends Node {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   static Deque field1210;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 1478482759
   )
   @Export("port1")
   static int port1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2113914309
   )
   int field1205;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1411312789
   )
   int field1202;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -141911479
   )
   int field1203;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1689768271
   )
   int field1204;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -817162809
   )
   int field1208;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1225852661
   )
   int field1206;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1754595149
   )
   int field1207;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   class114 field1201;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1774612885
   )
   int field1209;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 309702709
   )
   int field1212;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljb;"
   )
   ObjectComposition field1214;
   @ObfuscatedName("d")
   int[] field1211;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1240512903
   )
   int field1216;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   class114 field1213;

   static {
      field1210 = new Deque();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "104"
   )
   void method1750() {
      int var1 = this.field1207;
      ObjectComposition var2 = this.field1214.getImpostor();
      if(var2 != null) {
         this.field1207 = var2.ambientSoundId;
         this.field1206 = var2.int4 * 128;
         this.field1209 = var2.int5;
         this.field1212 = var2.int6;
         this.field1211 = var2.field3565;
      } else {
         this.field1207 = -1;
         this.field1206 = 0;
         this.field1209 = 0;
         this.field1212 = 0;
         this.field1211 = null;
      }

      if(var1 != this.field1207 && this.field1201 != null) {
         KeyFocusListener.field583.method2069(this.field1201);
         this.field1201 = null;
      }

   }
}
