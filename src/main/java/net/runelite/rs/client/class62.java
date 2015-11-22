package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("be")
public class class62 extends class65 {
   @ObfuscatedName("l")
   int field1218;
   @ObfuscatedName("m")
   public byte[] field1219;
   @ObfuscatedName("f")
   public int field1220;
   @ObfuscatedName("j")
   public int field1221;
   @ObfuscatedName("u")
   public boolean field1222;

   class62(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.field1221 = var1;
      this.field1219 = var2;
      this.field1220 = var3;
      this.field1218 = var4;
      this.field1222 = var5;
   }

   @ObfuscatedName("j")
   public class62 method1320(class74 var1) {
      this.field1219 = var1.method1614(this.field1219);
      this.field1221 = var1.method1615(this.field1221);
      if(this.field1220 == this.field1218) {
         this.field1220 = this.field1218 = var1.method1616(this.field1220);
      } else {
         this.field1220 = var1.method1616(this.field1220);
         this.field1218 = var1.method1616(this.field1218);
         if(this.field1220 == this.field1218) {
            --this.field1220;
         }
      }

      return this;
   }

   class62(int var1, byte[] var2, int var3, int var4) {
      this.field1221 = var1;
      this.field1219 = var2;
      this.field1220 = var3;
      this.field1218 = var4;
   }
}
