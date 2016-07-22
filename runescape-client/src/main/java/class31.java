import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public final class class31 extends class88 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -753023895
   )
   int field706 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1963619983
   )
   int field707;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 770707067
   )
   int field708;
   @ObfuscatedName("j")
   class44 field709;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1686285753
   )
   int field710;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 237561985
   )
   int field711;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1236494345
   )
   int field712;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1319278535
   )
   int field713 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 504985457
   )
   int field714;
   @ObfuscatedName("k")
   boolean field715 = false;
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = -117456771
   )
   @Export("cameraPitch")
   static int field717;
   @ObfuscatedName("nz")
   static class77 field718;

   class31(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field714 = var1;
      this.field712 = var2;
      this.field708 = var3;
      this.field710 = var4;
      this.field711 = var5;
      this.field707 = var6 + var7;
      int var8 = class175.method3442(this.field714).field1028;
      if(var8 != -1) {
         this.field715 = false;
         this.field709 = class28.method646(var8);
      } else {
         this.field715 = true;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "16587717"
   )
   final void method667(int var1) {
      if(!this.field715) {
         this.field706 += var1;

         while(this.field706 > this.field709.field1011[this.field713]) {
            this.field706 -= this.field709.field1011[this.field713];
            ++this.field713;
            if(this.field713 >= this.field709.field1009.length) {
               this.field715 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "1"
   )
   public static int method668(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-990594109"
   )
   protected final class108 vmethod1992() {
      class45 var1 = class175.method3442(this.field714);
      class108 var2;
      if(!this.field715) {
         var2 = var1.method942(this.field713);
      } else {
         var2 = var1.method942(-1);
      }

      return null == var2?null:var2;
   }
}
