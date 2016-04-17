import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("WidgetNode")
public class class3 extends class208 {
   @ObfuscatedName("gf")
   static class173 field65;
   @ObfuscatedName("d")
   boolean field66 = false;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 893204161
   )
   @Export("baseY")
   static int field67;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = -1520383361
   )
   static int field69;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1547999453
   )
   @Export("id")
   int field70;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -724614925
   )
   int field72;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-679128719"
   )
   static final void method48() {
      class11.method187();
      class41.field978.method3843();
      class24.method673();
      class7.method141();
      class39.field912.method3843();
      class39.field889.method3843();
      class4.method53();
      class42.field990.method3843();
      class42.field991.method3843();
      class37.method839();
      class47.field1073.method3843();
      class14.method201();
      class179.field2931.method3843();
      class173.field2752.method3843();
      class173.field2764.method3843();
      class173.field2754.method3843();
      class173.field2872.method3843();
      ((class95)class91.field1575).method2259();
      class22.field607.method3843();
      class45.field1057.method3408();
      class99.field1682.method3408();
      class181.field2943.method3408();
      class114.field1967.method3408();
      class8.field156.method3408();
      class38.field884.method3408();
      class19.field279.method3408();
      class103.field1768.method3408();
      class135.field2082.method3408();
      class48.field1089.method3408();
      class36.field814.method3408();
      class211.field3137.method3408();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2101078362"
   )
   static void method49(int var0) {
      if(client.field554 != var0) {
         if(0 == client.field554) {
            class143.method3110();
         }

         if(20 == var0 || var0 == 40 || 45 == var0) {
            client.field328 = 0;
            client.field329 = 0;
            client.field392 = 0;
         }

         if(var0 != 20 && var0 != 40 && null != class171.field2735) {
            class171.field2735.method3095();
            class171.field2735 = null;
         }

         if(client.field554 == 25) {
            client.field346 = 0;
            client.field350 = 0;
            client.field521 = 1;
            client.field333 = 0;
            client.field353 = 1;
         }

         if(5 != var0 && 10 != var0) {
            if(var0 == 20) {
               class155.method3263(class158.field2585, class48.field1089, class103.field1768, true, client.field554 == 11?4:0);
            } else if(11 == var0) {
               class155.method3263(class158.field2585, class48.field1089, class103.field1768, false, 4);
            } else {
               class166.method3355();
            }
         } else {
            class155.method3263(class158.field2585, class48.field1089, class103.field1768, true, 0);
         }

         client.field554 = var0;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-2058736541"
   )
   public static char method50(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(199 == var0) {
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

         if(221 == var0) {
            return 'Y';
         }

         if(223 == var0) {
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

         if(253 == var0 || var0 == 255) {
            return 'y';
         }
      }

      if(338 == var0) {
         return 'O';
      } else if(339 == var0) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }
}
