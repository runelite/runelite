package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bj")
public class class62 extends class65 {
   @ObfuscatedName("i")
   int field1238;
   @ObfuscatedName("l")
   public byte[] field1239;
   @ObfuscatedName("a")
   public int field1240;
   @ObfuscatedName("j")
   public int field1241;
   @ObfuscatedName("f")
   public boolean field1242;

   @ObfuscatedName("j")
   public class62 method1280(class74 var1) {
      this.field1239 = var1.method1583(this.field1239);
      this.field1241 = var1.method1586(this.field1241);
      if(this.field1240 == this.field1238) {
         this.field1240 = this.field1238 = var1.method1589(this.field1240);
      } else {
         this.field1240 = var1.method1589(this.field1240);
         this.field1238 = var1.method1589(this.field1238);
         if(this.field1240 == this.field1238) {
            --this.field1240;
         }
      }

      return this;
   }

   class62(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1241 = var1;
      this.field1239 = var2;
      this.field1240 = var3;
      this.field1238 = var4;
      this.field1242 = var5;
   }

   class62(int var1, byte[] var2, int var3, int var4) {
      this.field1241 = var1;
      this.field1239 = var2;
      this.field1240 = var3;
      this.field1238 = var4;
   }
}
