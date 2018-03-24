import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("e")
   public static int[] field1202;
   @ObfuscatedName("x")
   static ScheduledExecutorService field1203;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1966409045
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1088857431
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2107264557
   )
   @Export("health")
   int health;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 559187821
   )
   @Export("int2")
   int int2;

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "59"
   )
   @Export("set")
   void set(int var1, int var2, int var3, int var4) {
      this.cycle = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.int2 = var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Ljl;",
      garbageValue = "1090921143"
   )
   public static class279 method1671(int var0) {
      class279 var1 = (class279)class279.field3555.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class279.field3557.getConfigData(34, var0);
         var1 = new class279();
         if(var2 != null) {
            var1.method4914(new Buffer(var2));
         }

         var1.method4913();
         class279.field3555.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljc;IIIZI)V",
      garbageValue = "2046730207"
   )
   public static void method1668(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class229.field2674 = 1;
      class229.field2672 = var0;
      class171.field2199 = var1;
      class229.field2676 = var2;
      class229.field2677 = var3;
      class85.field1294 = var4;
      class2.field13 = 10000;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "-2078182693"
   )
   static int method1670(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         class5.intStackSize -= 2;
         Client.field1052 = (short)class81.intStack[class5.intStackSize];
         if(Client.field1052 <= 0) {
            Client.field1052 = 256;
         }

         Client.field1097 = (short)class81.intStack[class5.intStackSize + 1];
         if(Client.field1097 <= 0) {
            Client.field1097 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class5.intStackSize -= 2;
         Client.field922 = (short)class81.intStack[class5.intStackSize];
         if(Client.field922 <= 0) {
            Client.field922 = 256;
         }

         Client.field1099 = (short)class81.intStack[class5.intStackSize + 1];
         if(Client.field1099 <= 0) {
            Client.field1099 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class5.intStackSize -= 4;
         Client.field1100 = (short)class81.intStack[class5.intStackSize];
         if(Client.field1100 <= 0) {
            Client.field1100 = 1;
         }

         Client.field1101 = (short)class81.intStack[class5.intStackSize + 1];
         if(Client.field1101 <= 0) {
            Client.field1101 = 32767;
         } else if(Client.field1101 < Client.field1100) {
            Client.field1101 = Client.field1100;
         }

         Client.field1102 = (short)class81.intStack[class5.intStackSize + 2];
         if(Client.field1102 <= 0) {
            Client.field1102 = 1;
         }

         Client.field1103 = (short)class81.intStack[class5.intStackSize + 3];
         if(Client.field1103 <= 0) {
            Client.field1103 = 32767;
         } else if(Client.field1103 < Client.field1102) {
            Client.field1103 = Client.field1102;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field1061 != null) {
            class33.method381(0, 0, Client.field1061.width, Client.field1061.height, false);
            class81.intStack[++class5.intStackSize - 1] = Client.viewportWidth;
            class81.intStack[++class5.intStackSize - 1] = Client.viewportHeight;
         } else {
            class81.intStack[++class5.intStackSize - 1] = -1;
            class81.intStack[++class5.intStackSize - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class81.intStack[++class5.intStackSize - 1] = Client.field922;
         class81.intStack[++class5.intStackSize - 1] = Client.field1099;
         return 1;
      } else if(var0 == 6205) {
         class81.intStack[++class5.intStackSize - 1] = Client.field1052;
         class81.intStack[++class5.intStackSize - 1] = Client.field1097;
         return 1;
      } else {
         return 2;
      }
   }
}
