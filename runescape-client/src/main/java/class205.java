import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class205 extends Node {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   class202 field2560;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -134393741
   )
   int field2567;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   class207 field2558;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   class105 field2559;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   class115 field2570;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 754040557
   )
   int field2566;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1021019747
   )
   int field2563;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -803986209
   )
   int field2565;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -636565271
   )
   int field2571;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2133223503
   )
   int field2575;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 875521523
   )
   int field2557;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 443188993
   )
   int field2561;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1308746899
   )
   int field2576;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1434724169
   )
   int field2577;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 531285241
   )
   int field2574;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1388879807
   )
   int field2573;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 139802759
   )
   int field2568;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2047609969
   )
   int field2564;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1497020539
   )
   int field2569;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 110591895
   )
   int field2562;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -730432243
   )
   int field2572;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1383467450"
   )
   void method3927() {
      this.field2558 = null;
      this.field2559 = null;
      this.field2560 = null;
      this.field2570 = null;
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-1995059556"
   )
   static final void method3930(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class132.method2677(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1203 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(Ljl;IIII)V",
      garbageValue = "1559510815"
   )
   static void method3929(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1154 < 50 && Client.field1114 != 0) {
         if(var0.field3613 != null && var1 < var0.field3613.length) {
            int var4 = var0.field3613[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1155[Client.field1154] = var5;
               Client.field1156[Client.field1154] = var6;
               Client.field1157[Client.field1154] = 0;
               Client.audioEffects[Client.field1154] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1158[Client.field1154] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field1154;
            }
         }
      }
   }
}
