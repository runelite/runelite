import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public final class class31 extends class88 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1928564591
   )
   int field727;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 248463213
   )
   int field728;
   @ObfuscatedName("b")
   class44 field729;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1019555447
   )
   int field730;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -34064669
   )
   int field731;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 458832769
   )
   int field732;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1702808437
   )
   int field733 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1696422811
   )
   int field734 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1126622475
   )
   int field735;
   @ObfuscatedName("p")
   boolean field736 = false;
   @ObfuscatedName("nb")
   static class58 field742;
   @ObfuscatedName("nn")
   static class59 field744;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-447930905"
   )
   final void method671(int var1) {
      if(!this.field736) {
         this.field733 += var1;

         while(this.field733 > this.field729.field1025[this.field734]) {
            this.field733 -= this.field729.field1025[this.field734];
            ++this.field734;
            if(this.field734 >= this.field729.field1023.length) {
               this.field736 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-2017557153"
   )
   protected final class108 vmethod1999() {
      class45 var1 = class151.method3217(this.field727);
      class108 var2;
      if(!this.field736) {
         var2 = var1.method964(this.field734);
      } else {
         var2 = var1.method964(-1);
      }

      return null == var2?null:var2;
   }

   class31(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field727 = var1;
      this.field735 = var2;
      this.field730 = var3;
      this.field731 = var4;
      this.field732 = var5;
      this.field728 = var6 + var7;
      int var8 = class151.method3217(this.field727).field1047;
      if(var8 != -1) {
         this.field736 = false;
         this.field729 = class13.method153(var8);
      } else {
         this.field736 = true;
      }

   }
}
