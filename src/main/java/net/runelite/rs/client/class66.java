package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bp")
public abstract class class66 extends class207 {
   @ObfuscatedName("w")
   volatile boolean field1251 = true;
   @ObfuscatedName("n")
   int field1252;
   @ObfuscatedName("y")
   class65 field1253;
   @ObfuscatedName("g")
   class66 field1254;

   @ObfuscatedName("h")
   protected abstract class66 vmethod3770();

   @ObfuscatedName("ah")
   int vmethod1491() {
      return 255;
   }

   @ObfuscatedName("eh")
   final void method1492(int[] var1, int var2, int var3) {
      if(this.field1251) {
         this.vmethod3784(var1, var2, var3);
      } else {
         this.vmethod3787(var3);
      }

   }

   @ObfuscatedName("s")
   protected abstract void vmethod3787(int var1);

   @ObfuscatedName("i")
   protected abstract int vmethod3772();

   @ObfuscatedName("a")
   protected abstract class66 vmethod3774();

   @ObfuscatedName("t")
   protected abstract void vmethod3784(int[] var1, int var2, int var3);
}
