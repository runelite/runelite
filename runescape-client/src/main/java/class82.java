import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public final class class82 extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -547576971
   )
   int field1322;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1592560977
   )
   int field1323;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -30282431
   )
   int field1324;
   @ObfuscatedName("n")
   static Deque field1325;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -660486487
   )
   int field1326;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1979363263
   )
   int field1327;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1727172199
   )
   int field1328;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1862667841
   )
   int field1329;
   @ObfuscatedName("h")
   class117 field1330;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1705554677
   )
   int field1331;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -302871997
   )
   int field1332;
   @ObfuscatedName("o")
   int[] field1333;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1691605909
   )
   int field1334;
   @ObfuscatedName("a")
   class117 field1335;
   @ObfuscatedName("y")
   ObjectComposition field1336;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -1657330943
   )
   public static int field1337;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;I)V",
      garbageValue = "-293782011"
   )
   public static void method1575(IndexDataBase var0, IndexDataBase var1) {
      NPCComposition.field3585 = var0;
      NPCComposition.field3559 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "987939478"
   )
   void method1576() {
      int var1 = this.field1329;
      ObjectComposition var2 = this.field1336.getImpostor();
      if(var2 != null) {
         this.field1329 = var2.ambientSoundId;
         this.field1328 = var2.field3487 * 128;
         this.field1331 = var2.field3488;
         this.field1332 = var2.field3489;
         this.field1333 = var2.field3479;
      } else {
         this.field1329 = -1;
         this.field1328 = 0;
         this.field1331 = 0;
         this.field1332 = 0;
         this.field1333 = null;
      }

      if(var1 != this.field1329 && this.field1330 != null) {
         WorldMapType0.field613.method1862(this.field1330);
         this.field1330 = null;
      }

   }

   static {
      field1325 = new Deque();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-30"
   )
   public static void method1583() {
      PlayerComposition.field2630.reset();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-424425459"
   )
   static void method1584(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      class234 var4 = (class234)class238.field3258.method3545(var2);
      if(var4 != null) {
         class238.field3253.method3474(var4);
      }
   }
}
