package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bu")
public class class57 {
   @ObfuscatedName("u")
   int field1184;
   @ObfuscatedName("s")
   int field1185;
   @ObfuscatedName("m")
   int[] field1186 = new int[2];
   @ObfuscatedName("l")
   int field1187;
   @ObfuscatedName("h")
   int field1188;
   @ObfuscatedName("a")
   int field1189;
   @ObfuscatedName("j")
   int field1190 = 2;
   @ObfuscatedName("i")
   int field1191;
   @ObfuscatedName("t")
   int field1192;
   @ObfuscatedName("k")
   int field1193;
   @ObfuscatedName("f")
   int[] field1194 = new int[2];

   @ObfuscatedName("m")
   final void method1270(class118 var1) {
      this.field1190 = var1.method2536();
      this.field1186 = new int[this.field1190];
      this.field1194 = new int[this.field1190];

      for(int var2 = 0; var2 < this.field1190; ++var2) {
         this.field1186[var2] = var1.method2538();
         this.field1194[var2] = var1.method2538();
      }

   }

   @ObfuscatedName("j")
   final void method1271(class118 var1) {
      this.field1189 = var1.method2536();
      this.field1187 = var1.method2541();
      this.field1184 = var1.method2541();
      this.method1270(var1);
   }

   @ObfuscatedName("f")
   final void method1273() {
      this.field1188 = 0;
      this.field1191 = 0;
      this.field1192 = 0;
      this.field1193 = 0;
      this.field1185 = 0;
   }

   class57() {
      this.field1186[0] = 0;
      this.field1186[1] = '\uffff';
      this.field1194[0] = 0;
      this.field1194[1] = '\uffff';
   }

   @ObfuscatedName("l")
   final int method1278(int var1) {
      if(this.field1185 >= this.field1188) {
         this.field1193 = this.field1194[this.field1191++] << 15;
         if(this.field1191 >= this.field1190) {
            this.field1191 = this.field1190 - 1;
         }

         this.field1188 = (int)((double)this.field1186[this.field1191] / 65536.0D * (double)var1);
         if(this.field1188 > this.field1185) {
            this.field1192 = ((this.field1194[this.field1191] << 15) - this.field1193) / (this.field1188 - this.field1185);
         }
      }

      this.field1193 += this.field1192;
      ++this.field1185;
      return this.field1193 - this.field1192 >> 15;
   }
}
