package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bd")
public class class68 {
   @ObfuscatedName("l")
   int[] field1267;
   @ObfuscatedName("m")
   int field1268;
   @ObfuscatedName("f")
   int[] field1269;
   @ObfuscatedName("j")
   int field1270;

   class68() {
      class70.method1556(16);
      this.field1270 = class70.method1554() != 0?class70.method1556(4) + 1:1;
      if(class70.method1554() != 0) {
         class70.method1556(8);
      }

      class70.method1556(2);
      if(this.field1270 > 1) {
         this.field1268 = class70.method1556(4);
      }

      this.field1269 = new int[this.field1270];
      this.field1267 = new int[this.field1270];

      for(int var1 = 0; var1 < this.field1270; ++var1) {
         class70.method1556(8);
         this.field1269[var1] = class70.method1556(8);
         this.field1267[var1] = class70.method1556(8);
      }

   }
}
