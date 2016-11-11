import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
public class class71 {
   @ObfuscatedName("h")
   int field1333;
   @ObfuscatedName("i")
   int field1334;
   @ObfuscatedName("e")
   int[] field1335;
   @ObfuscatedName("g")
   int[] field1336;

   class71() {
      class73.method1567(16);
      this.field1334 = class73.method1566() != 0?class73.method1567(4) + 1:1;
      if(class73.method1566() != 0) {
         class73.method1567(8);
      }

      class73.method1567(2);
      if(this.field1334 > 1) {
         this.field1333 = class73.method1567(4);
      }

      this.field1335 = new int[this.field1334];
      this.field1336 = new int[this.field1334];

      for(int var1 = 0; var1 < this.field1334; ++var1) {
         class73.method1567(8);
         this.field1335[var1] = class73.method1567(8);
         this.field1336[var1] = class73.method1567(8);
      }

   }
}
