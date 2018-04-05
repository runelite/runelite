import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public final class class80 extends Node {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   static Deque field1263;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 360811061
   )
   int field1259;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 794311511
   )
   int field1265;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 229666575
   )
   int field1261;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1827160685
   )
   int field1269;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 383160553
   )
   int field1262;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1210249333
   )
   int field1273;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1479930023
   )
   int field1264;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   class115 field1266;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 154851345
   )
   int field1267;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1149899709
   )
   int field1268;
   @ObfuscatedName("a")
   int[] field1274;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2100466331
   )
   int field1270;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lda;"
   )
   class115 field1271;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   ObjectComposition field1272;

   static {
      field1263 = new Deque();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-923316257"
   )
   void method1794() {
      int var1 = this.field1264;
      ObjectComposition var2 = this.field1272.getImpostor();
      if(var2 != null) {
         this.field1264 = var2.ambientSoundId;
         this.field1273 = var2.int4 * 128;
         this.field1267 = var2.int5;
         this.field1268 = var2.int6;
         this.field1274 = var2.field3614;
      } else {
         this.field1264 = -1;
         this.field1273 = 0;
         this.field1267 = 0;
         this.field1268 = 0;
         this.field1274 = null;
      }

      if(var1 != this.field1264 && this.field1266 != null) {
         MouseInput.field727.method2060(this.field1266);
         this.field1266 = null;
      }

   }
}
