import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public final class class29 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 79360867
   )
   int field423;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 513385365
   )
   int field424;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 638670775
   )
   int field426;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1444240161
   )
   int field428;
   @ObfuscatedName("oj")
   static byte field429;
   // $FF: synthetic field
   final class41 this$0;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1065690112"
   )
   public static int method228(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "2"
   )
   static final void method229(class119 var0) {
      var0.field1732 = false;
      if(var0.field1734 != null) {
         var0.field1734.field1766 = 0;
      }

      for(class119 var1 = var0.vmethod3858(); var1 != null; var1 = var0.vmethod3886()) {
         method229(var1);
      }

   }

   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1243899989"
   )
   public static boolean method230() {
      return class203.field2514 != 0?true:class203.field2511.method3689();
   }
}
