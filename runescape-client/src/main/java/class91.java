import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class91 implements RSEnum {
   @ObfuscatedName("m")
   static final class91 field1403;
   @ObfuscatedName("p")
   static final class91 field1404;
   @ObfuscatedName("e")
   static final class91 field1405;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 2073367925
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;
   @ObfuscatedName("z")
   public static IndexDataBase field1409;
   @ObfuscatedName("t")
   static final class91 field1410;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1008401685
   )
   final int field1412;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;IB)V",
      garbageValue = "-53"
   )
   static void method1621(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class82 var5 = new class82();
      var5.field1306 = var0;
      var5.field1322 = var1 * 128;
      var5.field1310 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field1309 = (var6 + var1) * 128;
      var5.field1320 = (var2 + var7) * 128;
      var5.field1308 = var3.ambientSoundId;
      var5.field1311 = var3.field3466 * 128;
      var5.field1307 = var3.field3488;
      var5.field1315 = var3.field3442;
      var5.field1316 = var3.field3490;
      if(var3.impostorIds != null) {
         var5.field1319 = var3;
         var5.method1514();
      }

      class82.field1314.method3505(var5);
      if(var5.field1316 != null) {
         var5.field1317 = var5.field1307 + (int)(Math.random() * (double)(var5.field1315 - var5.field1307));
      }

   }

   static {
      field1404 = new class91(0);
      field1403 = new class91(1);
      field1405 = new class91(2);
      field1410 = new class91(3);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class91(int var1) {
      this.field1412 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int rsOrdinal() {
      return this.field1412;
   }
}
