import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public final class class29 extends class84 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1490281367
   )
   int field685;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1373096569
   )
   int field686;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1558973499
   )
   int field687;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -750230793
   )
   int field688;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 477353393
   )
   int field689;
   @ObfuscatedName("y")
   class42 field690;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -116789355
   )
   int field691 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1856807181
   )
   int field692 = 0;
   @ObfuscatedName("n")
   boolean field693 = false;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 784156809
   )
   int field696;
   @ObfuscatedName("az")
   static class78[] field700;
   @ObfuscatedName("bo")
   static class167 field701;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2130233286"
   )
   public static void method657() {
      class136 var0 = class136.field2108;
      synchronized(class136.field2108) {
         ++class136.field2117;
         class136.field2101 = class136.field2116;
         class136.field2110 = 0;
         int var1;
         if(class136.field2109 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class136.field2087[var1] = false;
            }

            class136.field2109 = class136.field2113;
         } else {
            while(class136.field2113 != class136.field2109) {
               var1 = class136.field2107[class136.field2113];
               class136.field2113 = class136.field2113 + 1 & 127;
               if(var1 < 0) {
                  class136.field2087[~var1] = false;
               } else {
                  if(!class136.field2087[var1] && class136.field2110 < class136.field2112.length - 1) {
                     class136.field2112[++class136.field2110 - 1] = var1;
                  }

                  class136.field2087[var1] = true;
               }
            }
         }

         class136.field2116 = class136.field2111;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-111185536"
   )
   final void method658(int var1) {
      if(!this.field693) {
         this.field692 += var1;

         while(this.field692 > this.field690.field990[this.field691]) {
            this.field692 -= this.field690.field990[this.field691];
            ++this.field691;
            if(this.field691 >= this.field690.field988.length) {
               this.field693 = true;
               break;
            }
         }

      }
   }

   class29(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field686 = var1;
      this.field696 = var2;
      this.field687 = var3;
      this.field688 = var4;
      this.field689 = var5;
      this.field685 = var7 + var6;
      int var8 = class24.method595(this.field686).field1012;
      if(var8 != -1) {
         this.field693 = false;
         this.field690 = class134.method2875(var8);
      } else {
         this.field693 = true;
      }

   }

   @ObfuscatedName("f")
   protected final class104 vmethod1919() {
      class43 var1 = class24.method595(this.field686);
      class104 var2;
      if(!this.field693) {
         var2 = var1.method909(this.field691);
      } else {
         var2 = var1.method909(-1);
      }

      return var2 == null?null:var2;
   }
}
