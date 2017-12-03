import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
public enum class239 implements Enumerated {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3261(4, 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3256(2, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3257(3, 2),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3263(1, 3),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3259(5, 4),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3260(0, 5),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3262(6, 6),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   field3258(7, 7);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 741878133
   )
   public final int field3255;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1892953301
   )
   final int field3264;

   class239(int var3, int var4) {
      this.field3255 = var3;
      this.field3264 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1035813094"
   )
   public int rsOrdinal() {
      return this.field3264;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;I)V",
      garbageValue = "-1632245897"
   )
   public static void method4226(IndexDataBase var0) {
      Varbit.varbit_ref = var0;
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "([Lhz;IIIZI)V",
      garbageValue = "-1010498984"
   )
   static void method4227(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class89.method1666(var6, var2, var3, var4);
            class60.method985(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               GrandExchangeOffer.method102(var0, var6, var4);
            }
         }
      }

   }
}
