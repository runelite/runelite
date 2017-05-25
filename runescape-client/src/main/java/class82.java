import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public final class class82 extends Node {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -754955229
   )
   int field1290;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 196316837
   )
   int field1291;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1194796837
   )
   int field1292;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -99368885
   )
   int field1293;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1655569311
   )
   int field1295;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 87558139
   )
   int field1296;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1811637643
   )
   int field1297;
   @ObfuscatedName("l")
   class117 field1298;
   @ObfuscatedName("i")
   static Deque field1299;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1069108353
   )
   int field1300;
   @ObfuscatedName("b")
   int[] field1301;
   @ObfuscatedName("o")
   class117 field1303;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -381097133
   )
   int field1304;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -829469155
   )
   int field1305;
   @ObfuscatedName("r")
   ObjectComposition field1307;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-401500229"
   )
   static String method1610(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2115812454"
   )
   void method1611() {
      int var1 = this.field1297;
      ObjectComposition var2 = this.field1307.getImpostor();
      if(var2 != null) {
         this.field1297 = var2.ambientSoundId;
         this.field1296 = var2.field3474 * -1065075840;
         this.field1292 = var2.field3469;
         this.field1290 = var2.field3476;
         this.field1301 = var2.field3459;
      } else {
         this.field1297 = -1;
         this.field1296 = 0;
         this.field1292 = 0;
         this.field1290 = 0;
         this.field1301 = null;
      }

      if(var1 != this.field1297 && this.field1298 != null) {
         class164.field2291.method1910(this.field1298);
         this.field1298 = null;
      }

   }

   static {
      field1299 = new Deque();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-337108626"
   )
   public static int method1615(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "12"
   )
   static final void method1620(int var0) {
      class134.field1987[++class134.field1986 - 1] = var0;
   }
}
