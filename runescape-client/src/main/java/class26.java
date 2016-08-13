import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class26 extends Node {
   @ObfuscatedName("e")
   class205 field647 = new class205();
   @ObfuscatedName("a")
   static int[] field649;
   @ObfuscatedName("r")
   class49 field655;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IB)I",
      garbageValue = "113"
   )
   public static int method616(CharSequence var0, int var1) {
      return class5.method91(var0, var1, true);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1340246204"
   )
   void method618(int var1, int var2, int var3, int var4) {
      class20 var5 = null;
      int var6 = 0;

      for(class20 var7 = (class20)this.field647.method4011(); null != var7; var7 = (class20)this.field647.method4013()) {
         ++var6;
         if(var7.field583 == var1) {
            var7.method571(var1, var2, var3, var4);
            return;
         }

         if(var7.field583 <= var1) {
            var5 = var7;
         }
      }

      if(null == var5) {
         if(var6 < 4) {
            this.field647.method4009(new class20(var1, var2, var3, var4));
         }
      } else {
         class205.method4010(new class20(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.field647.method4011().unlink();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-84"
   )
   boolean method619() {
      return this.field647.method4017();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "112"
   )
   static int method623(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3936((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LWorld;",
      garbageValue = "1475239927"
   )
   static World method625() {
      return World.field664 < World.field663?World.worldList[++World.field664 - 1]:null;
   }

   class26(class49 var1) {
      this.field655 = var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)LModIcon;",
      garbageValue = "-1549186505"
   )
   static ModIcon method626(class170 var0, int var1, int var2) {
      if(!class4.method49(var0, var1, var2)) {
         return null;
      } else {
         ModIcon var3 = new ModIcon();
         var3.width = class79.field1454;
         var3.originalHeight = class79.field1456;
         var3.offsetX = class79.field1457[0];
         var3.offsetY = class180.field2962[0];
         var3.originalWidth = class192.field3106[0];
         var3.height = class79.field1458[0];
         var3.palette = class79.field1459;
         var3.pixels = class145.field2236[0];
         ItemComposition.method1182();
         return var3;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass20;",
      garbageValue = "-1874798932"
   )
   class20 method627(int var1) {
      class20 var2 = (class20)this.field647.method4011();
      if(var2 != null && var2.field583 <= var1) {
         for(class20 var3 = (class20)this.field647.method4013(); null != var3 && var3.field583 <= var1; var3 = (class20)this.field647.method4013()) {
            var2.unlink();
            var2 = var3;
         }

         if(var2.field577 + var2.field583 + this.field655.field1108 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1019760893"
   )
   static final void method628(String var0) {
      if(null != class4.clanMembers) {
         Client.field337.method2903(103);
         Client.field337.method2783(class54.method1165(var0));
         Client.field337.method2703(var0);
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "489785583"
   )
   static final void method629(Actor var0, int var1) {
      class35.method756(var0.x, var0.y, var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1471193617"
   )
   public static void method630() {
      class49.field1100.reset();
      class49.field1115.reset();
   }
}
