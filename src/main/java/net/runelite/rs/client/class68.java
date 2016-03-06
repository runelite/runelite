package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bz")
public class class68 {
   @ObfuscatedName("j")
   int field1287;
   @ObfuscatedName("l")
   int field1288;
   @ObfuscatedName("a")
   int[] field1289;
   @ObfuscatedName("i")
   int[] field1290;

   class68() {
      class70.method1547(16);
      this.field1287 = class70.method1525() != 0?class70.method1547(4) + 1:1;
      if(class70.method1525() != 0) {
         class70.method1547(8);
      }

      class70.method1547(2);
      if(this.field1287 > 1) {
         this.field1288 = class70.method1547(4);
      }

      this.field1289 = new int[this.field1287];
      this.field1290 = new int[this.field1287];

      for(int var1 = 0; var1 < this.field1287; ++var1) {
         class70.method1547(8);
         this.field1289[var1] = class70.method1547(8);
         this.field1290[var1] = class70.method1547(8);
      }

   }
}
