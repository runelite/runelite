package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
public class class57 {
   @ObfuscatedName("n")
   int field1205;
   @ObfuscatedName("l")
   int[] field1206 = new int[2];
   @ObfuscatedName("h")
   int field1207;
   @ObfuscatedName("i")
   int field1208;
   @ObfuscatedName("f")
   int field1209;
   @ObfuscatedName("m")
   int field1210;
   @ObfuscatedName("a")
   int[] field1211 = new int[2];
   @ObfuscatedName("k")
   int field1212;
   @ObfuscatedName("o")
   int field1213;
   @ObfuscatedName("r")
   int field1214;
   @ObfuscatedName("j")
   int field1215 = 2;

   @ObfuscatedName("j")
   final void method1225(class118 var1) {
      this.field1210 = var1.method2453();
      this.field1208 = var1.method2458();
      this.field1209 = var1.method2458();
      this.method1236(var1);
   }

   @ObfuscatedName("a")
   final void method1227() {
      this.field1213 = 0;
      this.field1207 = 0;
      this.field1205 = 0;
      this.field1212 = 0;
      this.field1214 = 0;
   }

   @ObfuscatedName("i")
   final int method1228(int var1) {
      if(this.field1214 >= this.field1213) {
         this.field1212 = this.field1211[this.field1207++] << 15;
         if(this.field1207 >= this.field1215) {
            this.field1207 = this.field1215 - 1;
         }

         this.field1213 = (int)((double)this.field1206[this.field1207] / 65536.0D * (double)var1);
         if(this.field1213 > this.field1214) {
            this.field1205 = ((this.field1211[this.field1207] << 15) - this.field1212) / (this.field1213 - this.field1214);
         }
      }

      this.field1212 += this.field1205;
      ++this.field1214;
      return this.field1212 - this.field1205 >> 15;
   }

   class57() {
      this.field1206[0] = 0;
      this.field1206[1] = '\uffff';
      this.field1211[0] = 0;
      this.field1211[1] = '\uffff';
   }

   @ObfuscatedName("l")
   final void method1236(class118 var1) {
      this.field1215 = var1.method2453();
      this.field1206 = new int[this.field1215];
      this.field1211 = new int[this.field1215];

      for(int var2 = 0; var2 < this.field1215; ++var2) {
         this.field1206[var2] = var1.method2455();
         this.field1211[var2] = var1.method2455();
      }

   }
}
