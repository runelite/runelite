import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public final class class81 extends Node {
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = 2003116581
   )
   static int field1236;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   static Deque field1240;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -583134879
   )
   int field1245;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   ObjectComposition field1250;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1132030621
   )
   int field1239;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1404062169
   )
   int field1252;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 495716695
   )
   int field1248;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1729505865
   )
   int field1242;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 474016253
   )
   int field1241;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1429095151
   )
   int field1238;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 553894837
   )
   int field1243;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   class116 field1244;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 83387307
   )
   int field1246;
   @ObfuscatedName("a")
   int[] field1247;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 36451137
   )
   int field1237;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   class116 field1249;

   static {
      field1240 = new Deque();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method1576() {
      int var1 = this.field1243;
      ObjectComposition var2 = this.field1250.getImpostor();
      if(var2 != null) {
         this.field1243 = var2.ambientSoundId;
         this.field1238 = var2.field3531 * 128;
         this.field1245 = var2.field3503;
         this.field1246 = var2.field3533;
         this.field1247 = var2.field3532;
      } else {
         this.field1243 = -1;
         this.field1238 = 0;
         this.field1245 = 0;
         this.field1246 = 0;
         this.field1247 = null;
      }

      if(var1 != this.field1243 && this.field1244 != null) {
         Client.field1087.method1880(this.field1244);
         this.field1244 = null;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "93372242"
   )
   public static boolean method1588(int var0) {
      return (var0 & 1) != 0;
   }
}
