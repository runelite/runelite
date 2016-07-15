import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public final class class92 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 494100369
   )
   int field1616;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 487880901
   )
   int field1617;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -865247777
   )
   int field1618;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1578517163
   )
   int field1619;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1492511097
   )
   int field1620;
   @ObfuscatedName("a")
   boolean field1621 = true;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -429676377
   )
   int field1622;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1981938061"
   )
   static int method2178(int var0) {
      class29 var1 = (class29)class11.field191.get(Integer.valueOf(var0));
      return null == var1?0:var1.method654();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-278267735"
   )
   @Export("setGameState")
   static void method2179(int var0) {
      if(var0 != client.field301) {
         if(client.field301 == 0) {
            class124.method2851();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            client.field420 = 0;
            client.field565 = 0;
            client.field328 = 0;
         }

         if(var0 != 20 && var0 != 40 && class13.field219 != null) {
            class13.field219.method3088();
            class13.field219 = null;
         }

         if(client.field301 == 25) {
            client.field352 = 0;
            client.field348 = 0;
            client.field364 = 1;
            client.field350 = 0;
            client.field351 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class147.method3138(class158.field2346, class192.field3097, class230.field3263, true, client.field301 == 11?4:0);
            } else if(var0 == 11) {
               class147.method3138(class158.field2346, class192.field3097, class230.field3263, false, 4);
            } else {
               class12.method145();
            }
         } else {
            class147.method3138(class158.field2346, class192.field3097, class230.field3263, true, 0);
         }

         client.field301 = var0;
      }
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class92(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1618 = var1;
      this.field1616 = var2;
      this.field1620 = var3;
      this.field1619 = var4;
      this.field1617 = var5;
      this.field1622 = var6;
      this.field1621 = var7;
   }
}
