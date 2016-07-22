import java.awt.Canvas;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public class class112 {
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = -1878710125
   )
   protected static int field1962;
   @ObfuscatedName("qe")
   @Export("canvas")
   public static Canvas field1965;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-2117427639"
   )
   public static char method2483(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   static {
      new HashMap();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass125;B)V",
      garbageValue = "-56"
   )
   static final void method2486(class125 var0) {
      var0.method2799();
      int var1 = client.field551;
      class2 var2 = class114.field2010 = client.field393[var1] = new class2();
      var2.field46 = var1;
      int var3 = var0.method2813(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.field885[0] = var5 - class39.field838;
      var2.field864 = (var2.field885[0] << 7) + (var2.method14() << 6);
      var2.field886[0] = var6 - class13.field184;
      var2.field831 = (var2.field886[0] << 7) + (var2.method14() << 6);
      class51.field1119 = var2.field57 = var4;
      if(class34.field775[var1] != null) {
         var2.method12(class34.field775[var1]);
      }

      class34.field777 = 0;
      class34.field780[++class34.field777 - 1] = var1;
      class34.field772[var1] = 0;
      class34.field770 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method2813(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class34.field779[var7] = var11 + (var10 << 14) + (var9 << 28);
            class34.field778[var7] = 0;
            class34.field781[var7] = -1;
            class34.field774[++class34.field770 - 1] = var7;
            class34.field772[var7] = 0;
         }
      }

      var0.method2800();
   }
}
