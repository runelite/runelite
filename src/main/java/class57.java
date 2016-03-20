import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bv")
public class class57 {
   @ObfuscatedName("j")
   int field1196;
   @ObfuscatedName("r")
   int[] field1197 = new int[2];
   @ObfuscatedName("g")
   int field1198;
   @ObfuscatedName("s")
   int field1199;
   @ObfuscatedName("e")
   int field1200;
   @ObfuscatedName("y")
   int field1201;
   @ObfuscatedName("m")
   int field1202;
   @ObfuscatedName("a")
   int field1203 = 2;
   @ObfuscatedName("n")
   int field1204;
   @ObfuscatedName("l")
   int field1205;
   @ObfuscatedName("f")
   int[] field1206 = new int[2];

   @ObfuscatedName("r")
   final void method1245(class118 var1) {
      this.field1203 = var1.method2579();
      this.field1197 = new int[this.field1203];
      this.field1206 = new int[this.field1203];

      for(int var2 = 0; var2 < this.field1203; ++var2) {
         this.field1197[var2] = var1.method2514();
         this.field1206[var2] = var1.method2514();
      }

   }

   @ObfuscatedName("f")
   final void method1246() {
      this.field1202 = 0;
      this.field1196 = 0;
      this.field1204 = 0;
      this.field1205 = 0;
      this.field1201 = 0;
   }

   @ObfuscatedName("s")
   final int method1247(int var1) {
      if(this.field1201 >= this.field1202) {
         this.field1205 = this.field1206[this.field1196++] << 15;
         if(this.field1196 >= this.field1203) {
            this.field1196 = this.field1203 - 1;
         }

         this.field1202 = (int)((double)this.field1197[this.field1196] / 65536.0D * (double)var1);
         if(this.field1202 > this.field1201) {
            this.field1204 = ((this.field1206[this.field1196] << 15) - this.field1205) / (this.field1202 - this.field1201);
         }
      }

      this.field1205 += this.field1204;
      ++this.field1201;
      return this.field1205 - this.field1204 >> 15;
   }

   @ObfuscatedName("a")
   final void method1256(class118 var1) {
      this.field1198 = var1.method2579();
      this.field1199 = var1.method2517();
      this.field1200 = var1.method2517();
      this.method1245(var1);
   }

   class57() {
      this.field1197[0] = 0;
      this.field1197[1] = '\uffff';
      this.field1206[0] = 0;
      this.field1206[1] = '\uffff';
   }
}
